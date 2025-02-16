# Build container
FROM openjdk:21-jdk-bullseye AS builder

## Build
# Create a directory for our application
WORKDIR /app

COPY mvnw .
COPY pom.xml .
COPY .mvn .mvn
COPY src src
COPY movies.json .


# target/weather-0.0.1-SNAPSHOT.jar
RUN chmod a+x /app/mvnw
RUN /app/mvnw package -Dmaven.test.skip=true

# Run container
FROM openjdk:21-jdk-bullseye 

WORKDIR /app_run

COPY --from=builder /app/target/ibf-b4-ssf-assessment-0.0.1-SNAPSHOT.jar movies.jar
COPY --from=builder /app/movies.json .
#COPY --from=builder /app/target/weather-0.0.1-SNAPSHOT.jar .

## Run
ENV PORT=8080
EXPOSE ${PORT}

ENTRYPOINT SERVER_PORT=${PORT} java -jar movies.jar