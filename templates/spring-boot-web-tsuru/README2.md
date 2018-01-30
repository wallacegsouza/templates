# Spring Boot demo web with Tsuru config

## 1. Login on Tsuru

Open the terminal and type the following command: `tsuru login`

Input your e-mail and password and done! You successfully logged in!

## 2. Adding a platform to tsuru

Tsuru needs a platform to run your application. Each platform should have a unique name. 

To correctly name your platform we recommend you to follow the instructions bellow:

1) The platform name should always begin with your programing language name. For example: if you are programing in Java you platform name should begin with java. 

2) Complement your platform name with versions. Example: if you are using Java, verifiy the exactly version of your JDK and add to your platform name.

So, in order to follow the instructions above, we are going to add a Java 8 platform called **java8u152-zulu**. But first, let's list the Tsuru Platform and check if there is no platform with this name. 

Open the terminal and type `tsuru platform-list` to list the tsuru available platforms.**If there is no platform called java8u152-zulu** type, in terminal, `tsuru platform-add java-8u152-zulu -i jhonyscamacho/java-8u152-zulu` and done! You successfully added a new platform to tsuru!

## 3. Creating a new application on Tsuru

Once you've added a platform, it's time you create your application. Each application should have a unique name.

Before to create your new app, type `tsuru app-list <appname>` in terminal and if the there is no app with the name you intend to give to your app, type in terminal `tsuru app-create your-app-name java-8u152-zulu`.

If you succeeded in creating your app you should be able to see something like te following message on your terminal: `git@10.131.189.70.nip.io:you-app.git`. Copy and save this link beacause you gonna need it in the next steps.

## 4. Bind Database Service

Now that you created you application on Tsuru, you need to bind the database service to you application. To do this, execute the following command in terminal: `tsuru service-instance-bind postgresapi db_tsuru-poc-rails-pg -a your-app-name`

## 5. ENV SET

In this step you nedd to create an enviroment variable in order to tell Tsuru that Gradle build is not in the development enviroment and must ignore the container image build task.

So, in your terminal, type the following command: `tsuru env-set JAVA_ENV=production -a your-app-name`.

## 6 Installing the templates

Using Git, clone this project to some directory in your computer.

Open the terminal and execute the command below inside the cloned  project directory:

`./gradlew installAllTemplates`

To see if the templates were installed:

`lazybones list --cache`

## 7 Creating the template

Choose a different directory from the cloned repository in section 2.1 and execute the following command:

`lazybones create --with-git <template name> <template version> <target directory>`

So if you wanted to create a new project based on spring-boot-web template in a new 'myspringbootwebapp' directory you would run:

`lazybones create --with-git spring-boot-web-tsuru 0.1 yourspringbootwebapp`

Note: Do not use the **lazybones create command** passing names with the character "-". So, names like my-spring-boot-web-app **are not alowed**.
















## 3. Create pgadmin4 folder

Create your home directory (/home/$USER/), creates a folder called pgadmin4 and, in terminal, add permission running the following command: 

`sudo chmod 777 /home/$USER/pgadmin4`

## 3. Build app & Dockerfile

`gradle build`

## 4. Run docker-compose

`docker-compose up`

**What happens:**

1. Starts Postgresql and waits up to 15 seconds for it to finish ([using wait-for-it](https://github.com/vishnubob/wait-for-it))
2. Starts Spring boot application which populates database with some test data

## 3. Test

1. Navigate to <http://localhost:8080> and you should see: `[{"id":1,"name":"A"},{"id":2,"name":"B"},{"id":3,"name":"C"}]`
2. Navigate to <http://localhost:5050> and you should see the Pgadmin home page. To connect to the database you need to pass your IP address for the Host.
