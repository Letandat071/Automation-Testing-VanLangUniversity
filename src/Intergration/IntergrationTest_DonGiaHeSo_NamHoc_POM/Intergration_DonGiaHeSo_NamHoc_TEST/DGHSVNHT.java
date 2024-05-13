package Intergration_DonGiaHeSo_NamHoc_TEST;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import IntergrationTest_DonGiaHeSo_NamHoc_PAGE.DGHSVNHP;
import PageSetup.Setup;

public class DGHSVNHT {
	static WebDriver driver;
	private By inputHK = By.xpath("//*[@id=\"id\"]");
	private By startYearDropdown = By.id("start_year");
	private By endYearDropdown = By.id("end_year");
	private By startWeekInput = By.xpath("//*[@id=\"start_week\"]");
	private By maxLessonInput = By.xpath("//*[@id=\"max_lesson\"]");
	private By maxClassInput = By.xpath("//*[@id=\"max_class\"]");
	@BeforeTest
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}
	@Test
	public void Action1() throws InterruptedException, IOException {
	    // In ra tên của Testcase
	    System.out.println("Testcase 1: Tạo Học Kỳ để lấy Năm học và sang mục Đơn giá và hệ số kiểm tra  ");
	    
	    // Khởi tạo một đối tượng DGHSVNHP để thực hiện các hành động
	    DGHSVNHP MainPage = new DGHSVNHP(driver);
	    
	    // Chọn mục Học kỳ từ menu
	    MainPage.MenuHK();
	    Thread.sleep(2000);
	    
	    // Nhấn nút thêm mới Học kỳ
	    MainPage.AddNewTermButton();
	    Thread.sleep(2000);
	    
	    // Nhập thông tin cho Học kỳ, bao gồm năm học, số tuần bắt đầu, số buổi học tối đa, số lớp học tối đa
	    // Lưu ý: Các element như inputHK, startYearDropdown, endYearDropdown, startWeekInput, maxLessonInput, maxClassInput phải được khai báo ở nơi khác
	    // Ví dụ: private By inputHK = By.id("inputHK");
	    driver.findElement(inputHK).sendKeys("198");
	    // Tiếp tục nhập các thông tin cần thiết khác như startYear, endYear, startWeek, maxLesson, maxClass
	    
	    // Click vào nút lưu
	    driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
	    Thread.sleep(2000);
	    
	    // Chọn một phần tử để xác định thời gian
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();
	    
	    // Lưu thông tin Học kỳ và kiểm tra việc lưu thành công
	    MainPage.SaveHKButton();
	    
	    // In ra dấu phân cách
	    System.out.println("=========");
	    // In ra thông điệp báo hiệu chuyển sang mục Đơn giá và Hệ số
	    System.out.println("CHuyển sang Đơn Giá và Hệ Số");
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Menu
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Đơn giá và Hệ số
	    MainPage.DGVHS();
	    
	    // Kiểm tra xem thông tin về năm học đã được lưu thành công và hiển thị trên textbox Năm học ở mục Đơn giá và Hệ số hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("2030 - 2031")) {
	        System.out.println("Dữ liệu 2030 - 2031 đã tạo tại Học Kỳ và tồn tại trong textbox Năm Học ");
	    } else {
	        System.out.println("Dữ liệu 2030 - 2031 đã tạo tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	    }
	    System.out.println("============");
	}

	@Test
	public void Action2() throws InterruptedException, IOException {
	    // In ra tên của Testcase
	    System.out.println("Testcase 2: Tạo Học Kỳ để lấy Năm học và ấn Hủy và sang mục Đơn giá và hệ số kiểm tra  ");
	    
	    // Khởi tạo một đối tượng DGHSVNHP để thực hiện các hành động
	    DGHSVNHP MainPage = new DGHSVNHP(driver);
	    
	    // Chọn mục Học kỳ từ menu
	    MainPage.MenuHK();
	    Thread.sleep(2000);
	    
	    // Nhấn nút thêm mới Học kỳ
	    MainPage.AddNewTermButton();
	    Thread.sleep(2000);
	    
	    // Nhập thông tin cho Học kỳ, bao gồm năm học, số tuần bắt đầu, số buổi học tối đa, số lớp học tối đa
	    // Lưu ý: Các element như inputHK, startYearDropdown, endYearDropdown, startWeekInput, maxLessonInput, maxClassInput phải được khai báo ở nơi khác
	    // Ví dụ: private By inputHK = By.id("inputHK");
	    driver.findElement(inputHK).sendKeys("199");
	    // Tiếp tục nhập các thông tin cần thiết khác như startYear, endYear, startWeek, maxLesson, maxClass
	    
	    // Click vào nút lưu
	    driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
	    Thread.sleep(2000);
	    
	    // Chọn một phần tử để xác định thời gian
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();
	    
	    // Lưu thông tin Học kỳ và kiểm tra việc lưu thành công
	    MainPage.CloseHKButton();
	    
	    // In ra dấu phân cách
	    System.out.println("=========");
	    // In ra thông điệp báo hiệu chuyển sang mục Đơn giá và Hệ số
	    System.out.println("CHuyển sang Đơn Giá và Hệ Số");
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Menu
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Đơn giá và Hệ số
	    MainPage.DGVHS();
	    
	    // Kiểm tra xem thông tin về năm học đã được lưu thành công và hiển thị trên textbox Năm học ở mục Đơn giá và Hệ số hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("2014 - 2015")) {
	        System.out.println("Dữ liệu 2014 - 2015 đã ấn Hủy tại Học Kỳ và tồn tại trong textbox Năm Học ");
	    } else {
	        System.out.println("Dữ liệu 2014 - 2015 đã ấn Hủy tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	    }
	    System.out.println("============");
	}

	@Test
	public void Action3() throws InterruptedException, IOException {
	    // In ra tên của Testcase
	    System.out.println("Testcase 3: Chỉnh sửa Học Kỳ và chỉnh sửa Năm học và sang mục Đơn giá và hệ số kiểm tra  ");
	    
	    // Khởi tạo một đối tượng DGHSVNHP để thực hiện các hành động
	    DGHSVNHP MainPage = new DGHSVNHP(driver);
	    
	    // Chọn mục Học kỳ từ menu
	    MainPage.MenuHK();
	    Thread.sleep(2000);
	    
	    // Tìm và chọn Học kỳ cần chỉnh sửa
	    driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("198");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();
	    Thread.sleep(2000);
	    
	    // Chỉnh sửa thông tin của Học kỳ
	    // Lấy element dropdown của Năm học bắt đầu và kết thúc
	    Select startYearSelect = new Select(driver.findElement(startYearDropdown));
	    Select endYearSelect = new Select(driver.findElement(endYearDropdown));
	    // Chọn giá trị mới cho dropdown của Năm học bắt đầu và kết thúc
	    startYearSelect.selectByValue("2028");
	    endYearSelect.selectByValue("2030");
	    Thread.sleep(2000);
	    
	    // Nhập số tuần bắt đầu học kỳ
	    WebElement startWeek = driver.findElement(startWeekInput);
	    startWeek.clear();
	    Thread.sleep(3000);
	    Random random = new Random();
	    int randomNumber = random.nextInt(52) + 1;
	    String randomString = Integer.toString(randomNumber);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString + "';", startWeek);
	    Thread.sleep(2000);
	    
	    // Click vào nút lưu
	    driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
	    Thread.sleep(2000);
	    
	    // Chọn một phần tử để xác định thời gian
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();
	    
	    // Lưu thông tin chỉnh sửa Học kỳ và kiểm tra việc lưu thành công
	    MainPage.SaveHKButton();
	    
	    // In ra dấu phân cách
	    System.out.println("=========");
	    // In ra thông điệp báo hiệu chuyển sang mục Đơn giá và Hệ số
	    System.out.println("CHuyển sang Đơn Giá và Hệ Số");
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Menu
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Đơn giá và Hệ số
	    MainPage.DGVHS();
	    
	    // Kiểm tra xem thông tin về năm học đã được chỉnh sửa thành công và hiển thị trên textbox Năm học ở mục Đơn giá và Hệ số hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("2028 - 2030")) {
	        System.out.println("Dữ liệu 2028 - 2030 đã chỉnh sửa tại Học Kỳ và tồn tại trong textbox Năm Học ");
	    } else {
	        System.out.println("Dữ liệu 2028 - 2030 đã chỉnh sửa tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	    }
	    System.out.println("============");
	}


	@Test
	public void Action4() throws InterruptedException, IOException {
	    // In ra tên của Testcase
	    System.out.println("Testcase 4:  Chỉnh sửa Học Kỳ và chỉnh sửa Năm học và ấn Hủy và sang mục Đơn giá và hệ số kiểm tra   ");
	    
	    // Khởi tạo một đối tượng DGHSVNHP để thực hiện các hành động
	    DGHSVNHP MainPage = new DGHSVNHP(driver);
	    
	    // Chọn mục Học kỳ từ menu
	    MainPage.MenuHK();
	    Thread.sleep(2000);
	    
	    // Tìm và chọn Học kỳ cần chỉnh sửa thông qua ô tìm kiếm và click vào liên kết chỉnh sửa
	    driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("198");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();
	    Thread.sleep(2000);
	    
	    // Chỉnh sửa thông tin của Học kỳ
	    // Lấy element dropdown của Năm học bắt đầu và kết thúc
	    Select startYearSelect = new Select(driver.findElement(startYearDropdown));
	    Select endYearSelect = new Select(driver.findElement(endYearDropdown));
	    // Chọn giá trị mới cho dropdown của Năm học bắt đầu và kết thúc
	    startYearSelect.selectByValue("2029");
	    endYearSelect.selectByValue("2030");
	    Thread.sleep(2000);
	    
	    // Nhập số tuần bắt đầu học kỳ
	    WebElement startWeek = driver.findElement(startWeekInput);
	    startWeek.clear();
	    Thread.sleep(3000);
	    Random random = new Random();
	    int randomNumber = random.nextInt(52) + 1;
	    String randomString = Integer.toString(randomNumber);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString + "';", startWeek);
	    Thread.sleep(2000);
	    
	    // Click vào nút lưu
	    driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
	    Thread.sleep(2000);
	    
	    // Chọn một phần tử để xác định thời gian
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();
	    
	    // Lưu thông tin chỉnh sửa Học kỳ và kiểm tra xem việc lưu thành công hay không
	    MainPage.CloseHKButton();
	    
	    // In ra dấu phân cách
	    System.out.println("=========");
	    // In ra thông điệp báo hiệu chuyển sang mục Đơn giá và Hệ số
	    System.out.println("CHuyển sang Đơn Giá và Hệ Số");
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Menu
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Đơn giá và Hệ số
	    MainPage.DGVHS();
	    
	    // Kiểm tra xem thông tin về năm học đã được chỉnh sửa thành công và hiển thị trên textbox Năm học ở mục Đơn giá và Hệ số hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("2029 - 2030")) {
	        System.out.println("Dữ liệu 2029 - 2030 ấn Hủy chỉnh sửa tại Học Kỳ và tồn tại trong textbox Năm Học ");
	    } else {
	        System.out.println("Dữ liệu 2029 - 2030 ấn Hủy chỉnh sửa tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	    }
	    System.out.println("============");
	}


	@Test
	public void Action5() throws InterruptedException, IOException {
	    // In ra tên của Testcase
	    System.out.println("Testcase 5:  Xóa Học Kỳ để xóa Năm học và ấn Hủy và sang mục Đơn giá và hệ số kiểm tra   ");
	    
	    // Khởi tạo một đối tượng DGHSVNHP để thực hiện các hành động
	    DGHSVNHP MainPage = new DGHSVNHP(driver);
	    
	    // Chọn mục Học kỳ từ menu
	    MainPage.MenuHK();
	    Thread.sleep(2000);
	    
	    // Tìm và chọn Học kỳ cần xóa thông qua ô tìm kiếm và click vào liên kết xóa
	    driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("198");
	    Thread.sleep(2000);
	    MainPage.CloseHKDelete();
	    System.out.println("=========");
	    System.out.println("Chuyển sang Đơn Giá và Hệ Số");
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Menu
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Đơn giá và Hệ số
	    MainPage.DGVHS();
	    
	    // Kiểm tra xem thông tin về năm học đã được xóa thành công và không hiển thị trên textbox Năm học ở mục Đơn giá và Hệ số hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("2028 - 2030")) {
	        System.out.println("Dữ liệu 2028 - 2030 ấn Hủy xóa tại Học Kỳ và tồn tại trong textbox Năm Học ");
	    } else {
	        System.out.println("Dữ liệu 2028 - 2030 ấn Hủy xóa tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	    }
	    System.out.println("============");
	}

	@Test
	public void Action6() throws InterruptedException, IOException {
	    // In ra tên của Testcase
	    System.out.println("Testcase 6:Xóa Học Kỳ để xóa Năm học và ấn Lưu và sang mục Đơn giá và hệ số kiểm tra ");
	    
	    // Khởi tạo một đối tượng DGHSVNHP để thực hiện các hành động
	    DGHSVNHP MainPage = new DGHSVNHP(driver);
	    
	    // Chọn mục Học kỳ từ menu
	    MainPage.MenuHK();
	    Thread.sleep(2000);
	    
	    // Tìm và chọn Học kỳ cần xóa thông qua ô tìm kiếm và click vào liên kết xóa
	    driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("198");
	    Thread.sleep(2000);
	    MainPage.DeleteHK();
	    System.out.println("=========");
	    System.out.println("Chuyển sang Đơn Giá và Hệ Số");
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Menu
	    MainPage.MenuNavigation();
	    Thread.sleep(2000);
	    
	    // Chuyển sang mục Đơn giá và Hệ số
	    MainPage.DGVHS();
	    
	    // Kiểm tra xem thông tin về năm học đã được xóa thành công và không hiển thị trên textbox Năm học ở mục Đơn giá và Hệ số hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains("2028 - 2030")) {
	        System.out.println("Dữ liệu 2028 - 2030 ấn Xóa tại Học Kỳ và tồn tại trong textbox Năm Học ");
	    } else {
	        System.out.println("Dữ liệu 2028 - 2030 ấn Xóa tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	    }
	    System.out.println("============");
	}


}
