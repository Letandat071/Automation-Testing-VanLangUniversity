import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DonGiaHeSo {
	static WebDriver driver;
	@BeforeTest 
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String profileString = "C:\\Users\\Phan_Hoang_Khang\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + profileString);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[2]/a/span")).click();
	}
//	@Test(priority = 0)
//	public void DGHS() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase1: sửa đơn giá của CTĐT tiêu chuẩn 'lưu'");
//	    // Mở file Excel để đọc dữ liệu
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(0);
//	    // Lấy giá trị ID từ file Excel và chuyển đổi thành chuỗi
//	    int idInt = (int) row.getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt sử dụng xpath
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[3]/a[1]/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);	    
//	    // Tạm dừng thread để đợi cho trình duyệt xử lý
//	    Thread.sleep(1500);	    
//	    // Xóa và nhập giá trị ID vào một trường trên trang web
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);	    
//	    // Click vào nút để thực hiện thao tác
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);	    
//	    // In ra kết quả thực tế là giá trị ID đã nhập
//	    System.out.println("Kết quả thực tế : " + idString);	    
//	    // Tìm và lấy thông báo popup
//	    WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    String popupText = popup.getText();	    
//	    // In ra kết quả mong đợi từ thông báo popup
//	    System.out.println("Kết quả mong đợi: " + popupText);	    
//	    // Tạm dừng để kiểm tra kết quả trước khi đóng workbook
//	    Thread.sleep(2000);	    
//	    // Đóng workbook
//	    workbook.close();
//	}


//	@Test(priority = 1)
//	public void DGHS1() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase2: sửa đơn giá của CTĐT tiêu chuẩn 'hủy'");
//	    // Mở file Excel để đọc dữ liệu
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(0);
//	    // Lấy giá trị ID từ file Excel và chuyển đổi thành chuỗi
//	    int idInt = (int) row.getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt sử dụng xpath
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[3]/a[1]/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    // Tạm dừng thread để đợi cho trình duyệt xử lý
//	    Thread.sleep(1500);
//	    // Xóa và nhập giá trị ID vào một trường trên trang web
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút để thực hiện thao tác hủy
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[1]")).click();
//	    Thread.sleep(1000);
//	    System.out.println("Kết quả mong đợi: " + idString);
//	    // Kiểm tra nếu có thông báo lỗi hiển thị
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).size() != 0) {
//	        // Lấy và in ra thông báo lỗi
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).getText();
//	        System.out.println("Hủy thất bại: " + ketquahienthiString);
//	    } else {
//	        // Nếu không có thông báo lỗi, lấy và in ra kết quả thực tế
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[1]/a")).getText();
//	        System.out.println("hủy sửa thành công : " + ketquahienthiString);
//	        Thread.sleep(2000);
//	    }
//	    // Đóng workbook
//	    workbook.close();
//	}


//	@Test(priority = 2)
//	public void DGHS2() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase3: sửa tất cả đơn giá của CTĐT tiêu chuẩn 'lưu'");
//	    // Mở file Excel để đọc dữ liệu
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(0);
//	    // Lấy giá trị ID từ file Excel và chuyển đổi thành chuỗi
//	    int idInt = (int) row.getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt sử dụng xpath
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/div/button/span"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    // Tạm dừng thread để đợi cho trình duyệt xử lý
//	    Thread.sleep(1500);
//	    // Nhập giá trị ID vào một trường trên trang web
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút 'Lưu' để thực hiện thao tác
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click(); 
//	    Thread.sleep(1500);
//	    // In ra kết quả mong đợi là giá trị ID đã nhập
//	    System.out.println("Kết quả mong đợi: " + idString);
//	    // Tìm và lấy thông báo popup
//	    WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    String popupText = popup.getText();
//	    // In ra kết quả thực tế từ thông báo popup
//	    System.out.println("kết quả thực tế: " + popupText);
//	    // Tạm dừng để kiểm tra kết quả trước khi tiếp tục
//	    Thread.sleep(2000);
//	}


