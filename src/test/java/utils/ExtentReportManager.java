package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentSparkReporter sparkReporter;
	private static ExtentReports extent;
	private static ExtentTest test;

	public static void initReport() {

		String reportPath = "extent-report/" + Util.generateCurrentDateAndTime() + ".html";

		sparkReporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	public static ExtentTest createTest(String testName, String description) {
		test = extent.createTest(testName, description);
		return test;
	}

	public static ExtentTest getTest() {
		return test;
	}

	public static void flushReport() {
		extent.flush();
	}

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Call getScreenshotAs method to create image file
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = "screenshots/" + screenshotName + Util.generateCurrentDateAndTime() + ".png";
		File DestFile = new File(destination);
		try {
			FileUtils.copyFile(source, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return DestFile.getAbsolutePath();
	}
}
