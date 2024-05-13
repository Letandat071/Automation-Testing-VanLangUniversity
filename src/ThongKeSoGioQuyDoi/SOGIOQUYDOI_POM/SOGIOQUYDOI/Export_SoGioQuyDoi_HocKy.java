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
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
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

import PageSetup.Setup;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Export_SoGioQuyDoi_HocKy {
	static WebDriver driver;

	@BeforeTest
	public void Main() throws IOException, InterruptedException {

		Setup setup = new Setup(); 
		driver = setup.setup();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		
	}
	 @Test(priority = 1)
	    // Phương thức kiểm tra chức năng xuất dữ liệu
	    public void Export1() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {

	        // In ra thông báo về test case đang được chạy
	        System.out.println("Testcase 1: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả ");
	        // Đọc dữ liệu từ file excel
	        FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheetAt(0);
	        XSSFRow row = sheet.getRow(0);
	        // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến stringHK
	        String stringHK = row.getCell(0).getStringCellValue();

	        // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNganh
	        String stringNganh = row.getCell(1).getStringCellValue();
	        Thread.sleep(2000);
	        // Nhấn vào dropdown chọn học kỳ
	        driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
	        // Nhập giá trị học kỳ vào ô tìm kiếm
	        driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
	        // Nhấn ENTER để chọn học kỳ
	        driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	        Thread.sleep(2000);
	        // Nhấn vào dropdown chọn ngành học
	        driver.findElement(By.xpath(
	                "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
	                .click();
	        // Nhập giá trị ngành học vào ô tìm kiếm
	        driver.findElement(By.xpath(
	                "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	                .sendKeys(stringNganh);
	        // Nhấn ENTER để chọn ngành học
	        driver.findElement(By.xpath(
	                "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	                .sendKeys(Keys.ENTER);
	        Thread.sleep(2000);
	        // Chuyển đến tab bảng
	        driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();

	        // Nhấn vào nút in
	        WebElement printElement = driver
	                .findElement(By.xpath("//*[@id=\"tblStatistics_wrapper\"]/div[1]/div[2]/div/div[2]/button"));
	        printElement.click();
	        Thread.sleep(1000);
	        // Chọn tùy chọn in
	        WebElement printOptionElement = driver.findElement(
	                By.xpath("//*[@id=\"tblStatistics_wrapper\"]/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", printOptionElement);

	        // Tạo đối tượng Robot để điều khiển bàn phím và chuột
	        Robot robot = new Robot();
	        // Tìm phần tử xác nhận
	        WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
	        if (confirmElement.getText().contains("Hiển thị")) {

	            Thread.sleep(2000);
	            // Nhấn ENTER để xác nhận
	            robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);
	            Thread.sleep(2000);
	            // Sao chép dữ liệu từ clipboard
	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_C);
	            robot.keyRelease(KeyEvent.VK_CONTROL);
	            robot.keyRelease(KeyEvent.VK_C);
	            Thread.sleep(2000);
	            // Nhấn ENTER để xác nhận
	            robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);
	            // Lấy dữ liệu từ clipboard
	            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	            String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);

	            // In ra kết quả mong đợi
	            System.out.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
	            // In ra kết quả thực tế
	            System.out.println("Kết quả thực tế: " + duLieu);

	        } else {
	            System.out.println("Xem thất bại!!");
	        }
	        // Làm mới trang
	        driver.navigate().refresh();
	    }

	 @Test(priority = 2)
	// Phương thức kiểm tra chức năng xuất dữ liệu thứ hai
	public void Export2() throws IOException, InterruptedException, UnsupportedFlavorException {
	    // In ra thông báo về test case đang được chạy
	    System.out.println("Testcase 2: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả");
	    // Đọc dữ liệu từ file excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến stringHK
	    String stringHK = row.getCell(0).getStringCellValue();
	    // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNganh
	    String stringNganh = row.getCell(1).getStringCellValue();
	    // Nhấn vào dropdown chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
	    // Nhập giá trị học kỳ vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
	    // Nhấn ENTER để chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
	            .click();
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(stringNganh);
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Chuyển đến tab bảng
	    driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();

	    // In
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(1000);
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(
	            By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
	    Thread.sleep(2000);
	    printOptionElement.click();
	    Thread.sleep(300);
	    // Lấy thông báo
	    WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
	    String dulieuString = thongbaoElement.getText();

	    // Sao chép bảng dữ liệu
	    WebElement bangdulieuElement = driver.findElement(By.xpath(
	            "//*[@id=\"tblStatistics\"]/tbody"));
	    String dulieumongdoiString = bangdulieuElement.getText();

	    // Xác nhận đã vào giao diện bảng biểu
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
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
	    // Làm mới trang
	    driver.navigate().refresh();
	}
	
	 @Test(priority = 3)
	// Phương thức kiểm tra chức năng xuất dữ liệu thứ ba
	public void Export3() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
	    // In ra thông báo về test case đang được chạy
	    System.out.println("Testcase 3: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả và xem theo ca giảng");
	    // Đọc dữ liệu từ file excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến stringHK
	    String stringHK = row.getCell(0).getStringCellValue();

	    // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNganh
	    String stringNganh = row.getCell(1).getStringCellValue();
	    // Nhấn vào checkbox "Xem theo ca giảng"
	    driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
	    // Nhập giá trị học kỳ vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
	    // Nhấn ENTER để chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
	            .click();
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(stringNganh);
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Chuyển đến tab bảng
	    driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();

	    // Print
	    WebElement printElement = driver
	            .findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(1000);
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(
	            By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
	    printOptionElement.click();

	    // Tạo một đối tượng Robot để điều khiển bàn phím và clipboard
	    Robot robot = new Robot();
	    // Xác nhận đã vào giao diện bảng biểu
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
	    if (confirmElement.getText().contains("Hiển thị")) {
	        // Nhấn ENTER để xác nhận in
	        Thread.sleep(2000);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(2000);
	        // Sao chép dữ liệu từ bảng
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_C);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_C);
	        Thread.sleep(2000);
	        // Nhấn ENTER để xác nhận sao chép
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        // Lấy dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);

	        // In ra kết quả mong đợi và kết quả thực tế
	        System.out.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
	        System.out.println("Kết quả thực tế: " + duLieu);

	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    // Làm mới trang
	    driver.navigate().refresh();
	}

	 @Test(priority = 4)
	// Phương thức kiểm tra chức năng xuất dữ liệu thứ tư
	public void Export4() throws IOException, InterruptedException, UnsupportedFlavorException {
	    // In ra thông báo về test case đang được chạy
	    System.out.println("Testcase 4: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả và xem theo ca giảng");
	    // Đọc dữ liệu từ file excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến stringHK
	    String stringHK = row.getCell(0).getStringCellValue();
	    // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNganh
	    String stringNganh = row.getCell(1).getStringCellValue();
	    // Nhấn vào checkbox "Xem theo ca giảng"
	    driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
	    // Nhập giá trị học kỳ vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
	    // Nhấn ENTER để chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
	            .click();
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(stringNganh);
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Chuyển đến tab bảng
	    driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();

	    // Print
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(1000);
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(
	            By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
	    Thread.sleep(2000);
	    printOptionElement.click();
	    Thread.sleep(300);
	    // Lấy thông báo sau khi sao chép
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
	        // In ra thông báo và kết quả mong đợi và thực tế
	        System.out.println(dulieuString);
	        System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
	        System.out.println("Kết quả thực tế: " + duLieu);

	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    // Làm mới trang
	    driver.navigate().refresh();
	}
	 @Test(priority = 5)
	// Phương thức kiểm tra chức năng xuất dữ liệu thứ năm
	public void Export5() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
	    // In ra thông báo về test case đang được chạy
	    System.out.println("Testcase 5: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất Cả và chọn mục Chi Tiết");
	    // Đọc dữ liệu từ file excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến stringHK
	    String stringHK = row.getCell(0).getStringCellValue();
	    // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNganh
	    String stringNganh = row.getCell(1).getStringCellValue();
	    // Nhấn vào dropdown chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
	    // Nhập giá trị học kỳ vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
	    // Nhấn ENTER để chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
	            .click();
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(stringNganh);
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(Keys.ENTER);
	    Thread.sleep(4000);
	    // Chuyển đến tab chi tiết
	    driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
	    Thread.sleep(2000);
	    // Nhấn vào nút in
	    WebElement printElement = driver
	            .findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(2000);
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(
	            By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
	    printOptionElement.click();
	    
	    // Tạo đối tượng robot để tương tác với bảng
	    Robot robot = new Robot();
	    // Xác nhận đã vào giao diện bảng chi tiết
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
	    if (confirmElement.getText().contains("Hiển thị")) {
	        // Thực hiện sao chép và in dữ liệu từ bảng
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
	        // In ra thông báo và kết quả mong đợi và thực tế
	        System.out.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
	        System.out.println("Kết quả thực tế: " + duLieu);
	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    // Làm mới trang
	    driver.navigate().refresh();
	}

	 @Test(priority = 6)
	// Phương thức kiểm tra chức năng xuất dữ liệu thứ sáu
	public void Export6() throws IOException, InterruptedException, UnsupportedFlavorException {
	    // In ra thông báo về test case đang được chạy
	    System.out.println("Testcase 6: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả và chọn mục Chi Tiết");
	    // Đọc dữ liệu từ file excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến stringHK
	    String stringHK = row.getCell(0).getStringCellValue();
	    // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNganh
	    String stringNganh = row.getCell(1).getStringCellValue();
	    // Nhấn vào dropdown chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
	    // Nhập giá trị học kỳ vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
	    // Nhấn ENTER để chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
	            .click();
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(stringNganh);
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Chuyển đến tab chi tiết
	    driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
	    
	    // Print
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(2000);
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(
	            By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
	    Thread.sleep(2000);
	    printOptionElement.click();
	    Thread.sleep(300);
	    // Lấy thông báo sau khi in
	    WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
	    String dulieuString = thongbaoElement.getText();

	    // Sao chép bảng dữ liệu
	    WebElement bangdulieuElement = driver.findElement(By.xpath(
	            "//*[@id=\"tblStatisticsDetails\"]/tbody"));
	    String dulieumongdoiString = bangdulieuElement.getText();

	    // Xác nhận đã vào giao diện bảng biểu
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
	    if (confirmElement.getText().contains("Hiển thị")) {
	        // In dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
	        // In ra thông báo và kết quả mong đợi và thực tế
	        System.out.println(dulieuString);
	        System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
	        System.out.println("Kết quả thực tế: " + duLieu);

	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    // Làm mới trang
	    driver.navigate().refresh();
	}
	 @Test(priority = 7)
	// Phương thức kiểm tra chức năng xuất dữ liệu thứ bảy
	public void Export7() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
	    // In ra thông báo về test case đang được chạy
	    System.out.println("Testcase 7: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả và chọn mục Chi Tiết và xem theo ca giảng");
	    // Đọc dữ liệu từ file excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến stringHK
	    String stringHK = row.getCell(0).getStringCellValue();
	    // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNganh
	    String stringNganh = row.getCell(1).getStringCellValue();
	    // Nhấn vào checkbox "Xem theo ca giảng"
	    driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
	    // Nhập giá trị học kỳ vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
	    // Nhấn ENTER để chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
	            .click();
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(stringNganh);
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Chuyển đến tab chi tiết
	    driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();

	    // Print
	    WebElement printElement = driver
	            .findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
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
	        // Nhấn ENTER để lấy dữ liệu in
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(2000);
	        // Sao chép dữ liệu vào clipboard
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_C);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_C);
	        Thread.sleep(2000);
	        // Nhấn ENTER để hoàn tất
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        // In dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
	        // In ra thông báo và kết quả mong đợi và thực tế
	        System.out.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
	        System.out.println("Kết quả thực tế: " + duLieu);

	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    // Làm mới trang
	    driver.navigate().refresh();
	}

	 @Test(priority = 8)
	// Phương thức kiểm tra chức năng xuất dữ liệu thứ tám
	public void Export8() throws IOException, InterruptedException, UnsupportedFlavorException {
	    // In ra thông báo về test case đang được chạy
	    System.out.println("Testcase 8: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả và chọn mục Chi Tiết và xem theo ca giảng");
	    // Đọc dữ liệu từ file excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFRow row = sheet.getRow(0);
	    // Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến stringHK
	    String stringHK = row.getCell(0).getStringCellValue();
	    // Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến stringNganh
	    String stringNganh = row.getCell(1).getStringCellValue();
	    // Nhấn vào checkbox "Xem theo ca giảng"
	    driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
	    // Nhập giá trị học kỳ vào ô tìm kiếm
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
	    // Nhấn ENTER để chọn học kỳ
	    driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Nhấn vào dropdown chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
	            .click();
	    // Nhập giá trị ngành học vào ô tìm kiếm
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(stringNganh);
	    // Nhấn ENTER để chọn ngành học
	    driver.findElement(By.xpath(
	            "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
	            .sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    // Chuyển đến tab chi tiết
	    driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();

	    // Print
	    WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
	    printElement.click();
	    Thread.sleep(2000);
	    // Chọn tùy chọn in
	    WebElement printOptionElement = driver.findElement(
	            By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
	    Thread.sleep(2000);
	    printOptionElement.click();
	    Thread.sleep(300);
	    // Lấy thông báo
	    WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
	    String dulieuString = thongbaoElement.getText();

	    // Sao chép bảng dữ liệu
	    WebElement bangdulieuElement = driver.findElement(By.xpath(
	            "//*[@id=\"tblStatisticsDetails\"]/tbody"));
	    String dulieumongdoiString = bangdulieuElement.getText();

	    // Xác nhận đã vào giao diện bảng biểu chi tiết
	    WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
	    if (confirmElement.getText().contains("Hiển thị")) {
	        // In dữ liệu từ clipboard
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
	        // In ra thông báo và kết quả mong đợi và thực tế
	        System.out.println(dulieuString);
	        System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
	        System.out.println("Kết quả thực tế: " + duLieu);

	    } else {
	        System.out.println("Xem thất bại!!");
	    }
	    // Làm mới trang
	    driver.navigate().refresh();
	}

}
