package opportunity;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class CreateOpportunityTest {

	public static void main(String[] args) throws InterruptedException, IOException {

		// fetch common data from properties file
		FileInputStream prop = new FileInputStream("./src/test/resources/testdata/commondata.properties");
		Properties pObj = new Properties();
		pObj.load(prop);
		String USER_NAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		// ===== Open browser and launch application ======
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		
		Thread.sleep(2000);
		
		// ===== Login ======== 
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(USER_NAME);
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(1500);
		
		// ======== Navigate to Opportunities ================
		driver.findElement(By.linkText("Opportunities")).click();
		
		Thread.sleep(1500);
		
		// ========= Create a new opportunity ==============
		driver.findElement(By.cssSelector("img[alt='Create Opportunity...']")).click();
		
		String opName = "abc -" + (int)(Math.random() * 1000 ) + " units";
		WebElement opportunityName = driver.findElement(By.name("potentialname"));
		opportunityName.sendKeys(opName);
		
		// select organization
		String PID = driver.getWindowHandle();
		WebElement addOrg = driver.findElement(RelativeLocator.with(By.cssSelector("img[src='themes/softed/images/select.gif']")).toRightOf(By.id("related_to_display")));
		addOrg.click();
		
		Set<String> IDs = driver.getWindowHandles();
		Thread.sleep(1500);
		
		for(String id : IDs) {
			driver.switchTo().window(id);
			if(!driver.getTitle().contains("Opportunities")) {
				driver.findElement(By.linkText("vtiger")).click();
				break;
			}
		}
		
//		driver.switchTo().window(PID);
		
		Thread.sleep(2000);
		
		// select Type
		WebElement typeDD = driver.findElement(By.name("opportunity_type"));
		new Select(typeDD).selectByVisibleText("Existing Business");
		
		Thread.sleep(500);
		
		// select Type
		WebElement leadDD = driver.findElement(By.name("leadsource"));
		new Select(leadDD).selectByVisibleText("Partner");
		
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		
		// ========== Back to Opportunities page =============
		driver.findElement(By.linkText("Opportunities")).click();
		
		// =========== Verify Document is Created =================
		/*
		List<WebElement> entries = driver.findElements(By.xpath("//tr[contains(@id, 'row_')]"));
		
		Boolean success = false;
		for (WebElement entry : entries) {
			String curTitle = entry.findElement(By.xpath("./td[3]")).getText();
			if(curTitle.equals(opName)) {
				success = true;
				break;
			}
		}
		
		*/
		String actTitle = driver.findElement(By.id("dtlview_Opportunity Name")).getText();
		
		if(actTitle.equals(opName))
			System.out.println("Opportunity created successfully.....");
		else 
			System.out.println("Opportunity creation failed....");
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
