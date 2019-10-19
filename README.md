# Spring demo project (mvc, jpa, flyaway) & Angular front 

#### requirements:
java 8, maven, MySql.

#### build
`mvn clean package`

#### run
`docker-compose up` (run MySql)  
 
`mvn spring-boot:run` or `java -jar target/book-api.war`

also you can rename `book-api.war` to `ROOT.war` and deploy to Tomcat 8 

### documentation

Domain model:
* Book

Page:
* / -> index

Rest apis:
* /api/book GET POST
* /api/book/{id} GET PUT DELETE
