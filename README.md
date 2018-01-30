# Java Lazybones Templates

## Downloading and installing tools on your machine

The instructions bellow will help you to install Git, SDKMAN, Java (JDK), Maven, Gradle, Lazybones and Docker in your machine.

You will need execute the steps 1 to 7 only once.

The step 8 helps you to create your java project from one of ours template projects.

### 1 Download, install and configure Git

To download and install Git, open the terminal and execute the commands bellow:

`sudo apt-get update`

`sudo apt-get install git`

Now that you have git installed, you need to do a few things so that the commit messages that will be generated for you will contain your correct information.

The easiest way of doing this is through the git config command. Specifically, we need to provide our name and email address because git embeds this information into each commit we do. We can go ahead and add this information by typing in terminal:

`git config --global user.name "Your Name"`

`git config --global user.email "youremail@domain.com"`

### 2 Download and install SDKMAN

To download and install SDKMAN follow the instructions of this [link](http://sdkman.io/install.html)

### 3 Download and install Java Development Kit (JDK)

Open your terminal and type the command below:

`sdk install java`

### 4 Download and install Maven

Open your terminal and type the command below:

`sdk install maven`

### 5 Download and install Gradle

Open your terminal and type the command below:

`sdk install gradle`

### 6 Download and install Lazybones

Lazybones allows you to create a new project structure for any framework or library for which the tool has a template. 

If you want more information about the project check it out [here](https://github.com/pledbrook/lazybones/) and [here](https://github.com/pledbrook/lazybones/wiki/Template-developers-guide)

Open your terminal and type the command below:

`sdk install lazybones`

### 7 Download and install Docker

To download and install Docker follow the instructions of this [link](DOCKERINSTALLATION.md)

### 8 Creating projects by templates

We have 2 (two) templates that you can choose and create your project from them: **spring-boot-web** and **spring-boot-web-tsuru**.

**spring-boot-web** template will generate a Spring boot Java project configured with:
    - Spring Boot
    - Spring Data JPA
    - Docker
    - Flyway
    - PostgreSQL connection database
    - Guava

**spring-boot-web-tsuru** template will generate a Spring boot Java project configured with:
    - Spring Boot
    - Spring Data JPA
    - Docker
    - Flyway
    - PostgreSQL connection database
    - Guava
    - **Tsuru Deploy configuration**

To create a **spring-boot-web** project follow the instructions of this [link](java-templates/templates/spring-boot-web/README.md)

To create a **spring-boot-web-tsuru** project follow the instructions of this [link](/home/jhonys/Projects/Java/Projects/java-templates/templates/spring-boot-web-tsuru/README.md)