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

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      //.apis(RequestHandlerSelectors.any())
      .apis(RequestHandlerSelectors.basePackage("${pkg}.controller"))
      .paths(PathSelectors.any())
      .build()
      .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
    "REST Api do CCidadao ",
    "Alguma descrição personalizada da API.",
    "API TOS",
    "Termos de serviço",
    new Contact("Wallace G. Souza", "www.campos.rj.gov.br", "wallacesouza@campos.rj.gov.br"),
    "Licença de API", "API license URL", Collections.emptyList());
  }
}