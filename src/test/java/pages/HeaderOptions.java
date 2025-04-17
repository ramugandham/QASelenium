package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;
import root.RootPage;

public class HeaderOptions  extends RootPage{
	public HeaderOptions(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;

	public void clickOnMyAccountMenu() {
		elementUtilities.clickOnElement(myAccountDropMenu);

	}

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement clickOnRegisterOption;

	public RegisterAccountPage selectRegisterOption() {
		elementUtilities.clickOnElement(clickOnRegisterOption);

		return new RegisterAccountPage(driver);
	}

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement clickOnLoginOption;

	public LoginPage selectLoginOption() {
		elementUtilities.clickOnElement(clickOnLoginOption);
		return new LoginPage(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchBoxField;

	public void enterSearchProduct(String searchText) {
		elementUtilities.enterTextIntoElement(searchBoxField, searchText);
	}

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchbutton;

	public SearchPage clickOnSearchbutton() {
		elementUtilities.clickOnElement(searchbutton);
		return new SearchPage(driver);
	}
}
