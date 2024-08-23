package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginPage class provides methods for interacting with the login page elements.
 */
public class LoginPage extends BasePage {

    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement emailInput;
    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordInput;
    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement loginSubmitButton;
    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    @Step("Load the login page")
    public LoginPage load() {
        try {
            driver.get(ConfigUtils.getInstance().getBaseURL());
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load login page.", e);
        }
    }

    @Step("Login with email: {0} and password: {1}")
    public TodoPage login(String email, String password) {
        try {
            emailInput.sendKeys(email);
            passwordInput.sendKeys(password);
            loginSubmitButton.click();
            return new TodoPage();
        } catch (Exception e) {
            throw new RuntimeException("Login failed.", e);
        }
    }
}
