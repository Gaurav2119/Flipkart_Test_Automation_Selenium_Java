package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelper;

public class SellerPage {
	
	@FindBy(xpath = "//img[contains(@class,'styles__HeaderImage-sc-155ljwi-1')]")
	private WebElement flipkartsellerlogo;
	
	@FindBy(xpath = "//button[contains(@class,'jSCZCD')]")
	private WebElement startsellingbutton;

	WebDriver driver;

	public SellerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public WebDriver sellerPageTitle() {
		return this.driver;
	}
	
	public WebElement sellerLogo() {
		SeleniumHelper.waitForElementToBeVisible(driver, flipkartsellerlogo);
		return flipkartsellerlogo;
	}
	
	public WebElement startSellingButton() {
		return startsellingbutton;
	}
	
	public SellerDashboard goToSellerDashboard() {
		startsellingbutton.click();
		return new SellerDashboard(driver);
	}

}
