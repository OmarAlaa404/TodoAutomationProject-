package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginPage class provides methods for interacting with the login page elements.
 * This class includes actions such as loading the login page and performing login operations.
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

    /**
     * Loads the login page.
     *
     * @return the current LoginPage instance.
     */
    @Step("Load the login page")
    public LoginPage load() {
        try {
            driver.get(ConfigUtils.getInstance().getBaseURL());
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load login page.", e);
        }
    }

    /**
     * Logs in using the specified email and password.
     *
     * @param email the email to log in with.
     * @param password the password to log in with.
     * @return a new instance of the TodoPage.
     */
    @Step("Login with email: {0} and password: {1}")
    public TodoPage login(String email, String password) {
        try {
            enterEmail(email);
            enterPassword(password);
            clickLoginButton();
            return new TodoPage();
        } catch (Exception e) {
            throw new RuntimeException("Login failed.", e);
        }
    }

    /**
     * Enters the specified email into the email input field.
     *
     * @param email the email to enter.
     */
    private void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    /**
     * Enters the specified password into the password input field.
     *
     * @param password the password to enter.
     */
    private void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    /**
     * Clicks the login button.
     */
    private void clickLoginButton() {
        loginSubmitButton.click();
    }
}
