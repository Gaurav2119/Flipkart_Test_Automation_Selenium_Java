package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelper;

public class FlightPage {

	@FindBy(xpath = "//span[@class = 'PH2SxH']")
	private List<WebElement> location;

	@FindBy(xpath = "//div[@class='Do40aG']")
	private List<WebElement> bookButtonOneWay;
	
	@FindBy(xpath = "//div[@class='_7QayNj']")
	private WebElement bookButtonRoundTrip;

	@FindBy(xpath = "//button[@class='QqFHMw twnTnD _7Pd1Fp']")
	private WebElement otpButton;

	private WebDriver driver;

	public FlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public List<WebElement> flightLocation() {
		SeleniumHelper.waitForAllElementsToBeVisible(driver, location);
		return location;
	}

	public List<WebElement> clickBookButtonOneWay() {
		return bookButtonOneWay;
	}
	
	public WebElement clickBookButtonRoundTrip() {
		return bookButtonRoundTrip;
	}
	
	public WebElement requestOTP() {
		SeleniumHelper.waitForElementToBeVisible(driver, otpButton);
		return otpButton;
	}
}
