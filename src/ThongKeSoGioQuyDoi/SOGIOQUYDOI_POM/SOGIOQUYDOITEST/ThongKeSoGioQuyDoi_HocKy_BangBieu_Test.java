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
import SOGIOQUYDOI.ThongKeSoGioQuyDoi_HocKy_BangBieu_Page;

public class ThongKeSoGioQuyDoi_HocKy_BangBieu_Test {
	static WebDriver driver;

	@BeforeSuite
	public void Setup() throws InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(2000);
	}

	@BeforeTest
	public void Setup2() throws InterruptedException {
		ThongKeSoGioQuyDoi_HocKy_BangBieu_Page MainPage = new ThongKeSoGioQuyDoi_HocKy_BangBieu_Page(driver);
		MainPage.navigateToPage(); // Điều hướng đến trang
		MainPage.selectTerm("789"); // Chọn học kỳ
		MainPage.selectMajor("Tất cả"); // Chọn ngành học
		MainPage.switchToTableTab(); // Chuyển sang tab bảng biểu
	}

	// Phương thức thực hiện hành động và kiểm tra
	@Test
	public void Action() throws InterruptedException {
		System.out.println("Testcase 1:Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ với bảng biểu");
		Thread.sleep(2000); // Chờ 2 giây để load
		WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody")); // Tìm phần tử chứa dữ liệu
		String getDatString = dataElement.getText(); // Lấy nội dung dữ liệu
		System.out.println(getDatString); // In ra dữ liệu
		System.out.println("========"); // In ra dấu '='
	}

	@Test
	public void Action2() throws InterruptedException {
	    System.out.println(
	            "Testcase 2: Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ hiển thị 25 dữ liệu với bảng biểu");
	    Thread.sleep(2000); // Chờ 2 giây để load

	    // Tìm dropdown chứa số lượng dữ liệu trên trang
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
	    Select select = new Select(dropdown); // Khởi tạo đối tượng Select
	    select.selectByValue("25"); // Chọn giá trị 25 trong dropdown
	    Thread.sleep(2000); // Chờ 2 giây để load

	    // Tìm phần tử chứa dữ liệu
	    WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
	    String getDatString = dataElement.getText(); // Lấy nội dung dữ liệu
	    System.out.println(getDatString); // In ra dữ liệu
	}

	@Test
	public void Action3() throws InterruptedException {
	    System.out.println(
	            "Testcase 3: Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ hiển thị 50 dữ liệu với bảng biểu");
	    Thread.sleep(2000); // Chờ 2 giây để load

	    // Tìm dropdown chứa số lượng dữ liệu trên trang
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
	    Select select = new Select(dropdown); // Khởi tạo đối tượng Select
	    select.selectByValue("50"); // Chọn giá trị 50 trong dropdown
	    Thread.sleep(2000); // Chờ 2 giây để load

	    // Tìm phần tử chứa dữ liệu
	    WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
	    String getDatString = dataElement.getText(); // Lấy nội dung dữ liệu
	    System.out.println(getDatString); // In ra dữ liệu
	    System.out.println("========"); // In ra dấu gạch ngang để phân biệt giữa các test case
	}

	@Test
	public void Action4() throws InterruptedException {
		System.out.println(
				"Testcase 4:Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ hiển thị tất cả dữ liệu với bảng biểu");
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("-1");
		Thread.sleep(2000);
		WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
		String getDatString = dataElement.getText();
		System.out.println(getDatString);
		System.out.println("========");

	}

	@AfterTest
	public void Close() {
		driver.close();
	}
}
