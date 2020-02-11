package com.qa.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {

	private final  WebDriver driver;

	public Action(WebDriver driver) {
		this.driver = driver;
	}

	public void click(WebElement element) {
		click(element, FrameworkProperties.EXTENDED_TIMEOUT);
	}

	void click(WebElement element, Integer timeout) {
		isElementDisplayed(element, timeout);
		element.click();
	}

	public boolean isElementDisplayed(WebElement element) {
		return isElementDisplayed(element, FrameworkProperties.DEFAULT_TIMEOUT);
	}

	boolean isElementDisplayed(WebElement element, Integer timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	String text(WebElement element,  Integer timeout) {
		isElementDisplayed(element, timeout);
		return element.getText();
	}
	public String text(WebElement element ) {
		return text(element, FrameworkProperties.DEFAULT_TIMEOUT);
	}

	void type(WebElement element, String text, Integer timeout) {
		isElementDisplayed(element, timeout);
		element.clear();
		element.sendKeys(text);
	}

	public void type(WebElement element, String text) {
		type(element, text, FrameworkProperties.DEFAULT_TIMEOUT);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public org.openqa.selenium.interactions.Actions hover() {
		return new org.openqa.selenium.interactions.Actions(driver);
	}

	public void switchToFrames(WebElement name){
		WebDriverWait wait = new WebDriverWait(driver, FrameworkProperties.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
	}

	public  void selectOptionFromList(WebElement element, String option){
		WebElement select = element;
		new Select(select).selectByVisibleText(option);
	}

	public WebDriver switchToDefaultContent(){
		return driver.switchTo().defaultContent();
	}


	public boolean isPageReady() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, FrameworkProperties.DEFAULT_TIMEOUT);
			wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		} catch (WebDriverException e) {
			return false;
		}
		return true;
	}

}
