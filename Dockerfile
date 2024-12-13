FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/myApp.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "/app/myApp.jar"]