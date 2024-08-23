package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterAPI;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Todo Management")
public class TodoTest extends BaseTest {

    @Test(description = "Should be able to add a new todo correctly")
    @Story("Add new todo")
    @Description("This test verifies that a user can add a new todo item successfully.")
    public void shouldBeAbleToAddNewTodo() {
        RegisterAPI registerApi = new RegisterAPI();
        registerApi.register();

        NewTodoPage newTodoPage = new NewTodoPage();
        newTodoPage.load();

        injectCookiesToBrowser(registerApi.getRestAssuredCookies());

        String actualResult = addNewTodoItem(newTodoPage, "Learn Selenium");
        Assert.assertEquals(actualResult, "Learn Selenium");
    }

    @Step("Add a new todo item with text: {0}")
    private String addNewTodoItem(NewTodoPage newTodoPage, String todoText) {
        return newTodoPage
                .load()
                .addNewTodo(todoText)
                .getTodoText();
    }

    @Test(description = "Should be able to delete todo")
    @Story("Delete todo")
    @Description("This test verifies that a user can delete a todo item successfully.")
    public void shouldBeAbleToDeleteTodo() {
        RegisterAPI registerApi = new RegisterAPI();
        registerApi.register();

        TaskApi tasksApi = new TaskApi();
        tasksApi.addTask(registerApi.getAccessToken());

        TodoPage todoPage = new TodoPage();
        todoPage.load();

        injectCookiesToBrowser(registerApi.getRestAssuredCookies());

        boolean isNoTodoMessageDisplayed = deleteTodoItem(todoPage);
        Assert.assertTrue(isNoTodoMessageDisplayed);
    }

    @Step("Delete a todo item")
    private boolean deleteTodoItem(TodoPage todoPage) {
        return todoPage
                .load()
                .clickOnDeleteTodoButton()
                .isNoTodoMessageDisplayed();
    }
}
