# Development commands and tips

## 1. Showing all available tasks in the project

To see all available tasks in the project you could run one of these commands (they are equivalents):

`gradle tasks` or `./gradlew tasks`

## 2. Building the Docker image for the Java application

To create the Docker image for these application execute one the following commands (they are equivalents):

`gradle createDockerImage` or `./gradlew createDockerImage`

## 3. Stopping all docker containers

To stop all docker containers run `docker stop $(docker ps -a -q)`

## 4. Removing all docker containers

To remove all docker containers run `docker rm $(docker ps -a -q)`

## 4. Running this project as a JVM application in your host

The `gradle run -Pjenv=development` command is equivalent to the `./gradlew run -Pjenv=development`.

The `gradle run -Pjenv=test` command is equivalent to the `./gradlew run -Pjenv=test`

The `gradle run -Pjenv=production` command is equivalent to the `./gradlew run -Pjenv=production`

If you run `gradle run` the development environment will be used by default.

## 5. Running unit tests

To run the unit test of this project as a JVM application execute one the following commands (they are equivalents):

`gradle test` or `./gradlew test`

## 6. Running project using Spring Boot tools

Execute the `gradle bootRun` command to run the project with support for auto-detecting main class and reloading static resources.

## 7. Checking the source quality

To run quality plugins for **main source set** execute one the following commands (they are equivalents):

`gradle checkQualityMain` or `./gradlew checkQualityMain`

To run quality plugins for **test source set** execute one the following commands (they are equivalents):

`gradle checkQualityTest` or `./gradlew checkQualityTest`

## 8. Displaying the dependency updates for the project

To displays the dependency updates for the project execute one the following commands (they are equivalents):

`gradle dependencyUpdates -Drevision=release` or `./gradlew dependencyUpdates -Drevision=release`

Take a look at some actuator endpoints:

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

For more information about Actuator take a look at this [link](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html)

## 10. Swagger

Swagger is an open source project used to describe and document RESTful APIs. To access the project API documentation use the following URL's:

/swagger-ui.html

/swagger-resources/configuration/security

/swagger-resources

/swagger-resources/configuration/ui

For more information about Swagger take a look at this [link](https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/)