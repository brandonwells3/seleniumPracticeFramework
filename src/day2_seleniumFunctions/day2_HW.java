package day2_seleniumFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day2_HW {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		day2_HW trial = new day2_HW();

		
		//trial.testcase1();	
		trial.testcase2();
	}
		
		public void testcase1() throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			String automation = "Automation";
			
			driver.get("http://etsy.com");
			Thread.sleep(2000);
			driver.findElement(By.className("select-signin")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("join_neu_email_field")).sendKeys(automation);
			driver.findElement(By.id("join_neu_password_field")).sendKeys(automation);
			driver.findElement(By.name("submit_attempt")).click();
			Thread.sleep(2000);
			driver.quit();
		}
		
		public void testcase2() throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			String sdet = "SDET";

			
			driver.get("https://indeed.com/");
			Thread.sleep(2000);
			
			String homeURL = driver.getCurrentUrl();
			String homeTitle = driver.getTitle();
			
			driver.findElement(By.id("text-input-what")).sendKeys("SDET");
			driver.findElement(By.className("yosegi-InlineWhatWhere-primaryButton")).click();
			Thread.sleep(2000);
			
			String searchURL = driver.getCurrentUrl();
			String searchTitle = driver.getTitle();
			
			if(!searchURL.equals(homeURL)) {
				System.out.println("Different URL's - ETSY");
			} else {
				System.out.println("Same URL's - ETSY");
			}
			if(!searchTitle.equals(homeTitle)) {
				System.out.println("Different Title's - ETSY");
			} else {
				System.out.println("Same Title's - ETSY");
			}
			
			String jobsInLocation = driver.findElement(By.xpath("//h1[@ class]")).getText();
			
			if(sdet.equals(jobsInLocation.substring(0,(sdet.length())))) {
				System.out.println("Equals Search Criteria - INDEED");
			} else {
				System.out.println("Doesn't Equal Search Criteria - INDEED");
			}
			
			driver.quit();
		}
	}

