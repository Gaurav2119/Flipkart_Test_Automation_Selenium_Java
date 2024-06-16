package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {
	
	@FindBy(xpath = "//span[normalize-space()='Login or Signup']")
	private WebElement loginsignupfield;
	
	WebDriver driver;

	public PlaceOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement loginSignUpField() {
		return loginsignupfield;
	}
	
}
