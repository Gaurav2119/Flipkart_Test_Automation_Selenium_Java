package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class TestCase16_SortProductByPriceLowToHigh extends BaseTest {

	@Test(priority = 1)
	private void verifyHomePageIsVisibleSuccessfully() {
		logger.info("Starting test case: SortProductByPriceLowToHigh");

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
	private void searchForProduct(String productToSearch) throws Exception {
		ExtentReportManager.getTest().info("Verifying search item visible or not");
		logger.info("Verifying search item visible or not");

		new HomePage(driver).productSearch(productToSearch);

		ExtentReportManager.getTest().info("Searching for product: " + productToSearch);
		logger.info("Searching for product: " + productToSearch);

		searchProductIsVisible(productToSearch);
	}

	private void searchProductIsVisible(String searchedFor) throws Exception {
		try {
			String showingResultFor = new ProductPage(driver).showingResult().getText();

			Assert.assertEquals(showingResultFor, searchedFor, "Searched Result not visible");

			ExtentReportManager.getTest().pass("Test case passed: Searched product " + searchedFor + " is visible");
			logger.info("Test case passed: Searched product " + searchedFor + " is visible");

			sortProductByPriceLowToHigh();

		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Searched product not visible");
			logger.info("Searched product not visible", e);
			throw e;
		}
	}

	private void sortProductByPriceLowToHigh() throws Exception {
		ExtentReportManager.getTest().info("Trying to sort product by price low to high");
		logger.info("Trying to sort product by price low to high");

		try {

			new ProductPage(driver).clickLowToHighPriceButton().click();

			ExtentReportManager.getTest().info("Verifying the result");
			logger.info("Verifying the result");

			List<Integer> list_product_price = new ProductPage(driver).sortProductsPriceList();

			if (list_product_price == null) {
				logger.warn("Product prices list is null");
				throw new Exception("Product prices list is null");
			}

			List<Integer> sorted_list_product_price = new ArrayList<>(list_product_price);

			Collections.sort(sorted_list_product_price);

			Assert.assertEquals(list_product_price, sorted_list_product_price, "Product not sorted by price");
			ExtentReportManager.getTest().pass("Sorted by price low to high");
			logger.info("Sorted by price low to high");

		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test case failed: Product not sorted by price");
			logger.info("Test case failed: Product not sorted by price", e);
			throw e;
		}
	}

}
