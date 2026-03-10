package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import utils.ConfigReader;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // initialize driver
        DriverFactory.initDriver(ConfigReader.getProperty("browser"));

        // get driver instance
        driver = DriverFactory.getDriver();

        // open application
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}