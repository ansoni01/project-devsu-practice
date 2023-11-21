FROM openjdk:8-jdk-alpine
MAINTAINER ansonidaniel.com
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE}  ms-cuenta-movimientos-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "/ms-cuenta-movimientos-0.0.1-SNAPSHOT.jar" ]