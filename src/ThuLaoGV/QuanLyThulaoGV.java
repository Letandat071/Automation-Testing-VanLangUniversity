package ThulaoGV;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuanLyThulaoGV {
	static WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\letan\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
	}
	
//	@Test (priority = 0)
//	public void xemthulaotheohocky() throws InterruptedException, IOException, AWTException {
//		Thread.sleep(2000);
//		System.out.println("Test Case 1: Xem thù lao theo danh sách học kỳ");
//		FileInputStream fis = new FileInputStream("E:\\TestData\\ThuLaoGV.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		
//        for(int i = 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
//        	Row row = sheet.getRow(i);
//        	String hockyString = row.getCell(0).getStringCellValue();
//        	Thread.sleep(2000);
//        	driver.findElement(By.id("select2-term-container")).click();
//        	Thread.sleep(2000);
//        	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
//        	Robot robot = new Robot();
//        	robot.keyPress(KeyEvent.VK_ENTER);
//        	robot.keyRelease(KeyEvent.VK_ENTER);
//        	Thread.sleep(1000);
//        	
//        	try {
//        		Thread.sleep(1000);
//				WebElement blankterm = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/h4"));
//				String notice = "Chưa có dữ liệu hệ số cho năm học này";
//				if (blankterm.getText().contains(notice)) {
//					System.out.println("Học kỳ "+ hockyString +" không có dữ liệu để xem");
//				}	
//			} catch (Exception e) {
//				Thread.sleep(1000);
//				WebElement hockyxemduoc= driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/label"));
//				String thongbaoString ="Hiển thị"
//						+ "";
//				if(hockyxemduoc.getText().contains(thongbaoString)) {
//					System.out.println("Đã xem Thù lao giảng viên tại học kỳ: "+ hockyString);
//				} 
//			}
//        	driver.navigate().refresh();
//        }	
//	}
	
	
//	@Test (priority = 1)
//	public void hienthidulieu() throws InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("Test Case 2: Hiển thị thù lao theo số dữ liệu");
//		
//		Random random= new Random();
//		int solieu = random.nextInt(4)+1;
//		
//		WebElement sodulieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/label/select/option["+solieu+"] "));
//		Thread.sleep(1000);
//		sodulieu.click();
//		
//		Thread.sleep(7000);
//		WebElement check=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div"));
//		if (check.getText().contains(sodulieu.getText())) {
//			System.out.println("Kết quả mong đợi: " + " Hiển thị 1 tới "  +sodulieu.getText()+" của \"***\" dữ liệu");
//			System.out.println("Kết quả Thực Tết: " + check.getText());
//			}
//	}
	
//	@Test
//	public void timkemGV() throws InterruptedException, IOException {
//		Thread.sleep(2000);
//		System.out.println("Test Case 3: Tìm kiếm giảng viên theo file dữ liệu");
//		
//		
//		 FileInputStream fis = new FileInputStream("E:\\TestData\\ThuLaoGV.xlsx");
//		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		 XSSFSheet sheet = workbook.getSheetAt(1);
//		 for(int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
//			 Row row = sheet.getRow(i);
//			 String magv = row.getCell(0).getStringCellValue();
//			 String tengvString = row.getCell(1).getStringCellValue();
//			 Thread.sleep(2000);
//			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(magv);
//			 Thread.sleep(1000);
//			 WebElement ketquama= driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr/td[2]"));
//			 System.out.println("Kết quả mong đợi: " + magv);
//			 System.out.println("Kết quả thực tế: " + ketquama.getText());
//			 
//			 driver.navigate().refresh();
//			 
//			 Thread.sleep(2000);
//			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(tengvString);
//			 Thread.sleep(1000);
//			 WebElement ketquaten= driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr/td[3]"));
//			 System.out.println("Kết quả mong đợi: " + tengvString);
//			 System.out.println("Kết quả thực tế: " + ketquaten.getText());
//			 
//			 driver.navigate().refresh();
//		 }
//	}
//	
	
//	@Test
//	public void exportdataprint() throws InterruptedException, AWTException {
//		Thread.sleep(2000);
//		System.out.println("Test Case 4: In dữ liệu bằng print");
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]")).click();
//		Thread.sleep(2000);
//		
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_C);
//		Thread.sleep(2000);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_C);
//		Thread.sleep(2000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//		try {    
//            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); 
//            String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);    
//            System.out.println("File đã được print: " + duLieu);
//        } catch (UnsupportedFlavorException | IOException e) {
//           System.out.println("Print file thất bại");
//        }
//		
//	}
	
}
