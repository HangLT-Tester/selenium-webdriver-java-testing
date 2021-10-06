package webdriver;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Web_Browser_Method {
	//Interface
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver(); 
	}

	@Test
	public void TC_01_Browwser() {
		//Bien driver tuong tac vs browser
		driver.
		
		//Bien  ... tuong tac vs element (textbox, dropdown...)
	}

	

	}
}