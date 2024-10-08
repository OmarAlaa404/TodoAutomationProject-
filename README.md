# Todo Test Automation Framework

## Overview

This repository contains a Selenium-based test automation framework for a Todo application. The framework utilizes TestNG for test management and supports browser automation with Selenium WebDriver. It is designed to be a flexible and robust solution for automated testing of web applications.

## Features

- **Browser Automation**: Supports Chrome, Firefox, and Edge browsers.
- **Page Object Model**: Implements the Page Object Model pattern for cleaner and maintainable test code.
- **Configuration Management**: Uses configuration properties for environment-specific settings.
- **API Testing**: Integrates with Rest-Assured for API testing.

## Prerequisites

- **Java 11**: Ensure you have Java 11 installed on your machine.
- **Maven**: Apache Maven is required for building and managing dependencies.

## Getting Started

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/OmarAlaa404/TodoAutomationProject-
    cd TodoAutomationProject-
    ```

2. **Install Dependencies**:

   Run the following command to install all required dependencies:

    ```bash
    mvn clean install
    ```

3. **Configure Environment**:

   Configure the environment-specific properties by editing the configuration files located in `src/test/java/com/qacart/todo/config/`.

4. **Run Tests**:

   You can run the tests with specific configurations as follows:

   - **To specify the browser**: Use the `-Dbrowser` system property to choose the browser (e.g., Chrome, Firefox, Edge).

       ```bash
       mvn test -Dbrowser=chrome
       mvn test -Dbrowser=firefox
       mvn test -Dbrowser=edge
       ```

   - **To specify the environment**: Use the `-Denv` system property to choose the environment (e.g., TEST, PRODUCTION).

       ```bash
       mvn test -Denv=TEST
       mvn test -Denv=PRODUCTION
       ```

   - **Example of combined usage**: To run tests using Chrome in the TEST environment:

       ```bash
       mvn test -Dbrowser=chrome -Denv=TEST
       ```

5. **Update Dependencies and Plugins**:

   To update the dependencies, plugins, and the parent POM specified in the `pom.xml` to their latest versions, use the following Maven commands:

   - **Update all dependencies to the latest stable releases**:

       ```bash
       mvn versions:use-latest-releases
       ```

   - **Update all plugins to their latest versions**:

       ```bash
       mvn versions:use-latest-versions -DincludePlugins
       ```

   - **Update the parent POM to the latest version** (if applicable):

       ```bash
       mvn versions:update-parent
       ```

   - **Update properties that specify versions**:

       ```bash
       mvn versions:update-properties
       ```

   - **Revert any changes made by the versions plugin** (if needed):

       ```bash
       mvn versions:revert
       ```

## Project Structure

- **`src/main/java`**: Contains the main source code for the framework.
   - **`com.qacart.todo.base`**: Base classes for page and test setup.
   - **`com.qacart.todo.factory`**: Driver factory for managing WebDriver instances.
   - **`com.qacart.todo.pages`**: Page objects representing different pages in the application.
   - **`com.qacart.todo.utils`**: Utility classes for configuration and properties handling.

- **`src/test/java`**: Contains the test cases.
   - **`com.qacart.todo.testcases`**: Test classes using TestNG framework.

## Dependencies

The project uses the following dependencies:

- **TestNG**: For running tests.
- **Selenium Java**: For browser automation.
- **Rest-Assured**: For API testing.
- **Commons-Codec**: For encoding and decoding utilities.
- **Apache HttpClient**: For HTTP requests.

## Example Test Case

Here's an example of how a test case is structured:

```java
package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Test Login Functionality With Valid Email and Password")
    public void ShouldBeAbleToLoginWithEmailAndPassword() {
        LoginPage loginPage = new LoginPage();
        boolean isWelcomeDisplayed =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .isWelcomeMessageDisplayed();
        Assert.assertTrue(isWelcomeDisplayed, "The welcome message should be displayed after a successful login.");
    }
}

