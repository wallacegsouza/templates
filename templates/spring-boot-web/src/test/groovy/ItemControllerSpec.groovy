package ${pkg}

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Import
import org.springframework.http.HttpStatus
import org.springframework.http.HttpMethod
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

/**
 * @author Wallace G. Souza
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ItemControllerSpec extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    def "root path should return array with tuple id:name"() {
        setup:
        def expectResult = '[{"id":1,"name":"A"},{"id":2,"name":"B"},{"id":3,"name":"C"}]'

        when:
        def entity = restTemplate.exchange("/", HttpMethod.GET, null, String)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body == expectResult
    }
}