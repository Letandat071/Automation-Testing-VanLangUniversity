package HocHamHocViTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HocHamHocVi.ThemCapBac_Page;
import PageSetup.Setup;

public class ThemCapBac_Test {
	   static WebDriver driver;
		@BeforeSuite
		public void Main() throws IOException, InterruptedException {
			Setup setup = new Setup();
			driver = setup.setup();
			Thread.sleep(3000);
		}
		@BeforeTest
		public void Setup2() throws InterruptedException {
			ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
			MainPage.Menu();
			Thread.sleep(2000);
		}
		@Test(priority = 1)
		public void Action1() throws IOException, InterruptedException {
		    // In ra thông tin về test case đang được thực hiện
		    System.out.println("Testcase 1: Chức năng thêm Cấp Bậc với khoảng trắng tại Mã cấp bậc");
		    
		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu từ ô đầu tiên của dòng đầu tiên trong Excel
		    XSSFRow row = sheet.getRow(0);
		    String id = row.getCell(0).getStringCellValue();
		    
		    // Khởi tạo một đối tượng của class ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);
		    // Lấy danh sách các phần tử trong dropdown
		    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_id\"]/option"));
		    int numberOfElements = elements.size();
		    // Chọn một phần tử ngẫu nhiên trong dropdown
		    Random radom = new Random();
		    int rant = radom.nextInt(numberOfElements);
		    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]"));
		    Select select = new Select(dropdown);
		    select.selectByIndex(rant);
		    Thread.sleep(2000);
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);

		    // Click vào nút Lưu
		    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]"));
		    clickElement.click();
		    Thread.sleep(2000);
		    
		    // Kiểm tra xem thông báo lỗi có hiển thị không
		    try {
		        clickElement.click();
		        System.out.println("Click Lưu không thành công");
		    } catch (WebDriverException e) {
		        System.out.println("Kết quả thực tế: Lưu thành công");
		    }

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
		    System.out.println("Kết quả mong đợi: " + expected);
		    
		    // In ra thông tin thực tế của thông báo lỗi
		    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
		    System.out.println("Kết quả thực tế: " + errorElement.getText());
		    System.out.println("===============");
		}
		@Test(priority = 2)
		public void Action2() throws IOException, InterruptedException {
		    // In ra thông báo cho testcase đang được thực thi
		    System.out.println("Testcase 2: Chức năng thêm Cấp Bậc với kí tự đặc biệt tại Mã cấp bậc");

		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu từ ô đầu tiên của dòng thứ hai (index 1) trong sheet
		    XSSFRow row = sheet.getRow(1);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);

		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);

		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);

		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);

		    // Lấy danh sách tất cả các phần tử trong dropdown chứa ID học hàm/học vị
		    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_id\"]/option"));
		    int numberOfElements = elements.size();

		    // Random một số nguyên từ 0 đến số lượng phần tử trong dropdown
		    Random random = new Random();
		    int rand = random.nextInt(numberOfElements);

		    // Chọn một phần tử trong dropdown bằng cách sử dụng index được random
		    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]"));
		    Select select = new Select(dropdown);
		    select.selectByIndex(rand);
		    Thread.sleep(2000);
		    
		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);

		    // Click vào nút Lưu
		    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]"));
		    clickElement.click();
		    Thread.sleep(2000);

		    // Xử lý exception nếu click vào nút Lưu không thành công
		    try {
		        clickElement.click();
		        System.out.println("Click Lưu không thành công");
		    } catch (WebDriverException e) {
		        System.out.println("Kết quả thực tế: Lưu thành công");
		    }

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
		    System.out.println("Kết quả mong đợi: " + expected);

		    // Lấy thông báo lỗi thực tế hiển thị trên trang web
		    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
		    System.out.println("Kết quả thực tế: " + errorElement.getText());
		    System.out.println("===============");
		}
		@Test(priority = 3)
		public void Action3() throws IOException, InterruptedException {
		    // In ra thông báo cho testcase đang được thực thi
		    System.out.println("Testcase 3: Chức năng thêm Cấp Bậc với kí tự có dấu tại Mã cấp bậc");

		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu từ ô đầu tiên của dòng thứ ba (index 2) trong sheet
		    XSSFRow row = sheet.getRow(2);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);

		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);

		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);

		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);

		    // Lấy danh sách tất cả các phần tử trong dropdown chứa ID học hàm/học vị
		    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_id\"]/option"));
		    int numberOfElements = elements.size();

		    // Random một số nguyên từ 0 đến số lượng phần tử trong dropdown
		    Random random = new Random();
		    int rand = random.nextInt(numberOfElements);

		    // Chọn một phần tử trong dropdown bằng cách sử dụng index được random
		    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]"));
		    Select select = new Select(dropdown);
		    select.selectByIndex(rand);
		    Thread.sleep(2000);
		    
		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);

		    // Click vào nút Lưu
		    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]"));
		    clickElement.click();
		    Thread.sleep(2000);

		    // Xử lý exception nếu click vào nút Lưu không thành công
		    try {
		        clickElement.click();
		        System.out.println("Click Lưu không thành công");
		    } catch (WebDriverException e) {
		        System.out.println("Kết quả thực tế: Lưu thành công");
		    }

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
		    System.out.println("Kết quả mong đợi: " + expected);

		    // Lấy thông báo lỗi thực tế hiển thị trên trang web
		    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
		    System.out.println("Kết quả thực tế: " + errorElement.getText());
		    System.out.println("===============");
		}
		@Test(priority = 4)
		public void Action4() throws IOException, InterruptedException {
		    // In ra thông báo cho testcase đang được thực thi
		    System.out.println("Testcase 4: Chức năng thêm Cấp Bậc đầy đủ và đúng thông tin");

		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu từ ô đầu tiên của dòng thứ tư (index 3) trong sheet
		    XSSFRow row = sheet.getRow(3);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);

		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);

		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);

		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);

		    // Lấy danh sách tất cả các phần tử trong dropdown chứa ID học hàm/học vị
		    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_id\"]/option"));
		    int numberOfElements = elements.size();
		    Random random = new Random();
		    int rand = random.nextInt(numberOfElements);

		    // Chọn một phần tử trong dropdown bằng cách sử dụng index được random
		    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]"));
		    Select select = new Select(dropdown);
		    select.selectByIndex(rand);

		    // Lấy và in ra giá trị của cấp bậc đã được chọn
		    WebElement printElement = driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_id-container\"]"));
		    String printString = printElement.getText();
		    System.out.println("Cấp bậc được thêm là: " + printString);
		    Thread.sleep(2000);

		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);

		    // Click vào nút Lưu
		    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]"));
		    clickElement.click();
		    System.out.println("===============");
		}
		
		@Test(priority = 5)
		public void Action5() throws IOException, InterruptedException {
		    // In ra thông báo cho testcase đang được thực thi
		    System.out.println("Testcase 5: Chức năng thêm Cấp Bậc với khoảng trắng tại Mã cấp bậc và không chọn HHHV");

		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu từ ô đầu tiên của dòng đầu tiên (index 0) trong sheet
		    XSSFRow row = sheet.getRow(0);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);

		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);

		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);

		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);


		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);

		    // Click vào nút Lưu
		    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]"));
		    clickElement.click();
		    Thread.sleep(2000);

		    // Xử lý exception nếu click vào nút Lưu không thành công
		    try {
		        clickElement.click();
		        System.out.println("Click Lưu không thành công");
		    } catch (WebDriverException e) {
		        System.out.println("Kết quả thực tế: Lưu thành công");
		    }

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected1 = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
		    System.out.println("Kết quả mong đợi tại Mã Cấp Bậc: " + expected1);

		    // Lấy thông báo lỗi thực tế hiển thị trên trang web
		    WebElement errorElement1 = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
		    System.out.println("Kết quả thực tế tại Mã Cấp Bậc: " + errorElement1.getText());
		    System.out.println("=========");

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected2 = "Bạn chưa chọn học hàm, học vị";
		    System.out.println("Kết quả mong đợi tại Học Hàm Học Vị: " + expected2);

		    // Lấy thông báo lỗi thực tế hiển thị trên trang web
		    WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"academic_degree_id-error\"]"));
		    System.out.println("Kết quả thực tế tại Học Hàm Học Vị: " + errorElement2.getText());
		    System.out.println("===============");
		}
		@Test(priority = 6)
		public void Action6() throws IOException, InterruptedException {
		    // In ra thông báo cho testcase đang được thực thi
		    System.out.println("Testcase 6: Chức năng thêm Cấp Bậc với kí tự đặc biệt tại Mã cấp bậc và không chọn HHHV");

		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu từ ô đầu tiên của dòng thứ hai (index 1) trong sheet
		    XSSFRow row = sheet.getRow(1);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);

		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);

		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);

		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);


		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);

		    // Click vào nút Lưu
		    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]"));
		    clickElement.click();
		    Thread.sleep(2000);

		    // Xử lý exception nếu click vào nút Lưu không thành công
		    try {
		        clickElement.click();
		        System.out.println("Click Lưu không thành công");
		    } catch (WebDriverException e) {
		        System.out.println("Kết quả thực tế: Lưu thành công");
		    }

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected1 = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
		    System.out.println("Kết quả mong đợi tại Mã Cấp Bậc: " + expected1);

		    // Lấy thông báo lỗi thực tế hiển thị trên trang web
		    WebElement errorElement1 = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
		    System.out.println("Kết quả thực tế tại Mã Cấp Bậc: " + errorElement1.getText());
		    System.out.println("=========");

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected2 = "Bạn chưa chọn học hàm, học vị";
		    System.out.println("Kết quả mong đợi tại Học Hàm Học Vị: " + expected2);

		    // Lấy thông báo lỗi thực tế hiển thị trên trang web
		    WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"academic_degree_id-error\"]"));
		    System.out.println("Kết quả thực tế tại Học Hàm Học Vị: " + errorElement2.getText());
		    System.out.println("===============");
		}
		@Test(priority = 7)
		public void Action7() throws IOException, InterruptedException {
		    // In ra thông báo cho testcase đang được thực thi
		    System.out.println("Testcase 7: Chức năng thêm Cấp Bậc với kí tự có dấu tại Mã cấp bậc và không chọn HHHV");

		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu từ ô đầu tiên của dòng thứ hai (index 2) trong sheet
		    XSSFRow row = sheet.getRow(2);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);

		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);

		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);

		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);

		    // Chọn một phần tử từ dropdown HHHV (chưa chọn)
