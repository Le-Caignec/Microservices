FROM openjdk:18-jdk-alpine

ADD build/libs/*.jar bdd.jar
ADD token.json token.json

ENTRYPOINT ["java","-jar","/bdd.jar"]