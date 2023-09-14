FROM eclipse-temurin:17
LABEL maintainer="daniel.amdei@gmail.com"
 WORKDIR/app
 COPY target/empMan_backend-0.0.1-SNAPSHOT.jar app/empman_backend.jar
  ENTRYPOINT["java","-jar","empman_backend.jar"]