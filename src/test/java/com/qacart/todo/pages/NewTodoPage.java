package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
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
     * Adds a new todo item and navigates to TodoPage.
     * @param item Text of the new todo item.
     * @return instance of TodoPage.
     */
    public TodoPage addNewTodo(String item) {
        try {
            newTodoInput.sendKeys(item);
            newTodoSubmitButton.click();
            return new TodoPage();
        } catch (Exception e) {
            throw new RuntimeException("Failed to add new todo item.", e);
        }
    }
}
