package HocHamHocViTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HocHamHocVi.HienThiDuLieu_HocHamHocVi_Page;
import HocHamHocVi.XoaHocHamHocVi_Page;
import PageSetup.Setup;

public class XoaHocHamHocVi_Test {
	static WebDriver driver;

	@BeforeSuite
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}

	@BeforeTest
	public void Setup2() throws InterruptedException {
		XoaHocHamHocVi_Page MainPage = new XoaHocHamHocVi_Page(driver);
		MainPage.Menu();
		Thread.sleep(2000);

	}
	@Test(priority = 1)
	public void Actions1() throws IOException, InterruptedException {
	    System.out.println("Testcase 1 :Xóa học hàm học vị và ấn Hủy");
	    XoaHocHamHocVi_Page MainPage = new XoaHocHamHocVi_Page(driver); // Khởi tạo trang Xóa Học hàm, học vị
	    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx"); // Mở tệp Excel chứa dữ liệu
	    XSSFWorkbook workbook = new XSSFWorkbook(fis); // Đọc workbook từ FileInputStream
	    XSSFSheet sheet = workbook.getSheetAt(0); // Lấy trang tính đầu tiên từ workbook
	    for (int i = 0; i < 4; i++) { // Lặp qua 4 hàng trong trang tính
	        XSSFRow row = sheet.getRow(i); // Lấy hàng thứ i
	        String NAME = row.getCell(0).getStringCellValue(); // Lấy giá trị từ cột đầu tiên trong hàng
	        MainPage.HHHVMenu(); // Chọn mục trong menu
	        Thread.sleep(2000); // Tạm dừng 2 giây để đợi cho trang tải
	        WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input")); // Tìm ô tìm kiếm trên trang
	        inputElement.sendKeys(NAME); // Nhập giá trị tìm kiếm
	        Thread.sleep(2000); // Tạm dừng 2 giây để đợi cho kết quả tìm kiếm xuất hiện
	        driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr/td[5]/a[2]")).click(); // Nhấn vào nút Xóa tương ứng
	        Thread.sleep(3000); // Tạm dừng 3 giây để đợi xuất hiện popup xác nhận
	        WebElement clickElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")); // Tìm nút Hủy trong popup
	        if (clickElement.isEnabled()) { // Kiểm tra xem nút Hủy có được kích hoạt không
	            clickElement.click(); // Nhấn vào nút Hủy
	            Thread.sleep(2000); // Tạm dừng 2 giây để đợi popup biến mất
	            System.out.println("Click Hủy xóa thành công tại mục HHHV");
	        } else {
	            System.out.println("Click Hủy xóa không thành công tại mục HHHV");
	        }
	        System.out.println("=======");
	    }
	}

	@Test(priority = 2)
	public void Actions2() throws IOException, InterruptedException {
	    System.out.println("Testcase 2 :Xóa học hàm học vị bị trùng dữ liệu và ấn Hủy");
	    XoaHocHamHocVi_Page MainPage = new XoaHocHamHocVi_Page(driver); // Khởi tạo trang Xóa Học hàm, học vị
	    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx"); // Mở tệp Excel chứa dữ liệu
	    XSSFWorkbook workbook = new XSSFWorkbook(fis); // Đọc workbook từ FileInputStream
	    XSSFSheet sheet = workbook.getSheetAt(1); // Lấy trang tính thứ hai từ workbook
	    XSSFRow row = sheet.getRow(0); // Lấy hàng đầu tiên
	    String NAME = row.getCell(0).getStringCellValue(); // Lấy giá trị từ cột đầu tiên trong hàng
	    MainPage.HHHVMenu(); // Chọn mục trong menu
	    Thread.sleep(2000); // Tạm dừng 2 giây để đợi cho trang tải
	    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input")); // Tìm ô tìm kiếm trên trang
	    inputElement.sendKeys(NAME); // Nhập giá trị tìm kiếm
	    Thread.sleep(2000); // Tạm dừng 2 giây để đợi cho kết quả tìm kiếm xuất hiện
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr/td[5]/a[2]")).click(); // Nhấn vào nút Xóa tương ứng
	    Thread.sleep(2000); // Tạm dừng 2 giây để đợi xuất hiện popup xác nhận
	    WebElement clickElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")); // Tìm nút Hủy trong popup
	    if (clickElement.isEnabled()) { // Kiểm tra xem nút Hủy có được kích hoạt không
	        clickElement.click(); // Nhấn vào nút Hủy
	        Thread.sleep(2000); // Tạm dừng 2 giây để đợi popup biến mất
	        System.out.println("Click Hủy xóa thành công tại mục HHHV");
	    } else {
	        System.out.println("Click Hủy xóa không thành công tại mục HHHV");
	    }
	    System.out.println("=======");
	}

	@Test(priority = 3)
	public void Actions3() throws IOException, InterruptedException {
	    System.out.println("Testcase 3 :Xóa học hàm học vị");
	    XoaHocHamHocVi_Page MainPage = new XoaHocHamHocVi_Page(driver); // Khởi tạo trang Xóa Học hàm, học vị
	    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx"); // Mở tệp Excel chứa dữ liệu
	    XSSFWorkbook workbook = new XSSFWorkbook(fis); // Đọc workbook từ FileInputStream
	    XSSFSheet sheet = workbook.getSheetAt(0); // Lấy trang tính đầu tiên từ workbook
	    for (int i = 0; i < 4; i++) { // Lặp qua 4 hàng trong trang tính
	        XSSFRow row = sheet.getRow(i); // Lấy hàng thứ i
	        String NAME = row.getCell(0).getStringCellValue(); // Lấy giá trị từ cột đầu tiên trong hàng
	        MainPage.HHHVMenu(); // Chọn mục trong menu
	        Thread.sleep(2000); // Tạm dừng 2 giây để đợi cho trang tải
	        WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input")); // Tìm ô tìm kiếm trên trang
	        inputElement.sendKeys(NAME); // Nhập giá trị tìm kiếm
	        Thread.sleep(2000); // Tạm dừng 2 giây để đợi cho kết quả tìm kiếm xuất hiện
	        driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr/td[5]/a[2]")).click(); // Nhấn vào nút Xóa tương ứng
	        Thread.sleep(5000); // Tạm dừng 5 giây để đợi xuất hiện popup xác nhận
	        WebElement clickElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")); // Tìm nút Xóa trong popup
	        if (clickElement.isEnabled()) { // Kiểm tra xem nút Xóa có được kích hoạt không
	            clickElement.click(); // Nhấn vào nút Xóa
	            System.out.println("Click Xóa thành công dữ liệu "+ NAME);
	        } else {
	            System.out.println("Click Xóa không thành công dữ liệu" +NAME);
	        }
	        System.out.println("=======");
	    }
	}

	@Test(priority = 4)
	public void Actions4() throws IOException, InterruptedException {
	    System.out.println("Testcase 4 :Xóa học hàm học vị đã có dữ liệu");
	    XoaHocHamHocVi_Page MainPage = new XoaHocHamHocVi_Page(driver); // Khởi tạo trang Xóa Học hàm, học vị
	    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx"); // Mở tệp Excel chứa dữ liệu
	    XSSFWorkbook workbook = new XSSFWorkbook(fis); // Đọc workbook từ FileInputStream
	    XSSFSheet sheet = workbook.getSheetAt(1); // Lấy trang tính thứ hai từ workbook
	    XSSFRow row = sheet.getRow(0); // Lấy hàng đầu tiên
	    String NAME = row.getCell(0).getStringCellValue(); // Lấy giá trị từ cột đầu tiên trong hàng
	    MainPage.HHHVMenu(); // Chọn mục trong menu
	    Thread.sleep(2000); // Tạm dừng 2 giây để đợi cho trang tải
	    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input")); // Tìm ô tìm kiếm trên trang
	    inputElement.sendKeys(NAME); // Nhập giá trị tìm kiếm
	    Thread.sleep(2000); // Tạm dừng 2 giây để đợi cho kết quả tìm kiếm xuất hiện
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr/td[5]/a[2]")).click(); // Nhấn vào nút Xóa tương ứng
	    Thread.sleep(2000); // Tạm dừng 2 giây để đợi xuất hiện popup xác nhận
	    WebElement clickElement=driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")); // Tìm nút Xóa trong popup
	    Thread.sleep(2000); // Tạm dừng 2 giây để đợi cho nút Xóa xuất hiện
	    clickElement.click(); // Nhấn vào nút Xóa
	    Thread.sleep(2000); // Tạm dừng 2 giây để đợi cho popup kết quả xuất hiện
	    try {
	        driver.findElement(By.xpath("/html/body/div[3]/div/h2")).getText(); // Kiểm tra xem popup kết quả có xuất hiện hay không
	        WebElement errorElement = driver.findElement(By.id("swal2-html-container")); // Nếu có, lấy phần tử chứa thông báo lỗi
	        System.out.println("Click xóa không thành công, kết quả thực tế: " + errorElement.getText()); // In ra thông báo lỗi
	    } catch (WebDriverException e) {
	        System.out.println("Click xóa thành công"); // Nếu không có popup kết quả, in ra thông báo xóa thành công
	    }
	    String expected = "Không thể xoá do học hàm, học vị này đã có dữ liệu!"; // Chuỗi kỳ vọng thông báo lỗi
	    System.out.println("Kết quả mong đợi: " + expected); // In ra kết quả mong đợi của thông báo lỗi
	    driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click(); // Nhấn vào nút Đóng trong popup kết quả
	    System.out.println("=======");
	}

	@AfterTest
	public void Close() {
		driver.close();
	}
}
