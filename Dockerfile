FROM debian:buster

RUN apt-get update && \
 apt-get -y upgrade && \
 apt-get -y update

RUN apt-cache search openjdk

RUN apt-get -y install openjdk-11-jre

RUN useradd spring
RUN mkdir /home/spring && chown spring:spring /home/spring
RUN usermod -d /home/spring spring
RUN usermod -aG spring spring
USER spring:spring

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar


ENTRYPOINT ["java","-jar","/app.jar"]

