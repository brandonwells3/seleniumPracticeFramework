package day7_ElementStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownSelect {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");

		dropdownDemo();
	}
	
	public static void dropdownDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
		
		WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
		Select choose = new Select(selectElement);
		
		WebElement firstSelectedOption = choose.getFirstSelectedOption();
		//System.out.println(firstSelectedOption.getText());
		
		choose.selectByVisibleText("Home & Kitchen");
		Thread.sleep(2000);
		choose.selectByIndex(1);
		Thread.sleep(2000);
		choose.selectByValue("search-alias=stripbooks");
		
		System.out.println(choose.getFirstSelectedOption().getText());
		
		List<WebElement> allOptions = choose.getOptions();
		System.out.println(allOptions.size());
		for (WebElement element : allOptions) {
			System.out.println(element.getText());
		}
	}
	
	public static void nonSelectDropdown() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 4);
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		
		WebElement dropdown = driver.findElement(By.xpath("(//div[@class='ui fluid selection dropdown'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(dropdown));
		dropdown.click();
		
		WebElement mattOption = driver.findElement(By.xpath("//div[@data-value='matt']"));
		wait.until(ExpectedConditions.visibilityOf(mattOption));
		mattOption.click();
	}
	
	public static void alertDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 4);
		
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		driver.findElement(By.id("confirm")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle = driver.switchTo().alert();
		Thread.sleep(2000);
		handle.accept();
		
		driver.findElement(By.id("prompt")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle2 = driver.switchTo().alert();
		System.out.println(handle2.getText());
		handle2.sendKeys("Brandon");
		handle2.dismiss();
	}
}
