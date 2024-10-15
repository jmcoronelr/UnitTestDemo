# UnitTestDemo
# 🛒 DiscountCalculator

This is a discount calculator that determines the final price of a product based on its original price and the customer's membership type.

## 📜 Description

The `DiscountCalculator` class applies different discounts based on the membership type:

- **🚫 Non-Members**: No discount.
- **💎 Silver Members**: 5% discount on purchases over $100.
- **🌟 Gold Members**: 10% discount on purchases over $50.
- **🏆 Platinum Members**: 20% discount, regardless of the purchase amount.


## Unit Tests 🧪

| Test Case                            | Input                      | Expected Output   |
|--------------------------------------|---------------------------|-------------------|
| No Member Exact Purchase             | 100.0, NONE               | 100.0             |
| No Member Over Purchase              | 200.0, NONE               | 200.0             |
| No Member Under Purchase             | 50.0, NONE                | 50.0              |
| Silver Member Under Limit            | 99.99, SILVER             | 99.99             |
| Silver Member At Limit               | 100.0, SILVER             | 95.0              |
| Silver Member Above Limit            | 101.0, SILVER             | 95.95             |
| Negative Price                       | -1.0, NONE                | Exception thrown   |

## 2-Value Boundary Analysis 🔍

We tested the values at the edges of input ranges.
For the Silver members:
1. **Boundary Below Limit**:
    - **Test**: Silver Member Under Limit (99.99)
    - **Expected**: No discount.

2. **Boundary At Limit**:
    - **Test**: Silver Member At Limit (100.0)
    - **Expected**: 5% discount applied.

## 🛠 Requirements

- Java 11 or higher ☕
- Maven 📦

## 🏗️ Project Structure
```bash
UnitTestDemo/
├── pom.xml                   # Maven project configuration file
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── MembershipDiscount/
│   │   │       └── DiscountCalculator.java    # Main class for discount calculation
│   │   └── resources/        
│   └── test/
│       ├── java/
│       │   └── MembershipDiscount/
│       │       └── DiscountCalculatorTest.java # Test class for DiscountCalculator
│       └── resources/        
└── files/                     




