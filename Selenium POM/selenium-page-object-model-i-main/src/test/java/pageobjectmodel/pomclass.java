package pageobjectmodel;

import org.openqa.selenium.*;

public class pomclass {
	WebDriver driver;

	By mainmenu=By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[1]/div/div/div/header/div/div[3]/nav/div[2]/div/button");
	By signup_login=By.linkText("Sign up");
	By phno=By.id("phoneInputphoneNumber");
	By continue_log=By.className("_1n35162");
	By mainsearch=By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[1]/div/div/div/header/div/div[2]/div[1]/div/span[2]/button[3]/div[2]");
	By addguests=By.xpath("//*[@id=\"search-tabpanel\"]/div[1]/div[5]/div[1]/div[1]");
	By adults=By.xpath("//*[@id=\"stepper-adults\"]/button[2]");
	By childrens=By.xpath("//*[@id=\"stepper-children\"]/button[2]/span");
	By checkin=By.xpath("//*[@id=\"search-tabpanel\"]/div[1]/div[3]/div[1]/div/div");
	By indate=By.xpath("//*[@id=\"panel--tabs--0\"]/div/div[1]/div/div/div/div[2]/div[2]/div/div[3]/div/table/tbody/tr[2]/td[7]/div");
	By outdate=By.xpath("//*[@id=\"panel--tabs--0\"]/div/div[1]/div/div/div/div[2]/div[2]/div/div[3]/div/table/tbody/tr[3]/td[2]/div");
	By destinysearch=By.name("query");
	By searchclick=By.cssSelector(".t1dqvypu.dir.dir-ltr");
	By includetax=By.xpath("//*[@id=\"site-content\"]/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div/div[2]/button/div");
	
	By close_login=By.cssSelector(".i3tjjh1.dir.dir-ltr");
	
	public pomclass(WebDriver driver1) {
		this.driver=driver1;
	}
	
	public void signup_login(String no) throws InterruptedException {
		driver.findElement(mainmenu).click();
		driver.findElement(signup_login).click();
		driver.findElement(phno).click();
		driver.findElement(phno).sendKeys(no);
		Thread.sleep(5000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(continue_log).click();
		Thread.sleep(5000);
		driver.findElement(close_login).click();
	}
	
	public void details(String searchname) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(mainsearch).click();
		driver.findElement(destinysearch).sendKeys(searchname);
		driver.findElement(addguests).click();
		WebElement e1= driver.findElement(adults);
		WebElement e2=driver.findElement(childrens);
		for(int i=0;i<5;i++) {
			e1.click();
			e2.click();
		}
		driver.findElement(checkin).click();
		driver.findElement(indate).click();
		driver.findElement(outdate).click();
	}
	
	public void searchloc() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(searchclick).click();
		driver.findElement(includetax).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle()+"\n"+driver.getCurrentUrl());
	}
}
