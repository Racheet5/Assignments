#Dockerfile contains all the commands with which
#Docker can build images reading the instructions.

FROM openjdk:17 
EXPOSE 8088
ADD target/spring-boot-docker1.jar spring-boot-docker1.jar
ENTRYPOINT ["java", "-jar","/spring-boot-docker1.jar"]