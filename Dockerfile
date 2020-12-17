FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD e4CompareFrameworkServer.jar /app/application.jar
ENTRYPOINT java -jar /app/application.jar --server.port=8080