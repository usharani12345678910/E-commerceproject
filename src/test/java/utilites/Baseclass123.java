package utilites;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.configuration.Theme;


public class Baseclass123  {
	Readconfig read=new Readconfig();
	 
	public static  WebDriver driver=null;
	
	
	public static Logger logger;
@BeforeClass
public void setup() {
	
	
	logger = Logger.getLogger("naveen automation labs ");
	PropertyConfigurator.configure("Log4j.properties");
	
System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"drivers"+File.separator+"chromedriver.exe");
 driver= new ChromeDriver();
 
 driver.get(read.geturl());
 driver.manage().window().maximize();}
 
@BeforeMethod
public void login() {
 driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
 driver.findElement(By.linkText("Login")).click();
logger.info("login url");
 driver.findElement(By.id("input-email")).sendKeys(read.getusername());

 driver.findElement(By.id("input-password")).sendKeys(read.getpassword());
 driver.findElement(By.xpath("//input[@type='submit']")).click();
 
}
@AfterClass
public void closeConnection() throws IOException, InterruptedException {
	Thread.sleep(5000);
	
logger.info("driverclosed");
	
	driver.close();
	
	
}public String getScreenhot() throws IOException {
	String timeStamp1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	String repName1="scrrenshot"+timeStamp1+".png";
	String screenshotPath= System.getProperty("user.dir")+"\\Screenshots\\"+ repName1;
	 TakesScreenshot src=(TakesScreenshot)driver;
File	screenshot=src.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(screenshot, new File(screenshotPath));
	return screenshotPath;
}
	
}



