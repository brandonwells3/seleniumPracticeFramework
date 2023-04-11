package day8_PopupAlerts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class day8_HW {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		testCase2();
	}
	
	public static void testCase1() throws InterruptedException {
		
		String email = "testemail123@gmail.com";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.get("http://demo.guru99.com/popup.php");
		
		String mainTitle = driver.getTitle();
		String mainID = driver.getWindowHandle();
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> ids = windowIds.iterator();
		
		String firstTab = ids.next();
		String secondTab = ids.next();
				
		driver.switchTo().window(secondTab);
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement>info = driver.findElements(By.xpath("//td[@align='center']"));
	
		String userID = info.get(2).getText();
		System.out.println("User ID: "+ userID);
		
		String pass = info.get(4).getText();
		System.out.println("Password: "+ pass);
		
		String text = info.get(5).getText();
		if(text.equals("This access is valid only for 20 days.")) {
			System.out.println("Text MATCHES");
		} else {
			System.out.println("Text DOES NOT match");
		}
		
		driver.close();
		
		driver.switchTo().window(mainID);
		String currentTitle = driver.getTitle();
		if(currentTitle.equals(mainTitle)) {
			System.out.println("You are on the original page");
		} else {
			System.out.println("YOU ARE LOST");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void testCase2() throws InterruptedException {
		
		String name = "Brandon";
		String last = "Wells";
		String address = "12345 Main St";
		String city = "Ashburn";
		String zip = "98765";
		String state = "Virginia";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.get("http://practice.primetech-apps.com/practice/frames");
		
		if(driver.findElement(By.xpath("//h3[@class='mb-5']")).isDisplayed()) {
			System.out.println("You are on the Frames page");
		} else {
			System.out.println("You are NOT on the frames page");
		}
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 300)", "");
		
		driver.switchTo().frame(0);
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("firstName")).sendKeys(name);
		driver.findElement(By.id("lastName")).sendKeys(last);
		driver.findElement(By.id("address")).sendKeys(address);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("zipCode")).sendKeys(zip);
		
		WebElement selectElement = driver.findElement(By.id("state"));
		Select choose = new Select(selectElement);
		choose.selectByVisibleText(state);
		Thread.sleep(2000);
	
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		wait.until(ExpectedConditions.elementToBeClickable(button));
		js.executeScript("arguments[0].scrollIntoView();", button);	
		Thread.sleep(2000);
		button.click();	
		
		if(driver.findElement(By.xpath("//h3[text()='You have submited below information:']")).isDisplayed()) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test FAIL");
		}
		
		driver.switchTo().parentFrame();
		
		if(driver.findElement(By.xpath("//h3[@class='mb-5']")).isDisplayed()) {
			System.out.println("You are on the Frames page");
		} else {
			System.out.println("You are NOT on the frames page");
		}
		
		Thread.sleep(1000);
		driver.quit();
	}
}