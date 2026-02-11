package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.LoginPage;
import com.utillity.BrowserUtility;
import com.utillity.LambdaTestUtility;
import com.utillity.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.constants.Browser.CHROME;

public class TestBase {

    protected LoginPage loginPage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLembdaTest;


    @Parameters({"browser", "isLembdaTest", "isHeadless"})
    @BeforeMethod(description = "Load the login page of the website")
    public void setup(
            @Optional("chrome") String browser,
            @Optional("false") boolean isLembdaTest,
            @Optional("true") boolean isHeadless, ITestResult result) {

        this.isLembdaTest = isLembdaTest;

        WebDriver Lambdadriver;
        if (isLembdaTest) {

            Lambdadriver = LambdaTestUtility.intializeLambdaTestSession(browser, result.getMethod().getMethodName());
            loginPage = new LoginPage(CHROME, isHeadless);
        } else {
            // running the test on local machine!!!
            logger.info("Load the homepage of the website");
            loginPage = new LoginPage(Browser.valueOf(browser.toUpperCase()), isHeadless);
        }
    }

    public BrowserUtility getInstance() {
        return loginPage;
    }

    @AfterMethod(description = "Tear Down the browser")
    public void tearDown() {
        if (isLembdaTest) {
            LambdaTestUtility.quitSession(); // close or browsersession on LT
        }
    }
}
