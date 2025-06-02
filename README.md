# 📦 DocuVault – Secure Document Storage & Access System

A RESTful Spring Boot backend for **securely uploading, categorizing, and retrieving personal documents** like certificates, IDs, receipts, etc. This system enables structured storage with metadata, tagging, and access control.

---

## 🔐 Real-World Problem

People often lose or misplace important digital documents. **DocuVault** serves as a secure backend vault for organizing and managing these files, making them easily retrievable and well-categorized.

---

## 🚀 Features

* User registration and login (optional advanced feature)
* Upload personal documents with metadata
* Categorize and tag documents
* Retrieve, search, and delete uploaded documents
* Filter documents by tag and category

---

## 📄 Document Entity

```java
Long id;
String name;             // e.g., "Passport", "Marksheet"
String type;             // PDF, DOCX, etc.
String category;         // e.g., Education, Finance, Identity
String tags;             // Comma-separated or list (e.g., ["govt", "official"])
LocalDate uploadDate;
String downloadUrl;      // Simulated path or AWS S3 link (future scope)
User user;               // Reference to the uploader
```

---

## 🔧 REST API Endpoints

| Method | Endpoint                               | Description                              |
| ------ | -------------------------------------- | ---------------------------------------- |
| POST   | `/api/backend/documents`               | Upload a document (metadata + file path) |
| GET    | `/api/backend/documents`               | List all documents                       |
| GET    | `/api/backend/documents/{id}`          | View document details                    |
| DELETE | `/api/backend/documents/{id}`          | Delete a document                        |
|        |                                        |                                          |
| GET    | `/api/backend/documents/user/{userId}` | Get all docs uploaded by a specific user |

---

## 📁 Project Structure

```
com.docuvault
├── controller          # REST Controllers
├── service             # Business Logic Layer
├── model               # JPA Entities
├── repository          # Spring Data JPA Repositories
├── dto                 # Data Transfer Objects
├── exception           # Custom Exceptions
└── DocuVaultApplication.java
```

---

## ✅ Tech Stack

* Java 17+
* Spring Boot 3+
* Spring Data JPA
* PostgreSQL (or other DBs)
* Lombok
* Optional: Spring Security (for login/registration)

---

## 📈 Future Enhancements

* Integrate with AWS S3 for real file upload support
* Add JWT-based authentication
* Enable file previews/downloads
* Add role-based access control (admin/user)

---

## 🚧 Setup & Run

1. Clone the repo:

   ```bash
   git clone https://github.com/your-username/docuvault.git
   ```
2. Open in your favorite IDE (e.g., IntelliJ, VS Code)
3. Configure your PostgreSQL DB in `application.properties`
4. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

---

## 🌟 Author

**Harshit Varshney**
*Java FullStack Engineer | Spring Boot Developer | C++ Enthusiast | React Developer*
---

---

> ✨ "Securely Vault Every Document, Forever!" ✨
