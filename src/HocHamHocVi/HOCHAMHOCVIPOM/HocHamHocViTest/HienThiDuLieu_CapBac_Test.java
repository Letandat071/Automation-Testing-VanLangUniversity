package HocHamHocViTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HocHamHocVi.HienThiDuLieu_CapBac_Page;
import PageSetup.Setup;

public class HienThiDuLieu_CapBac_Test {
    static WebDriver driver;

	@BeforeSuite
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}
	@BeforeTest
	public void Setup2() throws InterruptedException {
		HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
		MainPage.Menu();
		Thread.sleep(2000);

	}
	@Test
	public void Action1() throws InterruptedException {
	    System.out.println("Testcase 1: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA CẤP BẬC KHI HIỂN THỊ 25 DỮ LIỆU");
	    // Khởi tạo một trang MainPage của lớp HienThiDuLieu_CapBac_Page
	    HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
	    // Click vào menu HHHV
	    MainPage.HHHVMenu();
	    // Dừng 2 giây
	    Thread.sleep(2000);
	    // Click vào mục cấp bậc
	    MainPage.CapBac();
	    // Dừng 2 giây
	    Thread.sleep(2000);
	    // Chọn hiển thị 25 dữ liệu
	    MainPage.SelectData("25");
	    // In ra dữ liệu đã chọn
	    MainPage.PrintData();
	    System.out.println("============");
	}
	@Test
	public void Action2() throws InterruptedException {
	    System.out.println("Testcase 2: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA CẤP BẬC KHI HIỂN THỊ 50 DỮ LIỆU");
	    HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
	    MainPage.HHHVMenu(); // Chọn menu HHHV
	    Thread.sleep(2000);
	    MainPage.CapBac(); // Chọn mục cấp bậc
	    Thread.sleep(2000);
	    MainPage.SelectData("50"); // Chọn hiển thị 50 dữ liệu
	    MainPage.PrintData(); // In ra dữ liệu đã chọn
	    System.out.println("============");
	}
	@Test
	public void Action3() throws InterruptedException {
	    System.out.println("Testcase 3: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA CẤP BẬC KHI HIỂN THỊ TẤT CẢ DỮ LIỆU");
	    HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
	    MainPage.HHHVMenu(); // Chọn menu HHHV
	    Thread.sleep(2000);
	    MainPage.CapBac(); // Chọn mục cấp bậc
	    Thread.sleep(2000);
	    MainPage.SelectData("-1"); // Chọn hiển thị tất cả dữ liệu
	    MainPage.PrintData(); // In ra dữ liệu đã chọn
	    System.out.println("============");
	}
	@Test(priority = 4)
	public void Action4() throws InterruptedException {
		System.out.println("Testcase 4: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU VÀ ẤN VÀO MÃ CẤP BẬC SẮP XẾP");
		HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.SelectData("25");
		Thread.sleep(2000);
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm phần tử thứ tự và thực hiện click để sắp xếp
	    WebElement thutuElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/thead/tr/th[1]"));
	    Thread.sleep(2000);
	    thutuElement.click();
	    Thread.sleep(2000);
	    // Kiểm tra xem đã sắp xếp thành công hay không
	    String trangtahString = thutuElement.getAttribute("aria-sort");
	    String dowString = "descending";
	    String upString = "ascending";
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp CẤP BẬC tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp CẤP BẬC tăng dần! Thất bại!!");
	    }
	    Thread.sleep(3000);
	    // In ra thông báo về sắp xếp giảm dần
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Thực hiện click để sắp xếp theo thứ tự giảm dần
		 WebElement thutuElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/thead/tr/th[1]"));
	    Thread.sleep(2000);
	    thutuElement2.click();
	    Thread.sleep(2000);
	    // Kiểm tra xem đã sắp xếp thành công hay không
	    String trangtahString2 = thutuElement2.getAttribute("aria-sort");
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp MÃ CẤP BẬC giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp CẤP BẬC giảm dần! Thất bại!!");
	    }
	    System.out.println("==================");
	}
	
	@Test(priority = 5)
	public void Action5() throws InterruptedException {
		System.out.println("Testcase 5: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU VÀ ẤN VÀO MÃ CẤP BẬC SẮP XẾP");
		HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.SelectData("50");
		Thread.sleep(2000);
		 WebElement thutuElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/thead/tr/th[1]"));
		    Thread.sleep(2000);
		    thutuElement.click();
		    Thread.sleep(2000);
		    // Kiểm tra xem đã sắp xếp thành công hay không
		    String trangtahString = thutuElement.getAttribute("aria-sort");
		    String dowString = "descending";
		    String upString = "ascending";
		    if (trangtahString.contains(upString)) {
		        System.out.println("Sắp xếp CẤP BẬC tăng dần! Thành công!!");
		    } else  {
		        System.out.println("Sắp xếp CẤP BẬC tăng dần! Thất bại!!");
		    }
		    Thread.sleep(3000);
		    // In ra thông báo về sắp xếp giảm dần
		    System.out.println("=======");
		    System.out.println("Dữ liệu giảm dần");
		    // Thực hiện click để sắp xếp theo thứ tự giảm dần
			 WebElement thutuElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/thead/tr/th[1]"));
		    Thread.sleep(2000);
		    thutuElement2.click();
		    Thread.sleep(2000);
		    // Kiểm tra xem đã sắp xếp thành công hay không
		    String trangtahString2 = thutuElement2.getAttribute("aria-sort");
		    if (trangtahString2.contains(dowString)) {
		        System.out.println("Sắp xếp MÃ CẤP BẬC giảm dần! Thành công!!");
		    } else  {
		        System.out.println("Sắp xếp MÃ CẤP BẬC giảm dần! Thất bại!!");
		    }
		    System.out.println("==================");
		
	}
	@Test(priority = 6)
	public void Action6() throws InterruptedException {
		System.out.println("Testcase 6: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU VÀ ẤN VÀO MÃ CẤP BẬC SẮP XẾP");
		HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.SelectData("-1");
		Thread.sleep(2000);
		 WebElement thutuElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/thead/tr/th[1]"));
		    Thread.sleep(2000);
		    thutuElement.click();
		    Thread.sleep(2000);
		    // Kiểm tra xem đã sắp xếp thành công hay không
		    String trangtahString = thutuElement.getAttribute("aria-sort");
		    String dowString = "descending";
		    String upString = "ascending";
		    if (trangtahString.contains(upString)) {
		        System.out.println("Sắp xếp MÃ CẤP BẬC tăng dần! Thành công!!");
		    } else  {
		        System.out.println("Sắp xếp MÃ CẤP BẬCtăng dần! Thất bại!!");
		    }
		    Thread.sleep(3000);
		    // In ra thông báo về sắp xếp giảm dần
		    System.out.println("=======");
		    System.out.println("Dữ liệu giảm dần");
		    // Thực hiện click để sắp xếp theo thứ tự giảm dần
			 WebElement thutuElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/thead/tr/th[1]"));
		    Thread.sleep(2000);
		    thutuElement2.click();
		    Thread.sleep(2000);
		    // Kiểm tra xem đã sắp xếp thành công hay không
		    String trangtahString2 = thutuElement2.getAttribute("aria-sort");
		    if (trangtahString2.contains(dowString)) {
		        System.out.println("Sắp xếp MÃ CẤP BẬC giảm dần! Thành công!!");
		    } else  {
		        System.out.println("Sắp xếp MÃ CẤP BẬC giảm dần! Thất bại!!");
		    }
		    System.out.println("==================");
		}
	@AfterTest
	public void Close() {
		driver.close();
	}

}
