package com.qa.Pages;

import com.qa.Base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import com.qa.Base.Action;

import static com.qa.Base.FrameworkProperties.BASE_URL;


public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
	private String pageUrl;
	private WebDriver driver;
	private Action action;

	BasePage() {
		this.pageUrl = BASE_URL;
		this.driver = BaseClass.get().getDriver();
		this.action = new Action(driver);
		PageFactory.initElements(driver, this);
	}

	BasePage(String pageUrl) {
		this.pageUrl = pageUrl;
		this.driver = BaseClass.get().getDriver();
		this.action = new Action(driver);
		PageFactory.initElements(driver, this);
	}

	Action getActions() {
		return action;
	}

	@Override
	public void load() {
		if (pageUrl.contains("http")) {
			driver.get(pageUrl);
		} else {
			driver.get(BASE_URL + pageUrl);
		}
	}

	@Override
	protected void isLoaded() throws Error {
		if (!this.driver.getCurrentUrl().contains(pageUrl) && getActions().isPageReady()) {
			throw new Error(action.getCurrentUrl() + " is not loaded");
		}
	}



}
