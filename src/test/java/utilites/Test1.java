package utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Test1 extends Baseclass123 {
	@Test

	public void macc() throws InterruptedException {
	
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[input[@type='text']]"))).click().sendKeys("MAC").sendKeys(Keys.ENTER).build().perform();
logger.info("mac detais");
		 Thread.sleep(2000);
		  JavascriptExecutor jse=(JavascriptExecutor)driver; 
		  WebElement ele=driver.findElement(By.linkText("iMac"));
		  jse.executeScript("arguments[0].scrollIntoView();", ele); ele.click();
		  Thread.sleep(2000);
		 
		driver.findElement(By.xpath("(//button[@type='button' and @class='btn btn-default'])[2]")).click();
		 Thread.sleep(3000);
		
	//macbook
		 logger.info("macbook dtails");
		 driver.findElement(By.xpath("//input[@value='MAC']")).clear();
		Actions act1=new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//div[input[@type='text']]"))).click().sendKeys("macbook").sendKeys(Keys.ENTER).build().perform();
		 Thread.sleep(2000);
	driver.findElement(By.xpath("(//img[@title='MacBook'])[2]")).click();
	Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button' and @class='btn btn-default'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'product')]")).click();
		 JavascriptExecutor jse1=(JavascriptExecutor)driver; 
		 //// WebElement ele1=driver.findElement(By.xpath("//h1[text()='Product Comparison']"));
		  //jse1.executeScript("arguments[0].scrollIntoView();", ele1);
		  //Thread.sleep(2000);
		String maccost=driver.findElement(By.xpath("//tbody//tr[3]/td[2]")).getText();
		System.out.println(maccost);
		String macbookcost=driver.findElement(By.xpath("//tbody//tr[3]/td[3]")).getText();
		System.out.println(macbookcost);
		if(maccost==macbookcost)
		{ 
			System.out.println("maccost is better");
			
		}
		else
			
		{
			System.out.println("macbookcost is better");
		}
	}
	
}
