package com.qa.TestCaseSuite;

import com.qa.Pages.*;
import org.testng.annotations.*;
import com.qa.Base.BaseClass;


public class BaseTest {
	ItemPage item;
	CheckOutPage check;
	SignInPage signIn;
	PaymentOrderPage payment;


	@BeforeSuite
	public void setup()  {

		item = new ItemPage().get();
		check = new CheckOutPage().get();
		signIn = new SignInPage().get();
		payment = new PaymentOrderPage().get();
	}

	@BeforeMethod
	public void setUp() {
		BaseClass.get().getDriver();
	}


	@AfterMethod
	public void tearDown() {
		//BaseClass.get().quitDriver(BaseClass.get().getDriver());
	}

}
