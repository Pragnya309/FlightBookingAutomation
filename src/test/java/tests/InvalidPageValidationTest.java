package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;


@Listeners(listeners.TestListener.class)
public class InvalidPageValidationTest extends BaseTest { 
	
	private static final Logger logger =
	        LogManager.getLogger(InvalidPageValidationTest.class);

	@Test
	public void validateWrongPageTitle() {

	    logger.info("Starting Negative Test: Page Title Validation");

	    String title = driver.getTitle();

	    logger.info("Actual Page Title: " + title);

	    logger.info("Validating incorrect title intentionally");

	    Assert.assertEquals(title, "Invalid Title",
	            "Page title validation failed");
	}
}
