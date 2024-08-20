package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class NewTodoTest extends BaseTest {
    @Test
    public void ShouldBeAbleToAddNewTodo() {
        driver.get("https://todo.qacart.com/login");
        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("test1234");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"add\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"new-todo\"]")).sendKeys("TestTodo");
        driver.findElement(By.cssSelector("[data-testid=\"submit-newTask\"]")).click();
        String actualResult = driver.findElement(By.cssSelector("[data-testid=\"todo-item\"]")).getText();
        Assert.assertEquals(actualResult,"TestTodo");
    }
}