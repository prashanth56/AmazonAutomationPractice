package com.qa.Pages;

import com.qa.TestData.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends BasePage<ItemPage> {

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBar;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitSearchBar;

	@FindBy(xpath = "//a[contains(@href,'Safety-Helmet')]")
	private WebElement safetyHelmet;

	@FindBy(xpath = "//a[contains(@href,'ERB') and contains(@href,'Americana-Style-Ratchet') and contains(@href,'customerReviews')]")
	private WebElement ERBHardHatCustRev;

	@FindBy(xpath = "//input[contains(@class,'askBtfSearchTextInput')]")
	private WebElement custReviewSearch;

	@FindBy(xpath = "//span[@class='askBtfSearchResultsHeader'][contains(text(),'Customer Reviews')]")
	private WebElement customerReviewsTab;

	@FindBy(xpath = "//a[@class='a-link-emphasis']")
	private WebElement resultDisplay;

	@FindBy(xpath = "//div[@data-cel-widget='search_result_0']")
	private WebElement selectFirstResult;

	@FindBy(id = "add-to-cart-button")
	private WebElement addToCartButton;

	@FindBy(id = "nav-cart-count")
	private WebElement CartButton;

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteItemFromCart;




	public boolean searchAndNoticeSafetyHardHat()  {
		getActions().type(searchBar, "hard hat");
		getActions().click(submitSearchBar);
		getActions().hover().moveToElement(safetyHelmet).build().perform();
		return (safetyHelmet.isDisplayed());
	}

	public boolean selectRatchetHardHatERB(){
		getActions().type(searchBar, "Ratchet Hard Hat");
		getActions().click(submitSearchBar);
		getActions().click(ERBHardHatCustRev);
		getActions().type(custReviewSearch, "quality");
		getActions().click(customerReviewsTab);
		return getActions().isElementDisplayed(resultDisplay);
	}

	public String safetyGoggleAddToCart()  {
		getActions().type(searchBar, "safety goggles");
		getActions().click(submitSearchBar);
		getActions().click(selectFirstResult);
		getActions().click(addToCartButton);
		return getActions().text(CartButton);
	}

	public String fireExtinguisherAddRemoveCart()  {
		getActions().type(searchBar, "fire extinguisher");
		getActions().click(submitSearchBar);
		getActions().click(selectFirstResult);
		getActions().click(addToCartButton);
		getActions().click(CartButton);
		getActions().click(deleteItemFromCart);
		return getActions().text(CartButton);
	}



}
