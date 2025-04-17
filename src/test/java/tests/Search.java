package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HeaderOptions;
import pages.SearchPage;

public class Search extends Base {

	WebDriver driver;
	HeaderOptions headerOptions;
	SearchPage searchPage;

	@BeforeMethod
	public void setUp() {

		driver = openBrowserAndApplicationURL();
		headerOptions = new HeaderOptions(driver);
	}

	@AfterMethod
	public void tearDown() {
		quiteBrowser(driver);
	}

	@Test(priority = 1)
	public void verifySearchWithExistingProductName() {
		headerOptions.enterSearchProduct(prop.getProperty("ExistingProductName"));
		searchPage = headerOptions.clickOnSearchbutton();
		Assert.assertTrue(searchPage.isProductInDisplayedSearchPage());

	}

	@Test(priority = 2)
	public void verifySearchWithNonExistingProductName() {
		headerOptions.enterSearchProduct(prop.getProperty("NonExistingProductName"));
		searchPage = headerOptions.clickOnSearchbutton();
		String ExcepectedResults = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchPage.getNoProductMessage(), ExcepectedResults);

	}

	@Test(priority = 3)
	public void verifySearchWithoutProductName() {

		searchPage = headerOptions.clickOnSearchbutton();
		String ExcepectedResults = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchPage.getNoProductMessage(), ExcepectedResults);

	}

}
