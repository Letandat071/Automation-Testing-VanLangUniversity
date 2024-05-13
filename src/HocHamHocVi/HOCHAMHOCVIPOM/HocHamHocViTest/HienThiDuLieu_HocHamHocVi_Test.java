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
import HocHamHocVi.HienThiDuLieu_HocHamHocVi_Page;
import PageSetup.Setup;

public class HienThiDuLieu_HocHamHocVi_Test {
	static WebDriver driver;

	@BeforeSuite
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}

	@BeforeTest
	public void Setup2() throws InterruptedException {
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.Menu();
		Thread.sleep(2000);

	}

	@Test
	public void Action1() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 1: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị 10 dữ liệu
	    MainPage.SelectData("10");
	    // In dữ liệu ra màn hình
	    MainPage.PrintData();
	    System.out.println("========");
	}

	@Test
	public void Action2() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 2: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị 25 dữ liệu
	    MainPage.SelectData("25");
	    // In dữ liệu ra màn hình
	    MainPage.PrintData();
	    System.out.println("========");
	}

	@Test
	public void Action3() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 3: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị 50 dữ liệu
	    MainPage.SelectData("50");
	    // In dữ liệu ra màn hình
	    MainPage.PrintData();
	    System.out.println("========");
	}

	@Test
	public void Action4() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 4: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị tất cả dữ liệu
	    MainPage.SelectData("-1");
	    // In dữ liệu ra màn hình
	    MainPage.PrintData();
	    System.out.println("========");
	}


	@Test(priority = 5)
	public void Action5() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 5: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU VÀ ẤN VÀO MÃ HHHV SẮP XẾP");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị 10 dữ liệu
	    MainPage.SelectData("10");
	    Thread.sleep(2000);
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm và click vào tiêu đề Mã HHHV để sắp xếp
	    WebElement mamonhocElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
	    Thread.sleep(2000);
	    mamonhocElement.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString = mamonhocElement.getAttribute("aria-sort");
	    String dowString = "descending";
	    String upString = "ascending";
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp Mã HHHV tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Mã HHHV tăng dần! Thất bại!!");
	    }
	    Thread.sleep(3000);
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Tìm và click lại vào tiêu đề Mã HHHV để sắp xếp ngược lại
	    WebElement mamonhocElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
	    Thread.sleep(2000);
	    mamonhocElement2.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString2 = mamonhocElement2.getAttribute("aria-sort");
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp Mã HHHV giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Mã HHHV giảm dần! Thất bại!!");
	    }
	    System.out.println("==================");
	}


	@Test(priority = 6)
	public void Action6() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 6: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU VÀ ẤN VÀO MÃ HHHV SẮP XẾP");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị 25 dữ liệu
	    MainPage.SelectData("25");
	    Thread.sleep(2000);
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm và click vào tiêu đề Mã HHHV để sắp xếp
	    WebElement mamonhocElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
	    Thread.sleep(2000);
	    mamonhocElement.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString = mamonhocElement.getAttribute("aria-sort");
	    String dowString = "descending";
	    String upString = "ascending";
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp Mã HHHV tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Mã HHHV tăng dần! Thất bại!!");
	    }
	    Thread.sleep(3000);
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Tìm và click lại vào tiêu đề Mã HHHV để sắp xếp ngược lại
	    WebElement mamonhocElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
	    Thread.sleep(2000);
	    mamonhocElement2.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString2 = mamonhocElement2.getAttribute("aria-sort");
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp Mã HHHV giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Mã HHHV giảm dần! Thất bại!!");
	    }
	    System.out.println("==================");
	}

	@Test(priority = 7)
	public void Action7() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 7:  CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU VÀ ẤN VÀO MÃ HHHV SẮP XẾPp");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị 50 dữ liệu
	    MainPage.SelectData("50");
	    Thread.sleep(2000);
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm và click vào tiêu đề Mã HHHV để sắp xếp
	    WebElement mamonhocElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
	    Thread.sleep(2000);
	    mamonhocElement.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString = mamonhocElement.getAttribute("aria-sort");
	    String dowString = "descending";
	    String upString = "ascending";
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp Mã HHHV tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Mã HHHV tăng dần! Thất bại!!");
	    }
	    Thread.sleep(3000);
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Tìm và click lại vào tiêu đề Mã HHHV để sắp xếp ngược lại
	    WebElement mamonhocElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
	    Thread.sleep(2000);
	    mamonhocElement2.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString2 = mamonhocElement2.getAttribute("aria-sort");
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp Mã HHHV giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Mã HHHV giảm dần! Thất bại!!");
	    }
	    System.out.println("==================");
	}

	@Test(priority = 8)
	public void Action8() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 8:  CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU VÀ ẤN VÀO MÃ HHHV SẮP XẾP");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị tất cả dữ liệu
	    MainPage.SelectData("-1");
	    Thread.sleep(2000);
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm và click vào tiêu đề Mã HHHV để sắp xếp
	    WebElement mamonhocElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
	    Thread.sleep(2000);
	    mamonhocElement.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString = mamonhocElement.getAttribute("aria-sort");
	    String dowString = "descending";
	    String upString = "ascending";
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp Mã HHHV tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Mã HHHV tăng dần! Thất bại!!");
	    }
	    Thread.sleep(3000);
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Tìm và click lại vào tiêu đề Mã HHHV để sắp xếp ngược lại
	    WebElement mamonhocElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
	    Thread.sleep(2000);
	    mamonhocElement2.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString2 = mamonhocElement2.getAttribute("aria-sort");
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp Mã HHHV giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Mã HHHV giảm dần! Thất bại!!");
	    }
	    System.out.println("==================");
	}

	@Test(priority = 9)
	public void Action9() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 9: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU VÀ ẤN VÀO TÊN HHHV SẮP XẾP");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị 10 dữ liệu
	    MainPage.SelectData("10");
	    Thread.sleep(2000);
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm và click vào tiêu đề Tên HHHV để sắp xếp
	    WebElement tenhhhvElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
	    Thread.sleep(2000);
	    tenhhhvElement.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString = tenhhhvElement.getAttribute("aria-sort");
	    String dowString = "descending";
	    String upString = "ascending";
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp Tên HHHV tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Tên HHHV tăng dần! Thất bại!!");
	    }
	    Thread.sleep(3000);
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Tìm và click lại vào tiêu đề Tên HHHV để sắp xếp ngược lại
	    WebElement tenhhhvElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
	    Thread.sleep(2000);
	    tenhhhvElement2.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString2 = tenhhhvElement2.getAttribute("aria-sort");
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp Tên HHHV giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Tên HHHV giảm dần! Thất bại!!");
	    }
	    System.out.println("==================");
	}

	@Test(priority = 10)
	public void Action10() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 10: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU VÀ ẤN VÀO TÊN HHHV SẮP XẾP");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị 25 dữ liệu
	    MainPage.SelectData("25");
	    Thread.sleep(2000);
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm và click vào tiêu đề Tên HHHV để sắp xếp
	    WebElement tenhhhvElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
	    Thread.sleep(2000);
	    tenhhhvElement.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString = tenhhhvElement.getAttribute("aria-sort");
	    String dowString = "descending";
	    String upString = "ascending";
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp Tên HHHV tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Tên HHHV tăng dần! Thất bại!!");
	    }
	    Thread.sleep(3000);
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Tìm và click lại vào tiêu đề Tên HHHV để sắp xếp ngược lại
	    WebElement tenhhhvElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
	    Thread.sleep(2000);
	    tenhhhvElement2.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString2 = tenhhhvElement2.getAttribute("aria-sort");
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp Tên HHHV giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Tên HHHV giảm dần! Thất bại!!");
	    }
	    System.out.println("==================");
	}

	@Test(priority = 11)
	public void Action11() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 11:  CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU VÀ ẤN VÀO TÊN HHHV SẮP XẾP");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị 50 dữ liệu
	    MainPage.SelectData("50");
	    Thread.sleep(2000);
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm và click vào tiêu đề Tên HHHV để sắp xếp
	    WebElement tenhhhvElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
	    Thread.sleep(2000);
	    tenhhhvElement.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString = tenhhhvElement.getAttribute("aria-sort");
	    String dowString = "descending";
	    String upString = "ascending";
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp Tên HHHV tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Tên HHHV tăng dần! Thất bại!!");
	    }
	    Thread.sleep(3000);
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Tìm và click lại vào tiêu đề Tên HHHV để sắp xếp ngược lại
	    WebElement tenhhhvElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
	    Thread.sleep(2000);
	    tenhhhvElement2.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString2 = tenhhhvElement2.getAttribute("aria-sort");
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp Tên HHHV giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Tên HHHV giảm dần! Thất bại!!");
	    }
	    System.out.println("==================");
	}

	@Test(priority = 12)
	public void Action12() throws InterruptedException {
	    // In ra thông tin về testcase
	    System.out.println("Testcase 12:  CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU VÀ ẤN VÀO TÊN HHHV SẮP XẾP");
	    // Khởi tạo trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Truy cập mục Học hàm, học vị trong Menu
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị tất cả dữ liệu
	    MainPage.SelectData("-1");
	    Thread.sleep(2000);
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm và click vào tiêu đề Tên HHHV để sắp xếp
	    WebElement tenhhhvElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
	    Thread.sleep(2000);
	    tenhhhvElement.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString = tenhhhvElement.getAttribute("aria-sort");
	    String dowString = "descending";
	    String upString = "ascending";
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp Tên HHHV tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Tên HHHV tăng dần! Thất bại!!");
	    }
	    Thread.sleep(3000);
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Tìm và click lại vào tiêu đề Tên HHHV để sắp xếp ngược lại
	    WebElement tenhhhvElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
	    Thread.sleep(2000);
	    tenhhhvElement2.click();
	    Thread.sleep(2000);
	    // Kiểm tra trạng thái của sắp xếp
	    String trangtahString2 = tenhhhvElement2.getAttribute("aria-sort");
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp Tên HHHV giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp Tên HHHV giảm dần! Thất bại!!");
	    }
	    System.out.println("==================");
	}

	@Test(priority = 13)
	public void Action13() throws InterruptedException {
	    // In ra mô tả của testcase
	    System.out.println("Testcase 13: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU VÀ ẤN VÀO THỨ TỰ SẮP XẾP");
	    // Khởi tạo một đối tượng trang chủ
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Mở menu HHHV
	    MainPage.HHHVMenu();
	    // Chờ 2 giây
	    Thread.sleep(2000);
	    // Chọn hiển thị 10 dòng dữ liệu
	    MainPage.SelectData("10");
	    // Chờ 2 giây
	    Thread.sleep(2000);
	    // In ra thông báo về dữ liệu tăng dần
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm và click vào tiêu đề "Thứ tự" để sắp xếp
	    WebElement thutuElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[4]"));
	    Thread.sleep(2000);
	    thutuElement.click();
	    Thread.sleep(2000);
	    // Lấy thông tin về thứ tự sắp xếp hiện tại
	    String trangtahString = thutuElement.getAttribute("aria-sort");
	    String dowString = "descending"; // Sắp xếp giảm dần
	    String upString = "ascending"; // Sắp xếp tăng dần
	    // Kiểm tra xem thứ tự sắp xếp có phải là tăng dần không
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp THỨ TỰ tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp THỨ TỰ tăng dần! Thất bại!!");
	    }
	    // Chờ 3 giây
	    Thread.sleep(3000);
	    // In ra thông báo về dữ liệu giảm dần
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Tìm và click lại vào tiêu đề "Thứ tự" để đảo ngược thứ tự sắp xếp
	    WebElement thutuElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[4]"));
	    Thread.sleep(2000);
	    thutuElement2.click();
	    Thread.sleep(2000);
	    // Lấy thông tin về thứ tự sắp xếp sau khi đảo ngược
	    String trangtahString2 = thutuElement2.getAttribute("aria-sort");
	    // Kiểm tra xem thứ tự sắp xếp có phải là giảm dần không
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp THỨ TỰ giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp THỨ TỰ giảm dần! Thất bại!!");
	    }
	    // In ra dấu phân tách để phân biệt giữa các testcase
	    System.out.println("==================");
	}

	@Test(priority = 14)
	public void Action14() throws InterruptedException {
	    // In ra mô tả của testcase
	    System.out.println("Testcase 14: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU VÀ ẤN VÀO THỨ TỰ SẮP XẾP");
	    // Khởi tạo một đối tượng trang HienThiDuLieu_HocHamHocVi_Page
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Mở menu chức năng hiển thị
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị 25 dữ liệu
	    MainPage.SelectData("25");
	    Thread.sleep(2000);
	    // In ra thông báo về sắp xếp tăng dần
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm phần tử thứ tự và thực hiện click để sắp xếp
	    WebElement thutuElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[4]"));
	    Thread.sleep(2000);
	    thutuElement.click();
	    Thread.sleep(2000);
	    // Kiểm tra xem đã sắp xếp thành công hay không
	    String trangtahString = thutuElement.getAttribute("aria-sort");
	    String dowString = "descending";
	    String upString = "ascending";
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp THỨ TỰ tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp THỨ TỰ tăng dần! Thất bại!!");
	    }
	    Thread.sleep(3000);
	    // In ra thông báo về sắp xếp giảm dần
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Thực hiện click để sắp xếp theo thứ tự giảm dần
	    WebElement thutuElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[4]"));
	    Thread.sleep(2000);
	    thutuElement2.click();
	    Thread.sleep(2000);
	    // Kiểm tra xem đã sắp xếp thành công hay không
	    String trangtahString2 = thutuElement2.getAttribute("aria-sort");
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp THỨ TỰ giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp THỨ TỰ giảm dần! Thất bại!!");
	    }
	    System.out.println("==================");
	}

	@Test(priority = 15)
	public void Action15() throws InterruptedException {
	    // Mô tả testcase
	    System.out.println("Testcase 15: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU VÀ ẤN VÀO THỨ TỰ SẮP XẾP");
	    HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
	    // Mở menu hiển thị
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Chọn hiển thị 50 dữ liệu
	    MainPage.SelectData("50");
	    Thread.sleep(2000);
	    // In ra thông báo về sắp xếp tăng dần
	    System.out.println("Dữ liệu tăng dần");
	    // Tìm phần tử thứ tự và thực hiện click để sắp xếp
	    WebElement thutuElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[4]"));
	    Thread.sleep(2000);
	    thutuElement.click();
	    Thread.sleep(2000);
	    // Kiểm tra xem đã sắp xếp thành công hay không
	    String trangtahString = thutuElement.getAttribute("aria-sort");
	    String dowString = "descending";
	    String upString = "ascending";
	    if (trangtahString.contains(upString)) {
	        System.out.println("Sắp xếp THỨ TỰ tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp THỨ TỰ tăng dần! Thất bại!!");
	    }
	    Thread.sleep(3000);
	    // In ra thông báo về sắp xếp giảm dần
	    System.out.println("=======");
	    System.out.println("Dữ liệu giảm dần");
	    // Thực hiện click để sắp xếp theo thứ tự giảm dần
	    WebElement thutuElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[4]"));
	    Thread.sleep(2000);
	    thutuElement2.click();
	    Thread.sleep(2000);
	    // Kiểm tra xem đã sắp xếp thành công hay không
	    String trangtahString2 = thutuElement2.getAttribute("aria-sort");
	    if (trangtahString2.contains(dowString)) {
	        System.out.println("Sắp xếp THỨ TỰ giảm dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp THỨ TỰ giảm dần! Thất bại!!");
	    }
	    System.out.println("==================");
	}
	 
	@AfterTest
	public void Close() {
		driver.close();
	}
}
