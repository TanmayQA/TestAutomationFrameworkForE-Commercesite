package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utillity.BrowserUtility;
import com.utillity.ExtentReporterUtility;
import com.utillity.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListner implements ITestListener {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(result.getMethod().getMethodName());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "PASSED");
        ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " " + "FAILED");
        logger.error(result.getThrowable().getMessage());
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

        Object testclass = result.getInstance();
        BrowserUtility browserUtility = ((TestBase) testclass).getInstance();
        logger.info("Capturing Screenshot for the failed tests");

        String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
        logger.info("Attaching the  Screenshot to the HTML File");

        ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
        ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReporterUtility.setUpSparkReporter("report.html");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Comdletes");
        ExtentReporterUtility.flushReport();
    }


}
