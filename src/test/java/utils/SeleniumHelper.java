package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement locator ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void waitForElementToBeVisible(WebDriver driver, WebElement locator ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public static void waitForAllElementsToBeVisible(WebDriver driver, List<WebElement> locator ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(locator));
	}
	
	public static void waitForTextToBePresentInElementValue(WebDriver driver, WebElement locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
	}

}
