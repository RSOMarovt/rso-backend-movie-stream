FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

ADD ./target/rso-backend-movie-stream-1.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "rso-backend-movie-stream-1.0-SNAPSHOT.jar"]