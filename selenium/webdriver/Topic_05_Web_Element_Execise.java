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
	String firstName, lastName, emailAddress, password, fullName;
	By emailTextbox = By.id("mail");
	By educationTextarea = By.id("edu");
	By under18RadioButton = By.id("under_18");
	By JavaCheckbox = By.id("java");
	
	By passwordTextbox = By.id("password");
	By disableCheckbox = By.id("check-disbaled");
	By disableButton = By.id("button-disabled");

	@BeforeClass
	public void beforeClass() {
		// Khởi tạo biến driver
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Khởi tạo data test
		firstName = "Ha";
		lastName = "Le";
		fullName = firstName + " " + lastName;
		emailAddress = "HaLe" + generateEmail();
		password = "123456";
	}

	//@Test
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
		
		//Dùng hàm isDisplayed để kiểm tra
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p[contains(string(),'" + fullName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p[contains(string(),'" + emailAddress + "')]")).isDisplayed());
		
		//Dùng hàm getText và verify contains (fullname/ email)
		String contactInfomation = driver.findElement(By.xpath(" //h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		System.out.println(contactInfomation);
		
		Assert.assertTrue(contactInfomation.contains(fullName));
		Assert.assertTrue(contactInfomation.contains(emailAddress));
		
		driver.findElement(By.cssSelector(".skip-account")).click();
		
		driver.findElement(By.cssSelector("a[title='Log Out']")).click();
		
	}

	//@Test
	public void TC_02_Login() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.cssSelector("#email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']//strong")).getText(), "Hello, " + fullName + "!");
	}

	//@Test
	public void TC_03_Displayed_Newbie() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		if(driver.findElement(By.id("mail")).isDisplayed()) {
			driver.findElement(By.id("mail")).sendKeys("Automation FC");
			System.out.println("Mail textbox is displayed");
		} else {
			System.out.println("Mail textbox is not displayed");
		}
		
		
		if(driver.findElement(By.id("edu")).isDisplayed()) {
			driver.findElement(By.id("edu")).sendKeys("Automation FC");
			System.out.println("Education Textarea is displayed");
		} else {
			System.out.println("Education Textarea is not displayed");
		}
		
		if(driver.findElement(By.id("under_18")).isDisplayed()) {
			driver.findElement(By.id("under_18")).click();
			System.out.println("Radio button Under 18 is displayed");
		} else {
			System.out.println("Radio button Under 18 is not displayed");
		}
	}
	
	//@Test
	public void TC_03_Displayed_Function() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		if(isElementDisplayed(emailTextbox)) {
			senkeyToElement(emailTextbox, "Automation FC");
		}
		
		if(isElementDisplayed(educationTextarea)) {
			senkeyToElement(educationTextarea, "Automation FC");
		}
	
		if(isElementDisplayed(under18RadioButton)) {
			clickRadioButton(under18RadioButton);
		}
		
	}
	
	
	
	//@Test
	public void TC_04_Selected_Function() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		clickRadioButton(under18RadioButton);
		clickRadioButton(JavaCheckbox);
		
		//Verify checkbox/radio đã được chọn
		Assert.assertTrue(isElementSelected(under18RadioButton));
		Assert.assertTrue(isElementSelected(JavaCheckbox));
		
		//Bỏ chọn checkbox Java
		clickRadioButton(JavaCheckbox);
		
		//Verify checkbox chưa được chọn
		Assert.assertTrue(isElementSelected(under18RadioButton));
		Assert.assertFalse(isElementSelected(JavaCheckbox));		
	}
	
	@Test
	public void TC_05_Enabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Expected enable
		Assert.assertTrue(isElementEnable(emailTextbox));
		Assert.assertTrue(isElementDisplayed(educationTextarea));
		Assert.assertTrue(isElementEnable(under18RadioButton));
		Assert.assertTrue(isElementEnable(JavaCheckbox));
		
		//Expected disnable
		Assert.assertFalse(isElementEnable(passwordTextbox));
		Assert.assertFalse(isElementEnable(disableCheckbox));
		Assert.assertFalse(isElementEnable(disableButton));
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	public boolean isElementDisplayed(By by) {
		if (driver.findElement(by).isDisplayed()){
			System.out.println(by + "is displayed");
			return true;
		} else {
			System.out.println(by + "is not displayed");
			return false;
		}
	}
	
	public void senkeyToElement(By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
	}
	
	public void clickRadioButton(By by) {
		driver.findElement(by).click();
	}
	
	public boolean isElementSelected(By by) {
		if (driver.findElement(by).isSelected()){
			System.out.println(by + "is selected");
			return true;
		} else {
			System.out.println(by + "is not selected");
			return false;
		}
	}
	
	public boolean isElementEnable(By by) {
		if (driver.findElement(by).isEnabled()){
			System.out.println(by + "is enable");
			return true;
		} else {
			System.out.println(by + "is disable");
			return false;
		}
	}
	
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