package documents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateDocumentTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// fetch common data from properties file
		FileInputStream commonData = new FileInputStream("./src/test/resources/testdata/commondata.properties");
		Properties pObj = new Properties();
		pObj.load(commonData);
		String USER_NAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		// fetch Test Script data from excel file
		FileInputStream scriptData = new FileInputStream("./src/test/resources/testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(scriptData);
		Sheet sh = wb.getSheet("Doc");
		Row rw = sh.getRow(3);
		Cell titleCell = rw.getCell(0);
		String titleData = titleCell.getStringCellValue();
		Cell descCell = rw.getCell(1);
		String description = descCell.getStringCellValue(); 
		
		wb.close();
		
		// ===== Open browser and launch application ======
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				driver.get("http://localhost:8888/");
				
				Thread.sleep(2000);
				
				// ===== Login ========
				/*
				String uname = "admin";
				String pass = "manager";
				*/
				WebElement username = driver.findElement(By.name("user_name"));
				username.sendKeys(USER_NAME);
				WebElement password = driver.findElement(By.name("user_password"));
				password.sendKeys(PASSWORD);
				
				driver.findElement(By.id("submitButton")).click();
				
				Thread.sleep(1500);
				
				// ======== Navigate to Documents Page ================
				driver.findElement(By.linkText("Documents")).click();
				
				Thread.sleep(1500);
				
				// ========= Create a new Document ==============
				driver.findElement(By.cssSelector("img[alt='Create Document...']")).click();
				
				Thread.sleep(2500);
				
				// enter title
//				String title = "abc" + Math.round(Math.random() * 1000);
				String title = titleData + (int)(Math.random() * 1000);
				driver.findElement(By.name("notes_title")).sendKeys(title);
				
				// enter description
				driver.switchTo().frame(0);
				driver.findElement(By.tagName("body")).sendKeys(description);
				
				driver.switchTo().defaultContent();
				
				// click save button
				driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
				
				Thread.sleep(2000);
				
//				// ============ Back to Documents page ===========
//				driver.findElement(By.linkText("Documents")).click();
				
				// =========== Verify Document is Created =================
				/*
				List<WebElement> entries = driver.findElements(By.xpath("//tr[contains(@id, 'row_')]"));

				//)
				
				Boolean success = false;
				for (WebElement entry : entries) {
					String curTitle = entry.findElement(By.xpath("./td[3]")).getText();
					if(curTitle.equals(title)) {
						success = true;
						break;
					}
				}
				*/
				String actTitle = driver.findElement(By.id("dtlview_Title")).getText();
				
				// Match the title
				if(actTitle.equals(title))
					System.out.println("Document created successfully.....");
				else 
					System.out.println("Document creation failed....");
				Thread.sleep(5000);
				driver.quit();
	}

}
