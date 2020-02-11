package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentOrderPage  extends BasePage<PaymentOrderPage> {

    @FindBy(css = ".bankwire")
    private WebElement bankWirePayment;

    @FindBy (xpath = "//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrder;

    @FindBy(css = ".navigation_page")
    private WebElement navpag;

    public String confirmOrderWithPayment ()  {
        getActions().click(bankWirePayment);
        getActions().click(confirmOrder);
        return getActions().text(navpag);
    }

}
