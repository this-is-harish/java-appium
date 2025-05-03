# Appium Automation Test Suite

This project is an automated test suite using `Appium`, `TestNG`, and `ExtentReports` for Android apps. It uses the `Page Object Model (POM)` design pattern.

---

## Dependencies

Ensure these dependencies are in your `pom.xml`:

- `io.appium:java-client:8.5.1`
- `org.seleniumhq.selenium:selenium-java:4.17.0`
- `org.testng:testng:7.9.0`
- `com.aventstack:extentreports:5.1.1`

---

## Pre-requisites

- `Java 11+`
- `Maven` installed (`mvn -v`)
- `Android Studio` or emulator or real device
- `Appium Server` running (Desktop or CLI)
- Environment variable `ANDROID_HOME` is set
- Add `platform-tools` to system `PATH`
- `testng.xml` present in the root or `src/test/resources`

---

## How to Run Tests

Run from terminal:

`mvn clean test -DsuiteXmlFile=testng.xml`

Or run from IntelliJ:

- Right-click on `testng.xml`
- Select `Run 'testng.xml'`

---

## Reports

After test execution, report is located at:  
[extent-report.html](test-output/extent-report.html)

Open in browser to view detailed test results.