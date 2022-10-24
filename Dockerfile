FROM openjdk:11
VOLUME /tmp
EXPOSE 8000
ADD ./target/CustomerProduct-0.0.1-SNAPSHOT.jar CustomerProduct.jar
ENTRYPOINT ["java","-jar","/CustomerProduct.jar"]