//	@Test(priority = 3)
//	public void DGHS3() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase4: sửa tất cả đơn giá của CTĐT tiêu chuẩn 'hủy'");
//	    // Mở file Excel để đọc dữ liệu
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(0);
//	    // Lấy giá trị ID từ file Excel và chuyển đổi thành chuỗi
//	    int idInt = (int) row.getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt sử dụng xpath
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/div/button/span"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    // Tạm dừng thread để đợi cho trình duyệt xử lý
//	    Thread.sleep(1500);
//	    // Nhập giá trị ID vào một trường trên trang web
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút 'Lưu' để thực hiện thao tác
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[1]")).click();
//	    // In ra kết quả mong đợi là giá trị ID đã nhập
//	    System.out.println("Kết quả mong đợi: " + idString);
//	    // Kiểm tra nếu có thông báo lỗi hiển thị
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).size() != 0) {
//	        // Lấy và in ra thông báo lỗi
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).getText();
//	        System.out.println("Hủy thất bại: " + ketquahienthiString);
//	    } else {
//	        // Nếu không có thông báo lỗi, lấy và in ra kết quả thực tế
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[1]/a")).getText();
//	        System.out.println("Hủy sửa thành công " + ketquahienthiString);
//	        Thread.sleep(2000);
//	    }
//	}


//	@Test(priority = 4)
//	public void DGHS4() throws InterruptedException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase5: xóa đơn giá của CTĐT tiêu chuẩn 'lưu'");
//	    // Tạm dừng thread để đợi trước khi thực hiện các thao tác
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt sử dụng xpath
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[3]/a[2]/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    // Tạm dừng thread để đợi cho trình duyệt xử lý
//	    Thread.sleep(1500);
//	    // Click vào nút xác nhận xóa
//	    driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
//	    // Tạm dừng để lấy và in ra kết quả thực tế từ thông báo popup
//	    Thread.sleep(1500);
//	    WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    String popupText = popup.getText();
//	    System.out.println("kết quả thực tế: " + popupText);
//	    // Tạm dừng để kiểm tra kết quả trước khi tiếp tục
//	    Thread.sleep(2000);
//	}

	
//	@Test(priority = 5)
//	public void DGHS5() throws InterruptedException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase6: xóa đơn giá của CTĐT tiêu chuẩn 'hủy'");
//	    // Tạm dừng thread để đợi trước khi thực hiện các thao tác
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt sử dụng xpath
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/table/tbody/tr[12]/td[3]/a[2]/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    // Tạm dừng thread để đợi cho trình duyệt xử lý
//	    Thread.sleep(1500);
//	    // Click vào nút xác nhận xóa
//	    driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")).click();
//	    // Kiểm tra nếu có thông báo lỗi hiển thị
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).size() != 0) {
//	        // Lấy và in ra thông báo lỗi
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).getText();
//	        System.out.println("Xóa thất bại: " + ketquahienthiString);
//	    } else {
//	        // Nếu không có thông báo lỗi, lấy và in ra kết quả thực tế
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[1]/a")).getText();
//	        System.out.println("Hủy thành công " + ketquahienthiString);
//	        Thread.sleep(2000);
//	    }
//	}


//	@Test(priority = 6)
//	public void DGHS6() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase7: sửa đơn giá của CTĐT đặc biệt 'lưu'");
//	    // Mở file Excel để đọc dữ liệu
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    int idInt = (int) sheet.getRow(0).getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn CTĐT đặc biệt
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để sửa đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/table/tbody/tr[1]/td[3]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa và nhập giá trị ID vào một trường trên trang web
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút để thực hiện thao tác
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra kết quả mong đợi là giá trị ID
//	    System.out.println("Kết quả mong đợi: " + idString);
//	    // Tìm và lấy thông báo popup
//	    WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    String popupText = popup.getText();
//	    // In ra kết quả thực tế từ thông báo popup
//	    System.out.println("kết quả thực tế: " + popupText);
//	    // Tạm dừng để kiểm tra kết quả trước khi tiếp tục
//	    Thread.sleep(2000);
//	}


