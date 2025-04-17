package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;
import root.RootPage;

public class AccountSuccessPage extends RootPage {
	
	public AccountSuccessPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[normalize-space()='Success']")
	private WebElement accountSuccessPageBreadCrumb;
	public boolean navigateAccountSuccessPage() {
		return elementUtilities.isElementDisplayed(accountSuccessPageBreadCrumb);
		
	}
	@FindBy(xpath="//a[normalize-space()='Continue']")
	private WebElement Continuebutton;
	public MyAccountPage clickOnContinuebutton() {
		elementUtilities.clickOnElement(Continuebutton);
		return new MyAccountPage(driver);
	}
	
	public  RightColoumOptionsPage getRightcoloumnOptions() {
		return new RightColoumOptionsPage(driver);
	}
}
