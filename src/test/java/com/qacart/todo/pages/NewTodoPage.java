package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement newTodoInput;
    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement newTodoSubmitButton;

    public TodoPage addNewTodo(String item) {
        newTodoInput.sendKeys(item);
        newTodoSubmitButton.click();
        return new TodoPage(driver);
    }
}
