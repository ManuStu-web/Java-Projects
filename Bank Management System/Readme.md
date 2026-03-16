# Bank Management System

![Java](https://img.shields.io/badge/Java-17-orange)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![JDBC](https://img.shields.io/badge/Connectivity-JDBC-green)
![Swing](https://img.shields.io/badge/UI-Java%20Swing-purple)
![Status](https://img.shields.io/badge/Project-Completed-brightgreen)

A **Java desktop application** that simulates basic banking and ATM functionalities.  
The system is built using **Java Swing for the user interface, JDBC for database connectivity, and MySQL for data storage**.

The application allows users to create accounts, login securely, and perform ATM-style operations like deposit, withdrawal, balance enquiry, and viewing transaction history.

---

## Project Overview

The **Bank Management System** replicates the functionality of a basic ATM interface.

Users can:

- Create a new bank account
- Login securely
- Deposit money
- Withdraw money
- Use fast cash options
- Check account balance
- View transaction history
- Change ATM PIN

The system uses **multiple Swing screens** to simulate the workflow of a real ATM.

---

## Features

- Multi-page account registration
- Secure login system
- Deposit money
- Withdraw money
- Fast cash withdrawal
- Balance enquiry
- Mini statement (transaction history)
- PIN change functionality
- MySQL database integration
- Interactive GUI using Java Swing

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Core programming language |
| Java Swing | Graphical User Interface |
| JDBC | Database connectivity |
| MySQL | Database storage |
| OOP | Object-oriented design |

---

## Project Structure

```
BankManagementSystem
│
├── Login.java
├── SignUp(Page1).java
├── SignUp(Page2).java
├── SignUp(Page3).java
│
├── Transaction.java
├── DepositMoney.java
├── WithdrawlMoney.java
├── FastCash.java
├── BalanceEnquiry.java
├── MiniStatment.java
├── PinChange.java
│
├── ConnectMySQL.java
└── DataBase.sql
```

---

## File Overview

| Filename | Description |
|---|---|
| Login.java | Starting point of the project. Handles user login and redirects to transaction screen |
| SignUp(Page1).java | First page of account registration that collects personal details |
| SignUp(Page2).java | Second signup page collecting additional information |
| SignUp(Page3).java | Final signup page that generates ATM card number and PIN |
| ConnectMySQL.java | Establishes JDBC connection with MySQL database |
| DataBase.sql | SQL script for creating database tables |
| Transaction.java | Main ATM screen showing all transaction options |
| DepositMoney.java | Allows users to deposit money |
| WithdrawlMoney.java | Enables users to withdraw money |
| FastCash.java | Provides quick withdrawal options |
| BalanceEnquiry.java | Displays current account balance |
| MiniStatment.java | Shows recent transaction history |
| PinChange.java | Allows users to change ATM PIN |

---

## Example Features in Application

### Login Screen
Users enter their **card number and PIN** to access the banking system.

### Transaction Menu

```
1. Deposit
2. Withdraw
3. Fast Cash
4. Mini Statement
5. Balance Enquiry
6. PIN Change
7. Exit
```

### Deposit Example

```
Enter amount to deposit: 5000
Deposit successful
```

### Withdrawal Example

```
Enter amount to withdraw: 2000
Transaction successful
```

---

## Installation & Setup

### 1 Clone the Repository

```bash
git clone https://github.com/ManuStu-web/Bank-Management-System.git
```

---

### 2 Open the Project

Open the project in any Java IDE:

- IntelliJ IDEA
- Eclipse
- VS Code

---

### 3 Setup Database

Run the SQL script:

```
DataBase.sql
```

This will create the required database tables.

---

### 4 Configure Database Connection

Update database credentials inside:

```
ConnectMySQL.java
```

Example:

```java
Connection conn = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/bank_management",
"root",
"password"
);
```

---

### 5 Run the Application

Start the program by running:

```
Login.java
```

The login screen will appear.

---

## Example Workflow

1. Create a new bank account using the signup pages  
2. Login using card number and PIN  
3. Access transaction menu  
4. Perform deposit or withdrawal  
5. Check balance or transaction history  

---

## Concepts Demonstrated

This project demonstrates:

- Java **Object-Oriented Programming**
- **Java Swing GUI development**
- **JDBC database connectivity**
- CRUD database operations
- Multi-page UI navigation
- Basic banking system simulation

---

## Future Improvements

Possible improvements for the project:

- Password encryption
- User authentication security
- Account transfer feature
- Improved UI design
- Transaction receipts
- Online banking version using **Spring Boot**

---

## Author

**Manu Sharma**  
B.Tech Computer Science Student  

GitHub:  
https://github.com/ManuStu-web
