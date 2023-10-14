package com.assignment.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAutomationTest {

    private WebDriver driver;
    private String url = "https://www.amazon.in/";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testAmazonAutomation() {
        driver.get(url);
        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actualTitle = driver.getTitle();
        System.out.println("actualtitle"+actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title mismatch");

        // Click on Amazon Pay link
        driver.findElement(By.linkText("Best Sellers")).click();
        String expectedPayTitle = "Amazon.in Bestsellers: The most popular items on Amazon";
        String actualPayTitle = driver.getTitle();
        Assert.assertTrue(actualPayTitle.contains(expectedPayTitle),"Amazon Best Sellers title mismatch");

        // Navigate back to Home Page
        driver.navigate().back();

        // Verify the Home Page title
        String expectedHomeTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actualHomeTitle = driver.getTitle();
        Assert.assertTrue(actualHomeTitle.contains(expectedHomeTitle), "Home page title mismatch");

        // Repeat for other menu links...

        // Close the browser
        driver.quit();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
