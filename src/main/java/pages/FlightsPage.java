package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class FlightsPage {

    WebDriver driver;

    // Constructor
    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        
        WaitUtils.waitForElementVisible(driver, flightsTable);
    }

    // Locators
    By flightsTable = By.xpath("//table");
    By chooseFlightBtn = By.xpath("(//input[@value='Choose This Flight'])[1]");

    // Verify flights list displayed
    public boolean isFlightsTableDisplayed() {
       return WaitUtils.waitForElementVisible(driver, flightsTable).isDisplayed();
     }
    

    // Select first flight
    public void chooseFirstFlight() {
    	 WaitUtils.waitForElementClickable(driver, chooseFlightBtn).click();
    }
}