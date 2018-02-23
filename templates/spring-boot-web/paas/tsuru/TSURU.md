# Spring Boot Web Tsuru

This documentation helps you to set up a Spring Boot Web Application to deploy with Tsuru.

## 1. Setting up Development Environment

### 1.1 Creating a project from a template

Choose a different directory from this template project and execute the following command:

```
lazybones create --with-git <template name> <template version> <target directory>
```

So if you wanted to create a new project based on spring-boot-web template in a new 'myspringbootwebapp' directory you would run:

```
lazybones create --with-git spring-boot-web-tsuru 0.2 yourspringbootwebapp
```

Note: Do not use the **lazybones create command** passing names with the character "-". So, names like my-spring-boot-web-app **are not alowed**.

### 1.2 Setting up Test Environment

If you are behind a HTTP or HTTPS proxy server, you will need to create a file called _gradle.properties_ in the /yourspringbootwebapp/.gradle directory, add the file the following properties:

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

### 1.3 Building the application & Docker image

```
cd yourspringbootwebappyourspringbootwebapp
gradle build
```

### 1.4 Development commands and tips

If you want tips asnd more information about the development enviroment take a look at this [link]
(https://gitlab.com/jhonys.camacho/java-templates/blob/master/templates/spring-boot-web-tsuru/doc/DEVELOPMENT.md)

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

## 3. Setting up Deploy Environment

### 3.1 Creating a new application on Tsuru

Once you've added a tsuru platform, it's time you create your application. Each application should have a unique name.

Before to create your new app, type `tsuru app-list <appname>` in terminal and if the there is no app with the name you intend to give to your app, type in terminal ~~`tsuru app-create your-app-name java-8u152-zulu`~~ `tsuru app-create your-app-name java8`.

If you succeeded in creating your app you should be able to see something like te following message on your terminal: `git@10.131.189.70.nip.io:you-app.git`. Copy and save this git deploy url beacause you gonna need it in the next steps.

### 3.2 Bind Database Service

Now that you created you application on Tsuru, you need to bind the database service to you application. To do this, execute the following command in terminal: 

```
tsuru service-instance-bind postgresapi db_tsuru-poc-rails-pg -a your-app-name
```# This Dockerfile is very simple, but that’s all you need to run a Spring Boot app 
# with no frills: just Java and a JAR file. The project JAR file is ADDed to the
# container as "app.jar" and then executed in the ENTRYPOINT.

FROM openjdk:8u151-jdk-alpine3.7

ENV http_proxy http://10.131.188.1:80/
ENV https_proxy http://10.131.188.1:80/

RUN apk update && apk add openssh-client bash

COPY build/libs/*.jar app.jar
COPY docker/start.sh start.sh
COPY docker/wait-for-it.sh wait-for-it.sh

ENTRYPOINT ["./start.sh"]

### 3.3 Binding your project on Tsuru to make the deploy

Now you gonna need the git deploy url (Git Repository) that you got in step 4. But if you lost it, run the following command in your terminal and you will be able to see the git deploy url of your application:

```
tsuru app-info -a your-app-name
```

 If you forgot your application name run the command:
 
```
tsuru app-list
```

Using the terminal, get inside the project created in the previous step and type the following command: 

```
git remote add origin the-git-tsuru-deploy-url-of-your-project
```

### 3.4 Deploying your project on Tsuru

To deploy your project on Tsuru run the following command:

```
git push --set-upstream origin master
```