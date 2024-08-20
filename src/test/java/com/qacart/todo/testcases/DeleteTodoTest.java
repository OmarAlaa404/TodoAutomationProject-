package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
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
        TodoPage todoPage = new TodoPage(driver);
        todoPage.clickOnDeleteTodoButton();
        boolean isNoTodoDisplayed = todoPage.isNoTodoMessageDisplayed();
        Assert.assertTrue(isNoTodoDisplayed);
    }
}