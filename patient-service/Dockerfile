FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# the pom file will be in the /app directory
COPY pom.xml .

# mvn to install packages from pom and go-offline is for caching and download new packages
RUN mvn dependency:go-offline -B

# Copy src files into /app directory
COPY src ./src

# Create .jar file
RUN mvn clean package

FROM openjdk:21-jdk AS runner

WORKDIR /app

# Copy the builder .jar into runner
COPY --from=builder ./app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4000

ENTRYPOINT ["java","-jar","app.jar"]