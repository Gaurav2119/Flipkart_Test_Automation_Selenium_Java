package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class TestCase1_HomePageVisible extends BaseTest {

	@Test
	public static void verifyHomePageIsVisibleSuccessfully() {

		logger.info("Starting test case: verifyHomePageIsVisibleSuccessfully");
		ExtentReportManager.getTest().info("Stating test case");

		logger.info("Verifying if the home page is visible");
		ExtentReportManager.getTest().info("Verifying home page is visible or not");

		try {
			int countAdShow = new HomePage(driver).homePageIsVisible().size();

			Assert.assertTrue(countAdShow > 0, "Home page not visible");

			logger.info("Test passed: Home page is visible");
			ExtentReportManager.getTest().pass("Test passed: Home page is visible");

		} catch (Exception e) {
			logger.error("Test failed: Home page is not visible", e);
			ExtentReportManager.getTest().fail("Test failed: Home page is not visible");
			throw e;
		}
	}
}
