package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;


@Listeners(listeners.TestListener.class)
public class InvalidPageValidationTest extends BaseTest { 
	
	@Test(groups = "negative")

    public void validateWrongPageTitle() {

        String title = driver.getTitle();

        Assert.assertEquals(title, "Invalid Title",
                "Page title validation failed");
    }

}
