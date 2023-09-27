FROM jenkins/jenkins:latest-jdk11

USER root

RUN apt-get install

USER jenkins