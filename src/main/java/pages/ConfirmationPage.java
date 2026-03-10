package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class ConfirmationPage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By confirmationMessage = By.tagName("h1");

    public String getConfirmationMessage() {

    	return WaitUtils
                .waitForElementVisible(driver, confirmationMessage)
                .getText();
    }
}