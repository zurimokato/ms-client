FROM openjdk:17-jdk-slim
LABEL authors="noj2304"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-client.jar
ENTRYPOINT ["java", "-jar","/ms-client.jar"]