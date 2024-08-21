package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTodoTest extends BaseTest {
    @Test
    public void ShouldBeAbleToAddNewTodo() {
        LoginPage loginPage = new LoginPage(driver);
        String actualResult = loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .clickOnAddNewTodoButton()
                .addNewTodo("TestNewTodo").getTodoText();
        Assert.assertEquals(actualResult, "TestNewTodo");
    }
}