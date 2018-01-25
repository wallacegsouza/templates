# Spring Boot demo web with Tsuru config

## 1. Choose database name

Open the docker-compose file in the root directory and put your database name at the POSTGRES_DB enviroment variable.

## 2. Edit application.yaml file

Once you have changed the database name in Step 1, open the application.yaml file in the src/main/resources directory and change de database name at url propertie.

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
