# Spring Boot Web Tsuru

## 3. Setting up Deploy Environment

> **Note:** 
This project is GitLab CI/CD integrated. So, to use GitLab CI/CD you only need to follow the instructions of the sections **3.1 and 3.3**
>

### 3.1 Creating a new application on Tsuru

Once you've added a tsuru platform, it's time you create your application. Each application should have a unique name.

Before create your new app, type `tsuru app-list <appname>` in terminal and if the there is no app with the name you intend to give to your app, type in terminal: 

```
## Creating staging and production applications

~~tsuru app-create yourappname-staging java-8u152-zulu~~
~~tsuru app-create yourappname-production java-8u152-zulu~~

tsuru app-create yourappname-staging java8
tsuru app-create yourappname-production java8
```

### 3.2 Storing git deploy URL's

If you succeeded in creating your staging and production app you should be able to see something like te following message on your terminal: `git@10.131.189.70.nip.io:you-app.git`.

Copy and save the staging and production git deploy urls if you want to make manual deploy.

### 3.3 Bind Database Service

Now that you created you application on Tsuru, you need to bind the database service to your staging and production deploy environment. To do this, execute the following commands in terminal: 

```
tsuru service-instance-bind postgresapi db_tsuru-poc-rails-pg -a yourappname-staging

tsuru service-instance-bind postgresapi db_tsuru-poc-rails-pg -a yourappname-production
```

### 3.4 Binding your project on Tsuru to make the deploy 

Now you gonna need the git deploy url (Git Repository) that you got in step 4. But if you lost it, run the following command in your terminal and you will be able to see the git deploy url of your application:

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

### 3.5 Deploying your project on Tsuru

To deploy your project on Tsuru run the following command:

```
git push --set-upstream origin master
```