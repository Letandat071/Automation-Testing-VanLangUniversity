package Thongke;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import javax.sound.midi.Soundbank;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xemnamhoc_CoHuu {
	public WebDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\letan\\AppData\\Local\\Google\\Chrome\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir="+chromeProfilePath);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.id("OpenIdConnect")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[1]/a")).click();
	}
	
//	@Test (priority = 22)
//	public void xemnamhoccohuubieudo() throws IOException, InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("Test case 23: Xem theo năm học - Cơ hữu - biểu đồ ");
//		// Nhập dữ liệu từ file
//		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\So_Gio_GV.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(2);
//	    String thongketheoString = row.getCell(0).getStringCellValue();
//	    String namhocString = row.getCell(1).getStringCellValue();
//	    String nganhString = row.getCell(2).getStringCellValue();
//	    String loaiGvString = row.getCell(3).getStringCellValue();
//		//Chọn Thống kê theo: học kỳ
//		// Click box 
//	    WebElement boxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span"));
//	    boxElement.click();
//	    Thread.sleep(1000);
//	    // input search 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(thongketheoString);
//	    // click kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//		Thread.sleep(2000);
//	    
//	    //Chọn năm học
//	    WebElement namhocboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span"));
//	    namhocboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(namhocString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn ngành
//	    WebElement nganhboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span"));
//	    nganhboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn loại GV
//	    WebElement loaiGVboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span/span[1]/span"));
//	    loaiGVboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input")).sendKeys(loaiGvString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	    //Loại view
//	    WebElement viewBoxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[1]/a"));
//	    
//	    
//	    System.out.println("Kết quả mong đợi: " + thongketheoString + " - " + namhocString+" - " + nganhString + " - " + loaiGvString + " - Biểu đồ");
//	    System.out.println("Kết quả thực tế: " + boxElement.getText() + " - " + namhocboxElement.getText() + " - " + nganhboxElement.getText() +" - "+ loaiGVboxElement.getText()+" - "+viewBoxElement.getText());
//	    
//	    driver.navigate().refresh();
//	}
	
	
//	@Test (priority = 23)
//	public void xemnamhoccohuubangbieu() throws IOException, InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("Test case 24: Xem theo năm học - cơ hữu - bảng biểu ");
//		// Nhập dữ liệu từ file
//		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\So_Gio_GV.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(2);
//	    String thongketheoString = row.getCell(0).getStringCellValue();
//	    String namhocString = row.getCell(1).getStringCellValue();
//	    String nganhString = row.getCell(2).getStringCellValue();
//	    String loaiGvString = row.getCell(3).getStringCellValue();
//		//Chọn Thống kê theo: học kỳ
//		// Click box 
//	    WebElement boxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span"));
//	    boxElement.click();
//	    Thread.sleep(1000);
//	    // input search 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(thongketheoString);
//	    // click kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//		Thread.sleep(2000);
//	    
//	    //Chọn năm học
//	    WebElement namhocboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span"));
//	    namhocboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(namhocString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn ngành
//	    WebElement nganhboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span"));
//	    nganhboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn loại GV
//	    WebElement loaiGVboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span/span[1]/span"));
//	    loaiGVboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input")).sendKeys(loaiGvString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	    //Loại view
//	    WebElement viewBoxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[2]/a"));
//	    viewBoxElement.click();
//	    Thread.sleep(2000);
//	    // Xác nhận đã vào giao diện bảng biểu
//	    WebElement confirmElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/b"));
//	    if(confirmElement.getText().contains("Hướng dẫn:")) {
//	    	System.out.println("Kết quả mong đợi: " + thongketheoString + " - " + namhocString+" - " + nganhString + " - " + loaiGvString + " - Bảng Biểu ");
//	 	    System.out.println("Kết quả thực tế: " + boxElement.getText() + " - " + namhocboxElement.getText() + " - " + nganhboxElement.getText() +" - "+ loaiGVboxElement.getText()+" - "+viewBoxElement.getText());
//	    } else {
//			System.out.println("Xem thất bại!!");
//		}
//	   
//	    driver.navigate().refresh();
//	}
	
