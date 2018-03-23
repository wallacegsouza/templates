package ${pkg}.controller;

import com.yahoo.elide.Elide;
import com.yahoo.elide.ElideResponse;
import com.yahoo.elide.audit.Logger;
import com.yahoo.elide.audit.Slf4jLogger;
import com.yahoo.elide.core.DataStore;
import com.yahoo.elide.datastores.hibernate5.HibernateStore;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Map;

@RestController
public class EntityController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EntityController.class);

    @Autowired
    private EntityManagerFactory emf;
    private final Logger logger = new Slf4jLogger();
    private Elide elide;

    /**
     * Converts a plain map to a multivalued map
     * @param input The original map
     * @return A MultivaluedMap constructed from the input
     */
    private MultivaluedMap<String, String> fromMap(final Map<String, String> input) {
        return new MultivaluedHashMap<String, String>(input);
    }

    @CrossOrigin(origins = "*")
    /*@GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            value={"/{entity}", "/{entity}/{id}/relationships/{entity2}", "/{entity}/{id}/{child}", "/{entity}/{id}"})*/
    @Transactional
    public String jsonApiGet(@RequestParam final Map<String, String> allRequestParams, final HttpServletRequest request) {
        LOGGER.debug("Request api get");

        // This gives us the full path that was used to call this endpoint.
        final String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

        final Elide elide = getElide();

        // Convert the map to a MultivaluedMap, which we can then
        final MultivaluedMap<String, String> params = fromMap(allRequestParams);

        /*
            This is where the magic happens. We pass in the path, the params, and a place holder security
            object (which we won't be using here in any meaningful way, but can be used by Elide
            to authorize certain actions), and we get back a response with all the information
            we need.
         */
        final ElideResponse response = elide.get(restOfTheUrl, params, new Object());

        // Return the JSON response to the client
        return response.getBody();
    }

    private DataStore getElideDataStore() {
        /*
            Elide works with the Hibernate SessionFactory, not the JPA EntityManagerFactory.
            Fortunately we san unwrap the JPA EntityManagerFactory to get access to the
            Hibernate SessionFactory.
         */
        final SessionFactory sessionFactory = emf.unwrap(SessionFactory.class);

        // Elide takes a hibernate session factory
        return new HibernateStore(sessionFactory);
    }

    private Elide getElide() {
        if(elide == null) {
            final DataStore dataStore = getElideDataStore();
            elide = new Elide(logger, dataStore);
        }
        return elide;
    }
}