//	@Test(priority = 7)
//	public void DGHS7() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase8: sửa đơn giá của CTĐT đặc biệt 'hủy'");
//	    // Mở file Excel để đọc dữ liệu
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    int idInt = (int) sheet.getRow(0).getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn CTĐT đặc biệt
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để sửa đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/table/tbody/tr[1]/td[3]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa và nhập giá trị ID vào một trường trên trang web
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút để thực hiện thao tác
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[1]")).click();
//	    Thread.sleep(1500);
//	    // In ra kết quả mong đợi là giá trị ID
//	    System.out.println("Kết quả mong đợi: " + idString);
//	    // Kiểm tra nếu có thông báo lỗi hiển thị
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).size() != 0) {
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).getText();
//	        System.out.println("Hủy thất bại: " + ketquahienthiString);
//	    } else {
//	        // Nếu không có thông báo lỗi, in ra thông báo thành công
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[2]/a")).getText();
//	        System.out.println("Hủy sửa thành công " + ketquahienthiString);
//	        Thread.sleep(2000);
//	    }
//	}

	
//	@Test(priority = 8)
//	public void DGHS8() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase9: sửa tất cả đơn giá của CTĐT đặc biệt 'Lưu'");
//	    // Mở file Excel để đọc dữ liệu
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    int idInt = (int) sheet.getRow(0).getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn CTĐT đặc biệt
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để sửa tất cả đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/button"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa và nhập giá trị ID vào một trường trên trang web
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút để thực hiện thao tác
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra kết quả mong đợi là giá trị ID
//	    System.out.println("Kết quả mong đợi: " + idString);
//	    // Tìm và lấy thông báo popup
//	    WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    String popupText = popup.getText();
//	    // In ra kết quả thực tế từ thông báo popup
//	    System.out.println("kết quả thực tế: " + popupText);
//	    // Tạm dừng để kiểm tra kết quả trước khi tiếp tục
//	    Thread.sleep(2000);
//	}

	
//	@Test(priority = 9)
//	public void DGHS9() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase10: sửa tất cả đơn giá của CTĐT đặc biệt 'hủy'");
//	    // Mở file Excel để đọc dữ liệu
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    int idInt = (int) sheet.getRow(0).getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn CTĐT đặc biệt
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để sửa tất cả đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/button"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa và nhập giá trị ID vào một trường trên trang web
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút để thực hiện thao tác
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[1]")).click();
//	    Thread.sleep(1500);
//	    // In ra kết quả mong đợi là giá trị ID
//	    System.out.println("Kết quả mong đợi: " + idString);
//	    // Kiểm tra nếu có thông báo lỗi xuất hiện
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).size() != 0) {
//	        // Lấy và in ra thông báo lỗi
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).getText();
//	        System.out.println("Hủy thất bại: " + ketquahienthiString);
//	    } else {
//	        // Nếu không có thông báo lỗi, in ra kết quả thực tế
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[2]/a")).getText();
//	        System.out.println("Hủy sửa tất cả thành công : " + ketquahienthiString);
//	        Thread.sleep(2000);
//	    }
//	}


	
//	@Test(priority = 10)
//	public void DGHS10() throws InterruptedException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase11: xóa đơn giá của CTĐT đặc biệt 'lưu'");
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn CTĐT đặc biệt
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để xóa đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/table/tbody/tr[1]/td[3]/a[2]/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Click vào nút để xác nhận xóa đơn giá
//	    driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
//	    Thread.sleep(1500);
//	    // Lấy và in ra thông báo kết quả thực tế từ popup
//	    WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    String popupText = popup.getText();
//	    System.out.println("kết quả thực tế: " + popupText);
//	    Thread.sleep(2000);
//	}


	
//	@Test(priority = 11)
//	public void DGHS11() throws InterruptedException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase12: xóa đơn giá của CTĐT đặc biệt 'hủy'");
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn CTĐT đặc biệt
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để xóa đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/table/tbody/tr[1]/td[3]/a[2]/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Click vào nút để hủy xóa đơn giá
//	    driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")).click();
//	    Thread.sleep(1500);
//	    // Kiểm tra xem có thông báo lỗi hiển thị hay không
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).size() != 0) {
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).getText();
//	        System.out.println("Hủy thất bại: " + ketquahienthiString);
//	    } else {
//	        // Nếu không có thông báo lỗi, in ra thông báo thành công
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[2]/a")).getText();
//	        System.out.println("Hủy xóa thành công " + ketquahienthiString);
//	        Thread.sleep(2000);
//	    }
//	}


//	@Test(priority = 12)
//	public void DGHS12() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase13: sửa đơn giá của người nước ngoài 'lưu'");
//	    // Đọc dữ liệu từ file Excel
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Lấy giá trị ID từ file Excel
//	    int idInt = (int) sheet.getRow(0).getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn người nước ngoài
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[3]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để sửa đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[3]/div/table/tbody/tr[1]/td[3]/a[1]/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung hiện tại của ô nhập liệu và nhập ID mới
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút 'Lưu' để lưu thay đổi
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra kết quả mong đợi và kết quả thực tế từ popup
//	    System.out.println("Kết quả mong đợi: " + idString);
//	    WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    String popupText = popup.getText();
//	    System.out.println("kết quả thực tế: " + popupText);
//	    Thread.sleep(2000);
//	}

	
	
