FROM anapsix/alpine-java
MAINTAINER myNAME
COPY /target/data-generator-management-tool-1.0-SNAPSHOT-jar-with-dependencies.jar /home/testprj-1.0-SNAPSHOT.jar
CMD ["java","-jar","/home/testprj-1.0-SNAPSHOT.jar"]

FROM docker.elastic.co/beats/filebeat:6.6.2
COPY filebeat.yml /usr/share/filebeat/filebeat.yml
USER root
RUN chown root:filebeat /usr/share/filebeat/filebeat.yml
USER filebeat