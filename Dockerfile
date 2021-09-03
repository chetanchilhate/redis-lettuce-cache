FROM adoptopenjdk:11-jre-hotspot

EXPOSE 8080

COPY ./build/libs/redis-lettuce-cache-v1.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "redis-lettuce-cache-v1.jar"]