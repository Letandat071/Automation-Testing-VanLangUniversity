package CapBacGiaoVien;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChinhSua_CapBacGiangVien {
	static WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\Phan_Hoang_Khang\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
	}
	@BeforeTest
	public void Setup2() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a")).click();
		Thread.sleep(2000);

	}
//	@Test(priority = 4)
//	public void Action5() throws InterruptedException {
//	    // In ra mô tả của test case
//	    System.out.println("Testcase 5:Chọn chỉnh sửa và ấn Lưu");
//	    // Click vào menu chức năng
//	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//	    Thread.sleep(2000);
//	    // Nhập từ khóa tìm kiếm
//	    WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
//	    searchInput.sendKeys("Phan Hoàng Khang");
//	    // Click vào nút chỉnh sửa
//	    WebElement editButton = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a"));
//	    editButton.click();
//	    Thread.sleep(2000);
//	    // Chọn một cấp bậc ngẫu nhiên từ dropdown
//	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//	    int numberOfElements = elements.size();
//	    Random radom = new Random();
//	    int rant = radom.nextInt(numberOfElements);
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//	    Select select = new Select(dropdown);
//	    select.selectByIndex(rant);
//	    // Lấy và in ra cấp bậc đã chọn
//	    WebElement printElement = driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	    String prinString = printElement.getText();
//	    System.out.println("Cấp bậc được chọn là: " + prinString);
//	    Thread.sleep(2000);
//	    // Click vào nút "Lưu"
//	    WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[4]/button[2]"));
//	    saveButton.click();
//	    // Kiểm tra xem nút "Lưu" có được kích hoạt không
//	    if (saveButton.isEnabled()) {
//	        System.out.println("Click lưu thành công");
//	    } else {
//	        System.out.println("Click lưu không thành công");
//	    }
//	}
//
//	@Test (priority = 5)
//	public void Action6() throws InterruptedException {
//		System.out.println("Testcase 6:Chọn chỉnh sửa và ấn Hủy");
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]")).click();
//		Thread.sleep(4000);
//		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//		int numberOfElements = elements.size();
//		Random radom = new Random();
//		int rant = radom.nextInt(numberOfElements);
//		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//		Select select = new Select(dropdown);
//		select.selectByIndex(rant);
//		WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//		String prinString = printElement.getText();
//		System.out.println("Cấp bậc được chọn là: "+prinString);
//		Thread.sleep(2000);
//		WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
//	    if (clickElement.isEnabled()) {
//	        clickElement.click();
//	        Thread.sleep(2000);
//	        System.out.println("Click Hủy thành công");
//	    } else {
//	        System.out.println("Click Hủy không thành công");
//	    }
//	}
//	
//	@Test (priority = 6)
//	public void Action7() throws InterruptedException {
//	    // In ra mô tả của testcase
//	    System.out.println("Testcase 7: Chọn chỉnh sửa và nhập cấp bậc");
//	    // Click vào link chỉnh sửa
//	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//	    Thread.sleep(2000);
//	    // Nhập tên cần tìm kiếm vào ô tìm kiếm
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//	    // Click vào nút chỉnh sửa của bản ghi đầu tiên
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//	    Thread.sleep(2000);
//	    // Click vào dropdown chọn cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]")).click();
//	    Thread.sleep(4000);
//	    // Lấy danh sách các phần tử trong dropdown
//	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//	    int numberOfElements = elements.size();
//	    // Chọn ngẫu nhiên một phần tử từ dropdown
//	    Random radom = new Random();
//	    int rant = radom.nextInt(numberOfElements);
//	    // Chọn phần tử được chọn từ dropdown
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//	    Select select = new Select(dropdown);
//	    select.selectByIndex(rant);
//	    // Lấy tên của phần tử được chọn
//	    WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	    String prinString = printElement.getText();
//	    Thread.sleep(3000);
//	    // Nhập tên cấp bậc vào ô nhập liệu
//	    driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(prinString);
//	    Thread.sleep(3000);
//	    // Ấn Enter để xác nhận việc chọn cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//	    System.out.println("Cấp bậc được chọn là: "+prinString);
//	    Thread.sleep(2000);
//	    // Click vào nút lưu
//	    WebElement clickElement =driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[4]/button[2]"));
//	    clickElement.click();
//	    // Kiểm tra nút lưu có được kích hoạt không
//	    if (clickElement.isEnabled()) {
//	        System.out.println("Click lưu thành công");
//	    } else {
//	        System.out.println("Click lưu không thành công");
//	    }
//	}
//	
//	@Test (priority = 7)
//	public void Action8() throws InterruptedException {
//	    // In ra mô tả của testcase
//	    System.out.println("Testcase 8: CHỨC NĂNG NHẬP CẤP BẬC BẤT Kì VÀ ẤN HỦY");
//	    // Click vào link chỉnh sửa
//	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"))
//	            .click();
//	    Thread.sleep(2000);
//	    // Nhập tên cần tìm kiếm vào ô tìm kiếm
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"))
//	            .sendKeys("Phan Hoàng Khang");
//	    // Click vào nút chỉnh sửa của bản ghi đầu tiên
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a"))
//	            .click();
//	    Thread.sleep(2000);
//	    // Click vào dropdown chọn cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"))
//	            .click();
//	    Thread.sleep(4000);
//	    // Lấy danh sách các phần tử trong dropdown
//	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//	    int numberOfElements = elements.size();
//	    // Chọn ngẫu nhiên một phần tử từ dropdown
//	    Random radom = new Random();
//	    int rant = radom.nextInt(numberOfElements);
//	    // Chọn phần tử được chọn từ dropdown
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//	    Select select = new Select(dropdown);
//	    select.selectByIndex(rant);
//	    // Lấy tên của phần tử được chọn
//	    WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	    String prinString = printElement.getText();
//	    // Nhập tên cấp bậc vào ô nhập liệu
//	    driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input"))
//	            .sendKeys(prinString);
//	    Thread.sleep(3000);
//	    // Ấn Enter để xác nhận việc chọn cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input"))
//	            .sendKeys(Keys.ENTER);
//	    // Click vào nút hủy
//	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
//	    if (clickElement.isEnabled()) {
//	        clickElement.click();
//	        Thread.sleep(2000);
//	        System.out.println("Click Hủy thành công");
//	    } else {
//	        System.out.println("Click Hủy không thành công");
//	    }
//	}
//	
//	@Test (priority = 8)
//	public void Action9() throws InterruptedException {
//	    // Testcase 9: Chọn chỉnh sửa và ấn Lưu với hiển thị 25 dữ liệu
//		System.out.println("Testcase 9:Chọn chỉnh sửa và ấn Lưu với hiển thị 25 dữ liệu");
//	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//	    Thread.sleep(2000);
//	    WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select1 = new Select(dropdown1);
//	    select1.selectByValue("25");
//	    // Nhập tên vào ô tìm kiếm
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//	    // Nhấn vào nút chỉnh sửa của hàng đầu tiên trong bảng
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//	    Thread.sleep(2000);
//	    // Lấy danh sách các phần tử trong dropdown
//	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//	    int numberOfElements = elements.size();
//	    Random radom = new Random();
//	    int rant = radom.nextInt(numberOfElements);
//	    // Chọn ngẫu nhiên một phần tử trong dropdown
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//	    Select select = new Select(dropdown);
//	    select.selectByIndex(rant);
//	    // Lấy thông tin về phần tử đã chọn
//	    WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	    String prinString = printElement.getText();
//	    System.out.println("Cấp bậc được chọn là: "+prinString);
//	    Thread.sleep(2000);
//	    // Click vào nút lưu
//	    WebElement clickElement =driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[4]/button[2]"));
//	    clickElement.click();
//	    // Kiểm tra nếu nút lưu đã được kích hoạt
//	    if (clickElement.isEnabled()) {
//	        System.out.println("Click lưu thành công");
//	    } else {
//	        System.out.println("Click lưu không thành công");
//	    }
//	}
//	
//	@Test (priority = 9)
//	public void Action10() throws InterruptedException {
//	    // Testcase 10: Chọn chỉnh sửa và ấn Hủy với hiển thị 25 dữ liệu
//	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//	    Thread.sleep(2000);
//	    WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select1 = new Select(dropdown1);
//	    select1.selectByValue("25");
//	    // Nhập tên vào ô tìm kiếm
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//	    // Nhấn vào nút chỉnh sửa của hàng đầu tiên trong bảng
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//	    Thread.sleep(2000);
//	    // Click vào dropdown cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]")).click();
//	    Thread.sleep(4000);
//	    // Lấy danh sách các phần tử trong dropdown
//	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//	    int numberOfElements = elements.size();
//	    Random radom = new Random();
//	    int rant = radom.nextInt(numberOfElements);
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//	    Select select = new Select(dropdown);
//	    // Chọn ngẫu nhiên một phần tử trong dropdown
//	    select.selectByIndex(rant);
//	    // Lấy thông tin về phần tử đã chọn
//	    WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	    String prinString = printElement.getText();
//	    System.out.println("Cấp bậc được chọn là: "+prinString);
//	    Thread.sleep(2000);
//	    // Click vào nút Hủy
//	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
//	    if (clickElement.isEnabled()) {
//	        clickElement.click();
//	        Thread.sleep(2000);
//	        System.out.println("Click Hủy thành công");
//	    } else {
//	        System.out.println("Click Hủy không thành công");
//	    }
//	}
//	
//	@Test(priority = 10)
//	public void Action11() throws InterruptedException {
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 11: Chọn chỉnh sửa và nhập cấp bậc với hiển thị 25 dữ liệu ");
//	    // Click vào dropdown để chọn hiển thị số lượng dữ liệu
//	    WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select1 = new Select(dropdown1);
//	    select1.selectByValue("25");
//	    // Tìm kiếm và chọn để chỉnh sửa dữ liệu
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//	    Thread.sleep(2000);
//	    // Click vào dropdown để chọn cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]")).click();
//	    Thread.sleep(4000);
//	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//	    int numberOfElements = elements.size();
//	    Random radom = new Random();
//	    int rant = radom.nextInt(numberOfElements);
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//	    Select select = new Select(dropdown);
//	    select.selectByIndex(rant);
//	    // Lấy và nhập thông tin cấp bậc đã chọn
//	    WebElement printElement = driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	    String prinString = printElement.getText();
//	    driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(prinString);
//	    Thread.sleep(3000);
//	    // Kết thúc nhập thông tin cấp bậc và lưu
//	    driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//	    System.out.println("Cấp bậc được chọn là: " + prinString);
//	    Thread.sleep(2000);
//	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[4]/button[2]"));
//	    clickElement.click();
//	    // Kiểm tra xem việc lưu đã thành công hay không
//	    if (clickElement.isEnabled()) {
//	        System.out.println("Click lưu thành công");
//	    } else {
//	        System.out.println("Click lưu không thành công");
//	    }
//	}
//	
//	@Test (priority = 11)
//	public void Action12() throws InterruptedException {
//		System.out.println("Testcase 12: CHỨC NĂNG NHẬP CẤP BẬC BẤT Kì VÀ ẤN HỦY với hiển thị 25 dữ liệu");
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//		Select select1 = new Select(dropdown1);
//		select1.selectByValue("25");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]")).click();
//		Thread.sleep(2000);
//		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//		int numberOfElements = elements.size();
//		Random radom = new Random();
//		int rant = radom.nextInt(numberOfElements);
//		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//		Select select = new Select(dropdown);
//		select.selectByIndex(rant);
//		WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//		String prinString = printElement.getText();
//		driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(prinString);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
//	    if (clickElement.isEnabled()) {
//	        clickElement.click();
//	        Thread.sleep(2000);
//	        System.out.println("Click Hủy thành công");
//	    } else {
//	        System.out.println("Click Hủy không thành công");
//	    }
//	}
//	
//	@Test (priority = 12)
//	public void Action13() throws InterruptedException {
//		System.out.println("Testcase 13:Chọn chỉnh sửa và ấn Lưu với hiển thị 25 dữ liệu");
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//		Select select1 = new Select(dropdown1);
//		select1.selectByValue("50");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//		Thread.sleep(2000);
//		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//		int numberOfElements = elements.size();
//		Random radom = new Random();
//		int rant = radom.nextInt(numberOfElements);
//		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//		Select select = new Select(dropdown);
//		select.selectByIndex(rant);
//		WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//		String prinString = printElement.getText();
//		System.out.println("Cấp bậc được chọn là: "+prinString);
//		Thread.sleep(2000);
//		WebElement clickElement =driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[4]/button[2]"));
//		clickElement.click();
//		if (clickElement.isEnabled()) {
//		    System.out.println("Click lưu thành công");
//		} else {
//		    System.out.println("Click lưu không thành công");
//		    
//		}
//	}
//	
//	@Test (priority = 13)
//	public void Action14() throws InterruptedException {
//		System.out.println("Testcase 14:Chọn chỉnh sửa và ấn Hủy với hiển thị 25 dữ liệu");
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//		Select select1 = new Select(dropdown1);
//		select1.selectByValue("25");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]")).click();
//		Thread.sleep(4000);
//		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//		int numberOfElements = elements.size();
//		Random radom = new Random();
//		int rant = radom.nextInt(numberOfElements);
//		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//		Select select = new Select(dropdown);
//		select.selectByIndex(rant);
//		WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//		String prinString = printElement.getText();
//		System.out.println("Cấp bậc được chọn là: "+prinString);
//		Thread.sleep(2000);
//		WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
//	    if (clickElement.isEnabled()) {
//	        clickElement.click();
//	        Thread.sleep(2000);
//	        System.out.println("Click Hủy thành công");
//	    } else {
//	        System.out.println("Click Hủy không thành công");
//	    }
//	}
//	
//	@Test (priority = 14)
//	public void Action15() throws InterruptedException {
//		System.out.println("Testcase 15: Chọn chỉnh sửa và nhập cấp bậc với hiển thị 25 dữ liệu ");
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//		Select select1 = new Select(dropdown1);
//		select1.selectByValue("50");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]")).click();
//		Thread.sleep(4000);
//		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//		int numberOfElements = elements.size();
//		Random radom = new Random();
//		int rant = radom.nextInt(numberOfElements);
//		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//		Select select = new Select(dropdown);
//		select.selectByIndex(rant);
//		WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//		String prinString = printElement.getText();
//		driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(prinString);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		System.out.println("Cấp bậc được chọn là: "+prinString);
//		Thread.sleep(2000);
//		WebElement clickElement =driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[4]/button[2]"));
//		clickElement.click();
//		if (clickElement.isEnabled()) {
//		    System.out.println("Click lưu thành công");
//		} else {
//		    System.out.println("Click lưu không thành công");
//		    
//		}
//	}
//	
//	@Test (priority = 15)
//	public void Action16() throws InterruptedException {
//		System.out.println("Testcase 16: CHỨC NĂNG NHẬP CẤP BẬC BẤT Kì VÀ ẤN HỦY với hiển thị 25 dữ liệu");
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//		Select select1 = new Select(dropdown1);
//		select1.selectByValue("50");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]")).click();
//		Thread.sleep(2000);
//		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//		int numberOfElements = elements.size();
//		Random radom = new Random();
//		int rant = radom.nextInt(numberOfElements);
//		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//		Select select = new Select(dropdown);
//		select.selectByIndex(rant);
//		WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//		String prinString = printElement.getText();
//		driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(prinString);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
//	    if (clickElement.isEnabled()) {
//	        clickElement.click();
//	        Thread.sleep(2000);
//	        System.out.println("Click Hủy thành công");
//	    } else {
//	        System.out.println("Click Hủy không thành công");
//	    }
//	}
//	
//	@Test (priority = 16)
//	public void Action17() throws InterruptedException {
//		System.out.println("Testcase 17:Chọn chỉnh sửa và ấn Lưu với hiển thị 25 dữ liệu");
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//		Select select1 = new Select(dropdown1);
//		select1.selectByValue("50");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//		Thread.sleep(2000);
//		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//		int numberOfElements = elements.size();
//		Random radom = new Random();
//		int rant = radom.nextInt(numberOfElements);
//		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//		Select select = new Select(dropdown);
//		select.selectByIndex(rant);
//		WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//		String prinString = printElement.getText();
//		System.out.println("Cấp bậc được chọn là: "+prinString);
//		Thread.sleep(2000);
//		WebElement clickElement =driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[4]/button[2]"));
//		clickElement.click();
//		if (clickElement.isEnabled()) {
//		    System.out.println("Click lưu thành công");
//		} else {
//		    System.out.println("Click lưu không thành công");
//		}
//	}
//	
//	@Test (priority = 17)
//	public void Action18() throws InterruptedException {
//		System.out.println("Testcase 18:Chọn chỉnh sửa và ấn Hủy với hiển thị 25 dữ liệu");
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//		Select select1 = new Select(dropdown1);
//		select1.selectByValue("25");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys("Phan Hoàng Khang");
//		driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]")).click();
//		Thread.sleep(4000);
//		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//		int numberOfElements = elements.size();
//		Random radom = new Random();
//		int rant = radom.nextInt(numberOfElements);
//		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//		Select select = new Select(dropdown);
//		select.selectByIndex(rant);
//		WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//		String prinString = printElement.getText();
//		System.out.println("Cấp bậc được chọn là: "+prinString);
//		Thread.sleep(2000);
//		WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
//	    if (clickElement.isEnabled()) {
//	        clickElement.click();
//	        Thread.sleep(2000);
//	        System.out.println("Click Hủy thành công");
//	    } else {
//	        System.out.println("Click Hủy không thành công");
//	    }
//	}
//	
//	@Test(priority = 18)
//	public void Action19() throws InterruptedException {
//	// In ra thông tin của testcase
//	System.out.println("Testcase 19: Chọn chỉnh sửa và nhập cấp bậc với hiển thị 25 dữ liệu ");
//	// Click vào liên kết để mở chức năng chỉnh sửa
//	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	linkEdit.click();
//	Thread.sleep(2000);
//	// Chọn hiển thị 50 dữ liệu
//	WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	Select select1 = new Select(dropdown1);
//	select1.selectByValue("50");
//	// Tìm kiếm và chọn để chỉnh sửa dữ liệu
//	WebElement filterInput = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
//	filterInput.sendKeys("Phan Hoàng Khang");
//	WebElement editLink = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a"));
//	editLink.click();
//	Thread.sleep(2000);
//	// Chọn cấp bậc ngẫu nhiên
//	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	dropdown.click();
//	Thread.sleep(4000);
//	List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//	int numberOfElements = elements.size();
//	Random radom = new Random();
//	int rant = radom.nextInt(numberOfElements);
//	WebElement selectElement = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//	Select select = new Select(selectElement);
//	select.selectByIndex(rant);
//	// Lấy và in ra thông tin cấp bậc đã chọn
//	WebElement printElement = driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	String selectedRank = printElement.getText();
//	System.out.println("Cấp bậc được chọn là: " + selectedRank);
//	Thread.sleep(2000);
//	// Ấn nút lưu và kiểm tra xem nó đã được kích hoạt hay không
//	WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[4]/button[2]"));
//	if (clickElement.isEnabled()) {
//	System.out.println("Click lưu thành công");
//	} else {
//	System.out.println("Click lưu không thành công");
//	}
//	}
//	
	@Test(priority = 19)
	public void Action20() throws InterruptedException {
	// In ra thông tin của testcase
	System.out.println("Testcase 20: CHỨC NĂNG NHẬP CẤP BẬC BẤT Kì VÀ ẤN HỦY với hiển thị 25 dữ liệu");
	// Click vào liên kết để mở chức năng chỉnh sửa
	WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
	linkEdit.click();
	Thread.sleep(2000);
	// Chọn hiển thị 50 dữ liệu
	WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
	Select select1 = new Select(dropdown1);
	select1.selectByValue("50");
	// Tìm kiếm và chọn để chỉnh sửa dữ liệu
	WebElement filterInput = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
	filterInput.sendKeys("Phan Hoàng Khang");
	WebElement editLink = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a"));
	editLink.click();
	Thread.sleep(2000);
	// Chọn cấp bậc ngẫu nhiên
	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
	dropdown.click();
	Thread.sleep(2000);
	List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
	int numberOfElements = elements.size();
	Random radom = new Random();
	int rant = radom.nextInt(numberOfElements);
	WebElement selectElement = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
	Select select = new Select(selectElement);
	select.selectByIndex(rant);
	// Lấy và in ra thông tin cấp bậc đã chọn
	WebElement printElement = driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
	String selectedRank = printElement.getText();
	System.out.println("Cấp bậc được chọn là: " + selectedRank);
	Thread.sleep(3000);
	// Ấn nút Hủy và kiểm tra xem nó đã được kích hoạt hay không
	WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	if (clickElement.isEnabled()) {
	clickElement.click();
	Thread.sleep(2000);
	System.out.println("Click Hủy thành công");
	} else {
	System.out.println("Click Hủy không thành công");
	}
	}


}
