# Match Odds REST API

This project is a Spring Boot REST API for managing matches and their betting odds.

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger (OpenAPI)
- Docker

## Project Structure

Controller → Service → Repository → Entity → Database

## API Endpoints

### Match

POST /matches  
GET /matches  
GET /matches/{id}  
PUT /matches/{id}  
DELETE /matches/{id}

### MatchOdds

POST /odds  
GET /odds  
GET /odds/{id}  
PUT /odds/{id}  
DELETE /odds/{id}

## API Documentation

Swagger UI available at:

http://localhost:8080/swagger-ui.html

Word documentation with Screenshots available at:

https://github.com/TasoulasTheofanis/match-odds-rest-api/tree/main/documentation


## Running the Application

### Option 1 – Run locally

.\mvnw spring-boot:run


### Option 2 – Run with Docker


docker compose up --build


Then open:


http://localhost:8080/swagger-ui.html


## Database

PostgreSQL database:


match_odds_db


Tables:

- matches
- match_odds
