package pageobjectmodel;
import java.text.DecimalFormat;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class pom1 {
  WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void register(String search,String phnumber) throws InterruptedException {
	  driver.get("https://www.airbnb.co.in/");
	  
	  pomclass obj1=new pomclass(driver);
	  obj1.signup_login(phnumber);
	  obj1.details(search);
	  obj1.searchloc();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() throws IOException {
	  String[][] data=new String[2][2];
	  
	  File file=new File("/home/ubuntu/Documents/CGI/selenium-page-object-model-i-main/inputdata.xlsx");
	  FileInputStream fis=new FileInputStream(file);
	  XSSFWorkbook workbook=new XSSFWorkbook(fis);
	  XSSFSheet sheet=workbook.getSheetAt(1);
	  int rowcount=sheet.getPhysicalNumberOfRows();
	  System.out.println("row count:"+rowcount);
	  
	  for(int i=0;i<rowcount;i++)
	  {
		 
		  data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
		  DecimalFormat df=new DecimalFormat("#");
		  data[i][1]= df.format(sheet.getRow(i).getCell(1).getNumericCellValue());
		 
	  }
	    
	 
	  return data;
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
