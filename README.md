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
| Silver Member At Limit               | 100.0, SILVER             | 100.0             |
| Silver Member Above Limit            | 101.0, SILVER             | 95.95             |
| Gold Member Under Limit              | 49.0, GOLD                | 49.0              |
| Gold Member At Limit                 | 50.0, GOLD                | 50.0              |
| Gold Member Over Limit               | 51.0, GOLD                | 45.9              |
| Platinum Member Regular Purchase     | 100.0, PLATINUM           | 80.0              |
| Negative Price                       | -1.0, NONE                | Exception thrown  |
| No Price                             | 0.0, NONE                 | Exception thrown  |

## 2-Value Boundary Analysis 🔍

We tested the values at the edges of input ranges:
1. **Silver Members**:
    - **Boundary Below Limit**:
        - **Test**: Silver Member Under Limit (99.99)
        - **Expected**: No discount.
    - **Boundary At Limit**:
        - **Test**: Silver Member At Limit (100.0)
        - **Expected**: 5% discount applied.
        
2. **Gold Members**:
    - **Boundary Below Limit**:
        - **Test**: Gold Member Under Limit (49.0)
        - **Expected**: No discount.
    - **Boundary At Limit**:
        - **Test**: Gold Member At Limit (50.0)
        - **Expected**: No discount.
    - **Boundary Over Limit**:
        - **Test**: Gold Member Over Limit (51.0)
        - **Expected**: 10% discount applied.

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
