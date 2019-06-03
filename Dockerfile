FROM openjdk:8-jdk
ADD target/HotelApplication-0.0.1-SNAPSHOT.jar HotelApplication-0.0.1-SNAPSHOT.jar
RUN sh -c 'touch /HotelApplication-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://spring-demo-mongo/HotelDb","-Djava.security.egd=file:/dev/./urandom","-jar","/HotelApplication-0.0.1-SNAPSHOT.jar"]