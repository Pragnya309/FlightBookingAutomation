package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import data.FlightDataProvider;
import pages.ConfirmationPage;
import pages.FlightsPage;
import pages.HomePage;
import pages.PurchasePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Listeners(listeners.TestListener.class)

public class FlightBookingTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(FlightBookingTest.class);

	@Test(
		 dataProvider = "flightData", 
		 dataProviderClass = FlightDataProvider.class
		 )
	public void completeFlightBooking(String fromCity, String toCity, String name, String address, String city, String state, String zip,
	                                  String cardNumber) 
	{
		logger.info("Starting Flight Booking Test");
		
	    HomePage home = new HomePage(driver);

	    logger.info("Selecting departure city: " + fromCity);
	    home.selectDepartureCity(fromCity);
	    
	    logger.info("Selecting destination city: " + toCity);
	    home.selectDestinationCity(toCity);
	    
	    logger.info("Clicking Find Flights");
	    home.clickFindFlights();

	    FlightsPage flights = new FlightsPage(driver);
	    flights.chooseFirstFlight();

	    PurchasePage purchase = new PurchasePage(driver);

	    logger.info("Entering passenger details");
	    purchase.enterPassengerDetails(
	            name, address, city, state, zip);
	    
	    logger.info("Entering payment details");
	    purchase.enterPaymentDetails(cardNumber);
	    
	    logger.info("Clicking Purchase Flight");
	    purchase.clickPurchaseFlight();

	    ConfirmationPage confirmation = new ConfirmationPage(driver);

	    String message = confirmation.getConfirmationMessage();

	    logger.info("Confirmation Message: " + message);
	    
	    Assert.assertTrue(message.contains("Thank you for your purchase"),
	            "Booking confirmation message not displayed");
	
    }
}