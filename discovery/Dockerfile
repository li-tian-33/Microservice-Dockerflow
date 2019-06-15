
FROM openjdk:8-jre-alpine
ENV APP_FILE discovery.jar
WORKDIR /app
COPY target/discovery-0.0.1-SNAPSHOT.jar $APP_FILE
ENTRYPOINT [ "sh","-c","while ! (nc -z config-center 8088); do sleep 5; echo 'Waiting for config-server services to start-up...'; done;java -Dspring.profiles.active=docker -jar  $APP_FILE"]