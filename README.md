# 📚 Attendance Management System

A web-based Attendance Management System developed using Java (Servlet & JSP), Maven, MySQL, and Apache Tomcat.

---

## 🚀 Features

- 🔐 Teacher Login Authentication
- 📝 Mark Student Attendance
- 📊 View Attendance Reports
- 👨‍🎓 Manage Students
- 🔄 Session Handling & Logout
- 🎨 Clean UI with CSS Styling

---

## 🛠 Technologies Used

- Java 11
- JSP & Servlets
- Maven (WAR packaging)
- MySQL Database
- Apache Tomcat 9
- HTML & CSS

---

## 📂 Project Structure
AttendanceApp
│
├── src/main/java/com/attendance
│ ├── LoginServlet.java
│ ├── LogoutServlet.java
│ ├── MarkAttendanceServlet.java
│ ├── ReportServlet.java
│ ├── StudentServlet.java
│ ├── AttendanceDAO.java
│ ├── DBUtil.java
│ ├── Teacher.java
│ └── Student.java
│
├── src/main/webapp
│ ├── css/style.css
│ ├── login.jsp
│ ├── dashboard.jsp
│ ├── mark.jsp
│ ├── report.jsp
│ ├── students.jsp
│ └── WEB-INF/web.xml
│
├── pom.xml
└── .gitignore


---

## 🗄 Database Configuration

Create database in MySQL:

```sql
CREATE DATABASE attendance_db;
USE attendance_db;

Create teacher table:

CREATE TABLE teacher (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    fullname VARCHAR(100)
);

Insert sample teacher:

INSERT INTO teacher (username, password, fullname)
VALUES ('teacher1', '1234', 'M. Neelanaik');

Create students table:

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    roll_no INT,
    name VARCHAR(100)
);

Create attendance table:

CREATE TABLE attendance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    subject VARCHAR(100),
    date DATE,
    status VARCHAR(20)
);
