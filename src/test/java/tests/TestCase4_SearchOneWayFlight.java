package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FlightPage;
import pages.TravelsPage;
import utils.BaseTest;
import utils.ExtentReportManager;
import utils.PropertiesLoader;

public class TestCase4_SearchOneWayFlight extends BaseTest {

	@Test
	public static void verifySearchFlightIsVisible() throws IOException {
		logger.info("Starting test: SearchOneWayFlight");

		TestCase1_HomePageVisible.verifyHomePageIsVisibleSuccessfully();
		TestCase3_TravelsPageVisible.travelsPageIsVisible();

		oneWayButtonSelected();
		searchFlight();

		logger.info("Completed test: SearchOneWayFlight");
	}

	private static void oneWayButtonSelected() {

		ExtentReportManager.getTest().info("Verifying one way button clicked or not");
		logger.info("Verifying one way button clicked or not");

		try {
			boolean buttonClicked = new TravelsPage(driver).selectOneWay().isSelected();

			Assert.assertTrue(buttonClicked, "One way button not clicked");

			ExtentReportManager.getTest().pass("Test passed: One way button clicked");
			logger.info("Test passed: One way button clicked");

		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: One way button not clicked");
			logger.info("Test failed: One way button not clicked", e);
			throw e;
		}
	}

	private static void searchFlight() throws IOException {

		ExtentReportManager.getTest()
				.info("Verifying flight searched for " + PropertiesLoader.loadProperty("depart.city") + " to "
						+ PropertiesLoader.loadProperty("arrival.city"));
		logger.info("Verifying flight searched for " + PropertiesLoader.loadProperty("depart.city") + " to "
				+ PropertiesLoader.loadProperty("arrival.city"));
		try {
			new TravelsPage(driver).selectDepartCity(PropertiesLoader.loadProperty("depart.city"));
			new TravelsPage(driver).selectArrivalCity(PropertiesLoader.loadProperty("arrival.city"));

			new TravelsPage(driver).defaultDepartDate().click();

			new TravelsPage(driver).searchButton().click();

			String departureCity = new FlightPage(driver).flightLocation().get(0).getText();
			String arrivalCity = new FlightPage(driver).flightLocation().get(1).getText();

			Assert.assertEquals(departureCity.toLowerCase(), PropertiesLoader.loadProperty("depart.city").toLowerCase(),
					"Departure city not matched");
			Assert.assertEquals(arrivalCity.toLowerCase(), PropertiesLoader.loadProperty("arrival.city").toLowerCase(),
					"Arrival city not matched");

			ExtentReportManager.getTest().pass("Test passed: Desired result is visible");
			logger.info("Test passed: Desired result is visible");

		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Desired result not visible");
			logger.info("Test failed: Desired result not visible", e);
			throw e;
		}
	}
}
