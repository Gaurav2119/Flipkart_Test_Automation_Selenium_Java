package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelper;

public class AppliancesPage {
	
	@FindBy(xpath = "//h1[@class = '_0FYq1K']")
	private WebElement appliancespageheading;
	
	private WebDriver driver;
	
	public AppliancesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	
	public WebElement appliancesPageHeading() {
		SeleniumHelper.waitForElementToBeVisible(driver, appliancespageheading);
		return appliancespageheading;
	}

}
