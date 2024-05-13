package CapBacGiaoVien;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HienThiDuLieu_CapBacGIaoVien {
	public WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String profileString = "C:\\Users\\Phan_Hoang_Khang\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + profileString);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[3]/a/span")).click();
	}
	@BeforeTest
	public void Setup2() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a")).click();
		Thread.sleep(2000);

	}
//	@Test(priority = 20)
//	public void Action21() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 21: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị 10 dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("10");
//	Thread.sleep(2000);
//	// Lấy dữ liệu và in ra màn hình
//	WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = dataElement.getText();
//	System.out.println(dataString);
//	}
//
//	@Test(priority = 21)
//	public void Action22() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 22: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị 25 dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("25");
//	Thread.sleep(2000);
//	// Lấy dữ liệu và in ra màn hình
//	WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = dataElement.getText();
//	System.out.println(dataString);
//	}
//
//	@Test(priority = 22)
//	public void Action23() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 23: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị 50 dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("50");
//	Thread.sleep(2000);
//	// Lấy dữ liệu và in ra màn hình
//	WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = dataElement.getText();
//	System.out.println(dataString);
//	}

//	@Test(priority = 23)
//	public void Action24() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 24: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị tất cả dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("-1");
//	Thread.sleep(2000);
//	// Lấy dữ liệu và in ra màn hình
//	WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = dataElement.getText();
//	System.out.println(dataString);
//	}

//	@Test(priority = 24)
//	public void Action25() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 25: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU VÀ ẤN VÀO MÃ GV SẮP XẾP");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị 10 dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("10");
//	Thread.sleep(2000);
//	// Ấn vào mã giáo viên để sắp xếp
//	WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[2]"));
//	clickSortElement.click();
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ cao đến thấp");
//	// In ra dữ liệu đã sắp xếp
//	WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = printElement.getText();
//	System.out.println(dataString);
//	System.out.println("======");
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ thấp đến cao");
//	// In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	WebElement printElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString2 = printElement2.getText();
//	System.out.println(dataString2);
//	}

//	@Test(priority = 25)
//	public void Action26() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 26: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU VÀ ẤN VÀO MÃ GV SẮP XẾP");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị 25 dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("25");
//	Thread.sleep(2000);
//	// Ấn vào mã giáo viên để sắp xếp
//	WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[2]"));
//	clickSortElement.click();
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ cao đến thấp");
//	// In ra dữ liệu đã sắp xếp
//	WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = printElement.getText();
//	System.out.println(dataString);
//	System.out.println("======");
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ thấp đến cao");
//	// In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	WebElement printElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString2 = printElement2.getText();
//	System.out.println(dataString2);
//	}

//	@Test(priority = 26)
//	public void Action27() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 27: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU VÀ ẤN VÀO MÃ GV SẮP XẾP");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị 50 dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("50");
//	Thread.sleep(2000);
//	// Ấn vào mã giáo viên để sắp xếp
//	WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[2]"));
//	clickSortElement.click();
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ cao đến thấp");
//	// In ra dữ liệu đã sắp xếp
//	WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = printElement.getText();
//	System.out.println(dataString);
//	System.out.println("======");
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ thấp đến cao");
//	// In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	WebElement printElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString2 = printElement2.getText();
//	System.out.println(dataString2);
//	}

//	@Test(priority = 27)
//	public void Action28() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 28: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU VÀ ẤN VÀO MÃ GV SẮP XẾP");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị tất cả dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("-1");
//	Thread.sleep(2000);
//	// Ấn vào mã giáo viên để sắp xếp
//	WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[2]"));
//	clickSortElement.click();
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ cao đến thấp");
//	// In ra dữ liệu đã sắp xếp
//	WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = printElement.getText();
//	System.out.println(dataString);
//	System.out.println("======");
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ thấp đến cao");
//	// In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	WebElement printElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString2 = printElement2.getText();
//	System.out.println(dataString2);
//	}

