package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	// =========== constructor ===============
	public ConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	// ============== Elements ====================
	
	@FindBy(xpath = "//h2[text()='THANK YOU FOR YOUR ORDER']")
	private WebElement thankMsg;
	
	
	// ============ Getters =====================
	
	public WebElement getThankMsg() {
		return thankMsg;
	}
	
}
