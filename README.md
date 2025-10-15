# 🔐 Password Validator

![Build Status](https://github.com/nilijoski/password-validator/actions/workflows/maven.yml/badge.svg)
![Java](https://img.shields.io/badge/Java-25%2B-orange)

A lightweight **Java utility** for validating passwords according to modern security standards.

---

## 🧩 Password Policy

### 🔸 Mandatory Requirements
A valid password must:
1. Contain **at least 8 characters, no more than 36**
2. Include **at least one digit (0–9)**
3. Include **both uppercase and lowercase letters**
4. Include **at least one** special characters from an allowed set (e.g. `!@#$%^&*()-_+=?.,;:`
5. **Not appear** in a list of **common or weak passwords**

---

### ✅ OPTIONAL TASKS IMPLEMENTED

```
✔ Enabled special characters in policy and extended isValid(...)
✔ Implemented password generator
✔ Added JUnit @ParameterizedTest for valid/invalid test data
✔ Implemented ValidationResult record to provide detailed feedback for users input
✔ Added an interactive console tool with a menu that lets the user choose between:
    1. generating a secure password 
    2. validating an existing password, with detailed validation feedback
```

### ⚙️ HOW-TO USE

1. **Navigate to path:**
   ```bash
   cd password-validator/src/main/java/com/example
   ```
2. **Compile all Java files:**
   ```bash
   javac *.java
   ```
3. **Run the program from the same directory:**
   ```bash
   java com.example.Main
   ```
You will see the interactive console menu:

    [1] Generate secure password
    [2] Validate existing password
    [0] Exit
    → Choose option:
