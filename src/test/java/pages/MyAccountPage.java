package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;
import root.RootPage;

public class MyAccountPage extends RootPage {
	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Subscribe / unsubscribe to newsletter']")
	private WebElement subscribeUnsubscribeToNewsLetteroption;

	public NewsLettersubscriptionPage clickOnSubscribeUnsubscribeToNewsLetteroption() {
		elementUtilities.clickOnElement(subscribeUnsubscribeToNewsLetteroption);
		return new NewsLettersubscriptionPage(driver);
	}

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	private WebElement editYourAccountInformationOption;

	public boolean didWeNavigateMyAccountPage() {
		return elementUtilities.isElementDisplayed(editYourAccountInformationOption);

	}

	public RightColoumOptionsPage getRightColoumnOption() {

		return new RightColoumOptionsPage(driver);
	}

}
