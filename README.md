# Java Lazybones Templates

This templates helps you to create portable Java projects.

We recommend you to use Ubuntu to the correctly use of this templates.

## Getting Started

These instructions will generate you a copy of the project up and running on your local machine for development, testing and deploy purposes.

### Prerequisites

In order to generate a Java project from one of this templates you need to install the following softwares:

* [Git](INSTALL.GIT.md) - Version Control System
* [SDKMAN](http://sdkman.io/install.html) - Software Development Kit Manager
* [Docker](INSTALL.DOCKER.md) - Container provider
* [Tsuru](TSURU.md) - Platform as a Service (Paas)

Open your terminal and type the command below:

`sdk install java`
`sdk install maven`
`sdk install gradle`
`sdk install lazybones`

Lazybones allows you to create a new project structure for any framework or library for which the tool has a template. 

If you want more information about lazybones project check it out [here](https://github.com/pledbrook/lazybones/) and [here](https://github.com/pledbrook/lazybones/wiki/Template-developers-guide)


## Creating projects by templates

We have 2 (two) templates that you can choose and create your project from them: **spring-boot-web** and **spring-boot-web-tsuru**.

**spring-boot-web** template will generate a Spring boot Java project configured with:
    - Gradle
    - Spring Boot
    - Spring Data JPA
    - Docker
    - FlywayDB
    - PostgreSQL connection database
    - Guava
    - Spring Actuator

**spring-boot-web-tsuru** template will generate a Spring boot Java project configured with:
    - Gradle
    - Spring Boot
    - Spring Data JPA
    - Docker
    - FlywayDB
    - PostgreSQL connection database
    - Guava
    - Spring Actuator
    - **Tsuru Deploy configuration**

To create a **spring-boot-web** project follow the instructions of the **README** file inside spring-boot-web folder.

To create a **spring-boot-web-tsuru** project follow the instructions of the **README** file inside spring-boot-web-tsuru folder.