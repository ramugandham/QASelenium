package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.CommonUtils;
import base.Base;
import pages.HeaderOptions;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RightColoumOptionsPage;

public class Login extends Base {

	WebDriver driver;

	HeaderOptions headerOptions;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	RightColoumOptionsPage rightColoumOptionsPage;

	@BeforeMethod
	public void setUp() {
		driver = openBrowserAndApplicationURL();
		headerOptions = new HeaderOptions(driver);
		headerOptions.clickOnMyAccountMenu();
		loginPage = headerOptions.selectLoginOption();

	}

	@AfterMethod
	public void tearDown() {
		quiteBrowser(driver);
	}

	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {
		loginPage.enterEmailField(prop.getProperty("ExistingEmail"));
		loginPage.enterpasswordField(prop.getProperty("ValidPassword"));
		myAccountPage = loginPage.clickOnLoginButton();
		rightColoumOptionsPage = myAccountPage.getRightColoumnOption();
		Assert.assertTrue(rightColoumOptionsPage.isUserLoggedIn());
		myAccountPage = rightColoumOptionsPage.getMYAccountPage();
		Assert.assertTrue(myAccountPage.didWeNavigateMyAccountPage());
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidEmailAndPassword() {
		loginPage.enterEmailField(CommonUtils.newEmailGenration());
		loginPage.enterpasswordField(prop.getProperty("InValidPassword"));
		myAccountPage = loginPage.clickOnLoginButton();
		String ExcepectedResults = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.GetWarningMessage(), ExcepectedResults);

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		loginPage.enterEmailField(CommonUtils.newEmailGenration());
		loginPage.enterpasswordField(prop.getProperty("ValidPassword"));
		myAccountPage = loginPage.clickOnLoginButton();
		String ExcepectedResults = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.GetWarningMessage(), ExcepectedResults);
	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndINValidPassword() {
		loginPage.enterEmailField(prop.getProperty("ExistingEmail"));
		loginPage.enterpasswordField(prop.getProperty("InValidPassword"));
		myAccountPage = loginPage.clickOnLoginButton();
		String ExcepectedResults = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.GetWarningMessage(), ExcepectedResults);
	}

	@Test(priority = 5)
	public void verifyLoginWithoutCredentials() {
		myAccountPage = loginPage.clickOnLoginButton();
		String ExcepectedResults = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.GetWarningMessage(), ExcepectedResults);
	}

}
