FROM maven:3.6.3-adoptopenjdk-11 AS build
ARG SPRING_PROFILES_ACTIVE=dev
COPY src /usr/app/src
COPY pom.xml /usr/app
RUN mvn -f /usr/app/pom.xml clean package

FROM adoptopenjdk/openjdk11:jdk-11.0.9_11.1-alpine
RUN apk update && apk upgrade && addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ENV SPRING_PROFILES_ACTIVE=docker
COPY --from=build /usr/app/target/*.jar /usr/app/app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]