//	@Test(priority = 28)
//	public void Action29() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 29: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU VÀ ẤN VÀO TÊN GV SẮP XẾP");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị 10 dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("10");
//	Thread.sleep(2000);
//	// Ấn vào tên giáo viên để sắp xếp
//	WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[3]"));
//	clickSortElement.click();
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ cao đến thấp");
//	// In ra dữ liệu đã sắp xếp
//	WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = printElement.getText();
//	System.out.println(dataString);
//	System.out.println("======");
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ thấp đến cao");
//	// In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	WebElement printElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString2 = printElement2.getText();
//	System.out.println(dataString2);
//	}

//	@Test(priority = 29)
//	public void Action30() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 30: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU VÀ ẤN VÀO TÊN GV SẮP XẾP");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị 25 dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("25");
//	Thread.sleep(2000);
//	// Ấn vào tên giáo viên để sắp xếp
//	WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[3]"));
//	clickSortElement.click();
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ cao đến thấp");
//	// In ra dữ liệu đã sắp xếp
//	WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = printElement.getText();
//	System.out.println(dataString);
//	System.out.println("======");
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ thấp đến cao");
//	// In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	WebElement printElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString2 = printElement2.getText();
//	System.out.println(dataString2);
//	}

//	@Test(priority = 30)
//	public void Action31() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 31: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU VÀ ẤN VÀO TÊN GV SẮP XẾP");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị 50 dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("50");
//	Thread.sleep(2000);
//	// Ấn vào tên giáo viên để sắp xếp
//	WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[3]"));
//	clickSortElement.click();
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ cao đến thấp");
//	// In ra dữ liệu đã sắp xếp
//	WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = printElement.getText();
//	System.out.println(dataString);
//	System.out.println("======");
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ thấp đến cao");
//	// In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	WebElement printElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString2 = printElement2.getText();
//	System.out.println(dataString2);
//	}

//	@Test(priority = 31)
//	public void Action32() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 32: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU VÀ ẤN VÀO TÊN GV SẮP XẾP");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị tất cả dữ liệu
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select = new Select(dropdown);
//	select.selectByValue("-1");
//	Thread.sleep(2000);
//	// Ấn vào tên giáo viên để sắp xếp
//	WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[3]"));
//	clickSortElement.click();
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ cao đến thấp");
//	// In ra dữ liệu đã sắp xếp
//	WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString = printElement.getText();
//	System.out.println(dataString);
//	System.out.println("======");
//	clickSortElement.click();
//	System.out.println("Dữ liệu được in từ thấp đến cao");
//	// In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	WebElement printElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	String dataString2 = printElement2.getText();
//	System.out.println(dataString2);
//	}

//	@Test(priority = 32)
//	public void Action33() throws InterruptedException {
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 33: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU VÀ ẤN VÀO CẤP BẬC SẮP XẾP");
//	    // Click vào liên kết để mở chức năng chỉnh sửa
//	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	    linkEdit.click();
//	    Thread.sleep(2000);
//	    // Chọn hiển thị 10 dữ liệu
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select = new Select(dropdown);
//	    select.selectByValue("10");
//	    Thread.sleep(2000);
//	    // Ấn vào cấp bậc để sắp xếp
//	    WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[4]"));
//	    clickSortElement.click();
//	    clickSortElement.click();
//	    System.out.println("Dữ liệu được in từ cao đến thấp");
//	    // In ra dữ liệu đã sắp xếp
//	    WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	    String dataString = printElement.getText();
//	    System.out.println(dataString);
//	    System.out.println("======");
//	    clickSortElement.click();
//	    System.out.println("Dữ liệu được in từ thấp đến cao");
//	    // In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	    WebElement printElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	    String dataString2 = printElement2.getText();
//	    System.out.println(dataString2);
//	}

