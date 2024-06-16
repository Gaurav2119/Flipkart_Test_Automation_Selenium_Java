package pages;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelper;

public class TravelsPage {

	@FindBy(xpath = "//div[@class='NmD+EK']")
	private WebElement travelspageheading;

	@FindBy(xpath = "//input[@name='0-departcity']")
	private WebElement departcity;

	@FindBy(xpath = "//input[@name='0-arrivalcity']")
	private WebElement arrivalcity;

	@FindBy(xpath = "(//div[@class='ecAhsD uzeEmI'])[1]/div/div/div/span")
	private List<WebElement> departairport;

	@FindBy(xpath = "(//div[@class='ecAhsD uzeEmI'])[2]/div/div/div/span")
	private List<WebElement> arrivalairport;

	@FindBy(xpath = "//div[@class = 'VTUEC- _9z7C2Z']//div")
	private List<WebElement> trip;

	@FindBy(xpath = "//input[@id='ONE_WAY']")
	private WebElement onewayradio;

	@FindBy(xpath = "//input[@id='ROUND_TRIP']")
	private WebElement roundtripradio;

	@FindBy(xpath = "//button[@class = 'pl8ttv paxEPa ZFO-pc']")
	private WebElement providedDepartDate;

	@FindBy(xpath = "//button[@class = 'pl8ttv LJWtcS paxEPa FC89rO']")
	private WebElement providedArrivalDate;

	@FindBy(xpath = "//button[@class = 'xSWdQ- azBkHf']")
	private WebElement doneButton;

	@FindBy(xpath = "//button[@class = 'QqFHMw sgUmTV M5XAsp']")
	private WebElement searchButton;

	WebDriver driver;

	public TravelsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WebElement travelPageHeading() {
		return travelspageheading;
	}

	public WebElement selectOneWay() {
		SeleniumHelper.waitForAllElementsToBeVisible(driver, trip);
		for (WebElement trip_oneway : trip) {
			if (trip_oneway.getText().equalsIgnoreCase("one way")) {
				trip_oneway.click();
			}
		}

		return onewayradio;
	}

	public WebElement selectRoundTrip() {
		SeleniumHelper.waitForAllElementsToBeVisible(driver, trip);
		for (WebElement trip_round : trip) {
			if (trip_round.getText().equalsIgnoreCase("round trip")) {
				trip_round.click();
			}
		}

		return roundtripradio;
	}

	public void selectDepartCity(String city) {
		SeleniumHelper.waitForElementToBeClickable(this.driver, departcity);
		departcity.click();
		departcity.sendKeys(city);

		boolean citySelected = false;

		for (int attempts = 0; attempts < 3; attempts++) {
			try {

				PageFactory.initElements(driver, this);
				SeleniumHelper.waitForAllElementsToBeVisible(this.driver, departairport);

				for (WebElement selectAirport : departairport) {
					if (selectAirport.getText().equalsIgnoreCase(city)) {
						selectAirport.click();
						citySelected = true;
						break;
					}
				}
				if (citySelected)
					break; // Exit loop if city is selected
			} catch (StaleElementReferenceException e) {
				// Reinitialize page elements if stale
				System.out.println("Attempt " + (attempts + 1)
						+ ": Caught StaleElementReferenceException. Reinitializing elements...");
			}
		}
		if (!citySelected) {
			System.out.println("City not found in suggestions.");
		}
	}

	public void selectArrivalCity(String city) {
		SeleniumHelper.waitForElementToBeClickable(this.driver, arrivalcity);
		arrivalcity.click();
		arrivalcity.sendKeys(city);

		boolean citySelected = false;

		for (int attempts = 0; attempts < 3; attempts++) {
			try {

				PageFactory.initElements(driver, this);
				SeleniumHelper.waitForAllElementsToBeVisible(this.driver, arrivalairport);

				for (WebElement selectAirport : arrivalairport) {
					if (selectAirport.getText().equalsIgnoreCase(city)) {
						selectAirport.click();
						citySelected = true;
						break;
					}
				}
				if (citySelected)
					break; // Exit loop if city is selected
			} catch (StaleElementReferenceException e) {
				// Reinitialize page elements if stale
				System.out.println("Attempt " + (attempts + 1)
						+ ": Caught StaleElementReferenceException. Reinitializing elements...");
			}
		}
		if (!citySelected) {
			System.out.println("City not found in suggestions.");
		}
	}

	public WebElement defaultDepartDate() {
		SeleniumHelper.waitForElementToBeClickable(driver, providedDepartDate);
		return providedDepartDate;
	}

	public WebElement defaultArrivalDate() {
		SeleniumHelper.waitForElementToBeClickable(driver, providedArrivalDate);
		return providedArrivalDate;
	}

	public WebElement searchButton() {
		SeleniumHelper.waitForElementToBeClickable(driver, searchButton);
		return searchButton;
	}
}
