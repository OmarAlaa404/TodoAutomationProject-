package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookieUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * BaseTest class sets up and tears down the WebDriver for test methods.
 */
public class BaseTest {

    /**
     * Initializes WebDriver before each test method.
     */
    @BeforeMethod
    @Step("Initialize WebDriver before test method")
    public void setup() {
        try {
            DriverFactory.getInstance().initializeDriver();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize WebDriver.", e);
        }
    }

    /**
     * Takes a screenshot and attaches it to the Allure report.
     *
     * @param destFile The destination file where the screenshot will be saved.
     */
    @Step("Take a screenshot")
    public void takeScreenshot(File destFile) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Cannot take screenshot.");
        }
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            org.apache.commons.io.FileUtils.copyFile(file, destFile);
            try (InputStream is = new FileInputStream(destFile)) {
                Allure.addAttachment("screenshot", is);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to take a screenshot.", e);
        }
    }

    /**
     * Quits WebDriver after each test method and takes a screenshot.
     */
    @AfterMethod
    @Step("Quit WebDriver after test method")
    public void teardown(ITestResult result) {
        String testCaseName = result.getMethod().getMethodName();
        File destFile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName + ".png");

        // Capture screenshot
        takeScreenshot(destFile);

        // Quit the WebDriver
        DriverFactory.getInstance().quitDriver();
    }

    /**
     * Injects cookies into the browser from the given RestAssured cookies.
     *
     * @param restAssuredCookies List of RestAssured cookies to inject into the browser.
     */
    @Step("Inject cookies into browser")
    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies) {
        List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssureCookiesToSeleniumCookies(restAssuredCookies);
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Cannot inject cookies.");
        }
        for (org.openqa.selenium.Cookie cookie : seleniumCookies) {
            driver.manage().addCookie(cookie);
        }
    }
}
