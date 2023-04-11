package day10_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Driver;

public class day10_FrameworkTest {
	public static void main(String[] args) throws InterruptedException {
		testcase1();
	}
		
	public static void testcase1() throws InterruptedException {
		
		String automation = "Automation";
		
		Driver.getDriver().get("http://etsy.com");
		Thread.sleep(2000);
		
		Driver.getDriver().findElement(By.className("select-signin")).click();
		Thread.sleep(2000);
		
		Driver.getDriver().findElement(By.id("join_neu_email_field")).sendKeys(automation);
		Driver.getDriver().findElement(By.id("join_neu_password_field")).sendKeys(automation);
		Driver.getDriver().findElement(By.name("submit_attempt")).click();
		Thread.sleep(2000);
		
		Driver.quitDriver();
	}
}
