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
spring.datasource.url=jdbc:postgresql://localhost:5432/$YOUR_DB_NAME"
spring.datasource.username="$YOUR_USERNAME"
spring.datasource.password="$YOUR_PASSWORD"
```

# API Doc

## - Swagger

You can access it via http://localhost:$PORT(8080 default)/swagger-ui/

# Features

## - Health Check

**GET /public-api/v1/healthCheck**</br>
&nbsp; Just returns a simple string</br>

## - Authentication

**POST /public-api/v1/authentication/createUser**</br>
&nbsp; Registers a user to the db</br>
**POST /public-api/v1/authentication/login**</br>
&nbsp; Returns a jwt token if success</br>
**GET /api/v1/authentication/userInfo** (Needs Authorization token from login as Authorization header : "Bearer
{$token}")</br>
&nbsp; Returns the user information</br>
## - Star Wars

**GET /api/v1/star-wars/movie** (Needs Authorization token from login as Authorization header : "Bearer {$token}")</br>
&nbsp; An External API call example. Returns a movie information from an external api
