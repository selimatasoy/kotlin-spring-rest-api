# kotlin-spring-rest-api
A Modern Kotlin-Spring RESTful API example. Connects to a PostgreSQL database and uses Exposed framework for database
operations. Focused on Clean Architecture, SOLID Principles and feature based development.

- Spring Framework
- Kotlin
- Authorization -> JWT
- Database -> PostgreSQL
- ORM SQL Framework -> Exposed
- Ktor Client -> For External API calls
- Build Tool -> Gradle
- Server -> Tomcat
- API Documentation -> Swagger

# Architecture

![github (7)](https://user-images.githubusercontent.com/86873858/132682784-aa98f8e3-5604-4563-a8e6-d8126a1d1aa3.png)

# Database Credentials

resources/application.conf

```
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/{$your_db_name}
spring.datasource.username={$your_username}
spring.datasource.password={$your_password}
```

# API Doc

## - Swagger

You can access it via http://localhost:{$PORT(8080 default)}/swagger-ui/

# Features

## - Health Check

GET /api/v1/healthCheck</br>
&nbsp; Just returns a simple object</br>

## - Authentication

POST /api/v1/createUser</br>
&nbsp; Registers a user to the db</br>
POST /api/v1/login</br>
&nbsp; Returns a jwt token if success</br>
GET /api/v1/userInfo (Needs Authroization token from login as Authorization header)</br>
&nbsp; Return user information</br>
## - Star Wars

GET /api/v1/movie (Needs Authroization token from login as Authorization header)</br>
&nbsp; An External API call example. Returns a movie information from an external api
