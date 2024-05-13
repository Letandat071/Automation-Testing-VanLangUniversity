package CapBacGiaoVien;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class TimKiem_CapBacGiangVien {
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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a")).click();
		Thread.sleep(2000);
	}
//	@Test(priority = 39)
//	public void Action40() throws InterruptedException, IOException {
//	    // Click vào liên kết để mở chức năng chỉnh sửa
//	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	    linkEdit.click();
//	    Thread.sleep(2000);
//	    // Chọn hiển thị 10 dòng dữ liệu
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select = new Select(dropdown);
//	    select.selectByValue("10");
//	    Thread.sleep(2000);
//	    // Đọc dữ liệu từ tệp Excel
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\SearchCapBac.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Chuỗi để lưu ID của các dòng không tìm thấy và tìm thấy
//	    StringBuilder pasStringBuilder = new StringBuilder();
//	    StringBuilder faildBuilder = new StringBuilder();
//	    // Duyệt qua từng dòng trong tệp Excel
//	    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//	        XSSFRow row = sheet.getRow(i);
//	        String id = row.getCell(0).getStringCellValue();
//	        Thread.sleep(500);
//	        // Nhập ID vào ô tìm kiếm
//	        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
//	        searchbox.sendKeys(id);
//	        Thread.sleep(1000);
//	        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	        System.out.println(dataTable.getText());
//	        // Kiểm tra xem có kết quả tìm kiếm hay không
//	        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
//	            faildBuilder.append(id);
//	        } else {
//	            pasStringBuilder.append(id);
//	        }
//	        searchbox.clear();
//	    }
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 40: Tìm kiếm với Hiển thị 10 dữ liệu");
//	    String pasString = pasStringBuilder.toString();
//	    String faildString = faildBuilder.toString();
//	    System.out.println("Key word không có kết quả " + faildString);
//	    System.out.println("Key Word có kết quả " + pasString);
//	}

	
//	@Test (priority = 40)
//	public void Action41() throws InterruptedException, IOException {
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//		Select select = new Select(dropdown);
//		select.selectByValue("25");
//		Thread.sleep(2000);
//		FileInputStream fis = new FileInputStream("D:\\TestLibery\\SearchCapBac.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		StringBuilder pasStringBuilder = new StringBuilder();
//		StringBuilder faildBuilder = new StringBuilder();
//		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//			XSSFRow row = sheet.getRow(i);
//			String id = row.getCell(0).getStringCellValue();
//			Thread.sleep(500);
//			WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
//			searchbox.sendKeys(id);
//			Thread.sleep(1000);
//			WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//			System.out.println(dataTable.getText());
//			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
//				faildBuilder.append(id);
//			} else {
//				pasStringBuilder.append(id);
//			}
//			searchbox.clear();
//		}
//		System.out.println("Testcase 41:Tìm kiếm với Hiển thị 25 dữ liệu");
//		String pasString = pasStringBuilder.toString();
//		String faildString = faildBuilder.toString();
//		System.out.println("Key word không có kết quả " + faildString);
//		System.out.println("Key Word có kết quả " + pasString);
//	}
//	
//	@Test(priority = 41)
//	public void Action42() throws InterruptedException, IOException {
//	    // Click vào liên kết để mở chức năng chỉnh sửa
//	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	    linkEdit.click();
//	    Thread.sleep(2000);
//	    // Chọn hiển thị 50 dòng dữ liệu
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select = new Select(dropdown);
//	    select.selectByValue("50");
//	    Thread.sleep(2000);
//	    // Đọc dữ liệu từ tệp Excel
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\SearchCapBac.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Chuỗi để lưu ID của các dòng không tìm thấy và tìm thấy
//	    StringBuilder pasStringBuilder = new StringBuilder();
//	    StringBuilder faildBuilder = new StringBuilder();
//	    // Duyệt qua từng dòng trong tệp Excel
//	    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//	        XSSFRow row = sheet.getRow(i);
//	        String id = row.getCell(0).getStringCellValue();
//	        Thread.sleep(500);
//	        // Nhập ID vào ô tìm kiếm
//	        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
//	        searchbox.sendKeys(id);
//	        Thread.sleep(1000);
//	        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	        System.out.println(dataTable.getText());
//	        // Kiểm tra xem có kết quả tìm kiếm hay không
//	        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
//	            faildBuilder.append(id);
//	        } else {
//	            pasStringBuilder.append(id);
//	        }
//	        searchbox.clear();
//	    }
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 42: Tìm kiếm với Hiển thị 50 dữ liệu");
//	    String pasString = pasStringBuilder.toString();
//	    String faildString = faildBuilder.toString();
//	    System.out.println("Key word không có kết quả " + faildString);
//	    System.out.println("Key Word có kết quả " + pasString);
//	}

