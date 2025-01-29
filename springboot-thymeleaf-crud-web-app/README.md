# Employee Management System

## App Concept and Purpose

The **Employee Management System** is a web application designed to help manage employee information efficiently. Users will be able to **add, view, update, and delete** employee records. It also provides **user authentication** to ensure that only authorized personnel can access and manage employee data.

The application is built with **Spring Boot** for the backend, **Thymeleaf** for rendering views, and **MySQL** for storing employee and user data. It allows easy management of employee data through a user-friendly interface.

### **App Development Strategy:**
- We will develop the application step-by-step starting with **user authentication** (Login and Registration).
- Next, we will implement the **employee management system** with **CRUD** functionality.
- We will ensure the application supports **pagination** and **sorting** of employee records.
- **Security** will be handled through **Spring Security** to protect sensitive data.
- **Responsive UI** using **Bootstrap** and **Thymeleaf** to make the application accessible on various devices.

### **Key Features:**
- **User Authentication**: Secure login and registration pages.
- **Employee CRUD Operations**: Add, update, view, and delete employee records.
- **Pagination**: Display employee records with pagination for easy navigation.
- **Sorting**: Employees can be sorted by various fields (name, department, etc.).

## Step-by-Step Setup Instructions

### Prerequisites:
1. Java 8 or higher
2. Maven (for dependency management)
3. MySQL Database (for storing employee data)

### Setup Steps:

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/yourusername/employee-management-system.git
    ```

2. **Install Maven Dependencies**:
    Navigate into the project directory and install dependencies using Maven:
    ```bash
    cd employee-management-system
    mvn clean install
    ```

3. **Set up MySQL Database**:
    - Create a MySQL database named `employee_db` (or any name you prefer).
    - Update the database credentials in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    ```

4. **Run the Application**:
    Run the Spring Boot application with the following command:
    ```bash
    mvn spring-boot:run
    ```

5. **Access the Application**:
    Open your browser and navigate to `http://localhost:8080` to access the application.

### **Final Project Overview**:
This Employee Management System offers a simple and secure way to manage employee records. It provides functionalities such as user authentication, employee CRUD operations, and pagination with sorting.

