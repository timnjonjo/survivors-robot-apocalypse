FROM  fabric8/java-alpine-openjdk11-jre
#fabric8/java-alpine-openjdk11-jre
LABEL maintainer="timnjonjo@gmail.com"
RUN apk add --no-cache bash
EXPOSE 8080
ADD target/*.jar  robot-apocalypse.jar
ENTRYPOINT ["java","-Xmx256m","-jar","/robot-apocalypse.jar"]
