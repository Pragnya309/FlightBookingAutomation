package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import base.BaseTest;
import pages.HomePage;
import pages.FlightsPage;
import pages.PurchasePage;
import pages.ConfirmationPage;

@Listeners(listeners.TestListener.class)

public class NegativeBookingTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(NegativeBookingTest.class);

    @Test
    public void validateWrongConfirmationMessage() {

        logger.info("Starting Negative Test: Wrong Confirmation Message Validation");

        HomePage home = new HomePage(driver);

        logger.info("Selecting departure city: Boston");
        home.selectDepartureCity("Boston");

        logger.info("Selecting destination city: London");
        home.selectDestinationCity("London");

        logger.info("Clicking Find Flights");
        home.clickFindFlights();

        FlightsPage flights = new FlightsPage(driver);

        logger.info("Choosing first flight");
        flights.chooseFirstFlight();

        PurchasePage purchase = new PurchasePage(driver);

        logger.info("Entering passenger details");
        purchase.enterPassengerDetails(
                "John", "Street 1", "New York", "NY", "10001");

        logger.info("Entering payment details");
        purchase.enterPaymentDetails("12345678");

        logger.info("Clicking Purchase Flight");
        purchase.clickPurchaseFlight();

        ConfirmationPage confirmation = new ConfirmationPage(driver);

        String message = confirmation.getConfirmationMessage();

        logger.info("Actual Confirmation Message: " + message);

        logger.info("Validating incorrect confirmation message intentionally");

        // Intentionally failing assertion
        Assert.assertTrue(message.contains("Payment Failed"),
                "Expected failure message not displayed");
    }
}