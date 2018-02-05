# Spring Boot Web Tsuru

This documentation helps you to set up a Spring Boot Web Application to deploy with Tsuru.

## 1. Prerequisites

### 1.1 Create pgadmin4 folder

This project use containers provided by Docker. 

In order to create a container for Pgadmin4, you need to create a folder in your host directory as Pgadmin4 volume folder.

Create in your home directory (/home/$USER/), creates a folder called pgadmin4 and, in terminal, add permission running the following command: 

`mkdir -p $HOME/pgadmin4`

`sudo chmod 777 /$HOME/pgadmin4`

### 1.2 Configure Gradle proxy

If you are behind a HTTP or HTTPS proxy server, you will need to create a file called _gradle.properties_ in the /$HOME/.gradle directory, add the file the following properties:

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
### 1.3 Create Java projects directory

Open the terminal and execute the commands below:

`mkdir -p $HOME/Projects/Java`

### 1.4 Cloning java-templates repository

Open the terminal and execute the commands below:

`cd $HOME/Projects/Java`

`git clone git@gitlab.campos.rj.gov.br:cubo/java-templates.git`

### 1.5 Installing the templates

Open the terminal and execute the commands below:

`cd $HOME/Projects/Java/java-templates`

`./gradlew installAllTemplates`

To see if the templates were installed:

`lazybones list --cache`

## 2. Setting up Development Environment

### 2.1 Creating a project from a template

Choose a different directory from this template project and execute the following command:

`lazybones create --with-git <template name> <template version> <target directory>`

So if you wanted to create a new project based on spring-boot-web template in a new 'myspringbootwebapp' directory you would run:

`lazybones create --with-git spring-boot-web-tsuru 0.1 yourspringbootwebapp`

Note: Do not use the **lazybones create command** passing names with the character "-". So, names like my-spring-boot-web-app **are not alowed**.

### 2.2 Building the application & Docker image

`gradle build`

### 2.3 Run docker-compose

`docker-compose up`

**What happens:**

1. Starts Postgresql and waits up to 15 seconds for it to finish ([using wait-for-it](https://github.com/vishnubob/wait-for-it))
2. Starts Spring boot application which populates database with some test data

### 2.4 Testing the Application

1. Navigate to <http://localhost:8080> and you should see: `[{"id":1,"name":"A"},{"id":2,"name":"B"},{"id":3,"name":"C"}]`
2. Navigate to <http://localhost:5050> and you should see the Pgadmin home page. To connect to the database you need to pass your IP address for the Host.

## 3. Setting up Deploy Environment

### 3.1 Creating a new application on Tsuru

Once you've added a tsuru platform, it's time you create your application. Each application should have a unique name.

Before to create your new app, type `tsuru app-list <appname>` in terminal and if the there is no app with the name you intend to give to your app, type in terminal `tsuru app-create your-app-name java-8u152-zulu`.

If you succeeded in creating your app you should be able to see something like te following message on your terminal: `git@10.131.189.70.nip.io:you-app.git`. Copy and save this git deploy url beacause you gonna need it in the next steps.

### 3.2 Bind Database Service

Now that you created you application on Tsuru, you need to bind the database service to you application. To do this, execute the following command in terminal: `tsuru service-instance-bind postgresapi db_tsuru-poc-rails-pg -a your-app-name`

### 3.3 Creating JAVA_ENV in Tsuru

In this step you nedd to create an enviroment variable in order to tell Tsuru that Gradle build is not in the development enviroment and must ignore the container image build task.

So, in your terminal, type the following command: `tsuru env-set JAVA_ENV=production -a your-app-name`.

### 3.4 Binding your project on Tsuru to make the deploy

Now you gonna need the git deploy url (Git Repository) that you got in step 4. But if you lost it, run the following command in your terminal and you will be able to see the git deploy url of your application: `tsuru app-info -a your-app-name`. If you forgot your application name run the command `tsuru app-list`.

Using the terminal, get inside the project created in the previous step and type the following command: `git remote add origin the-git-tsuru-deploy-url-of-your-project`.

### 3.5 Deploying your project on Tsuru

To deploy your project on Tsuru run the following command: `git push --set-upstream origin master`