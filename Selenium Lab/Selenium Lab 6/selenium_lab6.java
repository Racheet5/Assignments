package selenium_06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium_lab6 {
	public static void main(String[] args) throws InterruptedException{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://demo.opencart.com/");
		 driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul[1]/li[3]")).click();
		 driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul[1]/li[3]/div[1]/div[1]/ul[1]/li[2]")).click();
//		 driver.findElement(By.xpath("//*[@id=\"input-limit\"])).click();
//		 driver.findElement(By.linkText("Register")).getAttribute("href"));
//		 driver.findElement(getAttribute("https://demo.opencart.com/index.php?route=product/category&language=en-gb&path=25_28&limit=25")).click();
		 
		 Select lm=new Select(driver.findElement(By.id("input-limit")));
			lm.selectByIndex(1);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//			List<WebElement> alloptions=lm.getOptions();
//			
//			for(int i=0;i<=alloptions.size();i++)
//				
//			{
//				System.out.println(alloptions.get(i).getText());
//				
//			}
//			lm.selectByVisibleText("Name (Z - A)");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id=\"product-list\"]/div[1]/form/div[1]/div[2]/div[2]/button[1]")).click();
			JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		 driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/ul[1]/li[2]")).click();
			driver.findElement(By.id("specification-tab").className("nav-link active")).click();
	}
}
