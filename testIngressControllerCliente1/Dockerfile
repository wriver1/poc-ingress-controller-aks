FROM openjdk:13-jdk-alpine

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

VOLUME /tmp

COPY maven /target/

CMD ["java", "-XX:TieredStopAtLevel=1", "-XX:+UnlockExperimentalVMOptions", "-XshowSettings:vm", "-Dspring.backgroundpreinitializer.ignore=true", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/target/testIngressControllerCliente1-0.0.1.jar"]
