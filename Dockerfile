FROM openjdk:17-jdk-slim
WORKDIR /
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests
COPY target/mixer-gateway-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
