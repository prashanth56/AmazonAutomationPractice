package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage<CheckOutPage> {

    @FindBy(css = ".button.btn.btn-default.standard-checkout.button-medium")
    private WebElement proceedToCheckout;

    @FindBy(css = ".navigation_page")
    private WebElement navBar;


    public CheckOutPage() { super (); }

    public  String selectProceedToCheckout () {
        getActions().click(proceedToCheckout);
        return getActions().text(navBar);
    }
}
