# Quality Engineering Capstone Project

## Overview

This repository contains a comprehensive Quality Engineering Capstone Project demonstrating the application of modern testing practices across multiple quality assurance disciplines. The project evaluates both the functional and non-functional aspects of software quality through UI automation, API automation, performance testing, accessibility assessment, and supporting QA documentation.

The project focuses on two systems:

- **OrangeHRM** – UI Automation Testing
- **JSONPlaceholder REST API** – API Automation and Performance Testing

The objective is to showcase a complete Quality Engineering approach by validating application functionality, API reliability, performance characteristics, and accessibility considerations while producing industry-standard QA artifacts.

---

## Project Components

### 1. UI Automation Testing - OrangeHRM

The UI automation framework validates critical user workflows within the OrangeHRM application using Selenium WebDriver and Cucumber.

#### Technology Stack

- Java
- Selenium WebDriver
- Cucumber BDD
- JUnit
- Maven

#### Key Features

- Page Object Model (POM) design pattern
- Cross-browser testing
    - Google Chrome
    - Microsoft Edge
- Data-driven testing using Scenario Outlines
- Tag-based test execution
- Reusable page objects and step definitions
- Centralized WebDriver management
- Screenshot capture utilities
- Maven-based execution

#### Functional Coverage

- Login Validation
- Dashboard Verification
- Forgot Password Workflow
- Invalid Login Handling
- Authentication Validation
- Cross-Browser Testing

#### Location

```text
UI Tests/
```

For framework-specific implementation details, refer to the README inside the UI Tests directory.

---

### 2. API Automation Testing - JSONPlaceholder

Automated API tests were developed using Java and REST Assured to validate CRUD operations on the JSONPlaceholder REST API.

#### Technology Stack

- Java
- REST Assured
- JUnit
- Maven

#### API Coverage

##### Create

- POST requests
- Resource creation validation
- Response payload verification

##### Read

- GET single resources
- GET multiple resources
- Response body validation

##### Update

- PUT requests
- Resource update validation
- Updated data verification

##### Delete

- DELETE requests
- Response validation
- Status code verification

#### Additional Validations

- Status code validation
- Response body assertions
- Header validation
- Endpoint verification
- API behavior validation

#### Location

```text
API Tests/
```

#### Structure

```text
API Tests
├── API Test Results Screenshots
├── Automated_API_Tests_Java
└── README.md
```

---

### 3. Performance Testing - JSONPlaceholder

Performance testing was conducted using Apache JMeter to assess API responsiveness and behavior under load.

#### Technology Stack

- Apache JMeter

#### Objectives

- Response time analysis
- Throughput measurement
- Load simulation
- Stability assessment
- Performance evaluation

#### Artifacts

```text
JMeter Load Test
├── JSONPlaceholder_LoadTest.jmx
├── jmeter_summary.txt
├── Jmeter_HTML_Report.png
└── jmeterCLI.png
```

#### Location

```text
JMeter Load Test/
```

---

### 4. Quality Assurance Documentation

The repository contains essential QA deliverables typically produced throughout the software testing lifecycle.

#### Location

```text
Text Components/
```

#### Contents

##### Test Plan

Defines:

- Test objectives
- Scope
- Testing strategy
- Resources
- Risks and assumptions

```text
test_plan.txt
```

##### Test Cases

Detailed functional test scenarios and expected outcomes.

```text
test_cases.txt
```

##### Test Execution Summary

Execution results and test outcome analysis.

```text
test_execution_summary.txt
```

##### Defect Report

Defects identified during testing activities.

```text
defect_report.txt
```

##### Accessibility Findings

Accessibility observations and usability concerns identified during review.

```text
accessibility_findings.txt
```

---

## Repository Structure

```text
ORANGEHR-QA
│
├── API Tests
│   ├── API Test Results Screenshots
│   ├── Automated_API_Tests_Java
│   └── README.md
│
├── JMeter Load Test
│   ├── JSONPlaceholder_LoadTest.jmx
│   ├── jmeter_summary.txt
│   ├── Jmeter_HTML_Report.png
│   └── jmeterCLI.png
│
├── Text Components
│   ├── accessibility_findings.txt
│   ├── defect_report.txt
│   ├── test_cases.txt
│   ├── test_execution_summary.txt
│   └── test_plan.txt
│
├── UI Tests
│   ├── .mvn
│   ├── src
│   ├── target
│   ├── pom.xml
│   └── README.md
│
├── .gitignore
└── README.md
```

---

## Testing Strategy

A layered testing approach was implemented to achieve broader quality coverage.

### UI Testing

Validates application functionality from an end-user perspective through automated browser interactions.

### API Testing

Validates backend services independently of the user interface through automated CRUD operation testing.

### Performance Testing

Measures system responsiveness and stability under load conditions.

### Accessibility Testing

Identifies usability and accessibility concerns that may affect user experience.

### Regression Testing

Supports repeatable execution of automated test suites to verify functionality following changes.

---

## Tools and Technologies

### UI Automation

- Java
- Selenium WebDriver
- Cucumber
- JUnit
- Maven

### API Automation

- Java
- REST Assured
- JUnit
- Maven

### Performance Testing

- Apache JMeter

### Development and Collaboration

- Git
- GitHub
- IntelliJ IDEA
- Google Chrome
- Microsoft Edge

---

## Quality Engineering Practices Demonstrated

- Behavior-Driven Development (BDD)
- Page Object Model (POM)
- Cross-Browser Testing
- CRUD API Testing
- REST API Automation
- Data-Driven Testing
- Regression Testing
- Performance Testing
- Accessibility Assessment
- Test Planning
- Test Execution Reporting
- Defect Management
- Version Control

---

## Running the UI Automation Framework

Navigate to the UI Tests project:

```bash
cd "UI Tests"
```

Run all tests:

```bash
mvn test
```

Run tests on Chrome:

```bash
mvn test -Dbrowser=chrome
```

Run tests on Edge:

```bash
mvn test -Dbrowser=edge
```

Run smoke tests:

```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

Run regression tests:

```bash
mvn test -Dcucumber.filter.tags="@regression"
```

Run login tests:

```bash
mvn test -Dcucumber.filter.tags="@login"
```

---

## Deliverables

This repository includes:

- Selenium UI Automation Framework
- Automated REST API Test Suite
- JMeter Performance Test Scripts
- Test Plan
- Test Cases
- Defect Report
- Accessibility Findings
- Test Execution Summary
- Test Results and Evidence Screenshots

---

## Learning Outcomes

This project demonstrates practical experience in:

- Quality Engineering Methodologies
- Test Automation Framework Development
- Selenium WebDriver Automation
- Cucumber BDD Implementation
- REST API Automation with REST Assured
- CRUD API Testing
- Performance Testing with JMeter
- Accessibility Assessment
- Defect Reporting and Tracking
- Test Documentation
- Software Quality Assurance Best Practices

---

## Author
**Abdulkarim Noorzaie**
**Maleesha Wanniarachchige**

Quality Engineering Capstone Project demonstrating end-to-end software testing through UI automation, API automation, performance testing, accessibility evaluation, and QA documentation.