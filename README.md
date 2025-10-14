# 🔐 Password Validator

![Build Status](https://github.com/nilijoski/password-validator/actions/workflows/maven.yml/badge.svg)
![Code Coverage](https://img.shields.io/codecov/c/github/nilijoski/password-validator)
![Java](https://img.shields.io/badge/Java-25%2B-orange)

A lightweight **Java utility** for validating passwords according to modern security standards.  

---

## 🧩 Password Policy

### 🔸 Mandatory Requirements
A valid password must:
1. Contain **at least 8 characters**
2. Include **at least one digit (0–9)**
3. Include **both uppercase and lowercase letters**
4. **Not appear** in a list of **common or weak passwords**

### 🔹 Optional Policy
A password should:
1. Include **at least one special character**  
   from an allowed set (e.g. `!@#$%^&*()-_=+?`)
2. Contain a **minimum number of distinct character groups**  
   (e.g. at least 3 of 4: uppercase, lowercase, digits, special characters)

---