//	
//	@Test(priority = 42)
//	public void Action43() throws InterruptedException, IOException {
//	    // Click vào liên kết để mở chức năng chỉnh sửa
//	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	    linkEdit.click();
//	    Thread.sleep(2000);
//	    // Chọn hiển thị tất cả dữ liệu
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select = new Select(dropdown);
//	    select.selectByValue("-1");
//	    Thread.sleep(2000);
//	    // Đọc dữ liệu từ tệp Excel
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\SearchCapBac.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Chuỗi để lưu ID của các dòng không tìm thấy và tìm thấy
//	    StringBuilder pasStringBuilder = new StringBuilder();
//	    StringBuilder faildBuilder = new StringBuilder();
//	    // Duyệt qua từng dòng trong tệp Excel
//	    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//	        XSSFRow row = sheet.getRow(i);
//	        String id = row.getCell(0).getStringCellValue();
//	        Thread.sleep(500);
//	        // Nhập ID vào ô tìm kiếm
//	        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
//	        searchbox.sendKeys(id);
//	        Thread.sleep(1000);
//	        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	        System.out.println(dataTable.getText());
//	        // Kiểm tra xem có kết quả tìm kiếm hay không
//	        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
//	            faildBuilder.append(id);
//	        } else {
//	            pasStringBuilder.append(id);
//	        }
//	        searchbox.clear();
//	    }
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 43: Tìm kiếm với Hiển thị tất cả dữ liệu");
//	    String pasString = pasStringBuilder.toString();
//	    String faildString = faildBuilder.toString();
//	    System.out.println("Key word không có kết quả " + faildString);
//	    System.out.println("Key Word có kết quả " + pasString);
//	}

//
//
//	@Test(priority = 43)
//	public void Action44() throws InterruptedException, IOException {
//	    // Click vào liên kết để mở chức năng chỉnh sửa
//	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	    linkEdit.click();
//	    Thread.sleep(2000);
//	    // Chọn hiển thị 10 dòng dữ liệu
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select = new Select(dropdown);
//	    select.selectByValue("10");
//	    Thread.sleep(2000);
//	    // Đọc dữ liệu từ tệp Excel
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\SearchCapBac.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Chuỗi để lưu ID của các dòng không tìm thấy và tìm thấy
//	    StringBuilder pasStringBuilder = new StringBuilder();
//	    StringBuilder faildBuilder = new StringBuilder();
//	    // Duyệt qua từng dòng trong tệp Excel
//	    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//	        XSSFRow row = sheet.getRow(i);
//	        String id = row.getCell(1).getStringCellValue();
//	        Thread.sleep(500);
//	        // Nhập ID vào ô tìm kiếm
//	        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
//	        searchbox.sendKeys(id);
//	        Thread.sleep(1000);
//	        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	        System.out.println(dataTable.getText());
//	        // Kiểm tra xem có kết quả tìm kiếm hay không
//	        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
//	            faildBuilder.append(id);
//	        } else {
//	            pasStringBuilder.append(id);
//	        }
//	        searchbox.clear();
//	    }
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 44: Tìm kiếm với kí tự đặc biệt và Hiển thị 10 dữ liệu");
//	    String pasString = pasStringBuilder.toString();
//	    String faildString = faildBuilder.toString();
//	    System.out.println("Key word không có kết quả " + faildString);
//	    System.out.println("Key Word có kết quả " + pasString);
//	}

