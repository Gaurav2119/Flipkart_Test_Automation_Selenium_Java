package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MobilePhonesPage;
import pages.ProductDetailPage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class TestCase13_VerifyMobilePhonePageProductDetails extends BaseTest {

	@Test(priority = 1)
	private void verifyHomePageIsVisibleSuccessfully() {
		logger.info("Starting test case: verifyMobilePhonePageProductDetails");

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
			logger.error("Test failed: Home page is not visible", e);
			throw e;
		}
	}

	@Test(priority = 2)
	private void verifyMobilePhonePageIsVisibleSuccessfully() {
		ExtentReportManager.getTest().info("Verifying Mobile Phone page is visible or not");
		logger.info("Verifying Mobile Phone page is visible or not");

		try {
			boolean mobilepage = new HomePage(driver).navigateToMobilesPage().mobilePageHeading().isDisplayed();

			Assert.assertTrue(mobilepage, "Mobile page is not displayed");

			ExtentReportManager.getTest().pass("Test passed: Mobile Phone page is visible");
			logger.info("Test passed: Mobile Phone page is visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Mobile Phone page is not visible");
			logger.error("Test failed: Mobile Phone page is not visible", e);
			throw e;
		}
	}

	@Test(priority = 3)
	private void verifyProductDetailsIsDisplayed() {
		logger.info("Verifying Mobile Phone page products are active");
		ExtentReportManager.getTest().info("Verifying Mobile Phone page products are active");
		try {

			boolean clickedProductDisplayed = false;

			String clickedProduct = new MobilePhonesPage(driver).clickFirstMobilePhone().getText();

			new MobilePhonesPage(driver).clickFirstMobilePhone().click();

			ExtentReportManager.getTest().info(clickedProduct + " is clicked");
			logger.info(clickedProduct + " is clicked");

			String productTitle = new ProductDetailPage(driver).getProductTitle().getText();

			if (productTitle.contains(clickedProduct)) {
				clickedProductDisplayed = true;
			}

			boolean productPriceDisplayed = new ProductDetailPage(driver).getProductPrice().isDisplayed();

			Assert.assertTrue(clickedProductDisplayed, "Product title not matched");
			ExtentReportManager.getTest().pass("Test case passed: Product title displayed");
			logger.info("Test case passed: Product title displayed");

			Assert.assertTrue(productPriceDisplayed, "Product price not displayed");
			ExtentReportManager.getTest().pass("Test case passed: Product price displayed");
			logger.info("Test case passed: Product price displayed");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test case passed: Product title or price not displayed");
			logger.error("Test case failed: Product title or price not displayed", e);
			throw e;
		}
	}

}