//	@Test (priority = 24)
//	public void xemnamhoccohuuchitiet() throws IOException, InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("Test case 25: Xem theo năm học - cơ hữu - chi tiết");
//		// Nhập dữ liệu từ file
//		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\So_Gio_GV.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(2);
//	    String thongketheoString = row.getCell(0).getStringCellValue();
//	    String namhocString = row.getCell(1).getStringCellValue();
//	    String nganhString = row.getCell(2).getStringCellValue();
//	    String loaiGvString = row.getCell(3).getStringCellValue();
//		//Chọn Thống kê theo: học kỳ
//		// Click box 
//	    WebElement boxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span"));
//	    boxElement.click();
//	    Thread.sleep(1000);
//	    // input search 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(thongketheoString);
//	    // click kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//		Thread.sleep(2000);
//	    
//	    //Chọn năm học
//	    WebElement namhocboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span"));
//	    namhocboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(namhocString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn ngành
//	    WebElement nganhboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span"));
//	    nganhboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn loại GV
//	    WebElement loaiGVboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span/span[1]/span"));
//	    loaiGVboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input")).sendKeys(loaiGvString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	    //Loại view
//	    WebElement viewBoxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[3]/a"));
//	    viewBoxElement.click();
//	    Thread.sleep(2000);
//	    // Xác nhận đã vào giao diện bảng biểu
//	    WebElement confirmElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[1]/div/label"));
//	    if(confirmElement.getText().contains("Hiển thị")) {
//	    	System.out.println("Kết quả mong đợi: " + thongketheoString + " - " + namhocString+" - " + nganhString + " - " + loaiGvString + " - Chi tiết ");
//	 	    System.out.println("Kết quả thực tế: " + boxElement.getText() + " - " + namhocboxElement.getText() + " - " + nganhboxElement.getText() +" - "+ loaiGVboxElement.getText()+" - "+viewBoxElement.getText());
//	    } else {
//			System.out.println("Xem thất bại!!");
//		}
//	   	    driver.navigate().refresh();
//	}
	
	
//	@Test (priority = 25)
//	public void xemnamhoccohuubangbieusodulieu() throws IOException, InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("Test case 26: Xem theo năm học- cơ hữu - bảng biểu - so du lieu");
//		// Nhập dữ liệu từ file
//		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\So_Gio_GV.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(2);
//	    String thongketheoString = row.getCell(0).getStringCellValue();
//	    String namhocString = row.getCell(1).getStringCellValue();
//	    String nganhString = row.getCell(2).getStringCellValue();
//	    String loaiGvString = row.getCell(3).getStringCellValue();
//		//Chọn Thống kê theo: học kỳ
//		// Click box 
//	    WebElement boxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span"));
//	    boxElement.click();
//	    Thread.sleep(1000);
//	    // input search 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(thongketheoString);
//	    // click kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//		Thread.sleep(2000);
//	    
//	    //Chọn năm học
//	    WebElement namhocboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span"));
//	    namhocboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(namhocString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn ngành
//	    WebElement nganhboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span"));
//	    nganhboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn loại GV
//	    WebElement loaiGVboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span/span[1]/span"));
//	    loaiGVboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input")).sendKeys(loaiGvString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	    //Loại view
//	    WebElement viewBoxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[2]/a"));
//	    viewBoxElement.click();
//	    Thread.sleep(2000);
//	    
//	    //Số dữ liệu
//	    Random random = new Random();
//	    int option = random.nextInt(1,4);
//	    WebElement sodulieuboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/label/select"));
//	    sodulieuboxElement.click();
//	    Thread.sleep(500);
//	    WebElement soElemen = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/label/select/option["+option+"]"));
//	    soElemen.click();
//	    
//	    
//	    // Xác nhận đã vào giao diện bảng biểu
//	    WebElement confirmElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/b"));
//	    if(confirmElement.getText().contains("Hướng dẫn:")) {
//	    	System.out.println("Kết quả mong đợi: " + thongketheoString + " - " + namhocString+" - " + nganhString + " - " + loaiGvString + " - Bảng Biểu - " + soElemen.getText());
//	 	    System.out.println("Kết quả thực tế: " + boxElement.getText() + " - " + namhocboxElement.getText() + " - " + nganhboxElement.getText() +" - "+ loaiGVboxElement.getText()+" - "+viewBoxElement.getText()+" - " + soElemen.getText());
//	    } else {
//			System.out.println("Xem thất bại!!");
//		}
//	   
////	    driver.navigate().refresh();
//	}
	
