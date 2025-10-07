package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	// =========== constructor ===============
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// ============== Elements ====================
	
	@FindBy(linkText = "CHECKOUT")
	private WebElement checkout;
	
	
	// ============ Getters =====================
	
	public WebElement getCheckout() {
		return checkout;
	}
}
