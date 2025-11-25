<<<<<<< HEAD
# 💰 Midas Core - Financial Transaction System

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-green?style=for-the-badge&logo=spring&logoColor=white)
![Kafka](https://img.shields.io/badge/Apache_Kafka-Messaging-black?style=for-the-badge&logo=apachekafka&logoColor=white)
![Database](https://img.shields.io/badge/H2-In--Memory-blue?style=for-the-badge&logo=h2&logoColor=white)

**Midas Core** is the central transaction processing engine for the Midas Financial System. It is designed to handle high-volume financial transactions with real-time validation, external incentivization, and secure persistence.

This project was built as part of the **JP Morgan Chase Software Engineering Virtual Experience** on Forage.

---

## 🚀 Architecture & Workflow

The system follows a microservices-style architecture using Spring Boot.

1.  **Ingestion:** Listens for incoming transactions via **Kafka** (or REST API for testing).
2.  **Validation:** `TransactionService` ensures business rules (e.g., positive amounts, valid user IDs).
3.  **Persistence:** Valid transactions are saved to an **H2 SQL Database** with a `PENDING` status.
4.  **Incentivization:** A synchronous REST call is made to an external **Incentive API** to reward users.
5.  **Finalization:** Upon success, the transaction status is updated to `COMPLETED`.

---

## 🛠️ Tech Stack

* **Core Framework:** Spring Boot (Web, Data JPA)
* **Language:** Java 17
* **Messaging:** Apache Kafka (Consumer)
* **Database:** H2 In-Memory Database (SQL)
* **API Client:** Spring RestTemplate
* **Build Tool:** Maven

---

## ⚙️ Setup & Installation

### Prerequisites
* Java 17 or higher
* Maven (or use the included `mvnw` wrapper)

### Running the Application
1.  Clone the repository:
    ```bash
    git clone [https://github.com/KrushnaG-03/Midas-core.git](https://github.com/KrushnaG-03/Midas-core.git)
    ```
2.  Navigate to the project directory:
    ```bash
    cd Midas-core
    ```
3.  Build and Run:
    ```bash
    ./mvnw spring-boot:run
    ```
    *(Note: Ensure `application.properties` is configured correctly in the project root).*

---

## 🧪 API Usage

You can interact with Midas Core using the built-in REST Controller.

### 1. Check System Status
**GET** `/midas/test`
```bash
curl http://localhost:8080/midas/test
=======
💰 Midas Core - Financial Transaction System
Midas Core is the central transaction processing engine for the Midas Financial System. It is designed to handle high-volume financial transactions with real-time validation, external incentivization, and secure persistence.

This project was built as part of the JP Morgan Chase Software Engineering Virtual Experience on Forage.

🚀 Architecture & Workflow
The system follows a microservices-style architecture using Spring Boot.

Ingestion: Listens for incoming transactions via Kafka (or REST API for testing).

Validation: TransactionService ensures business rules (e.g., positive amounts, valid user IDs).

Persistence: Valid transactions are saved to an H2 SQL Database with a PENDING status.

Incentivization: A synchronous REST call is made to an external Incentive API to reward users.

Finalization: Upon success, the transaction status is updated to COMPLETED.

🛠️ Tech Stack
Core Framework: Spring Boot (Web, Data JPA)

Language: Java 17

Messaging: Apache Kafka (Consumer)

Database: H2 In-Memory Database (SQL)

API Client: Spring RestTemplate

Build Tool: Maven

⚙️ Setup & Installation
Prerequisites
Java 17 or higher

Maven (or use the included mvnw wrapper)

Running the Application
Clone the repository:

Bash

git clone https://github.com/KrushnaG-03/Midas-core.git
Navigate to the project directory:

Bash

cd Midas-core
Build and Run:

Bash

./mvnw spring-boot:run
(Note: Ensure application.properties is configured correctly in the project root).

🧪 API Usage
You can interact with Midas Core using the built-in REST Controller.

1. Check System Status
GET /midas/test

Bash

curl http://localhost:8080/midas/test
Response: Midas Core is Running!

2. Create a Transaction
POST /midas/create

Body:

JSON

{
  "senderId": 101,
  "recipientId": 202,
  "amount": 500.0
}
Example Command:

Bash

curl -X POST http://localhost:8080/midas/create \
     -H "Content-Type: application/json" \
     -d '{"senderId":101, "recipientId":202, "amount":500.0}'
📂 Project Structure
Plaintext

src/main/java/com/midas/core
├── config          # App Configuration (RestTemplate)
├── controller      # REST API Endpoints
├── kafka           # Kafka Consumer Logic
├── model           # JPA Entities (Transaction)
├── repository      # Database Interfaces
└── service         # Business Logic & External Calls
## 📜 License
This project is open-source and available under the [MIT License](LICENSE).