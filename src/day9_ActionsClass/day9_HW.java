package day9_ActionsClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class day9_HW {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");

		testcase1();
	}
	
	public static void testcase1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Actions letsdoit = new Actions(driver);
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		Thread.sleep(2000);
		
		WebElement dragAndDrop = driver.findElement(By.xpath("//h3[contains(text(), 'Drag And Drop')]"));
		if (dragAndDrop.isDisplayed()) {
			System.out.println("Drag And Drop is displayed");
		} else {
			System.out.println("Drag And Drop IS NOT DISPLAYED");
		}
		
		WebElement source = driver.findElement(By.id("text"));
		WebElement target = driver.findElement(By.id("dropzone"));
		letsdoit.dragAndDrop(source, target).build().perform();
		Thread.sleep(2000);
		
		WebElement source2 = driver.findElement(By.id("textarea"));
		letsdoit.dragAndDrop(source2, target).build().perform();
		Thread.sleep(2000);
		
		WebElement source3 = driver.findElement(By.id("Number"));
		letsdoit.dragAndDrop(source3, target).build().perform();
		Thread.sleep(2000);
		
		List<WebElement> garbage = driver.findElements(By.xpath("//i[@class='bi bi-trash']"));
		for (int x = 0; x<garbage.size(); x++) {
			garbage.get(x).click();
			Thread.sleep(2000);
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}