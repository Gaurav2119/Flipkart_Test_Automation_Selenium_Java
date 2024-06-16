package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelper;

public class HomePage {
	
	@FindBy(css = "div._8S67Ib")
	private List<WebElement> adshow;
	
	@FindBy(xpath = "//span[contains(text(),'Mobiles')]")
	private WebElement mobilesbutton;
	
	@FindBy(xpath = "//span[contains(text(),'Travel')]")
	private WebElement travelbutton;
	
	@FindBy(xpath = "//span[contains(text(),'Grocery')]")
	private WebElement grocerybutton;
	
	@FindBy(xpath = "//span[contains(text(),'Appliances')]")
	private WebElement appliancesbutton;
	
	@FindBy(xpath = "//a[@title = 'Dropdown with more help links']")
	private WebElement helplinks;
	
	@FindBy(xpath = "//a[@title = '24x7 Customer Care']")
	private WebElement customersupport;
	
	@FindBy(xpath = "//a[@title = 'Become a Seller']")
	private WebElement becomeseller;
	
	@FindBy(xpath = "//input[@name='q']")
	private WebElement searchbox;
	
	@FindBy(xpath = "//a[@class='HlWMPX' and @aria-label='Terms Of Use']")
	private WebElement termsandconditionslink;
	
	@FindBy(xpath = "//a[@class='_9Wy27C']")
	private WebElement cartButton;
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public List<WebElement> homePageIsVisible(){
		return adshow;
	}
	
	public WebDriver homePageTitle() {
		return this.driver;
	}
	
	public MobilePhonesPage navigateToMobilesPage() {
		mobilesbutton.click();
		return new MobilePhonesPage(driver);
	}
	
	public TravelsPage navigateToTravelPage() {
		travelbutton.click();
		return new TravelsPage(driver);
	}
	
	public GroceryPage navigateToGroceryPage() {
		grocerybutton.click();
		return new GroceryPage(driver);
	}
	
	public AppliancesPage navigateToAppliancesPage() {
		appliancesbutton.click();
		return new AppliancesPage(driver);
	}
	
	public WebElement helpLinks() {
		return helplinks;
	}
	
	public WebElement customerSupport() {
		return customersupport;
	}
	
	public WebElement becomeSellerButton() {
		return becomeseller;
	}
	
	public ProductPage searchProduct(String productName) {
		searchbox.clear();
		
		SeleniumHelper.waitForTextToBePresentInElementValue(driver, searchbox, "");
		
		searchbox.sendKeys(productName);
		searchbox.sendKeys(Keys.RETURN);
		
		SeleniumHelper.waitForTextToBePresentInElementValue(driver, searchbox, productName);
		
		searchbox.sendKeys(Keys.CONTROL,"a");
		searchbox.sendKeys(Keys.DELETE);
		
		return new ProductPage(driver);
	}
	
	public ProductPage productSearch(String productName) {
		SeleniumHelper.waitForTextToBePresentInElementValue(driver, searchbox, "");
		
		searchbox.sendKeys(productName);
		searchbox.sendKeys(Keys.RETURN);
		
		searchbox.clear();
		
		SeleniumHelper.waitForTextToBePresentInElementValue(driver, searchbox, productName);
		
		return new ProductPage(driver);
	}
	
	public TermsAndConditionPage clickTermsAndConditionsLink() {
		SeleniumHelper.waitForElementToBeClickable(driver, termsandconditionslink);
		termsandconditionslink.click();
		return new TermsAndConditionPage(driver);
	}

	public WebElement clickCartButton() {
		return cartButton;
	}
}
