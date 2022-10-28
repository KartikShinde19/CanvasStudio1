package canvasStudio;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assesment1 {

	public WebDriver driver;
	
	@BeforeMethod
	public void base() {
		System.setProperty("webdriver.chrome.driver","D:\\kartik testing report\\Automation\\drivers\\chromedriver_v105\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void practice() throws Exception {                                   
		driver.get("http://www.htmlcanvasstudio.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Chosen Drawing']")).click();
		
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		driver.findElement(By.xpath("//a[text()='Create a new canvas']")).click();
		
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		driver.findElement(By.xpath("//input[@title='Draw a line']")).click();
		WebElement sheet = driver.findElement(By.xpath("//div[@id='container']"));
		
		Actions act = new Actions(driver);
		
		//horizontal line
		act.moveToElement(sheet, 0, 85).clickAndHold().build().perform();
		Thread.sleep(3000);
		act.moveToElement(sheet, 135, 85).click().perform();
		act.release().perform();
		driver.findElement(By.xpath("//input[@title='Draw a line']")).click();
		Thread.sleep(3000);
		
		//vertical line
		act.moveToElement(sheet, 55, 55).clickAndHold().perform();
		act.moveToElement(sheet, 55, 135).click().perform();
		act.release().perform();
		
		//rectangle
		driver.findElement(By.xpath("//input[@title='Draw a rectangle']")).click();
		act.moveToElement(sheet, 0, 15).clickAndHold().perform();
		act.moveToElement(sheet, 35, 35).click().perform();
		act.release().perform();
      
		//eraser
		driver.findElement(By.xpath("//input[@title='Use eraser']")).click();
		act.moveToElement(sheet, 0, 85).clickAndHold().build().perform();
		act.moveToElement(sheet, 135, 85).click().perform();
		act.release().perform();
		
		Thread.sleep(3000);
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
