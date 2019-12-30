FROM openjdk:8
VOLUME /tmp
EXPOSE 8181
ADD ./target/microService-Person-0.0.1-SNAPSHOT.jar service-person.jar
ENTRYPOINT ["java","-jar","/service-person.jar"]