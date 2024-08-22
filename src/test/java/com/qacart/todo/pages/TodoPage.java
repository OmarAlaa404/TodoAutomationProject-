package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.config.EndPoint;
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

    /**
     * Loads the Todo page by navigating to the specified endpoint.
     * @return this TodoPage instance.
     */
    public TodoPage load() {
        driver.get(ConfigUtils.getInstance().getBaseURL() + EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }

    /**
     * Checks if the welcome message is displayed.
     * @return true if welcome message is displayed, false otherwise.
     */
    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    /**
     * Clicks on the 'Add New Todo' button and navigates to NewTodoPage.
     * @return instance of NewTodoPage.
     */
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
     * @return Text of the todo item.
     */
    public String getTodoText() {
        try {
            return todoItem.getText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get todo text.", e);
        }
    }

    /**
     * Clicks on the delete todo button and remains on the same page.
     * @return this TodoPage instance.
     */
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
     * @return true if 'No Todos' message is displayed, false otherwise.
     */
    public boolean isNoTodoMessageDisplayed() {
        return noTodoMessage.isDisplayed();
    }
}
