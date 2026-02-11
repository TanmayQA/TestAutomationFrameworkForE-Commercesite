package com.ui.pages;

import com.constants.Browser;

import static com.constants.Env.*;

import com.utillity.BrowserUtility;

import static com.utillity.PropertiesUtill.*;

import static com.utillity.JsonUtillity.*;

import com.utillity.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public final class LoginPage extends BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final By Email_Textbox_Locator = By.xpath("//input[@data-qa='login-email']");
    private static final By Password_Textbox_Locator = By.xpath("//input[@data-qa='login-password']");
    private static final By login_btn_locator = By.xpath("//button[@data-qa='login-button']");


    public LoginPage(Browser driver, boolean isHeadless) {
        super(driver, isHeadless);
        // goToWebsite(readProperty(QA, "URL"));
        goToWebsite(readJSON(QA).getUrl());
        maximizeWindow();
    }

    public HomePage doLoginWith(String emailAddress, String password) {
        entertext(Email_Textbox_Locator, emailAddress);
        entertext(Password_Textbox_Locator, password);
        logger.info("Trying to performing click to go to login home page");
        clickOn(login_btn_locator);
        return new HomePage(getDriver());

    }
}
