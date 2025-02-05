#FROM openjdk:17-jdk-alpine
#RUN mkdir /app
#WORKDIR /app
#COPY target/ElasticSearch-0.0.1-SNAPSHOT.jar /app
#EXPOSE 8082
#CMD ["--spring.profiles.active=gcp"]
#ENTRYPOINT ["java", "-jar", "ElasticSearch-0.0.1-SNAPSHOT.jar"]

# 1. Building the App with Maven
FROM maven:3-openjdk-17 AS build

# Add source code to the container
ADD ./ElasticSearch /elastic_search_service_staging

# Set the working directory
WORKDIR /elastic_search_service_staging

# Display the contents for debugging
RUN ls -l

# Run Maven build to create the JAR file
RUN mvn clean install -DskipTests

# 2. Creating a smaller image for the final application
FROM openjdk:17-jdk-alpine

# Set up a volume for temporary files
VOLUME /tmp

# Copy the built JAR from the build stage
COPY --from=build /elastic_search_service_staging/target/ElasticSearch-0.0.1-SNAPSHOT.jar elastic-search-service.jar

# Expose the application port
EXPOSE 8082

# Set the default command to run the Spring Boot app
CMD ["sh", "-c", "java -Dserver.port=8082 -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom -jar elastic-search-service.jar"]
