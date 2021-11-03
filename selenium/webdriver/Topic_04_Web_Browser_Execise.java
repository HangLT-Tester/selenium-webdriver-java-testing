package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Web_Browser_Execise {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/");
	}

	@Test
	public void TC_01_Verify_URL() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		
		driver.findElement(By.xpath("//div[@class='buttons-set']/a[@class='button']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");
	}

	@Test
	public void TC_02_Verify_Title() {
		driver.findElement(By.xpath("//*[@id='header']//a[@class='logo']")).click();
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		
		driver.findElement(By.xpath("//div[@class='buttons-set']/a[@class='button']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}
	@Test
	public void TC_03_Verify_Navigatetion() {
		driver.findElement(By.xpath("//*[@id='header']//a[@class='logo']")).click();
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//div[@class='buttons-set']/a[@class='button']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");
		
		driver.navigate().back();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		
		driver.navigate().forward();
		sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}
	@Test
	public void TC_04() {
		driver.findElement(By.xpath("//*[@id='header']//a[@class='logo']")).click();
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		// Khai báo và khởi tạo biến tại vị trí màn hình Login
		String currentPageSouce = driver.getPageSource();
		Assert.assertTrue(currentPageSouce.contains("Login or Create an Account"));
		
		driver.findElement(By.xpath("//div[@class='buttons-set']/a[@class='button']")).click();
		sleepInSecond(3);
		// Khởi tạo lại giá trị mới tại màn hình Register
		currentPageSouce = driver.getPageSource();
		Assert.assertTrue(currentPageSouce.contains("Create an Account"));
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