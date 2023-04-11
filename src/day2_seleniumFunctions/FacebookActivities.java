package day2_seleniumFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookActivities {
	public static void main(String[] args) {
		
		public void getTextPractice() {
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			String loginText = driver.findElement(By.name("login")).getText();
			System.out.println("Login button text is: "+loginText);
			}
	}
}
