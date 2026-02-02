# Step 1: Build stage using Maven and Java 21
FROM eclipse-temurin:21 AS build

WORKDIR /app

# Copy only what's needed first for dependency caching
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Download dependencies (caching layer)
RUN ./mvnw dependency:go-offline

# Copy the full source code
COPY src ./src

# Package the application (skipping tests for speed)
RUN ./mvnw clean package -DskipTests

# Step 2: Run stage using a slim JDK
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copy built JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]