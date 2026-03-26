# HH Automation Project

## Overview

This project is a Java-based automation tool for interacting with hh.ru.
It uses Playwright to control a browser and simulate user actions.

At the current stage, the project successfully launches the hh.ru website in automated mode.

---

## Current Features

* Launches hh.ru using Playwright automation
* Basic project structure for future expansion

---

## Planned Features

* Resume auto-refresh bot
* Job listings crawler
* Data storage (PostgreSQL)
* Analytics (salary trends, tech stack insights)
* Queue-based processing (RabbitMQ)

---

## Tech Stack

* Java
* Playwright (Java)
* Maven
* PostgreSQL (planned)
* RabbitMQ (planned)

---

## Getting Started

### Prerequisites

Make sure you have installed:

* Java 17+
* Maven 3.8+

---

### Clone the Repository

```bash
git clone https://github.com/<your-username>/hh-automation.git
cd hh-automation
```

---

### Install Dependencies

```bash
mvn clean install
```

---

### Install Playwright Browsers

Playwright requires browser binaries. Install them with:

```bash
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

---

### Run the Project

```bash
mvn compile exec:java -Dexec.mainClass="com.example.hhautomation.Main"
```

This will launch a browser and open hh.ru in automated mode.

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

* The project is in an early stage and focuses on learning and experimentation.
* Future updates will expand automation scenarios and add backend components.

---

## Motivation

This project is built as a hands-on way to learn Java through:

* Browser automation
* Web scraping
* Backend architecture
* Scalable system design

---
