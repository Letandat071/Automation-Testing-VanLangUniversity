package HocHamHocVi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThemHocHamHocVi {
	static WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\AN515-45\\AppData\\Local\\Google\\Chrome\\User Data";
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

	@Test(priority = 1)
	public void Action1() throws IOException, InterruptedException {
	    System.out.println("Testcase 1: Chức năng thêm HHHV với kí tự đặc biệt tại Mã HHHV");
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng đầu tiên
	    XSSFRow row = sheet.getRow(0);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();
	    // Nhấn vào menu "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    // Nhấn vào nút "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    // Nhập Mã HHHV và Tên HHHV từ dữ liệu Excel
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    // Nhấn nút "Lưu"
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);
	    try {
	        // Thử nhấn nút "Lưu" lần nữa để kiểm tra xem việc lưu có thành công không
	        clickElement.click();
	        System.out.println("Click Lưu không thành công");
	    } catch (WebDriverException e) {
	        // Nếu ném ra ngoại lệ WebDriverException, in ra thông báo là lưu thành công
	        System.out.println("Kết quả thực tế: Lưu thành công");
	    }
	    // Chuỗi kỳ vọng thông báo lỗi
	    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
	    System.out.println("Kết quả mong đợi: " + expected);
	    // In ra kết quả mong đợi của thông báo lỗi
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    System.out.println("===============");
	}

	@Test(priority = 2)
	public void Action2() throws IOException, InterruptedException {
	    System.out.println("Testcase 2: Chức năng thêm HHHV với khoảng trắng tại Mã HHHV");
	    Thread.sleep(2000);
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ hai
	    XSSFRow row = sheet.getRow(1);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();
	    // Nhấn vào menu "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    // Nhấn vào nút "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    // Nhập Mã HHHV và Tên HHHV từ dữ liệu Excel
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    // Nhấn nút "Lưu"
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);
	    try {
	        // Thử nhấn nút "Lưu" lần nữa để kiểm tra xem việc lưu có thành công không
	        clickElement.click();
	        System.out.println("Click Lưu không thành công");
	    } catch (WebDriverException e) {
	        // Nếu ném ra ngoại lệ WebDriverException, in ra thông báo là lưu thành công
	        System.out.println("Kết quả thực tế: Lưu thành công");
	    }
	    // Chuỗi kỳ vọng thông báo lỗi
	    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
	    System.out.println("Kết quả mong đợi: " + expected);
	    // In ra kết quả mong đợi của thông báo lỗi
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    System.out.println("===============");
	}

	@Test(priority = 3)
	public void Action3() throws IOException, InterruptedException {
	    System.out.println("Testcase 3: Chức năng thêm HHHV với kí tự đặc biệt và số tại Mã HHHV");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ ba
	    XSSFRow row = sheet.getRow(2);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    // Nhấn vào nút "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    // Nhập Mã HHHV và Tên HHHV từ dữ liệu Excel
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    // Nhấn nút "Lưu"
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);
	    try {
	        // Thử nhấn nút "Lưu" lần nữa để kiểm tra xem việc lưu có thành công không
	        clickElement.click();
	        System.out.println("Click Lưu không thành công");
	    } catch (WebDriverException e) {
	        // Nếu ném ra ngoại lệ WebDriverException, in ra thông báo là lưu thành công
	        System.out.println("Kết quả thực tế: Lưu thành công");
	    }
	    // Chuỗi kỳ vọng thông báo lỗi
	    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
	    System.out.println("Kết quả mong đợi: " + expected);
	    // In ra kết quả mong đợi của thông báo lỗi
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    System.out.println("===============");
	}
	@Test(priority = 4)
	public void Action4() throws IOException, InterruptedException {
	    System.out.println("Testcase 4: Chức năng thêm HHHV với kí tự đặc biệt tại Tên HHHV");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ tư
	    XSSFRow row = sheet.getRow(3);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    // Nhấn vào nút "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    // Nhập Mã HHHV và Tên HHHV từ dữ liệu Excel
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    // Nhấn nút "Lưu"
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);
	    // Chuỗi kỳ vọng thông báo lỗi
	    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
	    System.out.println("Kết quả mong đợi: " + expected);
	    // In ra kết quả mong đợi của thông báo lỗi
	    try {
	        // Thử nhấn nút "Lưu" lần nữa để kiểm tra xem việc lưu có thành công không
	        clickElement.click();
	        System.out.println("Click Lưu không thành công");
	    } catch (WebDriverException e) {
	        // Nếu ném ra ngoại lệ WebDriverException, in ra thông báo là lưu thành công
	        System.out.println("Kết quả thực tế: Lưu thành công");
	    }
	    // In ra kết quả thực tế của thông báo lỗi trên giao diện web
	    System.out.println("===============");
	}

	@Test(priority = 5)
	public void Action5() throws IOException, InterruptedException {
	    System.out.println("Testcase 5: Chức năng thêm HHHV với khoảng trắng tại Tên HHHV");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ năm
	    XSSFRow row = sheet.getRow(4);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    // Nhấn vào nút "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    // Nhập Mã HHHV và Tên HHHV từ dữ liệu Excel
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    // Nhấn nút "Lưu"
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);
	    // Chuỗi kỳ vọng thông báo lỗi
	    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
	    System.out.println("Kết quả mong đợi: " + expected);
	    // In ra kết quả mong đợi của thông báo lỗi
	    try {
	        // Thử nhấn nút "Lưu" lần nữa để kiểm tra xem việc lưu có thành công không
	        clickElement.click();
	        System.out.println("Click Lưu không thành công");
	    } catch (WebDriverException e) {
	        // Nếu ném ra ngoại lệ WebDriverException, in ra thông báo là lưu thành công
	        System.out.println("Kết quả thực tế: Lưu thành công");
	    }
	    // In ra dấu phân biệt giữa các testcase
	    System.out.println("===============");
	}

	@Test(priority = 6)
	public void Action6() throws IOException, InterruptedException {
	    System.out.println("Testcase 6: Chức năng thêm HHHV với kí tự đặc biệt và số tại Tên HHHV");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ sáu
	    XSSFRow row = sheet.getRow(5);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    // Nhấn vào nút "Thêm mới"
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    // Nhập Mã HHHV và Tên HHHV từ dữ liệu Excel
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    // Nhấn nút "Lưu"
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);
	    // Chuỗi kỳ vọng thông báo lỗi
	    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    System.out.println("Kết quả mong đợi: " + expected);
	    // In ra kết quả mong đợi của thông báo lỗi
	    try {
	        // Thử nhấn nút "Lưu" lần nữa để kiểm tra xem việc lưu có thành công không
	        clickElement.click();
	        System.out.println("Click Lưu không thành công");
	    } catch (WebDriverException e) {
	        // Nếu ném ra ngoại lệ WebDriverException, in ra thông báo là lưu thành công
	        System.out.println("Kết quả thực tế: Lưu thành công");
	    }
	    // In ra dấu phân biệt giữa các testcase
	    System.out.println("===============");
	}
	@Test(priority = 7)
	public void Action7() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 7: Chức năng thêm HHHV với khoảng trắng tại Tên HHHV và Mã HHHV");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu Mã HHHV và Tên HHHV từ dòng thứ 7 của file Excel
	    XSSFRow row = sheet.getRow(6);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập Mã HHHV và Tên HHHV từ dữ liệu Excel vào các trường tương ứng trên giao diện
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Lưu" để lưu thông tin
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);
	    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
	    System.out.println("Kết quả mong đợi: " + expected);
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    // Thử nhấn nút "Lưu" lần nữa để kiểm tra xem việc lưu có thành công không
	    try {
	        clickElement.click();
	        System.out.println("Click Lưu không thành công");
	    } catch (WebDriverException e) {
	        // Nếu ném ra ngoại lệ WebDriverException, in ra thông báo là lưu thành công
	        System.out.println("Kết quả thực tế: Lưu thành công");
	    }
	    // In ra dấu phân biệt giữa các testcase
	    System.out.println("===============");
	}

	@Test(priority = 8)
	public void Action8() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 8: Chức năng thêm HHHV với kí tự có dấu tại Mã HHHV");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu Mã HHHV và Tên HHHV từ dòng thứ 8 của file Excel
	    XSSFRow row = sheet.getRow(7);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập Mã HHHV và Tên HHHV từ dữ liệu Excel vào các trường tương ứng trên giao diện
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Lưu" để lưu thông tin
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);
	    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
	    System.out.println("Kết quả mong đợi: " + expected);
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    // Thử nhấn nút "Lưu" lần nữa để kiểm tra xem việc lưu có thành công không
	    try {
	        clickElement.click();
	        System.out.println("Click Lưu không thành công");
	    } catch (WebDriverException e) {
	        // Nếu ném ra ngoại lệ WebDriverException, in ra thông báo là lưu thành công
	        System.out.println("Kết quả thực tế: Lưu thành công");
	    }
	    // In ra dấu phân biệt giữa các testcase
	    System.out.println("===============");
	}

	@Test(priority = 9)
	public void Action9() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 9: Chức năng thêm HHHV với bỏ trống tại Tên HHHV");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu Mã HHHV từ dòng thứ 9 của file Excel
	    XSSFRow row = sheet.getRow(8);
	    String id = row.getCell(0).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập Mã HHHV từ dữ liệu Excel vào trường tương ứng trên giao diện
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Lưu" để lưu thông tin
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);
	    String expected = "Bạn chưa nhập tên học hàm, học vị";
	    System.out.println("Kết quả mong đợi: " + expected);
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"name-error\"]"));
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    // Thử nhấn nút "Lưu" lần nữa để kiểm tra xem việc lưu có thành công không
	    try {
	        clickElement.click();
	        System.out.println("Click Lưu không thành công");
	    } catch (WebDriverException e) {
	        // Nếu ném ra ngoại lệ WebDriverException, in ra thông báo là lưu thành công
	        System.out.println("Kết quả thực tế: Lưu thành công");
	    }
	    // In ra dấu phân biệt giữa các testcase
	    System.out.println("===============");
	}

	@Test(priority = 10)
	public void Action10() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 10: Chức năng thêm HHHV với bỏ trống tại Mã HHHV");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel, không cần dữ liệu từ cột Mã HHHV do ta không nhập dữ liệu vào trường đó trong test case này
	    XSSFRow row = sheet.getRow(9);
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu Tên HHHV từ file Excel vào trường tương ứng trên giao diện
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Lưu" để lưu thông tin
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);
	    
	    // Thử nhấn nút "Lưu" lần nữa để kiểm tra xem việc lưu có thành công không
	    try {
	        clickElement.click();
	        System.out.println("Click Lưu không thành công");
	    } catch (WebDriverException e) {
	        // Nếu ném ra ngoại lệ WebDriverException, in ra thông báo là lưu thành công
	        System.out.println("Kết quả thực tế: Lưu thành công");
	    }
	    // In ra kết quả mong đợi của thông báo lỗi
	    String expected = "Bạn chưa nhập mã học hàm, học vị";
	    System.out.println("Kết quả mong đợi: " + expected);
	    
	    // In ra kết quả thực tế của thông báo lỗi
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    System.out.println("===============");
	}

	@Test(priority = 11)
	public void Action11() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 11: Chức năng thêm HHHV với đầy đủ và đúng thông tin");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(10);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Lưu" để lưu thông tin
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(4000);
	    
	    // Kiểm tra xem nút "Lưu" có còn được kích hoạt không
	    if (clickElement.isEnabled()) {
	        System.out.println("Click lưu và tạo thành công tại mục HHHV");
	    } else {
	        System.out.println("Click lưu và tạo không thành công tại mục HHHV");
	    }
	    // In ra dấu phân biệt giữa các testcase
	    System.out.println("===============");
	}

	@Test(priority = 12)
	public void Action12() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 12: Chức năng thêm HHHV với kí tự đặc biệt tại Thứ tự");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(11);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();
	    String level = row.getCell(2).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    WebElement LEVEL = driver.findElement(By.xpath("//*[@id=\"level\"]"));
	    LEVEL.clear(); // Xóa dữ liệu có sẵn trong trường Thứ tự
	    Thread.sleep(2000);
	    LEVEL.sendKeys(level);
	    Thread.sleep(3000);
	    Thread.sleep(3000);
	    
	    // Nhấn nút "Lưu" để lưu thông tin
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);

	    // Kiểm tra thông báo lỗi trên giao diện web và so sánh với kết quả mong đợi
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
	    String expected = "Vui lòng nhập lớn hơn hoặc bằng 1"; // Chuỗi kỳ vọng thông báo lỗi
	    System.out.println("Kết quả mong đợi: " + expected);
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    System.out.println("===============");
	}

	@Test(priority = 13)
	public void Action13() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 13: Chức năng thêm HHHV với số âm tại Thứ tự");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(12);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();
	    String level = row.getCell(2).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    WebElement LEVEL = driver.findElement(By.xpath("//*[@id=\"level\"]"));
	    LEVEL.clear(); // Xóa dữ liệu có sẵn trong trường Thứ tự
	    Thread.sleep(2000);
	    LEVEL.sendKeys(level);
	    Thread.sleep(3000);
	    
	    // Nhấn nút "Lưu" để lưu thông tin
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);

	    // Kiểm tra thông báo lỗi trên giao diện web và so sánh với kết quả mong đợi
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
	    String expected = "Vui lòng nhập lớn hơn hoặc bằng 1"; // Chuỗi kỳ vọng thông báo lỗi
	    System.out.println("Kết quả mong đợi: " + expected);
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    System.out.println("===============");
	}

	@Test(priority = 14)
	public void Action14() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 14: Chức năng thêm HHHV với số lớn hơn 100 tại Thứ tự");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(13);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();
	    String level = row.getCell(2).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    WebElement LEVEL = driver.findElement(By.xpath("//*[@id=\"level\"]"));
	    LEVEL.clear(); // Xóa dữ liệu có sẵn trong trường Thứ tự
	    Thread.sleep(2000);
	    LEVEL.sendKeys(level);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Lưu" để lưu thông tin
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);

	    // Kiểm tra thông báo lỗi trên giao diện web và so sánh với kết quả mong đợi
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
	    String expected = "Vui lòng nhập nhỏ hơn hoặc bằng 100"; // Chuỗi kỳ vọng thông báo lỗi
	    System.out.println("Kết quả mong đợi: " + expected);
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    System.out.println("===============");
	}

	@Test(priority = 15)
	public void Action15() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 15: Chức năng thêm HHHV với bỏ trống tại Thứ tự");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(13);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    WebElement LEVEL = driver.findElement(By.xpath("//*[@id=\"level\"]"));
	    LEVEL.clear(); // Xóa dữ liệu có sẵn trong trường Thứ tự
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Lưu" để lưu thông tin
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
	    clickElement.click();
	    Thread.sleep(2000);

	    // Kiểm tra thông báo lỗi trên giao diện web và so sánh với kết quả mong đợi
	    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
	    String expected = "Bạn chưa nhập thứ tự"; // Chuỗi kỳ vọng thông báo lỗi
	    System.out.println("Kết quả mong đợi: " + expected);
	    System.out.println("Kết quả thực tế: " + errorElement.getText());
	    System.out.println("===============");
	}

	@Test(priority = 16)
	public void Action16() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 16: Chức năng thêm HHHV với số lớn hơn 100 tại Thứ tự và bấm Hủy");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(13);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();
	    String level = row.getCell(2).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    WebElement LEVEL = driver.findElement(By.xpath("//*[@id=\"level\"]"));
	    LEVEL.clear(); // Xóa dữ liệu có sẵn trong trường Thứ tự
	    Thread.sleep(2000);
	    LEVEL.sendKeys(level);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 17)
	public void Action17() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 17: Chức năng thêm HHHV với bỏ trống tại Thứ tự và bấm Hủy");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(13);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    WebElement LEVEL = driver.findElement(By.xpath("//*[@id=\"level\"]"));
	    LEVEL.clear(); // Xóa dữ liệu có sẵn trong trường Thứ tự
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 18)
	public void Action18() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 18: Chức năng thêm HHHV với kí tự đặc biệt tại Mã HHHV và ấn Hủy");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(0);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);

	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}
	@Test(priority = 19)
	public void Action19() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 19: Chức năng thêm HHHV với khoảng trắng tại Mã HHHV và ấn Hủy");
	    Thread.sleep(2000);
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(1);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();
	    
	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 20)
	public void Action20() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 20: Chức năng thêm HHHV với kí tự đặc biệt và số tại Mã HHHV và ấn Hủy");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(2);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 21)
	public void Action21() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 21: Chức năng thêm HHHV với kí tự đặc biệt tại Tên HHHV và ấn Hủy");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(3);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 22)
	public void Action22() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 22: Chức năng thêm HHHV với khoảng trắng tại Tên HHHV và ấn Hủy");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(4);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 23)
	public void Action23() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 23: Chức năng thêm HHHV với kí tự đặc biệt và số tại Tên HHHV và ấn Hủy");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(5);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 24)
	public void Action24() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 24: Chức năng thêm HHHV với khoảng trắng tại Tên HHHV và Mã HHHV ấn Hủy");
	    
	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(6);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 25)
	public void Action25() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 25: Chức năng thêm HHHV với kí tự có dấu tại Mã HHHV ấn Hủy");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(7);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 26)
	public void Action26() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 26: Chức năng thêm HHHV với bỏ trống tại Tên HHHV ấn Hủy");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(8);
	    String id = row.getCell(0).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 27)
	public void Action27() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 27: Chức năng thêm HHHV với bỏ trống tại Mã HHHV và ấn Hủy");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(9);
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	
	@Test(priority = 28)
	public void Action28() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 28: Chức năng thêm HHHV với đầy đủ và đúng thông tin và ấn Hủy");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng đầu tiên
	    XSSFRow row = sheet.getRow(10);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    Thread.sleep(2000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 29)
	public void Action29() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 29: Chức năng thêm HHHV với kí tự đặc biệt tại Thứ tự và ấn Hủy");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(11);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();
	    String level = row.getCell(2).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    WebElement LEVEL = driver.findElement(By.xpath("//*[@id=\"level\"]"));
	    LEVEL.clear();
	    Thread.sleep(2000);
	    LEVEL.sendKeys(level);
	    Thread.sleep(3000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@Test(priority = 30)
	public void Action30() throws IOException, InterruptedException {
	    // In ra thông tin về testcase đang được thực thi
	    System.out.println("Testcase 30: Chức năng thêm HHHV với số âm tại Thứ tự và ấn Hủy");

	    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(12);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();
	    String level = row.getCell(2).getStringCellValue();

	    // Nhấn vào menu "Thêm mới" trong giao diện
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	    
	    // Nhấn vào nút "Thêm mới" để mở form thêm mới
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	    Thread.sleep(2000);
	    
	    // Nhập dữ liệu từ file Excel vào các trường tương ứng trên giao diện web
	    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
	    ID.sendKeys(id);
	    WebElement NAME = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	    NAME.sendKeys(name);
	    WebElement LEVEL = driver.findElement(By.xpath("//*[@id=\"level\"]"));
	    LEVEL.clear();
	    Thread.sleep(2000);
	    LEVEL.sendKeys(level);
	    Thread.sleep(3000);
	    
	    // Nhấn nút "Hủy" để hủy thao tác thêm mới
	    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục tạo HHHV");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục tạo HHHV");
	    }
	    System.out.println("===============");
	}

	@AfterTest
	public void Close() {
		driver.close();
	}
}
