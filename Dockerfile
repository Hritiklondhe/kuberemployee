FROM openjdk:17
COPY build/libs/employeeapp-0.0.1-SNAPSHOT.jar /app/employeeapp-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "employeeapp-0.0.1-SNAPSHOT.jar"]