//	
//	@Test (priority = 44)
//	public void Action45() throws InterruptedException, IOException {
//	    // Click vào liên kết để mở chức năng chỉnh sửa
//	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	    linkEdit.click();
//	    Thread.sleep(2000);
//	    // Chọn hiển thị 25 dòng dữ liệu
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select = new Select(dropdown);
//	    select.selectByValue("25");
//	    Thread.sleep(2000);
//	    // Đọc dữ liệu từ tệp Excel
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\SearchCapBac.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Chuỗi để lưu ID của các dòng không tìm thấy và tìm thấy
//	    StringBuilder pasStringBuilder = new StringBuilder();
//	    StringBuilder faildBuilder = new StringBuilder();
//	    // Duyệt qua từng dòng trong tệp Excel
//	    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//	        XSSFRow row = sheet.getRow(i);
//	        String id = row.getCell(1).getStringCellValue();
//	        Thread.sleep(500);
//	        // Nhập ID vào ô tìm kiếm
//	        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
//	        searchbox.sendKeys(id);
//	        Thread.sleep(1000);
//	        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	        System.out.println(dataTable.getText());
//	        // Kiểm tra xem có kết quả tìm kiếm hay không
//	        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
//	            faildBuilder.append(id);
//	        } else {
//	            pasStringBuilder.append(id);
//	        }
//	        searchbox.clear();
//	    }
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 45: Tìm kiếm với kí tự đặc biệt và Hiển thị 25 dữ liệu");
//	    String pasString = pasStringBuilder.toString();
//	    String faildString = faildBuilder.toString();
//	    System.out.println("Key word không có kết quả " + faildString);
//	    System.out.println("Key Word có kết quả " + pasString);
//	}

//	
	@Test (priority = 45)
	public void Action46() throws InterruptedException, IOException {
	    // Click vào liên kết để mở chức năng chỉnh sửa
	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
	    linkEdit.click();
	    Thread.sleep(2000);
	    // Chọn hiển thị 50 dòng dữ liệu
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
	    Select select = new Select(dropdown);
	    select.selectByValue("50");
	    Thread.sleep(2000);
	    // Đọc dữ liệu từ tệp Excel
	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\SearchCapBac.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    // Chuỗi để lưu ID của các dòng không tìm thấy và tìm thấy
	    StringBuilder pasStringBuilder = new StringBuilder();
	    StringBuilder faildBuilder = new StringBuilder();
	    // Duyệt qua từng dòng trong tệp Excel
	    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
	        XSSFRow row = sheet.getRow(i);
	        String id = row.getCell(1).getStringCellValue();
	        Thread.sleep(500);
	        // Nhập ID vào ô tìm kiếm
	        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
	        searchbox.sendKeys(id);
	        Thread.sleep(1000);
	        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
	        System.out.println(dataTable.getText());
	        // Kiểm tra xem có kết quả tìm kiếm hay không
	        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
	            faildBuilder.append(id);
	        } else {
	            pasStringBuilder.append(id);
	        }
	        searchbox.clear();
	    }
	    // In ra thông tin của testcase
	    System.out.println("Testcase 46: Tìm kiếm với kí tự đặc biệt và Hiển thị 50 dữ liệu");
	    String pasString = pasStringBuilder.toString();
	    String faildString = faildBuilder.toString();
	    System.out.println("Key word không có kết quả " + faildString);
	    System.out.println("Key Word có kết quả " + pasString);
	}

//	
//	@Test (priority = 46)
//	public void Action47() throws InterruptedException, IOException {
//	    // Click vào liên kết để mở chức năng chỉnh sửa
//	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	    linkEdit.click();
//	    Thread.sleep(2000);
//	    // Chọn hiển thị tất cả dữ liệu
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select"));
//	    Select select = new Select(dropdown);
//	    select.selectByValue("-1");
//	    Thread.sleep(2000);
//	    // Đọc dữ liệu từ tệp Excel
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\SearchCapBac.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    // Chuỗi để lưu ID của các dòng không tìm thấy và tìm thấy
//	    StringBuilder pasStringBuilder = new StringBuilder();
//	    StringBuilder faildBuilder = new StringBuilder();
//	    // Duyệt qua từng dòng trong tệp Excel
//	    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//	        XSSFRow row = sheet.getRow(i);
//	        String id = row.getCell(1).getStringCellValue();
//	        Thread.sleep(500);
//	        // Nhập ID vào ô tìm kiếm
//	        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
//	        searchbox.sendKeys(id);
//	        Thread.sleep(1000);
//	        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody"));
//	        System.out.println(dataTable.getText());
//	        // Kiểm tra xem có kết quả tìm kiếm hay không
//	        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
//	            faildBuilder.append(id);
//	        } else {
//	            pasStringBuilder.append(id);
//	        }
//	        searchbox.clear();
//	    }
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 47: Tìm kiếm với kí tự đặc biệt và Hiển thị tất cả dữ liệu");
//	    String pasString = pasStringBuilder.toString();
//	    String faildString = faildBuilder.toString();
//	    System.out.println("Key word không có kết quả " + faildString);
//	    System.out.println("Key Word có kết quả " + pasString);
//	}

//
//	@AfterTest
//	public void Close() {
//		driver.close();
//	}
}
