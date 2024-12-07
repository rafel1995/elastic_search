# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Install Maven and necessary tools
RUN apt-get update && apt-get install -y maven && apt-get clean

# Set the working directory in the container
WORKDIR /app

# Copy the project’s pom.xml and download dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy the project’s source code
COPY src ./src

# Copy the resources directory
COPY src/main/resources /app/resources

# Package the application
RUN mvn package -DskipTests

# Expose the port the application runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]