FROM openjdk:19
ADD target/test-classes/tmovie_rental_system-0.0.1-SNAPSHOT.jar
VOLUME /simple.app
ENTRYPOINT["java","-jar","/app.jar"]
EXPOSE 8181
