package com.ui.listeners;

import com.constants.Env;
import com.utillity.JsonUtillity;
import com.utillity.PropertiesUtill;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    // private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtill.readProperty(Env.DEV, "MAX_NUMBER_OF_ATTEMPTS"));
    private static final int MAX_NUMBER_OF_ATTEMPTS = JsonUtillity.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
    private static int currentAttempt = 1;


    @Override
    public boolean retry(ITestResult iTestResult) {

        if (currentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {
            currentAttempt++;
            return true;
        }
        return false;
    }
}
