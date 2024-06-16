package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SellerPage;
import utils.BaseTest;
import utils.ExtentReportManager;
import utils.PropertiesLoader;

public class TestCase9_VerifySellerPageIsVisibleAndTitleIsAsExpected extends BaseTest {

	@Test
	public void verifyThatSellerPageIsVisible() throws IOException {
		logger.info("Starting test: VerifySellerPageIsVisibleAndTitleIsAsExpected");
		
		TestCase1_HomePageVisible.verifyHomePageIsVisibleSuccessfully();

		sellerPageIsVisible();
		sellerPageTitle();
		
		logger.info("Completed test: VerifySellerPageIsVisibleAndTitleIsAsExpected");
	}

	private void sellerPageTitle() throws IOException {

		ExtentReportManager.getTest().info("Matching seller page title");
		logger.info("Matching seller page title");

		try {
			String actualTitle = new SellerPage(driver).sellerPageTitle().getTitle();

			String expectedTitle = PropertiesLoader.loadProperty("sellerPage.title");

			Assert.assertEquals(actualTitle, expectedTitle, "Title not matched correctly");

			ExtentReportManager.getTest().pass("Seller page title matched");
			logger.info("Seller page title matched");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Seller page title not matched");
			logger.info("Seller page title not matched", e);
			throw e;
		}
	}

	public static void sellerPageIsVisible() {

		ExtentReportManager.getTest().info("Verifying seller page is visible or not");
		logger.info("Verifying seller page is visible or not");

		try {
			new HomePage(driver).becomeSellerButton().click();

			ExtentReportManager.getTest().pass("Become a seller button clicked");
			logger.info("Become a seller button clicked");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Not able to click Become a seller button");
			logger.info("Not able to click Become a seller button");
			throw e;
		}

		try {
			boolean logoDisplayed = new SellerPage(driver).sellerLogo().isDisplayed();
			boolean sellingButtonDisplayed = new SellerPage(driver).startSellingButton().isDisplayed();

			Assert.assertTrue(logoDisplayed);
			Assert.assertTrue(sellingButtonDisplayed);
			
			ExtentReportManager.getTest().pass("Seller page is visible");
			logger.info("Seller page is visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Seller page not visible");
			logger.info("Seller page not visible");
			throw e;
		}
	}

}
