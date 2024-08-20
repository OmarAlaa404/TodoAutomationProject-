package com.qacart.todo.testcases;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTodoTest extends BaseTest {
    @Test
    public void ShouldBeAbleToAddNewTodo() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        loginPage.login("test@test.com" , "test1234");
        TodoPage todoPage = new TodoPage(driver);
        todoPage.clickOnAddNewTodoButton();
        NewTodoPage newTodoPage = new NewTodoPage(driver);
        newTodoPage.addNewTodo("TestNewTodo");
        String actualResult = todoPage.getTodoText();
        Assert.assertEquals(actualResult,"TestNewTodo");
    }
}