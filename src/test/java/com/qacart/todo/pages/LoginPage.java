package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utilities.ConfigUtils;
import com.qacart.todo.utilities.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement emailInput;
    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordInput;
    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement loginSubmitButton;
    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    public LoginPage load() {
        driver.get(ConfigUtils.getInstance().getBaseURL());
        return this;
    }

    public TodoPage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginSubmitButton.click();
        return new TodoPage(driver);
    }

}
