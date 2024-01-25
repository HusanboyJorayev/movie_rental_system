FROM openjdk:17

#WORKDIR /app

ADD target/movie-app.jar app.jar

VOLUME /simple.app

EXPOSE 8181

ENTRYPOINT ["java", "-jar", "/app.jar"]
