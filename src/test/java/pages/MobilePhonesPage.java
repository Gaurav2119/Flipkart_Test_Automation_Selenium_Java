package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelper;

public class MobilePhonesPage {
	
	@FindBy(xpath = "//h1[@class='_0FYq1K']" )
	private WebElement mobilepageheading;
	
	@FindBy(xpath = "//div[@class='s8FW+c']//a[1]")
	private WebElement clickfirstmobilephoneinlist;

	private WebDriver driver;

	public MobilePhonesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public WebElement mobilePageHeading() {
		SeleniumHelper.waitForElementToBeVisible(driver, mobilepageheading);
		return mobilepageheading;
	}
	
	public WebElement clickFirstMobilePhone(){
		return clickfirstmobilephoneinlist;
	}
}
