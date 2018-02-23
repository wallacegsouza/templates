# This Dockerfile is very simple, but that’s all you need to run a Spring Boot app 
# with no frills: just Java and a JAR file. The project JAR file is ADDed to the
# container as "app.jar" and then executed in the ENTRYPOINT.

FROM openjdk:8u151-jdk-alpine3.7

ENV http_proxy http://10.131.188.1:80/
ENV https_proxy http://10.131.188.1:80/

RUN apk update && apk add openssh-client bash

COPY build/libs/*.jar app.jar
COPY docker/start.sh start.sh
COPY docker/wait-for-it.sh wait-for-it.sh

ENTRYPOINT ["./start.sh"]