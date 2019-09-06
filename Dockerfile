FROM maven:3.5-jdk-8 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:go-offline -B
COPY src /app/src
RUN mvn clean install

FROM openjdk:8u131-jre-alpine
WORKDIR /app
COPY --from=build /app/target/coffee-service-0.0.1-SNAPSHOT.jar /app
RUN chmod +x coffee-service-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "coffee-service-0.0.1-SNAPSHOT.jar"]
