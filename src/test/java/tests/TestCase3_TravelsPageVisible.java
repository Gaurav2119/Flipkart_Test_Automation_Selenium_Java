package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class TestCase3_TravelsPageVisible extends BaseTest {

	@Test
	public void verifyTravelsPageIsVisibleSuccessfully() {
		logger.info("Starting test: TravelsPageVisible");

		TestCase1_HomePageVisible.verifyHomePageIsVisibleSuccessfully();
		travelsPageIsVisible();

		logger.info("Completed test: TravelsPageVisible");
	}

	public static void travelsPageIsVisible() {

		ExtentReportManager.getTest().info("Verifying travels page is visible or not");
		logger.info("Verifying travels page is visible or not");

		try {
			String pageHeading = new HomePage(driver).navigateToTravelPage().travelPageHeading().getText();

			Assert.assertEquals(pageHeading, "Travel", "Travels page not visibile");

			ExtentReportManager.getTest().pass("Test passed: Travels page is visible");
			logger.info("Test passed: Travels page is visible");

		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Travels page is not visible");
			logger.info("Test failed: Travels page is not visible", e);
			throw e;
		}
	}
}
