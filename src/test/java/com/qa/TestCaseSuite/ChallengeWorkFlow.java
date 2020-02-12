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
      @Test ( priority = 2,  description = "Notice safety hard hat")
       public void testSafetyHardHat() throws InterruptedException {
            singInTest();
            assertTrue(item.searchAndNoticeSafetyHardHat());
    }
//
    @Test(priority = 3,  description = "Select Ratchet Hard Hat")
    public void selectRatchetHardHatERBTest() throws InterruptedException{
        singInTest();
        assertTrue(item.selectRatchetHardHatERB());
   }

   @Test(priority = 4,  description = "Add safety goggles to Cart")
    public void safetyGoggleCheckoutTest() throws InterruptedException{
       singInTest();
      assertEquals(item.safetyGoggleAddToCart(), "1");
   }

    @Test(priority = 5, description = "Add Fire extinguisher to cart and Remove")
    public void fireExtinguisherAddRemoveCartTest() throws InterruptedException{
        singInTest();
        assertEquals(item.fireExtinguisherAddRemoveCart(), "0");
    }


}
