package day6_advancedKeys;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day6_inClassTask {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.navigate().to("https://amazon.com");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Coffee Mug" + Keys.ENTER);
		driver.navigate().back();
		WebElement newSearchBox = driver.findElement(By.id("twotabsearchtextbox"));

		newSearchBox.sendKeys("Pretty Coffee Mug" + Keys.ENTER);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		driver.quit();

	}
	
	public static void listElement() {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get("https://saucedemo.com");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item"));
		int listSize = items.size();
		System.out.println(listSize);
		
		List<WebElement> itemPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
		for(int i = 0; i< itemPrices.size(); i++) {
			System.out.println(itemPrices.get(i).getText());
		}
	}
	
	public static void elementStatus() {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get("https://indeed.com");
		
		WebElement whatField = driver.findElement(By.id("text-input-what"));
		WebElement whereField = driver.findElement(By.id("text-input-where"));
		
		if (whatField.isEnabled() && whatField.isDisplayed()) {
			System.out.println("What Field is Enabled & Displayed");
		} else {
			System.out.println("What Field is NOT Enabled or Displayed");
		}
		
		if (whereField.isEnabled() && whereField.isDisplayed()) {
			System.out.println("Where Field is Enabled & Displayed");
		} else {
			System.out.println("Where Field is NOT Enabled or Displayed");
		}
	}
}
