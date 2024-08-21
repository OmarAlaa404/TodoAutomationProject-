package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteTodoTest extends BaseTest {
    @Test (enabled = false)
    public void ShouldBeAbleToAddNewTodo() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isNoTodoDisplayed = loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .clickOnDeleteTodoButton()
                .isNoTodoMessageDisplayed();
        Assert.assertTrue(isNoTodoDisplayed);
    }
}