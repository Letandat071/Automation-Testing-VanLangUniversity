package PhanCong;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.apache.poi.hslf.record.Sound;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;import com.github.dockerjava.api.model.Driver;
import com.google.errorprone.annotations.ThreadSafe;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhanCong {
	static WebDriver driver;
	public Random random = new Random();
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
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]/ul/li[2]/a")).click();

		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Phancong.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 String nganhString = row.getCell(1).getStringCellValue();
		 
		 
		 //Setup học kỳ và ngành
		 
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
		 Thread.sleep(500);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hocky);
		 Thread.sleep(500);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();
		 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span")).click();
		 Thread.sleep(500);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
		 Thread.sleep(500);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
	}
	
	
//	@Test (priority = 0)
//	public void XoaPhanCong() throws InterruptedException {
//		System.out.println("Test Case 1: Xóa phân công tiết đã được phân");
//		for(int i =2; i<=36; i++) {
//			Thread.sleep(5000);
//			WebElement cellElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td["+i+"]"));
//			if(!cellElement.getText().equals("Chưa phân")) {
//				try {
//					Thread.sleep(4000);
//					driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[\"+i+\"]/div[1]/button")).click();
//					Thread.sleep(800);
//					driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/span/span[1]/span/span[1]/span")).click();
//					driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/button[1]")).click();
//					Thread.sleep(800);
//					try {
//						WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[4]/div/div"));
//						String thongbaothucte = thongbaoElement.getText();
//						if (thongbaothucte.equals("Thành công!")) {
//							System.out.println("Kết quả mong đợi: Thành Công");
//							System.out.println("Kết quả thực tế: " + thongbaothucte);
//						}
//						break;
//					} catch (Exception e) {
//						System.out.println("Lỗi không thể xóa phân công");
//						break;
//					}
//					
//					
//				} catch (Exception e) {
//					System.out.println("Lỗi không thể chọn ô");
//					break;
//				}
////			}
//	else {
//		continue;
//	}
//		}
//	}
	
	
//	@Test (priority = 1)
//	public void SuaPhanCong() throws InterruptedException {
//		Random random = new Random();
//		System.out.println("Test Case 2: Sửa phân công tiết đã được phân GV Random");
//		for(int i =2; i<=36; i++) {
//			Thread.sleep(5000);
//			WebElement cellElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td["+i+"]"));
//			if(!cellElement.getText().equals("Chưa phân")) {
//				try {
//					for (int j = 1; j<= 4; j++) {
//						Thread.sleep(5000);
//						WebElement subcellElement= driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td["+i+"]/div["+j+"]"));
//						if (!subcellElement.getText().equals("Chưa phân")) {
//							subcellElement.click();
//							System.out.println("Yeah");
//							Thread.sleep(15000);
//							driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/span/span[1]/span/span[1]")).click();
//							int giangvienduocchon = random.nextInt(1,300);
//							Thread.sleep(5000);
//							WebElement giangvienElement= driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/span[2]/span/span[2]/ul/li["+giangvienduocchon+"]"));
//							String giantgvienphancongString = giangvienElement.getText();	
//								try {
//									Thread.sleep(5000);
//									driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/button[1]")).click();
//									Thread.sleep(1000);
//									WebElement thongbaoloiElement = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]"));
//									System.out.println("Không thể phân công " + thongbaoloiElement.getText());
//									Thread.sleep(5000);
//									break;
//								} catch (Exception e) {
//									driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/button[1]")).click();
//									Thread.sleep(1000);
//									WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[4]/div/div"));
//									String thongbaothucte = thongbaoElement.getText();
//									
//									System.out.println("Kết quả mong đợi: Phân công Thành Công");
//									System.out.println("Kết quả thực tế: Phâng công "+giantgvienphancongString  + thongbaothucte);
//									break;
//								}	
//						}
//					}
//				} catch (Exception e) {
//					System.out.println("Không thể chọn tiết này");
//				}
//			}
//		}
//	}
	
	
//	@Test (priority = 2)
//	public void SuaPhanCong() throws InterruptedException {
//		Random random = new Random();
//		System.out.println("Test Case 3: Sửa phân công tiết đã được phân GV (GV bị trùng lớp / Tiết");
//		for(int i =2; i<=36; i++) {
//			Thread.sleep(5000);
//			WebElement cellElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td["+i+"]"));
//			if(!cellElement.getText().equals("Chưa phân")) {	
//					for (int j = 1; j<= 4; j++) {
//						Thread.sleep(5000);
//						WebElement subcellElement= driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td["+i+"]/div["+j+"]"));
//						if (!subcellElement.getText().equals("Chưa phân")) {
//							subcellElement.click();
//							System.out.println("Yeah");
//							Thread.sleep(20000);
//							driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/span/span[1]/span/span[1]")).click();
//							int giangvienduocchon = random.nextInt(1,300);
//							Thread.sleep(5000);
//							WebElement giangvienElement= driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/span[2]/span/span[2]/ul/li["+giangvienduocchon+"]"));
//							String giantgvienphancongString = giangvienElement.getText();	
//								
//							Thread.sleep(5000);
//							driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/button[1]")).click();
//							Thread.sleep(1000);
//							WebElement thongbaoloiElement = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]"));
//							System.out.println("Không thể phân công " + thongbaoloiElement.getText());	
//							driver.close();		
//						}
//					}
//			}
//		}
//	}
	
	
}
