package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * BasePage class initializes the WebDriver and sets up PageFactory for Page Object Model.
 */
public class BasePage {

    protected WebDriver driver;

    /**
     * Constructor for BasePage class. Initializes WebDriver and sets up PageFactory.
     */
    public BasePage() {
        try {
            this.driver = DriverFactory.getDriver();
            PageFactory.initElements(driver, this);
        } catch (IllegalStateException e) {
            throw new RuntimeException("WebDriver is not initialized. Please ensure that the DriverFactory is properly set up.", e);
        }
    }
}
