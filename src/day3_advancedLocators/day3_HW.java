package day3_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day3_HW {
	
	public void testcase1() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Automation");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.quit();
	}
	
	public void testcase2() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Automation");
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		Thread.sleep(5000);
		driver.quit();
	}
	
	public void testcase3() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		String sdet = "SDET";
		
		driver.get("https://indeed.com/");
		Thread.sleep(2000);
		
		String homeURL = driver.getCurrentUrl();
		String homeTitle = driver.getTitle();
		
		driver.findElement(By.xpath("//input[@id='text-input-what']")).sendKeys("SDET");
		
		WebElement whereField = driver.findElement(By.xpath("//input[@id='text-input-where']"));
		whereField.sendKeys(Keys.COMMAND + "a");
		whereField.sendKeys(Keys.DELETE);
		whereField.sendKeys("washington DC");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		String searchURL = driver.getCurrentUrl();
		String searchTitle = driver.getTitle();
		
		if(!searchURL.equals(homeURL)) {
			System.out.println("Different URL's");
		} else {
			System.out.println("Same URL's");
		}
		if(!searchTitle.equals(homeTitle)) {
			System.out.println("Different Title's");
		} else {
			System.out.println("Same Title's");
		}
		
		String jobsInLocation = driver.findElement(By.xpath("//h1[@ class]")).getText();
		
		if(sdet.equals(jobsInLocation.substring(0,(sdet.length())))) {
			System.out.println("Equals Search Criteria - INDEED");
		} else {
			System.out.println("Doesn't Equal Search Criteria - INDEED");
		}
		
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		day3_HW trial = new day3_HW();
		
		trial.testcase1();
		trial.testcase2();
		trial.testcase3();
	}
}