//		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
//		    Thread.sleep(2000);

		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);

		    // Click vào nút Lưu
		    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]"));
		    clickElement.click();
		    Thread.sleep(2000);

		    // Xử lý exception nếu click vào nút Lưu không thành công
		    try {
		        clickElement.click();
		        System.out.println("Click Lưu không thành công");
		    } catch (WebDriverException e) {
		        System.out.println("Kết quả thực tế: Lưu thành công");
		    }

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected1 = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";
		    System.out.println("Kết quả mong đợi tại Mã Cấp Bậc: " + expected1);

		    // Lấy thông báo lỗi thực tế hiển thị trên trang web
		    WebElement errorElement1 = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
		    System.out.println("Kết quả thực tế tại Mã Cấp Bậc: " + errorElement1.getText());
		    System.out.println("=========");

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected2 = "Bạn chưa chọn học hàm, học vị";
		    System.out.println("Kết quả mong đợi tại Học Hàm Học Vị: " + expected2);

		    // Lấy thông báo lỗi thực tế hiển thị trên trang web
		    WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"academic_degree_id-error\"]"));
		    System.out.println("Kết quả thực tế tại Học Hàm Học Vị: " + errorElement2.getText());
		    System.out.println("===============");
		}
		@Test(priority = 8)
		public void Action8() throws IOException, InterruptedException {
			System.out.println("Testcase 8: Chức năng thêm Cấp Bậc với kí tự gạch ngang Mã cấp bậc và không chọn HHHV");
			// Mở file Excel và lấy dữ liệu từ sheet đầu tiên

			FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Lấy dữ liệu học kỳ từ ô đầu tiên của dòng đầu tiên
			XSSFRow row = sheet.getRow(3);
			String id = row.getCell(0).getStringCellValue();

			ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			MainPage.CapBac();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
			Thread.sleep(2000);
			WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
			ID.sendKeys(id);


			WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]"));
			clickElement.click();
			Thread.sleep(2000);
			try {
				clickElement.click();
				System.out.println("Click Lưu không thành công");
			}

			catch (WebDriverException e) {
				System.out.println("Kết quả thực tế: Lưu thành công");
			}

			String expected2 = "Bạn chưa chọn học hàm, học vị"; // Chuỗi kỳ vọng thông báo lỗi
			System.out.println("Kết quả mong đợi tại Học Hàm Học Vị: " + expected2);
			WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"academic_degree_id-error\"]"));
			System.out.println("Kết quả thực tế tại Học Hàm Học Vị: " + errorElement2.getText());
			System.out.println("===============");
			
		}
		@Test(priority = 9)
		public void Action9() throws IOException, InterruptedException {
		    // In ra thông báo cho testcase đang được thực thi
		    System.out.println("Testcase 9: Chức năng thêm Cấp Bậc với bỏ trống Mã cấp bậc ");

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);

		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);

		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);

		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);

		    // Chọn một phần tử từ dropdown HHHV (chưa chọn)
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);

		    // Tạo một số ngẫu nhiên để chọn từ dropdown
		    Random random = new Random();
		    int randomValue = random.nextInt(34)+1;
		    String xpathPC = "/html/body/div[3]/div[2]/form/div[1]/div/span[2]/span/span[2]/ul/li["+randomValue+"]";
		    WebElement itemElement = driver.findElement(By.xpath(xpathPC));
		    itemElement.click();
		    
		    // Click vào nút Lưu
		    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]"));
		    clickElement.click();
		    Thread.sleep(2000);

		    // Xử lý exception nếu click vào nút Lưu không thành công
		    try {
		        clickElement.click();
		        System.out.println("Click Lưu không thành công");
		    } catch (WebDriverException e) {
		        System.out.println("Kết quả thực tế: Lưu thành công");
		    }

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected1 = "Bạn chưa nhập mã cấp bậc";
		    System.out.println("Kết quả mong đợi tại Mã Cấp Bậc: " + expected1);

		    // Lấy thông báo lỗi thực tế hiển thị trên trang web
		    WebElement errorElement1 = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
		    System.out.println("Kết quả thực tế tại Mã Cấp Bậc: " + errorElement1.getText());
		    System.out.println("===============");
		}
		@Test(priority = 10)
		public void Action10() throws IOException, InterruptedException {
		    // In ra thông báo cho testcase đang được thực thi
		    System.out.println("Testcase 10: Chức năng thêm Cấp Bậc với bỏ trống Mã cấp bậc và không chọn HHHV ");

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);

		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);

		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);

		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);


		    // Click vào nút Lưu
		    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]"));
		    clickElement.click();
		    Thread.sleep(2000);

		    // Xử lý exception nếu click vào nút Lưu không thành công
		    try {
		        clickElement.click();
		        System.out.println("Click Lưu không thành công");
		    } catch (WebDriverException e) {
		        System.out.println("Kết quả thực tế: Lưu thành công");
		    }

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected1 = "Bạn chưa nhập mã cấp bậc";
		    System.out.println("Kết quả mong đợi tại Mã Cấp Bậc: " + expected1);

		    // Lấy thông báo lỗi thực tế hiển thị trên trang web
		    WebElement errorElement1 = driver.findElement(By.xpath("//*[@id=\"id-error\"]"));
		    System.out.println("Kết quả thực tế tại Mã Cấp Bậc: " + errorElement1.getText());
		    System.out.println("=========");

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected2 = "Bạn chưa chọn học hàm, học vị";
		    System.out.println("Kết quả mong đợi tại Học Hàm Học Vị: " + expected2);

		    // Lấy thông báo lỗi thực tế hiển thị trên trang web
		    WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"academic_degree_id-error\"]"));
		    System.out.println("Kết quả thực tế tại Học Hàm Học Vị: " + errorElement2.getText());
		    System.out.println("===============");
		}
		@Test(priority = 11)
		public void Action11() throws IOException, InterruptedException {
		    // In ra thông báo cho testcase đang được thực thi
		    System.out.println("Testcase 11: Chức năng thêm Cấp Bậc với khoảng trắng tại Mã cấp bậc và ấn Hủy");

		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu từ ô đầu tiên của dòng đầu tiên trong sheet
		    XSSFRow row = sheet.getRow(0);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);

		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);

		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);

		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);

		    // Chọn một phần tử từ dropdown HHHV
		    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_id\"]/option"));
		    int numberOfElements = elements.size();
		    Random radom = new Random();
		    int rant = radom.nextInt(numberOfElements);
		    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]"));
		    Select select = new Select(dropdown);
		    select.selectByIndex(rant);
		    Thread.sleep(2000);

		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);

		    // Click vào nút Hủy
		    MainPage.ClickCloseButton();
		    System.out.println("===============");
		}
		@Test(priority = 12)
		public void Action12() throws IOException, InterruptedException {
		    // In ra thông báo cho testcase đang được thực thi
		    System.out.println("Testcase 12: Chức năng thêm Cấp Bậc với kí tự đặc biệt tại Mã cấp bậc và ấn Hủy");

		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu từ ô đầu tiên của dòng thứ hai trong sheet
		    XSSFRow row = sheet.getRow(1);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);

		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);

		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    
		    // Click vào nút thêm mới
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
			Thread.sleep(2000);
			 List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_id\"]/option"));
			    int numberOfElements = elements.size();
			    Random radom = new Random();
			    int rant = radom.nextInt(numberOfElements);
			    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]"));
			    Select select = new Select(dropdown);
			    select.selectByIndex(rant);
			    Thread.sleep(2000);

			    // Nhập ID từ file Excel vào ô ID trên trang web
			    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
			    ID.sendKeys(id);

			    // Click vào nút Hủy
			    MainPage.ClickCloseButton();
			    System.out.println("===============");
			

		}
		@Test(priority = 13)
		public void Action13() throws IOException, InterruptedException {
		    // In ra tên của testcase
		    System.out.println("Testcase 13: Chức năng thêm Cấp Bậc với kí tự có dấu tại Mã cấp bậc và ấn Hủy");
		    
		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ ba trong sheet
		    XSSFRow row = sheet.getRow(2);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);
		    // Chọn một phần tử từ dropdown HHHV
		    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_id\"]/option"));
		    int numberOfElements = elements.size();
		    Random radom = new Random();
		    int rant = radom.nextInt(numberOfElements);
		    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]"));
		    Select select = new Select(dropdown);
		    select.selectByIndex(rant);
		    Thread.sleep(2000);
		    
		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);
		    // Click vào nút Hủy
		    MainPage.ClickCloseButton();
		    // In ra một dòng để phân biệt giữa các testcase khi chạy
		    System.out.println("===============");
		}

		@Test(priority = 14)
		public void Action14() throws IOException, InterruptedException {
		    // In ra tên của testcase
		    System.out.println("Testcase 14: Chức năng thêm Cấp Bậc với kí tự gạch ngang Mã cấp bậc và ấn Hủy");
		    
		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ tư trong sheet
		    XSSFRow row = sheet.getRow(3);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);
		    // Chọn một phần tử từ dropdown HHHV
		    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_id\"]/option"));
		    int numberOfElements = elements.size();
		    Random radom = new Random();
		    int rant = radom.nextInt(numberOfElements);
		    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]"));
		    Select select = new Select(dropdown);
		    select.selectByIndex(rant);
		    Thread.sleep(2000);
		    
		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);
		    // Click vào nút Hủy
		    MainPage.ClickCloseButton();
		    // In ra một dòng để phân biệt giữa các testcase khi chạy
		    System.out.println("===============");
		}

		@Test(priority = 15)
		public void Action15() throws IOException, InterruptedException {
		    // In ra tên của testcase
		    System.out.println("Testcase 15: Chức năng thêm Cấp Bậc với khoảng trắng tại Mã cấp bậc và không chọn HHHV và ấn Hủy");
		    
		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng đầu tiên trong sheet
		    XSSFRow row = sheet.getRow(0);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);
		    // Click vào dropdown HHHV
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);
		    // Click lại vào dropdown HHHV để đóng dropdown
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);
		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);
		    // Click vào nút Hủy
		    MainPage.ClickCloseButton();
		    // In ra một dòng để phân biệt giữa các testcase khi chạy
		    System.out.println("===============");
		}
		@Test(priority = 16)
		public void Action16() throws IOException, InterruptedException {
		    // In ra tên của testcase
		    System.out.println("Testcase 16: Chức năng thêm Cấp Bậc với kí tự đặc biệt tại Mã cấp bậc và không chọn HHHV và ấn Hủy");
		    
		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ hai trong sheet
		    XSSFRow row = sheet.getRow(1);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);
		    // Click vào dropdown HHHV
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);
		    // Click lại vào dropdown HHHV để đóng dropdown
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);
		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);
		    // Click vào nút Hủy
		    MainPage.ClickCloseButton();
		    // In ra một dòng để phân biệt giữa các testcase khi chạy
		    System.out.println("===============");
		}

		@Test(priority = 17)
		public void Action17() throws IOException, InterruptedException {
		    // In ra tên của testcase
		    System.out.println("Testcase 17: Chức năng thêm Cấp Bậc với kí tự có dấu tại Mã cấp bậc và không chọn HHHV và ấn Hủy");
		    
		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ ba trong sheet
		    XSSFRow row = sheet.getRow(2);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);
		    // Click vào dropdown HHHV
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);
		    // Click lại vào dropdown HHHV để đóng dropdown
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);
		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);
		    // Click vào nút Hủy
		    MainPage.ClickCloseButton();
		    // In ra một dòng để phân biệt giữa các testcase khi chạy
		    System.out.println("===============");
		}

		@Test(priority = 18)
		public void Action18() throws IOException, InterruptedException {
		    // In ra tên của testcase
		    System.out.println("Testcase 18: Chức năng thêm Cấp Bậc với kí tự gạch ngang Mã cấp bậc và không chọn HHHV và ấn Hủy");
		    
		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ tư trong sheet
		    XSSFRow row = sheet.getRow(3);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);
		    // Click vào dropdown HHHV
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);
		    // Click lại vào dropdown HHHV để đóng dropdown
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);
		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);
		    // Click vào nút Hủy
		    MainPage.ClickCloseButton();
		    // In ra một dòng để phân biệt giữa các testcase khi chạy
		    System.out.println("===============");
		}
		@Test(priority = 19)
		public void Action19() throws IOException, InterruptedException {
		    // In ra tên của testcase
		    System.out.println("Testcase 19: Chức năng thêm Cấp Bậc với bỏ trống Mã cấp bậc và ấn Hủy ");
		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);
		    // Click vào dropdown HHHV
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);
		    // Random một giá trị từ 1 đến 34 để chọn từ dropdown
		    Random random = new Random();
		    int randomValue = random.nextInt(34)+1;
		    String xpathPC = "/html/body/div[3]/div[2]/form/div[1]/div/span[2]/span/span[2]/ul/li["+randomValue+"]";
		    WebElement itemElement = driver.findElement(By.xpath(xpathPC));
		    // Click vào một phần tử trong dropdown
		    itemElement.click();
		    // Click vào nút Hủy
		    MainPage.ClickCloseButton();
		    // In ra một dòng để phân biệt giữa các testcase khi chạy
		    System.out.println("===============");
		}

		@Test(priority = 20)
		public void Action20() throws IOException, InterruptedException {
		    // In ra tên của testcase
		    System.out.println("Testcase 20: Chức năng thêm Cấp Bậc với bỏ trống Mã cấp bậc và không chọn HHHV và ấn Hủy");
		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);
		    // Click vào dropdown HHHV
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);
		    // Click lại vào dropdown HHHV để đóng dropdown
		    driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[1]/div/span[1]/span[1]/span")).click();
		    Thread.sleep(2000);
		    // Click vào nút Hủy
		    MainPage.ClickCloseButton();
		    // In ra một dòng để phân biệt giữa các testcase khi chạy
		    System.out.println("===============");
		}

		@Test(priority = 21)
		public void Action21() throws IOException, InterruptedException {
		    // In ra tên của testcase
		    System.out.println("Testcase 21: Chức năng thêm Cấp Bậc bị trùng dữ liệu");
		    // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		    FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Lấy dữ liệu từ ô đầu tiên của dòng thứ tư trong sheet
		    XSSFRow row = sheet.getRow(3);
		    String id = row.getCell(0).getStringCellValue();

		    // Khởi tạo đối tượng của trang ThemCapBac_Page
		    ThemCapBac_Page MainPage = new ThemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Click vào menu Cấp Bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Click vào nút thêm mới
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		    Thread.sleep(2000);
		    // Lấy số lượng phần tử trong dropdown HHHV
		    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"academic_degree_id\"]/option"));
		    int numberOfElements = elements.size();
		    // Random một số để chọn từ dropdown
		    Random radom = new Random();
		    int rant = radom.nextInt(numberOfElements);
		    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]"));
		    Select select = new Select(dropdown);
		    select.selectByIndex(rant);
		    Thread.sleep(2000);
		    // Nhập ID từ file Excel vào ô ID trên trang web
		    WebElement ID = driver.findElement(By.xpath("//*[@id=\"id\"]"));
		    ID.sendKeys(id);
		    // Click vào nút Lưu
		    WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]"));
		    clickElement.click();
		    Thread.sleep(2000);

		    Thread.sleep(2000);
		    try {
		        // Nếu có thông báo lỗi xuất hiện thì in ra
		        driver.findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText();
		        WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]"));
		        System.out.println("Click Lưu không thành công, thông báo nhận được: "+errorElement2.getText());
		    }

		    // Nếu không có thông báo lỗi xuất hiện thì in ra là Lưu thành công
		    catch (WebDriverException e) {
		        System.out.println("Kết quả thực tế: Lưu thành công");
		    }

		    // Chuỗi kỳ vọng thông báo lỗi
		    String expected = "Mã cấp bậc này đã tồn tại!";
		    System.out.println("Kết quả mong đợi: " + expected);
		    // In ra kết quả mong đợi của thông báo lỗi
		    Thread.sleep(3000);
		    // Click vào nút OK trên thông báo lỗi
		    driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
		    // In ra một dòng để phân biệt giữa các testcase khi chạy
		    System.out.println("===============");
		}

		@AfterTest
		public void Close() {
			driver.close();
		}
}
