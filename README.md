# 🚀 Course Management System (Microservices Architecture)

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.6-brightgreen)
![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-2022.0.4-important)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)
![Docker](https://img.shields.io/badge/Docker-24.0.5-9cf)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-%E2%98%85-white)

**An enterprise-grade microservices system for university course management with distributed architecture**

## 🔥 Core Features

### 🌉 **API Gateway Service**
- **Spring Cloud Gateway** routing with load balancing (Round Robin/Weighted)
- **JWT Authentication** with OAuth2 resource server
- Rate limiting (10 req/sec per service)
- Request/Response modification using custom filters
- Circuit breaker pattern integration

### 🎛️ **Service Registry**
- **Eureka Server** implementation
- Health-check monitoring dashboard
- Zone-aware service registration
- Heartbeat mechanism (30s intervals)
- Self-preservation mode configuration

### 📚 **Course Service**
- CRUD operations for courses with **Hibernate Validations**
- MySQL 8.0 persistence with **Spring Data JPA**
- **Redis** caching for frequent course catalog access
- Event-driven architecture using **Apache Kafka** (course_update topic)
- Distributed tracing with **Micrometer** + **Zipkin**

### 🧑🎓 **Student Service**
- Student enrollment management system
- **Many-to-Many** relationship with courses
- **Spring Security** RBAC implementation
- **Flyway** database migrations
- Integration tests with **Testcontainers**

## 🛠️ Tech Stack Deep Dive

| Component          | Technology Stack                                                                 |
|---------------------|----------------------------------------------------------------------------------|
| **API Gateway**     | Spring Cloud Gateway, Resilience4j, Spring Security OAuth2, Micrometer Tracing   |
| **Service Registry**| Netflix Eureka Server, Spring Boot Actuator, Spring Cloud Config                 |
| **Database**        | MySQL 8 (ACID compliance), Redis 7 (LRU caching), HikariCP connection pooling    |
| **Messaging**       | Apache Kafka 3.4 (Event sourcing), Schema Registry (Avro), Kafka Streams         |
| **CI/CD**           | GitHub Actions (Java CI), Docker Hub automated builds, Maven Wrapper             |
| **Monitoring**      | Prometheus metrics endpoint, Grafana dashboards, Sleuth for request correlation  |

## 📐 System Architecture

```plaintext
                            +-----------------+
                            |   Web/Mobile    |
                            |     Clients     |
                            +--------+--------+
                                     |
                                     | HTTPS
                            +--------v--------+
                            |   API Gateway   |
                            | (Spring Cloud)  |
                            +--------+--------+
                                     |
                     +---------------+---------------+
                     |               |               |
               +-----v-----+   +-----v-----+   +-----v-----+
               |  Course   |   |  Student  |   |  Auth     |
               | Service   |   |  Service  |   |  Service  |
               +-----------+   +-----------+   +-----------+
                     |               |               |
               +-----v-----+   +-----v-----+   +-----v-----+
               | MySQL 8   |   | MySQL 8   |   |  Redis    |
               | (Courses) |   | (Students)|   | (Sessions)|
               +-----------+   +-----------+   +-----------+
                     |
               +-----v-----+
               |  Kafka    |
               | Event Bus |
               +-----------+
