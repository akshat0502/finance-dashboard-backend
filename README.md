
### 🔹 Financial Records Management

* Create financial records (income/expense)
* Fetch all records
* Filter records by:


---

### 🔹 Dashboard Analytics

* Total Income
* Total Expense
* Net Balance
* Category-wise totals

---

### 🔹 Backend Capabilities

* RESTful API design
* Layered architecture (Controller → Service → Repository)
* DTO-based request handling
* Data validation
* JPA/Hibernate integration
* In-memory H2 database (for development)

---

## 🛠 Tech Stack

* **Java 17 / 21**
* **Spring Boot**
* **Spring Data JPA (Hibernate)**
* **H2 Database**
* **Maven**
* **Lombok**

---

## 📂 Project Structure

```
com.finance.dashboard
│
├── controller       # API endpoints
├── service          # Business logic
├── repository       # Database access
├── entity           # Database models
├── dto              # Request/Response models
└── FinanceDashboardApplication.java
```

---

## ⚙️ Setup & Run

### 1️⃣ Clone Repository

```
git clone <your-repo-url>
cd finance-dashboard
```

---

### 2️⃣ Run Application

```
./mvnw spring-boot:run
```

---

### 3️⃣ Access Application

```
http://localhost:8080
```

---

### 4️⃣ H2 Database Console

```
http://localhost:8080/h2-console
```

**JDBC URL:** `jdbc:h2:mem:testdb`
**Username:** `sa`
**Password:** *(empty)*

---

## 📌 API Endpoints

---

### 🔹 Create Record

```
POST /records
```

**Request Body:**

```json
{
  "amount": 5000,
  "type": "INCOME",
  "category": "Salary",
  "notes": "April salary"
}
```

---

### 🔹 Get All / Filter Records

```
GET /records
GET /records?type=INCOME
GET /records?category=Food
GET /records?startDate=2026-01-01&endDate=2026-12-31
```

---

### 🔹 Dashboard Summary

```
GET /dashboard/summary
```

**Response:**

```json
{
  "totalIncome": 5000,
  "totalExpense": 2000,
  "netBalance": 3000
}
```

---

### 🔹 Category-wise Totals

```
GET /dashboard/category-wise
```

**Response:**

```json
{
  "Salary": 5000,
  "Food": 2000
}
```

---

## 🧠 Design Decisions

* Used layered architecture for maintainability
* DTOs used to separate API layer from entities
* Aggregation handled via JPQL queries
* Optional query parameters for flexible filtering
* Null-safe handling for aggregation queries

---

## ⚠️ Assumptions

* Authentication is not implemented (can be added via JWT)
* Single-user system (no user-based ownership yet)
* In-memory DB used for simplicity

---

## 🔮 Future Enhancements

* JWT Authentication & Role-based Access Control
* User management (Admin / Analyst / Viewer)
* Pagination & sorting
* Monthly trends analytics
* Swagger/OpenAPI documentation
* MySQL/PostgreSQL integration

---

## 👨‍💻 Author

**Akshat Saxena**

* GitHub: https://github.com/akshat0502
* LinkedIn: https://linkedin.com/in/akshat0502

---

## ⭐ If you like this project

Give it a ⭐ on GitHub and feel free to fork!
