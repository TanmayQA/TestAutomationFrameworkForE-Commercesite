package com.ui.tests;

import com.ui.listeners.TestListner;
import com.ui.pojo.user;
import com.utillity.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(TestListner.class)
public class InvalidCredLoginTest extends TestBase {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private static final String Invalid_Email_Address = "TEst@gmail.com";
    private static final String Invalid_Password = "Test";

    @Test(description = "Verify if the proper error message is shown for the user when they enter invalid credentials", groups = {"E2E", "Sanity"})
    public void logintest() {
        assertEquals(loginPage.doLoginWithInvalidCredentials(Invalid_Email_Address, Invalid_Password).getErrorMessage(), "Your email or password is incorrect!");

    }

}
