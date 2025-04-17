package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;
import root.RootPage;

public class NewsLettersubscriptionPage extends RootPage {
	public NewsLettersubscriptionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='1']")
	private WebElement yesNewsletterOption;

	public boolean isyesNewsletterOptionSelect() {
		return elementUtilities.isElementSelected(yesNewsletterOption);

	}

	@FindBy(xpath = "//input[@value='0']")
	private WebElement NoNewsletterOption;

	public boolean isNoNewsletterOptionSelect() {
		return elementUtilities.isElementSelected(NoNewsletterOption);

	}

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement NewsletterOptionContinuebutton;

	public MyAccountPage clickOnNewsletterOptionContinueButton() {
		elementUtilities.clickOnElement(NewsletterOptionContinuebutton);
		return new MyAccountPage(driver);
	}

}
