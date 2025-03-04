FROM eclipse-temurin:23-jdk-noble AS builder

ARG COMPILE_DIR=/compiledir
WORKDIR /src

COPY mvnw .
COPY pom.xml .
COPY src src
COPY .mvn .mvn

RUN chmod a+x ./mvnw && ./mvnw package -Dmaven.test.skip=true

FROM eclipse-temurin:23-jre-noble

WORKDIR /app

COPY --from=builder /src/target/server-0.0.1-SNAPSHOT.jar day36.jar

ENV PORT=8080
EXPOSE ${PORT}

ENV SPRING_DATASOURCE_URL="" SPRING_DATASOURCE_USERNAME="" SPRING_DATASOURCE_PASSWORD=""

ENTRYPOINT SERVER_PORT=${PORT} java -jar day36.jar