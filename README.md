# 📊 ProManageScheduler

A Java-based project scheduling system that manages and prioritizes projects based on deadlines, revenue, and workload.

---

## 🚀 Features

- Add and manage projects
- Automatic weekly scheduling
- Priority-based execution
- Tracks project progress and status
- Uses MySQL database with JDBC

---

## 🧠 Scheduling Logic

Projects are prioritized using:

Score = (revenue / totalDays) + (1 / deadlineDays) + (1 / arrivalWeek)

Higher score → Higher priority

---

## 🏗️ Project Structure

src/
- dao/
- model/
- service/
- db/
- Main.java

---

## 🗄️ Database Schema

CREATE TABLE projects (
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(255),
total_days INT,
completed_days INT,
deadline_days INT,
revenue INT,
penalty_per_day INT,
status VARCHAR(50),
arrival_week INT,
completion_week INT
);

---

## ▶️ How to Run

1. Open project in IntelliJ
2. Setup MySQL database
3. Update DBConnection.java
4. Run Main.java

---

## 🛠️ Tech Stack

- Java
- MySQL
- JDBC

---

## 👨‍💻 Author

- Tanmay Kumar