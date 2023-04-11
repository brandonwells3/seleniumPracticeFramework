package day3_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	
	public void amazonSearch() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://amazon.com");
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon']")).sendKeys("Coffee Mug");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
	}
	
	public void etsyActivity() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		String verify = "Sorry, the email you have entered is already in use.";
		
		driver.get("http://etsy.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[1]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"join_neu_first_name_field\"]")).sendKeys("Automation");
		driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]")).sendKeys("Automation");
		driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button")).click();
		Thread.sleep(2000);
		
		String error = driver.findElement(By.xpath("//*[@id=\"aria-join_neu_email_field-error\"]")).getText();
		Thread.sleep(2000);
		
		if(verify.equals(error.substring(0,(verify.length())))) {
			System.out.println("Error Message Verified");
		} else {
			System.out.println("Error Message NOT VERIFIED");
		}
		
		driver.findElement(By.xpath("//*[@id=\"join-neu-overlay\"]/div/button/span/svg")).click();
		Thread.sleep(2000);
		
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		XpathDemo demo = new XpathDemo();
		
		demo.etsyActivity();
	}
}
