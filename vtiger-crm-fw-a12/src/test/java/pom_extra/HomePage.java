package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// ========== constructor ====================
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		// =========== Elements ====================
		
		@FindBy(xpath="//a[contains(@id, 'item_4_img_link')]/../..//button")
		private WebElement addToCart;
		
		@FindBy(xpath="//div[@id='shopping_cart_container']/a")
		private WebElement cartIcon;
		
		//================ Getters =========================
		
		public WebElement getAddToCart() {
			return addToCart;
		}
		
		public WebElement getCartIcon() {
			return cartIcon;
		}
}
