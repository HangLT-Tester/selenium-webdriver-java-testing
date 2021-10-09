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
	public void TC_01_Browser() {
		//Bien driver tuong tac vs browser
	    
		//Mở 1 page ra (Url) -> **
		driver.get("https://www.facebook.com/r.php?locale=vi_VN&display=page");
		
		// Lấy ra đường dẫn (url) của page hiện tại -> **
		String localPageUrl = driver.getCurrentUrl();
		
		// Lấy ra title của page hiện tại -> **
		driver.getTitle();
		
		// Lấy HTML code của page hiện tại   123
		driver.getPageSource();
		
		// Xử lý tab/ windows -> **
		driver.getWindowHandle();
		driver.getWindowHandles();
		
		//Framework (Share class state)
		//driver.manage().addCookie(cookie);
		
		//Chờ cho element được tìm thấy trong vòng xx thời gian -> **
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// setScripTimeout
		// pageLoadTimeout
		
		// back về page trước đó
		//foward về page trước đó
		// Refresh page hiện tại
		// Mở 1 url ra
		driver.navigate().back();
		// History (navigate().to("https://www.facebook.com/r.php?locale=vi_VN&display=page"))
		
		// Browser chỉ có 1 tab duy nhất thì đều đóng browser
		
		//Không quan tâm bao nhiêu tab, đóng trình duyệt -> **
		driver.quit();
		
		// Đóng tab đang active
		// Xử lý switch tab/ windows
		driver.close();
		
		// Windows/ Tab-> **
		// Alert -> **
		// Frame/ Iframe -> **
		driver.switchTo().alert();
		
		driver.switchTo().frame(1);
		
		driver.switchTo().window("");
		
		
		driver.manage().window().fullscreen();
		
		// -> **
		driver.manage().window().maximize();
		
		// Test GUI
		//Lấy ra vị trí browser so với độ phân giải màn hình
		driver.manage().window().getPosition();
		//driver.manage().window().setPosition(targetPosition);
		
		driver.manage().window().getSize();
		
		
		//Bien  ... tuong tac vs element (textbox, dropdown...)
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}