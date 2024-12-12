# 💳 Bank Management System Report

## 📚 Overview

This report outlines the development and functionality of the **Bank Management System** implemented in Java. The system is designed to manage banking operations such as creating accounts, making deposits, withdrawals, and transferring money between accounts. The data is stored in a file to ensure persistence even after the program terminates.

---

## 🛠️ System Description

### Purpose

The Bank Management System allows users to:

- 💳 **Create and manage bank accounts.**
- 💰 **Deposit and withdraw money.**
- 💵 **Transfer money between accounts.**
- 🔍 **Search and display account information.**

### Why File Storage? 

- 💾 **Data Persistence:** Preserves data even after the program stops.
- 📊 **Efficiency:** Facilitates quick access to large datasets.
- 🛢️ **Portability:** Allows easy data transfer between computers.

---

## 📚 Technologies Used

- **Programming Language:** Java 👨‍💻
- **File Storage:** Text files (`Data Base.txt`) 💾
- **Data Structures:** `ArrayList`, `ListIterator` 🔠

---

## 📚 Classes Overview

### 1. 🌟 **BankAccount (Parent Class)**

- Contains constructors and abstract methods.
- **Attributes:**
  - `name` 👤
  - `age` 👶
  - `accountNumber` 💳
  - `balance` 💰

### 2. 💳 **Current (Child Class)**

- Inherits from `BankAccount`.
- Implements:
  - **Deposit Method** 💵
  - **Withdraw Method** 💸

### 3. 🔧 **Account Class**

- Manages core functionalities:
  - Add, edit, delete accounts 🔄
  - Deposit and withdraw money 💰
  - Transfer funds between accounts 🛢️
  - Search and display account details 🔍
  - Handles file read/write operations 💾

---

## 🔀 Program Flow

1. **Main Menu** 📜:

   ```plaintext
   ###########################################
    1 - Add New Accounts
    2 - Display All Accounts Information
    3 - Edit Information of Specific Account
    4 - Delete Account From the File
    5 - Deposit
    6 - Withdraw
    7 - Transfer
    8 - Check Account Information
    9 - Exit
   ###########################################
   ```

2. **User Choices** 🛋:

   - **Add New Account:** Enter account details.
   - **Display Accounts:** View all account information.
   - **Edit Account:** Modify account details.
   - **Delete Account:** Remove an account from the file.
   - **Deposit Money:** Add funds to an account.
   - **Withdraw Money:** Deduct funds from an account.
   - **Transfer Money:** Move funds between accounts.
   - **Search Account:** Look up an account by number.

---

## 👤 Team Members

- **Saad** 👨‍💻
- **Nawaf** 👨‍💻
- **AbdulMohsen** 👨‍💻
- **Abdullah** 👨‍💻
- **Tarwq** 👨‍💻
- **Rayyan** 👨‍💻

---

## 📚 License

![License](https://img.shields.io/badge/license-MIT-blue.svg)

This project is licensed under the MIT License.

---

💌 Thank you for using the Bank Management System! 💳🌟
