package day1_seleniumLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1_selenium {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("Automation");
		driver.findElement(By.id("pass")).sendKeys("Automation");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys("Automation");
		driver.findElement(By.name("lastname")).sendKeys("Automation");
		driver.findElement(By.name("reg_email__")).sendKeys("Automation");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Automation");
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(2000);
		driver.close();
		
	}
}
