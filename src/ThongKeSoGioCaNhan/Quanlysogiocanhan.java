package Sogiocanhan;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Quanlysogiocanhan {
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
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[4]/a")).click();

	}
	
	@Test (priority = 0)
	public void xemtheohockybieudo() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test Case 1 Xem Thống kê theo học kỳ ở chế độ biểu đồ");
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clickhockyElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/select/option[1]"));
		 clickhockyElement.click();
		 String luachon = clickhockyElement.getText();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clicksohocky =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		clicksohocky.sendKeys(hocky);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		WebElement hockythucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bieudo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[1]/a"));
		System.out.println("Kết quả mong đợi: Học kỳ " + hocky +" Biểu đồ");
		System.out.println("Kết quả thực tế: " + luachon+ " " + hockythucte.getText() +" " + bieudo.getText());
		driver.navigate().refresh();
	}

	@Test (priority = 1)
	public void xemtheohockybangbieu() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test Case 2: Xem Thống kê theo học kỳ ở chế độ bảng biểu");
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clickhockyElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/select/option[1]"));
		 clickhockyElement.click();
		 String luachon = clickhockyElement.getText();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clicksohocky =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		clicksohocky.sendKeys(hocky);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		WebElement hockythucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]"));
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		Thread.sleep(1000);
		WebElement dulieuElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]"));
		String dulieuString = dulieuElement.getText();
		System.out.println("Kết quả mong đợi: Học kỳ " + hocky +" Bảng biểu" );
		System.out.println("Kết quả thực tế: " + luachon+ " " + hockythucte.getText() +" " + bangbieu.getText());
		System.out.println("Kếu quả mong đợi \"Bảng dữ liệu\"");
		System.out.println("Kết quả thực tế \n \t" + dulieuString);
		driver.navigate().refresh();

	}
	
	
	@Test (priority = 2)
	public void searchHocKybangbieu() throws InterruptedException, AWTException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 3: Tìm dữ liệu thống kê ở Bảng biểu học kỳ");
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clickhockyElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/select/option[1]"));
		 clickhockyElement.click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clicksohocky =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		clicksohocky.sendKeys(hocky);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		
		// Bắt đầu tìm kiếm
		FileInputStream fis2 = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		 XSSFWorkbook workbook2 = new XSSFWorkbook(fis2);
		 XSSFSheet sheet2 = workbook2.getSheetAt(1);
		 for(int i =1; i< sheet2.getPhysicalNumberOfRows(); i++) { 
			 XSSFRow row2 = sheet2.getRow(i);
			 String mahp = row2.getCell(0).getStringCellValue();
			 String tenhp = row2.getCell(1).getStringCellValue();
			 String nganh = row2.getCell(2).getStringCellValue();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(mahp);
			 Thread.sleep(1000);
			 WebElement mahpElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2]"));
			 System.out.println("Kết quả mong đợi: " + mahp);
			 System.out.println("Kết quả thực tế: " + mahpElement.getText());
			 
			 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(tenhp);
			 Thread.sleep(1000);
			 WebElement tenhpElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]"));
			 System.out.println("Kết quả mong đợi: " + tenhp);
			 System.out.println("Kết quả thực tế: " + tenhpElement.getText());
			 
			 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(nganh);
			 Thread.sleep(1000);
			 WebElement nganhElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]"));
			 System.out.println("Kết quả mong đợi: " + nganh);
			 System.out.println("Kết quả thực tế: " + nganhElement.getText());
		 }
		 driver.navigate().refresh();

	}

	
	
	@Test (priority = 3)
	public void printhockybangbieu() throws InterruptedException, AWTException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 4: In dữ liệu thống kê ở Bảng biểu học kỳ");
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clickhockyElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/select/option[1]"));
		 clickhockyElement.click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clicksohocky =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		 clicksohocky.sendKeys(hocky);
		 Robot robot = new Robot();
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		 Thread.sleep(2000);
		 WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		 bangbieu.click();
		
		//Tiến hành in file
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		try {    
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); 
            String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor); 
            System.out.println("Kết quả mong đợi - File đã được print: ThongKeSoGio_HK"+hocky+".pdf" );
            System.out.println("Kết quản thực tế File đã được print: " + duLieu);
        } catch (UnsupportedFlavorException | IOException e) {
           System.out.println("Print file thất bại");
        }
		
		driver.navigate().refresh();
	}
	
	
	
	@Test (priority = 4)
	public void Clipboardbangbieuhocky() throws InterruptedException, IOException, AWTException, UnsupportedFlavorException {
		Thread.sleep(2000);
		System.out.println("Test Case 5: Sao chép dữ liệu thống kê ở Bảng biểu học kỳ");
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clickhockyElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/select/option[1]"));
		 clickhockyElement.click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clicksohocky =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		clicksohocky.sendKeys(hocky);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		
		// Sao chép dữ liệu 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]")).click();
		WebElement bangdulieuElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody"));
		String dulieumongdoi = bangdulieuElement.getText();
		
		Thread.sleep(300);
		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
		String ketquathucteString = thongbaoElement.getText();
		
		System.out.println("Kết quả mong đợi: Sao chép vào clipboard" );
		System.out.println("Kết quả thực tế: " + ketquathucteString);
		
		System.out.println("Dữ liệu mong đợi \n" + dulieumongdoi);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
		System.out.println("Dữ liệu thực tế: " + duLieu);
		driver.navigate().refresh();
	}
	
	@Test (priority = 5)
	public void xemtheonamhocbieudo() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test Case 6 Xem Thống kê theo năm học ở chế độ biểu đồ");
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		XSSFRow row = sheet.getRow(1);
		String namhoc = row.getCell(0).getStringCellValue();
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicknamhocElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]"));
		String luachon = clicknamhocElement.getText();
		clicknamhocElement.click();
		 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicksonamhox =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		clicksonamhox.sendKeys(namhoc);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();		
		
		WebElement namhocthucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bieudo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[1]/a"));
		System.out.println("Kết quả mong đợi: Năm học " + namhoc +" Biểu đồ");
		System.out.println("Kết quả thực tế: " + luachon+ " " + namhocthucte.getText() +" " + bieudo.getText());
		driver.navigate().refresh();
	}

	@Test (priority = 6)
	public void xemtheonamhocbangbieu() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 7 Xem Thống kê theo năm học ở chế độ bảng biểu");
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		XSSFRow row = sheet.getRow(1);
		String namhoc = row.getCell(0).getStringCellValue();
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicknamhocElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]"));
		String luachon = clicknamhocElement.getText();
		clicknamhocElement.click();
		 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicksonamhox =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		clicksonamhox.sendKeys(namhoc);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();		
		Thread.sleep(2000);
		WebElement namhocthucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		System.out.println("Kết quả mong đợi: Năm học " + namhoc +" Bảng Biểu");
		System.out.println("Kết quả thực tế: " + luachon+ " " + namhocthucte.getText() +" " + bangbieu.getText());
		driver.navigate().refresh();
	}

	@Test (priority = 7)
	public void searchdulieutheonamhoc() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 8 tìm kiếm dữ liệu theo năm học ở chế độ bảng biểu");
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		XSSFRow row = sheet.getRow(1);
		String namhoc = row.getCell(0).getStringCellValue();
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicknamhocElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]"));
		String luachon = clicknamhocElement.getText();
		clicknamhocElement.click();
		 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicksonamhox =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		clicksonamhox.sendKeys(namhoc);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();		
		Thread.sleep(2000);
		WebElement namhocthucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		
		//Bắt đầu tìm kiếm dữ liệu 
		
		FileInputStream fis2 = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		 XSSFWorkbook workbook2 = new XSSFWorkbook(fis2);
		 XSSFSheet sheet2 = workbook2.getSheetAt(1);
		 for(int i =1; i< sheet2.getPhysicalNumberOfRows(); i++) { 
			 XSSFRow row2 = sheet2.getRow(i);
			 String mahp = row2.getCell(0).getStringCellValue();
			 String tenhp = row2.getCell(1).getStringCellValue();
			 String nganh = row2.getCell(2).getStringCellValue();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(mahp);
			 Thread.sleep(1000);
			 WebElement mahpElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2]"));
			 System.out.println("Kết quả mong đợi: " + mahp);
			 System.out.println("Kết quả thực tế: " + mahpElement.getText());
			 
			 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(tenhp);
			 Thread.sleep(1000);
			 WebElement tenhpElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]"));
			 System.out.println("Kết quả mong đợi: " + tenhp);
			 System.out.println("Kết quả thực tế: " + tenhpElement.getText());
			 
			 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(nganh);
			 Thread.sleep(1000);
			 WebElement nganhElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr/td[4]"));
			 System.out.println("Kết quả mong đợi: " + nganh);
			 System.out.println("Kết quả thực tế: " + nganhElement.getText());
		 }
		 driver.navigate().refresh();
	
	}
	
	@Test (priority = 8)
	public void printdulieutheonamhoc() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test Case 9 In dữ liệu thống kê ở Bảng biểu Năm Học");
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		XSSFRow row = sheet.getRow(1);
		String namhoc = row.getCell(0).getStringCellValue();
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicknamhocElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]"));
		String luachon = clicknamhocElement.getText();
		clicknamhocElement.click();
		 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicksonamhox =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		clicksonamhox.sendKeys(namhoc);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();		
		Thread.sleep(2000);
		WebElement namhocthucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]")).click();
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		try {    
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); 
            String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor); 
            System.out.println("Kết quả mong đợi - File đã được print: ThongKeSoGio_NamHoc_"+namhoc+".pdf" );
            System.out.println("Kết quản thực tế File đã được print: " + duLieu);
        } catch (UnsupportedFlavorException | IOException e) {
           System.out.println("Print file thất bại");
        }
		driver.navigate().refresh();
	}

	
	@Test (priority = 9)
	public void Clipboardbangbieunamhoc() throws InterruptedException, UnsupportedFlavorException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 10: Sao chép dữ liệu thống kê ở Bảng biểu Năm Học");
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		XSSFRow row = sheet.getRow(1);
		String namhoc = row.getCell(0).getStringCellValue();
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicknamhocElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]"));
		String luachon = clicknamhocElement.getText();
		clicknamhocElement.click();
		 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicksonamhox =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		clicksonamhox.sendKeys(namhoc);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();		
		Thread.sleep(2000);
		WebElement namhocthucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		
		// Sao chép dữ liệu 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]")).click();
		WebElement bangdulieuElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody"));
		String dulieumongdoi = bangdulieuElement.getText();
		
		Thread.sleep(300);
		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
		String ketquathucteString = thongbaoElement.getText();
		
		System.out.println("Kết quả mong đợi: Sao chép vào clipboard" );
		System.out.println("Kết quả thực tế: " + ketquathucteString);
		
		System.out.println("Dữ liệu mong đợi \n" + dulieumongdoi);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
		System.out.println("Dữ liệu thực tế: " + duLieu);
		driver.navigate().refresh();
	}	
	
	
	@Test (priority = 10)
	public void xemtheohockybieudotheoca() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test Case 11 Xem Thống kê theo học kỳ ở chế độ biểu đồ Xem theo ca");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div[2]/div/input")).click();
		Thread.sleep(1000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clickhockyElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/select/option[1]"));
		 clickhockyElement.click();
		 String luachon = clickhockyElement.getText();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clicksohocky =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		clicksohocky.sendKeys(hocky);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		WebElement hockythucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bieudo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[1]/a"));
		System.out.println("Kết quả mong đợi: Học kỳ " + hocky +" Biểu đồ");
		System.out.println("Kết quả thực tế: " + luachon+ " " + hockythucte.getText() +" " + bieudo.getText());
		driver.navigate().refresh();
	}

	@Test (priority = 11)
	public void xemtheohockybangbieutheoca() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test Case 12: Xem Thống kê theo học kỳ ở chế độ bảng biểu xem theo ca");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div[2]/div/input")).click();
		Thread.sleep(1000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clickhockyElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/select/option[1]"));
		 clickhockyElement.click();
		 String luachon = clickhockyElement.getText();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clicksohocky =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		clicksohocky.sendKeys(hocky);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		WebElement hockythucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]"));
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		Thread.sleep(1000);
		WebElement dulieuElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]"));
		String dulieuString = dulieuElement.getText();
		System.out.println("Kết quả mong đợi: Học kỳ " + hocky +" Bảng biểu" );
		System.out.println("Kết quả thực tế: " + luachon+ " " + hockythucte.getText() +" " + bangbieu.getText());
		System.out.println("Kếu quả mong đợi \"Bảng dữ liệu\"");
		System.out.println("Kết quả thực tế \n \t" + dulieuString);
		driver.navigate().refresh();

	}
	
	
	@Test (priority = 12)
	public void searchHocKybangbieutheoca() throws InterruptedException, AWTException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 13: Tìm dữ liệu thống kê ở Bảng biểu học kỳ xem theo ca");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div[2]/div/input")).click();
		Thread.sleep(1000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clickhockyElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/select/option[1]"));
		 clickhockyElement.click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clicksohocky =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		clicksohocky.sendKeys(hocky);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		
		// Bắt đầu tìm kiếm
		FileInputStream fis2 = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		 XSSFWorkbook workbook2 = new XSSFWorkbook(fis2);
		 XSSFSheet sheet2 = workbook2.getSheetAt(1);
		 for(int i =1; i< sheet2.getPhysicalNumberOfRows(); i++) { 
			 XSSFRow row2 = sheet2.getRow(i);
			 String mahp = row2.getCell(0).getStringCellValue();
			 String tenhp = row2.getCell(1).getStringCellValue();
			 String nganh = row2.getCell(2).getStringCellValue();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(mahp);
			 Thread.sleep(1000);
			 WebElement mahpElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2]"));
			 System.out.println("Kết quả mong đợi: " + mahp);
			 System.out.println("Kết quả thực tế: " + mahpElement.getText());
			 
			 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(tenhp);
			 Thread.sleep(1000);
			 WebElement tenhpElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]"));
			 System.out.println("Kết quả mong đợi: " + tenhp);
			 System.out.println("Kết quả thực tế: " + tenhpElement.getText());
			 
			 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(nganh);
			 Thread.sleep(1000);
			 WebElement nganhElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]"));
			 System.out.println("Kết quả mong đợi: " + nganh);
			 System.out.println("Kết quả thực tế: " + nganhElement.getText());
		 }
		 driver.navigate().refresh();

	}

	
	
	@Test (priority = 13)
	public void printhockybangbieutheoca() throws InterruptedException, AWTException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 14: In dữ liệu thống kê ở Bảng biểu học kỳ xem theo ca");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div[2]/div/input")).click();
		Thread.sleep(1000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clickhockyElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/select/option[1]"));
		 clickhockyElement.click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clicksohocky =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		 clicksohocky.sendKeys(hocky);
		 Robot robot = new Robot();
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		 Thread.sleep(2000);
		 WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		 bangbieu.click();
		
		//Tiến hành in file
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		try {    
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); 
            String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor); 
            System.out.println("Kết quả mong đợi - File đã được print: ThongKeSoGio_HK"+hocky+".pdf" );
            System.out.println("Kết quản thực tế File đã được print: " + duLieu);
        } catch (UnsupportedFlavorException | IOException e) {
           System.out.println("Print file thất bại");
        }
		
		driver.navigate().refresh();
	}
	
	
	
	@Test (priority = 14)
	public void Clipboardbangbieuhockytheoca() throws InterruptedException, IOException, AWTException, UnsupportedFlavorException {
		Thread.sleep(2000);
		System.out.println("Test Case 15: Sao chép dữ liệu thống kê ở Bảng biểu học kỳ xem theo ca");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div[2]/div/input")).click();
		Thread.sleep(1000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clickhockyElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/select/option[1]"));
		 clickhockyElement.click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span/span[1]")).click();
		 Thread.sleep(1000);
		 WebElement clicksohocky =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		clicksohocky.sendKeys(hocky);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		
		// Sao chép dữ liệu 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]")).click();
		WebElement bangdulieuElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody"));
		String dulieumongdoi = bangdulieuElement.getText();
		
		Thread.sleep(300);
		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
		String ketquathucteString = thongbaoElement.getText();
		
		System.out.println("Kết quả mong đợi: Sao chép vào clipboard" );
		System.out.println("Kết quả thực tế: " + ketquathucteString);
		
		System.out.println("Dữ liệu mong đợi \n" + dulieumongdoi);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
		System.out.println("Dữ liệu thực tế: " + duLieu);
		driver.navigate().refresh();
	}
	
	
	
	@Test (priority = 15)
	public void xemtheonamhocbieudotheoca() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test Case 16 Xem Thống kê theo năm học ở chế độ biểu đồ theo ca");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div[2]/div/input")).click();
		Thread.sleep(1000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		XSSFRow row = sheet.getRow(1);
		String namhoc = row.getCell(0).getStringCellValue();
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicknamhocElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]"));
		String luachon = clicknamhocElement.getText();
		clicknamhocElement.click();
		 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicksonamhox =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		clicksonamhox.sendKeys(namhoc);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();		
		
		WebElement namhocthucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bieudo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[1]/a"));
		System.out.println("Kết quả mong đợi: Năm học " + namhoc +" Biểu đồ");
		System.out.println("Kết quả thực tế: " + luachon+ " " + namhocthucte.getText() +" " + bieudo.getText());
		driver.navigate().refresh();
	}

	@Test (priority = 16)
	public void xemtheonamhocbangbieutheoca() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 17 Xem Thống kê theo năm học ở chế độ bảng biểu theo ca");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div[2]/div/input")).click();
		Thread.sleep(1000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		XSSFRow row = sheet.getRow(1);
		String namhoc = row.getCell(0).getStringCellValue();
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicknamhocElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]"));
		String luachon = clicknamhocElement.getText();
		clicknamhocElement.click();
		 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicksonamhox =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		clicksonamhox.sendKeys(namhoc);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();		
		Thread.sleep(2000);
		WebElement namhocthucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		System.out.println("Kết quả mong đợi: Năm học " + namhoc +" Bảng Biểu");
		System.out.println("Kết quả thực tế: " + luachon+ " " + namhocthucte.getText() +" " + bangbieu.getText());
		driver.navigate().refresh();
	}

	@Test (priority = 17)
	public void searchdulieutheonamhoctheoca() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 18 tìm kiếm dữ liệu theo năm học ở chế độ bảng biểu xem theo ca");		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div[2]/div/input")).click();
		Thread.sleep(1000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		XSSFRow row = sheet.getRow(1);
		String namhoc = row.getCell(0).getStringCellValue();
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicknamhocElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]"));
		String luachon = clicknamhocElement.getText();
		clicknamhocElement.click();
		 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicksonamhox =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		clicksonamhox.sendKeys(namhoc);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();		
		Thread.sleep(2000);
		WebElement namhocthucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		
		//Bắt đầu tìm kiếm dữ liệu 
		
		FileInputStream fis2 = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		 XSSFWorkbook workbook2 = new XSSFWorkbook(fis2);
		 XSSFSheet sheet2 = workbook2.getSheetAt(1);
		 for(int i =1; i< sheet2.getPhysicalNumberOfRows(); i++) { 
			 XSSFRow row2 = sheet2.getRow(i);
			 String mahp = row2.getCell(0).getStringCellValue();
			 String tenhp = row2.getCell(1).getStringCellValue();
			 String nganh = row2.getCell(2).getStringCellValue();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(mahp);
			 Thread.sleep(1000);
			 WebElement mahpElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2]"));
			 System.out.println("Kết quả mong đợi: " + mahp);
			 System.out.println("Kết quả thực tế: " + mahpElement.getText());
			 
			 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(tenhp);
			 Thread.sleep(1000);
			 WebElement tenhpElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]"));
			 System.out.println("Kết quả mong đợi: " + tenhp);
			 System.out.println("Kết quả thực tế: " + tenhpElement.getText());
			 
			 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
			 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(nganh);
			 Thread.sleep(1000);
			 WebElement nganhElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr/td[4]"));
			 System.out.println("Kết quả mong đợi: " + nganh);
			 System.out.println("Kết quả thực tế: " + nganhElement.getText());
		 }
		 driver.navigate().refresh();
	
	}
	
	@Test (priority = 18)
	public void printdulieutheonamhoctheoca() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test Case 19 In dữ liệu thống kê ở Bảng biểu Năm Học xem theo ca");
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div[2]/div/input")).click();
		Thread.sleep(1000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		XSSFRow row = sheet.getRow(1);
		String namhoc = row.getCell(0).getStringCellValue();
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicknamhocElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]"));
		String luachon = clicknamhocElement.getText();
		clicknamhocElement.click();
		 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicksonamhox =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		clicksonamhox.sendKeys(namhoc);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();		
		Thread.sleep(2000);
		WebElement namhocthucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]")).click();
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		try {    
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); 
            String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor); 
            System.out.println("Kết quả mong đợi - File đã được print: ThongKeSoGio_NamHoc_"+namhoc+".pdf" );
            System.out.println("Kết quản thực tế File đã được print: " + duLieu);
        } catch (UnsupportedFlavorException | IOException e) {
           System.out.println("Print file thất bại");
        }
		driver.navigate().refresh();
	}

	
	@Test (priority = 19)
	public void Clipboardbangbieunamhoctheoca() throws InterruptedException, UnsupportedFlavorException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 20: Sao chép dữ liệu thống kê ở Bảng biểu Năm Học xem theo ca");
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div[2]/div/input")).click();
		Thread.sleep(1000);
		FileInputStream fis = new FileInputStream("E:\\TestData\\Thongkesogiocanhan.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		XSSFRow row = sheet.getRow(1);
		String namhoc = row.getCell(0).getStringCellValue();
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicknamhocElement =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]"));
		String luachon = clicknamhocElement.getText();
		clicknamhocElement.click();
		 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		 
		WebElement clicksonamhox =	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		clicksonamhox.sendKeys(namhoc);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[1]")).click();		
		Thread.sleep(2000);
		WebElement namhocthucte = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[1]"));
		Thread.sleep(2000);
		WebElement bangbieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div/ul/li[2]/a"));
		bangbieu.click();
		
		// Sao chép dữ liệu 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]")).click();
		WebElement bangdulieuElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody"));
		String dulieumongdoi = bangdulieuElement.getText();
		
		Thread.sleep(300);
		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
		String ketquathucteString = thongbaoElement.getText();
		
		System.out.println("Kết quả mong đợi: Sao chép vào clipboard" );
		System.out.println("Kết quả thực tế: " + ketquathucteString);
		
		System.out.println("Dữ liệu mong đợi \n" + dulieumongdoi);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
		System.out.println("Dữ liệu thực tế: " + duLieu);
		driver.navigate().refresh();
	}	
	
}


