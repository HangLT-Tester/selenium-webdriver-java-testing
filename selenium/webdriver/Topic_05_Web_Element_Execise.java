package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Element_Execise {
	// Khai báo biến (Declare)
	WebDriver driver;
	String firstName, lastName, emailAddress, password;

	@BeforeClass
	public void beforeClass() {
		// Khởi tạo biến driver
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Khởi tạo data test
		firstName = "Ha";
		lastName = "Le";
		emailAddress = "HaLe" + generateEmail();
		password = "123456";
	}

	@Test
	public void TC_01_Create_New_Account() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		driver.findElement(By.id("lastname")).sendKeys(lastName);
		driver.findElement(By.id("email_address")).sendKeys(emailAddress);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmation")).sendKeys(password);
	
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "Thank you for registering with Main Website Store.");
		
		
		
	}

	@Test
	public void TC_02_Login() {
		
	}

	@Test
	public void TC_03_() {
		
	}
	@Test
	public void TC_04() {
		// ...
	}

	@AfterClass
	//public void afterClass() {
		//driver.quit();
	//}
	
	public String generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@email.vn";
	}
	
	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}