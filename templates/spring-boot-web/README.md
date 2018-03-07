# Spring Boot Web

This documentation helps you to set up a Spring Boot Web Application.

## 1. Setting up Development Environment

### 1.1 Creating a project from a template

Choose a different directory from this template project and execute the following command:

```
lazybones create --with-git <template name> <template version> <target directory>
```

So if you wanted to create a new project based on spring-boot-web template in a new 'myspringbootwebapp' directory you would run:

```
lazybones create --with-git spring-boot-web 0.5 yourspringbootwebapp
```

Note: Do not use the **lazybones create command** passing names with the character "-". So, names like my-spring-boot-web-app **are not alowed**.

> **Note:** 
In the application creation process you will need to choose the Platform as a Service that you need to use.
> 

### 1.2 Building the application & Docker image

```
cd yourspringbootwebapp
gradle build
```

### 1.3 Setting up Test Environment

> **Note:** 
If you are behind a HTTP or HTTPS proxy server, you will need to create a file called _gradle.properties_ in the /yourspringbootwebapp/.gradle directory, add the file the following properties:
>

```
org.gradle.jvmargs=-Xmx1536m
systemProp.http.proxyHost=proxy.campos.rj.gov.br
systemProp.http.proxyPort=80
systemProp.http.nonProxyHosts=localhost
systemProp.http.auth.ntlm.domain=domain

systemProp.https.proxyHost=proxy.campos.rj.gov.br
systemProp.https.proxyPort=80
systemProp.https.nonProxyHosts=localhost
systemProp.https.auth.ntlm.domain=domain

```

### 1.4 Development commands and tips

If you want tips asnd more information about the development enviroment take a look at this [link]
(http://gitlab.campos.rj.gov.br/cubo/java-templates/blob/master/templates/spring-boot-web/doc/DEVELOPMENT.md)

## 2. Running the application

### 2.1 Running the application in development environment containers

To run the development environment containers run:

```
docker-compose up --build app
```

To stop the containers run:

```
docker-compose down
```

**What happens:**

1. Starts Postgresql and waits up to 15 seconds for it to finish ([using wait-for-it](https://github.com/vishnubob/wait-for-it))
2. Starts Spring boot application which populates database with some test data

#### 2.1.2 Testing the Application

1. Navigate to <http://localhost:8080> and you should see:

```
[{"id":1,"name":"A"},{"id":2,"name":"B"},{"id":3,"name":"C"}]
```

2. Navigate to <http://localhost:5050> and you should see the Pgadmin home page. To connect to the database you need to pass your IP address for the Host.

### 2.2 Running the application in test environment container

To run the test environment container run:

```
docker-compose up --build test
```

To stop the container run:

```
docker-compose down
```