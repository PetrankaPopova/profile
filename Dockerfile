FROM openjdk:15-jdk-alpine
WORKDIR profile
COPY . .
RUN apk add maven
RUN mvn package -Dmaven.test.skip=true
CMD ["java", "-jar", "target/profile-0.0.1-SNAPSHOT.jar"]