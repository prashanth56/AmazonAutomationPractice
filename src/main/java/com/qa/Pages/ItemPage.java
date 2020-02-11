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


	public boolean searchAndNoticeSafetyHardHat()  {
		getActions().type(searchBar, "hard hat");
		getActions().click(submitSearchBar);
		getActions().hover().moveToElement(safetyHelmet).build().perform();
		return (safetyHelmet.isDisplayed());
	}

	public boolean safetyGoggleaddToCheckout()  {
		getActions().type(searchBar, "safety goggles");

		getActions().click(submitSearchBar);
		getActions().hover().moveToElement(safetyHelmet).build().perform();
		return (safetyHelmet.isDisplayed());
	}



}
