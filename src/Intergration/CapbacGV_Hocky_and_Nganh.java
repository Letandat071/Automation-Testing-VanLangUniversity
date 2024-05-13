package Intergration;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CapbacGV_Hocky_and_Nganh {

	static WebDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\letan\\AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
 
	}
	
//	@Test
//	public void taonganh () throws InterruptedException, IOException {
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click(); // Chọn tab học kỳ
//		Thread.sleep(2000);
//		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\HocKy_Nganh_CapBac.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(1);
//	    
//	    String hockyString = row.getCell(0).getStringCellValue();
//		System.out.println("Đang tiến hành tạo học kỳ "+hockyString+ " _ Người dùng bấm hủy:");
//		Thread.sleep(2000);
//		//Người dùng chọn nút thêm học kỳ
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
//		
//		
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys(hockyString);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/input[2]")).click();
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[10]")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[1]")).click();
//	    try {
//			driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[1]")).click();
//			System.out.println("Hủy Thất bại");
//		} catch (Exception e) {
//			System.out.println("Hủy Thành Công");
//		}
//	    
//	    System.out.println("Đang kiểm tra xem có tìm được học kỳ "+hockyString+" ở GD CBGV không ??");
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[4]/a")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span")).click();
//	    Thread.sleep(500);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
//	    Thread.sleep(2000);
//	    WebElement kqtravElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[2]/ul/li"));
//	    String ketquathucteString = kqtravElement.getText();
//	    
//	    System.out.println("Kết quả mong đợi: Không tìm thấy kết quả");
//	    System.out.println("Kết quả thực tế: "+ ketquathucteString);
//	    
//	}
	
	@Test
	public void taonganhok () throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click(); // Chọn tab học kỳ
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\HocKy_Nganh_CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(1);
	    
	    String hockyString = row.getCell(0).getStringCellValue();
		System.out.println("Đang tiến hành tạo học kỳ "+hockyString+ " _ Người dùng bấm hủy:");
		Thread.sleep(2000);
		//Người dùng chọn nút thêm học kỳ
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
		
		
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys(hockyString);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/input[2]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[10]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]")).click();
	   Thread.sleep(400);
	   WebElement noticElement = driver.findElement(By.xpath("/html/body/div[3]/div"));
	   String thongbaoString = noticElement.getText();
	   String mongdoi = "Lưu thành công!";
	   
		   if (thongbaoString.contains(mongdoi)) {
			System.out.println("Đã lưu thành công");
		} else {
			System.out.println("Lưu thất bại");
			
		}
	    
	    System.out.println("Đang kiểm tra xem có tìm được học kỳ "+hockyString+" ở GD CBGV không ??");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[4]/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span")).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
	    Thread.sleep(2000);
	    WebElement kqtravElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[2]/ul/li"));
	    String ketquathucteString = kqtravElement.getText();
	    
	    System.out.println("Kết quả mong đợi: "+ hockyString);
	    System.out.println("Kết quả thực tế: "+ ketquathucteString);
	    
	}
}