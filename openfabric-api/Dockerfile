
FROM openjdk:11-jre-slim

# Setting the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY ../build/libs/openfabric-api-1.0.0-SNAPSHOT.jar ./app.jar

ENV DB_HOST=127.0.0.1
ENV DB_PORT=5432
ENV DB_NAME=test
ENV DB_USERNAME=openfabric
ENV DB_PASSWORD=9c231a1c61a5fe322dd1

# Expose the port on which your application listens
EXPOSE 8080

# to run the application when the container starts
CMD ["java", "-jar", "app.jar"]


