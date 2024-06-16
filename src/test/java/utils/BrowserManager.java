package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {

	public static WebDriver browserSetup(String browserName, boolean headlessMode) {

		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// Initialize ChromeDriver
			ChromeOptions options = new ChromeOptions();

			if (headlessMode) {
				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// Initialize FirefoxDriver
			FirefoxOptions options = new FirefoxOptions();

			if (headlessMode) {
				options.addArguments("headless");
			}

			driver = new FirefoxDriver(options);

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			// Initialize EdgeDriver
			EdgeOptions options = new EdgeOptions();

			if (headlessMode) {
				options.addArguments("headless");
			}

			driver = new EdgeDriver(options);

		}
		
		return driver;
	}
}
