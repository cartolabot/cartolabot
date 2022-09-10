#docker buildx build --push --platform linux/arm64 -t crfwilliams/cb-database-integration-service:latest .
FROM eclipse-temurin:latest
COPY target/*.jar cb-database-integration-service.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/cb-score-scraping-service.jar"]
