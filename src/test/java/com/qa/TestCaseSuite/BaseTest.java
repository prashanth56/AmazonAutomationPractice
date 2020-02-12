package com.qa.TestCaseSuite;

import com.qa.Pages.*;
import org.testng.annotations.*;
import com.qa.Base.BaseClass;


public class BaseTest {
	ItemPage item;
	SignInPage signIn;


	@BeforeMethod
	public void setUp() {
		BaseClass.get().getDriver();
		item = new ItemPage().get();
		signIn = new SignInPage().get();
	}


	@AfterMethod
	public void tearDown() {
		BaseClass.get().quitDriver(BaseClass.get().getDriver());
	}

}
