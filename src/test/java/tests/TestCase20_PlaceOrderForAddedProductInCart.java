package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.PlaceOrderPage;
import pages.ProductDetailPage;
import pages.ProductPage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class TestCase20_PlaceOrderForAddedProductInCart extends BaseTest {

	@Test(priority = 0, groups = "regression")
	private void verifyHomePageIsVisibleSuccessfully() {
		logger.info("Stating test case : PlaceOrderForAddedProductInCart");

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

	@Test(priority = 1, dataProvider = "testdata", dataProviderClass = BaseTest.class, groups = "regression")
	private void searchForProduct(String productToSearch) {
		ExtentReportManager.getTest().info("Verifying search products are visible or not");
		logger.info("Verifying search products are visible or not");

		new HomePage(driver).searchProduct(productToSearch);

		ExtentReportManager.getTest().info("Searching for product: " + productToSearch);
		logger.info("Searching for product: " + productToSearch);

		searchProductIsVisible(productToSearch);

	}

	@Test(priority = 2, groups = "regression")
	private void verifyProductDetailsIsDisplayed() {

		new ProductPage(driver).clickFirstProduct();

		ExtentReportManager.getTest().info("Verifying product details are visible or not");
		logger.info("Verifying product details are visible or not");
		try {
			boolean productTitle = new ProductDetailPage(driver).getProductTitle().isDisplayed();

			boolean productPriceDisplayed = new ProductDetailPage(driver).getProductPrice().isDisplayed();

			Assert.assertTrue(productTitle, "Product title not matched");
			ExtentReportManager.getTest().pass("Test case passed: Product title displayed");
			logger.info("Test case passed: Product title displayed");

			Assert.assertTrue(productPriceDisplayed, "Product price not displayed");
			ExtentReportManager.getTest().pass("Test case passed: Product price displayed");
			logger.info("Test case passed: Product price displayed");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test case passed: Product title or price not displayed");
			logger.info("Test case passed: Product title or price not displayed", e);
			throw e;
		}
	}

	@Test(priority = 3, groups = "regression")
	private void addProductToCart() throws IOException, InterruptedException {

		new ProductDetailPage(driver).clickAddtoCartButton();
	}

	@Test(priority = 4, groups = {"regression", "visibility"})
	private void verifyCartPageIsVisible() {
		ExtentReportManager.getTest().info("Verifying cart page is visible or not");
		logger.info("Verifying cart page is visible or not");
		try {

			boolean displayedPlaceOrderButton = new CartPage(driver).buttonPlaceOrder().isDisplayed();

			Assert.assertTrue(displayedPlaceOrderButton, "Place Order Button not displayed");
			ExtentReportManager.getTest().pass("Test passed: Cart page is visible");
			logger.info("Test passed: Cart page is visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Cart page is not visible");
			logger.info("Test failed: Cart page is not visible", e);
			throw e;
		}
	}

	@Test(priority = 5, groups = "visibility")
	private void verifyProductIsAddedToCart() {
		ExtentReportManager.getTest().info("Verifying product added to cart or not");
		logger.info("Verifying product added to cart or not");

		try {

			int productInCart = new CartPage(driver).totalProductInCart().size();

			Assert.assertTrue(productInCart > 0, "Product not added to cart");
			ExtentReportManager.getTest().pass("Test passed: Product added to cart");
			logger.info("Test passed: Product added to cart");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Product not added to cart");
			logger.info("Test failed: Product not added to cart", e);
			throw e;
		}
	}

	@Test(priority = 6, groups = "visibility")
	private void placeOrder() {
		ExtentReportManager.getTest().info("Verifying product removed from cart");
		logger.info("Verifying product removed from cart");
		try {

			new CartPage(driver).clickPlaceOrderButton();

			boolean displayedDetailsField = new PlaceOrderPage(driver).loginSignUpField().isDisplayed();

			Assert.assertTrue(displayedDetailsField, "Details filling field not displayed");
			ExtentReportManager.getTest().pass("Test passed: Details filling field visible");
			logger.info("Test passed: Details filling field visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Details filling field not displayed");
			logger.info("Test failed: Details filling field not displayed", e);
			throw e;
		}
	}

	private void searchProductIsVisible(String searchedFor) {
		try {
			String showingResultFor = new ProductPage(driver).showingResult().getText();

			Assert.assertEquals(showingResultFor, searchedFor, "Searched Result not visible");

			ExtentReportManager.getTest().pass("Test case passed: Searched product " + searchedFor + " is visible");
			logger.info("Test case passed: Searched product " + searchedFor + " is visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Searched product not visible");
			logger.info("Searched product not visible", e);
			throw e;
		}
	}
}
