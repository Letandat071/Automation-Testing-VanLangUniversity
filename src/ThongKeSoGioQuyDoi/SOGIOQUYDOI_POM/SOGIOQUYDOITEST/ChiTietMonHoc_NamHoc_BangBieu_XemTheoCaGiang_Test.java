package SOGIOQUYDOITEST;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageSetup.Setup;
import SOGIOQUYDOI.ChiTietMonHoc_NamHoc_BangBieu_XemTheoCaGiang_Page;

public class ChiTietMonHoc_NamHoc_BangBieu_XemTheoCaGiang_Test {
	static WebDriver driver;
	@BeforeSuite
	public void Setup() throws InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(2000);
	}
	@BeforeTest
	public void Setup2() throws InterruptedException {
		ChiTietMonHoc_NamHoc_BangBieu_XemTheoCaGiang_Page MainPage = new ChiTietMonHoc_NamHoc_BangBieu_XemTheoCaGiang_Page(driver);
		MainPage.navigateToPage();
		MainPage.selectLessonType();
		MainPage.SearchInput("Năm học");
		MainPage.ChooseYear("2023 - 2024");
		MainPage.selectMajor("Tất cả");
		MainPage.switchToTableTab();
	}
	@Test
	public void Action1() throws InterruptedException {
	    Thread.sleep(3000);  // Chờ 3 giây
	    System.out.println(
	        "Testcase 1: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Năm Học với 10 dữ liệu và xem theo ca giảng");
	    Thread.sleep(2000);  // Chờ 2 giây
	    Thread.sleep(2000);  // Chờ 2 giây (chờ thêm 1 lần nữa)
	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));  // Tìm tất cả các nút để xem chi tiết môn học
	    int numberOfElements = elements.size();  // Lấy số lượng nút
	    for (int i = 1; i <= numberOfElements; i++) {  // Duyệt qua từng nút
	        WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr["+i+"]/td[1]")); // Tìm phần tử để cuộn
	        Actions action = new Actions(driver); // Tạo đối tượng action để thực hiện hành động
	        action.moveToElement(scroll).perform(); // Di chuyển chuột đến phần tử để cuộn
	        String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[2]/button";  // Xpath của nút xem chi tiết môn học
	        WebElement itemElement = driver.findElement(By.xpath(xpathButton));  // Tìm nút xem chi tiết môn học
	        itemElement.click();  // Click vào nút để xem chi tiết môn học
	        Thread.sleep(2000);  // Chờ 2 giây
	        WebElement dataElement1 = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));  // Tìm phần tử chứa dữ liệu từ giáo viên
	        String getDatString2 = dataElement1.getText();  // Lấy nội dung dữ liệu từ giáo viên
	        System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);  // In ra màn hình dữ liệu từ giáo viên
	        Thread.sleep(2000);  // Chờ 2 giây
	        WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));  // Tìm phần tử chứa dữ liệu
	        String getDatString = dataElement.getText();  // Lấy nội dung dữ liệu
	        System.out.println(getDatString);  // In ra màn hình dữ liệu
	        itemElement.click();  // Click vào nút để đóng chi tiết môn học
	        System.out.println("========");  // In ra dấu '='
	    }
	}
	@Test
	public void Action2() throws InterruptedException {
	    Thread.sleep(3000);  // Chờ 3 giây
	    System.out.println(
	        "Testcase 2: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Năm Học với 25 dữ liệu và xem theo ca giảng");
	    Thread.sleep(2000);  // Chờ 2 giây
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));  // Tìm dropdown để chọn số lượng dữ liệu hiển thị
	    Select select = new Select(dropdown);  // Khởi tạo đối tượng Select
	    select.selectByValue("25");  // Chọn số lượng dữ liệu hiển thị là 25
	    Thread.sleep(2000);  // Chờ 2 giây
	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));  // Tìm tất cả các nút để xem chi tiết môn học
	    int numberOfElements = elements.size();  // Lấy số lượng nút
	    for (int i = 1; i <= numberOfElements; i++) {  // Duyệt qua từng nút
	        WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr["+i+"]/td[1]")); // Tìm phần tử để cuộn
	        Actions action = new Actions(driver); // Tạo đối tượng action để thực hiện hành động
	        action.moveToElement(scroll).perform(); // Di chuyển chuột đến phần tử để cuộn
	        String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[2]/button";  // Xpath của nút xem chi tiết môn học
	        WebElement itemElement = driver.findElement(By.xpath(xpathButton));  // Tìm nút xem chi tiết môn học
	        itemElement.click();  // Click vào nút để xem chi tiết môn học
	        Thread.sleep(2000);  // Chờ 2 giây
	        WebElement dataElement1 = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));  // Tìm phần tử chứa dữ liệu từ giáo viên
	        String getDatString2 = dataElement1.getText();  // Lấy nội dung dữ liệu từ giáo viên
	        System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);  // In ra màn hình dữ liệu từ giáo viên
	        Thread.sleep(2000);  // Chờ 2 giây
	        WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));  // Tìm phần tử chứa dữ liệu
	        String getDatString = dataElement.getText();  // Lấy nội dung dữ liệu
	        System.out.println(getDatString);  // In ra màn hình dữ liệu
	        itemElement.click();  // Click vào nút để đóng chi tiết môn học
	        System.out.println("========");  // In ra dấu '='
	    }
	}
	@Test
	public void Action3() throws InterruptedException {
	    Thread.sleep(3000);  // Chờ 3 giây
	    System.out.println(
	        "Testcase 3: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Năm Học với 50 dữ liệu và xem theo ca giảng");
	    Thread.sleep(2000);  // Chờ 2 giây
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));  // Tìm dropdown để chọn số lượng dữ liệu hiển thị
	    Select select = new Select(dropdown);  // Khởi tạo đối tượng Select
	    select.selectByValue("50");  // Chọn số lượng dữ liệu hiển thị là 50
	    Thread.sleep(2000);  // Chờ 2 giây
	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));  // Tìm tất cả các nút để xem chi tiết môn học
	    int numberOfElements = elements.size();  // Lấy số lượng nút
	    for (int i = 1; i <= numberOfElements; i++) {  // Duyệt qua từng nút
	        WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr["+i+"]/td[1]")); // Tìm phần tử để cuộn
	        Actions action = new Actions(driver); // Tạo đối tượng action để thực hiện hành động
	        action.moveToElement(scroll).perform(); // Di chuyển chuột đến phần tử để cuộn
	        String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[2]/button";  // Xpath của nút xem chi tiết môn học
	        WebElement itemElement = driver.findElement(By.xpath(xpathButton));  // Tìm nút xem chi tiết môn học
	        itemElement.click();  // Click vào nút để xem chi tiết môn học
	        Thread.sleep(2000);  // Chờ 2 giây
	        WebElement dataElement1 = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));  // Tìm phần tử chứa dữ liệu từ giáo viên
	        String getDatString2 = dataElement1.getText();  // Lấy nội dung dữ liệu từ giáo viên
	        System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);  // In ra màn hình dữ liệu từ giáo viên
	        Thread.sleep(2000);  // Chờ 2 giây
	        WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));  // Tìm phần tử chứa dữ liệu
	        String getDatString = dataElement.getText();  // Lấy nội dung dữ liệu
	        System.out.println(getDatString);  // In ra màn hình dữ liệu
	        itemElement.click();  // Click vào nút để đóng chi tiết môn học
	        System.out.println("========");  // In ra dấu '='
	    }
	}
	@Test
	public void Action4() throws InterruptedException {
	    Thread.sleep(3000);  // Chờ 3 giây
	    System.out.println(
	        "Testcase 4: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Năm Học với tất cả dữ liệu và xem theo ca giảng");
	    Thread.sleep(2000);  // Chờ 2 giây
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));  // Tìm dropdown để chọn số lượng dữ liệu hiển thị
	    Select select = new Select(dropdown);  // Khởi tạo đối tượng Select
	    select.selectByValue("-1");  // Chọn tất cả dữ liệu
	    Thread.sleep(2000);  // Chờ 2 giây
	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));  // Tìm tất cả các nút để xem chi tiết môn học
	    int numberOfElements = elements.size();  // Lấy số lượng nút
	    for (int i = 1; i <= numberOfElements; i++) {  // Duyệt qua từng nút
	        WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr["+i+"]/td[1]")); // Tìm phần tử để cuộn
	        Actions action = new Actions(driver); // Tạo đối tượng action để thực hiện hành động
	        action.moveToElement(scroll).perform(); // Di chuyển chuột đến phần tử để cuộn
	        String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[2]/button";  // Xpath của nút xem chi tiết môn học
	        WebElement itemElement = driver.findElement(By.xpath(xpathButton));  // Tìm nút xem chi tiết môn học
	        itemElement.click();  // Click vào nút để xem chi tiết môn học
	        Thread.sleep(2000);  // Chờ 2 giây
	        WebElement dataElement1 = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));  // Tìm phần tử chứa dữ liệu từ giáo viên
	        String getDatString2 = dataElement1.getText();  // Lấy nội dung dữ liệu từ giáo viên
	        System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);  // In ra màn hình dữ liệu từ giáo viên
	        Thread.sleep(2000);  // Chờ 2 giây
	        WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));  // Tìm phần tử chứa dữ liệu
	        String getDatString = dataElement.getText();  // Lấy nội dung dữ liệu
	        System.out.println(getDatString);  // In ra màn hình dữ liệu
	        itemElement.click();  // Click vào nút để đóng chi tiết môn học
	        System.out.println("========");  // In ra dấu '='
	    }
	}
}
