package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * LoginTest class contains test case for logging in with email and password.
 */
public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword() {
        try {
            LoginPage loginPage = new LoginPage();
            boolean isWelcomeDisplayed =
                    loginPage
                            .load()
                            .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                            .isWelcomeMessageDisplayed();
            Assert.assertTrue(isWelcomeDisplayed, "Welcome message should be displayed.");
        } catch (Exception e) {
            throw new RuntimeException("Test failed: Unable to login with email and password.", e);
        }
    }
}
