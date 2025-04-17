package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;
import root.RootPage;

public class LoginPage extends RootPage{
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	public void enterEmailField(String emailText) {
		elementUtilities.enterTextIntoElement(emailField, emailText);
	}
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	public void enterpasswordField(String passwordText) {
		elementUtilities.enterTextIntoElement(passwordField, passwordText);
	}
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginbutton;
	
	public MyAccountPage clickOnLoginButton() {
		elementUtilities.clickOnElement(loginbutton);
		return new MyAccountPage(driver);
	}
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	
	public String GetWarningMessage() {
		return elementUtilities.getTextFromElement(warningMessage);
	
	}
	
	
	

}
