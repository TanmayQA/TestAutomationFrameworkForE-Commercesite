package com.ui.pages;

import com.utillity.BrowserUtility;
import com.utillity.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    private static final By search_text_field_locator = By.xpath("//input[contains(@id,'search_product')]");
    private static final By search_btn_locator = By.xpath("//button[@id='submit_search']");
    private SearchResultPage search;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchProduct(String searchinputtext) {
        killAds();
        entertext(search_text_field_locator, searchinputtext);
        clickOn(search_btn_locator);
        search = new SearchResultPage(getDriver());
        return search;
    }


}