//	@Test(priority = 33)
//	public void Action34() throws InterruptedException {
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 34: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU VÀ ẤN VÀO CẤP BẬC SẮP XẾP");
//	    // Click vào liên kết để mở chức năng chỉnh sửa
//	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	    linkEdit.click();
//	    Thread.sleep(2000);
//	    // Chọn hiển thị 25 dữ liệu
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select = new Select(dropdown);
//	    select.selectByValue("25");
//	    Thread.sleep(2000);
//	    // Ấn vào cấp bậc để sắp xếp
//	    WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[4]"));
//	    clickSortElement.click();
//	    clickSortElement.click();
//	    System.out.println("Dữ liệu được in từ cao đến thấp");
//	    // In ra dữ liệu đã sắp xếp
//	    WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	    String dataString = printElement.getText();
//	    System.out.println(dataString);
//	    System.out.println("======");
//	    clickSortElement.click();
//	    System.out.println("Dữ liệu được in từ thấp đến cao");
//	    // In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	    WebElement printElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	    String dataString2 = printElement2.getText();
//	    System.out.println(dataString2);
//	}

//	@Test(priority = 34)
//	public void Action35() throws InterruptedException {
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 35: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU VÀ ẤN VÀO CẤP BẬC SẮP XẾP");
//	    // Click vào liên kết để mở chức năng chỉnh sửa
//	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	    linkEdit.click();
//	    Thread.sleep(2000);
//	    // Chọn hiển thị 50 dữ liệu
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select = new Select(dropdown);
//	    select.selectByValue("50");
//	    Thread.sleep(2000);
//	    // Ấn vào cấp bậc để sắp xếp
//	    WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[4]"));
//	    clickSortElement.click();
//	    clickSortElement.click();
//	    System.out.println("Dữ liệu được in từ cao đến thấp");
//	    // In ra dữ liệu đã sắp xếp
//	    WebElement printElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	    String dataString = printElement.getText();
//	    System.out.println(dataString);
//	    System.out.println("======");
//	    clickSortElement.click();
//	    System.out.println("Dữ liệu được in từ thấp đến cao");
//	    // In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	    WebElement printElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	    String dataString2 = printElement2.getText();
//	    System.out.println(dataString2);
//	}

//	@Test(priority = 35)
//	public void Action36() throws InterruptedException {
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 36: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU VÀ ẤN VÀO CẤP BẬC SẮP XẾP");
//	    // Click vào liên kết để mở chức năng chỉnh sửa
//	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	    linkEdit.click();
//	    Thread.sleep(2000);
//	    // Chọn hiển thị tất cả dữ liệu
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select = new Select(dropdown);
//	    select.selectByValue("-1");
//	    Thread.sleep(2000);
//	    // Ấn vào cấp bậc để sắp xếp
//	    WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[4]"));
//	    clickSortElement.click();
//	    clickSortElement.click();
//	    System.out.println("Dữ liệu được in từ cao đến thấp");
//	    // In ra dữ liệu đã sắp xếp
//	    WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	    String dataString = prinElement.getText();
//	    System.out.println(dataString);
//	    System.out.println("======");
//	    clickSortElement.click();
//	    System.out.println("Dữ liệu được in từ thấp đến cao");
//	    // In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
//	    WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	    String dataString2 = prinElement2.getText();
//	    System.out.println(dataString2);
//	}

	@Test(priority = 36)
	public void Action37() throws InterruptedException {
	    // In ra thông tin của testcase
	    System.out.println("Testcase 37: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU VÀ ẤN VÀO CẤP BẬC SẮP XẾP");
	    // Click vào liên kết để mở chức năng chỉnh sửa
	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
	    linkEdit.click();
	    Thread.sleep(2000);
	    // Chọn hiển thị tất cả dữ liệu
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
	    Select select = new Select(dropdown);
	    select.selectByValue("-1");
	    Thread.sleep(2000);
	    // Ấn vào cấp bậc để sắp xếp
	    WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/thead/tr/th[4]"));
	    clickSortElement.click();
	    clickSortElement.click();
	    System.out.println("Dữ liệu được in từ cao đến thấp");
	    // In ra dữ liệu đã sắp xếp
	    WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
	    String dataString = prinElement.getText();
	    System.out.println(dataString);
	    System.out.println("======");
	    clickSortElement.click();
	    System.out.println("Dữ liệu được in từ thấp đến cao");
	    // In ra dữ liệu đã sắp xếp theo thứ tự đảo ngược
	    WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
	    String dataString2 = prinElement2.getText();
	    System.out.println(dataString2);
	}

//	@AfterTest
//	public void Close() {
//		driver.close();
//	}
}
