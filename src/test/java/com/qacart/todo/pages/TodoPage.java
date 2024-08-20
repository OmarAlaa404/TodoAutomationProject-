package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }

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



    public boolean isWelcomeMessageDisplayed (){
        return welcomeMessage.isDisplayed();
    }
    public void clickOnAddNewTodoButton(){
        addNewTodoButton.click();
    }
    public String getTodoText(){
        return todoItem.getText();
    }
    public void clickOnDeleteTodoButton(){
        deleteTodoButton.click();
    }
    public boolean isNoTodoMessageDisplayed (){
        return noTodoMessage.isDisplayed();
    }
}
