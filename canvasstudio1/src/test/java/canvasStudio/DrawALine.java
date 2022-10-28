package canvasStudio;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DrawALine {
	
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
		driver.findElement(By.xpath("//input[@title='Draw a line']")).click();
		WebElement sheet = driver.findElement(By.xpath("//div[@id='container']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(sheet, 0, 85).clickAndHold().build().perform();
		Thread.sleep(3000);
		act.moveToElement(sheet, 135, 85).perform();
		act.release().perform();
		Thread.sleep(3000);
		act.moveToElement(sheet, 55, 55).clickAndHold().perform();
		act.moveToElement(sheet, 55, 135).perform();
	}
}
