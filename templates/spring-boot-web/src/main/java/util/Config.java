package ${pkg}.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//import org.h2.server.web.WebServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;

/**
 *
 * @author wallace
 */
@Configuration
public class Config extends WebMvcConfigurerAdapter {
  public static final String JENV = System.getProperty("jenv", "development");
  public static final boolean JENV_TEST = JENV.equals("test");
  public static final boolean JENV_DEVELOPMENT = JENV.equals("development");
  public static final boolean JENV_PRODUCTION = JENV.equals("production");

  @Autowired
  @Qualifier("RequestLogger")
  private HandlerInterceptor requestLogger;
 
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(this.requestLogger);
  }

  // @Bean
  // public ServletRegistrationBean h2servletRegistration() {
  //   if(JENV_TEST) {
  //     ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
  //     registrationBean.addUrlMappings("/console/*");
  //     return registrationBean;
  //   }
  //   return null;
  // }
}
