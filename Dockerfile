FROM amazoncorretto:17.0.6-alpine3.17
MAINTAINER diegomischiatti
WORKDIR /app
COPY target/cliente-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]