//	@Test (priority = 26)
//	public void xemnamhoccohuubangbieusearch() throws IOException, InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("Test case 27: Xem theo năm học - cơ hữu - bảng biểu - Search ");
//		// Nhập dữ liệu từ file
//		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\So_Gio_GV.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(2);
//	    String thongketheoString = row.getCell(0).getStringCellValue();
//	    String namhocString = row.getCell(1).getStringCellValue();
//	    String nganhString = row.getCell(2).getStringCellValue();
//	    String loaiGvString = row.getCell(3).getStringCellValue();
//		//Chọn Thống kê theo: học kỳ
//		// Click box 
//	    WebElement boxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span"));
//	    boxElement.click();
//	    Thread.sleep(1000);
//	    // input search 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(thongketheoString);
//	    // click kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//		Thread.sleep(2000);
//	    
//	    //Chọn năm học
//	    WebElement namhocboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span"));
//	    namhocboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(namhocString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn ngành
//	    WebElement nganhboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span"));
//	    nganhboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn loại GV
//	    WebElement loaiGVboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span/span[1]/span"));
//	    loaiGVboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input")).sendKeys(loaiGvString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	    //Loại view
//	    WebElement viewBoxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[2]/a"));
//	    viewBoxElement.click();
//	    Thread.sleep(2000);
//	    
//	    //Search
//	    XSSFSheet sheet2 = workbook.getSheetAt(1);
//	    XSSFRow row2 = sheet2.getRow(4);
//	    String magvString = row2.getCell(1).getStringCellValue();
//	    String tenGvString = row2.getCell(2).getStringCellValue();
// 
//	    
//	    // Xác nhận đã vào giao diện bảng biểu
//	    WebElement confirmElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/b"));
//	    if(confirmElement.getText().contains("Hướng dẫn:")) {
//
//	    		Thread.sleep(1000);
//	    		//Nhập dữ liệu 
//	    		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
//	    		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(magvString);
//	    		
//	    		Thread.sleep(1000);
//	    		WebElement maketquaElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]"));
//	    		System.out.println("Kết quả mong đợi: " + magvString);
//	    		System.out.println("Kết quả thực tế: " + maketquaElement.getText());
//	    		
//	    		Thread.sleep(1000);
//
//	    		
//	    		Thread.sleep(1000);
//	    		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
//	    		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(tenGvString);
//	    		
//	    		Thread.sleep(1000);
//	    		WebElement tenketquaElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[4]"));
//	    		System.out.println("Kết quả mong đợi: " + tenGvString);
//	    		System.out.println("Kết quả thực tế: " + tenketquaElement.getText());
//
//	    } else {
//			System.out.println("Xem thất bại!!");
//		}
//	   
////	    driver.navigate().refresh();
//	}
	
	
	
