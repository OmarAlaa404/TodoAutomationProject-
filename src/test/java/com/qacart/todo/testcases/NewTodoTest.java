package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * NewTodoTest class contains test case for adding a new todo item.
 */
public class NewTodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddNewTodo() {
        try {
            LoginPage loginPage = new LoginPage();
            String actualResult = loginPage
                    .load()
                    .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                    .clickOnAddNewTodoButton()
                    .addNewTodo("TestNewTodo").getTodoText();
            Assert.assertEquals(actualResult, "TestNewTodo", "The added todo item text does not match the expected result.");
        } catch (Exception e) {
            throw new RuntimeException("Test failed: Unable to add new todo.", e);
        }
    }
}
