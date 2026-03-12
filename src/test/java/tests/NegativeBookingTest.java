package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.FlightsPage;
import pages.PurchasePage;
import pages.ConfirmationPage;

@Listeners(listeners.TestListener.class)

public class NegativeBookingTest extends BaseTest {

    @Test
    public void validateWrongConfirmationMessage() {

        HomePage home = new HomePage(driver);

        home.selectDepartureCity("Boston");
        home.selectDestinationCity("London");
        home.clickFindFlights();

        FlightsPage flights = new FlightsPage(driver);
        flights.chooseFirstFlight();

        PurchasePage purchase = new PurchasePage(driver);

        purchase.enterPassengerDetails(
                "John", "Street 1", "New York", "NY", "10001");

        purchase.enterPaymentDetails("12345678");

        purchase.clickPurchaseFlight();

        ConfirmationPage confirmation = new ConfirmationPage(driver);

        String message = confirmation.getConfirmationMessage();

        // Intentionally validating wrong text
        Assert.assertTrue(message.contains("Payment Failed"),
                "Expected failure message not displayed");
    }
}