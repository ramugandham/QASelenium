package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;
import root.RootPage;

public class RegisterAccountPage extends RootPage {
	public RegisterAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	public void enterFirstName(String firstNameText) {
		elementUtilities.enterTextIntoElement(firstNameField, firstNameText);

	}

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	public void enterLastName(String lastNameText) {
		elementUtilities.enterTextIntoElement(lastNameField, lastNameText);

	}

	@FindBy(id = "input-email")
	private WebElement emailField;

	public void enterEmailName(String emailNameText) {
		elementUtilities.enterTextIntoElement(emailField, emailNameText);

	}

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	public void enterTelephoneNumber(String telephoneNum) {
		elementUtilities.enterTextIntoElement(telephoneField, telephoneNum);

	}

	@FindBy(id = "input-password")
	private WebElement passwordField;

	public void enterPassword(String password) {
		elementUtilities.enterTextIntoElement(passwordField, password);

	}

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	public void enterconfirmPassword(String confirmpassword) {
		elementUtilities.enterTextIntoElement(confirmPasswordField, confirmpassword);

	}

	@FindBy(xpath = "//label[normalize-space()='Yes']")
	private WebElement newsLetterOption;

	public void selectYesNewsLetterOption() {
		elementUtilities.clickOnElement(newsLetterOption);

	}

	@FindBy(xpath = "//label[normalize-space()='No']")
	private WebElement newsLetterOptionNO;

	public void selectNoNewsLetterOption() {
		elementUtilities.clickOnElement(newsLetterOptionNO);
	}

	@FindBy(name = "agree")
	private WebElement PrivacyPolicy;

	public void clickOnPrivacyPolicybox() {
		elementUtilities.clickOnElement(PrivacyPolicy);

	}

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;

	public AccountSuccessPage clickOnContinueButton() {
		elementUtilities.clickOnElement(continueBtn);
		return new AccountSuccessPage(driver);
	}

}
