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

public class day7_HW {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		testcase6();
	}
	
	public static void testcase1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
		
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select dropdownOption = new Select(dropdown);
		
		List<WebElement> allOptions = dropdownOption.getOptions();
		for (WebElement element : allOptions) {
			System.out.println(element.getText());
		}
		
		int size = allOptions.size();
		if(size == 58) {
			System.out.println("Size EQUALS 58");
		} else {
			System.out.println("Size DOESN'T EQUAL 58");
		}
		
		driver.quit();
	}
	
	public static void testcase2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
		
		String expecAmazonTitle = "Amazon.com. Spend less. Smile more.";
		String amazonTitle = driver.getTitle();
		if(expecAmazonTitle.equals(amazonTitle)) {
			System.out.println("You are on Amazon.com");
		} else {
			System.out.println("You AREN'T on Amazon.com OR the title is incorrect");
		}
		
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select dropdownOption = new Select(dropdown);
		String expecFirstOption = "All Departments";
		String firstOption = dropdownOption.getFirstSelectedOption().getText();
		if(firstOption.equals(expecFirstOption)) {
			System.out.println("First option is All Departments");
		} else {
			System.out.println("First option IS NOT All Departments");
		}
		
		dropdownOption.selectByVisibleText("Home & Kitchen");
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.sendKeys("Coffee Mug");
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		
		String expecCoffeeMugTitle = "Amazon.com : Coffee Mug";
		String coffeeMugTitle = driver.getTitle();
		if(expecCoffeeMugTitle.equals(coffeeMugTitle)) {
			System.out.println("You are on Coffee Mug search");
		} else {
			System.out.println("You AREN'T on Coffee Mug search OR the title is incorrect");
		}
		
		String expecDepartment = "Home & Kitchen";
		WebElement dropdown2 = driver.findElement(By.id("searchDropdownBox"));
		Select dropdownOption2 = new Select(dropdown2);
		String department = dropdownOption2.getFirstSelectedOption().getText();
		if(department.equals(expecDepartment)) {
			System.out.println("You're in the Home & Kitchen department");
		} else {
			System.out.println("You ARE NOT in the Home & Kitchen department");
		}
		
		driver.quit();
	}
	
	public static void testcase3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		WebElement alertButton = driver.findElement(By.id("alert"));
		alertButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		
		driver.quit();
	}
	
	public static void testcase4() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		WebElement confirmAlert = driver.findElement(By.id("confirm"));
		confirmAlert.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		
		String alertText = alert.getText();
		String expecAlertText = "Do you wish to continue or cancel?";
		if(alertText.equals(expecAlertText)) {
			System.out.println("Alert text matches");
		} else {
			System.out.println("Alert text DOES NOT match");
		}
		
		alert.accept();
		Thread.sleep(2000);
		
		driver.quit();
	}
	
	public static void testcase5() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		WebElement promptAlert = driver.findElement(By.id("prompt"));
		promptAlert.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("PrimeTech");
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		
		String message = driver.findElement(By.id("demo")).getText();
		String expecMessage = "Hello PrimeTech! How are you today?";
		if(message.equals(expecMessage)) {
			System.out.println("Demo message matches");
		} else {
			System.out.println("Demo message DOES NOT match");
		}
		
		driver.quit();
	}
	
	public static void testcase6() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		WebElement promptAlert = driver.findElement(By.id("prompt"));
		promptAlert.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("PrimeTech");
		Thread.sleep(2000);
		alert.dismiss();
		Thread.sleep(2000);
		
		String message = driver.findElement(By.id("demo")).getText();
		String expecMessage = "User cancelled the prompt.";
		if(message.equals(expecMessage)) {
			System.out.println("Demo message matches");
		} else {
			System.out.println("Demo message DOES NOT match");
		}
		
		driver.quit();
	}
}
