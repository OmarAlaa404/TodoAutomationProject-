package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.config.EndPoint;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * NewTodoPage class provides methods for interacting with the new todo page elements.
 * This class includes actions such as loading the new todo page and adding a new todo item.
 */
public class NewTodoPage extends BasePage {

    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement newTodoInput;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement newTodoSubmitButton;

    /**
     * Loads the NewTodo page.
     *
     * @return the current NewTodoPage instance.
     */
    @Step("Load the NewTodo page")
    public NewTodoPage load() {
        try {
            driver.get(ConfigUtils.getInstance().getBaseURL() + EndPoint.NEW_TODO_ENDPOINT);
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load NewTodo page.", e);
        }
    }

    /**
     * Adds a new todo item with the specified text.
     *
     * @param item the text of the new todo item.
     * @return a new instance of the TodoPage.
     */
    @Step("Add a new todo item with text: {0}")
    public TodoPage addNewTodo(String item) {
        try {
            enterTodoText(item);
            submitNewTodo();
            return new TodoPage();
        } catch (Exception e) {
            throw new RuntimeException("Failed to add new todo item.", e);
        }
    }

    /**
     * Enters the specified todo text into the new todo input field.
     *
     * @param item the text to enter.
     */
    private void enterTodoText(String item) {
        newTodoInput.sendKeys(item);
    }

    /**
     * Clicks the submit button to add the new todo item.
     */
    private void submitNewTodo() {
        newTodoSubmitButton.click();
    }
}
