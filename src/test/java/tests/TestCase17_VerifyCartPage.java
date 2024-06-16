package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class TestCase17_VerifyCartPage extends BaseTest {

	@Test(priority = 1)
	private void verifyHomePageIsVisibleSuccessfully() {
		logger.info("Stating test case: VerifyCartPage");

		ExtentReportManager.getTest().info("Stating test case");

		ExtentReportManager.getTest().info("Verifying home page is visible or not");
		logger.info("Verifying home page is visible or not");

		try {
			int countAdShow = new HomePage(driver).homePageIsVisible().size();

			Assert.assertTrue(countAdShow > 0, "Home page not visible");

			ExtentReportManager.getTest().pass("Test passed: Home page is visible");
			logger.info("Test passed: Home page is visible");

		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Home page is not visible");
			logger.info("Test failed: Home page is not visible", e);
			throw e;
		}
	}

	@Test(priority = 2)
	private void verifyCartPageIsVisible() {
		logger.info("Verifying cart page is visible or not");
		ExtentReportManager.getTest().info("Verifying cart page is visible or not");
		try {
			new HomePage(driver).clickCartButton().click();
			
			boolean displayedLoginButton = new CartPage(driver)
					.loginButton()
					.isDisplayed();
			
			Assert.assertTrue(displayedLoginButton, "Login Button not displayed");
			ExtentReportManager.getTest().pass("Test passed: Cart page is visible");
			logger.info("Test passed: Cart page is visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Cart page is not visible");
			logger.info("Test failed: Cart page is not visible", e);
			throw e;
		}
	}
}
