package day6_advancedKeys;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day6_KeysEventPractice {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//driver.get("https://google.com");
		driver.navigate().to("https://google.com");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Coffee Mug" + Keys.ENTER);
		Thread.sleep(2000);
		WebElement newSearchBox = driver.findElement(By.name("q"));
		newSearchBox.clear();
		Thread.sleep(2000);
		newSearchBox.sendKeys("Selenium Webdriver" + Keys.ENTER);
		driver.navigate().back();
			newSearchBox.clear();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		driver.close();
	}
}
