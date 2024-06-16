package utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

	protected static WebDriver driver;
	protected static final Logger logger = LogManager.getLogger(BaseTest.class);

	@BeforeSuite
	public void beforeSuiteSetup() {
		ExtentReportManager.initReport();
	}

	@BeforeClass
	public void setUp() throws IOException {

		logger.info("Setting up for test class: " + this.getClass().getSimpleName());

		String browsername = PropertiesLoader.loadProperty("browser.name");
		Boolean headlessmode = "true".equalsIgnoreCase(PropertiesLoader.loadProperty("browser.headless"));

		String url = PropertiesLoader.loadProperty("base.url");

		driver = BrowserManager.browserSetup(browsername, headlessmode);

		if (driver == null) {
			logger.error("Browser can't be invoked. Try with another browser!!");
			throw new ExceptionHandler("Browser can't invoked. Try with other browser!!");
		}

		driver.manage().window().maximize();

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

		ExtentReportManager.createTest(this.getClass().getSimpleName(), "");
		logger.info("Test setup complete for class: " + this.getClass().getSimpleName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ExtentReportManager.captureScreenshot(driver, result.getName());
			ExtentReportManager.getTest()
					.fail("Test case failed. Screenshot attached: " + result.getThrowable().getMessage())
					.addScreenCaptureFromPath(screenshotPath);
			logger.error("Test case failed: " + result.getName(), result.getThrowable());
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
			logger.info("Browser closed and resources released.");
		}

		ExtentReportManager.flushReport();
	}

	@DataProvider(name = "testdata")
	public static Object[][] getData() {
		String excelPath = "src/test/resources/datafile.xlsx";
		String sheetName = "TestData";

		Object data[][] = Util.testData(excelPath, sheetName);
		return data;
	}
}
