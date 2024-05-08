# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper files to the container
COPY mvnw .
COPY .mvn .mvn

# Copy the project files to the container
COPY pom.xml .
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Use the official PostgreSQL image as the database image
FROM postgres:14

# Set the environment variables for the database
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=1234
ENV POSTGRES_DB=chatroom

# Copy the JAR file from the build stage to the container
COPY --from=0 /app/target/WhatsApp-API-0.0.1-SNAPSHOT.jar .

# Expose the port on which your Spring Boot app listens
EXPOSE 8080

# Set the command to run your Spring Boot app
CMD ["java", "-jar", "WhatsApp-API-0.0.1-SNAPSHOT.jar"]
