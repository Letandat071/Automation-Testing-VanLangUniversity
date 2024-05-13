package MonHoc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.apache.commons.codec.language.Nysiis;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MonHocALL {
	public WebDriver driver;
	Random random = new Random();
	@BeforeTest
	public void setup() throws InterruptedException {
		String profileString = "C:\\Users\\Phan_Hoang_Khang\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + profileString);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[3]/a")).click();
	}
	
	@Test (priority = 0)
	public void MonHoc14() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test case 14:Xem môn học theo - Học kỳ - Đơn ");	
		  FileInputStream fis = new FileInputStream("D:\\TestLibery\\MonHoc.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  XSSFRow row = sheet.getRow(2);		
		  String hockyString = row.getCell(0).getStringCellValue();
		  String nganhString = row.getCell(1).getStringCellValue();		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();		  	  
		  try {
			  Thread.sleep(2000);
				WebElement thongbao = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]/div/label"));
				if (thongbao.getText().contains("Hiển thị")) {
					System.out.println("Xem Thành Công!!");
				} else {
					System.out.println("Xem thất bại");
				}
			}catch (Exception e) {
				System.out.println("Xem thất bại");
			}
		  driver.navigate().refresh();
	}
	
	@Test (priority = 1)
	public void MonHoc15() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test case 15 :Xem môn học theo - Học kỳ - Đơn - Số Liệu");		
		  FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\MonHoc.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  XSSFRow row = sheet.getRow(2);		
		  String hockyString = row.getCell(0).getStringCellValue();
		  String nganhString = row.getCell(1).getStringCellValue();		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
		  Thread.sleep(2000);
		  WebElement optionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]/div/label/select"));
		  optionElement.click();
		  Thread.sleep(2000);
		  int option = random.nextInt(1,4);
		  WebElement optnumberElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]/div/label/select/option["+option+"]"));
		  optnumberElement.click();		  
		  Thread.sleep(2000);
		  optionElement.click();		
		  Thread.sleep(2000);
		  System.out.println("Đã hiển thị thành công: " + optnumberElement.getText() +" Dữ liệu!!");  
		  driver.navigate().refresh();
	}
	
	@Test (priority = 2)
	public void MonHoc16() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test case 16 :Xem môn học theo - Học kỳ - Đơn -> Tìm kiếm -> Mã môn học");		
		  FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\MonHoc.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  XSSFRow row = sheet.getRow(2);		
		  String hockyString = row.getCell(0).getStringCellValue();
		  String nganhString = row.getCell(1).getStringCellValue();		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
		  Thread.sleep(2000);		  
		  XSSFSheet sheet2 = workbook.getSheetAt(1);
		  for(int i = 1; i < sheet2.getPhysicalNumberOfRows(); i++ ) {
			  XSSFRow row2 = sheet2.getRow(i);			  
			  String mamonhocString = row2.getCell(0).getStringCellValue();
			  String tenMonhocString = row2.getCell(1).getStringCellValue();
			  String ngonNguString = row2.getCell(2).getStringCellValue();			  
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).clear();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).sendKeys(mamonhocString);
			  Thread.sleep(2000);
			  WebElement mamonhoctt = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2]"));
			  System.out.println("Kết quả mong đợi: " + mamonhocString);
			  System.out.println("Kết quả thực tế: " + mamonhoctt.getText());			  
		  } 
		  driver.navigate().refresh();
	}
	
	@Test (priority = 3)
	public void MonHoc17() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test case 17 :Xem môn học theo - Học kỳ - Đơn -> Tìm kiếm -> Tên môn học");	
		  FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\MonHoc.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  XSSFRow row = sheet.getRow(2);	
		  String hockyString = row.getCell(0).getStringCellValue();
		  String nganhString = row.getCell(1).getStringCellValue();		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();	  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
		  Thread.sleep(2000);		  
		  XSSFSheet sheet2 = workbook.getSheetAt(1);
		  for(int i = 1; i < sheet2.getPhysicalNumberOfRows(); i++ ) {
			  XSSFRow row2 = sheet2.getRow(i);			  
			  String tenMonhocString = row2.getCell(1).getStringCellValue();			 			  
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).clear();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).sendKeys(tenMonhocString);
			  Thread.sleep(2000);
			  WebElement nganhhoctt = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]"));
			  System.out.println("Kết quả mong đợi: " + tenMonhocString);
			  System.out.println("Kết quả thực tế: " + nganhhoctt.getText());			  
		  } 
		  driver.navigate().refresh();
	}	
	
	@Test (priority = 4)
	public void MonHoc18() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test case 18 :Xem môn học theo - Học kỳ - Đơn -> Tìm kiếm -> Ngôn ngữ môn học");		
		  FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\MonHoc.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  XSSFRow row = sheet.getRow(2);		
		  String hockyString = row.getCell(0).getStringCellValue();
		  String nganhString = row.getCell(1).getStringCellValue();		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
		  Thread.sleep(2000);		  
		  XSSFSheet sheet2 = workbook.getSheetAt(1);
		  for(int i = 1; i < sheet2.getPhysicalNumberOfRows(); i++ ) {
			  XSSFRow row2 = sheet2.getRow(i);			  
			  String ngonNguString = row2.getCell(2).getStringCellValue();	  			  
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).clear();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).sendKeys(ngonNguString);
			  Thread.sleep(2000);
			  WebElement nntt = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[5]"));
			  System.out.println("Kết quả mong đợi: " + ngonNguString);
			  System.out.println("Kết quả thực tế: " + nntt.getText());
		  } 
		  driver.navigate().refresh();
	}
	
	@Test (priority = 5)
	public void MonHoc19() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test case 19 :Sắp xếp theo Mã môn học Tăng dần");
		Thread.sleep(2000);
		WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[2]"));
		Thread.sleep(2000);
		mamonhocElement.click();
		String trangtahString = mamonhocElement.getAttribute("aria-label");
		String dowString = "Sắp xếp thứ tự giảm dần";
		String upString = "Sắp xếp thứ tự tăng dần";
		if (trangtahString.contains(upString)) {
			System.out.println("Sắp xếp mã môn học tăng dần! Thành công!!");
		} else  {
			System.out.println("Sắp xếp mã môn học tăng dần! Thất bại!!");
		}
		driver.navigate().refresh();
	}
	
	@Test (priority = 6)
	public void MonHoc20() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test case 20 :Sắp xếp theo Mã môn học Giảm dần");
		Thread.sleep(2000);
		WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[2]"));
		Thread.sleep(2000);
		mamonhocElement.click();
		String trangtahString = mamonhocElement.getAttribute("aria-label");
		String dowString = "Sắp xếp thứ tự giảm dần";
		if (trangtahString.contains(dowString)) {
			System.out.println("Sắp xếp mã môn học Giảm dần! Thành công!!");
		} else  {
			System.out.println("Sắp xếp mã môn học Giảm dần! Thất bại!!");
		}
		driver.navigate().refresh();
	}
	
	@Test (priority = 7)
	public void MonHoc21() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test case 21 :Sắp xếp theo Tên môn học Giảm dần");
		Thread.sleep(2000);
		WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[3]"));
		Thread.sleep(2000);
		mamonhocElement.click();
		String trangtahString = mamonhocElement.getAttribute("aria-label");
		String dowString = "Sắp xếp thứ tự giảm dần";
		String upString = "Sắp xếp thứ tự tăng dần";
		if (trangtahString.contains(dowString)) {
			System.out.println("Sắp xếp mã môn học giảm dần! Thành công!!");
		} else  {
			System.out.println("Sắp xếp mã môn học giảm dần! Thất bại!!");
		}
		driver.navigate().refresh();
	}
	
	@Test (priority = 8)
	public void MonHoc22() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test case 22 :Sắp xếp theo Tên môn học Tăng dần");
		Thread.sleep(2000);
		WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[3]"));
		Thread.sleep(2000);
		mamonhocElement.click();
		String trangtahString = mamonhocElement.getAttribute("aria-label");
		String dowString = "Sắp xếp thứ tự tăng dần";
		if (trangtahString.contains(dowString)) {
			System.out.println("Sắp xếp tên môn học tăng dần! Thành công!!");
		} else  {
			System.out.println("Sắp xếp tên môn học tăng dần! Thất bại!!");
		}
		driver.navigate().refresh();
	}
	
	@Test (priority = 9)
	public void MonHoc23() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test case 23 :Sắp xếp theo ngôn ngữ môn học Giảm dần");
		Thread.sleep(2000);
		WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[5]"));
		Thread.sleep(2000);
		mamonhocElement.click();
		String trangtahString = mamonhocElement.getAttribute("aria-label");
		String dowString = "Sắp xếp thứ tự giảm dần";
		String upString = "Sắp xếp thứ tự tăng dần";
		if (trangtahString.contains(dowString)) {
			System.out.println("Sắp xếp ngôn ngữ môn học giảm dần! Thành công!!");
		} else  {
			System.out.println("Sắp xếp ngôn ngữ môn học giảm dần! Thất bại!!");
		}
		driver.navigate().refresh();
	}
	
	@Test (priority = 10)
	public void MonHoc24() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test case 24 :Sắp xếp theo ngôn ngữ môn học Tăng dần");
		Thread.sleep(2000);
		WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[5]"));
		Thread.sleep(2000);
		mamonhocElement.click();
		String trangtahString = mamonhocElement.getAttribute("aria-label");
		String dowString = "Sắp xếp thứ tự tăng dần";
		if (trangtahString.contains(dowString)) {
			System.out.println("Sắp xếp ngôn ngữ môn học tăng dần! Thành công!!");
		} else  {
			System.out.println("Sắp xếp ngôn ngữ môn học tăng dần! Thất bại!!");
		}
		driver.navigate().refresh();
	}
	
	@Test (priority = 11)
	public void MonHoc25() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test case 25 :Sắp xếp theo STC môn học Giảm dần");
		Thread.sleep(2000);
		WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[4]"));
		Thread.sleep(2000);
		mamonhocElement.click();
		String trangtahString = mamonhocElement.getAttribute("aria-label");
		String dowString = "Sắp xếp thứ tự giảm dần";
		String upString = "Sắp xếp thứ tự tăng dần";
		if (trangtahString.contains(dowString)) {
			System.out.println("Sắp xếp STC môn học giảm dần! Thành công!!");
		} else  {
			System.out.println("Sắp xếp STC môn học giảm dần! Thất bại!!");
		}
		driver.navigate().refresh();
	}
	
	@Test (priority = 12)
	public void MonHoc26() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test case 26 :Sắp xếp theo STC môn học Tăng dần");
		Thread.sleep(2000);
		WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[4]"));
		Thread.sleep(2000);
		mamonhocElement.click();
		String trangtahString = mamonhocElement.getAttribute("aria-label");
		String dowString = "Sắp xếp thứ tự tăng dần";
		if (trangtahString.contains(dowString)) {
			System.out.println("Sắp xếp STC môn học tăng dần! Thành công!!");
		} else  {
			System.out.println("Sắp xếp STC môn học tăng dần! Thất bại!!");
		}
		driver.navigate().refresh();
	}
}

