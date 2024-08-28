package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * LoginTest class contains test cases for verifying the login functionality.
 * The tests ensure that users can log in with valid credentials and that the correct page elements are displayed.
 */
@Feature("Authentication")
public class LoginTest extends BaseTest {

    /**
     * Verifies that a user can log in with valid email and password.
     * This test checks if the welcome message is displayed after a successful login.
     */
    @Test(description = "Test Login Functionality With Valid Email and Password")
    @Story("Login with valid credentials")
    @Description("This test verifies that a user can log in with valid email and password.")
    public void shouldBeAbleToLoginWithEmailAndPassword() {
        try {
            LoginPage loginPage = new LoginPage();
            boolean isWelcomeDisplayed = loginWithValidCredentials(loginPage);
            Assert.assertTrue(isWelcomeDisplayed, "Welcome message should be displayed.");
        } catch (Exception e) {
            throw new RuntimeException("Test failed: Unable to login with email and password.", e);
        }
    }

    /**
     * Performs the login action with valid credentials and checks if the welcome message is displayed.
     *
     * @param loginPage the LoginPage object to interact with the login page.
     * @return true if the welcome message is displayed, false otherwise.
     */
    @Step("Log in with valid email and password")
    private boolean loginWithValidCredentials(LoginPage loginPage) {
        return loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .isWelcomeMessageDisplayed();
    }
}
