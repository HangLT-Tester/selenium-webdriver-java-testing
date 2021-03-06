package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_Css_Part_II_Technical {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void TC_01_Login_Empty_Email_Password() {
		//Open home page
		driver.get("http://live.demoguru99.com/index.php");
		
		//Open My Account page at footer
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("");
		driver.findElement(By.name("send")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(), "This is a required field.");
		
		
	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		//Open home page
		driver.get("http://live.demoguru99.com/index.php");
				
		//Open My Account page at footer
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("lehang@123");
		driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("123456");
		driver.findElement(By.name("send")).click();
		
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
		
	}

	@Test
	public void TC_03_Login_Invalid_Password() {
		//Open home page
		driver.get("http://live.demoguru99.com/index.php");
						
		//Open My Account page at footer
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("lehang@gmail.com");
		driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("123");
		driver.findElement(By.name("send")).click();
		
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
		
	}
	
	@Test
	public void TC_04_Login_Incorrect_Password() {
		//Open home page
		driver.get("http://live.demoguru99.com/index.php");
						
		//Open My Account page at footer
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("lehang@gmail.com");
		driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("1235555");
		driver.findElement(By.name("send")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}