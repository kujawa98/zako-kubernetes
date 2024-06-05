FROM openjdk:17-oracle
COPY target/zako-kubernetes-0.0.1-SNAPSHOT.jar zako.jar
ENTRYPOINT ["java","-jar","/zako.jar"]