package One.simple.Learn_Maven;

import static org.junit.Assert.*;

import java.awt.Desktop.Action;
import java.lang.System.Logger;
import java.sql.Driver;
import java.time.Duration;
import java.util.Set;

import org.apache.woden.wsdl20.extensions.rpc.Argument;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Loggers;

public class windowsHandle {
WebDriver driver;
private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(windowsHandle.class);

	@Before
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3);
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https://demoqa.com/browser-windows");
		String parentwindow = driver.getWindowHandle();
		
		System.out.println("parent window URL: " + driver.getCurrentUrl());
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		WebElement childwindow = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tabButton\"]")));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
		Actions action = new Actions(driver);
		//action.scrollToElement(childwindow).perform();
		childwindow.click();
		Set<String> allwindows = driver.getWindowHandles();
		for(String window: allwindows) {
			if(!window.equals(parentwindow)) {
				driver.switchTo().window(window);
				break;
			}
			
		}
		System.out.println(driver.getCurrentUrl());
		WebElement text = driver.findElement(By.xpath("/html/body"));
		System.out.println(text.getText());
		logger.info(" using logger of log4j");
		driver.switchTo().window(parentwindow);
		Thread.sleep(5);
		System.out.println(driver.getCurrentUrl());
	}
	@Ignore
	@Test 
	public void testAlerts() throws Exception {
		driver.get("https://demoqa.com/alerts");
		WebElement simpleOk = driver.findElement(By.xpath("//*[@id=\"alertButton\"]"));
		((JavascriptExecutor)driver).executeScript("window.scroll(0,200)");
		simpleOk.click();
		Thread.sleep(3);
		String al = driver.switchTo().alert().getText();
		System.out.println("Text of Alert :"+ al);
		Thread.sleep(3);
		driver.switchTo().alert().accept();
		Thread.sleep(3);
		WebElement fivsec = driver.findElement(By.xpath("//*[@id=\"timerAlertButton\"]"));
		fivsec.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		String al2 = driver.switchTo().alert().getText();
		System.out.println("Text of Alert2 :"+ al2);
		Thread.sleep(3);
		driver.switchTo().alert().accept();
		WebElement cancel = driver.findElement(By.xpath("//*[@id=\"confirmButton\"]"));
		((JavascriptExecutor)driver).executeScript("window.scroll(0,300)");
		cancel.click();
		
		String al3 = driver.switchTo().alert().getText();
		System.out.println("Text of Alert3 :"+ al3);
		driver.switchTo().alert().dismiss();
		WebElement cltext = driver.findElement(By.xpath("//*[@id=\"confirmResult\"]"));
		
		System.out.println(cltext.getText());
		cancel.click();
		driver.switchTo().alert().accept();
		System.out.println(cltext.getText());
		//////
		WebElement sendkey = driver.findElement(By.xpath("//*[@id=\"promtButton\"]"));
		((JavascriptExecutor)driver).executeScript("window.scroll(0,400)");
		sendkey.click();
		
		String al4 = driver.switchTo().alert().getText();
		System.out.println("Text of Alert4 :"+ al4);
		driver.switchTo().alert().sendKeys("dont mess with me");
		driver.switchTo().alert().accept();
		WebElement sktext = driver.findElement(By.xpath("//*[@id=\"promptResult\"]"));
		
		System.out.println(sktext.getText());
	}

}
