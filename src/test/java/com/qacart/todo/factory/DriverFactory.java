package com.qacart.todo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * DriverFactory class manages WebDriver instances and provides browser-specific implementations.
 */
public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE
    }

    /**
     * Gets the WebDriver instance.
     * @return WebDriver instance.
     * @throws IllegalStateException if WebDriver is not initialized.
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
        return driver.get();
    }

    /**
     * Initializes WebDriver based on system property or default to CHROME.
     * @return WebDriver instance.
     */
    public WebDriver initializeDriver() {
        String browser = System.getProperty("browser", "CHROME").toUpperCase();
        return initializeDriver(BrowserType.valueOf(browser));
    }

    /**
     * Initializes WebDriver based on the specified browser type.
     * @param browser BrowserType to initialize.
     * @return WebDriver instance.
     */
    public WebDriver initializeDriver(BrowserType browser) {
        WebDriver webDriver;

        switch (browser) {
            case CHROME:
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            case EDGE:
                webDriver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser type not supported: " + browser);
        }

        driver.set(webDriver);
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get().manage().window().maximize();

        return driver.get();
    }

    /**
     * Quits the WebDriver and removes it from the ThreadLocal.
     */
    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
