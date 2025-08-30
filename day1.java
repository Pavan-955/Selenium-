package One.simple.Learn_Maven;

import static org.junit.Assert.*;

import java.awt.List;
import java.awt.RenderingHints.Key;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.support.ui.ExpectedConditions;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import com.google.gson.annotations.Until;

import org.openqa.selenium.interactions.Actions;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day1 {
	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		//Setup chromedriver path
				//System.setProperty("webdriver.chrome.driver","C:\\Users\\shiva\\OneDrive\\Desktop\\Pavan Work Folder\\chromedriver-win64");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				//Explicit wait
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));

			}
		
	

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	@Ignore
	@Test
	public void test() {
		driver.get("https://demoqa.com/elements");
		//WebElement elements = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[2]"));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement elements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div/div[2]")));
//		elements.click();
		WebElement textbox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li[1]/span"));
		textbox.click();
		WebElement fname = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
		fname.sendKeys("Pavan Var");
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
		email.sendKeys("Pavan@gmail.com");
		WebElement curAdd = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
		curAdd.sendKeys("Pavan Address 123@ X Road");
		WebElement perAdd = driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]"));
		perAdd.sendKeys("PErmanent Pavan Address 123@ X Road");
		WebElement textSubmit = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div/button"));
		System.out.println(textSubmit.getText());
		textSubmit.sendKeys(Keys.TAB);
		textSubmit.sendKeys(Keys.ENTER);
		String outText = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[3]")).getText();
		
		System.out.println("Form Output:"+ outText);
	}
	@Ignore
	@Test
	public void testCheckbox() throws InterruptedException {

		driver.get("https://demoqa.com/checkbox");
		((JavascriptExecutor)driver).executeScript("window.scroll(0,200)");
		WebElement plus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/div/button[1]"));
		plus.click();
		Thread.sleep(3);
		WebElement minus= driver.findElement(By.xpath("//*[@id=\"tree-node\"]/div/button[2]"));
		minus.click();
		Thread.sleep(3);
		WebElement dhome= driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
		dhome.click();
		Thread.sleep(3);
		WebElement ddoc = driver.findElement(By.xpath("//*[@class=\"rct-node rct-node-parent rct-node-expanded\"]/ol/li[2]/span/button[1]"));
		ddoc.click();
		Thread.sleep(3);
		WebElement docCheck = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[1]"));
//		docCheck.click();
		if(!docCheck.isSelected()) {
			docCheck.click();
		}
		System.out.println("2");
	}
	
	@Test
	public void testTablelist(){
		driver.get("https://demoqa.com/webtables");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
		java.util.List<WebElement> rows = driver.findElements(By.xpath("//*[@class=\"rt-tr-group\"]"));
		for (WebElement row : rows) {
            java.util.List<WebElement> cells = row.findElements(By.className("rt-td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " | ");
            }
            System.out.println(); 
            
		}
		
	}
	@Ignore
	@Test
	public void testTable()  throws Exception{
		driver.get("https://demoqa.com/webtables");
		//inserting of data into rows
		
		Select rows = new Select(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select")));
		rows.selectByValue("10");
	//	rows.getOptions();
//		String header = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[1]/div")).getText();
//		System.out.print("hello:" + header + "\n");
		//*[@id="app"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[7]
		for(int i=1;i<=7;i++) {
			String header = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[1]/div/div["+i+"]")).getText();
			System.out.print(  header+ "||");
			}
		System.out.println();
		for(int x=1;x<=10;x++) {		
		for(int i=1;i<=7;i++) {
		String row = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div["+x+"]/div/div["+i+"]")).getText();
		
		System.out.print(row + "||");
	
		if(i==6) {
		break;
		}
		}
		
//		WebElement action = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[7]/div"));
//		if(action.isDisplayed()) {
//				System.out.print(" ✏️ 🗑️");}
		System.out.println();
		}
		}


@Ignore
@Test
public void testButtons() throws Exception{
	driver.get("https://demoqa.com/buttons");
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	WebElement doubleclk = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("doubleClickBtn")));
	action.doubleClick(doubleclk).build().perform();
	 
	
	WebElement dMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("doubleClickMessage")));
	
	System.out.println("Double msg: "+ dMsg.getText());
	WebElement rightclk = driver.findElement(By.xpath("//*[@id=\"rightClickBtn\"]"));
	action.contextClick(rightclk).build().perform();
	
	WebElement rMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rightClickMessage")));
	System.out.println("Rightclick msg: "+ rMsg.getText());
	WebElement click = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/button")));
	action.click(click).build().perform();
	WebElement cMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dynamicClickMessage")));
  	System.out.println("Double msg: "+ cMsg.getText());
}

@Ignore
@Test
public void testLinks() throws Exception {
	driver.get("https://demoqa.com/links");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	WebElement homeLink = driver.findElement(By.partialLinkText("Ho"));
	homeLink.click();
	Thread.sleep(3);
	System.out.println(driver.getCurrentUrl());
	}
@Ignore
@Test
public void testUpload() throws Exception {
	driver.get("https://demoqa.com/upload-download");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	WebElement upload = driver.findElement(By.xpath("//*[@id=\"uploadFile\"]"));
	upload.sendKeys("C:\\Users\\shiva\\Downloads\\sampleFile.jpeg");
	WebElement file = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"uploadedFilePath\"]")));
	System.out.println(file.getText());
	}
@Ignore
@Test 
public void testDynamic() throws Exception {
	driver.get("https://demoqa.com/dynamic-properties");  // dynamic text visibility
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"visibleAfter\"]")));
	System.out.println(text.getText());
	}

@Ignore
@Test 
public void testDynmic() throws Exception {
	driver.get("https://demoqa.com/modal-dialogs");
	((JavascriptExecutor)driver).executeScript("window.scroll(0,200)");
	WebElement smallmodal = driver.findElement(By.xpath("//*[@id=\"showSmallModal\"]"));
	smallmodal.click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	WebElement smalltext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"modal-body\"]")));
	System.out.println(smalltext.getText());
	WebElement smallclose = driver.findElement(By.xpath("//*[@id=\"closeSmallModal\"]"));
	smallclose.click();
	
	WebElement largemodal = driver.findElement(By.xpath("//*[@id=\"showLargeModal\"]"));
	largemodal.click();
	WebElement largetext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"modal-body\"]")));
	System.out.println(largetext.getText());
	WebElement largeclose = driver.findElement(By.xpath("//span[@aria-hidden='true' and text()=\"×\"]"));
	largeclose.click();
	
}

}
