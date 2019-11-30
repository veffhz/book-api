# BUILD
FROM parrotstream/centos-openjdk:8 AS MAVEN_IMAGE
ENV BUILD_DIR=/tmp/service
RUN mkdir -p $BUILD_DIR

WORKDIR $BUILD_DIR

COPY ./mvnw $BUILD_DIR/
COPY ./.mvn $BUILD_DIR/.mvn

COPY ./pom.xml $BUILD_DIR/
COPY ./src $BUILD_DIR/src

RUN ./mvnw package


# RUN
FROM parrotstream/centos-openjdk:8

ENV PROJECT_DIR=/opt/service
RUN mkdir -p $PROJECT_DIR

WORKDIR $PROJECT_DIR

COPY --from=MAVEN_IMAGE /tmp/service/target/book-api.war $PROJECT_DIR/book-api.war

EXPOSE 8080

CMD ["java", "-jar", "book-api.war"]