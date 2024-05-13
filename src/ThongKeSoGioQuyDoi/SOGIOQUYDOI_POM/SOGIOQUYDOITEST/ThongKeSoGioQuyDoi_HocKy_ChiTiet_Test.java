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
import SOGIOQUYDOI.ThongKeSoGioQuyDoi_HocKy_ChiTiet_Page;

public class ThongKeSoGioQuyDoi_HocKy_ChiTiet_Test {
	static WebDriver driver;

	@BeforeSuite
	public void Setup() throws InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(2000);
	}

	@BeforeTest
	public void Setup2() throws InterruptedException {
		ThongKeSoGioQuyDoi_HocKy_ChiTiet_Page Mainpage = new ThongKeSoGioQuyDoi_HocKy_ChiTiet_Page(driver);
		Mainpage.navigateToPage();
		Mainpage.selectTerm("789");
		Mainpage.selectMajor("Tất cả");
		Mainpage.switchToDetailsTab();

	}

	@Test
	public void Action() throws InterruptedException {
	    System.out.println("Testcase 1: Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ với chi tiết");
	    Thread.sleep(2000); // Chờ 2 giây để load

	    // Tìm phần tử chứa dữ liệu chi tiết
	    WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails\"]/tbody"));
	    String getDatString = dataElement.getText(); // Lấy nội dung dữ liệu chi tiết
	    System.out.println(getDatString); // In ra dữ liệu chi tiết
	    System.out.println("========"); // In dấu phân cách
	}

	@Test
	public void Action2() throws InterruptedException {
	    System.out.println("Testcase 2: Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ hiển thị 25 dữ liệu với chi tiết");
	    Thread.sleep(2000); // Chờ 2 giây để load

	    // Tìm dropdown chọn số lượng dữ liệu hiển thị trên trang
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label/select"));
	    Select select = new Select(dropdown); // Tạo đối tượng Select để thao tác với dropdown
	    select.selectByValue("25"); // Chọn giá trị "25" từ dropdown để hiển thị 25 dữ liệu
	    Thread.sleep(2000); // Chờ 2 giây để load dữ liệu mới

	    // Tìm phần tử chứa dữ liệu chi tiết
	    WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails\"]/tbody"));
	    String getDatString = dataElement.getText(); // Lấy nội dung dữ liệu chi tiết
	    System.out.println(getDatString); // In ra dữ liệu chi tiết
	    System.out.println("========"); // In dấu phân cách
	}
	@Test
	public void Action3() throws InterruptedException {
	    System.out.println("Testcase 3: Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ hiển thị 50 dữ liệu với chi tiết");
	    Thread.sleep(2000); // Chờ 2 giây để load

	    // Tìm dropdown chứa số lượng dữ liệu hiển thị
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label/select"));
	    Select select = new Select(dropdown); // Tạo đối tượng Select để thao tác với dropdown
	    select.selectByValue("50"); // Chọn hiển thị 50 dữ liệu
	    Thread.sleep(2000); // Chờ 2 giây để load

	    // Tìm phần tử chứa dữ liệu chi tiết
	    WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails\"]/tbody"));
	    String getDatString = dataElement.getText(); // Lấy nội dung dữ liệu chi tiết
	    System.out.println(getDatString); // In ra dữ liệu chi tiết
	    System.out.println("========"); // In dấu phân cách
	}
	@Test
	public void Action4() throws InterruptedException {
	    System.out.println("Testcase 4: Chức năng xem danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ hiển thị tất cả dữ liệu với chi tiết");
	    Thread.sleep(2000); // Chờ 2 giây để load

	    // Tìm dropdown chứa số lượng dữ liệu hiển thị
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label/select"));
	    Select select = new Select(dropdown); // Tạo đối tượng Select để thao tác với dropdown
	    select.selectByValue("-1"); // Chọn hiển thị tất cả dữ liệu
	    Thread.sleep(2000); // Chờ 2 giây để load

	    // Tìm phần tử chứa dữ liệu chi tiết
	    WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails\"]/tbody"));
	    String getDatString = dataElement.getText(); // Lấy nội dung dữ liệu chi tiết
	    System.out.println(getDatString); // In ra dữ liệu chi tiết
	    System.out.println("========"); // In dấu phân cách
	}
	@AfterTest
	public void Close() {
		driver.close();
	}

}
