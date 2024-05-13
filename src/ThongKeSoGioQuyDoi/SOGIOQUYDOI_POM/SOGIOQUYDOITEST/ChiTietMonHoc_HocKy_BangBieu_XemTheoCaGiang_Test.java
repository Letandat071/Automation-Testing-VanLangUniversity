package SOGIOQUYDOITEST;

import SOGIOQUYDOI.ChiTietMonHoc_HocKy_BangBieu_XemTheoCaGiang_Page;
import PageSetup.Setup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChiTietMonHoc_HocKy_BangBieu_XemTheoCaGiang_Test {
	static WebDriver driver;

	@BeforeSuite
	public void Setup() throws InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(2000);
	}
	
	@BeforeTest
	public void Setup2() throws InterruptedException {
		ChiTietMonHoc_HocKy_BangBieu_XemTheoCaGiang_Page page = new ChiTietMonHoc_HocKy_BangBieu_XemTheoCaGiang_Page(driver);
		page.navigateToPage();
		page.selectLessonType();
		page.selectTerm("789");
		page.selectMajor("Tất cả");
		page.switchToTableTab();

	}
	@Test
	public void viewCourseDetailsWithMultipleData1() throws InterruptedException {
		System.out.println(
				"Testcase 1: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ với 10 dữ liệu và xem theo ca giảng");
		Thread.sleep(2000);
		WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics_info\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(scroll).perform();
		Thread.sleep(4000);

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));
		int numberOfElements = elements.size();
		for (int i = 1; i <= numberOfElements; i++) {
			String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr["+i+"]/td[2]/button";
			WebElement itemElement = driver.findElement(By.xpath(xpathButton));
			itemElement.click();
			Thread.sleep(2000);
			WebElement dataElement1 = driver
					.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));
			String getDatString2 = dataElement1.getText();
			System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);
			Thread.sleep(2000);
			WebElement dataElement = driver
					.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));
			String getDatString = dataElement.getText();
			System.out.println(getDatString);
			itemElement.click();
			System.out.println("========");
		}
		System.out.println("==========");
	}

	@Test
	public void viewCourseDetailsWithMultipleData2() throws InterruptedException {
	    // In ra mô tả của testcase
	    System.out.println("Testcase 2: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ với 25 dữ liệu và xem theo ca giảng");

	    // Tìm dropdown để chọn số lượng dữ liệu hiển thị
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
	    // Khởi tạo đối tượng Select để chọn giá trị từ dropdown
	    Select select = new Select(dropdown);
	    // Chọn giá trị "25" từ dropdown
	    select.selectByValue("25");
	    Thread.sleep(2000);

	    // Cuộn đến phần tử trên trang
	    WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics_info\"]"));
	    Actions action = new Actions(driver);
	    action.moveToElement(scroll).perform();
	    Thread.sleep(4000);

	    // Tìm tất cả các nút trên bảng và lặp qua từng nút
	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));
	    int numberOfElements = elements.size();
	    for (int i = 1; i <= numberOfElements; i++) {
	        // Xác định xpath của nút trên hàng thứ i trong bảng
	        String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[2]/button";
	        WebElement itemElement = driver.findElement(By.xpath(xpathButton));
	        // Nhấp vào nút để mở cửa sổ
	        itemElement.click();
	        Thread.sleep(2000);
	        // Lấy dữ liệu từ hàng thứ i trong cột thứ 4
	        WebElement dataElement1 = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));
	        String getDatString2 = dataElement1.getText();
	        System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);
	        Thread.sleep(2000);
	        // Lấy dữ liệu từ hàng thứ (i+1)
	        WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));
	        String getDatString = dataElement.getText();
	        System.out.println(getDatString);
	        // Nhấp vào nút để đóng cửa sổ
	        itemElement.click();
	        System.out.println("========");
	    }
	    System.out.println("==========");
	}
	@Test
	public void viewCourseDetailsWithMultipleData3() throws InterruptedException {
	    // In ra mô tả của testcase
	    System.out.println("Testcase 3: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ với 50 dữ liệu và xem theo ca giảng");

	    // Tìm dropdown để chọn số lượng dữ liệu hiển thị
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
	    // Khởi tạo đối tượng Select để chọn giá trị từ dropdown
	    Select select = new Select(dropdown);
	    // Chọn giá trị "50" từ dropdown
	    select.selectByValue("50");
	    Thread.sleep(2000);

	    // Cuộn đến phần tử trên trang
	    WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics_info\"]"));
	    Actions action = new Actions(driver);
	    action.moveToElement(scroll).perform();
	    Thread.sleep(4000);

	    // Tìm tất cả các nút trên bảng và lặp qua từng nút
	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));
	    int numberOfElements = elements.size();
	    for (int i = 1; i <= numberOfElements; i++) {
	        // Xác định xpath của nút trên hàng thứ i trong bảng
	        String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[2]/button";
	        WebElement itemElement = driver.findElement(By.xpath(xpathButton));
	        // Nhấp vào nút để mở cửa sổ
	        itemElement.click();
	        Thread.sleep(2000);
	        // Lấy dữ liệu từ hàng thứ i trong cột thứ 4
	        WebElement dataElement1 = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));
	        String getDatString2 = dataElement1.getText();
	        System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);
	        Thread.sleep(2000);
	        // Lấy dữ liệu từ hàng thứ (i+1)
	        WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));
	        String getDatString = dataElement.getText();
	        System.out.println(getDatString);
	        // Nhấp vào nút để đóng cửa sổ
	        itemElement.click();
	        System.out.println("========");
	    }
	    System.out.println("==========");
	}
	@Test
	public void viewCourseDetailsWithMultipleData4() throws InterruptedException {
	    // In ra mô tả của testcase
	    System.out.println("Testcase 4: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ với tất cả dữ liệu và xem theo ca giảng");

	    // Tìm dropdown để chọn số lượng dữ liệu hiển thị
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
	    // Khởi tạo đối tượng Select để chọn giá trị từ dropdown
	    Select select = new Select(dropdown);
	    // Chọn giá trị "-1" từ dropdown để hiển thị tất cả dữ liệu
	    select.selectByValue("-1");
	    Thread.sleep(2000);

	    // Cuộn đến phần tử trên trang
	    WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics_info\"]"));
	    Actions action = new Actions(driver);
	    action.moveToElement(scroll).perform();

	    // Tìm tất cả các nút trên bảng và lặp qua từng nút
	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));
	    int numberOfElements = elements.size();
	    for (int i = 1; i <= numberOfElements; i++) {
	        // Xác định xpath của nút trên hàng thứ i trong bảng
	        String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[2]/button";
	        WebElement itemElement = driver.findElement(By.xpath(xpathButton));
	        // Nhấp vào nút để mở cửa sổ
	        itemElement.click();
	        Thread.sleep(2000);
	        // Lấy dữ liệu từ hàng thứ i trong cột thứ 4
	        WebElement dataElement1 = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));
	        String getDatString2 = dataElement1.getText();
	        System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);
	        Thread.sleep(2000);
	        // Lấy dữ liệu từ hàng thứ (i+1)
	        WebElement dataElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));
	        String getDatString = dataElement.getText();
	        System.out.println(getDatString);
	        // Nhấp vào nút để đóng cửa sổ
	        itemElement.click();
	        System.out.println("========");
	    }
	    System.out.println("==========");
	}
	
}
