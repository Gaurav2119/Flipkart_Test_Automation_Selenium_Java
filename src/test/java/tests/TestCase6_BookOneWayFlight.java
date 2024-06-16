package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FlightPage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class TestCase6_BookOneWayFlight extends BaseTest {

	@Test
	public void verifyThatBookFlightRequiresLogin() throws InterruptedException, IOException {
		logger.info("Starting test: BookOneWayFlight");
		
		TestCase4_SearchOneWayFlight.verifySearchFlightIsVisible();

		bookFlight();
		otpButtonIsVisible();
		
		logger.info("Completed test: BookOneWayFlight");
	}

	private void bookFlight() {
		try {
			new FlightPage(driver).clickBookButtonOneWay().get(2).click();
			ExtentReportManager.getTest().pass("Book button clicked");
			logger.info("Book button clicked");

		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Book button not clicked");
			logger.info("Book button not clicked");
			throw e;
		}
	}

	private void otpButtonIsVisible() {
		ExtentReportManager.getTest().info("Verifying login tab is visible");
		logger.info("Verifying login tab is visible");
		try {
		String buttonText = new FlightPage(driver).requestOTP().getText();

		Assert.assertEquals(buttonText, "Request OTP", "Button not visible");
		
		ExtentReportManager.getTest().pass("Test passed: Login tab is visible");
		logger.info("Test passed: Login tab is visible");

		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Login tab is not visible");
			logger.info("Test failed: Login tab is not visible", e);
			throw e;
		}
	}
}
