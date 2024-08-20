package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void ShouldBeAbleToLoginWithEmailAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isWelcomeDisplayed =
                loginPage
                        .load()
                        .login("test@test.com", "test1234")
                        .isWelcomeMessageDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
    }
}
