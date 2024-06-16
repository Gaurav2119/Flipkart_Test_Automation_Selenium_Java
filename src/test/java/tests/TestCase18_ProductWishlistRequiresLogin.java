package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class TestCase18_ProductWishlistRequiresLogin extends BaseTest {

	@Test(priority = 1)
	private void verifyHomePageIsVisible() {
		logger.info("Stating test case : ProductWishlistRequiresLogin");

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

	@Test(priority = 2, dataProvider = "testdata", dataProviderClass = BaseTest.class)
	private void searchForProduct(String productToSearch) {
		ExtentReportManager.getTest().info("Verifying search products are visible or not");
		logger.info("Verifying search products are visible or not");

		new HomePage(driver).productSearch(productToSearch);

		ExtentReportManager.getTest().info("Searching for product: " + productToSearch);
		logger.info("Searching for product: " + productToSearch);

		searchedProductIsVisible(productToSearch);

		new ProductPage(driver).clickWishlistButton().click();

		verifyWishlistRequireLogin();
	}

	private void searchedProductIsVisible(String searchedFor) {
		try {
			String searchResult = new ProductPage(driver).showingResult().getText();

			Assert.assertEquals(searchResult, searchedFor, "Searched Result not visible");
			ExtentReportManager.getTest().pass("Test case passed: Searched product " + searchedFor + " is visible");
			logger.info("Test case passed: Searched product " + searchedFor + " is visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test case failed: Searched product not visible");
			logger.info("Test case failed: Searched product not visible", e);
			throw e;
		}
	}

	private void verifyWishlistRequireLogin() {
		try {
			boolean buttonDisplayed = new ProductPage(driver).OTPButton().isDisplayed();

			Assert.assertTrue(buttonDisplayed, "Request OTP Button not displayed");

			new ProductPage(driver).clickCrossButton().click();
			ExtentReportManager.getTest().pass("Test case passed: Wishlist requires Login");
			logger.info("Test case passed: Wishlist requires Login");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test case failed: Without login wishlist added");
			logger.info("Test case failed: Without login wishlist added", e);
			throw e;
		}
	}
}
