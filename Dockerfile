FROM openjdk:17
ADD /target/demo-0.0.1-SNAPSHOT.jar nice.jar
ENTRYPOINT ["java", "-jar", "nice.jar"]