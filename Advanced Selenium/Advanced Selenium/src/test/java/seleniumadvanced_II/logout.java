package seleniumadvanced_II;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class logout {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
	@BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
  	  driver=new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);;
    driver.manage().window().maximize();
    }

    @Test
	public void testLogout() {
    	driver.get("https://opensource-demo.orangehrmlive.com");
        // Locate and interact with the login elements
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        
        // Perform the login with blank username and password
        usernameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();
    	WebElement menu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i"));
        List<WebElement> menuItems = menu.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a"));

        for (WebElement menuItem : menuItems) {
            if (menuItem.getText().equals("Logout")) {
                menuItem.click();
                break;
            }
        }
        try {
            captureScreenshot("testLogout_failure");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // Helper method to capture screenshots
    public void captureScreenshot(String screenshotName) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File("screenshots/" + screenshotName + ".png");
        FileUtils.copyFile(screenshotFile, targetFile);
    }
}
