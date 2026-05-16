# Stage 1 — Build with Maven + Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -q
COPY src ./src
COPY docs ./docs
RUN mvn clean package -DskipTests -q

# Stage 2 — Run with lightweight JRE
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/diksha-physio-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx300m", "-Xss512k", "-jar", "app.jar"]
