package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductDetailPage {
	
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	private WebElement addtocartbutton;
	
	@FindBy(xpath = "//span[@class='VU-ZEz']")
	private WebElement producttitle;
	
	@FindBy(xpath = "//div[@class='Nx9bqj CxhGGd']")
	private WebElement productprice;
	
	WebDriver driver;
	
	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddtoCartButton() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(addtocartbutton).click().perform();
	}
	
	public WebElement getProductTitle() {
		return producttitle;
	}
	
	public WebElement getProductPrice() {
		return productprice;
	}

}
