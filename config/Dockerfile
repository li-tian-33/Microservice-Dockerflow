
FROM openjdk:8-jre-alpine
ENV APP_FILE config.jar
WORKDIR /app
COPY target/demo-0.0.1-SNAPSHOT.jar $APP_FILE
EXPOSE 8060
ENTRYPOINT [ "sh","-c","java -jar $APP_FILE"]