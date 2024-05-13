import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GianVienThinhGiang {
	static WebDriver driver;
	@BeforeTest 
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String profileString = "C:\\Users\\Phan_Hoang_Khang\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + profileString);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[3]/a/span")).click();
	}
//	@Test
//	public void GVTG() throws InterruptedException {
//		System.out.println("Testcase1: Chọn 1 học kỳ in ra bản dữ liệu");
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span/ul/li/input")).click();
//	    Thread.sleep(1500);
//	    
//	    WebElement hockyElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span/ul/li[1]"));
//		String tenhkString = hockyElement.getText();
//		hockyElement.click();
//		if (hockyElement.getAttribute("aria-selected").equals("true")) {
//			System.out.println("Học kỳ mong đợi: 999");
//			System.out.println("Học kỳ thực tế: " + tenhkString);
//		}
//		
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[1]/span[1]/span/ul")).click();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/button")).click();
//	    Thread.sleep(1500);
//	}
	@Test (priority = 2) 

	public void GVTG1() throws InterruptedException { 

	System.out.println("Testcase2: Chọn số dữ liệu hiển thị"); 

	Thread.sleep(1500); 

	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span/ul")).click(); 

	Thread.sleep(1500); 

	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/div/button[1]")).click(); 

	Thread.sleep(1500); 

	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/button")).click(); 

	Thread.sleep(1500); 
//
//	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/label/select")).click(); 
//
//	Thread.sleep(1500); 
//
//	WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select")); 
//
//	Select select2 = new Select(dropdown2); 
//
//	select2.selectByValue("25"); 
//
//	Thread.sleep(8000); 
//
//	String ketquatimkiemString = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[3]/div/div/div/table/thead/tr/th[5]")).getText(); 
//
//	String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[3]/div/div/div/table")).getText(); 
//
//	System.out.println("Kết quả tìm kiếm xem học kỳ là: " + ketquatimkiemString); 
//
//	System.out.println("Kết quả hiển thị theo số liệu tìm kiếm là: " + ketquahienthiString); 

	} 
}
