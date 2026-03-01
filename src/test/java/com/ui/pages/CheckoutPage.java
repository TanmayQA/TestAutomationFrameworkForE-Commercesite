package com.ui.pages;

import com.ui.pojo.CardDetails;
import com.utillity.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BrowserUtility {

    private static final By place_order_locator = By.xpath("//a[contains(text(),'Place Order')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage placeorder() {
        killAds();
        clickOn(place_order_locator);
        killAds();
        return new PaymentPage(getDriver());
    }


}
