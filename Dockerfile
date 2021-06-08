FROM openjdk:16-ea-jdk

ADD target/ms-with-kafka-0.0.1-SNAPSHOT.jar ms-with-kafka.jar

EXPOSE 80

ENTRYPOINT ["java", "-jar", "ms-with-kafka.jar"]