//	@Test (priority = 27)
//	public void xemnamhoccohuubangbieusearch() throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
//		Thread.sleep(2000);
//		System.out.println("Test Case 28: Xem theo năm học - cơ hữu - bảng biểu - Export -> print");
//		// Nhập dữ liệu từ file
//		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\So_Gio_GV.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(2);
//	    String thongketheoString = row.getCell(0).getStringCellValue();
//	    String namhocString = row.getCell(1).getStringCellValue();
//	    String nganhString = row.getCell(2).getStringCellValue();
//	    String loaiGvString = row.getCell(3).getStringCellValue();
//		//Chọn Thống kê theo: học kỳ
//		// Click box 
//	    WebElement boxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span"));
//	    boxElement.click();
//	    Thread.sleep(1000);
//	    // input search 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(thongketheoString);
//	    // click kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//		Thread.sleep(2000);
//	    
//	    //Chọn năm học
//	    WebElement namhocboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span"));
//	    namhocboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(namhocString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn ngành
//	    WebElement nganhboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span"));
//	    nganhboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn loại GV
//	    WebElement loaiGVboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span/span[1]/span"));
//	    loaiGVboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input")).sendKeys(loaiGvString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	    //Loại view
//	    WebElement viewBoxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[2]/a"));
//	    viewBoxElement.click();
//	    Thread.sleep(2000);
//	    
//	    //Print
//	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/button"));
//	    printElement.click();
//	    Thread.sleep(1000);
//	    WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", printOptionElement);
//
//	    
//	    Robot robot = new Robot();
// 
//	    
//	    // Xác nhận đã vào giao diện bảng biểu
//	    WebElement confirmElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/b"));
//	    if(confirmElement.getText().contains("Hướng dẫn:")) {
//
//	    		Thread.sleep(2000);
//	    		robot.keyPress(KeyEvent.VK_ENTER);
//	    		robot.keyRelease(KeyEvent.VK_ENTER);
//	    		Thread.sleep(2000);
//	    		robot.keyPress(KeyEvent.VK_CONTROL);
//	    		robot.keyPress(KeyEvent.VK_C);
//	    		robot.keyRelease(KeyEvent.VK_CONTROL);
//	    		robot.keyRelease(KeyEvent.VK_C);
//	    		Thread.sleep(2000);
//	    		robot.keyPress(KeyEvent.VK_ENTER);
//	    		robot.keyRelease(KeyEvent.VK_ENTER);
//	    		// In dữ liệu từ clipboard
//	    		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//	            String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//	    		
//	    		System.out.println("Kết quả mong đợi: ThongKeSoGio_NamHoc"+namhocString+"_Nganh_"+nganhString+".pdf");
//	    		System.out.println("Kết quả thực tế: " + duLieu);
//
//	    } else {
//			System.out.println("Xem thất bại!!");
//		}
//	   
////	    driver.navigate().refresh();
//	}
	
	
//	@Test (priority = 28)
//	public void xemnamhoccohuubangbieusearch() throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
//		Thread.sleep(2000);
//		System.out.println("Test Case 29: Xem theo năm học - cơ hữu - bảng biểu - Export -> sao chép");
//		// Nhập dữ liệu từ file
//		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\So_Gio_GV.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(2);
//	    String thongketheoString = row.getCell(0).getStringCellValue();
//	    String namhocString = row.getCell(1).getStringCellValue();
//	    String nganhString = row.getCell(2).getStringCellValue();
//	    String loaiGvString = row.getCell(3).getStringCellValue();
//		//Chọn Thống kê theo: học kỳ
//		// Click box 
//	    WebElement boxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span"));
//	    boxElement.click();
//	    Thread.sleep(1000);
//	    // input search 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(thongketheoString);
//	    // click kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//		Thread.sleep(2000);
//	    
//	    //Chọn năm học
//	    WebElement namhocboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span"));
//	    namhocboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(namhocString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn ngành
//	    WebElement nganhboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span"));
//	    nganhboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn loại GV
//	    WebElement loaiGVboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span/span[1]/span"));
//	    loaiGVboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input")).sendKeys(loaiGvString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	    //Loại view
//	    WebElement viewBoxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[2]/a"));
//	    viewBoxElement.click();
//	    Thread.sleep(2000);
//	    
//	    //Sao chép
//	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/button"));
//	    printElement.click();
//	    Thread.sleep(1000);
//	    WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", printOptionElement);
//
//	    Thread.sleep(300);
//	    WebElement thongbaoElement= driver.findElement(By.xpath("/html/body/div[3]/h2"));
//	    String dulieuString = thongbaoElement.getText();
//	    
//	    //Sao chép table
//	    WebElement bangdulieuElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/table/tbody"));
//	    String dulieumongdoiString = bangdulieuElement.getText();
//	    
//	    // Xác nhận đã vào giao diện bảng biểu
//	    WebElement confirmElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/b"));
//	    if(confirmElement.getText().contains("Hướng dẫn:")) {
//
//	    		
//	    		// In dữ liệu từ clipboard
//	    		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//	            String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//	    		System.out.println(dulieuString);
//	    		System.out.println("Kết quả mong đợi: "+ dulieumongdoiString);
//	    		System.out.println("Kết quả thực tế: " + duLieu);
//
//	    } else {
//			System.out.println("Xem thất bại!!");
//		}
//	   
////	    driver.navigate().refresh();
//	}
	
	
//	@Test (priority = 29)
//	public void xemnamhoccohuuchitietsodulieu() throws IOException, InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("Test case 30: Xem theo năm học - cơ hữu - chi tiết - so du lieu");
//		// Nhập dữ liệu từ file
//		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\So_Gio_GV.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(2);
//	    String thongketheoString = row.getCell(0).getStringCellValue();
//	    String namhocString = row.getCell(1).getStringCellValue();
//	    String nganhString = row.getCell(2).getStringCellValue();
//	    String loaiGvString = row.getCell(3).getStringCellValue();
//		//Chọn Thống kê theo: học kỳ
//		// Click box 
//	    WebElement boxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span"));
//	    boxElement.click();
//	    Thread.sleep(1000);
//	    // input search 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(thongketheoString);
//	    // click kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//		Thread.sleep(2000);
//	    
//	    //Chọn năm học
//	    WebElement namhocboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span"));
//	    namhocboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(namhocString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn ngành
//	    WebElement nganhboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span"));
//	    nganhboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn loại GV
//	    WebElement loaiGVboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span/span[1]/span"));
//	    loaiGVboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input")).sendKeys(loaiGvString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	    //Loại view
//	    WebElement viewBoxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[3]/a"));
//	    viewBoxElement.click();
//	    Thread.sleep(2000);
//	    
//	    //Số dữ liệu
//	    Random random = new Random();
//	    int option = random.nextInt(1,4);
//	    WebElement sodulieuboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[1]/div/label/select"));
//	    sodulieuboxElement.click();
//	    Thread.sleep(500);
//	    WebElement soElemen = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[1]/div/label/select/option["+option+"]"));
//	    soElemen.click();
//	    
//	    
//	    // Xác nhận đã vào giao diện bảng biểu
//	    WebElement confirmElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[1]/div/label"));
//	    if(confirmElement.getText().contains("Hiển thị")) {
//	    	System.out.println("Kết quả mong đợi: " + thongketheoString + " - " + namhocString+" - " + nganhString + " - " + loaiGvString + " - Chi tiết - " + soElemen.getText());
//	 	    System.out.println("Kết quả thực tế: " + boxElement.getText() + " - " + namhocboxElement.getText() + " - " + nganhboxElement.getText() +" - "+ loaiGVboxElement.getText()+" - "+viewBoxElement.getText()+" - " + soElemen.getText());
//	    } else {
//			System.out.println("Xem thất bại!!");
//		}
//	   
////	    driver.navigate().refresh();
//	}
	
