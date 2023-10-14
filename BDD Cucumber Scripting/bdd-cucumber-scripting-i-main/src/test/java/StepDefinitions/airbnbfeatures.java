package StepDefinitions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class airbnbfeatures {
	static WebDriver driver;

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
	
	@Given("launch the browser")
	public void launch_the_browser() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@And("Navigate to the URL")
	public void navigate_to_the_url() {
		driver.get("https://www.airbnb.co.in/");
	}

	@When("the user opens the main menu")
	public void the_user_opens_the_main_menu() {
		driver.findElement(mainmenu).click();
	}

	@And("the user selects the sign-up\\/login option")
	public void the_user_selects_the_sign_up_login_option() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(signup_login).click();
	}

	@And("the user enters a phone number")
	public void the_user_enters_a_phone_number() throws InterruptedException {
		driver.findElement(phno).click();
		driver.findElement(phno).sendKeys("1234567890");
		Thread.sleep(5000);
	}

	@And("clicks continue")
	public void clicks_continue() throws InterruptedException {
		driver.findElement(continue_log).click();
		Thread.sleep(5000);
	}

	@Then("the user closes the login window")
	public void the_user_closes_the_login_window() {
		driver.findElement(close_login).click();
	}

	@Given("the user opens the main search menu")
	public void the_user_opens_the_main_search_menu() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(mainsearch).click();
	}

	@When("the user enters the destination")
	public void the_user_enters_the_destination() {
		driver.findElement(destinysearch).sendKeys("Dandeli");
	}

	@And("adds guests \\(e.g., 5 adults and 5 children)")
	public void adds_guests_e_g_adults_and_children() {
		driver.findElement(addguests).click();
		WebElement e1= driver.findElement(adults);
		WebElement e2=driver.findElement(childrens);
		for(int i=0;i<5;i++) {
			e1.click();
			e2.click();
		}
	}

	@And("selects check-in and check-out dates")
	public void selects_check_in_and_check_out_dates() {
		driver.findElement(checkin).click();
		driver.findElement(indate).click();
		driver.findElement(outdate).click();   
	}

	@And("performs the search")
	public void performs_the_search() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(searchclick).click();
		
	}

	@And("includes taxes in the search")
	public void includes_taxes_in_the_search() throws InterruptedException {
		driver.findElement(includetax).click();
		Thread.sleep(3000);
	    
	}

	@And("the user should see search results")
	public void the_user_should_see_search_results() {
		System.out.println(driver.getTitle()+"\n"+driver.getCurrentUrl());
	}

	@Then("closes the browser")
	public void closes_the_browser() throws InterruptedException {
		Thread.sleep(2000);	
		driver.quit();
	}
	}