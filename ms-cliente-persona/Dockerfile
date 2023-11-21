FROM openjdk:8-jdk-alpine
MAINTAINER ansonidaniel.com
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE}  ms-cliente-persona-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/ms-cliente-persona-0.0.1-SNAPSHOT.jar" ]