package ${pkg};

import ${pkg}.init.Bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication implements ApplicationRunner {

  @Autowired
  Bootstrap bootstrap;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  public void run(ApplicationArguments args) throws Exception {
    bootstrap.seed();
  }

}
