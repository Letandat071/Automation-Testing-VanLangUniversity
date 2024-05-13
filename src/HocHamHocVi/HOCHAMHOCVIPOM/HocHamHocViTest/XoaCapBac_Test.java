package HocHamHocViTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HocHamHocVi.TimKiemCapBac_Page;
import HocHamHocVi.XoaCapBac_Page;
import PageSetup.Setup;

public class XoaCapBac_Test {
	   static WebDriver driver;
			@BeforeSuite
			public void Main() throws IOException, InterruptedException {
				Setup setup = new Setup();
				driver = setup.setup();
				Thread.sleep(3000);
			}
			@BeforeTest
			public void Setup2() throws InterruptedException {
				XoaCapBac_Page MainPage = new XoaCapBac_Page(driver);
				MainPage.Menu();
				Thread.sleep(2000);
			}
			@Test(priority = 1)
			public void Actions1() throws IOException, InterruptedException {
			    // In ra tên của testcase và mô tả
			    System.out.println("Testcase 1 :Xóa cấp bậc và ấn Hủy");
			    // Khởi tạo đối tượng XoaCapBac_Page
			    XoaCapBac_Page MainPage = new XoaCapBac_Page(driver);
			    // Chọn menu HHHV
			    MainPage.HHHVMenu();
			    Thread.sleep(2000);
			    // Chọn mục cấp bậc
			    MainPage.CapBac();
			    Thread.sleep(2000);
			    // Nhập tên cấp bậc cần xóa vào ô tìm kiếm
			    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys("TestingKhang13");
			    Thread.sleep(3000);
			    // Click vào nút xóa của cấp bậc cần xóa
			    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]")).click();
			    Thread.sleep(2000);
			    // Click vào nút Hủy trên popup xác nhận xóa
			    WebElement clikElement=driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]"));
			    clikElement.click();
			    try {
			        // Kiểm tra xem nút Hủy có hoạt động không
			        clikElement.click();
			        System.out.println("Click hủy không thành công");
			    } catch (WebDriverException e) {
			        System.out.println("Click hủy thành công");
			    }
			    System.out.println("=======");
			}

			@Test(priority = 2)
			public void Actions2() throws IOException, InterruptedException {
			    // Mô tả testcase
			    System.out.println("Testcase 2 :Xóa cấp bậc đã có dữ liệu và ấn Hủy");
			    // Khởi tạo đối tượng XoaCapBac_Page
			    XoaCapBac_Page MainPage = new XoaCapBac_Page(driver);
			    // Chọn menu HHHV
			    MainPage.HHHVMenu();
			    Thread.sleep(2000);
			    // Chọn mục cấp bậc
			    MainPage.CapBac();
			    Thread.sleep(2000);
			    // Nhập tên cấp bậc cần xóa vào ô tìm kiếm
			    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys("TestingKhang11");
			    Thread.sleep(3000);
			    // Click vào nút xóa của cấp bậc cần xóa
			    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]")).click();
			    Thread.sleep(2000);
			    // Click vào nút Hủy trên popup xác nhận xóa
			    WebElement clikElement=driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]"));
			    clikElement.click();
			    try {
			        // Kiểm tra xem nút Hủy có hoạt động không
			        clikElement.click();
			        System.out.println("Click hủy không thành công");
			    } catch (WebDriverException e) {
			        System.out.println("Click hủy thành công");
			    }
			    System.out.println("=======");
			}

			@Test(priority = 3)
			public void Actions3() throws IOException, InterruptedException {
			    // Mô tả testcase
			    System.out.println("Testcase 3 :Xóa cấp bậc đúng");
			    // Khởi tạo đối tượng XoaCapBac_Page
			    XoaCapBac_Page MainPage = new XoaCapBac_Page(driver);
			    // Chọn menu HHHV
			    MainPage.HHHVMenu();
			    Thread.sleep(2000);
			    // Chọn mục cấp bậc
			    MainPage.CapBac();
			    Thread.sleep(2000);
			    // Nhập tên cấp bậc cần xóa vào ô tìm kiếm
			    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys("KTFCB");
			    Thread.sleep(3000);
			    // Click vào nút xóa của cấp bậc cần xóa
			    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]")).click();
			    Thread.sleep(3000);
			    // Click vào nút Xác nhận xóa
			    WebElement cliElement=driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
			    cliElement.click();
			    try {
			        // Kiểm tra xem nút Xác nhận xóa có hoạt động không
			        cliElement.click();
			        System.out.println("Xóa không thành công");
			    } catch (WebDriverException e) {
			        System.out.println("Xóa thành công dữ liệu");
			    }
			    System.out.println("=======");
			}

			@Test(priority = 4)
			public void Actions4() throws IOException, InterruptedException {
			    // Mô tả testcase
			    System.out.println("Testcase 4 :Xóa học hàm học vị đã có dữ liệu");
			    // Khởi tạo đối tượng XoaCapBac_Page
			    XoaCapBac_Page MainPage = new XoaCapBac_Page(driver);
			    // Chọn menu HHHV
			    MainPage.HHHVMenu();
			    Thread.sleep(2000);
			    // Chọn mục cấp bậc
			    MainPage.CapBac();
			    Thread.sleep(2000);
			    // Nhập tên cấp bậc cần xóa vào ô tìm kiếm
			    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys("TestingKhang11");
			    Thread.sleep(3000);
			    // Click vào nút xóa của cấp bậc cần xóa
			    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]")).click();
			    Thread.sleep(3000);
			    // Click vào nút Xác nhận xóa
			    WebElement cliElement=driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
			    cliElement.click();
			    Thread.sleep(2000);
			    try {
			        // Kiểm tra xem thông báo lỗi hiển thị khi xóa một mục đã có dữ liệu
			        driver.findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText();
			        System.out.println("Click xóa không thành công");
			        // In ra thông báo lỗi thực tế nếu có
			        WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]"));
			        System.out.println("Kết quả thực tế: " + errorElement.getText());
			    } catch (WebDriverException e) {
			        System.out.println("Click xóa thành công");
			    }
			    System.out.println("=======");
			}


			@AfterTest
			public void Close() {
				driver.close();
			}
}
