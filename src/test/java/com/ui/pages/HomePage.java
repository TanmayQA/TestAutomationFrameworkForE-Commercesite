package com.ui.pages;

import com.utillity.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtility {

    private static final By User_Name_Locator = By.xpath("//a[.//i[contains(@class,'fa-user')]]//b");
    private static final By product_link_locator = By.xpath("//a[@href='/products']");
    private static final By homepage_logo_locator = By.xpath("//img[@alt='Website for automation practice']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        waitForVisible(User_Name_Locator);
        return getVisibleText(User_Name_Locator);
    }


    public ProductPage clickonProductlink() {
        ProductPage product = new ProductPage(getDriver());
        killAds();
        waitForElementToBeClickable(product_link_locator);
        clickOn(product_link_locator);
        return product;
    }

    public boolean isHomePageLoaded() {
        return isElementDisplayed(homepage_logo_locator);
    }




}
