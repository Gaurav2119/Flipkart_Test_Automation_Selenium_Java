package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.TermsAndConditionPage;
import utils.BaseTest;
import utils.ExtentReportManager;
import utils.PropertiesLoader;

public class TestCase12_VerifyTermsAndConditionPageTitle extends BaseTest {

	@Test
	public void verifyTermsAndConditionPageTitle() throws Exception {
		logger.info("Starting test: verifyTermsAndConditionPageTitle");
		TestCase1_HomePageVisible.verifyHomePageIsVisibleSuccessfully();

		new HomePage(driver).clickTermsAndConditionsLink();

		termsAndConditionPageIsVisible();

		pageTitleIsAsExcepted();

		logger.info("Completed test: verifyTermsAndConditionPageTitle");
	}

	private void termsAndConditionPageIsVisible() {
		logger.info("Verifying page is displayed or not");
		ExtentReportManager.getTest().info("Verifying page is displayed or not");
		try {
			new TermsAndConditionPage(driver).pageHeadingVisible().isDisplayed();
			ExtentReportManager.getTest().pass("Test case passed: Page is visible");
			logger.info("Test case passed: Page is visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test case failed: Page not displayed");
			logger.error("Test case failed: Page not displayed", e);
			throw e;
		}
	}

	private void pageTitleIsAsExcepted() throws Exception {
		logger.info("Matching page title is as expected");
		ExtentReportManager.getTest().info("Matching page title is as expected");
		try {

			String expectedTitle = PropertiesLoader.loadProperty("termsAndConditionPage.title");

			String actualTitle = new TermsAndConditionPage(driver).termsAndConditionPageTitle().getTitle();

			Assert.assertEquals(actualTitle, expectedTitle, "Title not matched");
			ExtentReportManager.getTest().pass("Test case passed: Page title is as expected");
			logger.info("Test case passed: Page title is as expected");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test case failed: Page title not matched correctly");
			logger.error("Test case failed: Page title not matched correctly", e);
			throw e;
		}
	}

}
