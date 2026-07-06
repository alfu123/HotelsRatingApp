# Hotel Rating Microservices System

A Spring Boot Microservices-based Hotel Rating application developed using Spring Cloud. The project demonstrates microservice architecture, service discovery, API Gateway, centralized configuration, distributed communication, fault tolerance, and OAuth2/JWT-based security.

---

## Project Overview

This project consists of three independent microservices:

- **User Service** – Manages user information and aggregates hotel and rating data.
- **Hotel Service** – Manages hotel details.
- **Rating Service** – Stores and retrieves ratings provided by users for hotels.

The services communicate using REST APIs through Spring Cloud infrastructure.

---

## Microservices

| Service | Port | Description |
|---------|------|-------------|
| User Service | 8084 | User Management |
| Hotel Service | 8085 | Hotel Management |
| Rating Service | 8086 | Rating Management |

---

## Tech Stack

### Backend

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Spring Security
- OAuth2 Resource Server
- JWT Authentication

### Spring Cloud

- Eureka Server
- API Gateway
- Config Server
- OpenFeign Client

### Resilience

- Resilience4J
    - Circuit Breaker
    - Rate Limiter

### Database

- MySQL

### Build Tool

- Maven

---

## Architecture

```
                    Client
                       │
                       ▼
                API Gateway
                       │
        ┌──────────────┼──────────────┐
        │              │              │
        ▼              ▼              ▼
 User Service     Hotel Service   Rating Service
   (8084)            (8085)           (8086)
        │                 ▲
        └────Feign────────┘
              │
              ▼
       REST Communication

              Eureka Server
      (Service Discovery)

            Config Server
   (Centralized Configuration)
```

---

## Features

### User Service

- Create User
- Get User by Id
- Get All Users
- Fetch associated Ratings
- Fetch Hotel Details
- Circuit Breaker
- Rate Limiter
- Fallback Response

---

### Hotel Service

- Create Hotel
- Get Hotel by Id
- Get All Hotels

---

### Rating Service

- Create Rating
- Get Ratings by User
- Get Ratings by Hotel
- Get All Ratings

---

## Fault Tolerance

Implemented using **Resilience4J**

### Circuit Breaker

If Hotel Service or Rating Service becomes unavailable, User Service returns a fallback response instead of failing.

Example fallback response:

```json
{
    "userId":"14235",
    "name":"dummy",
    "email":"dummy@gmail.com",
    "about":"User is dummy because some services are down"
}
```

---

### Rate Limiter

Protects the User Service from excessive requests.

---

## Security

Implemented using Spring Security OAuth2 Resource Server with JWT Authentication.

### Authorization Rules

### Hotel Service

| Endpoint | Access |
|-----------|--------|
| POST /hotels | Admin |
| GET /hotels | Admin, Internal |
| GET /hotels/{id} | Internal |

---

### Rating Service

| Endpoint | Access |
|-----------|--------|
| POST /ratings | Admin |
| GET /ratings | Admin, Internal |
| GET /ratings/users/{id} | Admin, Internal |
| GET /ratings/hotels/{id} | Public |

---

## REST APIs

### User Service

| Method | Endpoint |
|---------|----------|
| POST | /users |
| GET | /users |
| GET | /users/{userId} |

---

### Hotel Service

| Method | Endpoint |
|---------|----------|
| POST | /hotels |
| GET | /hotels |
| GET | /hotels/{hotelId} |

---

### Rating Service

| Method | Endpoint |
|---------|----------|
| POST | /ratings |
| GET | /ratings |
| GET | /ratings/users/{userId} |
| GET | /ratings/hotels/{hotelId} |

---

## Communication

- REST APIs
- OpenFeign Client
- Service Discovery using Eureka

---

## Project Structure

```
Hotel-Rating-Microservices

│── User-Service
│── Hotel-Service
│── Rating-Service
│── API-Gateway
│── Config-Server
│── Eureka-Server
```

---

## How to Run

### Clone Repository

```bash
git clone https://github.com/yourusername/Hotel-Rating-Microservices.git
```

### Start Services

Start the services in the following order:

1. Config Server
2. Eureka Server
3. API Gateway
4. Hotel Service
5. Rating Service
6. User Service

---

## Future Improvements

- Docker Support
- Kubernetes Deployment
- Distributed Tracing
- Kafka Event Streaming
- Monitoring with Prometheus & Grafana
- CI/CD using Jenkins or GitHub Actions

---

## Learning Outcomes

- Microservices Architecture
- Spring Cloud
- OpenFeign
- API Gateway
- Eureka Service Discovery
- Centralized Configuration
- OAuth2 & JWT Security
- Circuit Breaker Pattern
- Rate Limiting
- RESTful API Design
- Fault Tolerant Systems

---

## Author

**Alfahad Ansari**

M.Tech Artificial Intelligence | MANIT Bhopal

Java Backend Developer | Spring Boot | Microservices | AI
