FROM maven:3.9.9-eclipse-temurin-24 AS builder
# After we build our maven image, we specify the working direcotry
WORKDIR /app
# Then we copy the pom.xml to the working directory
COPY pom.xml .
# We run the command mvn and cache the depedency
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:24-jdk AS runner
# In here we do the running environement
WORKDIR /app
# We will copy the snapshot.jar that is created during the build from the builder to a new file in here
COPY --from=builder ./app/target/billing-service-0.0.1-SNAPSHOT.jar ./app.jar
# Once the jar has been created, we expose the port
EXPOSE 4001
# Expose the GRPC port
EXPOSE 9001
# We make a command to specify an entry point for the app
ENTRYPOINT ["java", "-jar", "app.jar"]
