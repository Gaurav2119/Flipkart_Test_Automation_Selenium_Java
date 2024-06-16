package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FlightPage;
import pages.TravelsPage;
import utils.BaseTest;
import utils.ExtentReportManager;
import utils.PropertiesLoader;

public class TestCase5_SearchRoundTripFlight extends BaseTest {

	@Test
	public static void verifySearchFlightIsVisible() throws IOException {
		logger.info("Starting test: SearchRoundTripFlight");
		
		TestCase1_HomePageVisible.verifyHomePageIsVisibleSuccessfully();
		TestCase3_TravelsPageVisible.travelsPageIsVisible();

		roundTripButtonSelected();
		searchFlight();
		
		logger.info("Completed test: SearchRoundTripFlight");
	}

	private static void roundTripButtonSelected() {

		ExtentReportManager.getTest().info("Verifying round trip button clicked or not");
		logger.info("Verifying round trip button clicked or not");

		try {
			boolean buttonClicked = new TravelsPage(driver).selectRoundTrip().isSelected();

			Assert.assertTrue(buttonClicked, "Round trip button not clicked");

			ExtentReportManager.getTest().pass("Test passed: Round trip button clicked");
			logger.info("Test passed: Round trip button clicked");

		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Round trip button not clicked");
			logger.info("Test failed: Round trip button not clicked", e);
			throw e;
		}
	}

	private static void searchFlight() throws IOException {
		ExtentReportManager.getTest().info("Verifying flight searched for " + PropertiesLoader.loadProperty("depart.city") + " to " + PropertiesLoader.loadProperty("arrival.city"));
		logger.info("Verifying flight searched for " + PropertiesLoader.loadProperty("depart.city") + " to " + PropertiesLoader.loadProperty("arrival.city"));
		
		try {
			new TravelsPage(driver).selectDepartCity(PropertiesLoader.loadProperty("depart.city"));
			new TravelsPage(driver).selectArrivalCity(PropertiesLoader.loadProperty("arrival.city"));

			new TravelsPage(driver).defaultDepartDate().click();
			new TravelsPage(driver).defaultArrivalDate().click();

			new TravelsPage(driver).searchButton().click();

			String departureCity1 = new FlightPage(driver).flightLocation().get(0).getText();
			String arrivalCity1 = new FlightPage(driver).flightLocation().get(1).getText();

			String departureCity2 = new FlightPage(driver).flightLocation().get(2).getText();
			String arrivalCity2 = new FlightPage(driver).flightLocation().get(3).getText();

			Assert.assertEquals(departureCity1.toLowerCase(), PropertiesLoader.loadProperty("depart.city").toLowerCase(), "Departure city not matched");
			Assert.assertEquals(arrivalCity1.toLowerCase(), PropertiesLoader.loadProperty("arrival.city").toLowerCase(), "Arrival city not matched");

			Assert.assertEquals(departureCity2.toLowerCase(), PropertiesLoader.loadProperty("arrival.city").toLowerCase(), "Departure city not matched");
			Assert.assertEquals(arrivalCity2.toLowerCase(), PropertiesLoader.loadProperty("depart.city").toLowerCase(), "Arrival city not matched");
			ExtentReportManager.getTest().pass("Test passed: Desired result is visible");
			logger.info("Test passed: Desired result is visible");

		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Desired result not visible");
			logger.info("Test failed: Desired result not visible", e);
			throw e;
		}
	}
}
