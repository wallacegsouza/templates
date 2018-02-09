#! /bin/bash
./wait-for-it.sh database:5432 -t 15

# Java command for jhonyscamacho/java-8u152-zulu - this image is temporarily not being used
#/home/ubuntu/.sdkman/candidates/java/current/bin/java -Djava.security.egd=file:/dev/./urandom -jar app.jar

# Java command for jhonyscamacho/java8
java -Djava.security.egd=file:/dev/./urandom -jar app.jar