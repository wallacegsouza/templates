# Java Lazybones Templates

# Section 1: Downloading and installing tools

## 1. Download, install and configure Git

To download and install Git, open the terminal and execute the commands bellow:

`sudo apt-get update`

`sudo apt-get install git`

Now that you have git installed, you need to do a few things so that the commit messages that will be generated for you will contain your correct information.

The easiest way of doing this is through the git config command. Specifically, we need to provide our name and email address because git embeds this information into each commit we do. We can go ahead and add this information by typing in terminal:

`git config --global user.name "Your Name"`

`git config --global user.email "youremail@domain.com"`

## 2. Download and install SDKMAN

To download and install SDKMAN follow the instructions of this [link](http://sdkman.io/install.html)

## 3. Download and install Java Development Kit (JDK)

Open your terminal and type the command below:

`sdk install java`

## 3. Download and install Maven

Open your terminal and type the command below:

`sdk install maven`

## 4. Download and install Gradle

Open your terminal and type the command below:

`sdk install gradle`

## 5. Download and install Lazybones

Lazybones allows you to create a new project structure for any framework or library for which the tool has a template. 

If you want more information about the project check it out [here](https://github.com/pledbrook/lazybones/) and [here](https://github.com/pledbrook/lazybones/wiki/Template-developers-guide)

Open your terminal and type the command below:

`sdk install lazybones`

## 6. Download and install Docker

To download and install Docker follow the instructions of this [link](DOCKER-INSTALLATION.md)

# Section 2: Creating projects by template

## 1. Installing the templates 

Using Git, clone this project to some directory in your computer.

Open the terminal and execute the command below inside the cloned  project directory:

`./gradlew installAllTemplates`

## 2. Creating the template

Choose a different directory from the Section 2 step 1 and execute the following command:

`lazybones create <template name> <template version> <target directory>`

So if you wanted to create a new project based on spring-boot-web project in a new 'myspringbootwebapp' directory you would run:

`lazybones create spring-boot-web 0.1 myspringbootwebapp`

Note: Do not use the **lazybones create command** passing names with the character "-". So names like my-spring-boot-web-app are not alowed.