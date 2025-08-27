# 🏥 Patient Management — Microservices (Spring Boot 3 + Kafka) → AWS ECS

A production-ready, containerized **microservices** system for patient management, built with **Spring Boot 3**, **Apache Kafka** (event-driven), and deployed on **AWS ECS** (Fargate or EC2 launch type).

---

## ✨ Features

- Patient CRUD, appointments, notifications
- **Event-driven** with Kafka (publish/subscribe)
- API Gateway entrypoint; optional service discovery
- Dockerized services; deployable to **AWS ECS**
- Observability with **Spring Boot Actuator**
- CI/CD ready (example provided)

---

## 🧱 Architecture

```mermaid
flowchart LR
  Client -->|HTTP| API_Gateway
  API_Gateway --> Patient_Service
  API_Gateway --> Appointment_Service
  Patient_Service -->|Publish patient.events| Kafka[(Kafka)]
  Billing Service -->|Consume patient.events| Kafka
  Notification_Service -->|Consume appointment.events| Kafka
  subgraph AWS ECS Cluster
    API_Gateway
    Patient_Service
    Appointment_Service
    Notification_Service
  end