//	@Test(priority = 13)
//	public void DGHS13() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase14: sửa đơn giá của người nước ngoài 'hủy'");
//	    // Đọc dữ liệu từ file Excel
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Lấy giá trị ID từ file Excel
//	    int idInt = (int) sheet.getRow(0).getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn người nước ngoài
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[3]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để sửa đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[3]/div/table/tbody/tr[1]/td[3]/a[1]/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung hiện tại của ô nhập liệu và nhập ID mới
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút 'Hủy' để hủy bỏ thay đổi
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[1]")).click();
//	    Thread.sleep(1500);
//	    // In ra kết quả mong đợi và kiểm tra kết quả thực tế từ popup
//	    System.out.println("Kết quả mong đợi: " + idString);
//	    if(driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).size() != 0) {
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).getText();
//	        System.out.println("Hủy thất bại: " + ketquahienthiString);
//	    } else {
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[3]/a")).getText();
//	        System.out.println("Hủy sửa thành công " + ketquahienthiString);
//	        Thread.sleep(2000);
//	    }
//	}


	
//	@Test(priority = 14)
//	public void DGHS14() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase15: sửa tất cả đơn giá của người nước ngoài 'lưu'");
//	    // Đọc dữ liệu từ file Excel
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Lấy giá trị ID từ file Excel
//	    int idInt = (int) sheet.getRow(0).getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn người nước ngoài
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[3]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để sửa đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[3]/div/div/button/span"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Nhập ID vào ô nhập liệu
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút 'Lưu' để lưu thay đổi
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra kết quả mong đợi và kiểm tra kết quả thực tế từ popup
//	    System.out.println("Kết quả mong đợi: " + idString);
//	    WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    String popupText = popup.getText();
//	    System.out.println("kết quả thực tế: " + popupText);
//	    Thread.sleep(2000);
//	}

	
//	@Test(priority = 15)
//	public void DGHS15() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase16: sửa tất cả đơn giá của người nước ngoài 'hủy'");
//	    // Đọc dữ liệu từ file Excel
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Lấy giá trị ID từ file Excel
//	    int idInt = (int) sheet.getRow(0).getCell(0).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn người nước ngoài
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[3]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để sửa đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[3]/div/div/button/span"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Nhập ID vào ô nhập liệu
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút 'Hủy' để hủy thay đổi
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[1]")).click();
//	    System.out.println("Kết quả đầu vào: " + idString);
//	    // Kiểm tra kết quả thực tế từ popup
//	    if(driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).size() != 0) {
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).getText();
//	        System.out.println("Hủy thất bại: " + ketquahienthiString);
//	    } else {
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[3]/a")).getText();
//	        System.out.println("Hủy sửa tất cả thành công : " + ketquahienthiString);
//	        Thread.sleep(2000);
//	    }
//	}


	
//	@Test(priority = 16)
//	public void DGHS16() throws InterruptedException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase17: xóa đơn giá của người nước ngoài 'lưu'");
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn người nước ngoài
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[3]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để xóa đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[3]/div/table/tbody/tr[2]/td[3]/a[2]/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Click vào nút 'Lưu' trên popup để xác nhận xóa
//	    driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
//	    Thread.sleep(1500);
//	    // Lấy thông báo kết quả thực tế từ popup
//	    WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    String popupText = popup.getText();
//	    System.out.println("Kết quả thực tế: " + popupText);
//	    Thread.sleep(2000);
//	}

	
//	@Test(priority = 17)
//	public void DGHS17() throws InterruptedException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("TestCase18: xóa đơn giá của người nước ngoài 'hủy'");
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn người nước ngoài
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[3]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để xóa đơn giá
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[3]/div/table/tbody/tr[1]/td[3]/a[2]/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Click vào nút 'Hủy' trên popup để hủy xóa
//	    driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")).click();
//	    Thread.sleep(1500);
//	    // Kiểm tra xem có thông báo hiển thị về việc hủy không
//	    if(driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).size() != 0) {
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/label")).getText();
//	        System.out.println("Hủy thất bại: " + ketquahienthiString);
//	    } else {
//	        String ketquahienthiString = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[3]/a")).getText();
//	        System.out.println("Hủy xóa thành công " + ketquahienthiString);
//	        Thread.sleep(2000);
//	    }
//	}


