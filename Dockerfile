FROM openjdk:17-alpine

WORKDIR /app

COPY target/PlanetInfo-0.0.1-SNAPSHOT.jar /app

CMD ["java","-jar","PlanetInfo-0.0.1-SNAPSHOT.jar"]