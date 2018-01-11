package ${pkg}

import org.springframework.boot.ApplicationArguments
import ${pkg}.init.BootStrap
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@EnableAutoConfiguration
@ComponentScan
@CompileStatic
@SpringBootApplication
class AppNameApplication implements ApplicationRunner {

  @Autowired
  BootStrap bootStrap

  static void main(String[] args) {
    SpringApplication.run AppNameApplication, args
  }

  void run(ApplicationArguments args) throws Exception {
    if(System.getenv("env")?.equals("developement")) {
      bootStrap.init()
    }
  }
}
