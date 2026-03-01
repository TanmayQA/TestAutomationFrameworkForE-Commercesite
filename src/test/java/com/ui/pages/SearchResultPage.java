package com.ui.pages;

import com.utillity.BrowserUtility;
import com.utillity.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    private static final By searched_result_locator = By.xpath("//div[contains(@class,'productinfo')]//p");
    private static final By add_to_cart_locator = By.xpath("//div[contains(@class,'productinfo')] [.//p[text()='Sleeveless Dress']] /a[contains(@class,'add-to-cart')]");
    private static final By view_cart_locator = By.xpath("//u[contains(text(),'View Cart')]");


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getSearchResultNames() {
        killAds();
        return getElements(searched_result_locator)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public ViewCartPage viewaddedproduct() {
        killAds();
        jsClick(add_to_cart_locator);
        killAds();
        jsClick(view_cart_locator);
        killAds();
        return new ViewCartPage(getDriver());
    }


}
