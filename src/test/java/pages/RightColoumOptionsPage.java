package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;
import root.RootPage;

public class RightColoumOptionsPage extends RootPage {
	public RightColoumOptionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	private WebElement logoutOptions;

	public boolean isUserLoggedIn() {
		return elementUtilities.isElementDisplayed(logoutOptions);

	}

	public AccountSuccessPage getAccountSuccessPage() {
		return new AccountSuccessPage(driver);
	}

	public MyAccountPage getMYAccountPage() {
		return new MyAccountPage(driver);
	}
}
