package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SupportPage;
import utils.BaseTest;
import utils.ExtentReportManager;

public class TestCase8_VerifySupportPageTopics extends BaseTest {

	@Test
	public void verifyHelpTopics() {
		logger.info("Starting test: VerifySupportPageTopics");
		
		TestCase1_HomePageVisible.verifyHomePageIsVisibleSuccessfully();

		supportPageIsVisible();
		deliveryRelatedTopicIsVisible();
		refundsRelatedTopicIsVisible();
		
		logger.info("Completed test: VerifySupportPageTopics");
	}

	private void supportPageIsVisible() {
		ExtentReportManager.getTest().info("Verifying support page is visible or not.");
		logger.info("Verifying support page is visible or not.");

		try {
			new HomePage(driver).helpLinks().click();
			new HomePage(driver).customerSupport().click();

			ExtentReportManager.getTest().pass("Customer support button clicked");
			logger.info("Customer support button clicked");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Not able to click customer support button");
			logger.info("Not able to click customer support button", e);
			throw e;
		}
		try {
			boolean pageVisible = new SupportPage(driver).supportPageHeading().isDisplayed();

			Assert.assertTrue(pageVisible, "Support page is not visible");

			ExtentReportManager.getTest().pass("Test case passed: Customer support page is visible");
			logger.info("Test case passed: Customer support page is visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Test case failed: Support page not visible");
			logger.info("Test case failed: Support page not visible", e);
			throw e;
		}
	}

	private void deliveryRelatedTopicIsVisible() {

		ExtentReportManager.getTest().info("Verifying delivery topic is visible");
		logger.info("Verifying delivery topic is visible");

		try {
			new SupportPage(driver).deliveryHelpTopic().click();

			ExtentReportManager.getTest().pass("Help topic delivery related clicked");
			logger.info("Help topic delivery related clicked");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Not able to click help topic delivery related");
			logger.info("Not able to click help topic delivery related", e);
			throw e;
		}

		try {
			String topicClicked = new SupportPage(driver).deliveryHelpTopic().getText();
			String topicVisible = new SupportPage(driver).topicVisible().getText();

			Assert.assertEquals(topicClicked, topicVisible, topicClicked + " topic not visible");

			ExtentReportManager.getTest().pass("Help topic delivery related is visible");
			logger.info("Help topic delivery related is visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Help topic delivery related not visible");
			logger.info("Help topic delivery related not visible", e);
			throw e;
		}
	}

	private void refundsRelatedTopicIsVisible() {

		ExtentReportManager.getTest().info("Verifying refund topic is visible");
		logger.info("Verifying refund topic is visible");

		try {
			new SupportPage(driver).refundHelpTopic().click();
			ExtentReportManager.getTest().pass("Help topic refund related clicked");
			logger.info("Help topic refund related clicked");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Not able to click help topic refund related");
			logger.info("Not able to click help topic refund related", e);
			throw e;
		}

		try {
			String topicClicked = new SupportPage(driver).refundHelpTopic().getText();
			String topicVisible = new SupportPage(driver).topicVisible().getText();

			Assert.assertEquals(topicClicked, topicVisible, topicClicked + " topic not visible");

			ExtentReportManager.getTest().pass("Help topic refund related is visible");
			logger.info("Help topic refund related is visible");
		} catch (Exception e) {
			ExtentReportManager.getTest().fail("Help topic refund related not visible");
			logger.info("Help topic refund related not visible", e);
			throw e;
		}
	}
}
