#start with a base image containing java runtime

FROM openjdk:17-alpine

# information around who mantains the image
MAINTAINER mrdiipo.com

#apps jar path
COPY target/Accounts_Microservice-0.0.1-SNAPSHOT.jar Accounts_Microservice-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java", "-jar", "/Accounts_Microservice-0.0.1-SNAPSHOT.jar"]