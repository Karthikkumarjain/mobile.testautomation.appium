# Test Automation with Appium for mobile devices

This is a sample test framework for mobile testing of Android and iOS using appium. The tests and other classes are written in Java.The framework also supports parallel testing and running test cases over cloud based platform.


## Prerequisite

Since this is based on Java language, so the pre-requisite is to have latest version of JDK installed on our system along with maven.

* Clone the repo
* Run "maven clean compile" or build the project in any IDE.
* Install node js and appium server with required drivers(Currently in use as part of this framework-UIAtomator and XCUITest).
* Install Android studio to have a emulator open.
* Install XCode to have a simulator open.
* See the Run Tests section on how to run the tests
## Structure

The primary directories are as follows


* runner : Contains set of testNG xml files that could be used to run the tests.
* base : Contains a base test class file that initializes XCUITest and UIAutomator drivers and has some commonly used functions that can be applied on locators.
* listeners : Contains a class file that implements ITestListener which has various useful methods that can be used during failure or success of a test.
* pages : Contains locator classes along with the functions to be performed.
* reports: Contains a class file that helps in creation of extent report.
* utils: Contains some utils classes that can be useful in calling repetitive functions related to property file reader,database,test related and encryption-decryption.
* tests : Contain the tests for the mobile apps.
## System Under Test

The application  under test are under the resources/app

## Libraries Used

* testNG : For driving the tests.
* appium : To add tests related to Android and iOS application.
* jasypt : To encrypt and decrypt sensitive information.
* assertj: To write tests with much effective assertions.
* oracle jdbc: To connect to database.
## Config

* globalconfig.properties - Is maintained as part of global level properties
## Run Tests

To run the tests in local use

```bash
  mvn clean test
```

## Reports

* Reports are generated as part of extent library