package com.ui.tests;

import com.ui.listeners.TestListner;

import static org.testng.Assert.*;

import com.ui.pojo.user;
import com.utillity.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListner.class)
public class LoginTest extends TestBase {
    Logger logger = LoggerUtility.getLogger(this.getClass());

//    @Test(description = "Verify the valid user is able to login into the application", groups = {"E2E", "Sanity"},
//            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
//            dataProvider = "LoginTestDataProvider")
//    public void logintest(user user) {
//        assertEquals(loginPage.doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Tanmay QA");
//
//    }
//
//    @Test(description = "Verify the valid user is able to login into the application", groups = {"E2E", "Sanity"},
//            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
//            dataProvider = "LoginTestCSVDataProvider")
//    public void loginCSVtest(user user) {
//        assertEquals(loginPage.doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Tanmay QA");
//    }
//
    @Test(description = "Verify the valid user is able to login into the application", groups = {"E2E", "Sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginExceltest(user user) {
        assertEquals(loginPage.doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Tanmay QA");

    }

}
