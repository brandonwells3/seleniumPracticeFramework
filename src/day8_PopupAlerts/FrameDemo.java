package day8_PopupAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		frameDemo();
	}
	
	public static void frameDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.get("http://practice.primetech-apps.com/practice/frames");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1']")));
		//or driver.switchTo().frame(0);
		driver.findElement(By.id("firstName")).sendKeys("Hello");
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
	}
}
