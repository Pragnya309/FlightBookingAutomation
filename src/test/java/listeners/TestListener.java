package listeners;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utils.ExtentManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        WebDriver driver = BaseTest.getDriver();

        try {

            // 1️ Save screenshot to folder
            String screenshotPath =
                    ScreenshotUtils.captureScreenshot(driver, result.getName());

            // 2️ Attach screenshot file to Extent Report
            test.addScreenCaptureFromPath(screenshotPath);

            // 3️ Embed screenshot inside report (Base64)
            String base64Screenshot =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

            test.fail("Screenshot",
                    com.aventstack.extentreports.MediaEntityBuilder
                    .createScreenCaptureFromBase64String(base64Screenshot)
                    .build()); 

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        extent.flush();
    }
}