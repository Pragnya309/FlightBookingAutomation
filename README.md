Flight Booking Automation Framework
Project Overview
This project automates the end-to-end flight booking process for the BlazeDemo travel website using Java, Selenium WebDriver, and TestNG.
The framework follows the Page Object Model (POM) design pattern and includes reporting, screenshot capture on failure, configuration management, and CI integration

Tech Stack
Tool               - Purpose
Java               - Programming Language
Selenium WebDriver - Browser Automation
TestNG	           - Test Framework
Maven	           - Build & Dependency Management
Git                - Version Control
Jenkins	           - Continuous Integration
Extent Reports	   - Test Reporting

- Framework Features

✔ Page Object Model (POM) design
✔ Configuration using config.properties
✔ Screenshot capture on test failure
✔ Extent HTML reports for execution results
✔ TestNG listener integration
✔ CI pipeline with Jenkins
✔ Maven dependency management

- Test Scenario

The automated test performs:
Open BlazeDemo website
Select departure city
Select destination city
Search available flights
Choose a flight
Enter passenger details
Complete purchase
Verify booking confirmation

- Test Reports

Execution reports are generated using Extent Reports.

Location:
/reports/ExtentReport.html

- The report includes:
Test status
Failure details
Screenshots for failed tests

- Running the Tests

Clone the repository:
git clone https://github.com/Pragnya309/FlightBookingAutomation.git
Run tests using Maven:
mvn clean test

- Continuous Integration

The project is integrated with Jenkins to automatically execute tests whenever code changes are pushed to the repository.

- Pipeline Flow:

Git Push
   ↓
GitHub Repository
   ↓
Jenkins Build Trigger
   ↓
Maven Test Execution
   ↓
Extent Report Generated


- Author
Pragnya Edulakanti
Automation Testing Enthusiast
Skilled in Selenium, Java, TestNG, and CI/CD tools.
