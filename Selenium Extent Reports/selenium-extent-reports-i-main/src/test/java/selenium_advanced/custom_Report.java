package selenium_advanced;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.text.numbers.DoubleFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class custom_Report {
   WebDriver driver;
   ExtentReports extent;
   ExtentSparkReporter spark;
   ExtentTest test;
	
  @Test(dataProvider = "dp")
  public void main(String wrong_user,String wrong_pass,String correct_user,String correct_pass,String fname,String mname,String lname,String id,String loguser,String logpass,String screenshot) throws InterruptedException {
	  
	  driver.get("https://opensource-demo.orangehrmlive.com");
	  test=extent.createTest("Launch Browser, login orangehrm with all possible ways and do log out and login again and add employee details");
	  
	  orangehrm_classobject obj1=PageFactory.initElements(driver, orangehrm_classobject.class);
	  obj1.blankuser(correct_pass);
	  obj1.blankpass(correct_user);
	  obj1.invaliduser(wrong_user,correct_pass);
	  obj1.invalidpass(correct_user,wrong_pass);
	  obj1.validuserpass(correct_user,correct_pass);
	  obj1.logout();
	  obj1.addemployee(correct_user,correct_pass, fname, mname, lname, id, loguser, logpass);
	  
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	  File destfile=new File("./Screenshots/"+screenshot);
	  try {
		  FileUtils.copyFile(sourcefile, destfile);
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  Thread.sleep(3000);
	  test.pass("all functions working fine");
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  extent.flush();
  }


  @DataProvider
  public Object[][] dp() throws IOException {
	  String[][] data=new String[2][11];
	  
	  File file=new File("E:\\ECLIPSE WORKSPACE\\selenium_extent_reports_i\\inputdata.xlsx");
	  FileInputStream fis=new FileInputStream(file);
	  XSSFWorkbook workbook=new XSSFWorkbook(fis);
	  XSSFSheet sheet=workbook.getSheetAt(2);
	  int rowcount=sheet.getPhysicalNumberOfRows();
	  System.out.println("row count:"+rowcount);
	  
	  for(int i=0;i<rowcount;i++)
	  {
		 
		  data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
		  data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
		  data[i][2]=sheet.getRow(i).getCell(2).getStringCellValue();
		  data[i][3]=sheet.getRow(i).getCell(3).getStringCellValue();
		  data[i][4]=sheet.getRow(i).getCell(4).getStringCellValue();
		  data[i][5]=sheet.getRow(i).getCell(5).getStringCellValue();
		  data[i][6]=sheet.getRow(i).getCell(6).getStringCellValue();
		  
		  DecimalFormat df=new DecimalFormat("#");
		  data[i][7]= df.format(sheet.getRow(i).getCell(7).getNumericCellValue());
		  data[i][8]=sheet.getRow(i).getCell(8).getStringCellValue();
		  data[i][9]=sheet.getRow(i).getCell(9).getStringCellValue();
		  data[i][10]=sheet.getRow(i).getCell(10).getStringCellValue();
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
	  extent=new ExtentReports();
	  spark=new ExtentSparkReporter("./Screenshots/extent_report.html");
	  extent.attachReporter(spark);
  }

  @AfterSuite
  public void afterSuite() {
  }

}
