package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Element_Method {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		//Mở ra 1 trình duyệt
		driver = new FirefoxDriver();
		
		// Wait cho 1 element xuất hiện trong 1 khoảng time là xx second
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Mở 1 cái page url
		driver.get("https://demo.nopcommerce.com/"); 
	}

	@Test
	public void TC_01_Web_Element() {
		// muốn thao tác với element thì phải tìm element trước
		
		//Thao tác với 1 element
		driver.findElement(By.id(""));
		
		//Tìm nhiều element
		driver.findElements(By.id(""));
		
		// Nếu như chỉ thao tác với element 1 lần thì không cần khai báo biến
		driver.findElement(By.id("small-searchterms")).sendKeys("Apple");
		
		// Nếu cần thao tác với element nhiều lần thì nên khai báo biến
		WebElement searchTextbox = driver.findElement(By.id("small-searchterms"));
		searchTextbox.clear();
		searchTextbox.sendKeys("Apple");
		searchTextbox.getAttribute("value");
		
		
		// Đêm xem có bao nhiêu element thỏa mãn đk
		// Verify số lượng element tả về như mong đợi
		// Thao tác với tất cả các loại element giống nhau trong 1 page (checkbox, textbox...)
	List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='inputs']/input[not(@type='checkbox')]"));
		
		//Lấy ra số lượng
		checkboxes.size();
		
		//Verify có đúng 6 texbox tại form Đăng ký
		Assert.assertEquals(checkboxes.size(), 6);
		
		WebElement singleElement = driver.findElement(By.className(""));
		
		//Texbox, TexArrea, Edittable dropdown
		//Dữ liệu được toàn vẹn
		singleElement.clear();
		singleElement.sendKeys("");
		
		//Button, Link, Radio, Checkbox, Custum Dropdown,...
		singleElement.click();
		
		//Các hàm có tiền tố bắt đầu băng Get luôn luôn trả về dữ liệu
		// getTitle, getCurrentUrl, getPageSource, getAttribute, getCssValue, getText,...
		singleElement.getAttribute("");
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