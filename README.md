# kotlin-spring-rest-api
A Modern Kotlin-Spring RESTful API example. Connects to a PostgreSQL database and uses Exposed framework for database operations. Focused on Clean Architecture, SOLID Principles and feautre based development.

- Spring Framework
- Kotlin
- (WIP) Authorization -> JWT
- Database -> PostgreSQL
- ORM SQL Framework -> Exposed
- Ktor Client -> For External API calls
- Build Tool -> Gradle
- Server -> Tomcat

# Architecture


# Database Creditentials
resources/application.conf
```
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/exampleDatabase
spring.datasource.username=postgres
spring.datasource.password=Test1234
```
# Features
## - Health Check
GET /healthCheck/</br>
 &nbsp; Just returns a simple object</br>
## - Authentication
POST /createUser/</br>
 &nbsp; Registers a user to the db</br>
POST /login/</br>
 &nbsp; Returns a jwt token if success</br>
GET /userInfo/ (Needs Authroization token from login as Authorization header)</br>
 &nbsp; Return user information</br>
## - Star Wars
GET /movie/ (Needs Authroization token from login as Authorization header)</br>
 &nbsp; An External API call example. Returns a movie information from an external api
