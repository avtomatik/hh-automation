# HH Automation Project

## Overview

This project is a Java-based automation tool for interacting with hh.ru.

It uses Playwright to automate browser actions and now includes a login automation flow with environment-based credentials.

---

## Current Features

* Launches hh.ru using Playwright automation
* Automated login flow (email + password)
* Environment-based configuration via `.env`
* Structured helper methods for automation steps

---

## Planned Features

* Resume auto-refresh bot
* Job listings crawler
* Data storage (PostgreSQL)
* Analytics (salary trends, tech stack insights)
* Queue-based processing (RabbitMQ)

---

## Tech Stack

* Java 21
* Maven
* Playwright (Java)
* dotenv-java (environment variables)
* JUnit 4.13.2 (testing)

---

## Getting Started

### Prerequisites

Make sure you have installed:

* Java 21+
* Maven 3.8+

---

### Clone the Repository

```bash
git clone https://github.com/avtomatik/hh-automation.git
cd hh-automation
```

---

### Configure Environment Variables

Create a `.env` file in the project root:

```env
HH_EMAIL=your_email@example.com
HH_PASSWORD=your_password
```

---

### Install Dependencies

```bash
mvn clean install
```

---

### Install Playwright Browsers

```bash
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

---

### Run the Project

```bash
mvn compile exec:java -Dexec.mainClass="com.example.hhautomation.LoginExample"
```

This will launch a browser, navigate to hh.ru login page, and perform an automated login using credentials from `.env`.

---

## Project Structure (simplified)

```
src/
 └── main/
     └── java/
         └── com/example/hhautomation/
             └── Main.java
```

---

## Notes

* The project now uses environment variables for credentials via `dotenv-java`
* Login flow is split into reusable methods for better maintainability
* Java version has been upgraded to 21
* This is still an early-stage learning project focused on automation and backend architecture

---

## Motivation

This project is built as a hands-on way to learn Java through:

* Browser automation with Playwright
* Secure configuration management (.env)
* Web scraping and automation flows
* Backend architecture and scalable design patterns

---
