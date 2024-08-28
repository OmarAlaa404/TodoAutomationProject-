package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.config.EndPoint;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * TodoPage class provides methods for interacting with the todo page elements.
 * This class includes actions such as loading the todo page, adding a new todo,
 * deleting a todo, and checking if certain elements are displayed.
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

    /**
     * Loads the Todo page.
     *
     * @return the current TodoPage instance.
     */
    @Step("Load the Todo page")
    public TodoPage load() {
        try {
            driver.get(ConfigUtils.getInstance().getBaseURL() + EndPoint.TODO_PAGE_ENDPOINT);
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load the Todo page.", e);
        }
    }

    /**
     * Checks if the welcome message is displayed.
     *
     * @return true if the welcome message is displayed, false otherwise.
     */
    @Step("Check if the welcome message is displayed")
    public boolean isWelcomeMessageDisplayed() {
        try {
            return welcomeMessage.isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException("Failed to check if the welcome message is displayed.", e);
        }
    }

    /**
     * Clicks on the 'Add New Todo' button.
     *
     * @return a new instance of NewTodoPage.
     */
    @Step("Click on the 'Add New Todo' button")
    public NewTodoPage clickOnAddNewTodoButton() {
        try {
            addNewTodoButton.click();
            return new NewTodoPage();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click 'Add New Todo' button.", e);
        }
    }

    /**
     * Gets the text of the todo item.
     *
     * @return the text of the todo item.
     */
    @Step("Get the text of the todo item")
    public String getTodoText() {
        try {
            return todoItem.getText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get the todo text.", e);
        }
    }

    /**
     * Clicks on the delete todo button.
     *
     * @return the current TodoPage instance.
     */
    @Step("Click on the delete todo button")
    public TodoPage clickOnDeleteTodoButton() {
        try {
            deleteTodoButton.click();
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Failed to click 'Delete Todo' button.", e);
        }
    }

    /**
     * Checks if the 'No Todos' message is displayed.
     *
     * @return true if the 'No Todos' message is displayed, false otherwise.
     */
    @Step("Check if the 'No Todos' message is displayed")
    public boolean isNoTodoMessageDisplayed() {
        try {
            return noTodoMessage.isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException("Failed to check if the 'No Todos' message is displayed.", e);
        }
    }
}
