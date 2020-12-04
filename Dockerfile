FROM openjdk:8-jre-alpine
VOLUME /tmp
EXPOSE 7000
ADD target/springboot-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
