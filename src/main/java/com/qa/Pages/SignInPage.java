package com.qa.Pages;

import com.qa.Base.FrameworkProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class SignInPage extends BasePage<SignInPage>  {

    @FindBy(id = "nav-link-accountList")
    private WebElement hoverSignIn;

    @FindBy(css = ".nav-action-button")
    private WebElement signIn;

    @FindBy(id = "ap_email")
    private WebElement emailID;

    @FindBy(id = "continue")
    private WebElement cntnue;

    @FindBy(id = "ap_password")
    private WebElement password;

    @FindBy(css = ".a-label.a-checkbox-label")
    private WebElement checkbox;

    @FindBy(id = "signInSubmit")
    private WebElement login;

    @FindBy(css = "#nav-link-accountList .nav-line-1")
    private WebElement userName;

    public SignInPage() { super (); }

    public String SignInAmazon() {
        System.out.println("val : "+ getActions().text(userName));
        if (getActions().text(userName).contains("Hello, Sign in")) {
            //getActions().hover().moveToElement(hoverSignIn).build().perform();
            getActions().click(hoverSignIn);
            getActions().type(emailID, FrameworkProperties.UNAME);
            getActions().click(cntnue);
            getActions().type(password, FrameworkProperties.PWD);
            getActions().click(checkbox);
            getActions().click(login);
            return getActions().text(userName);
        }
        else {
            return "sign in failure.";
        }

    }
}
