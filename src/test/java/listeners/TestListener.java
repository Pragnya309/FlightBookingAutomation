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


public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        WebDriver driver = BaseTest.getDriver();

        String base64Screenshot =
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

        test.fail("Screenshot",
                com.aventstack.extentreports.MediaEntityBuilder
                .createScreenCaptureFromBase64String(base64Screenshot)
                .build());
    }
    public void onFinish(org.testng.ITestContext context) {

        extent.flush();
    }
}