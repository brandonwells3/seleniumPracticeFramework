package day9_ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");

		actionsDemo();
	}
	
	public static void dragAndDropDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		
		Actions letsdoit = new Actions(driver);
		
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		
		WebElement sourceElement = driver.findElement(By.id("text"));
		WebElement targetElement = driver.findElement(By.id(""));
		letsdoit.dragAndDrop(sourceElement, targetElement);
	}
	
	public static void actionsDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		
		Actions letsdoit = new Actions(driver);
		
		driver.get("https://etsy.com");
		
		WebElement jewelryTab = driver.findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));
		letsdoit.moveToElement(jewelryTab).build().perform();
		Thread.sleep(2000);
		
		WebElement bagsPurses = driver.findElement(By.xpath("//span[contains(text(), 'Bags & Purses')])[1]"));
		letsdoit.moveToElement(bagsPurses).build().perform();
		Thread.sleep(2000);
		
		WebElement shoulderBags = driver.findElement(By.xpath("//a[contains(text(), 'Shoulder Bags')]"));
		letsdoit.moveToElement(shoulderBags).build().perform();
		Thread.sleep(2000);
		
		shoulderBags.click();
		
		if (driver.findElement(By.xpath("//h1[text()='Shoulder Bags']")).isDisplayed()) {
			System.out.println("We are on the Bag Page");
		} else {
			System.out.println("We are NOT on the Bag Page");
		}
		
		driver.quit();
	}
}
