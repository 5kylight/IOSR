FROM openjdk:8-jdk-alpine
RUN apk --update add curl
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f 0.0.0.0:8761/health || exit 1

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar"]
