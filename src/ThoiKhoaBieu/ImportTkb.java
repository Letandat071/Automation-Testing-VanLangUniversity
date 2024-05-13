package ThoiKhoaBieu;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

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

public class ImportTkb {
	public  WebDriver driver;
	Random random = new Random();
	@BeforeTest
	public void setup() throws InterruptedException {
		String chromeProfilePath = "C:\\Users\\letan\\AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]/ul/li[1]/a")).click();
	}
	@Test(priority = 0)
	public void uploadkhonghocki() throws IOException, InterruptedException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test case 1: Chọn đủ các trường không chọn học kỳ!");
		
		//Lấy dữ liệu từ file
		FileInputStream fis = new FileInputStream("D:\\thongtinthoikhoabieu.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  XSSFRow row = sheet.getRow(1);
		    
		  String hocky = row.getCell(0).getStringCellValue();
		  String nganh = row.getCell(1).getStringCellValue();
		  String filethoikhoabieu = row.getCell(2).getStringCellValue();
		  StringSelection duongdan = new StringSelection(filethoikhoabieu);
		//Chọn dữ liệu
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-major-container")).click();
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganh);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		  //Upload Thời Khóa biểu
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[2]/div")).click();
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(duongdan, null);
		  Thread.sleep(2000);
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  Thread.sleep(2000);
		  String ketquamongdoi= "Bạn chưa chọn học kỳ";
		  //Xác nhận
		  driver.findElement(By.id("submit-all")).click();
		  Thread.sleep(800);
		  WebElement thongbao = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		  String ketquathucte = thongbao.getText();
		  System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		  System.out.println("Kết quả thực tế: "+ ketquathucte);
		driver.navigate().refresh();
	}
	
	@Test (priority = 1)
	public void chondukhongchonnganh() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test case 2: Chọn đủ các trường không chọn ngành");
		
		//Lấy dữ liệu từ file
		FileInputStream fis = new FileInputStream("D:\\thongtinthoikhoabieu.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  XSSFRow row = sheet.getRow(1);
		    
		  String hocky = row.getCell(0).getStringCellValue();
		  String nganh = row.getCell(1).getStringCellValue();
		  String filethoikhoabieu = row.getCell(2).getStringCellValue();
		  StringSelection duongdan = new StringSelection(filethoikhoabieu);
		//Chọn dữ liệu
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-term-container")).click();
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hocky);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
		  //Upload Thời Khóa biểu
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[2]/div")).click();
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(duongdan, null);
		  Thread.sleep(2000);
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  Thread.sleep(2000);
		  String ketquamongdoi= "Bạn chưa chọn ngành";
		  //Xác nhận
		  driver.findElement(By.id("submit-all")).click();
		  Thread.sleep(800);
		  WebElement thongbao = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		  String ketquathucte = thongbao.getText();
		  System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		  System.out.println("Kết quả thực tế: "+ ketquathucte);
		  driver.navigate().refresh();
	}
	
	@Test (priority = 2)
	public void khongconuploadfile() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test case 3: Chọn đủ trường nhưng không upload file");
		
		//Lấy dữ liệu từ file
		FileInputStream fis = new FileInputStream("D:\\thongtinthoikhoabieu.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
			    
		String hocky = row.getCell(0).getStringCellValue();
		String nganh = row.getCell(1).getStringCellValue();
		String filethoikhoabieu = row.getCell(2).getStringCellValue();
		StringSelection duongdan = new StringSelection(filethoikhoabieu);
		
		//Chọn dữ liệu
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-term-container")).click();
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hocky);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-major-container")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganh);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
		  
		  String ketquamongdoi= "File chưa được upload hoặc sai định dạng";
		  //Xác nhận
		  driver.findElement(By.id("submit-all")).click();
		  Thread.sleep(800);
		  WebElement thongbao = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		  String ketquathucte = thongbao.getText();
		  System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		  System.out.println("Kết quả thực tế: "+ ketquathucte);
		  driver.navigate().refresh();
	}
	@Test (priority = 3)
	public void uploadfullinforcancel() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test case 4: Chọn đủ trường, thời khóa biểu có lớp trống nhưng chọn hủy");
		
		//Lấy dữ liệu từ file
		FileInputStream fis = new FileInputStream("D:\\thongtinthoikhoabieu.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
			    
		String hocky = row.getCell(0).getStringCellValue();
		String nganh = row.getCell(1).getStringCellValue();
		String filethoikhoabieu = row.getCell(2).getStringCellValue();
		StringSelection duongdan = new StringSelection(filethoikhoabieu);
		
		//Chọn dữ liệu
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-term-container")).click();
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hocky);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-major-container")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganh);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
	
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[2]/div")).click();
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(duongdan, null);
		  Thread.sleep(2000);
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  Thread.sleep(2000);
		  
		  String ketquamongdoi= "Hủy";
		  //Xác nhận
		  driver.findElement(By.id("submit-all")).click();	  
		  Thread.sleep(1000);
		  WebElement popupload = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]"));
		  String ketquathucte = popupload.getText();
		  popupload.click();
		  System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		  System.out.println("Kết quả thực tế: "+ ketquathucte);
		  driver.navigate().refresh();
	}
	
	@Test (priority = 4)
	public void uploadfullinfornext() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test case 5: Chọn đủ trường, thời khóa biểu có lớp trống nhưng chọn import tiếp");
		
		//Lấy dữ liệu từ file
		FileInputStream fis = new FileInputStream("D:\\thongtinthoikhoabieu.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
			    
		String hocky = row.getCell(0).getStringCellValue();
		String nganh = row.getCell(1).getStringCellValue();
		String filethoikhoabieu = row.getCell(2).getStringCellValue();
		StringSelection duongdan = new StringSelection(filethoikhoabieu);
		
		//Chọn dữ liệu
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-term-container")).click();
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hocky);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-major-container")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganh);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
	
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[2]/div")).click();
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(duongdan, null);
		  Thread.sleep(2000);
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  Thread.sleep(2000);
		  
		  String ketquamongdoi= "Import thời khoá biểu thành công!";
		  //Xác nhận
		  driver.findElement(By.id("submit-all")).click();	  
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		  Thread.sleep(80000);
		  WebElement thongbaothanhcong = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]"));
		  String ketquathucte = thongbaothanhcong.getText();
		  System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		  System.out.println("Kết quả thực tế: "+ ketquathucte);
		  driver.navigate().refresh();
	}
	
	@Test (priority = 5)
	public void uploadfullinforreplace() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test case 6: Chọn thay thế thời khóa biểu");
		
		//Lấy dữ liệu từ file
		FileInputStream fis = new FileInputStream("D:\\thongtinthoikhoabieu.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
			    
		String hocky = row.getCell(0).getStringCellValue();
		String nganh = row.getCell(1).getStringCellValue();
		String filethoikhoabieu = row.getCell(2).getStringCellValue();
		StringSelection duongdan = new StringSelection(filethoikhoabieu);
		
		//Chọn dữ liệu
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-term-container")).click();
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hocky);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-major-container")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganh);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
	
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[2]/div")).click();
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(duongdan, null);
		  Thread.sleep(2000);
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  Thread.sleep(2000);
		  
		  String ketquamongdoi= "Import thời khoá biểu thành công!";
		  //Xác nhận
		  driver.findElement(By.id("submit-all")).click();	  
		  Thread.sleep(1000);
		  WebElement popupload = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[2]"));
		  Thread.sleep(1000);
		  popupload.click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		  Thread.sleep(20000);
		  WebElement thongbaothanhcong = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]"));
		  String ketquathucte = thongbaothanhcong.getText();
		  System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		  System.out.println("Kết quả thực tế: "+ ketquathucte);
		  driver.navigate().refresh();
	}
	
	@Test (priority = 6)
	public void uploadfullinforupdate() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		System.out.println("Test case 7: Chọn Update thời khóa biểu");
		
		//Lấy dữ liệu từ file
		FileInputStream fis = new FileInputStream("D:\\thongtinthoikhoabieu.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
			    
		String hocky = row.getCell(0).getStringCellValue();
		String nganh = row.getCell(1).getStringCellValue();
		String filethoikhoabieu = row.getCell(2).getStringCellValue();
		StringSelection duongdan = new StringSelection(filethoikhoabieu);
		
		//Chọn dữ liệu
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-term-container")).click();
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hocky);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("select2-major-container")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganh);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]")).click();
	
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[2]/div")).click();
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(duongdan, null);
		  Thread.sleep(2000);
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  Thread.sleep(2000);
		  
		  String ketquamongdoi= "Import thời khoá biểu thành công!";
		  //Xác nhận
		  driver.findElement(By.id("submit-all")).click();	  
		  Thread.sleep(1000);
		  WebElement popupload = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
		  Thread.sleep(1000);
		  popupload.click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		  Thread.sleep(20000);
		  WebElement thongbaothanhcong = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]"));
		  String ketquathucte = thongbaothanhcong.getText();
		  System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		  System.out.println("Kết quả thực tế: "+ ketquathucte);
	}
}