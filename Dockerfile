FROM maven:3.8.2-openjdk-17-slim AS BUILD_STAGE

WORKDIR /app

COPY pom.xml pom.xml
COPY src/ src/

RUN mvn clean install

FROM openjdk:17-slim

WORKDIR /app

COPY --from=BUILD_STAGE /app/target/it-website*.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]