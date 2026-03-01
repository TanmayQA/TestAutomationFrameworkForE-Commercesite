package com.ui.pages;

import com.constants.Browser;

import static com.constants.Env.*;

import com.utillity.BrowserUtility;

import static com.utillity.PropertiesUtill.*;

import static com.utillity.JsonUtillity.*;

import com.utillity.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final By Email_Textbox_Locator = By.xpath("//input[@data-qa='login-email']");
    private static final By Password_Textbox_Locator = By.xpath("//input[@data-qa='login-password']");
    private static final By login_btn_locator = By.xpath("//button[@data-qa='login-button']");
    private static final By Invalid_login_error_msg_locator = By.xpath("//form[@action='/login']/p[contains(text(),'Your email or password is incorrect!')]");

    public LoginPage(Browser driver, boolean isHeadless) {
        super(driver, isHeadless);
        goToWebsite(readJSON(QA).getUrl());
        maximizeWindow();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage doLoginWith(String emailAddress, String password) {
        entertext(Email_Textbox_Locator, emailAddress);
        entertext(Password_Textbox_Locator, password);
        logger.info("Trying to performing click to go to login home page");
        clickOn(login_btn_locator);
        return new HomePage(getDriver());
    }

    public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {
        entertext(Email_Textbox_Locator, emailAddress);
        entertext(Password_Textbox_Locator, password);
        logger.info("Trying to performing click to go to login home page");
        clickOn(login_btn_locator);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

    public String getErrorMessage() {
        return getVisibleText(Invalid_login_error_msg_locator);
    }


}
