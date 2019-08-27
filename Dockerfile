FROM maven:3.6.1-jdk-8

COPY . /usr/app/

WORKDIR /usr/app

RUN mvn package

CMD ["java", "-jar", "target/aggregator-0.0.1-SNAPSHOT.jar"]