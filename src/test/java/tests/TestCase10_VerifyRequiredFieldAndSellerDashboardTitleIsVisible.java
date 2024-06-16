package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SellerDashboard;
import pages.SellerPage;
import utils.BaseTest;
import utils.ExtentReportManager;
import utils.PropertiesLoader;

public class TestCase10_VerifyRequiredFieldAndSellerDashboardTitleIsVisible extends BaseTest {

	@Test
	public void verifyTitleAndFieldsAreVisible() throws Exception {
		logger.info("Starting test: verifyTitleAndFieldsAreVisible");

		TestCase1_HomePageVisible.verifyHomePageIsVisibleSuccessfully();
		TestCase9_VerifySellerPageIsVisibleAndTitleIsAsExpected.sellerPageIsVisible();

		new SellerPage(driver).goToSellerDashboard();
		sellerDashboardTitleIsVisible();

		inputFieldsAreVisible();

		logger.info("Completed test: verifyTitleAndFieldsAreVisible");

	}

	private void sellerDashboardTitleIsVisible() throws Exception {

		logger.info("Verifying title is as expected");
		ExtentReportManager.getTest().info("Verifying title is as expected");

		try {
			String actualTitle = new SellerDashboard(driver).sellerDashboardTitle().getTitle();
			String expectedTitle = PropertiesLoader.loadProperty("sellerDashboard.title");

			Assert.assertEquals(actualTitle, expectedTitle, "Title not matched");
			ExtentReportManager.getTest().pass("Test case passed: Title is as expected");
			logger.info("Title is as expected: {}", actualTitle);
		} catch (Exception e) {
			logger.error("Title not matched. Expected: {}, Actual: {}",
					PropertiesLoader.loadProperty("sellerDashboard.title"), e.getMessage());
			ExtentReportManager.getTest().fail("Test case failed: Title not matched");
			throw e;
		}
	}

	private void inputFieldsAreVisible() {
		logger.info("Verifying required fields are displayed");
		ExtentReportManager.getTest().info("Verifying required fields are displayed");

		try {
			boolean emailFieldIsVisible = new SellerDashboard(driver).emailField().isDisplayed();

			boolean mobileNumberFieldIsVisible = new SellerDashboard(driver).mobileNumberField().isDisplayed();

			boolean registerButtonIsVisible = new SellerDashboard(driver).continueButton().isDisplayed();

			Assert.assertTrue(emailFieldIsVisible, "Email field not displayed");
			Assert.assertTrue(mobileNumberFieldIsVisible, "Mobile number field not displayed");
			Assert.assertTrue(registerButtonIsVisible, "Register button not displayed");

			logger.info("Required fields are visible");
			ExtentReportManager.getTest().pass("Test case passed: Required field are visible");
		} catch (Exception e) {
			logger.error("Required fields are not visible", e);
			ExtentReportManager.getTest().fail("Test case failed: Required field are not visible");
			throw e;
		}
	}
}
