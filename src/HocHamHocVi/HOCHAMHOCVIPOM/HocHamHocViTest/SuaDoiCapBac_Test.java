package HocHamHocViTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HocHamHocVi.HienThiDuLieu_CapBac_Page;
import HocHamHocVi.SuaDoiCapBac_Page;
import PageSetup.Setup;

public class SuaDoiCapBac_Test {
	   static WebDriver driver;

		@BeforeSuite
		public void Main() throws IOException, InterruptedException {
			Setup setup = new Setup();
			driver = setup.setup();
			Thread.sleep(3000);
		}
		@BeforeTest
		public void Setup2() throws InterruptedException {
			SuaDoiCapBac_Page MainPage = new SuaDoiCapBac_Page(driver);
			MainPage.Menu();
			Thread.sleep(2000);

		}
		@Test
		public void Action1() throws InterruptedException, IOException {
		    System.out.println("Testcase1: Chỉnh sửa và ấn Hủy");
		    // In ra thông báo mô tả cho test case
		    SuaDoiCapBac_Page MainPage = new SuaDoiCapBac_Page(driver);
		    // Khởi tạo một đối tượng SuaDoiCapBac_Page để tương tác với trang chỉnh sửa cấp bậc
		    MainPage.HHHVMenu();
		    // Chọn menu HHHV
		    Thread.sleep(2000);
		    MainPage.CapBac();
		    // Chọn mục cấp bậc
		    Thread.sleep(2000);
		    MainPage.InputName("KTFCB");
		    // Nhập tên cần tìm kiếm
		    MainPage.ClickButton();
		    // Click vào nút để chỉnh sửa cấp bậc
		    Thread.sleep(2000);
		    WebElement dropdown = driver.findElement(By.id("academic_degree_id"));
		    // Tìm phần tử dropdown của học vị/cấp bậc
		    Select select = new Select(dropdown);
		    // Khởi tạo một đối tượng Select để thao tác với dropdown
		    select.selectByValue("TestingKhang11");
		    // Chọn giá trị trong dropdown
		    Thread.sleep(4000);
		    MainPage.ClickCloseButton();
		    // Click vào nút Hủy để hủy bỏ thao tác chỉnh sửa
		}

		@Test
		public void Action2() throws InterruptedException, IOException {
		    System.out.println("Testcase 2: Chỉnh sửa đúng");
		    // In ra thông báo mô tả cho test case
		    SuaDoiCapBac_Page MainPage = new SuaDoiCapBac_Page(driver);
		    // Khởi tạo một đối tượng SuaDoiCapBac_Page để tương tác với trang chỉnh sửa cấp bậc
		    MainPage.HHHVMenu();
		    // Chọn menu HHHV
		    Thread.sleep(2000);
		    MainPage.CapBac();
		    // Chọn mục cấp bậc
		    Thread.sleep(2000);
		    MainPage.InputName("KTFCB");
		    // Nhập tên cần tìm kiếm
		    MainPage.ClickButton();
		    // Click vào nút để chỉnh sửa cấp bậc
		    Thread.sleep(2000);
		    WebElement dropdown = driver.findElement(By.id("academic_degree_id"));
		    // Tìm phần tử dropdown của học vị/cấp bậc
		    Select select = new Select(dropdown);
		    // Khởi tạo một đối tượng Select để thao tác với dropdown
		    select.selectByValue("TestingKhang11");
		    // Chọn giá trị trong dropdown
		    Thread.sleep(4000);
		    MainPage.ClickSaveButton();
		    // Click vào nút Lưu để lưu các thay đổi đã chỉnh sửa
		}

}
