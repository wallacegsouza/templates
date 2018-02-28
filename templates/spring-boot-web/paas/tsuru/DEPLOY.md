# Spring Boot Web Tsuru

## 1. Setting up GitLab CI/CD Deploy Environment

> **Note:** 
This project is GitLab CI/CD integrated. So, to use GitLab CI/CD you only need to follow the instructions of the sections **1.1 and 1.2**
>

### 1.1 Creating a new application on Tsuru

Once you've added a tsuru platform, it's time you create your application. Each application should have a unique name.

Before create your new app, type `tsuru app-list <appname>` in terminal and if the there is no app with the name you intend to give to your app, type in terminal: 

```
## Creating staging and production applications

~~tsuru app-create yourappname-staging java-8u152-zulu~~
~~tsuru app-create yourappname-production java-8u152-zulu~~

tsuru app-create yourappname-staging java8
tsuru app-create yourappname-production java8
```

### 1.2 Bind Database Service

Now that you created you application on Tsuru, you need to bind the database service to your staging and production deploy environment. To do this, execute the following commands in terminal: 

```
tsuru service-instance-bind postgresapi db_tsuru-poc-rails-pg -a yourappname-staging

tsuru service-instance-bind postgresapi db_tsuru-poc-rails-pg -a yourappname-production
```

## 2 Setting up Manual Deploy Environment

Now you gonna need the Tsuru deploy url. The command below will help you to find the URL.

```
tsuru app-info -a yourappname-staging
```

If you forgot your application name run the command:

```
tsuru app-list
```

Using the terminal, get inside the project created in the previous step and type the following command: 

```
git remote add origin the-git-tsuru-deploy-url-of-your-project
```

### 2.1 Deploying your project on Tsuru

To deploy your project on Tsuru run the following command:

```
git push --set-upstream origin master
```