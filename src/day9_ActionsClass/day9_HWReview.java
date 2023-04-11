package day9_ActionsClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class day9_HWReview {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");

	}
	
	public static void testcase2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.get("http://practice.primetech-apps.com/practice/frames");
		
		boolean isframetxt = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
		if (isframetxt) {
			System.out.println("Frame text is there");
		} else {
			System.out.println("Frame text IS NOT there");
		}
		
		driver.switchTo().frame("iframe1");
		driver.findElement(By.id("firstName")).sendKeys("Bro");
		driver.findElement(By.id("lastname")).sendKeys("Bruh");
		driver.findElement(By.id("address")).sendKeys("420 Brah Street");
		driver.findElement(By.id("city")).sendKeys("Broski City");
		driver.findElement(By.id("zipCode")).sendKeys("12345");
		
		Select stateSelect = new Select(driver.findElement(By.id("state")));
		stateSelect.selectByVisibleText("Virginia");
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		boolean infoText = driver.findElement(By.xpath("//h3[text()='You have submitted below information: ']")).isDisplayed();

		if (infoText) {
			System.out.println("Info Text is there");
		} else {
			System.out.println("Info Text IS NOT THERE!!!");
		}

		driver.switchTo().parentFrame();
		
		boolean istxt = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
		if (istxt) {
			System.out.println("Frame text is there.");
		}else {
			System.out.println("Frame text is NOT there.");
		}
		
		driver.quit();
	}
	
	public static void testcase1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.get("http://demo.guru99.com/popup.php");

		String mainPageTitle = driver.getTitle();
		String mainPageWindowId = driver.getWindowHandle();
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		for(String str : windowIds) {
			if (!str.equals(mainPageWindowId)) {
				driver.switchTo().window(str);
			}
		}
		
		driver.findElement(By.name("emailid")).sendKeys("test@email.com");
		driver.findElement(By.name("btnLogin")).click();
		
		String userId = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling:td")).getText();
		String password = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling:td")).getText();
		System.out.println("User ID: " + userId);
		System.out.println("Password: " + password);
		
		String message = driver.findElement(By.xpath("//h3[contains(text(), 'This access')]")).getText();
		if (message.equals("This access is valid only for 20 days")) {
			System.out.println("Test PASS");
		} else {
			System.out.println("Test FAIL");
		}
		
		driver.close();
		
		driver.switchTo().window(mainPageWindowId);
		if (driver.getTitle().equals(mainPageTitle)) {
			System.out.println("We are back to the Main Page");
		} else {
			System.out.println("WE ARE LOST");
		}
		
		driver.quit();
	}
}
