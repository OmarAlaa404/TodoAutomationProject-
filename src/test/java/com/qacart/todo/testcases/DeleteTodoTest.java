package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteTodoTest extends BaseTest {
    @Test (enabled = false)
    public void ShouldBeAbleToAddNewTodo() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isNoTodoDisplayed = loginPage
                .load()
                .login("test@test.com", "test1234")
                .clickOnDeleteTodoButton()
                .isNoTodoMessageDisplayed();
        Assert.assertTrue(isNoTodoDisplayed);
    }
}