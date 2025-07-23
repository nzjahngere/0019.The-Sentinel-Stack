# Sentinel Stack: StyleMate E2E Automation

## Introduction

Welcome to **Sentinel Stack**, a robust SDET framework designed to automate end‑to‑end user flows for the StyleMate e‑commerce platform. Leveraging Java, Selenium WebDriver, TestNG, and Cucumber, this project ensures fast, reliable regression testing and lays the groundwork for future Performance and Security testing.

## Project Type

**Type:** Backend Test Automation Framework

## Application Under Test

**URL:** [https://luni-interface-029.vercel.app/](https://luni-interface-029.vercel.app/)

## Table of Contents

1. Directory Structure
2. Prerequisites
3. Installation & Setup
4. Running Tests
5. Reporting
6. Performance Testing Roadmap
7. Security Testing Roadmap
8. Features
9. Design Decisions & Assumptions
10. Credentials
11. Technology Stack
12. Contributing
13. License

## Directory Structure

```bash
TheSentinelStack/
├─ src/
│  ├─ test/
│     ├─ java/
│     │  ├─ styleMateRunners/            # Cucumber Test Runners
│     └─ ├─ styleMateAutomation/         # Step Definitions
├─ StyleMate Features                    # Cucumber Feature Files 
├─ pom.xml                       # Maven Configuration
├─ jmeter/                       # JMeter Performance Scripts (future)
└─ burp/                         # Burp Suite Security Configs (future)
```

## Prerequisites

* Java 11 (or higher)
* Maven 3.6+
* Chrome, Firefox, Edge browsers installed
* Internet connection to access the SUT
* JMeter & Burp Suite for performance and security

## Installation & Setup

1. Clone the repository:

   ```bash
   ```

git clone [https://github.com/your-org/sentinel-stack.git](https://github.com/your-org/sentinel-stack.git)
cd sentinel-stack

````

2. Install dependencies & compile:

```bash
mvn clean install
````

3. Configure environment:

   * Place custom test data under `src/test/resources/testdata`
   * Adjust browser drivers in `config.properties` if needed

## Running Tests

* **Run all E2E tests:**

  ```bash
  ```

mvn test

````

- **Run by tag:**
```bash
mvn test -Dcucumber.filter.tags="@Checkout"
````
## Reporting

After execution, generate HTML reports:

```bash
mvn test site
```

Reports available under `target/site`:

* `CartAndWishlist.html`
* `CheckoutFeatureReport.html`
* `Homepage.html`
* `OrderManagementReport.html`
* `SearchAndCatalog.html`
* `UserManagementReport.html`

Screenshots on failure are stored in `target/screenshots`.

## Features

* E2E Coverage: Homepage → Product Listing → Cart → Checkout → Orders
* BDD: Readable Cucumber feature files for business clarity
* Robust Error Handling: Screenshots & logs on failure

## Design Decisions & Assumptions

* Cucumber BDD for stakeholder‑friendly test definitions.
* Assumes stable test accounts and predictable data resets.

## Credentials

| Role      | Username                                        | Password   |
| --------- | ----------------------------------------------- | ---------- |
| Test User | [testuser@style.com](mailto:testuser@style.com) | Test\@1234 |

## Technology Stack

* Language: Java 11+
* Test Automation: Selenium WebDriver, TestNG, Cucumber
* Build & Dependency Management: Maven
* Reporting: ExtentReports, Cucumber HTML Reports
* Future Tools: JMeter, Burp Suite, SonarQube

## License

This project is licensed under the MIT License. See LICENSE for details.
