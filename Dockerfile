FROM openjdk:11-ea-19-jre-slim
WORKDIR /app
COPY target/lab3LF-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8089
ENTRYPOINT [ "java", "-jar", "app.jar" ]