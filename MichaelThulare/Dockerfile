FROM openjdk:17-jdk-slim
LABEL authors="motlo"
# Install OpenJDK
#RUN apt-get update && apt-get install -y openjdk-17-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
