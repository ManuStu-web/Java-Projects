# 🏦 Bank Management System

This is a Java-based desktop application that simulates banking functionalities, developed using **Java Swing**, **JDBC**, and **MySQL**. It allows users to perform basic ATM-like operations through a multi-page user interface.

## 🚀 Getting Started

To run the project:
1. Ensure MySQL is running and the schema in `DataBase.sql` is set up.
2. Start the project by running `Login.java`.

---

## 📁 File Overview

| Filename              | Description                                                                              |
|-----------------------|------------------------------------------------------------------------------------------|
| **Login.java**        | Starting point of the project. Handles user login and redirects to transaction screen.   |
| **SignUp(Page1).java**| First part of the sign-up process—collects personal details.                             |
| **SignUp(Page2).java**| Second part of sign-up—collects additional user info.                                    |
| **SignUp(Page3).java**| Final sign-up screen—generates card and PIN.                                             |
| **ConnectMySQL.java** | Establishes JDBC connection with MySQL database.                                         |
| **DataBase.sql**      | SQL script to create required tables and schema for the project.                         |
| **Transaction.java**  | ATM-style UI showing available actions (deposit, withdrawal, fast cash, etc.).           |
| **DepositMoney.java** | Allows user to deposit funds into their account.                                         |
| **WithdrawlMoney.java**| Enables users to withdraw funds from their balance.                                     |
| **FastCash.java**     | Provides preset withdrawal options for quick transactions.                               |
| **BalanceEnquiry.java**| Displays current account balance.                                                       |
| **MiniStatment.java** | Shows a short history of transactions for the user.                                      |
| **PinChange.java**    | Allows user to change their ATM PIN.                                                     |

---

## 🛠 Technologies Used

- Java Swing for UI
- JDBC for database connectivity
- MySQL for data storage

---

## 📝 Notes

- Make sure all `.java` files are compiled.
- Use appropriate MySQL credentials inside `ConnectMySQL.java`.
- UI elements and transitions are based on Java Swing frames and panels.

---

## 📌 Author

Project by [ManuStu-web](https://github.com/ManuStu-web)

---

