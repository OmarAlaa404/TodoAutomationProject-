package com.qacart.todo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE
    }

    public WebDriver initializeDriver() {
        // Fetch browser type from system property, default to CHROME if not set
        String browser = System.getProperty("browser", "CHROME").toUpperCase();

        return initializeDriver(BrowserType.valueOf(browser));
    }

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
}
