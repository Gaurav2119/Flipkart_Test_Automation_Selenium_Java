package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelper;

public class GroceryPage {
	
	@FindBy(css = ".W5mR4e")
	private WebElement groceryImage;
	
	@FindBy(xpath = "//input[@name='q']")
	private WebElement searchbox;
	
	@FindBy(xpath = "//input[@name='pincode']")
	private WebElement pincodebox;
	
	@FindBy(xpath = "//span[@class='BUOuZu']//span")
	private WebElement searchfor;
	
	private WebDriver driver;
	
	public GroceryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	
	public WebElement groceryimagedisplayed() {
		SeleniumHelper.waitForElementToBeVisible(driver, groceryImage);
		return groceryImage;
	}
	
	public void searchProduct(String productName) {
		SeleniumHelper.waitForElementToBeClickable(driver, searchbox);
		searchbox.clear();
		SeleniumHelper.waitForTextToBePresentInElementValue(driver, searchbox, "");
		searchbox.sendKeys(productName);
		searchbox.sendKeys(Keys.RETURN);
		SeleniumHelper.waitForTextToBePresentInElementValue(driver, searchbox, productName);
	}
	
	public WebElement showingResult() {
		SeleniumHelper.waitForElementToBeVisible(driver, searchfor);
		return searchfor;
	}
	
	public void enterPincode(String pincode) {
		SeleniumHelper.waitForElementToBeClickable(driver, pincodebox);
		SeleniumHelper.waitForTextToBePresentInElementValue(driver, pincodebox, "");
		pincodebox.sendKeys(pincode);
		SeleniumHelper.waitForTextToBePresentInElementValue(driver, pincodebox, pincode);
		pincodebox.sendKeys(Keys.RETURN);
	}
}
