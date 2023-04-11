package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Driver;

public class FacebookPage {
	public FacebookPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (name = "email")
	public WebElement FBEmailField;
	
	@FindBy (name = "pass")
	public WebElement FBPassField;
	
	@FindBy (name = "login")
	public WebElement FBLoginBtn;
}
