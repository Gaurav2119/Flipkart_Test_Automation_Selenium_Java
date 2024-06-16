package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelper;

public class CartPage {

	@FindBy(xpath = "//div[@class = 'QqFHMw aEsfVh _7Pd1Fp']")
	private WebElement loginbutton;

	@FindBy(xpath = "//button[@class = 'QqFHMw zA2EfJ _7Pd1Fp']")
	private WebElement placeorderbutton;

	@FindBy(xpath = "//div[@class = '_8X-K8p']")
	private List<WebElement> productincart;

	@FindBy(xpath = "//span[normalize-space()='Place Order']")
	private WebElement placeorder;

	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement loginButton() {
		return loginbutton;
	}

	public WebElement buttonPlaceOrder() {
		return placeorderbutton;
	}

	public List<WebElement> totalProductInCart() {
		return productincart;
	}

	public PlaceOrderPage clickPlaceOrderButton() {
		SeleniumHelper.waitForElementToBeClickable(driver, placeorder);
		placeorder.click();
		
		return new PlaceOrderPage(driver);
	}
}
