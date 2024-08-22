package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookieUtils;
import io.restassured.http.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

/**
 * BaseTest class sets up and tears down the WebDriver for test methods.
 */
public class BaseTest {

    /**
     * Initializes WebDriver before each test method.
     */
    @BeforeMethod
    public void setup() {
        try {
            new DriverFactory().initializeDriver();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize WebDriver.", e);
        }
    }

    /**
     * Quits WebDriver after each test method.
     */
    @AfterMethod
    public void tearDown() {
        try {
            new DriverFactory().quitDriver();
        } catch (Exception e) {
            throw new RuntimeException("Failed to quit WebDriver.", e);
        }

    }

    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies) {
        List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssureCookiesToSeleniumCookies(restAssuredCookies);
        for (org.openqa.selenium.Cookie cookie : seleniumCookies) {
            DriverFactory.getDriver().manage().addCookie(cookie);
        }
    }
}

