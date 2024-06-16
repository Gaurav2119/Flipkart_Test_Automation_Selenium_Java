package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.BaseTest;
import utils.ExtentReportManager;
import utils.PropertiesLoader;

public class TestCase2_VerifyHomePageTitle extends BaseTest {

	@Test
	public void verifyHomePageTitle() throws IOException {
		logger.info("Starting test: VerifyHomePageTitle");
		
		TestCase1_HomePageVisible.verifyHomePageIsVisibleSuccessfully();
		HomePageTitle();
		
		logger.info("Completed test: VerifyHomePageTitle");
	}

	private void HomePageTitle() throws IOException {

		ExtentReportManager.getTest().info("Matching home page title");
		logger.info("Matching home page title");

		try {
			String expectedTitle = PropertiesLoader.loadProperty("homePage.title");

			String actualTitle = new HomePage(driver).homePageTitle().getTitle();

			Assert.assertEquals(actualTitle, expectedTitle, "Title not matched");
			
			ExtentReportManager.getTest().pass("Test passed: Home page title matched");
			logger.info("Test passed: Home page title matched");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test failed: Home page title not matched");
			logger.info("Test failed: Home page title not matched", e);
			throw e;
		}
	}
}
