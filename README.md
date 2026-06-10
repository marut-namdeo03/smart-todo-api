# 🚀 Smart TODO List API

A backend project built using Spring Boot that provides REST APIs to manage tasks efficiently with smart features like automatic overdue detection.

---

## 📌 Features

* ✅ Create, Read, Update, Delete tasks
* 🔍 Filter tasks by **priority** and **status**
* 📄 Pagination & sorting support
* 🧠 Automatic **overdue detection** based on due date
* ⚠️ Global exception handling

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

## 📂 Project Structure

com.todo.smarttodo
├── controller
├── service
├── repository
├── entity
├── exception

---

## 🔗 API Endpoints

### 🔹 Create Task

POST /tasks

### 🔹 Get All Tasks (with pagination)

GET /tasks?page=0&size=5&sort=dueDate,asc

### 🔹 Get Task by ID

GET /tasks/{id}

### 🔹 Update Task

PUT /tasks/{id}

### 🔹 Delete Task

DELETE /tasks/{id}

### 🔹 Filter by Priority

GET /tasks/priority/{priority}

### 🔹 Filter by Status

GET /tasks/status/{status}

---

## 🧠 Smart Logic

Tasks are automatically marked as **OVERDUE** if their due date is before the current date.

This logic is applied:

* During task creation and update
* Dynamically while fetching tasks

---

## ⚠️ Exception Handling

Implemented using `@RestControllerAdvice` to return clean and meaningful error responses.

---

## ▶️ How to Run

1. Clone the repository
2. Configure MySQL database in `application.properties`
3. Run the Spring Boot application
4. Test APIs using Postman

---

## 📸 Sample Request

```json
{
  "title": "Learn Spring Boot",
  "description": "Build REST APIs",
  "priority": "HIGH",
  "dueDate": "2026-05-01"
}
```

---

## 🎯 Learning Outcome

This project helped in understanding:

* REST API design
* Service layer architecture
* Pagination & sorting
* Time-based business logic
* Exception handling in Spring Boot

---

## 📬 Author

Marut Kumar Namdeo

Aspiring Backend Developer (Java | Spring Boot)

---
