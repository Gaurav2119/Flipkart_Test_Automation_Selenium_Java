package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumHelper;

public class ProductPage {
	
	@FindBy(xpath = "//span[@class='BUOuZu']//span")
	private WebElement searchfor;
	
	@FindBy(xpath = "//div[@class = 'sHCOk2']/div[3]")
	private WebElement buttonpricelowtohigh;
	
	@FindBy(xpath = "(//div[@class = 'DOjaWF gdgoEp']//div[@class='cPHDOP col-12-12'])[1]/div/div[1]")
	private WebElement clickfirstproduct;
	
	@FindBy(xpath = "(//div[@class = '+7E521'])[1]")
	private WebElement wishlistbutton;
	
	@FindBy(xpath = "//div[@class='DOjaWF gdgoEp']//div[@class = 'hl05eU']/div[contains(@class, 'Nx9bqj')]")
	private List<WebElement> productprice;
	
	@FindBy(xpath = "//button[@class = 'QqFHMw twnTnD _7Pd1Fp']")
	private WebElement requestOTPbutton;
	
	@FindBy(xpath = "//button[@class = 'QqFHMw NEEcDr']")
	private WebElement crossbutton;
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public WebElement showingResult() {
		SeleniumHelper.waitForElementToBeVisible(driver, searchfor);
		return searchfor;
	}
	
	public ProductDetailPage clickFirstProduct() {
		driver.getWindowHandle();
		
		SeleniumHelper.waitForElementToBeClickable(driver, clickfirstproduct);
		clickfirstproduct.click();
		
		// Wait for the new tab to open
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        
        // Get all window handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        
        // Switch to the new tab
        //tabs.remove(mainWindowHandle);
        driver.switchTo().window(tabs.get(1));
        
		return new ProductDetailPage(driver);
	}
	
	public WebElement clickLowToHighPriceButton() {
		SeleniumHelper.waitForElementToBeClickable(driver, buttonpricelowtohigh);
		return buttonpricelowtohigh;
	}
	
	public List<Integer> sortProductsPriceList(){
		boolean priceFetched = false;

		for (int attempts = 0; attempts < 3; attempts++) {
			try {

				PageFactory.initElements(driver, this);
				SeleniumHelper.waitForAllElementsToBeVisible(driver, productprice);

				List<Integer> list_product_price = new ArrayList<Integer>();
				for(WebElement ele: productprice) {
					list_product_price.add(Integer.valueOf(ele.getText().replaceAll("[^0-9]", "")));
				}
				
				priceFetched = true;
				
				if (priceFetched)
					return list_product_price;
			} catch (StaleElementReferenceException e) {
				// Reinitialize page elements if stale
				System.out.println("Attempt " + (attempts + 1)
						+ ": Caught StaleElementReferenceException. Reinitializing elements...");
			}
		}
		if (!priceFetched) {
			System.out.println("Facing issue to fetch product price.");
		}
		return null;
	}
	
	public WebElement clickWishlistButton() {
		SeleniumHelper.waitForElementToBeClickable(driver, wishlistbutton);
		return wishlistbutton;
	}
	
	public WebElement OTPButton() {
		SeleniumHelper.waitForElementToBeVisible(driver, requestOTPbutton);
		return requestOTPbutton;
	}
	
	public WebElement clickCrossButton() {
		SeleniumHelper.waitForElementToBeClickable(driver, crossbutton);
		return crossbutton;
	}
}
