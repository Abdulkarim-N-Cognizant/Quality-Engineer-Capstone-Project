# OrangeHRM Test Automation Framework

Automated UI testing framework for the OrangeHRM application built using Java, Selenium WebDriver, Cucumber, JUnit, and Maven.

The framework follows the Page Object Model (POM) design pattern and utilizes Behavior-Driven Development (BDD) practices to create maintainable, scalable, and readable automated test suites. Test scenarios are implemented using Cucumber and Gherkin syntax, enabling both technical and non-technical stakeholders to understand application behavior.

---

## Overview

This framework automates and validates key OrangeHRM application workflows through end-to-end UI testing.

Current automation coverage includes:

- User Login
- Dashboard Validation
- Forgot Password Functionality
- Authentication Error Handling
- Navigation Verification

The framework is designed with a clear separation of concerns between page objects, test logic, configuration management, and utility components.

---

## Technology Stack

- Java
- Selenium WebDriver
- Cucumber
- JUnit
- Maven
- ChromeDriver
- EdgeDriver

---

## Key Features

- Selenium WebDriver-based UI automation
- Cucumber BDD implementation using Gherkin
- Page Object Model (POM) architecture
- Cross-browser execution support
    - Google Chrome
    - Microsoft Edge
- Data-driven testing using Scenario Outlines
- Tag-based test execution
- Centralized WebDriver management
- Reusable page objects and step definitions
- Screenshot capture utilities
- Network monitoring support
- Maven-based execution
- Scalable and maintainable project structure

---

## Project Structure

```text
src
├── main
│   └── java
│       └── com.orangehrm
│           ├── pages
│           │   ├── BasePage.java
│           │   ├── LoginPage.java
│           │   ├── DashboardPage.java
│           │   └── PasswordResetPage.java
│           │
│           └── utils
│               ├── ConfigReader.java
│               ├── DriverFactory.java
│               ├── NetworkMonitor.java
│               └── ScreenshotUtil.java
│
├── test
│   └── java
│       └── com.orangehrm
│           ├── runner
│           │   └── CucumberTest.java
│           │
│           └── stepdefs
│               ├── BaseSteps.java
│               ├── DashboardSteps.java
│               ├── Hooks.java
│               ├── LoginSteps.java
│               └── PasswordResetSteps.java
│
├── resources
│   └── features
│
├── pom.xml
└── README.md
```

---

## Framework Architecture

### Page Objects

The framework utilizes the Page Object Model (POM) design pattern to separate UI interactions from test implementation.

#### BasePage

Contains reusable Selenium functionality shared across all page objects.

#### LoginPage

Encapsulates login page elements and user actions.

#### DashboardPage

Handles dashboard interactions and validations.

#### PasswordResetPage

Implements password reset page functionality and validations.

---

### Utilities

#### DriverFactory

Responsible for browser initialization and WebDriver lifecycle management.

#### ConfigReader

Reads and manages application and execution configurations.

#### ScreenshotUtil

Captures screenshots during test execution for debugging and reporting purposes.

#### NetworkMonitor

Provides browser network monitoring capabilities to assist with troubleshooting and validation.

---

### Step Definitions

The following classes contain implementations for Cucumber scenarios:

- BaseSteps
- LoginSteps
- DashboardSteps
- PasswordResetSteps
- Hooks

---

### Test Runner

The framework executes Cucumber tests using:

```text
com.orangehrm.runner.CucumberTest
```

---

## Browser Support

The framework supports execution on the following browsers:

- Google Chrome
- Microsoft Edge

Browser selection can be controlled at runtime through Maven parameters.

### Run Tests on Chrome

```bash
mvn test -Dbrowser=chrome
```

### Run Tests on Edge

```bash
mvn test -Dbrowser=edge
```

If no browser argument is provided, the framework will use the default browser configuration.

---

## Prerequisites

Ensure the following tools are installed:

- Java 11 or higher
- Maven 3.6 or higher
- Google Chrome
- Microsoft Edge

Verify installations:

```bash
java -version
mvn -version
```

---

## Running the Test Suite

### Execute All Tests

```bash
mvn test
```

### Execute on Chrome

```bash
mvn test -Dbrowser=chrome
```

### Execute on Edge

```bash
mvn test -Dbrowser=edge
```

### Clean and Execute

```bash
mvn clean test -Dbrowser=chrome
```

---

## Running Tests by Tags

The framework supports tag-based execution for test selection.

### Execute Smoke Tests

```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

### Execute Regression Tests

```bash
mvn test -Dcucumber.filter.tags="@regression"
```

### Execute Positive Tests

```bash
mvn test -Dcucumber.filter.tags="@positive"
```

### Execute Login Tests

```bash
mvn test -Dcucumber.filter.tags="@login"
```

### Execute Multiple Tags

```bash
mvn test -Dcucumber.filter.tags="@smoke or @regression"
```

### Exclude Tags

```bash
mvn test -Dcucumber.filter.tags="not @smoke"
```

---

## Sample Feature

```gherkin
@login
Feature: Login

  @smoke @regression
  Scenario Outline: Login Validation
    Given the user is on the login page
    When the user enters username "<username>" on the login page
    And the user enters password "<password>" on the login page
    And the user clicks the login button
    Then the <result> should be displayed

    Examples:
      | username | password      | result                    |
      | Admin    | admin123      | dashboard                 |
      | Admin    | wrongpassword | Invalid Credentials Alert |

  @regression @positive
  Scenario: Forgot your password
    Given the user is on the login page
    When the user clicks the Forgot your Password? hyperlink
    Then the user is directed to the password reset page
```

---

## Current Test Coverage

### Login Module

- Successful login validation
- Invalid login validation
- Authentication error verification
- Login page functionality checks

### Dashboard Module

- Successful navigation verification
- Dashboard visibility validation
- Post-login workflow validation

### Password Reset Module

- Forgot Password navigation
- Password reset page verification
- Password recovery workflow validation

---

## Reporting

Test execution artifacts are generated under:

```text
target/
```

Depending on the configured Cucumber plugins, reports may include:

- HTML Reports
- JSON Reports
- JUnit XML Reports

---

## Design Patterns and Practices

The framework incorporates the following patterns and practices:

- Page Object Model (POM)
- Factory Pattern
- Behavior-Driven Development (BDD)
- Data-Driven Testing
- Reusable Test Components
- Separation of Concerns
- Configuration-Based Execution

---

## Future Enhancements

Potential areas for expansion include:

- Parallel test execution
- Selenium Grid integration
- Dockerized execution
- GitHub Actions CI/CD integration
- Jenkins pipeline integration
- Allure reporting
- Data-driven execution using external data sources

---

## Author

Maleesh Wanniarachchige Abdulkarim Noorzaie
## License

This project is intended for educational, demonstration, and test automation purposes.