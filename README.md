# spring-boot-coding-styles

## Background
A sample Spring Boot application to compare different coding styles.

## Prerequisites
- Java 17

## Running Application
Run the command in the root of the project.
### Windows
```bash
gradlew.bat bootRun
 ```
### Linux
```bash
./gradlew bootRun
```

## OpenAPI/Swagger UI
The OpenAPI/Swagger UI can be found at the following link:
http://localhost:9080/actuator/swagger-ui/index.html

All documentation about testing the application is found here.

## Database
The system uses an H2 in memory database that can be accessed at the following URL:  
http://localhost:8080/h2-console
The following details can be used to access the database:

**Driver Class:** org.h2.Driver  
**JDBC URL:** jdbc:h2:mem:testdb  
**User Name:** sa  
**Password:** 

## Coding Styles

### Step 1

This code example uses the coding styles used in most Spring Boot tuturials and should be familiar to most Spring Boot developers. 
This is a good starting point for our comparisons as we are familiar with this coding style.

This code branch has a total of 11 Java code files and 224 lines of Java code excluding blank lines.

### Step 2

The first improvement I would look for is the removal of unneccesary interfaces.
Many Spring Boot developers avoid these by default, so it is a good starting point, but it is a topic worth discussing.

I can think of 3 reasons why we would use interfaces in Java:

    1. When we use the interface as the contract between two teams or modules either in a monolith or using some RPC mechanism.
       In this scenario one team would implement the interface and play the role of the server.
       The other team will call the interface and play the role of the client.
       In this case I would put the interface in a separate package or module where both teams can access it.
       Any changes in this interface would have to be negotiated and agreed to by both teams.
    2. When there are multiple implementations of the interface.
       For example, if we are building a software product that can work with an Oracle Database and a Postgress database
       we might want to have 2 implementations of a Data Access Object (DAO) interface, one for each database.
       This usage of interfaces can largely be avoided by using modern object-relational mapping technologies susch as
       JPA and/or Spring Data.
       Also when building software for enterprises and not as prooducts this type of flexibility is hardly ever required.
    3. When unit testing a layeded application, injecting an interface of the layer below instead of a concrete class makes it
       possible for the unit test to code to inject a mock implementation of the interface instead of the real implementation.
       This problem has largely been solved by technologies such as Mockito, which has not issue mocking a concrete class for unit testing.

In our application we only have one such unneccesary interface i.e. PersonService, so lets remove it.

This code branch has a total of 10 Java code files and 212 lines of Java code excluding blank lines.