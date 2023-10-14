package selenium_advanced;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class orangehrm_classobject {
	WebDriver driver;
	@FindBy(name="username")
	WebElement ohrmuser;
	
	@FindBy(name="password")
	WebElement ohrmpass;
	
	@FindBy(xpath ="//button[@type='submit']" )
	WebElement ohrmsubmit;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")
	WebElement log_drop;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")
	WebElement log_but;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")
	WebElement emp_fname;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input")
	WebElement emp_mname;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")
	WebElement emp_lname;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
	WebElement emp_id;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")
	WebElement emp_create_log;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
	WebElement log_user;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")
	WebElement log_pass;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")
	WebElement log_pass_confirm;
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
	WebElement log_save;
	
	public orangehrm_classobject(WebDriver driver2) {
		this.driver=driver2;
	}
	
	public void blankuser(String pass) throws InterruptedException {
		  Thread.sleep(2000);
		  ohrmpass.sendKeys(pass);
		  ohrmsubmit.click();
		  driver.navigate().refresh();
		  Thread.sleep(2000);
	  }
	
	public void blankpass(String user) throws InterruptedException {
		  ohrmuser.sendKeys(user);
		  Thread.sleep(2000);
		  ohrmsubmit.click();
		  driver.navigate().refresh();
		  Thread.sleep(2000);
	  }
	
	 public void invaliduser(String user,String pass) throws InterruptedException {
		  ohrmuser.sendKeys(user);
		  ohrmpass.sendKeys(pass);
		  ohrmsubmit.click();
		  driver.navigate().refresh();
		  Thread.sleep(2000);
	  }
	 
	 public void invalidpass(String user,String pass) throws InterruptedException {
		  ohrmuser.sendKeys(user);
		  ohrmpass.sendKeys(pass);
		  ohrmsubmit.click();
		  driver.navigate().refresh();
		  Thread.sleep(2000);
	  }
	 
	 public void validuserpass(String user,String pass) throws InterruptedException {
		  ohrmuser.sendKeys(user);
		  ohrmpass.sendKeys(pass);
		  ohrmsubmit.click();
		  driver.navigate().refresh();
		  Thread.sleep(2000);
	  }
	 
	 public void logout() throws InterruptedException {
		  log_drop.click();
		  Thread.sleep(2000);
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")));
		  Actions a=new Actions(driver);
		  a.moveToElement(log_but).perform();
		  Thread.sleep(3000);
		  element.click();
		  Thread.sleep(3000);
	  }
	 
	 public void addemployee(String user,String pass,String fname,String mname,String lname,String id,String loguser,String logpass) throws InterruptedException {
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		  Thread.sleep(2000);
		  ohrmuser.sendKeys(user);
		  ohrmpass.sendKeys(pass);
		  ohrmsubmit.click();
		  Thread.sleep(5000);
		  emp_fname.sendKeys(fname);
		  emp_mname.sendKeys(mname);
		  emp_lname.sendKeys(lname);
		  emp_id.sendKeys(id);
		  Thread.sleep(2000);
		  emp_create_log.click();
		  Thread.sleep(2000);
		  log_user.sendKeys(loguser);
		  log_pass.sendKeys(logpass);
		  log_pass_confirm.sendKeys(logpass);
		  Thread.sleep(2000);
		  
		  Actions a=new Actions(driver);
		  a.moveToElement(log_save).perform();
		  Thread.sleep(3000);
		  log_save.click();
		  Thread.sleep(5000);
	 }
}
