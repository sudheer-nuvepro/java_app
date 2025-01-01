# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build jar from your local machine into the container
COPY target/todo-app-0.0.1-SNAPSHOT.jar todo-app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "todo-app.jar"]
