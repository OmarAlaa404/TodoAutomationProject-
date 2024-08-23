package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.config.EndPoint;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * TodoPage class provides methods for interacting with the todo page elements.
 */
public class TodoPage extends BasePage {

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addNewTodoButton;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement todoItem;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteTodoButton;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodoMessage;

    @Step("Load the Todo page")
    public TodoPage load() {
        driver.get(ConfigUtils.getInstance().getBaseURL() + EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }

    @Step("Check if the welcome message is displayed")
    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    @Step("Click on the 'Add New Todo' button")
    public NewTodoPage clickOnAddNewTodoButton() {
        try {
            addNewTodoButton.click();
            return new NewTodoPage();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click 'Add New Todo' button.", e);
        }
    }

    @Step("Get the text of the todo item")
    public String getTodoText() {
        try {
            return todoItem.getText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get todo text.", e);
        }
    }

    @Step("Click on the delete todo button")
    public TodoPage clickOnDeleteTodoButton() {
        try {
            deleteTodoButton.click();
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Failed to click 'Delete Todo' button.", e);
        }
    }

    @Step("Check if the 'No Todos' message is displayed")
    public boolean isNoTodoMessageDisplayed() {
        return noTodoMessage.isDisplayed();
    }
}
