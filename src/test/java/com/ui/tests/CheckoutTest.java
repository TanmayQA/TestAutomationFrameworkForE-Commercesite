package com.ui.tests;

import com.ui.listeners.TestListner;
import com.ui.pages.*;
import com.ui.pojo.CardDetails;
import com.utillity.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.flows.*;

@Listeners(TestListner.class)
public class CheckoutTest extends TestBase {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private HomePage homePage;
    private ProductPage productPage;
    private SearchResultPage searchResultPage;
    private CardDetails cardDetails;
    private PaymentPage paymentPage;
    private Checkoutflow checkoutflow;

    @BeforeMethod(description = "Valid user logs into the application")
    public void setup() {
        String searchKey = "Sleeveless";
        homePage = loginPage.doLoginWith("xowam96002@icubik.com", "password1");
        productPage = homePage.clickonProductlink();
        searchResultPage = productPage.searchProduct(searchKey);
        cardDetails = new CardDetails("tanmay", "1234432112344321", "123", "02", "2028");
        checkoutflow = new Checkoutflow();
    }

    @Test(description = "Verify if the logged in user is able to add the product and places it", groups = {"E2E", "Sanity"})
    public void checkoutProducttest() {

         paymentPage =
                checkoutflow.completeCheckout(searchResultPage, cardDetails);

        String message = paymentPage.getConfirmationMessage();

        Assert.assertEquals(message,
                "Congratulations! Your order has been confirmed!");
    }

   @Test(description = "Verify if user can download the invoice and navigate to homepage after clicking on continue button")
   public void downloadinvoicetest() {

        paymentPage =
               checkoutflow.completeCheckout(searchResultPage, cardDetails);

        homePage =
               paymentPage.downloadorderivoiceandContinue();

       Assert.assertTrue(homePage.isHomePageLoaded(),
               "Home page not loaded after clicking on continue button");
   }

}
