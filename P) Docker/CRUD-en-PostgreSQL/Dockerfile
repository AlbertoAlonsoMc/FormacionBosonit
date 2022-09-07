FROM openjdk:17-oracle
COPY /target/*.jar /usr/local/lib/spring.jar
ENTRYPOINT ["java", "-jar", "/usr/local/lib/spring.jar"]