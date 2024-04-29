FROM eclipse-temurin:17
WORKDIR /home
COPY ./flowers ./flowers
COPY ./target/c322-final-backend-0.0.1-SNAPSHOT.jar c322-final-backend.jar
ENTRYPOINT ["java", "-jar", "c322-final-backend.jar"]