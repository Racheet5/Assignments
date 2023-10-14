package com.assignment.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GO_DADDY {
    
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.godaddy.com/");
    }

    @Test(priority=1)
    public void TitleValidation() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "GoDaddy";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title validation failed");
    }

    @Test(priority=2)
    public void UrlValidation() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.godaddy.com/en-in";
        Assert.assertEquals(actualUrl, expectedUrl, "URL validation failed");
    }

    @Test(priority=3)
    public void PageSourceValidation() {
        String pageSource = driver.getPageSource();
        String pageTitle = "GoDaddy";
        Assert.assertTrue(pageSource.contains(pageTitle), "Page title validation in page source failed");
    }

    @AfterClass
    public void CloseBrowser() {
        driver.quit();
    }
}
