package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.config.EndPoint;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * NewTodoPage class provides methods for interacting with the new todo page elements.
 */
public class NewTodoPage extends BasePage {

    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement newTodoInput;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement newTodoSubmitButton;

    /**
     * Loads the NewTodo page by navigating to the specified endpoint.
     * @return this NewTodoPage instance.
     */
    public NewTodoPage load() {
        driver.get(ConfigUtils.getInstance().getBaseURL() + EndPoint.NEW_TODO_ENDPOINT);
        return this;
    }

    /**
     * Adds a new todo item and navigates to TodoPage.
     * @param item Text of the new todo item.
     * @return instance of TodoPage.
     */
    public TodoPage addNewTodo(String item) {
        newTodoInput.sendKeys(item);
        newTodoSubmitButton.click();
        return new TodoPage();
    }
    }

