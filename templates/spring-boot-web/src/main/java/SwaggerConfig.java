package ${pkg};

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  public static final Contact DEFAULT_CONTACT = new Contact(
    "CIDAC",
    "www.campos.rj.gov.br",
    "desenvolvimento.cidac@campos.rj.gov.br");

  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
    "${artifact.toUpperCase()} REST API",
    "Alguma descrição personalizada da API.",
    "API TOS",
    "Termos de serviço",
    DEFAULT_CONTACT,
    "Licença de API",
    "API license URL",
    Collections.emptyList());

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      //.apis(RequestHandlerSelectors.any())
      .apis(RequestHandlerSelectors.basePackage("${pkg}.controller"))
      .paths(PathSelectors.any())
      .build()
      .apiInfo(DEFAULT_API_INFO);
  }
}