//	@Test (priority = 30)
//	public void xemnamhoccohuuchitietsearch() throws IOException, InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("Test case 31: Xem theo năm học - cơ hữu - chi tiết - Search ");
//		// Nhập dữ liệu từ file
//		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\So_Gio_GV.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(4);
//	    String thongketheoString = row.getCell(0).getStringCellValue();
//	    String namhocString = row.getCell(1).getStringCellValue();
//	    String nganhString = row.getCell(2).getStringCellValue();
//	    String loaiGvString = row.getCell(3).getStringCellValue();
//		//Chọn Thống kê theo: học kỳ
//		// Click box 
//	    WebElement boxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span"));
//	    boxElement.click();
//	    Thread.sleep(1000);
//	    // input search 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(thongketheoString);
//	    // click kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//		Thread.sleep(2000);
//	    
//	    //Chọn năm học
//	    WebElement namhocboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span"));
//	    namhocboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(namhocString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn ngành
//	    WebElement nganhboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span"));
//	    nganhboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn loại GV
//	    WebElement loaiGVboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span/span[1]/span"));
//	    loaiGVboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input")).sendKeys(loaiGvString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	    //Loại view
//	    WebElement viewBoxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[3]/a"));
//	    viewBoxElement.click();
//	    Thread.sleep(2000);
//	    
//	    //Search
//	    XSSFSheet sheet2 = workbook.getSheetAt(1);
//	    XSSFRow row2 = sheet2.getRow(2);
//	    String magvString = row2.getCell(1).getStringCellValue();
//	    String tenGvString = row2.getCell(2).getStringCellValue();
// 
//	    
//	    // Xác nhận đã vào giao diện bảng biểu
//	 // Xác nhận đã vào giao diện bảng biểu
//	    WebElement confirmElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[1]/div/label"));
//	    if(confirmElement.getText().contains("Hiển thị")) {
//
//	    		Thread.sleep(1000);
//	    		//Nhập dữ liệu 
//	    		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
//	    		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(magvString);
//	    		
//	    		Thread.sleep(1000);
//	    		WebElement maketquaElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/table/tbody/tr[1]/td[2]"));
//	    		System.out.println("Kết quả mong đợi: " + magvString);
//	    		System.out.println("Kết quả thực tế: " + maketquaElement.getText());
//	    		
//	    		Thread.sleep(1000);
//
//	    		
//	    		Thread.sleep(1000);
//	    		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
//	    		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(tenGvString);
//	    		
//	    		Thread.sleep(1000);
//	    		WebElement tenketquaElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/table/tbody/tr[1]/td[3]"));
//	    		System.out.println("Kết quả mong đợi: " + tenGvString);
//	    		System.out.println("Kết quả thực tế: " + tenketquaElement.getText());
//
//	    } else {
//			System.out.println("Xem thất bại!!");
//		}
//	   
////	    driver.navigate().refresh();
//	}
	
	
	
