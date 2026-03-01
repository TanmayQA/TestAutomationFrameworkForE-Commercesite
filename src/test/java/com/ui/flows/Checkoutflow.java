package com.ui.flows;

import com.ui.pages.CheckoutPage;
import com.ui.pages.PaymentPage;
import com.ui.pages.SearchResultPage;
import com.ui.pages.ViewCartPage;
import com.ui.pojo.CardDetails;

public class Checkoutflow  {

    ViewCartPage viewCartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    public PaymentPage completeCheckout(SearchResultPage searchResultPage, CardDetails cardDetails) {
         viewCartPage = searchResultPage.viewaddedproduct();
         checkoutPage = viewCartPage.checkout();
         paymentPage = checkoutPage.placeorder();
         paymentPage.enterpayementdetails(cardDetails);
         return paymentPage;
    }


}