//	@Test(priority = 18)
//	public void DGHS18() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase19: lưu hệ số tiếng việt >1 và <9.99");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(1).getNumericCellValue();
//	    // Chuyển giá trị đọc được sang kiểu chuỗi
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(2000);
//	    // In ra giá trị mong đợi
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    // Kiểm tra xem có hiển thị popup hay không
//	    WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    if (popup != null) {
//	        // Nếu hiển thị popup thì in ra nội dung của popup
//	        String popupText = popup.getText();
//	        System.out.println("Nội dung của popup là: " + popupText);
//	    } else {
//	        // Nếu không hiển thị popup thì in ra thông báo thực tế
//	        String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/label[2]")).getText();
//	        System.out.println("kết quả thực tế: " + ketquahienthistrString);
//	    }
//	}


	
//	@Test(priority = 19)
//	public void DGHS19() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase20: lưu hệ số tiếng việt <1");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(2).getNumericCellValue();
//	    // Chuyển giá trị đọc được sang kiểu chuỗi
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra giá trị nhập vào
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = null;
//	    try {
//	        // Kiểm tra xem có hiển thị popup hay không
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không hiển thị popup thì in ra thông báo lưu thất bại
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu hiển thị popup thì in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("kết quả thực tế: " + popupText);
//	        }
//	    }
//	}


	
//	@Test(priority = 20)
//	public void DGHS20() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase21: lưu hệ số tiếng việt chữ hoa");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(0);
//	    // Đọc giá trị từ ô trong file excel
//	    String idString = row.getCell(3).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra giá trị nhập vào
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = null;
//	    try {
//	        // Kiểm tra xem có hiển thị popup hay không
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException ex) {
//	        if (popup != null && popup.isDisplayed()) {
//	            // Nếu hiển thị popup thì in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("Nội dung của popup là: " + popupText);
//	        } else {
//	            // Nếu không hiển thị popup thì in ra kết quả thực tế
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/label[2]")).getText();
//	            System.out.println("kết quả thực tế: " + ketquahienthistrString);
//	        }
//	        Thread.sleep(2000);
//	    }
//	}


	
//	@Test(priority = 21)
//	public void DGHS21() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase22: lưu hệ số tiếng việt >10");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(4).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra giá trị nhập vào
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = null;
//	    try {
//	        // Kiểm tra xem có hiển thị popup hay không
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (Exception e) {
//	        if (popup != null && popup.isDisplayed()) {
//	            // Nếu hiển thị popup thì in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("Nội dung của popup là: " + popupText);
//	        } else {
//	            // Nếu không hiển thị popup thì in ra kết quả thực tế
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/label[2]")).getText();
//	            System.out.println("kết quả thực tế: " + ketquahienthistrString);
//	            Thread.sleep(2000);
//	        }
//	    }
//	}


	
//	@Test(priority = 22)
//	public void DGHS22() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase23: lưu hệ số tiếng việt chữ thường");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(0);
//	    // Đọc giá trị từ ô trong file excel
//	    String idString = row.getCell(5).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra giá trị nhập vào
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/label[2]"));
//	    if (popup != null && popup.isDisplayed()) {
//	        // Nếu hiển thị popup thì in ra kết quả hiển thị là lưu thất bại
//	        String ketquahienthistrString = popup.getText();
//	        System.out.println("Lưu thất bại kết quả hiển thị là: " + ketquahienthistrString);
//	    } else {
//	        // Nếu không hiển thị popup thì in ra kết quả thực tế
//	        System.out.println("kết quả thực tế: " + popup);
//	        Thread.sleep(2000);
//	    }
//	}


	
//	@Test(priority = 23)
//	public void DGHS23() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase24: lưu hệ số tiếng việt ký tự đặc biệt");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(0);
//	    // Đọc giá trị từ ô trong file excel
//	    String idString = row.getCell(6).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra giá trị nhập vào
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup != null && popup.isDisplayed()) {
//	            // Nếu hiển thị popup thì in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("Nội dung của popup là: " + popupText);
//	        } else {
//	            // Nếu không hiển thị popup thì in ra kết quả thực tế
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/label[2]")).getText();
//	            System.out.println("kết quả thực tế: " + ketquahienthistrString);
//	            Thread.sleep(2000);
//	        }
//	    }
//	}


//	@Test(priority = 24)
//	public void DGHS24() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase25: lưu hệ số tiếng việt với khoảng trắng");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(0);
//	    // Đọc giá trị từ ô trong file excel
//	    String idString = row.getCell(7).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra giá trị nhập vào
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup != null && popup.isDisplayed()) {
//	            // Nếu hiển thị popup thì in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("Nội dung của popup là: " + popupText);
//	        } else {
//	            // Nếu không hiển thị popup thì in ra kết quả thực tế
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/label[2]")).getText();
//	            System.out.println("kết quả thực tế: " + ketquahienthistrString);
//	            Thread.sleep(2000);
//	        }
//	    }
//	}

	
	
//	@Test(priority = 25)
//	public void DGHS25() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase26: lưu hệ số lý thuyết >1 và <9.99");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(1).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(2000);
//	    // In ra giá trị nhập vào
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).size() > 0) {
//	        // Nếu xuất hiện thông báo lỗi thì in ra thông báo
//	        String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).getText();
//	        Thread.sleep(1500);
//	        System.out.println("Lưu thất bại kết quả hiển thị là: " + ketquahienthistrString);
//	    } else {
//	        // Nếu không xuất hiện thông báo lỗi thì in ra nội dung của popup
//	        WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	        String popupText = popup.getText();
//	        System.out.println("kết quả thực tế: " + popupText);
//	        Thread.sleep(2000);
//	    }
//	}


	
//	@Test(priority = 26)
//	public void DGHS26() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase27: lưu hệ số lý thuyết <1");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(2).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra giá trị nhập vào
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).size() > 0) {
//	        // Nếu xuất hiện thông báo lỗi thì in ra thông báo
//	        String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).getText();
//	        System.out.println("Lưu thất bại kết quả hiển thị là: " + ketquahienthistrString);
//	    } else {
//	        // Nếu không xuất hiện thông báo lỗi thì in ra nội dung của popup
//	        WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	        String popupText = popup.getText();
//	        System.out.println("kết quả thực tế: " + popupText);
//	        Thread.sleep(2000);
//	    }
//	}


	
//	@Test(priority = 27)
//	public void DGHS27() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase28: lưu hệ số lý thuyết với chữ hoa");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    XSSFRow row = sheet.getRow(0);
//	    String idString = row.getCell(3).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    // In ra giá trị nhập vào
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).size() > 0) {
//	        // Nếu xuất hiện thông báo lỗi thì in ra thông báo
//	        String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).getText();
//	        System.out.println("Lưu thất bại kết quả hiển thị là: " + ketquahienthistrString);
//	    } else {
//	        // Nếu không xuất hiện thông báo lỗi thì in ra nội dung của popup
//	        WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	        String popupText = popup.getText();
//	        System.out.println("kết quả thực tế: " + popupText);
//	        Thread.sleep(2000);
//	    }
//	}


	
//	@Test(priority = 28)
//	public void DGHS28() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase29: lưu hệ số lý thuyết >10");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(4).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    System.out.println("Kết quả nhập vào: " + idString);
//
//	    // Kiểm tra lưu thành công hay thất bại
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).size() > 0) {
//	        String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).getText();
//	        System.out.println("Lưu thất bại kết quả hiển thị là: " + ketquahienthistrString);
//	        Thread.sleep(2000);
//	    } else {
//	        WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	        System.out.println("Kết quả đầu vào: " + idString);
//	        String popupText = popup.getText();
//	        System.out.println("kết quả thực tế: " + popupText);
//	        Thread.sleep(2000);
//	    }
//	}


	
//	@Test(priority = 29)
//	public void DGHS29() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase30: lưu hệ số lý thuyết với chữ thường");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    XSSFRow row = sheet.getRow(0);
//	    String idString = row.getCell(5).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    // Kiểm tra lưu thành công hay thất bại
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).size() > 0) {
//	        String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).getText();
//	        System.out.println("Lưu thất bại kết quả hiển thị là: " + ketquahienthistrString);
//	        Thread.sleep(2000);
//	    } else {
//	        WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[1]/label[2]"));
//	        String popupText = popup.getText();
//	        System.out.println("kết quả thực tế: " + popupText);
//	        Thread.sleep(2000);
//	    }
//	}


	
	
//	@Test(priority = 30)
//	public void DGHS30() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase31: lưu hệ số lý thuyết với ký tự đặc biệt");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    XSSFRow row = sheet.getRow(0);
//	    String idString = row.getCell(6).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    // Kiểm tra lưu thành công hay thất bại
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).size() > 0) {
//	        String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).getText();
//	        System.out.println("Lưu thất bại kết quả hiển thị là: " + ketquahienthistrString);
//	        Thread.sleep(2000);
//	    } else {
//	        WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	        String popupText = popup.getText();
//	        System.out.println("Kết quả thực tế: " + popupText);
//	        Thread.sleep(2000);
//	    }
//	}


	
	
//	@Test(priority = 31)
//	public void DGHS31() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase32: lưu hệ số lý thuyết với khoảng trắng");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    XSSFRow row = sheet.getRow(0);
//	    String idString = row.getCell(7).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    // Kiểm tra lưu thành công hay thất bại
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).size() > 0) {
//	        String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).getText();
//	        System.out.println("Lưu thất bại kết quả hiển thị là: " + ketquahienthistrString);
//	        Thread.sleep(2000);
//	    } else {
//	        WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	        String popupText = popup.getText();
//	        System.out.println("kết quả thực tế: " + popupText);
//	        Thread.sleep(2000);
//	    }
//	}


	
	
//	@Test(priority = 32)
//	public void DGHS32() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase33: lưu hệ số thực hành >1 và <9.99");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(1).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(2000);
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    // Kiểm tra lưu thành công hay thất bại
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).size() > 0) {
//	        String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).getText();
//	        System.out.println("Lưu thất bại kết quả hiển thị là: " + ketquahienthistrString);
//	        Thread.sleep(1500);
//	    } else {
//	        WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	        String popupText = popup.getText();
//	        System.out.println("kết quả thực tế: " + popupText);
//	        Thread.sleep(2000);
//	    }
//	}

	
	
//	@Test(priority = 33)
//	public void DGHS33() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase34: lưu hệ số thực hành <1");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(2).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không có popup xuất hiện, in ra thông báo lưu thất bại từ trang web
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu có popup xuất hiện, in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("kết quả thực tế: " + popupText);
//	        }
//	    }
//	}


	
	
//	@Test(priority = 34)
//	public void DGHS34() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase35: lưu hệ số thực hành với chữ hoa");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    XSSFRow row = sheet.getRow(0);
//	    String idString = row.getCell(3).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    System.out.println("Kết quả nhập vào: " + idString);    
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không có popup xuất hiện, in ra thông báo lưu thất bại từ trang web
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu có popup xuất hiện, in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("kết quả thực tế: " + popupText);
//	        }
//	    }
//	}



	
//	@Test(priority = 35)
//	public void DGHS35() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase36: lưu hệ số thực hành >10");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(4).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không có popup xuất hiện, in ra thông báo lưu thất bại từ trang web
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu có popup xuất hiện, in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("kết quả thực tế: " + popupText);
//	        }
//	    }
//	}

	
//	@Test(priority = 36)
//	public void DGHS36() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase37: lưu hệ số thực hành với chữ thường");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    XSSFRow row = sheet.getRow(0);
//	    String idString = row.getCell(5).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không có popup xuất hiện, in ra thông báo lưu thất bại từ trang web
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu có popup xuất hiện, in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("kết quả thực tế: " + popupText);
//	        }
//	    }
//	}

	
//	@Test(priority = 37)
//	public void DGHS37() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase38: lưu hệ số thực hành với ký tự đặc biệt");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    XSSFRow row = sheet.getRow(0);
//	    String idString = row.getCell(6).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không có popup xuất hiện, in ra thông báo lưu thất bại từ trang web
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu có popup xuất hiện, in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("kết quả thực tế: " + popupText);
//	        }
//	    }
//	}


	
//	@Test(priority = 38)
//	public void DGHS38() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase39: lưu hệ số thực hành với khoảng trắng");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    XSSFRow row = sheet.getRow(0);
//	    String idString = row.getCell(7).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    String keyword = "ㅤ";
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/div/input")).sendKeys(keyword);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    Thread.sleep(1500);
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không có popup xuất hiện, in ra thông báo lưu thất bại từ trang web
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[2]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu có popup xuất hiện, in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("kết quả thực tế: " + popupText);
//	        }
//	    }
//	}

	
	
	
//	@Test(priority = 39)
//	public void DGHS39() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase40: lưu hệ số tiếng anh <1");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(2).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    String keyword = "-1";
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).sendKeys(keyword);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không có popup xuất hiện, in ra thông báo lưu thất bại từ trang web
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu có popup xuất hiện, in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("kết quả thực tế: " + popupText);
//	        }
//	    }
//	}

	
//	@Test(priority = 40)
//	public void DGHS40() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase41: lưu hệ số tiếng anh >1 và <9.99");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(1).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    if (driver.findElements(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div[1]/label[2]")).size() > 0) {
//	        // Nếu có thông báo lỗi hiển thị, in ra thông báo lỗi từ trang web
//	        String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/label[2]")).getText();
//	        System.out.println("Lưu thất bại kết quả hiển thị là: " + ketquahienthistrString);
//	        Thread.sleep(1500);
//	    } else {
//	        // Nếu không có thông báo lỗi hiển thị, in ra nội dung của popup
//	        WebElement popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	        String popupText = popup.getText();
//	        System.out.println("kết quả thực tế: " + popupText);
//	        Thread.sleep(2000);
//	    }
//	}

	
//	@Test(priority = 41)
//	public void DGHS41() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase42: lưu hệ số tiếng anh >10");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    int idInt = (int) sheet.getRow(0).getCell(4).getNumericCellValue();
//	    String idString = String.valueOf(idInt);
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    // Kiểm tra xem có popup thông báo lỗi hiển thị không
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không có popup, in ra thông báo lỗi từ trang web
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu có popup, in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("kết quả thực tế: " + popupText);
//	        }
//	    }
//	}

	
//	@Test(priority = 42)
//	public void DGHS42() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase43: lưu hệ số tiếng anh với chữ hoa");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    XSSFRow row = sheet.getRow(0);
//	    String idString = row.getCell(3).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    // Kiểm tra xem có popup thông báo lỗi hiển thị không
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không có popup, in ra thông báo lỗi từ trang web
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu có popup, in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("kết quả thực tế: " + popupText);
//	        }
//	    }
//	}

	
//	@Test(priority = 43)
//	public void DGHS43() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase44: lưu hệ số tiếng anh với chữ thường");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    XSSFRow row = sheet.getRow(0);
//	    String idString = row.getCell(5).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    // Kiểm tra xem có popup thông báo lỗi hiển thị không
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không có popup, in ra thông báo lỗi từ trang web
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu có popup, in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("Kết quả thực tế: " + popupText);
//	        }
//	    }
//	}

	
//	@Test(priority = 44)
//	public void DGHS44() throws InterruptedException, IOException {
//	    // In ra thông báo mô tả cho test case
//	    System.out.println("Testcase45: lưu hệ số tiếng anh với ký tự đặc biệt");
//	    // Mở file excel chứa dữ liệu test
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Đọc giá trị từ ô trong file excel
//	    XSSFRow row = sheet.getRow(0);
//	    String idString = row.getCell(6).getStringCellValue();
//	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
//	    Thread.sleep(1500);
//	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//	    Thread.sleep(1500);
//	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
//	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
//	    Thread.sleep(1500);
//	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).clear();
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).sendKeys(idString);
//	    Thread.sleep(1500);
//	    // Click vào nút lưu để lưu hệ số
//	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//	    System.out.println("Kết quả nhập vào: " + idString);
//	    // Kiểm tra xem có popup thông báo lỗi hiển thị không
//	    WebElement popup = null;
//	    try {
//	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//	    } catch (NoSuchElementException e) {
//	        if (popup == null || !popup.isDisplayed()) {
//	            // Nếu không có popup, in ra thông báo lỗi từ trang web
//	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/label[2]")).getText();
//	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
//	        } else {
//	            // Nếu có popup, in ra nội dung của popup
//	            String popupText = popup.getText();
//	            System.out.println("Kết quả thực tế: " + popupText);
//	        }
//	    }
//	}

	
	@Test(priority = 45)
	public void DGHS45() throws InterruptedException, IOException {
	    // In ra thông báo mô tả cho test case
	    System.out.println("Testcase46: lưu hệ số tiếng anh với khoảng trắng");
	    // Mở file excel chứa dữ liệu test
	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\Test.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    // Đọc giá trị từ ô trong file excel
	    XSSFRow row = sheet.getRow(0);
	    String idString = row.getCell(7).getStringCellValue();
	    // Tạm dừng thread để đợi cho các tác vụ trước đó hoàn thành
	    Thread.sleep(1500);
	    // Click vào phần tử trên trình duyệt để chọn chức năng lưu
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
	    Thread.sleep(1500);
	    // Tìm và click vào phần tử trên trình duyệt để mở popup lưu hệ số
	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a/i"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
	    Thread.sleep(1500);
	    // Xóa nội dung trong ô input và nhập giá trị từ file excel vào ô input
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).clear();
	    Thread.sleep(1500);
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/div/input")).sendKeys(idString);
	    Thread.sleep(1500);
	    // Click vào nút lưu để lưu hệ số
	    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
	    System.out.println("Kết quả nhập vào: " + idString);
	    // Kiểm tra xem có popup thông báo lỗi hiển thị không
	    WebElement popup = null;
	    try {
	        popup = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
	    } catch (NoSuchElementException e) {
	        if (popup == null || !popup.isDisplayed()) {
	            // Nếu không có popup, in ra thông báo lỗi từ trang web
	            String ketquahienthistrString = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div[2]/label[2]")).getText();
	            System.out.println("Lưu thất bại: " + ketquahienthistrString);
	        } else {
	            // Nếu có popup, in ra nội dung của popup
	            String popupText = popup.getText();
	            System.out.println("kết quả thực tế: " + popupText);
	        }
	    }
	}

	
}


