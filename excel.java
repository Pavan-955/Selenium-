package One.simple.Learn_Maven;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class excel {
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

	@Test
	public void test() throws Exception {
		driver.get("https://demoqa.com/automation-practice-form");
		FileInputStream filePath = new FileInputStream("src/main/resources/Pavan Excel.xlsx");
		try (XSSFWorkbook workbook = new XSSFWorkbook(filePath)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row r =sheet.getRow(0);
			Cell cell = r.getCell(0);
			System.out.println("xcel : " + cell.getStringCellValue());
		}
	}

}
