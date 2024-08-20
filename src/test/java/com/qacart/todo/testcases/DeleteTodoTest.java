package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteTodoTest extends BaseTest {
    @Test
    public void ShouldBeAbleToAddNewTodo() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        loginPage.login("test@test.com" , "test1234");
        driver.findElement(By.cssSelector("[data-testid=\"delete\"]")).click();
        boolean isNoTodoDisplayed = driver.findElement(By.cssSelector("[data-testid=\"no-todos\"]")).isDisplayed();
        Assert.assertTrue(isNoTodoDisplayed);
        driver.quit();
    }
}