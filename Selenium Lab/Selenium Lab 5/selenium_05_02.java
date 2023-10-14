package selenium_05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium_05_02 {
	public static void main(String[] args) throws InterruptedException{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://demo.opencart.com/");
		 
		 System.out.println(driver.findElement(By.linkText("My Account")).getText());
		driver.findElement(By.linkText("My Account")).click();
		System.out.println(driver.findElement(By.linkText("Register")).getAttribute("href"));
		driver.findElement(By.linkText("Register")).click();
		 WebElement nameInput= driver.findElement(By.id("input-firstname").className("form-control")); 
		 System.out.println("hello");
	        String name = "Racheet";
	        nameInput.sendKeys(name);
//	        nameInput.clear();
	        int expectedMaxLength = 3; 
	        int actualLength = nameInput.getAttribute("value").length();
	        nameInput.clear();
	        System.out.println(actualLength);
	        if (actualLength <= expectedMaxLength) {
	            System.out.println("Name length is within the expected limit.");
	        } else {
	            System.out.println("Name length exceeds the expected limit.");
	        }
	       
	        WebElement lastname= driver.findElement(By.id("input-lastname").className("form-control")); 
			 System.out.println("hello1");
		        String name1 = "Pradhan";
		        lastname.sendKeys(name1);
		        int expectedMaxLength1 = 33; 
		        int actualLength1 = lastname.getAttribute("value").length();
		        lastname.clear();
		        System.out.println(actualLength1);
		        if (actualLength1 <= expectedMaxLength1) {
		            System.out.println("Name length is within the expected limit.");
		        } else {
		            System.out.println("Name length exceeds the expected limit.");
		        }
		        WebElement emailInput = driver.findElement(By.id("input-email"));
		        String email = "test@gmail.com";
		        emailInput.sendKeys(email);
		        String emailPattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
		        Pattern pattern = Pattern.compile(emailPattern);
		        Matcher matcher = pattern.matcher(email);

		        if (matcher.matches()) {
		            System.out.println("Email format is valid.");
		        } else {
		            System.out.println("Email format is not valid.");
		        }
		        
		        
//		        WebElement mobileNumberInput = driver.findElement(By.id("mobile-number-input")); 
//
//		        String mobileNumber = "1234567890"; 
//		        mobileNumberInput.sendKeys(mobileNumber);
//		        String mobileNumberPattern = "\\d{10}";
//		        Pattern pattern1 = Pattern.compile(mobileNumberPattern);
//		        Matcher matcher1 = pattern1.matcher(mobileNumber);
//
//		        if (matcher1.matches()) {
//		            System.out.println("Mobile number format is valid.");
//		        } else {
//		            System.out.println("Mobile number format is not valid.");
//		        }
		        
		        WebElement passwordInput = driver.findElement(By.id("input-password")); 


		        String password = "StrongPass123"; 
		        passwordInput.sendKeys(password);

		        boolean isStrongPassword = isStrongPassword(password);
		        
		        if (isStrongPassword) {
		            System.out.println("Password is strong.");
		        } else {
		            System.out.println("Password is not strong.");
		        }
		        
		        JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				Thread.sleep(3000);

				System.out.println("Yes radio button is displayed:"+driver.findElement(By.id("input-newsletter-yes")).isDisplayed());
				driver.findElement(By.id("input-newsletter-yes")).click();
				
				driver.findElement(By.name("agree")).click();
		        
				driver.findElement(By.linkText("Continue").className("btn btn-primary")).click();
				
//				Alert al=driver.switchTo().alert();
//				al.sendKeys("Your account has been created");
//				System.out.println("Alert Message:"+al.getText());
//				al.accept();	
//				driver.findElement(By.className("list-group-item")).click();
//	        driver.quit();
	}
	 public static boolean isStrongPassword(String password) {
	        return password.length() >= 8 && password.matches(".*[A-Z].*") && 
	        		password.matches(".*[a-z].*") && password.matches(".*\\d.*");
	    }
}
