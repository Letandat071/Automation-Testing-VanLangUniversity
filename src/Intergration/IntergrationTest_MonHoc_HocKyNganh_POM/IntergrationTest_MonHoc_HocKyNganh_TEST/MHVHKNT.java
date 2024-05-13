package IntergrationTest_MonHoc_HocKyNganh_TEST;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import IntergrationsTest_MonHoc_HocKyNganh_PAGE.MHVHKNP;
import PageSetup.Setup;

public class MHVHKNT {
	static WebDriver driver;
	@BeforeTest
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}
//	@BeforeTest
//	public void Setup2() throws InterruptedException {
//		MHVHKNP MainPage = new MHVHKNP(driver);
//		MainPage.OpenHK();
//	}
	@Test(priority = 1)
	public void Action1() throws InterruptedException, IOException {
	    // In ra thông báo cho Testcase 1
	    System.out.println("Testcase 1: Tạo học kỳ mới bên mục Học Kỳ và kiểm tra trong textbox của mục Môn Học");
	    
	    // Khởi tạo trang MHVHKNP
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    // Click vào nút Thêm học kỳ
	    MainPage.AddHKButton();
	    Thread.sleep(2000);
	    
	    // Thêm học kỳ "180"
	    MainPage.themHocKy("180");
	    
	    // Click vào nút Lưu
	    MainPage.SaveHKButton();
	    Thread.sleep(2000);
	    
	    // Click vào menu điều hướng
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    
	    // Click vào mục Môn học
	    MainPage.MonHoc();
	    
	    // Kiểm tra xem học kỳ "180" có tồn tại trong textbox hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("180")) {
	        System.out.println("Dữ liệu học kỳ 180 đã tạo tại Học Kỳ đã tồn tại trong textbox học kỳ Môn Học ");
	    } else {
	        System.out.println("Dữ liệu học kỳ 180 đã tạo tại Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	    }
	    System.out.println("============");
	    driver.navigate().refresh();
	}

	@Test(priority = 2)
	public void Action2() throws InterruptedException, IOException {
	    // In ra thông báo cho Testcase 2
	    System.out.println("Testcase 2: Tạo học kỳ mới bên mục Học Kỳ và ấn Hủy và kiểm tra trong textbox của mục Môn Học");
	    
	    // Khởi tạo trang MHVHKNP
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    // Click vào nút Thêm học kỳ
	    MainPage.AddHKButton();
	    Thread.sleep(2000);
	    
	    // Thêm học kỳ "187"
	    MainPage.themHocKy("187");
	    
	    // Click vào nút Hủy
	    MainPage.CloseHKButton();
	    Thread.sleep(2000);
	    
	    // Click vào menu điều hướng
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    
	    // Click vào mục Môn học
	    MainPage.MonHoc();
	    
	    // Kiểm tra xem học kỳ "187" có tồn tại trong textbox hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("187")) {
	        System.out.println("Dữ liệu 187 được tạo và ấn Hủy tại Học Kỳ đã tồn tại trong textbox học kỳ Môn Học ");
	    } else {
	        System.out.println("Dữ liệu 187 được tạo và ấn Hủy tại Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	    }
	    System.out.println("============");
	    driver.navigate().refresh();

	}
	@Test(priority = 3)
	public void Action3() throws InterruptedException, IOException {
	    // In ra mô tả của testcase
	    System.out.println("Testcase 3: Chỉnh sửa Học kỳ bên mục Học Kỳ và kiểm tra textbox của mục Môn Học");
	    
	    // Khởi tạo một đối tượng MHVHKNP
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    // Nhập từ khóa "180" vào ô tìm kiếm trên bảng Học Kỳ
	    driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("180");
	    Thread.sleep(2000);
	    
	    // Click vào liên kết để chỉnh sửa học kỳ đầu tiên trong bảng
	    driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[1]")).click();
	    Thread.sleep(2000);
	    
	    // Click nút Lưu sau khi chỉnh sửa
	    driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
	    Thread.sleep(2000);
	    
	    // Chọn một phần tử để xác định thời gian
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[13]")).click();
	    
	    // Gọi phương thức SaveHKButton() của đối tượng MainPage để lưu thay đổi
	    MainPage.SaveHKButton();
	    Thread.sleep(2000);
	    
	    // Điều hướng đến menu
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    
	    // Chọn mục Môn học
	    MainPage.MonHoc();
	    
	    // Lấy mã nguồn của trang và kiểm tra xem "180" có tồn tại trong mã nguồn hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("180")) {
	        System.out.println("Dữ liệu học kỳ 180 đã chỉnh sửa tại Học Kỳ đã tồn tại trong textbox học kỳ Môn Học ");
	    } else {
	        System.out.println("Dữ liệu học kỳ 180 đã chỉnh sửa Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	    }
	    System.out.println("============");
	    driver.navigate().refresh();

	}

	@Test(priority = 4)
	public void Action4() throws InterruptedException, IOException {
	    System.out.println("Testcase 4: Chỉnh sửa Học kỳ bên mục Học Kỳ và ấn Hủy và kiểm tra textbox của mục Môn Học");
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    // Nhập từ khóa "180" vào ô tìm kiếm trên bảng Học Kỳ
	    driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("180");
	    Thread.sleep(2000);
	    
	    // Click vào liên kết để chỉnh sửa học kỳ đầu tiên trong bảng
	    driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[1]")).click();
	    Thread.sleep(2000);
	    
	    // Click nút Hủy sau khi chỉnh sửa và chọn một phần tử để xác định thời gian
	    driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[13]")).click();
	    
	    // Gọi phương thức SaveHKButton từ đối tượng MainPage để kiểm tra việc hủy chỉnh sửa
	    MainPage.SaveHKButton();
	    Thread.sleep(2000);
	    
	    // Điều hướng đến menu và chọn mục Môn học
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    MainPage.MonHoc();
	    
	    // Kiểm tra xem chuỗi "180" có tồn tại trong mã nguồn hay không để xác định việc chỉnh sửa đã bị hủy thành công hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("180")) {
	        System.out.println("Dữ liệu học kỳ 180 đã Hủy chỉnh sửa tại Học Kỳ đã tồn tại trong textbox học kỳ Môn Học ");
	    } else {
	        System.out.println("Dữ liệu học kỳ 180 đã Hủy chỉnh sửa Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	    }
	    System.out.println("============");
	    driver.navigate().refresh();

	}

	@Test(priority = 5)
	public void Action5() throws InterruptedException, IOException {
	    System.out.println("Testcase 5: Xóa Học kỳ bên mục Học Kỳ và ấn Hủy và kiểm tra textbox của mục Môn Học");
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    // Nhập từ khóa "180" vào ô tìm kiếm trên bảng Học Kỳ
	    driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("180");
	    Thread.sleep(2000);
	    
	    // Gọi phương thức CloseHKDelete từ đối tượng MainPage để hủy xóa học kỳ
	    MainPage.CloseHKDelete();
	    Thread.sleep(2000);
	    
	    // Điều hướng đến menu và chọn mục Môn học
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    MainPage.MonHoc();
	    
	    // Kiểm tra xem chuỗi "180" có tồn tại trong mã nguồn hay không để xác định việc xóa đã bị hủy thành công hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("180")) {
	        System.out.println("Dữ liệu học kỳ 180 đã Hủy xóa tại Học Kỳ vẫn tồn tại trong textbox học kỳ Môn Học ");
	    } else {
	        System.out.println("Dữ liệu học kỳ 180 đã Hủy xóa tại Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	    }
	    System.out.println("============");
	    driver.navigate().refresh();

	}

	@Test(priority = 6)
	public void Action6() throws InterruptedException, IOException {
	    System.out.println("Testcase 6: Xóa Học kỳ bên mục Học Kỳ và kiểm tra textbox của mục Môn Học");
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    Thread.sleep(2000);	    // Nhập từ khóa "180" vào ô tìm kiếm trên bảng Học Kỳ
	    driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("180");
	    Thread.sleep(2000);
	    
	    // Gọi phương thức DeleteHK từ đối tượng MainPage để xóa học kỳ
	    MainPage.DeleteHK();
	    Thread.sleep(2000);
	    
	    // Điều hướng đến menu và chọn mục Môn học
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    MainPage.MonHoc();
	    
	    // Kiểm tra xem chuỗi "180" có tồn tại trong mã nguồn hay không để xác định việc xóa đã thành công hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("180")) {
	        System.out.println("Dữ liệu học kỳ 180 đã Xóa tại Học Kỳ vẫn tồn tại trong textbox học kỳ Môn Học ");
	    } else {
	        System.out.println("Dữ liệu học kỳ 180 đã Xóa tại Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	    }
	    System.out.println("============");
	    driver.navigate().refresh();

	}

	@Test(priority = 7)
	public void Action7() throws InterruptedException, IOException {
	    System.out.println("Testcase 7: Tạo ngành mới bên mục Ngành và kiểm tra textbox của môn học");
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    // Chuyển đến tab Ngành
	    MainPage.TabNganh();
	    Thread.sleep(2000);
	    
	    // Click nút để thêm ngành
	    MainPage.AddNganhButton();
	    Thread.sleep(2000);
	    
	    // Nhập thông tin ngành mới
	    MainPage.InputDataNganh("14102003", "KhangCNTT", "KIT");
	    MainPage.SaveNganhButton();
	    Thread.sleep(2000);
	    
	    // Điều hướng đến menu và chọn mục Môn học
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    MainPage.MonHoc();
	    
	    // Kiểm tra xem thông tin ngành vừa tạo có xuất hiện trong mã nguồn hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("KhangCNTT")) {
	        System.out.println("Dữ liệu Ngành KhangCNTT đã tạo tại Ngành đã tồn tại trong textbox ngành của Môn Học ");
	    } else {
	        System.out.println("Dữ liệu Ngành KhangCNTT đã tạo tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	    }
	    System.out.println("============");
	    driver.navigate().refresh();

	}

	@Test(priority = 8)
	public void Action8() throws InterruptedException, IOException {
	    System.out.println("Testcase 8:Tạo ngành mới bên mục Ngành và ấn Hủy và kiểm tra textbox của môn học ");
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    // Chuyển đến tab Ngành
	    MainPage.TabNganh();
	    Thread.sleep(2000);
	    
	    // Click nút để thêm ngành
	    MainPage.AddNganhButton();
	    Thread.sleep(2000);
	    
	    // Nhập thông tin ngành mới
	    MainPage.InputDataNganh("14102003", "KhangCNTT01", "KIT");
	    
	    // Hủy việc thêm ngành mới
	    MainPage.CloseNganhButton();
	    Thread.sleep(2000);
	    
	    // Điều hướng đến menu và chọn mục Môn học
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    MainPage.MonHoc();
	    
	    // Kiểm tra xem thông tin ngành vừa tạo có xuất hiện trong mã nguồn hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("KhangCNTT01")) {
	        System.out.println("Dữ liệu Ngành KhangCNTT01 đã Hủy tạo tại Ngành đã tồn tại trong textbox ngành của Môn Học ");
	    } else {
	        System.out.println("Dữ liệu Ngành KhangCNTT01 đã Hủy tạo tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	    }
	    System.out.println("============");
	    driver.navigate().refresh();

	}

	@Test(priority = 9)
	public void Action9() throws InterruptedException, IOException {
	    System.out.println("Testcase 9: Chỉnh sửa ngành bên mục Ngành và kiểm tra textbox của môn học");
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    // Chuyển đến tab Ngành
	    MainPage.TabNganh();
	    Thread.sleep(2000);
	    
	    // Tìm kiếm ngành cần chỉnh sửa
	    driver.findElement(By.xpath("//*[@id=\"tblMajor_filter\"]/label/input")).sendKeys("KhangCNTT");
	    Thread.sleep(2000);
	    
	    // Click để chỉnh sửa ngành
	    driver.findElement(By.xpath("//*[@id=\"tblMajor\"]/tbody/tr/td[6]/a[1]")).click();
	    Thread.sleep(2000);
	    
	    // Xóa thông tin cũ và nhập thông tin mới
	    WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    nameInput.clear();
	    nameInput.sendKeys("KhangCNTTUpdate");
	    
	    // Lưu thay đổi
	    MainPage.SaveNganhButton();
	    Thread.sleep(2000);
	    
	    // Điều hướng đến menu và chọn mục Môn học
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    MainPage.MonHoc();
	    
	    // Kiểm tra xem thông tin ngành đã chỉnh sửa có xuất hiện trong mã nguồn hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("KhangCNTTUpdate")) {
	        System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã chỉnh sửa tại Ngành đã tồn tại trong textbox ngành của Môn Học ");
	    } else {
	        System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã chỉnh sửa tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	    }
	    System.out.println("============");
	    driver.navigate().refresh();

	}

	@Test(priority = 10)
	public void Action10() throws InterruptedException, IOException {
	    System.out.println("Testcase 10: Chỉnh sửa ngành và ấn Hủy bên mục Ngành và kiểm tra textbox của mục Môn Học");
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    // Chuyển đến tab Ngành
	    MainPage.TabNganh();
	    Thread.sleep(2000);
	    
	    // Tìm kiếm ngành cần chỉnh sửa
	    driver.findElement(By.xpath("//*[@id=\"tblMajor_filter\"]/label/input")).sendKeys("KhangCNTTUpdate");
	    Thread.sleep(2000);
	    
	    // Click để chỉnh sửa ngành
	    driver.findElement(By.xpath("//*[@id=\"tblMajor\"]/tbody/tr/td[6]/a[1]")).click();
	    Thread.sleep(2000);
	    
	    // Xóa thông tin cũ và nhập thông tin mới
	    WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    nameInput.clear();
	    nameInput.sendKeys("KhangCNTTUpdate2");
	    
	    // Hủy việc chỉnh sửa ngành
	    MainPage.CloseNganhButton();
	    Thread.sleep(2000);
	    
	    // Điều hướng đến menu và chọn mục Môn học
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    MainPage.MonHoc();
	    
	    // Kiểm tra xem thông tin ngành đã chỉnh sửa có xuất hiện trong mã nguồn hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("KhangCNTTUpdate2")) {
	        System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Hủy chỉnh sửa tại Ngành đã tồn tại trong textbox ngành của Môn Học ");
	    } else {
	        System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Hủy chỉnh sửa tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	    }
	    System.out.println("============");
	    driver.navigate().refresh();

	}

	@Test(priority = 11)
	public void Action11() throws InterruptedException, IOException {
	    System.out.println("Testcase 11: Xóa ngành và ấn Hủy bên mục Ngành và kiểm tra textbox của mục Môn Học");
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    // Chuyển đến tab Ngành
	    MainPage.TabNganh();
	    Thread.sleep(2000);
	    
	    // Tìm kiếm ngành cần xóa
	    driver.findElement(By.xpath("//*[@id=\"tblMajor_filter\"]/label/input")).sendKeys("KhangCNTTUpdate");
	    
	    // Hủy việc xóa ngành
	    MainPage.CloseNganhDelete();
	    Thread.sleep(2000);
	    
	    // Điều hướng đến menu và chọn mục Môn học
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    MainPage.MonHoc();
	    
	    // Kiểm tra xem thông tin ngành đã xóa có xuất hiện trong mã nguồn hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("KhangCNTTUpdate")) {
	        System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Hủy xóa tại Ngành vẫn tồn tại trong textbox ngành của Môn Học ");
	    } else {
	        System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Hủy xóa tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	    }
	    System.out.println("============");
	    driver.navigate().refresh();

	}

	@Test(priority = 12)
	public void Action12() throws InterruptedException, IOException {
	    System.out.println("Testcase 12: Xóa ngành bên mục Ngành và kiểm tra textbox của mục Môn Học");
	    MHVHKNP MainPage = new MHVHKNP(driver);
	    MainPage.OpenHK();
	    // Chuyển đến tab Ngành
	    MainPage.TabNganh();
	    Thread.sleep(2000);
	    
	    // Tìm kiếm ngành cần xóa
	    driver.findElement(By.xpath("//*[@id=\"tblMajor_filter\"]/label/input")).sendKeys("KhangCNTTUpdate");
	    
	    // Xác nhận việc xóa ngành
	    MainPage.DeleteNganh();
	    Thread.sleep(2000);
	    
	    // Điều hướng đến menu và chọn mục Môn học
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    MainPage.MonHoc();
	    
	    // Kiểm tra xem thông tin ngành đã xóa có xuất hiện trong mã nguồn hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("KhangCNTTUpdate")) {
	        System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Xóa tại Ngành vẫn tồn tại trong textbox ngành của Môn Học ");
	    } else {
	        System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Xóa tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	    }
	    System.out.println("============");
	}

}
