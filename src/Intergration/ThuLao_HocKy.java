package Intergration;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThuLao_HocKy {
	static WebDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\letan\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
 
	}
	@Test (priority = 0)
	public void taonganh () throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click(); // Chọn tab học kỳ
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\HocKy_Nganh_CapBac.xlsx");
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
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[1]")).click();
	    try {
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[1]")).click();
			System.out.println("Hủy Thất bại");
		} catch (Exception e) {
			System.out.println("Hủy Thành Công");
		}
	    
	    System.out.println("Đang kiểm tra xem có tìm được học kỳ "+hockyString+" ở GD Thù Lao GV không ??");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span")).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
	    Thread.sleep(2000);
	    WebElement kqtravElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[2]/ul/li"));
	    String ketquathucteString = kqtravElement.getText();
	    
	    System.out.println("Kết quả mong đợi: Không tìm thấy kết quả");
	    System.out.println("Kết quả thực tế: "+ ketquathucteString);
	    
	}
	
	@Test (priority = 1)
	public void taonganhok () throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click(); // Chọn tab học kỳ
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\HocKy_Nganh_CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(1);
	    
	    String hockyString = row.getCell(0).getStringCellValue();
		System.out.println("Đang tiến hành tạo học kỳ "+hockyString+ " _ Người dùng lưu:");
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

	    
	    System.out.println("Đang kiểm tra xem có tìm được học kỳ "+hockyString+" ở GD CBGV không ?");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
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
	
	@Test (priority = 2)
	public void suanganhwr () throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click(); // Chọn tab học kỳ
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\HocKy_Nganh_CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(1);
	    
	    
	    
	    String hockyString = row.getCell(0).getStringCellValue();
	    
	    // Tìm học kỳ
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(hockyString);
		System.out.println("Đang tiến hành sử học kỳ "+hockyString+ " _ Người dùng không lưu:");
		Thread.sleep(2000);
		
		//Người dùng chọn nút sửa học kỳ
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[9]/a[1]")).click();
	
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/input[2]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[24]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[1]")).click();

	    
	    System.out.println("Đang kiểm tra xem có tìm được học kỳ "+hockyString+" ở GD CBGV không ?");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
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
	
	
	@Test (priority = 3)
	public void suanganhok () throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click(); // Chọn tab học kỳ
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\HocKy_Nganh_CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(1);
	    
	    
	    
	    String hockyString = row.getCell(0).getStringCellValue();
	    
	    // Tìm học kỳ
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(hockyString);
		System.out.println("Đang tiến hành sử học kỳ "+hockyString+ " _ Người dùng chọn lưu:");
		Thread.sleep(2000);
		
		//Người dùng chọn nút sửa học kỳ
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[9]/a[1]")).click();
	
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/input[2]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[24]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]")).click();

	    
	    System.out.println("Đang kiểm tra xem có tìm được học kỳ "+hockyString+" ở GD CBGV không ?");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
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
	
	
	@Test (priority = 4)
	public void xoanganhwr () throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click(); // Chọn tab học kỳ
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\HocKy_Nganh_CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(1);
	    
	    
	    
	    String hockyString = row.getCell(0).getStringCellValue();
	    
	    // Tìm học kỳ
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(hockyString);
		System.out.println("Đang tiến hành xóa học kỳ "+hockyString+ " _ Người dùng chọn hủy:");
		Thread.sleep(2000);
		
		//Người dùng chọn nút xóa học kỳ
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[9]/a[2]")).click();
	
	   
	    driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")).click();

	    
	    System.out.println("Đang kiểm tra xem có tìm được học kỳ "+hockyString+" ở GD CBGV không ?");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
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
	
	@Test (priority = 5)
	public void xoanganhok () throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click(); // Chọn tab học kỳ
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\HocKy_Nganh_CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(1);
	    
	    
	    
	    String hockyString = row.getCell(0).getStringCellValue();
	    
	    // Tìm học kỳ
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(hockyString);
		System.out.println("Đang tiến hành xóa học kỳ "+hockyString+ " _ Người dùng chọn Xóa:");
		Thread.sleep(2000);
		
		//Người dùng chọn nút xóa học kỳ
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[9]/a[2]")).click();
	
	   Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();

	    
	    System.out.println("Đang kiểm tra xem có tìm được học kỳ "+hockyString+" ở GD CBGV không ?");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span")).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
	    Thread.sleep(2000);
	    WebElement kqtravElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[2]/ul/li"));
	    String ketquathucteString = kqtravElement.getText();
	    
	    System.out.println("Kết quả mong đợi: Không tìm thấy kết quả");
	    System.out.println("Kết quả thực tế: "+ ketquathucteString); 
	}
}
