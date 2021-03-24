FROM adoptopenjdk/openjdk11:ubi
WORKDIR /
ADD target/demo-0.0.1-SNAPSHOT.jar //
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/demo-0.0.1-SNAPSHOT.jar"]