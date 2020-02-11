package com.qa.TestCaseSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

@Listeners(com.qa.testng.TestListener.class)
public class ChallengeWorkFlow  extends BaseTest{

    @Test (  priority = 1, description = "Navigate to Amazon and sign In" )
    public void singInTest() throws InterruptedException {
        assertEquals(signIn.SignInAmazon(),"ecompliancetest");

    }
      @Test (dependsOnMethods = {"singInTest"},  description = "Notice safety hard hat")
       public void testSafetyHardHat() throws InterruptedException {
            //signIn.SignInAmazon();
            assertTrue(item.searchAndNoticeSafetyHardHat());
    }
//
//    @Test(dependsOnMethods={"singInTest"},  description = "Select Ratchet Hard Hat")
//    public void selectCheckOutTest() throws InterruptedException{
//        assertEquals(item.selectCheckOut(), "Your shopping cart");
//    }
//
   @Test(dependsOnMethods = {"singInTest"},  description = "Select proceed to check out in Authentication page")
    public void safetyGoggleCheckoutTest() throws InterruptedException{
      assertEquals(check.selectProceedToCheckout(), "Authentication");
   }
//    @Test(dependsOnMethods = {"selectProceedToCheckoutTest"},  description = "Create Account")
//    public void selectCreateAccountTest() throws InterruptedException{
//        assertEquals(signIn.createAccountDetails(), "Addresses");
//    }
//
//    @Test(dependsOnMethods = "selectCreateAccountTest",  description = "Shipping and Final proceed to checkout")
//    public void selectProceedCheckOutAfterSignUpTest() throws InterruptedException{
//        assertEquals(signIn.selectProceedCheckOutAfterSignUp(),"Your payment method");
//    }
//
//    @Test(dependsOnMethods = {"selectProceedCheckOutAfterSignUpTest"},  description = "payment confirmation and accept order")
//    public void confirmOrderWithPaymentTest() throws InterruptedException{
//        assertEquals(payment.confirmOrderWithPayment(),"Order confirmation");
//    }


}
