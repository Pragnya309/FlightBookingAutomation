package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtils;

public class HomePage {

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By departureCity = By.name("fromPort");
    By destinationCity = By.name("toPort");
    By findFlightsBtn = By.xpath("//input[@value='Find Flights']");

    // Actions

    public void selectDepartureCity(String city) {
        Select select = new Select(driver.findElement(departureCity));
        select.selectByVisibleText(city);
    }

    public void selectDestinationCity(String city) {
        Select select = new Select(driver.findElement(destinationCity));
        select.selectByVisibleText(city);
    }

    public void clickFindFlights() {
    		WaitUtils.waitForElementClickable(driver, findFlightsBtn).click();
    }
}