package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class TestCase14_VerifyAppliancePageIsVisible extends BaseTest {

	@Test
	public void verifyAppliancesPageIsVisible() {
		logger.info("Starting test case: VerifyAppliancePageIsVisible");
		TestCase1_HomePageVisible.verifyHomePageIsVisibleSuccessfully();
		appliancesPageIsVisible();
		
		logger.info("Completed test: VerifyAppliancePageIsVisible");
	}

	private void appliancesPageIsVisible() {
		logger.info("Verifying Appliances page is visible or not");
		ExtentReportManager.getTest().info("Verifying Appliances page is visible or not");

		try {
			boolean appliancespage = new HomePage(driver)
					.navigateToAppliancesPage()
					.appliancesPageHeading()
					.isDisplayed();

			Assert.assertTrue(appliancespage, "Appliances page is not visible");
			ExtentReportManager.getTest().pass("Test passed: Appliances page is visible");
			logger.info("Test passed: Appliances page is visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Appliances page is not visible");
			logger.info("Test failed: Appliances page is not visible", e);
			throw e;
		}
	}
}
