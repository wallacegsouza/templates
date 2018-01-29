#! /bin/bash
./wait-for-it.sh database:5432 -t 15
/home/ubuntu/.sdkman/candidates/java/current/bin/java -Djava.security.egd=file:/dev/./urandom -jar app.jar
