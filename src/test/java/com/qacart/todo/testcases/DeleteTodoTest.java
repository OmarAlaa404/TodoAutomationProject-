package com.qacart.todo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteTodoTest {
    @Test
    public void ShouldBeAbleToAddNewTodo() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://todo.qacart.com/login");
        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("test1234");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"delete\"]")).click();
        boolean isNoTodoDisplayed = driver.findElement(By.cssSelector("[data-testid=\"no-todos\"]")).isDisplayed();
        Assert.assertTrue(isNoTodoDisplayed);
        driver.quit();
    }
}