package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GroceryPage;
import pages.HomePage;
import utils.BaseTest;
import utils.ExtentReportManager;
import utils.PropertiesLoader;

public class TestCase15_SearchGroceryItemInGroceryPage extends BaseTest {

	@Test(priority = 1)
	private void verifyHomePageIsVisibleSuccessfully() {
		logger.info("Starting test case: SearchGroceryItemInGroceryPage");

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
	private void verifyGroceryPageIsVisibleSuccessfully() {
		ExtentReportManager.getTest().info("Verifying Grocery page is visible or not");
		logger.info("Verifying Grocery page is visible or not");

		try {
			boolean groceryimage = new HomePage(driver).navigateToGroceryPage().groceryimagedisplayed().isDisplayed();

			Assert.assertTrue(groceryimage, "Grocery page is not displayed");

			ExtentReportManager.getTest().pass("Test passed: Grocery page is visible");
			logger.info("Test passed: Grocery page is visible");

		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Grocery page is not visible");
			logger.info("Test failed: Grocery page is not visible", e);
			throw e;
		}
	}

	@Test(priority = 3)
	private void enterPincode() throws Exception {
		try {
			String pincode = PropertiesLoader.loadProperty("pincode");
			ExtentReportManager.getTest().info("Entering pincode " + pincode);
			logger.info("Entering pincode " + pincode);

			new GroceryPage(driver).enterPincode(pincode);
			ExtentReportManager.getTest().pass("Pincode entered");
			logger.info("Pincode entered");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Not able to enter pincode");
			logger.info("Not able to enter pincode", e);
			throw e;
		}
	}

	@Test(dataProvider = "testdata", dataProviderClass = BaseTest.class, priority = 4)
	private void searchForProduct(String groceryItemToSearch) {
		ExtentReportManager.getTest().info("Verifying search item visible or not");
		logger.info("Verifying search item visible or not");

		new GroceryPage(driver).searchProduct(groceryItemToSearch);

		ExtentReportManager.getTest().info("Searching for item: " + groceryItemToSearch);
		logger.info("Searching for item: " + groceryItemToSearch);

		searchProductIsVisible(groceryItemToSearch);
	}

	private void searchProductIsVisible(String searchedFor) {
		try {
			String showingResultFor = new GroceryPage(driver).showingResult().getText();

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
