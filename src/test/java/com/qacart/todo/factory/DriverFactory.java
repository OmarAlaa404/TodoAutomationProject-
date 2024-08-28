package com.qacart.todo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * DriverFactory class manages WebDriver instances and provides browser-specific implementations.
 * This class ensures that a single instance of WebDriver is used per thread, supporting parallel test execution.
 */
public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static DriverFactory instance;

    /**
     * Enum for supported browser types.
     */
    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE
    }

    /**
     * Private constructor to prevent external instantiation.
     */
    private DriverFactory() {
        // Prevent instantiation
    }

    /**
     * Provides the singleton instance of DriverFactory.
     * @return DriverFactory instance.
     */
    public static DriverFactory getInstance() {
        if (instance == null) {
            synchronized (DriverFactory.class) {
                if (instance == null) {
                    instance = new DriverFactory();
                }
            }
        }
        return instance;
    }

    /**
     * Gets the WebDriver instance associated with the current thread.
     * @return WebDriver instance.
     * @throws IllegalStateException if WebDriver is not initialized.
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("WebDriver is not initialized. Make sure to call initializeDriver() before getDriver().");
        }
        return driver.get();
    }

    /**
     * Initializes WebDriver based on system property or defaults to CHROME.
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
        if (driver.get() == null) {
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

            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            webDriver.manage().window().maximize();
            driver.set(webDriver);
        }
        return driver.get();
    }

    /**
     * Quits the WebDriver and removes it from the ThreadLocal.
     * This method should be called after the test execution is completed.
     */
    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
