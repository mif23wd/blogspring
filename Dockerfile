FROM openjdk:8
EXPOSE 8080
ADD target/BlogSpringProject.jar BlogSpringProject.jar
ENTRYPOINT ["java",".jar","/BlogSpringProject.jar"]