FROM eclipse-temurin:21-jre-alpine

COPY build/libs/*.jar /tmp/app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_ARGS -jar /tmp/app.jar"]