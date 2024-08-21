package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * DeleteTodoTest class contains test case for deleting a todo item.
 */
public class DeleteTodoTest extends BaseTest {

    @Test(enabled = false)
    public void shouldBeAbleToAddNewTodo() {
        try {
            LoginPage loginPage = new LoginPage();
            boolean isNoTodoDisplayed = loginPage
                    .load()
                    .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                    .clickOnDeleteTodoButton()
                    .isNoTodoMessageDisplayed();
            Assert.assertTrue(isNoTodoDisplayed, "No todo message should be displayed.");
        } catch (Exception e) {
            throw new RuntimeException("Test failed: Unable to add new todo.", e);
        }
    }
}
