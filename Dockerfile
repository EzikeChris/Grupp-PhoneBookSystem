FROM openjdk:17-alpine
ADD build/libs/*.jar phonebooksystem.jar
ENTRYPOINT ["java", "-jar", "/phonebooksystem.jar"]