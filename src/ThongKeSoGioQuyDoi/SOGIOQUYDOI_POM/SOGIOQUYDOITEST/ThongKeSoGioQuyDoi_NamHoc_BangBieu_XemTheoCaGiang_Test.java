package SOGIOQUYDOITEST;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageSetup.Setup;
import SOGIOQUYDOI.ThongKeSoGioQuyDoi_NamHoc_BangBieu_XemTheoCaGiang_Page;

public class ThongKeSoGioQuyDoi_NamHoc_BangBieu_XemTheoCaGiang_Test {
	static WebDriver driver;
	@BeforeSuite
	public void Setup() throws InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(2000);
	}
	@BeforeTest
	public void Setup2() throws InterruptedException {
		ThongKeSoGioQuyDoi_NamHoc_BangBieu_XemTheoCaGiang_Page MainPage = new ThongKeSoGioQuyDoi_NamHoc_BangBieu_XemTheoCaGiang_Page(driver);
		MainPage.navigateToPage();
		MainPage.selectLessonType();
		MainPage.SearchInput("Năm học");
		MainPage.ChooseYear("2023 - 2024");
		MainPage.selectMajor("Tất cả");
		MainPage.switchToTableTab();
	}
	@Test
	public void Action() throws InterruptedException {
	    // In ra thông điệp mô tả testcase
	    System.out.println("Testcase 1: Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Năm Học với bảng biểu và xem theo ca giảng");
	    
	    // Dừng chương trình trong 2 giây để chờ trang web hoàn thành việc load dữ liệu
	    Thread.sleep(2000);
	    
	    // Tìm phần tử trên trang web chứa dữ liệu bảng biểu
	    WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
	    
	    // Lấy nội dung của phần tử trên và gán vào biến getDatString
	    String getDatString = dataElement.getText();
	    
	    // In ra nội dung của biến getDatString
	    System.out.println(getDatString);
	    
	    // In ra dòng gạch ngang để phân biệt giữa các testcase
	    System.out.println("========");
	}

	@Test
	public void Action2() throws InterruptedException {
	    // In ra thông điệp mô tả testcase
	    System.out.println("Testcase 2: Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Năm Học hiển thị 25 dữ liệu với bảng biểu và xem theo ca giảng");
	    
	    // Dừng chương trình trong 2 giây để chờ trang web hoàn thành việc load dữ liệu
	    Thread.sleep(2000);
	    
	    // Tìm dropdown chứa số lượng dữ liệu hiển thị trên trang
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
	    
	    // Khởi tạo đối tượng Select từ dropdown để thao tác với nó
	    Select select = new Select(dropdown);
	    
	    // Chọn giá trị "25" từ dropdown
	    select.selectByValue("25");
	    
	    // Dừng chương trình trong 2 giây để chờ trang web hiển thị dữ liệu mới
	    Thread.sleep(2000);
	    
	    // Tìm phần tử trên trang web chứa dữ liệu bảng biểu
	    WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
	    
	    // Lấy nội dung của phần tử trên và gán vào biến getDatString
	    String getDatString = dataElement.getText();
	    
	    // In ra nội dung của biến getDatString
	    System.out.println(getDatString);
	    
	    // In ra dòng gạch ngang để phân biệt giữa các testcase
	    System.out.println("========");
	}
	@Test // Đánh dấu phương thức này là một phương thức kiểm thử
	public void Action3() throws InterruptedException { // Khai báo phương thức kiểm thử và xử lý ngoại lệ InterruptedException
	    System.out.println("Testcase 3:Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Năm Học hiển thị 50 dữ liệu với bảng biểu và xem theo ca giảng"); // In ra màn hình tên của test case
	    Thread.sleep(2000); // Tạm ngừng thực thi trong 2 giây để chờ các tác động đồng bộ trong ứng dụng
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select")); // Tìm và chọn dropdown
	    Select select = new Select(dropdown); // Tạo một đối tượng Select từ dropdown
	    select.selectByValue("50"); // Chọn giá trị "50" trong dropdown
	    Thread.sleep(2000); // Tạm ngừng thực thi trong 2 giây
	    WebElement dataElement =driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody")); // Tìm phần tử chứa dữ liệu trong bảng
	    String getDatString=dataElement.getText(); // Lấy nội dung văn bản của phần tử
	    System.out.println(getDatString); // In ra dữ liệu thu được
	    System.out.println("========"); // In ra dấu phân cách để phân biệt giữa các test case
	}
	@Test // Đánh dấu phương thức này là một phương thức kiểm thử
	public void Action4() throws InterruptedException { // Khai báo phương thức kiểm thử và xử lý ngoại lệ InterruptedException
	    System.out.println("Testcase 4:Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Năm Học hiển thị tất cả dữ liệu với bảng biểu và xem theo ca giảng"); // In ra màn hình tên của test case
	    Thread.sleep(2000); // Tạm ngừng thực thi trong 2 giây để chờ các tác động đồng bộ trong ứng dụng
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select")); // Tìm và chọn dropdown
	    Select select = new Select(dropdown); // Tạo một đối tượng Select từ dropdown
	    select.selectByValue("-1"); // Chọn giá trị "-1" trong dropdown (tất cả dữ liệu)
	    Thread.sleep(2000); // Tạm ngừng thực thi trong 2 giây
	    WebElement dataElement =driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody")); // Tìm phần tử chứa dữ liệu trong bảng
	    String getDatString=dataElement.getText(); // Lấy nội dung văn bản của phần tử
	    System.out.println(getDatString); // In ra dữ liệu thu được
	    System.out.println("========"); // In ra dấu phân cách để phân biệt giữa các test case
	}

	
	@AfterTest
	public void Close() {
		driver.close();
	}
}
