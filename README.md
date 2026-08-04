# Selenium + Cucumber Test Automation Framework

UI test automation framework built with **Java**, **Selenium WebDriver**, **Cucumber (BDD)** and **TestNG**, following the **Page Object Model** pattern. UI scenarios run against [the-internet.herokuapp.com](https://the-internet.herokuapp.com).

## Tech Stack

| Tool | Purpose | Version |
|------|---------|---------|
| Java | Language | 21 |
| Selenium WebDriver | Browser automation | 4.33.0 |
| Cucumber | BDD / Gherkin scenarios | 7.34.3 |
| TestNG | Test runner | 7.11.0 |
| PicoContainer | Dependency injection (shared WebDriver) | 7.34.3 |
| Maven | Build & dependency management | 3.9+ |

## Project Structure

```
src/test/java
├── context/        # DriverContext – WebDriver shared across step classes via DI
├── pages/          # Page Objects (locators + actions)
├── steps/          # Cucumber step definitions + Hooks (driver lifecycle)
└──runners/         # TestNG + Cucumber runners
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
