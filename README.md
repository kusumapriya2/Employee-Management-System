# Employee-Management-System
Overview
The Employee Management System (EMS) is a Spring Boot application that allows users to manage employee records, including creating, reading, updating, and deleting (CRUD) employee details. The system also includes authentication features, allowing users to sign up and log in securely.

Features
✅ User Authentication (Signup & Login)
✅ Add new employees
✅ View employee details
✅ Update employee records
✅ Delete employees

Technologies Used
IDE: Spring Tool Suite (STS)
Backend: Spring Boot, Spring MVC, Spring Data JPA
Database: MySQL 
Frontend: HTML/CSS, Javascript
Installation & Setup
Prerequisites
Install STS (Spring Tool Suite)
Install MySQL Server
Java JDK 17+ installed
Maven installed
Postman (for API testing)
Steps to Set Up
1. Clone the Repository
git clone https://github.com/your-repo/employee-management-system.git
cd employee-management-system
2. Configure the Database
Open application.properties or application.yml and update your database settings:
application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
3. Run the Application
Open STS, import the project, and run the EmployeeManagementApplication.java file.
