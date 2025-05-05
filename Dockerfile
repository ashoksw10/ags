# Start with a lightweight Java runtime
FROM openjdk:17-jdk-slim

# Add a label (optional)
LABEL maintainer="ashok@ags.com"

# Create a directory inside the container
WORKDIR /app

# Copy your Spring Boot jar into the container
COPY target/ags-0.0.1-SNAPSHOT.jar app.jar

# Tell Docker how to run your app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
