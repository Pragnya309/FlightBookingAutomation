package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;



public class BaseTest {
	public static WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.initDriver("chrome");

        driver.get("https://blazedemo.com/");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

}