FROM maven:3.8.5-openjdk-17
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

ENTRYPOINT ["java", "-jar", "/app/target/esalink.jar"]