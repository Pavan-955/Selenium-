package One.simple.Learn_Maven;

import static org.junit.Assert.*;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.woden.wsdl20.extensions.rpc.Argument;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v136.page.model.FileHandler;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windgets {
WebDriver driver;
	@Before
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
@Ignore
	@Test
	public void test() {
		driver.get("https://demoqa.com/accordian");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		((JavascriptExecutor)driver).executeScript("window.scroll(0,200)");
		WebElement firstac = driver.findElement(By.xpath("//*[@id=\"section1Heading\"]"));
		firstac.click();
		WebElement firstbody = driver.findElement(By.xpath("//*[@id=\"section1Content\"]"));
		if(firstbody.isDisplayed()) {
			System.out.println("first body: " + firstbody.getText());	
		}else {
			firstac.click();
			System.out.println("first body: " + firstbody.getText());
		}
		//////////////////////////////////
		WebElement secondac = driver.findElement(By.xpath("//*[@id=\"section2Heading\"]"));
		secondac.click();
		WebElement secbody = driver.findElement(By.xpath("//*[@id=\"section2Content\"]"));
		if(secbody.isDisplayed()) {
			System.out.println("sec body: " + secbody.getText());	
		}else {
			firstac.click();
			System.out.println("sec body: " + secbody.getText());
		}
	}
	@Ignore
	@Test
	public void testmultiin() {
		driver.get("https://demoqa.com/auto-complete");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		((JavascriptExecutor)driver).executeScript("window.scroll(0,200)");
		WebElement mul = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"autoCompleteSingleContainer\"]/div/div[1]")));
		mul.sendKeys("Red");
		mul.sendKeys(Keys.ENTER);
//		mul.sendKeys("Blue");
//		mul.sendKeys(Keys.ENTER);
	}
	@Ignore
	@Test
	public void testSlidbar() {
		driver.get("https://demoqa.com/slider");
		//((JavascriptExecutor)driver).executeScript("window.scroll(0,200)");
		WebElement slidBar = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slidBar);
		System.out.println(slidBar.getSize().getWidth());
		Actions action = new Actions(driver);
		action.dragAndDropBy(slidBar,-30,0).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sliderValue\"]")));
		System.out.println("Slode text: "+ text.getAttribute("value"));
	}
	
	@Ignore
	@Test
	public void testProgressscreenshot() {
		driver.get("https://demoqa.com/progress-bar");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement progressbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progressBar\"]")));
		WebElement prostart = driver.findElement(By.xpath("//*[@id=\"startStopButton\"]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",progressbar);
		prostart.click();
		/////////////////////
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"progressBar\"]"), "100%"));  ///waiting the text in progressbar to be 100
		
		String percentage = progressbar.getText();
		if(percentage.equals("100%")){
		System.out.println("Total percentage is :" + percentage);
		}else {
			System.out.println(progressbar.getText());
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\shiva\\OneDrive\\Desktop\\Pavan Work Folder\\Screenshots Results\\screenshot1.jpeg");
		try {
			Files.copy(src, des);   //part of java and Supports advanced file operations like copying, deleting, moving, reading, writing, etc
			//org.openqa.selenium.io.FileHandler.copy(src, des);  //Simple and built-in for Selenium users ,Deprecated in modern Selenium versions,Not part of standard Java
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Ignore
	@Test
	public void testhover() {
		driver.get("https://demoqa.com/tool-tips");
		WebElement hoverme = driver.findElement(By.xpath("//*[@id=\"toolTipButton\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hoverme);
		Actions action = new Actions(driver);
		action.moveToElement(hoverme).build().perform();
		//WebElement hovertext = driver.findElement(By.cssSelector("aria-describedby"));
		System.out.println("text:" + hoverme.getAttribute("buttonToolTrip"));//unable to get hovered text
		
		WebElement hover2 = driver.findElement(By.xpath("//*[@id=\"toolTipTextField\"]"));
		action.moveToElement(hover2);
		
		WebElement hover3 = driver.findElement(By.xpath("//*[@id=\"texToolTopContainer\"]/a[1]"));
		action.moveToElement(hover3);
	}
		
@Ignore	
@Test
public void testdragndrop() throws InterruptedException {
	driver.get("https://demoqa.com/droppable");
	Actions action = new Actions(driver);
	((JavascriptExecutor) driver).executeScript("window.scroll(0,300)");
	WebElement src = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
	WebElement des = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
	action.dragAndDrop(src, des).build().perform();
	Thread.sleep(3);
	WebElement dropped = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
	System.out.println(dropped.getText());
	}

@Ignore
@Test
public void testsorting() {
	driver.get("https://demoqa.com/sortable");
	((JavascriptExecutor) driver).executeScript("window.scroll(0,450)");
	 WebElement itemOne = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div[1]"));
     WebElement itemfour = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div[4]"));
     Actions action = new Actions(driver);
     action.clickAndHold(itemOne).moveToElement(itemfour).release().build().perform();
}

@Test
public void testsortinggrid() {
	driver.get("https://demoqa.com/sortable");
	((JavascriptExecutor) driver).executeScript("window.scroll(0,250)");
	WebElement grid = driver.findElement(By.xpath("//*[@id=\"demo-tab-grid\"]"));
	grid.click();
	 WebElement itemOne = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[1]"));
     WebElement itemfive = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[5]"));
     Actions action = new Actions(driver);
     action.clickAndHold(itemOne).moveToElement(itemfive).release().build().perform();
}


}
