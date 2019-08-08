FROM openjdk:8
MAINTAINER Radiant Digital
ADD target/*.jar /msa-auth-service.jar
RUN bash -c 'touch /msa-auth-service.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-auth-service.jar"]
EXPOSE 9080
