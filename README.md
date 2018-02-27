# Java Lazybones Templates

This templates helps you to create portable Java projects.

We recommend you to use Ubuntu to the correctly use of this templates.

## 1. Prerequisites

### 1.1 Software installation

In order to generate a Java project from one of this templates you need to install the following softwares:

* [Git](INSTALL.GIT.md) - Version Control System
* [SDKMAN](http://sdkman.io/install.html) - Software Development Kit Manager
* [Docker](INSTALL.DOCKER.md) - Container provider
* [Tsuru](TSURU.md) - Platform as a Service (Paas)

Open your terminal and type the command below:

```
sdk install java
sdk install maven
sdk install gradle
sdk install lazybones
```

Lazybones allows you to create a new project structure for any framework or library for which the tool has a template. 

If you want more information about lazybones project check it out [here](https://github.com/pledbrook/lazybones/) and [here](https://github.com/pledbrook/lazybones/wiki/Template-developers-guide)

### 1.2 Create pgadmin4 folder

This project use containers provided by Docker. 

In order to create a container for Pgadmin4, you need to create a folder in your host directory as Pgadmin4 volume folder.

Create in your home directory (/$HOME/), creates a folder called pgadmin4 and, in terminal, add permission running the following command: 

```
mkdir -p $HOME/pgadmin4
sudo chmod 777 /$HOME/pgadmin4
```

### 1.3 Configure Gradle proxy

> **Note:** 
If you are behind a HTTP or HTTPS proxy server, you will need to create a file called _gradle.properties_ in the /$HOME/.gradle directory, add the file the following properties:
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
### 1.4 Create Java projects directory

Open the terminal and execute the commands below:

```
mkdir -p $HOME/Projects/Java
```

### 1.5 Cloning java-templates repository

Open the terminal and execute the commands below:

```
cd $HOME/Projects/Java
git clone git@gitlab.campos.rj.gov.br:cubo/java-templates.git
```

### 1.6 Installing the templates

Open the terminal and execute the commands below:

```
cd $HOME/Projects/Java/java-templates
./gradlew installAllTemplates
```

To see if the templates were installed:

```
lazybones list --cache
```

### 1.7 Configuring Microsoft Visual Studio Code (VS Code)

If you want to use Microsoft Visual Studio Code (VS Code) follow the instructions bellow to configure the Editor.

Create a file called _settings.json_ and add the following properties:

```
{
    "explorer.confirmDelete": false,
    "editor.tabSize": 2,
    "editor.tabCompletion": true,
    "files.autoSave": "afterDelay",
    "files.autoSaveDelay": 5000,
    "editor.renderWhitespace": "all"
}

```

You could also use the following plugins:

* [Debugger for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug)
* [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
* [Language Support for Java(TM) by Red Hat](https://marketplace.visualstudio.com/items?itemName=redhat.java)
* [Git Project Manager](https://marketplace.visualstudio.com/items?itemName=felipecaputo.git-project-manager)
* [gitLens - Git supercharged](https://marketplace.visualstudio.com/items?itemName=eamodio.gitlens)
* [Docker](https://marketplace.visualstudio.com/items?itemName=PeterJausovec.vscode-docker)
* [markdownlint](https://marketplace.visualstudio.com/items?itemName=DavidAnson.vscode-markdownlint)


## 2. Creating projects by templates

We have 2 (two) templates that you can choose and create your project from them: **spring-boot-web** and **spring-boot-web-tsuru**.

**spring-boot-web** template will generate a Spring boot Java project configured with:

    - Gradle
    - Spring Boot
    - Spring Data JPA
    - Logback
    - Docker
    - FlywayDB
    - PostgreSQL connection database
    - Guava
    - Spring Actuator
    - Swagger

### 2.1 Creating a Spring Boot Web project 

To create a **spring-boot-web** project follow the instructions of this [link](http://gitlab.campos.rj.gov.br/cubo/java-templates/blob/master/templates/spring-boot-web/README.md).