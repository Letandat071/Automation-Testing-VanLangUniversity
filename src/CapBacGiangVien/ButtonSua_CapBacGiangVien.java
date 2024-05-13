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

public class ButtonSua_CapBacGiangVien {
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
//	@Test(priority = 0)
//	public void Action1() throws InterruptedException {
//	    // In ra mô tả của test case
//	    System.out.println("Testcase 1: CHỨC NĂNG CHỌN BUTTON SỬA TẤT CẢ VÀ CHỌN CẤP BẬC BẤT Kì");
//	    // Click vào button tương ứng để chọn cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//	    Thread.sleep(2000);
//	    // Click vào button "Sửa tất cả"
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
//	    Thread.sleep(4000);
//	    // Tìm tất cả các lựa chọn trong dropdown
//	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//	    int numberOfElements = elements.size();
//	    Random radom = new Random();
//	    // Chọn ngẫu nhiên một lựa chọn
//	    int rant = radom.nextInt(numberOfElements);
//	    // Chọn dropdown bằng index
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//	    Select select = new Select(dropdown);
//	    select.selectByIndex(rant);
//	    // Lấy và in ra cấp bậc đã chọn
//	    WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	    String prinString = printElement.getText();
//	    System.out.println("Cấp bậc được chọn là: "+prinString);
//	    Thread.sleep(2000);
//	    // Click vào button "Lưu"
//	    WebElement clickElement =driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/button[2]"));
//	    clickElement.click();
//	    // Kiểm tra xem button "Lưu" có được kích hoạt không
//	    if (clickElement.isEnabled()) {
//	        System.out.println("Click lưu thành công");
//	    } else {
//	        System.out.println("Click lưu không thành công");		  
//	    }
//	}
//
//	@Test(priority = 1)
//	public void Action2() throws InterruptedException {
//	    // In ra mô tả của test case
//	    System.out.println("Testcase 2: CHỨC NĂNG NHẬP CẤP BẬC BẤT Kì");
//	    // Click vào button để chọn cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//	    Thread.sleep(2000);
//	    // Click vào button "Sửa tất cả"
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
//	    Thread.sleep(4000);
//	    // Click vào dropdown để mở danh sách cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[2]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    // Tìm tất cả các lựa chọn trong dropdown
//	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//	    int numberOfElements = elements.size();
//	    Random radom = new Random();
//	    // Chọn ngẫu nhiên một lựa chọn
//	    int rant = radom.nextInt(numberOfElements);
//	    // Chọn dropdown bằng index
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//	    Select select = new Select(dropdown);
//	    select.selectByIndex(rant);
//	    // Lấy và in ra cấp bậc đã chọn
//	    WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	    String prinString = printElement.getText();
//	    // Nhập cấp bậc đã chọn vào trường nhập liệu
//	    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[2]/div/span[2]/span/span[1]/input"));
//	    inputElement.sendKeys(prinString);
//	    inputElement.sendKeys(Keys.ENTER);
//	    // Click vào button "Lưu"
//	    WebElement clickElement =driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/button[2]"));
//	    clickElement.click();
//	    // Kiểm tra xem button "Lưu" có được kích hoạt không
//	    if (clickElement.isEnabled()) {
//	        System.out.println("Click lưu thành công");
//	    } else {
//	        System.out.println("Click lưu không thành công");
//	    }
//	    // In ra cấp bậc đã nhập
//	    System.out.println("Cấp bậc được nhập là: "+prinString);
//	}
//
//	@Test(priority = 2)
//	public void Action3() throws InterruptedException {
//	    // In ra mô tả của test case
//	    System.out.println("Testcase 3: CHỨC NĂNG CHỌN BUTTON SỬA TẤT CẢ VÀ CHỌN CẤP BẬC BẤT Kì VÀ ẤN HỦY");
//	    // Click vào button để chọn cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//	    Thread.sleep(2000);
//	    // Click vào button "Sửa tất cả"
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
//	    Thread.sleep(4000);
//	    // Tìm tất cả các lựa chọn trong dropdown
//	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//	    int numberOfElements = elements.size();
//	    Random radom = new Random();
//	    // Chọn ngẫu nhiên một lựa chọn
//	    int rant = radom.nextInt(numberOfElements);
//	    // Chọn dropdown bằng index
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//	    Select select = new Select(dropdown);
//	    select.selectByIndex(rant);
//	    // Lấy và in ra cấp bậc đã chọn
//	    WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	    String prinString = printElement.getText();
//	    System.out.println("Cấp bậc được chọn là: "+prinString);
//	    Thread.sleep(2000);
//	    // Click vào button "Hủy"
//	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
//	    // Kiểm tra xem button "Hủy" có được kích hoạt không
//	    if (clickElement.isEnabled()) {
//	        clickElement.click();
//	        Thread.sleep(2000);
//	        System.out.println("Click Hủy thành công ");
//	    } else {
//	        System.out.println("Click Hủy không thành công ");
//	    }
//	}
//
//	@Test(priority = 3)
//	public void Action4() throws InterruptedException {
//	    // In ra mô tả của test case
//	    System.out.println("Testcase 4: CHỨC NĂNG NHẬP CẤP BẬC BẤT Kì VÀ ẤN HỦY");
//	    // Click vào button để mở form nhập cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//	    Thread.sleep(2000);
//	    // Click vào button "Sửa tất cả"
//	    driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
//	    Thread.sleep(4000);
//	    // Click vào dropdown để chọn cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[2]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    // Tìm tất cả các lựa chọn trong dropdown
//	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_rank_id\"]/option"));
//	    int numberOfElements = elements.size();
//	    Random radom = new Random();
//	    // Chọn ngẫu nhiên một lựa chọn
//	    int rant = radom.nextInt(numberOfElements);
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_rank_id\"]"));
//	    Select select = new Select(dropdown);
//	    select.selectByIndex(rant);
//	    // Lấy và in ra cấp bậc đã chọn
//	    WebElement printElement=driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
//	    String prinString = printElement.getText();
//	    // Nhập cấp bậc vào input field
//	    driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(prinString);
//	    // Ấn Enter để xác nhận cấp bậc
//	    driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//	    // Click vào button "Hủy"
//	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
//	    // Kiểm tra xem button "Hủy" có được kích hoạt không
//	    if (clickElement.isEnabled()) {
//	        clickElement.click();
//	        Thread.sleep(2000);
//	        System.out.println("Click Hủy thành công");
//	    } else {
//	        System.out.println("Click Hủy không thành công");
//	    }
//	}

}
