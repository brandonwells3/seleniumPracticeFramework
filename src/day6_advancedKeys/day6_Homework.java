package day6_advancedKeys;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day6_Homework {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");

		
	}
	
	public static void testcase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.navigate().to("http://practice.primetech-apps.com/practice/radio-button");
		
		List<WebElement> radioButtons = driver.findElements(By.cssSelector(".form-check-input"));
		
		for (WebElement singleRadio : radioButtons) {
			if (singleRadio.isDisplayed() && singleRadio.isEnabled()) {
				if (singleRadio.isSelected()) {
					System.out.println("Radio Button IS selected");
				} else {
					System.out.println("Radio Button IS NOT selected");
					Thread.sleep(2000);
					singleRadio.click();
				}
			} else {
				System.out.println("Radio Button is either NOT displayed or enabled");
			}
				
		Thread.sleep(2000);
		System.out.println("Is Radio Button selected?" + singleRadio.isSelected());
		}
	}	
	
	public static void testcase3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.navigate().to("http://practice.primetech-apps.com/practice/check-box");
		
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[class=form-check-input]"));
		
		for (WebElement singleCheckbox : checkBoxes) {
			Thread.sleep(2000);
			if (singleCheckbox.isDisplayed()) {
				System.out.println("Checkbox IS displayed");
				if (singleCheckbox.isEnabled()) {
					System.out.println("Checkbox IS enabled");
					if (singleCheckbox.isSelected()) {
						System.out.println("Checkbox IS selected");
					} else {
						System.out.println("Checkbox IS NOT selected, Currently Selecting...");
						singleCheckbox.click();
					}
				} else {
					System.out.println("Checkbox IS NOT enabled");
				}
			} else {
				System.out.println("Checkbox IS NOT displayed");
			}
		System.out.println("Is Checkbox selected now?" + singleCheckbox.isSelected());
		}
	}
	
	public static void amazonTestCase() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
		
		driver.findElement(By.xpath("//span[text()=\"Hello, sign in\"]")).click();
		
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page");
		} else {
			System.out.println("I am NOT on the sign in page");
		}
		
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page for the 2ND TIME");
		} else {
			System.out.println("I am NOT on the sign in page for the 2ND TIME");
		}
		
		driver.findElement(By.id("createAccountSubmit")).click();
		WebElement createAccountText = driver.findElement(By.xpath("//h1[contains(text(), \"Create account\"]"));
		
		if (createAccountText.isDisplayed()) {
			System.out.println("I am on the account creation page");
		} else {
			System.out.println("I am NOT on the account creation page");
		}
		
		driver.navigate().back();
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page for the 3RD TIME");
		} else {
			System.out.println("I am NOT on the sign in page for the 3RD TIME");
		}
		
		driver.navigate().forward();
		if (createAccountText.isDisplayed()) {
			System.out.println("I am on the account creation page for the 2ND TIME");
		} else {
			System.out.println("I am NOT on the account creation page for the 2ND TIME");
		}
		
		driver.findElement(By.id("continue")).click();
		
		WebElement nameErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Enter your name')]"));
		if (nameErrorMessage.isDisplayed()) {
			if (nameErrorMessage.getText().equals("Enter your name")) {
				System.out.println("Name error message displays and it matches");
			} else {
				System.out.println("Name error message DOES NOT display or it DOES NOT match");
			}
		}
		
		WebElement emailErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Enter your email')]"));
		if (emailErrorMessage.isDisplayed()) {
			if (emailErrorMessage.getText().equals("Enter your email")) {
				System.out.println("Email error message displays and it matches");
			} else {
				System.out.println("Email error message DOES NOT display or it DOES NOT match");
			}
		}
		
		WebElement passwordErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Minimum 6 characters required')]"));
		if (passwordErrorMessage.isDisplayed()) {
			if (passwordErrorMessage.getText().equals("Enter your name")) {
				System.out.println("Password error message displays and it matches");
			} else {
				System.out.println("Password error message DOES NOT display or it DOES NOT match");
			}
		}
	}
}
