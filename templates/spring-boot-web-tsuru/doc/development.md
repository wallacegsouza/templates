Use in all gradle commands
-Pjenv=(development*|production|test)

 - by default 'development' will be used

[gradle OR ./gradlew]

All tasks runnable from root project
gradle tasks

Run the project with support for auto-detecting main class and reloading static resources
gradle bootRun

Runs this project as a JVM application
gradle run

Runs all checks
gradle check

  Run quality plugins for main source set
  gradle checkQualityMain

  Run quality plugins for test source set
  gradle checkQualityTest

Displays the dependency updates for the project
gradle dependencyUpdates -Drevision=release

Runs the unit tests
gradle test

Builds the Docker image for the Java application.
createDockerImage


Swagger:


  Example:
  https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/


Endpoints:
https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html

  Swagger:
    Api Document Test
    /swagger-ui.html
    /swagger-resources/configuration/security
    /swagger-resources
    /swagger-resources/configuration/ui

  Actuator:
    /error
    /auditevents
    /loggers
    /loggers/{name:.*}
    /env
    /env/{name:.*}
    /beans
    /mappings
    /info
    /auditevents
    /flyway
    /trace
    /health
    /dump
    /metrics/{name:.*}
    /metrics
    /autoconfig
    /heapdump
    /configprops
    /v2/api-docs

Docker commands:
  // remove all
  docker stop $(docker ps -a -q)
  docker rm $(docker ps -a -q)

Docker-compose commands:
  docker-compose up --build (app|test)
  docker-compose down

Tsuru:
https://docs.tsuru.io/stable/