//	@Test (priority = 31)
//	public void xemnamhoccohuuchitietsearch() throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
//		Thread.sleep(2000);
//		System.out.println("Test Case 32: Xem theo năm học - cơ hữu - chi tiết - Export -> print");
//		// Nhập dữ liệu từ file
//		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\So_Gio_GV.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(2);
//	    String thongketheoString = row.getCell(0).getStringCellValue();
//	    String namhocString = row.getCell(1).getStringCellValue();
//	    String nganhString = row.getCell(2).getStringCellValue();
//	    String loaiGvString = row.getCell(3).getStringCellValue();
//		//Chọn Thống kê theo: học kỳ
//		// Click box 
//	    WebElement boxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span"));
//	    boxElement.click();
//	    Thread.sleep(1000);
//	    // input search 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(thongketheoString);
//	    // click kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//		Thread.sleep(2000);
//	    
//	    //Chọn năm học
//	    WebElement namhocboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span"));
//	    namhocboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(namhocString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn ngành
//	    WebElement nganhboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span"));
//	    nganhboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	  //Chọn loại GV
//	    WebElement loaiGVboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span/span[1]/span"));
//	    loaiGVboxElement.click();
//	    Thread.sleep(1000);
//	    //input search
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input")).sendKeys(loaiGvString);
//	    // Click vào kết quả search
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    
//	    //Loại view
//	    WebElement viewBoxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[3]/a"));
//	    viewBoxElement.click();
//	    Thread.sleep(2000);
//	    
//	    //Print
//	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//	    printElement.click();
//	    Thread.sleep(1000);
//	    WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", printOptionElement);
//
//	    
//	    Robot robot = new Robot();
// 
//	    
//	    // Xác nhận đã vào giao diện bảng biểu
//	    WebElement confirmElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[1]/div/label"));
//	    if(confirmElement.getText().contains("Hiển thị")) {
//
//	    		Thread.sleep(2000);
//	    		robot.keyPress(KeyEvent.VK_ENTER);
//	    		robot.keyRelease(KeyEvent.VK_ENTER);
//	    		Thread.sleep(2000);
//	    		robot.keyPress(KeyEvent.VK_CONTROL);
//	    		robot.keyPress(KeyEvent.VK_C);
//	    		robot.keyRelease(KeyEvent.VK_CONTROL);
//	    		robot.keyRelease(KeyEvent.VK_C);
//	    		Thread.sleep(2000);
//	    		robot.keyPress(KeyEvent.VK_ENTER);
//	    		robot.keyRelease(KeyEvent.VK_ENTER);
//	    		// In dữ liệu từ clipboard
//	    		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//	            String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//	    		
//	    		System.out.println("Kết quả mong đợi: ThongKeChiTietSoGio_NamHoc"+namhocString+"_Nganh_"+nganhString+".pdf");
//	    		System.out.println("Kết quả thực tế: " + duLieu);
//
//	    } else {
//			System.out.println("Xem thất bại!!");
//		}
//	   
////	    driver.navigate().refresh();
//	}
	
	
	@Test (priority = 32)
	public void xemnamhoccohuubangbieusearch() throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
		Thread.sleep(2000);
		System.out.println("Test Case 33: Xem theo năm học - cơ hữu - chi tiết - Export -> sao chép");
		// Nhập dữ liệu từ file
		FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\So_Gio_GV.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(2);
	    String thongketheoString = row.getCell(0).getStringCellValue();
	    String namhocString = row.getCell(1).getStringCellValue();
	    String nganhString = row.getCell(2).getStringCellValue();
	    String loaiGvString = row.getCell(3).getStringCellValue();
		//Chọn Thống kê theo: học kỳ
		// Click box 
	    WebElement boxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span"));
	    boxElement.click();
	    Thread.sleep(1000);
	    // input search 
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(thongketheoString);
	    // click kết quả search
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
		Thread.sleep(2000);
	    
	    //Chọn năm học
	    WebElement namhocboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span"));
	    namhocboxElement.click();
	    Thread.sleep(1000);
	    //input search
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(namhocString);
	    // Click vào kết quả search
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();
	    Thread.sleep(2000);
	    
	  //Chọn ngành
	    WebElement nganhboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span"));
	    nganhboxElement.click();
	    Thread.sleep(1000);
	    //input search
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
	    // Click vào kết quả search
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
	    Thread.sleep(2000);
	    
	  //Chọn loại GV
	    WebElement loaiGVboxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span/span[1]/span"));
	    loaiGVboxElement.click();
	    Thread.sleep(1000);
	    //input search
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input")).sendKeys(loaiGvString);
	    // Click vào kết quả search
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li")).click();
	    Thread.sleep(2000);
	    
	  //Loại view
	    WebElement viewBoxElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[3]/a"));
	    viewBoxElement.click();
	    Thread.sleep(2000);
	    
	    //Sao chép
	    //Print
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(1000);
	    WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", printOptionElement);

	    Thread.sleep(300);
	    WebElement thongbaoElement= driver.findElement(By.xpath("/html/body/div[3]/h2"));
	    String dulieuString = thongbaoElement.getText();
	    
	    //Sao chép table
	    WebElement bangdulieuElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/table/tbody"));
	    String dulieumongdoiString = bangdulieuElement.getText();
	    
	    // Xác nhận đã vào giao diện bảng biểu
	    // Xác nhận đã vào giao diện bảng biểu
	    WebElement confirmElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div[1]/div[1]/div/label"));
	    if(confirmElement.getText().contains("Hiển thị")) {
	    		// In dữ liệu từ clipboard
	    		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	            String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
	    		System.out.println(dulieuString);
	    		System.out.println("Kết quả mong đợi: "+ dulieumongdoiString);
	    		System.out.println("Kết quả thực tế: " + duLieu);

	    } else {
			System.out.println("Xem thất bại!!");
		}
	   
//	    driver.navigate().refresh();
	}
	
}
