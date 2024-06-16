package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class TestCase11_SearchProduct extends BaseTest {

	@Test(dataProvider = "testdata", dataProviderClass = BaseTest.class)
	public void SearchProductAndVerifyProductIsSorted(String product) throws Exception {
		logger.info("Starting test: SearchProductAndVerifyProductIsSorted with product: {}", product);
		TestCase1_HomePageVisible.verifyHomePageIsVisibleSuccessfully();

		searchForProduct(product);

		logger.info("Completed test: SearchProductAndVerifyProductIsSorted with product: {}", product);
	}

	private void searchForProduct(String productToSearch) {
		logger.info("Searching for product: {}", productToSearch);

		ExtentReportManager.getTest().info("Verifying search products are visible or not");

		new HomePage(driver).searchProduct(productToSearch);

		ExtentReportManager.getTest().info("Searching for product: " + productToSearch);

		searchProductIsVisible(productToSearch);

	}

	private void searchProductIsVisible(String searchedFor) {
		logger.info("Verifying visibility of searched product: {}", searchedFor);

		try {
			String showingResultFor = new ProductPage(driver).showingResult().getText();

			Assert.assertEquals(showingResultFor, searchedFor, "Searched Result not visible");

			ExtentReportManager.getTest().pass("Test case passed: Searched product " + searchedFor + " is visible");
			logger.info("Searched product {} is visible", searchedFor);
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Searched product not visible");
			logger.error("Searched product not visible", e);
			throw e;
		}
	}
}
