
FROM openjdk:8-jre-alpine
ENV APP_FILE employee.jar
WORKDIR /app

COPY target/employee-0.0.1-SNAPSHOT.jar $APP_FILE
EXPOSE 9090
ENTRYPOINT [ "sh","-c","while ! (nc -z config-center 8088 && nc -z discovery 8061); do sleep 5; echo 'Waiting for config-server, discovery-server services to start-up...'; done;java -Dspring.profiles.active=docker -jar $APP_FILE"]



#FROM maven:3.6-jdk-8
#ENV APP_FILE employee.jar
#ARG SOURCE_FOLDER=/source
#
#RUN    mkdir -p $SOURCE_FOLDER
##    && cd $SOURCE_FOLDER \
##    && mvn  package -Dmaven.test.skip=true
#
#WORKDIR /app
#COPY $SOURCE_FOLDER/target/employee-0.0.1-SNAPSHOT.jar $APP_FILE
#EXPOSE 9090
#ENTRYPOINT [ "sh","-c","while ! (nc -z config-center 8088 && nc -z discovery 8061); do sleep 5; echo 'Waiting for config-server, discovery-server services to start-up...'; done;java -Dspring.profiles.active=docker -jar $APP_FILE"]
