FROM eclipse-temurin:21
COPY target/FleetFlow-0.0.1-SNAPSHOT.jar FleetFlow-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/FleetFlow-0.0.1-SNAPSHOT.jar"]