package SOGIOQUYDOI;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Export_SoGioQuyDoi_NamHoc {
	static WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\AN515-45\\AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[2]/a")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	// Phương thức kiểm tra chức năng xuất dữ liệu thứ nhất
	public void Export1() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
	    // In ra thông báo về test case đang được chạy
	    System.out.println("Testcase 1: Chức năng Export In ấn Số Giờ Quy Đổi theo Năm Học và chọn ngành Tất cả ");
	    // Đọc dữ liệu từ file excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	 
	    // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến NH
	    String NH = row.getCell(2).getStringCellValue();
	    
	    // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNH
	    String stringNH = row.getCell(3).getStringCellValue();
	    
	    // Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến stringNganh
	    String stringNganh = row.getCell(4).getStringCellValue();
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
	    
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
	    
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Chuyển đến tab dữ liệu bảng
	    driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();

	    // Nhấn vào nút in
	    WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_wrapper\"]/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(1000);
	    
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(
	            By.xpath("//*[@id=\"tblStatistics_wrapper\"]/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", printOptionElement);

	    // Tạo một đối tượng Robot để tương tác với bàn phím
	    Robot robot = new Robot();
	    // Tìm và xác nhận phần tử hiển thị số lượng bản ghi
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
	    
	    // Kiểm tra nếu phần tử hiển thị chứa chuỗi "Hiển thị"
	    if (confirmElement.getText().contains("Hiển thị")) {
	        // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	        Thread.sleep(2000);
	        
	        // Nhấn ENTER để xác nhận in
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(2000);
	        
	        // Nhấn phím CONTROL + C để sao chép dữ liệu
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_C);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_C);
	        Thread.sleep(2000);
	        
	        // Nhấn ENTER để xác nhận sao chép dữ liệu
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        
	        // Lấy dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);

	        // In ra kết quả mong đợi và kết quả thực tế
	        System.out.println("Kết quả mong đợi: ThongKeChiTietSoGio_NH" + stringNH + "_Nganh_" + stringNganh + ".pdf");
	        System.out.println("Kết quả thực tế: " + duLieu);

	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    
	    // Làm mới trang web
	    driver.navigate().refresh();
	}

	@Test(priority = 2)
	// Phương thức kiểm tra chức năng xuất dữ liệu thứ hai
	public void Export2() throws IOException, InterruptedException, UnsupportedFlavorException {
	    // In ra thông báo về test case đang được chạy
	    System.out.println("Testcase 2: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Năm học và chọn ngành Tất cả");
	    
	    // Đọc dữ liệu từ file excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    
	    // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến NH
	    String NH = row.getCell(2).getStringCellValue();
	    
	    // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNH
	    String stringNH = row.getCell(3).getStringCellValue();
	    
	    // Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến stringNganh
	    String stringNganh = row.getCell(4).getStringCellValue();
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
	    
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
	    
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
	    
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
	    
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
	    
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
	    
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Chuyển đến tab dữ liệu bảng
	    driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();

	    // Nhấn vào nút in
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(1000);
	    
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(
	            By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
	    Thread.sleep(2000);
	    printOptionElement.click();
	    Thread.sleep(300);
	    
	    // Lấy thông báo kết quả
	    WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
	    String dulieuString = thongbaoElement.getText();

	    // Sao chép dữ liệu từ bảng
	    WebElement bangdulieuElement = driver.findElement(By.xpath(
	            "//*[@id=\"tblStatistics\"]/tbody"));
	    String dulieumongdoiString = bangdulieuElement.getText();

	    // Xác nhận đã vào giao diện bảng biểu
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
	    if (confirmElement.getText().contains("Hiển thị")) {
	        // Lấy dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
	        // In ra thông báo kết quả
	        System.out.println(dulieuString);
	        System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
	        System.out.println("Kết quả thực tế: " + duLieu);

	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    // Làm mới trang web
	    driver.navigate().refresh();
	}
//	@Test (priority = 3)
//	public void Export3() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 3: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Năm học và chọn 1 ngành");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		String NH = row.getCell(2).getStringCellValue();
//		String stringNH = row.getCell(3).getStringCellValue();
//		String stringNganh = row.getCell(4).getStringCellValue();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
//
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(1000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatistics\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//	}
//	@Test (priority = 4)
//	public void Export4() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
//
//		System.out.println("Testcase 4: Chức năng Export In ấn Số Giờ Quy Đổi theo Năm học và chọn 1 ngành ");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String NH = row.getCell(2).getStringCellValue();
//		String stringNH = row.getCell(3).getStringCellValue();
//		String stringNganh = row.getCell(4).getStringCellValue();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
//		WebElement printElement = driver
//				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(1000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//		printOptionElement.click();
//		Robot robot = new Robot();
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_C);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_C);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//			System.out
//					.println("Kết quả mong đợi: ThongKeChiTietSoGio_NH" + stringNH + "_Nganh_" + stringNganh + ".pdf");
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//
//	}
	@Test(priority = 3)
	// Phương thức kiểm tra chức năng xuất dữ liệu thứ ba
	public void Export3() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {

	    // In ra thông báo về test case đang được chạy
	    System.out.println("Testcase 3: Chức năng Export In ấn Số Giờ Quy Đổi theo Năm học và chọn ngành Tất cả và chọn xem theo ca giảng");
	    
	    // Đọc dữ liệu từ file excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    
	    // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến NH
	    String NH = row.getCell(2).getStringCellValue();
	    
	    // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNH
	    String stringNH = row.getCell(3).getStringCellValue();
	    
	    // Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến stringNganh
	    String stringNganh = row.getCell(4).getStringCellValue();
	    
	    // Nhấn vào checkbox chọn xem theo ca giảng
	    driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
	    
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
	    
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
	    
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
	    
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
	    
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
	    
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Chuyển đến tab dữ liệu bảng
	    driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();

	    // Nhấn vào nút in
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(1000);
	    
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(
	            By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
	    printOptionElement.click();

	    // Tạo một đối tượng Robot để tương tác với bàn phím
	    Robot robot = new Robot();
	    
	    // Tìm và xác nhận phần tử hiển thị số lượng bản ghi
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
	    
	    // Kiểm tra nếu phần tử hiển thị chứa chuỗi "Hiển thị"
	    if (confirmElement.getText().contains("Hiển thị")) {

	        // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	        Thread.sleep(2000);
	        
	        // Nhấn ENTER để xác nhận in
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(2000);
	        
	        // Nhấn phím CONTROL + C để sao chép dữ liệu
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_C);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_C);
	        Thread.sleep(2000);
	        
	        // Nhấn ENTER để xác nhận sao chép dữ liệu
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        
	        // In dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);

	        // In ra kết quả mong đợi và kết quả thực tế
	        System.out.println("Kết quả mong đợi: ThongKeChiTietSoGio_NH" + stringNH + "_Nganh_" + stringNganh + ".pdf");
	        System.out.println("Kết quả thực tế: " + duLieu);

	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    
	    // Làm mới trang web
	    driver.navigate().refresh();
	}

	@Test(priority = 4)
	// Phương thức kiểm tra chức năng xuất dữ liệu thứ tư
	public void Export4() throws IOException, InterruptedException, UnsupportedFlavorException {

	    // In ra thông báo về test case đang được chạy
	    System.out.println("Testcase 4: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Năm học và chọn ngành Tất cả và chọn xem theo ca giảng");
	    
	    // Đọc dữ liệu từ file excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    
	    // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến NH
	    String NH = row.getCell(2).getStringCellValue();
	    
	    // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNH
	    String stringNH = row.getCell(3).getStringCellValue();
	    
	    // Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến stringNganh
	    String stringNganh = row.getCell(4).getStringCellValue();
	    
	    // Nhấn vào checkbox chọn xem theo ca giảng
	    driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
	    
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
	    
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
	    
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
	    
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
	    
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
	    
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    
	    // Tạm dừng chương trình để chờ cho các hoạt động trên trang web hoàn thành
	    Thread.sleep(2000);
	    
	    // Chuyển đến tab dữ liệu bảng
	    driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();

	    // Nhấn vào nút in
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(1000);
	    
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(
	            By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
	    Thread.sleep(2000);
	    printOptionElement.click();
	    Thread.sleep(300);
	    
	    // Đọc thông báo
	    WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
	    String dulieuString = thongbaoElement.getText();

	    // Sao chép dữ liệu bảng
	    WebElement bangdulieuElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
	    String dulieumongdoiString = bangdulieuElement.getText();

	    // Xác nhận đã vào giao diện bảng biểu
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
	    if (confirmElement.getText().contains("Hiển thị")) {
	        // Đọc dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
	        System.out.println(dulieuString);
	        System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
	        System.out.println("Kết quả thực tế: " + duLieu);

	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    
	    // Làm mới trang web
	    driver.navigate().refresh();
	}
//	@Test (priority = 7)
//	public void Export7() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 7: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Năm học và chọn 1 ngành và chọn xem theo ca giảng");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		String NH = row.getCell(2).getStringCellValue();
//		String stringNH = row.getCell(3).getStringCellValue();
//		String stringNganh = row.getCell(4).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
//
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(1000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatistics\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//	}
//	@Test (priority = 8)
//	public void Export8() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
//
//		System.out.println("Testcase 8: Chức năng Export In ấn Số Giờ Quy Đổi theo Năm học và chọn 1 ngành và chọn xem theo ca giảng ");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		String NH = row.getCell(2).getStringCellValue();
//		String stringNH = row.getCell(3).getStringCellValue();
//		String stringNganh = row.getCell(4).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
//
//		WebElement printElement = driver
//				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(1000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//		printOptionElement.click();
//
//		Robot robot = new Robot();
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_C);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_C);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//			System.out
//					.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringNH + "_Nganh_" + stringNganh + ".pdf");
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//	}
	@Test(priority = 5)
	public void Export5() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
	    System.out.println("Testcase 5: Chức năng Export In ấn Số Giờ Quy Đổi theo Năm học và chọn ngành Tất Cả và chọn mục Chi Tiết");
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    String NH = row.getCell(2).getStringCellValue();
	    String stringNH = row.getCell(3).getStringCellValue();
	    String stringNganh = row.getCell(4).getStringCellValue();
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Chuyển đến tab Chi Tiết
	    driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
	    Thread.sleep(2000);
	    // Nhấn vào nút in
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(2000);
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
	    printOptionElement.click();
	    Robot robot = new Robot();
	    // Xác nhận đã vào giao diện bảng biểu chi tiết
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
	    if (confirmElement.getText().contains("Hiển thị")) {
	        Thread.sleep(2000);
	        // Nhấn ENTER để chọn tất cả
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(2000);
	        // Sao chép dữ liệu
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_C);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_C);
	        Thread.sleep(2000);
	        // Nhấn ENTER để thoát
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        // In dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
	        System.out.println("Kết quả mong đợi: ThongKeChiTietSoGio_NH" + stringNH + "_Nganh_" + stringNganh + ".pdf");
	        System.out.println("Kết quả thực tế: " + duLieu);
	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    driver.navigate().refresh();
	}
	@Test(priority = 6)
	public void Export6() throws IOException, InterruptedException, UnsupportedFlavorException {
	    System.out.println("Testcase 6: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Năm học và chọn ngành Tất cả và chọn mục Chi Tiết");
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    String NH = row.getCell(2).getStringCellValue();
	    String stringNH = row.getCell(3).getStringCellValue();
	    String stringNganh = row.getCell(4).getStringCellValue();
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Chuyển đến tab Chi Tiết
	    driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
	    // Print
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(2000);
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
	    Thread.sleep(2000);
	    printOptionElement.click();
	    Thread.sleep(300);
	    WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
	    String dulieuString = thongbaoElement.getText();
	    // Sao chép table
	    WebElement bangdulieuElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails\"]/tbody"));
	    String dulieumongdoiString = bangdulieuElement.getText();
	    // Xác nhận đã vào giao diện bảng biểu
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
	    if (confirmElement.getText().contains("Hiển thị")) {
	        // In dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
	        System.out.println(dulieuString);
	        System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
	        System.out.println("Kết quả thực tế: " + duLieu);
	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    driver.navigate().refresh();
	}
