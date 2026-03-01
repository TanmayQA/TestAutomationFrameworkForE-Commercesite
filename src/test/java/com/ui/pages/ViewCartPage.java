package com.ui.pages;

import com.utillity.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCartPage extends BrowserUtility {

    private static final By checkout_btn_locator = By.xpath("//a[contains(text(),'Proceed To Checkout')]");


    public ViewCartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage checkout() {
        killAds();
        clickOn(checkout_btn_locator);
        killAds();
        return new CheckoutPage(getDriver());
    }

}
