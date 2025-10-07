package pom_extra;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SauceDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		driver.get("https://www.saucedemo.com/v1/index.html");
		
		
		// login
		LoginPage lp = new LoginPage(driver);
		
		WebElement un = lp.getUn();
		WebElement pwd = lp.getPwd();
		WebElement login = lp.getLogin();
		
		un.sendKeys("standard_user");
		pwd.sendKeys("secret_sauce");
		login.click();
		
		Thread.sleep(1500);
		
		// add product to cart
		HomePage hp = new HomePage(driver);
		
		WebElement addToCart = hp.getAddToCart();
		WebElement cart = hp.getCartIcon();
		
		addToCart.click();
		cart.click();
		
		Thread.sleep(1500);
		
		// Cart page
		CartPage cp = new CartPage(driver);
		
		WebElement checkout = cp.getCheckout();
		
		checkout.click();
		
		
		// checkout 1 details
		Checkout1Page cp1 = new Checkout1Page(driver);
		
		WebElement fname = cp1.getFname();
		WebElement lname = cp1.getLname();
		WebElement postal = cp1.getPostalCode();
		WebElement continueBtn = cp1.getContinueBtn();
		
		fname.sendKeys("Sarfaraz");
		lname.sendKeys("Ahmad");
		postal.sendKeys("210421");
		
		continueBtn.click();
		
		Thread.sleep(1000);
		

		// checkout overview - 2 page
		Checkout2Page cp2 = new Checkout2Page(driver);
		
		WebElement finish = cp2.getFinishBtn();
		finish.click();
		
		Thread.sleep(500);
		

		//  confirmation page
		ConfirmationPage confirm = new ConfirmationPage(driver);
		
		WebElement thankMsg = confirm.getThankMsg();
		
		if(thankMsg.isDisplayed())
			System.out.println("Item ordered successfully");
		else
			System.out.println("Item order failed");
		
		
		Thread.sleep(1500);
		
		driver.quit();
	}
}
