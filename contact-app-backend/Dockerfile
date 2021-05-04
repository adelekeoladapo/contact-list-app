FROM maven:3.6.3-jdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
COPY people.csv /workspace
RUN mvn -f pom.xml clean package -DskipTests

# Package stage
FROM openjdk:8-jdk-alpine
COPY --from=build /workspace/people.csv people.csv
COPY --from=build /workspace/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
