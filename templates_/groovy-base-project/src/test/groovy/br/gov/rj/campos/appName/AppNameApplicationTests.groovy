package br.gov.rj.campos.appName

import org.junit.Test
import org.junit.runner.RunWith

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate

import static org.assertj.core.api.Assertions.assertThat

@RunWith(SpringRunner)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AppNameApplicationTests {

  @Autowired
  private TestRestTemplate restTemplate

  @Test
  void contextLoads() {
    String body = this.restTemplate.getForObject("/", String)
    assertThat(body).isEqualTo("Hello World")
  }

}
