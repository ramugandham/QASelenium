package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;
import root.RootPage;

public class SearchPage extends RootPage {
	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='HP LP3065']")
	private WebElement existingProduct;

	public boolean isProductInDisplayedSearchPage() {
		return elementUtilities.isElementDisplayed(existingProduct);
	}

	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMessage;

	public String getNoProductMessage() {
		return elementUtilities.getTextFromElement(noProductMessage);
	}

}
