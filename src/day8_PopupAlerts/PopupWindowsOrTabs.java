package day8_PopupAlerts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupWindowsOrTabs {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		newTabDemo();
	}
	
	public static void windowHandlesExample() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		
		String mainWindowId = driver.getWindowHandle();
		driver.findElement(By.id("newTab")).click();
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> iterate = windowIds.iterator();
		String firstWindowId = iterate.next();
		
		if(firstWindowId.equals(mainWindowId)) {
			System.out.println("First Window Id matches the Main Window Id");
		} else {
			System.out.println("First Window Id DOES NOT match the Main Window Id");
		}
		
		String secondWindowId = iterate.next();
		driver.switchTo().window(secondWindowId);
		
		if(driver.findElement(By.id("newTab")).isDisplayed()) {
			System.out.println("New Tab IS available on the second window");
		} else {
			System.out.println("New Tab IS NOT available on the second window");
		}
		
		driver.close();
		driver.switchTo().window(mainWindowId);
		
		if(driver.getWindowHandle().equals(mainWindowId)) {
			System.out.println("Back to Main Window");
		} else {
			System.out.println("WE ARE LOST");
		}
		
		driver.quit();
	}
	
	public static void newTabDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		
		String mainWindowId = driver.getWindowHandle();
		System.out.println("Main Window Id: " + mainWindowId);
		driver.findElement(By.id("newTab")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {
			System.out.println("Window Id is: " + windowId);
		}
		
		Iterator<String> ids = windowIds.iterator();
		String firstWindowId = ids.next();
		String secondWindowId = ids.next();
		System.out.println("First Window Id: " + firstWindowId);
		System.out.println("Second Window Id: " + secondWindowId);
		
		String newTabTextOnSecondWindow = driver.findElement(By.xpath("//h1[text()='New Tab']")).getText();
		System.out.println(newTabTextOnSecondWindow);
		
		driver.close();
		
		driver.switchTo().window(firstWindowId);
		Thread.sleep(2000);
		String mainWindowText = driver.findElement(By.xpath("//h3[text()='Browser Windows']")).getText();
		System.out.println("Main Window Browser text is: " + mainWindowText);
		
		if(driver.getWindowHandle().equals(mainWindowId)) {
			System.out.println("Test PASS");
		} else {
			System.out.println("Test FAIL");
		}
		
		driver.quit();
	}	
}
