package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout1Page {

	// =========== constructor ===============
	public Checkout1Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	// ============== Elements ====================
	
	@FindBy(id = "first-name")
	private WebElement fname;
	
	@FindBy(id = "last-name")
	private WebElement lname;
	
	@FindBy(id = "postal-code")
	private WebElement postalCode;
	
	@FindBy(xpath = "//input[@value='CONTINUE']")
	private WebElement continueBtn;
	
	// ============ Getters =====================
	
	public WebElement getFname() {
		return fname;
	}
	
	public WebElement getLname() {
		return lname;
	}
	
	public WebElement getPostalCode() {
		return postalCode;
	}
	
	public WebElement getContinueBtn() {
		return continueBtn;
	}
}
