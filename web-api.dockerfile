FROM openjdk:21
RUN ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime && echo "Asia/Seoul" > /etc/timezone
ARG JAR_FILE=web-api/build/libs/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
