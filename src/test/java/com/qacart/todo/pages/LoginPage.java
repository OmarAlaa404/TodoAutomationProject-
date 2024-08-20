package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

public void load(){
    driver.get("https://todo.qacart.com/login");
}
    public void login (String email , String password){
    emailInput.sendKeys(email);
    passwordInput.sendKeys(password);
    loginSubmitButton.click();
}

}
