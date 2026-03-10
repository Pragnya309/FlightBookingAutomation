package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class PurchasePage {

    WebDriver driver;

    // Constructor
    public PurchasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zipCode = By.id("zipCode");
    By cardNumber = By.id("creditCardNumber");
    By purchaseBtn = By.xpath("//input[@value='Purchase Flight']");

    // Actions

    public void enterPassengerDetails(String pname, String addr,
            String cityName, String stateName, String zip) {

        driver.findElement(name).sendKeys(pname);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(cityName);
        driver.findElement(state).sendKeys(stateName);
        driver.findElement(zipCode).sendKeys(zip);
    }

    public void enterPaymentDetails(String cardNum) {

        driver.findElement(cardNumber).sendKeys(cardNum);
    }

    public void clickPurchaseFlight() {

    		WaitUtils.waitForElementClickable(driver, purchaseBtn).click();
    }
}