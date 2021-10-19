FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/yannitech-0.0.1-SNAPSHOT.jar yannitech.jar
ENTRYPOINT ["java","-jar","app.jar"]
