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