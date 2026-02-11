package com.ui.pages;

import com.utillity.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtility {

    private static final By User_Name_Locator =By.xpath("//a[.//i[contains(@class,'fa-user')]]//b");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return getVisibleText(User_Name_Locator);

    }

    public void quit() {
        getDriver().quit();
    }
}
