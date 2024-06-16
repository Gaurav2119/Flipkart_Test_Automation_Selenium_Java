package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellerDashboard {
	
	@FindBy(xpath = "//input[@label='Email ID']")
	private WebElement emailfield;
	
	@FindBy(xpath = "//input[@label='Enter Mobile Number']")
	private WebElement mobilenumberfield;
	
	@FindBy(xpath = "//span[contains(text(), 'Register & Continue')]")
	private WebElement continuebutton;
	
	WebDriver driver;
	
	public SellerDashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WebDriver sellerDashboardTitle() {
		return this.driver;
	}
	
	public WebElement emailField() {
		return emailfield;
	}
	
	public WebElement mobileNumberField() {
		return mobilenumberfield;
	}
	
	public WebElement continueButton() {
		return continuebutton;
	}
}
