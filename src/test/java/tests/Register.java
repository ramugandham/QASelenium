package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.CommonUtils;
import base.Base;
import pages.AccountSuccessPage;
import pages.HeaderOptions;
import pages.MyAccountPage;
import pages.NewsLettersubscriptionPage;
import pages.RegisterAccountPage;
import pages.RightColoumOptionsPage;

public class Register extends Base {
	WebDriver driver;
	HeaderOptions headerOptions;
	RegisterAccountPage registerAccountPage;
	AccountSuccessPage accountSuccessPage;
	RightColoumOptionsPage rightColoumOptionsPage;
	MyAccountPage myAccountPage;
	NewsLettersubscriptionPage newsLettersubscriptionPage;

	@BeforeMethod
	public void setUp() {
		driver = openBrowserAndApplicationURL();
		headerOptions = new HeaderOptions(driver);
		headerOptions.clickOnMyAccountMenu();
		registerAccountPage = headerOptions.selectRegisterOption();

	}

	@AfterMethod
	public void tearDown() {
		quiteBrowser(driver);
	}

	@Test(priority = 1, enabled = true)
	public void verifyRegisteringUsingMandatoryfields() {
		registerAccountPage.enterFirstName(prop.getProperty("FirstName"));
		registerAccountPage.enterLastName(prop.getProperty("LastName"));
		registerAccountPage.enterEmailName(CommonUtils.newEmailGenration());
		registerAccountPage.enterTelephoneNumber(prop.getProperty("Telephone"));
		registerAccountPage.enterPassword(prop.getProperty("Password"));
		registerAccountPage.enterconfirmPassword(prop.getProperty("Password"));
		registerAccountPage.clickOnPrivacyPolicybox();
		accountSuccessPage = registerAccountPage.clickOnContinueButton();

		rightColoumOptionsPage = accountSuccessPage.getRightcoloumnOptions();
		Assert.assertTrue(rightColoumOptionsPage.isUserLoggedIn());
		Assert.assertTrue(accountSuccessPage.navigateAccountSuccessPage());
		myAccountPage = accountSuccessPage.clickOnContinuebutton();
		Assert.assertTrue(myAccountPage.didWeNavigateMyAccountPage());

	}

	@Test(priority = 2, enabled = true)
	public void verifyRegisteringUsingAllfields() {

		registerAccountPage.enterFirstName(prop.getProperty("FirstName"));
		registerAccountPage.enterLastName(prop.getProperty("LastName"));
		registerAccountPage.enterEmailName(CommonUtils.newEmailGenration());
		registerAccountPage.enterTelephoneNumber(prop.getProperty("Telephone"));
		registerAccountPage.enterPassword(prop.getProperty("Password"));
		registerAccountPage.enterconfirmPassword(prop.getProperty("Password"));
		registerAccountPage.selectYesNewsLetterOption();
		registerAccountPage.clickOnPrivacyPolicybox();
		accountSuccessPage = registerAccountPage.clickOnContinueButton();
		rightColoumOptionsPage = accountSuccessPage.getRightcoloumnOptions();
		Assert.assertTrue(rightColoumOptionsPage.isUserLoggedIn());
		Assert.assertTrue(accountSuccessPage.navigateAccountSuccessPage());
		myAccountPage = accountSuccessPage.clickOnContinuebutton();
		Assert.assertTrue(myAccountPage.didWeNavigateMyAccountPage());

	}

	@Test(priority = 3, enabled = true)
	public void verifyRegisteringAccountSelectingByYesNewsLettersOptions() {

		registerAccountPage.enterFirstName(prop.getProperty("FirstName"));
		registerAccountPage.enterLastName(prop.getProperty("LastName"));
		registerAccountPage.enterEmailName(CommonUtils.newEmailGenration());
		registerAccountPage.enterTelephoneNumber(prop.getProperty("Telephone"));
		registerAccountPage.enterPassword(prop.getProperty("Password"));
		registerAccountPage.enterconfirmPassword(prop.getProperty("Password"));
		registerAccountPage.selectYesNewsLetterOption();
		registerAccountPage.clickOnPrivacyPolicybox();
		accountSuccessPage = registerAccountPage.clickOnContinueButton();
		myAccountPage = accountSuccessPage.clickOnContinuebutton();
		newsLettersubscriptionPage = myAccountPage.clickOnSubscribeUnsubscribeToNewsLetteroption();
		Assert.assertTrue(newsLettersubscriptionPage.isyesNewsletterOptionSelect());
		newsLettersubscriptionPage.clickOnNewsletterOptionContinueButton();

	}

	@Test(priority = 4, enabled = true)
	public void verifyRegisteringAccountSelectingByNoNewsLettersOptions() {

		registerAccountPage.enterFirstName(prop.getProperty("FirstName"));
		registerAccountPage.enterLastName(prop.getProperty("LastName"));
		registerAccountPage.enterEmailName(CommonUtils.newEmailGenration());
		registerAccountPage.enterTelephoneNumber(prop.getProperty("Telephone"));
		registerAccountPage.enterPassword(prop.getProperty("Password"));
		registerAccountPage.enterconfirmPassword(prop.getProperty("Password"));
		registerAccountPage.selectNoNewsLetterOption();
		registerAccountPage.clickOnPrivacyPolicybox();
		accountSuccessPage = registerAccountPage.clickOnContinueButton();
		myAccountPage = accountSuccessPage.clickOnContinuebutton();
		newsLettersubscriptionPage = myAccountPage.clickOnSubscribeUnsubscribeToNewsLetteroption();
		Assert.assertTrue(newsLettersubscriptionPage.isNoNewsletterOptionSelect());
		newsLettersubscriptionPage.clickOnNewsletterOptionContinueButton();

	}

}
