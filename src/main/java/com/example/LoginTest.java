package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set path to your WebDriver executable (e.g., chromedriver.exe)
        System.setProperty("webdriver.chrome.driver", "D:\\Programming\\Java + Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        // Locate and interact with username and password fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));

        // Enter login credentials
        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");

        // Click on the login button
        loginButton.click();

        // Verify successful login
        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed");

        // Logout process
        WebElement logoutLink = driver.findElement(By.cssSelector("a[href='/logout']"));
        logoutLink.click();

        // Verify successful logout
        WebElement logoutMessage = driver.findElement(By.cssSelector(".flash.success"));
        Assert.assertTrue(logoutMessage.isDisplayed(), "Logout message is not displayed");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

