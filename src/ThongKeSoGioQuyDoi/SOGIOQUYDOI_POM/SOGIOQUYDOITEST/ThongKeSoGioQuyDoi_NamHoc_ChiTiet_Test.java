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
import SOGIOQUYDOI.ThongKeSoGioQuyDoi_NamHoc_ChiTiet_Page;

public class ThongKeSoGioQuyDoi_NamHoc_ChiTiet_Test {
	static WebDriver driver;
	@BeforeSuite
	public void Setup() throws InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(2000);
	}
	@BeforeTest
	public void Setup2() throws InterruptedException {
		ThongKeSoGioQuyDoi_NamHoc_ChiTiet_Page MainPage = new ThongKeSoGioQuyDoi_NamHoc_ChiTiet_Page(driver);
		MainPage.navigateToPage();
		MainPage.SearchInput("Năm học");
		MainPage.ChooseYear("2023 - 2024");
		MainPage.selectMajor("Tất cả");
		MainPage.switchToDetailsTab();
	}
	@Test // Đánh dấu phương thức này là một phương thức kiểm thử
	public void Action() throws InterruptedException { // Khai báo phương thức kiểm thử và xử lý ngoại lệ InterruptedException
	    System.out.println("Testcase 1:Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Năm học với chi tiết"); // In ra màn hình tên của test case
	    Thread.sleep(2000); // Tạm ngừng thực thi trong 2 giây để chờ các tác động đồng bộ trong ứng dụng
	    WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails\"]/tbody")); // Tìm phần tử chứa dữ liệu trong bảng
	    String getDatString = dataElement.getText(); // Lấy nội dung văn bản của phần tử
	    System.out.println(getDatString); // In ra dữ liệu thu được
	    System.out.println("========"); // In ra dấu phân cách để phân biệt giữa các test case
	}

	@Test // Đánh dấu phương thức này là một phương thức kiểm thử
	public void Action2() throws InterruptedException { // Khai báo phương thức kiểm thử và xử lý ngoại lệ InterruptedException
	    System.out.println("Testcase 2:Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Năm học hiển thị 25 dữ liệu với chi tiết"); // In ra màn hình tên của test case
	    Thread.sleep(2000); // Tạm ngừng thực thi trong 2 giây để chờ các tác động đồng bộ trong ứng dụng
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label/select")); // Tìm phần tử dropdown để chọn số lượng dữ liệu hiển thị
	    Select select = new Select(dropdown); // Tạo một đối tượng Select để chọn giá trị trong dropdown
	    select.selectByValue("25"); // Chọn giá trị "25" trong dropdown
	    Thread.sleep(2000); // Tạm ngừng thực thi trong 2 giây để chờ dữ liệu được tải và hiển thị
	    WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails\"]/tbody")); // Tìm phần tử chứa dữ liệu trong bảng
	    String getDatString = dataElement.getText(); // Lấy nội dung văn bản của phần tử
	    System.out.println(getDatString); // In ra dữ liệu thu được
	    System.out.println("========"); // In ra dấu phân cách để phân biệt giữa các test case
	}
	@Test
	public void Action3() throws InterruptedException {
		System.out.println("Testcase 3:Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Năm học hiển thị 50 dữ liệu với chi tiết");
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("50");
		Thread.sleep(2000);
		WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails\"]/tbody"));
       String getDatString=dataElement.getText();
       System.out.println(getDatString);
       System.out.println("========");

	}
	@Test
	public void Action4() throws InterruptedException {
		System.out.println("Testcase 4:Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Năm học hiển thị tất cả dữ liệu với chi tiết");
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("-1");
		Thread.sleep(2000);
		WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails\"]/tbody"));
       String getDatString=dataElement.getText();
       System.out.println(getDatString);
		System.out.println("========");

	}
	@AfterTest
	public void Close() {
		driver.close();
	}
}
