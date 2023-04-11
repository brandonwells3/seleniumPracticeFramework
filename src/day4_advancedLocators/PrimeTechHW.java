package day4_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimeTechHW {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		PrimeTechHW trial = new PrimeTechHW();
		
		trial.testcase1();
	}
	
	public void testcase1() throws InterruptedException {
		
		String firstname = "Brandon";
		String lastname = "Wells";
		String email = "test123@email.com";
		String password = "password321";
		String address = "1600 Pennsylvania Avenue NW, Washington, DC 20500";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://practice.primetech-apps.com/practice/text-box");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-sm btn-enable']")).click();
		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(address);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		
		String returnfirstname = driver.findElement(By.xpath("//div[@class='firstName']")).getText();
		String returnlastname = driver.findElement(By.xpath("//div[@class='lastName']")).getText();
		String returnemail = driver.findElement(By.xpath("//div[@class='email']")).getText();
		String returnpassword = driver.findElement(By.xpath("//div[@class='password']")).getText();
		String returnaddress = driver.findElement(By.xpath("//div[@class='address']")).getText();
		
		if(firstname.equals(returnfirstname)) {
			System.out.println("First Name, MATCHES");
		} else {
			System.out.println("First Name, NOT MATCHING!!!");
		}
		
		if(lastname.equals(returnlastname)) {
			System.out.println("Last Name, MATCHES");
		} else {
			System.out.println("Last Name, NOT MATCHING!!!");
		}
		
		if(email.equals(returnemail)) {
			System.out.println("Email, MATCHES");
		} else {
			System.out.println("Email, NOT MATCHING!!!");
		}
		
		if(password.equals(returnpassword)) {
			System.out.println("Password, MATCHES");
		} else {
			System.out.println("Password, NOT MATCHING!!!");
		}
		
		if(address.equals(returnaddress)) {
			System.out.println("Address, MATCHES");
		} else {
			System.out.println("Address, NOT MATCHING!!!");
		}
		
		Thread.sleep(4000);
		driver.quit();
	}
	
	public void testcase2() throws InterruptedException {
		
		String id = "1";
		String firstname = "Brandon";
		String lastname = "Wells";
		String salary = "$100,000";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://practice.primetech-apps.com/practice/web-tables");
		Thread.sleep(2000);
		driver.findElement(By.id("Id")).sendKeys(id);
		driver.findElement(By.xpath("//input[@id='First Name']")).sendKeys(firstname);
		driver.findElement(By.id("Last Name")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='Salary']")).sendKeys(salary);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		
		
		driver.quit();
	}
	
	
}