//	@Test (priority =11)
//	public void Export11() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 11: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Năm học và chọn 1 ngành và chọn mục Chi Tiết");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		String NH = row.getCell(2).getStringCellValue();
//		String stringNH = row.getCell(3).getStringCellValue();
//		String stringNganh = row.getCell(4).getStringCellValue();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatisticsDetails\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//	}
//	@Test (priority =12)
//	public void Export12() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
//
//		System.out.println("Testcase 12: Chức năng Export In ấn Số Giờ Quy Đổi theo Năm học và chọn 1 ngành và chọn mục Chi Tiết ");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		String NH = row.getCell(2).getStringCellValue();
//		String stringNH = row.getCell(3).getStringCellValue();
//		String stringNganh = row.getCell(4).getStringCellValue();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//
//		WebElement printElement = driver
//				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//		printOptionElement.click();	
//
//		Robot robot = new Robot();
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_C);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_C);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//			System.out
//					.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringNH + "_Nganh_" + stringNganh + ".pdf");
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//	}
	@Test(priority = 7)
	public void Export7() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
	    System.out.println("Testcase 7: Chức năng Export In ấn Số Giờ Quy Đổi theo Năm học và chọn ngành Tất Cả và chọn mục Chi Tiết và xem theo ca giảng");
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    String NH = row.getCell(2).getStringCellValue();
	    String stringNH = row.getCell(3).getStringCellValue();
	    String stringNganh = row.getCell(4).getStringCellValue();
	    // Nhấn vào checkbox chọn xem theo ca giảng
	    driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Chuyển đến tab Chi Tiết
	    driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(2000);
	    WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
	    printOptionElement.click(); 
	    Robot robot = new Robot();
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
	    if (confirmElement.getText().contains("Hiển thị")) {
	        Thread.sleep(2000);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(2000);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_C);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_C);
	        Thread.sleep(2000);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        // In dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
	        System.out.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringNH + "_Nganh_" + stringNganh + ".pdf");
	        System.out.println("Kết quả thực tế: " + duLieu);
	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    driver.navigate().refresh();
	}

	@Test(priority = 8)
	public void Export8() throws IOException, InterruptedException, UnsupportedFlavorException {
	    System.out.println("Testcase 8: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Năm học và chọn ngành Tất cả và chọn mục Chi Tiết và xem theo ca giảng");
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    String NH = row.getCell(2).getStringCellValue();
	    String stringNH = row.getCell(3).getStringCellValue();
	    String stringNganh = row.getCell(4).getStringCellValue();
	    // Nhấn vào checkbox chọn xem theo ca giảng
	    driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
	    // Nhập giá trị năm học vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
	    // Nhấn ENTER để chọn năm học
	    driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Chuyển đến tab Chi Tiết
	    driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
	    // Print
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(2000);
	    WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
	    Thread.sleep(2000);
	    printOptionElement.click();
	    Thread.sleep(300);
	    WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
	    String dulieuString = thongbaoElement.getText();
	    // Sao chép table
	    WebElement bangdulieuElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails\"]/tbody"));
	    String dulieumongdoiString = bangdulieuElement.getText();
	    // Xác nhận đã vào giao diện bảng biểu
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
	    if (confirmElement.getText().contains("Hiển thị")) {
	        // In dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
	        System.out.println(dulieuString);
	        System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
	        System.out.println("Kết quả thực tế: " + duLieu);
	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    driver.navigate().refresh();
	}
//	@Test (priority = 15)
//	public void Export15() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 15: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Năm học và chọn 1 ngành và chọn mục Chi Tiết");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		String NH = row.getCell(2).getStringCellValue();
//		String stringNH = row.getCell(3).getStringCellValue();
//		String stringNganh = row.getCell(4).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatisticsDetails\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//	}
//	@Test (priority = 16)
//	public void Export16() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
//
//		System.out.println("Testcase 16: Chức năng Export In ấn Số Giờ Quy Đổi theo Năm học và chọn 1 ngành và chọn mục Chi Tiết");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		String NH = row.getCell(2).getStringCellValue();
//		String stringNH = row.getCell(3).getStringCellValue();
//		String stringNganh = row.getCell(4).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-unit-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(NH);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[1]/span[1]/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringNH);
//		driver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(stringNganh);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//
//		WebElement printElement = driver
//				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//		printOptionElement.click();	
//
//		Robot robot = new Robot();
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_C);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_C);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//			System.out
//					.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringNH + "_Nganh_" + stringNganh + ".pdf");
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//
//	}

}