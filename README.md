Employee Database Application (Java + MySQL + JDBC)

Overview:
--------

This is a simple Java console application that connects to a MySQL database using JDBC.  
It allows you to perform CRUD operations on an `employees` table — create, read, update, and delete employee records.

Technologies Used:
-----------------
Java (JDK 8+)
MySQL (Workbench/Server)
JDBC (Java Database Connectivity)
MySQL Connector/J (JDBC Driver)

Prerequisites:
--------------
Make sure you have installed:
1. Java JDK – [Download here](https://www.oracle.com/java/technologies/javase-downloads.html)
2. MySQL Server & Workbench – [Download here](https://dev.mysql.com/downloads/)
3. MySQL Connector/J (JDBC Driver) – [Download here](https://dev.mysql.com/downloads/connector/j/)


Database Setup:
---------------
Run the following SQL commands in MySQL Workbench or terminal:

CREATE DATABASE company_db;

USE company_db;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    department VARCHAR(50),
    salary DOUBLE
);

How to Run the Project in Eclipse:
---------------------------------
1. Clone this repository or download the source code.
2. Download MySQL Connector/J from the official site and extract it.
3. In Eclipse:

   * Right-click the project → Build Path → Configure Build Path…
   * Go to Libraries → Add External JARs…
   * Select the `.jar` file (e.g., `mysql-connector-j-8.4.0.jar`)
   * Click Apply and Close
4. Update database credentials in the Java file:

   String URL = "jdbc:mysql://localhost:3306/company_db?useSSL=false&serverTimezone=UTC";
   String USER = "root"; // your MySQL username
   String PASSWORD = "yourpassword"; // your MySQL password

5. Run the Java file.

Features:
--------

* Add a new employee
* View all employees
* Update employee details
* Delete an employee
* Exit the program



Author
------

Anushka Balaga
B.Tech in Electronics and Communication Engineering
Passionate about Java Development and Databases.

---

If you want, I can also **add the exact Java + MySQL combined code** in the README so someone can directly copy-paste and run it without confusion.  
Do you want me to include that in this README?
```
