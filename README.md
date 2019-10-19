# Spring demo project (mvc, jpa, flyaway) + embedded Angular front 

#### requirements:
java 8, maven, mySql.

#### build
`mvn clean package`

#### run
docker-compose up (mySql setUp)  
 
`mvn spring-boot:run` or `java -jar target/book-api.war`

also you can rename `book-api.war` to `ROOT.war` and deploy to Tomcat 8 

### documentation

Domain model:
* Book

Page:
* / -> home

Rest apis:
* /api/book GET POST
* /api/book/{fieldId} GET PUT DELETE