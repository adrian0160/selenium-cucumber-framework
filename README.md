# UI Test Automation Framework (BDD)

UI test automation framework built with **Java**, **Selenium WebDriver**, **Cucumber (BDD)** and **TestNG**, following the **Page Object Model** pattern. UI scenarios run against [the-internet.herokuapp.com](https://the-internet.herokuapp.com).

This project verifies the behaviour of common web UI components. It is built as a reusable foundation: the target application is a practice site, but the architecture and test design apply to any web application.

## Tech Stack

| Tool | Purpose | Version |
|------|---------|---------|
| Java | Language | 21 |
| Selenium WebDriver | Browser automation | 4.33.0 |
| Cucumber | BDD / Gherkin scenarios | 7.34.3 |
| TestNG | Test runner | 7.11.0 |
| PicoContainer | Dependency injection (shared WebDriver) | 7.34.3 |
| Maven | Build & dependency management | 3.9+ |

## Test Coverage

**35 automated scenarios** across 5 features (each row of a Scenario Outline counts as one scenario).

| Feature | Scenarios | Test design technique | What is covered |
|---------|:---------:|-----------------------|-----------------|
| Login | 6 | Equivalence Partitioning, Decision Table | All valid/invalid combinations of username and password, empty fields |
| JavaScript Alerts | 6 | Coverage per dialog type and user action | Alert accept, confirm accept/dismiss, prompt with text, empty input and cancel |
| Drag and Drop | 5 | Positive flows and edge cases | Swapping in both directions, swapping back, dropping a column onto itself |
| Horizontal Slider | 7 | Boundary Value Analysis | Minimum, maximum, values next to them, values outside the range, intermediate moves |
| Status Codes | 11 | Validation at HTTP and UI level | Status of every link via HTTP HEAD, broken link detection (4xx/5xx), navigation to each status page |

## Project Structure

```
src/test/java
├── context/        # DriverContext – WebDriver shared across step classes
├── pages/          # Page Objects (locators + actions)
├── steps/          # Cucumber step definitions + Hooks (driver lifecycle)
└── runners/        # TestNG + Cucumber runners
src/test/resources
└── features/       # Gherkin .feature files
```

## Key Design Decisions

- **Page Object Model** — locators and page interactions are encapsulated in `pages/`, keeping step definitions clean and readable.
- **Single WebDriver per scenario** — a single `Hooks` class manages the driver lifecycle (`@Before`/`@After`). The instance is shared with every step class through `DriverContext`, injected by PicoContainer. This avoids spawning multiple browser windows per scenario.
- **Selenium Manager** — Selenium 4 auto-resolves the matching ChromeDriver, so no manual driver setup is required.

## Running the Tests

Run all tests:

```bash
mvn test
```

The active features are configured in the Cucumber runner under `src/test/java/runners/`.

## Requirements

- JDK 21+
- Maven 3.9+
- Google Chrome installed
