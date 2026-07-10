# JSONPlaceholder API Test Suite

## Overview

This project contains an automated API test suite for the JSONPlaceholder `/posts` endpoint using Java, JUnit 5, and REST Assured.

API Endpoint:
https://jsonplaceholder.typicode.com/posts

## Prerequisites

- Java 17 or later
- Apache Maven
- Internet connection

## Running the Tests

1. Open a terminal in the project root directory.
2. Run the following command:

```bash
mvn test
```

3. Maven will execute all test cases and display the results in the console.

## Test Coverage

The suite includes:

- GET all posts
- GET specific post
- GET posts by user ID
- Response structure validation
- Response time validation
- POST create post
- PUT update post
- DELETE post
- Negative test (404 Not Found)
- Chained request test

## Expected Result

```text
Tests run: 11, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS
```

## Notes

- The tests use the public JSONPlaceholder API.
- No authentication is required.
- No environment variables are required.
- A Postman collection was also created during development for exploratory and manual API testing.