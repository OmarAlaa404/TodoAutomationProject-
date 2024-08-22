package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterAPI;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {

    @Test(description = "Should be able to add a new todo correctly")
    public void shouldBeAbleToAddNewTodo() {
        RegisterAPI registerApi = new RegisterAPI();
        registerApi.register();

        NewTodoPage newTodoPage = new NewTodoPage();
        newTodoPage.load();

        injectCookiesToBrowser(registerApi.getRestAssuredCookies());

        String actualResult = newTodoPage
                .load()
                .addNewTodo("Learn Selenium")
                .getTodoText();

        Assert.assertEquals(actualResult, "Learn Selenium");
    }


    @Test
    public void shouldBeAbleToDeleteTodo() {
        RegisterAPI registerApi = new RegisterAPI();
        registerApi.register();

        TaskApi tasksApi = new TaskApi();
        tasksApi.addTask(registerApi.getAccessToken());

        TodoPage todoPage = new TodoPage();
        todoPage.load();

        injectCookiesToBrowser(registerApi.getRestAssuredCookies());

        boolean isNoTodoMessageDisplayed = todoPage
                .load()
                .clickOnDeleteTodoButton()
                .isNoTodoMessageDisplayed();

        Assert.assertTrue(isNoTodoMessageDisplayed);
    }

}
