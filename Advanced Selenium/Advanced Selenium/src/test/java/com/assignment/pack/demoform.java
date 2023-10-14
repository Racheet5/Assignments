package com.assignment.pack;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoform {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set up the WebDriver (Assuming ChromeDriver here)
    	WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void fillAboutMeForm() throws InterruptedException {
        // Step 1: Open the link
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        // Step 2: Fill in the form
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Doe");

        // Step 3: Select gender
        driver.findElement(By.id("sex-0")).click(); // Assuming "Male" option

        // Step 4: Select years of experience
        driver.findElement(By.id("exp-4")).click(); // Assuming 5-10 years

        // Step 5: Enter date
        driver.findElement(By.id("datepicker")).sendKeys("2023-08-25");

        // Step 6: Select profession
        driver.findElement(By.id("profession-1")).click(); // Assuming "Automation Tester"

        // Step 7: Select automation tools
        driver.findElement(By.id("tool-0")).click(); // Assuming "Selenium WebDriver"
        driver.findElement(By.id("tool-2")).click(); // Assuming "Git"

        // Step 8: Select continent
        Select continentDropdown = new Select(driver.findElement(By.id("continents")));
        continentDropdown.selectByVisibleText("Asia");

        // Step 9: Select multiple commands
        Select commandsMultiSelect = new Select(driver.findElement(By.id("selenium_commands")));
        commandsMultiSelect.selectByVisibleText("Switch Commands");
        commandsMultiSelect.selectByVisibleText("WebElement Commands");

        // Step 10: Upload image (if you choose to implement this)

        // Step 11: Click on Submit button
        Thread.sleep(5000);
        driver.findElement(By.id("submit")).click();

        // You can add assertions here to verify form submission if needed
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
