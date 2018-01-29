# This Dockerfile is very simple, but that’s all you need to run a Spring Boot app 
# with no frills: just Java and a JAR file. The project JAR file is ADDed to the
# container as "app.jar" and then executed in the ENTRYPOINT.

FROM jhonyscamacho/java-8u152-zulu-smaller-2

# WORKDIR /tmp

# # We added a VOLUME pointing to "/tmp" because that is where a Spring Boot application 
# # creates working directories for Tomcat by default. The effect is to create a temporary file
# # on your host under "/var/lib/docker" and link it to the container under "/tmp". 
# # This step is optional for the simple app that we wrote here, but can be necessary for other
# # Spring Boot applications if they need to actually write in the filesystem.
# VOLUME /tmp

COPY build/libs/*.jar app.jar
COPY docker/start.sh start.sh
COPY docker/wait-for-it.sh wait-for-it.sh

#RUN sh -c 'touch app.jar'
ENTRYPOINT ["./start.sh"]