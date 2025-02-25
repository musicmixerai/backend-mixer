FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/mixer-gateway-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
