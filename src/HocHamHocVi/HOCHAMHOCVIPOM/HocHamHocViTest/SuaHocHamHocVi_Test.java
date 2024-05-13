package HocHamHocViTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HocHamHocVi.SuaDoiCapBac_Page;
import HocHamHocVi.SuaHocHamHocVi_Page;
import PageSetup.Setup;

public class SuaHocHamHocVi_Test {
	 static WebDriver driver;

		@BeforeSuite
		public void Main() throws IOException, InterruptedException {
			Setup setup = new Setup();
			driver = setup.setup();
			Thread.sleep(3000);
		}
		@BeforeTest
		public void Setup2() throws InterruptedException {
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);
			MainPage.Menu();
			Thread.sleep(2000);
		}
		@Test
		public void Action1() throws InterruptedException, IOException {
		    // In ra mô tả về test case
		    System.out.println("Testcase 1: Sửa học hàm học vị với khoảng cách tại Tên HHHV");

		    // Tạo một đối tượng trang (page object)
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);
		    // Truy cập vào menu học hàm học vị
		    MainPage.HHHVMenu();

		    // Đọc dữ liệu thử nghiệm từ một file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    XSSFRow row = sheet.getRow(0);
		    String NAME = row.getCell(0).getStringCellValue();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Tìm và nhập tên vào ô tìm kiếm
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);

		    // Nhấn vào nút sửa cho mục đầu tiên trong kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Đọc tên mới từ file Excel
		    XSSFRow row2 = sheet.getRow(0);
		    String NAME2 = row2.getCell(1).getStringCellValue();

		    // Tìm ô nhập tên, xóa nội dung và nhập tên mới
		    WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		    inpElement.clear();
		    inpElement.sendKeys(NAME2);

		    // Chờ 4 giây
		    Thread.sleep(4000);

		    // Gọi phương thức ClickSaveButton từ trang để lưu các thay đổi
		    MainPage.ClickSaveButton();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Định nghĩa thông báo lỗi dự kiến
		    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!"; // Chuỗi kỳ vọng thông báo lỗi
		    // In ra thông báo lỗi dự kiến
		    System.out.println("Kết quả mong đợi: " + expected);
		    System.out.println("=======");
		}

		@Test(priority = 2)
		public void Actions2() throws IOException, InterruptedException {
		    System.out.println("Testcase 2: Sửa học hàm học vị với kí tự đặc biệt tại Tên HHHV");

		    // Tạo một đối tượng trang
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);
		    // Truy cập vào menu học hàm học vị
		    MainPage.HHHVMenu();

		    // Đọc dữ liệu thử nghiệm từ một file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    XSSFRow row = sheet.getRow(1);
		    String NAME = row.getCell(0).getStringCellValue();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Tìm và nhập tên vào ô tìm kiếm
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);

		    // Nhấn vào nút sửa cho mục đầu tiên trong kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Đọc tên mới từ file Excel
		    XSSFRow row2 = sheet.getRow(1);
		    String NAME2 = row2.getCell(1).getStringCellValue();

		    // Tìm ô nhập tên, xóa nội dung và nhập tên mới
		    WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		    inpElement.clear();
		    inpElement.sendKeys(NAME2);

		    // Chờ 4 giây
		    Thread.sleep(4000);

		    // Gọi phương thức ClickSaveButton từ trang để lưu các thay đổi
		    MainPage.ClickSaveButton();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Định nghĩa thông báo lỗi dự kiến
		    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!"; // Chuỗi kỳ vọng thông báo lỗi
		    // In ra thông báo lỗi dự kiến
		    System.out.println("Kết quả mong đợi: " + expected);
		    System.out.println("=======");
		}

		@Test(priority = 3)
		public void Actions3() throws IOException, InterruptedException {
		    System.out.println("Testcase 3: Sửa học hàm học vị với số tại Tên HHHV");

		    // Tạo một đối tượng trang
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu thử nghiệm từ một file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    XSSFRow row = sheet.getRow(2);
		    String NAME = row.getCell(0).getStringCellValue();

		    // Truy cập vào menu học hàm học vị
		    MainPage.HHHVMenu();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Tìm và nhập tên vào ô tìm kiếm
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Nhấn vào nút sửa cho mục đầu tiên trong kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Đọc tên mới từ file Excel
		    XSSFRow row2 = sheet.getRow(2);
		    String NAME2 = row2.getCell(1).getStringCellValue();

		    // Tìm ô nhập tên, xóa nội dung và nhập tên mới
		    WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		    inpElement.clear();
		    inpElement.sendKeys(NAME2);

		    // Chờ 4 giây
		    Thread.sleep(4000);

		    // Gọi phương thức ClickSaveButton từ trang để lưu các thay đổi
		    MainPage.ClickSaveButton();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Định nghĩa thông báo lỗi dự kiến
		    String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!"; // Chuỗi kỳ vọng thông báo lỗi
		    // In ra thông báo lỗi dự kiến
		    System.out.println("Kết quả mong đợi: " + expected);
		    System.out.println("=======");
		}
		@Test(priority = 4)
		public void Actions4() throws IOException, InterruptedException {
		    System.out.println("Testcase 4: Sửa học hàm học vị với bỏ trống tại Tên HHHV");

		    // Tạo một đối tượng trang
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu thử nghiệm từ một file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    XSSFRow row = sheet.getRow(3);
		    String NAME = row.getCell(0).getStringCellValue();

		    // Truy cập vào menu học hàm học vị
		    MainPage.HHHVMenu();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Tìm và nhập tên vào ô tìm kiếm
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Nhấn vào nút sửa cho mục đầu tiên trong kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Tìm ô nhập tên, xóa nội dung
		    WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		    inpElement.clear();

		    // Chờ 4 giây
		    Thread.sleep(4000);

		    // Gọi phương thức ClickSaveButton từ trang để lưu các thay đổi
		    WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
		    saveButton.click();
		    try {
		        // Nếu có, in ra thông báo "Lưu không thành công"
		        driver.findElement(By.xpath("//*[@id=\"name-error\"]")).getText();
		        System.out.println("Lưu không thành công");
		    } catch (Exception e) {
		        // Nếu không, in ra thông báo "Lưu thành công"
		        System.out.println("Lưu thành công");
		    }	    

		    // Định nghĩa thông báo lỗi dự kiến
		    String expected = "Bạn chưa nhập tên học hàm, học vị"; // Chuỗi kỳ vọng thông báo lỗi
		    // In ra thông báo lỗi dự kiến
		    System.out.println("Kết quả mong đợi: " + expected);

		    // Tìm và in ra thông báo lỗi thực tế từ giao diện web
		    WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"name-error\"]"));
		    System.out.println("Kết quả thực tế: " + errorElement.getText());

		    System.out.println("=======");
		}

		@Test(priority = 5)
		public void Actions5() throws IOException, InterruptedException {
		    System.out.println("Testcase 5: Sửa học hàm học vị với số âm tại Thứ Tự");

		    // Tạo một đối tượng trang
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu thử nghiệm từ một file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    XSSFRow row = sheet.getRow(0);
		    String NAME = row.getCell(0).getStringCellValue();

		    // Truy cập vào menu học hàm học vị
		    MainPage.HHHVMenu();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Tìm và nhập tên vào ô tìm kiếm
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Nhấn vào nút sửa cho mục đầu tiên trong kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();

		    // Chờ 4 giây
		    Thread.sleep(4000);

		    // Đọc giá trị từ file Excel để nhập vào ô thứ tự
		    XSSFRow row3 = sheet.getRow(0);
		    String NAME3 = row3.getCell(2).getStringCellValue();

		    // Tìm và nhập giá trị thứ tự
		    WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
		    inpElement3.clear();
		    Thread.sleep(2000);
		    inpElement3.sendKeys(NAME3);

		    // Chờ 4 giây
		    Thread.sleep(4000);

		    // Nhấn nút Lưu
		    WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
		    saveButton.click();
		    try {
		        // Nếu có, in ra thông báo "Lưu không thành công"
		        driver.findElement(By.xpath("//*[@id=\"level-error\"]")).getText();
		        System.out.println("Lưu không thành công");
		    } catch (Exception e) {
		        // Nếu không, in ra thông báo "Lưu thành công"
		        System.out.println("Lưu thành công");
		    }	    

		    // Chờ 3 giây
		    Thread.sleep(3000);

		    // Định nghĩa thông báo lỗi dự kiến
		    String expected2 = "Vui lòng nhập lớn hơn hoặc bằng 1"; // Chuỗi kỳ vọng thông báo lỗi
		    // In ra thông báo lỗi dự kiến
		    System.out.println("Kết quả mong đợi: " + expected2);

		    // Tìm và in ra thông báo lỗi thực tế từ giao diện web
		    WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
		    System.out.println("Kết quả thực tế: " + errorElement2.getText());

		    System.out.println("=======");
		    // Chờ 3 giây
		    Thread.sleep(3000);
		}
		@Test(priority = 6)
		public void Actions6() throws IOException, InterruptedException {
		    System.out.println("Testcase 6: Sửa học hàm học vị với số lớn hơn 100 tại Thứ Tự");

		    // Tạo một đối tượng trang
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu thử nghiệm từ một file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    XSSFRow row = sheet.getRow(0);
		    String NAME = row.getCell(0).getStringCellValue();

		    // Truy cập vào menu học hàm học vị
		    MainPage.HHHVMenu();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Tìm và nhập tên vào ô tìm kiếm
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Nhấn vào nút sửa cho mục đầu tiên trong kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();

		    // Chờ 4 giây
		    Thread.sleep(4000);

		    // Đọc giá trị từ file Excel để nhập vào ô thứ tự
		    XSSFRow row3 = sheet.getRow(1);
		    String NAME3 = row3.getCell(2).getStringCellValue();

		    // Tìm và nhập giá trị thứ tự
		    WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
		    inpElement3.clear();
		    Thread.sleep(2000);
		    inpElement3.sendKeys(NAME3);

		    // Chờ 4 giây
		    Thread.sleep(4000);

		    // Nhấn nút Lưu
		    WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
		    saveButton.click();
		    try {
		        // Nếu có, in ra thông báo "Lưu không thành công"
		        driver.findElement(By.xpath("//*[@id=\"level-error\"]")).getText();
		        System.out.println("Lưu không thành công");
		    } catch (Exception e) {
		        // Nếu không, in ra thông báo "Lưu thành công"
		        System.out.println("Lưu thành công");
		    }	    

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Tìm và in ra thông báo lỗi thực tế từ giao diện web
		    WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
		    // Định nghĩa thông báo lỗi dự kiến
		    String expected2 = "Vui lòng nhập nhỏ hơn hoặc bằng 100"; // Chuỗi kỳ vọng thông báo lỗi

		    // In ra thông báo lỗi dự kiến và thực tế
		    System.out.println("Kết quả mong đợi: " + expected2);
		    System.out.println("Kết quả thực tế: " + errorElement2.getText());

		    System.out.println("=======");
		    // Chờ 3 giây
		    Thread.sleep(3000);
		}
		@Test(priority = 7)
		public void Actions7() throws IOException, InterruptedException {
		    System.out.println("Testcase 7: Sửa học hàm học vị với kí tự đặc biệt tại Thứ Tự");

		    // Tạo một đối tượng trang
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu thử nghiệm từ một file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    XSSFRow row = sheet.getRow(1);
		    String NAME = row.getCell(0).getStringCellValue();

		    // Truy cập vào menu học hàm học vị
		    MainPage.HHHVMenu();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Tìm và nhập tên vào ô tìm kiếm
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Nhấn vào nút sửa cho mục đầu tiên trong kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();

		    // Chờ 4 giây
		    Thread.sleep(4000);

		    // Đọc giá trị từ file Excel để nhập vào ô thứ tự
		    XSSFRow row3 = sheet.getRow(2);
		    String NAME3 = row3.getCell(2).getStringCellValue();

		    // Tìm và nhập giá trị thứ tự
		    WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
		    inpElement3.clear();
		    Thread.sleep(2000);
		    inpElement3.sendKeys(NAME3);

		    // Chờ 4 giây
		    Thread.sleep(4000);

		    // Nhấn nút Lưu
		    WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
		    saveButton.click();
		    try {
		        // Nếu có, in ra thông báo "Lưu không thành công"
		        driver.findElement(By.xpath("//*[@id=\"level-error\"]")).getText();
		        System.out.println("Lưu không thành công");
		    } catch (Exception e) {
		        // Nếu không, in ra thông báo "Lưu thành công"
		        System.out.println("Lưu thành công");
		    }	    
		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Tìm và in ra thông báo lỗi thực tế từ giao diện web
		    WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
		    String expected2 = "Vui lòng nhập lớn hơn hoặc bằng 1"; // Chuỗi kỳ vọng thông báo lỗi

		    // In ra thông báo lỗi dự kiến và thực tế
		    System.out.println("Kết quả mong đợi: " + expected2);
		    System.out.println("Kết quả thực tế: " + errorElement2.getText());
		    System.out.println("=======");
		    // Chờ 3 giây
		    Thread.sleep(3000);
		}

		// Khởi tạo một testcase để kiểm tra việc sửa học hàm, học vị với trường "Thứ tự" bị bỏ trống
		@Test(priority = 8)
		public void Actions8() throws IOException, InterruptedException {
		    System.out.println("Testcase 8 :Sửa học hàm học vị với bỏ trống tại Thứ Tự ");
		    
		    // Khởi tạo trang SuaHocHamHocVi_Page
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu từ file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    
		    // Lấy giá trị từ dòng thứ 2 của cột đầu tiên trong file Excel
		    XSSFRow row = sheet.getRow(1);
		    String NAME = row.getCell(0).getStringCellValue();
		    
		    // Mở menu học hàm, học vị
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào ô tìm kiếm trên giao diện web
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);
		    
		    // Click vào nút sửa đầu tiên trong danh sách kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
		    Thread.sleep(4000);
		    
		    // Xóa dữ liệu trong trường "Thứ tự"
		    WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
		    inpElement3.clear();
		    Thread.sleep(2000);
		    
		    // Click vào nút lưu
		    WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
		    saveButton.click();
		    
		    // Tìm và lưu phần tử hiển thị thông báo lỗi trên giao diện web
		    WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
		    
		    // Kiểm tra xem thông báo lỗi có hiển thị hay không
		    try {
		        // Nếu có, in ra thông báo "Lưu không thành công"
		        driver.findElement(By.xpath("//*[@id=\"level-error\"]")).getText();
		        System.out.println("Lưu không thành công");
		    } catch (Exception e) {
		        // Nếu không, in ra thông báo "Lưu thành công"
		        System.out.println("Lưu thành công");
		    }
		    
		    String expected2 = "Bạn chưa nhập thứ tự"; // Chuỗi kỳ vọng thông báo lỗi
		    
		    // In ra kết quả mong đợi của thông báo lỗi
		    System.out.println("Kết quả mong đợi: " + expected2);
		    
		    // In ra kết quả thực tế của thông báo lỗi trên giao diện web
		    System.out.println("Kết quả thực tế: " + errorElement2.getText());
		    System.out.println("=======");
		    Thread.sleep(3000);
		}
		@Test(priority = 9)
		public void Actions9() throws IOException, InterruptedException {
		    System.out.println("Testcase 9: Sửa học hàm học vị với khoảng cách tại Tên HHHV và ấn Hủy");
		    // Tạo một đối tượng trang
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu thử nghiệm từ một file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    XSSFRow row = sheet.getRow(0);
		    String NAME = row.getCell(0).getStringCellValue();

		    // Truy cập vào menu học hàm học vị
		    MainPage.HHHVMenu();

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Tìm và nhập tên vào ô tìm kiếm
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);

		    // Chờ 2 giây
		    Thread.sleep(2000);

		    // Nhấn vào nút sửa cho mục đầu tiên trong kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();

		    // Chờ 2000ms
		    Thread.sleep(2000);

		    // Đọc giá trị từ file Excel để nhập vào ô tên
		    XSSFRow row2 = sheet.getRow(0);
		    String NAME2 = row2.getCell(1).getStringCellValue();

		    // Tìm và nhập giá trị vào ô tên
		    WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		    inpElement.clear();
		    Thread.sleep(2000);
		    inpElement.sendKeys(NAME2);

		    // Chờ 4000ms
		    Thread.sleep(4000);

		    // Thực hiện click vào nút Hủy
		    MainPage.ClickCloseButton();

		    System.out.println("=======");
		}
		// Khởi tạo một testcase để kiểm tra việc sửa học hàm, học vị với trường "Tên HHHV" chứa kí tự đặc biệt và sau đó nhấn nút "Hủy"
		@Test(priority = 10)
		public void Actions10() throws IOException, InterruptedException {
		    System.out.println("Testcase 10 :Sửa học hàm học vị với kí tự đặc biệt tại Tên HHHV và ấn Hủy");
		    
		    // Khởi tạo trang SuaHocHamHocVi_Page
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu từ file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    
		    // Lấy giá trị từ dòng thứ 2 của cột đầu tiên trong file Excel
		    XSSFRow row = sheet.getRow(1);
		    String NAME = row.getCell(0).getStringCellValue();
		    
		    // Mở menu học hàm, học vị
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào ô tìm kiếm trên giao diện web
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);
		    
		    // Click vào nút sửa đầu tiên trong danh sách kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
		    Thread.sleep(2000);
		    
		    // Lấy giá trị từ dòng thứ 2 của cột thứ 2 trong file Excel
		    XSSFRow row2 = sheet.getRow(1);
		    String NAME2 = row2.getCell(1).getStringCellValue();
		    
		    // Xóa dữ liệu trong trường "Tên HHHV"
		    WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		    inpElement.clear();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào trường "Tên HHHV"
		    inpElement.sendKeys(NAME2);
		    Thread.sleep(4000);
		    
		    // Click vào nút "Hủy"
		    MainPage.ClickCloseButton();
		    System.out.println("=======");
		}

		// Khởi tạo một testcase để kiểm tra việc sửa học hàm, học vị với trường "Tên HHHV" chứa số và sau đó nhấn nút "Hủy"
		@Test(priority = 11)
		public void Actions11() throws IOException, InterruptedException {
		    System.out.println("Testcase 11 :Sửa học hàm học vị với số tại Tên HHHV và ấn Hủy");
		    
		    // Khởi tạo trang SuaHocHamHocVi_Page
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu từ file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    
		    // Lấy giá trị từ dòng thứ 3 của cột đầu tiên trong file Excel
		    XSSFRow row = sheet.getRow(2);
		    String NAME = row.getCell(0).getStringCellValue();
		    
		    // Mở menu học hàm, học vị
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào ô tìm kiếm trên giao diện web
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);
		    Thread.sleep(2000);
		    
		    // Click vào nút sửa đầu tiên trong danh sách kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
		    Thread.sleep(2000);
		    
		    // Lấy giá trị từ dòng thứ 3 của cột thứ 2 trong file Excel
		    XSSFRow row2 = sheet.getRow(2);
		    String NAME2 = row2.getCell(1).getStringCellValue();
		    
		    // Xóa dữ liệu trong trường "Tên HHHV"
		    WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		    inpElement.clear();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào trường "Tên HHHV"
		    inpElement.sendKeys(NAME2);
		    Thread.sleep(4000);
		    
		    // Click vào nút "Hủy"
		    MainPage.ClickCloseButton();
		    System.out.println("=======");
		}

		// Khởi tạo một testcase để kiểm tra việc sửa học hàm, học vị với trường "Tên HHHV" bị bỏ trống và sau đó nhấn nút "Hủy"
		@Test(priority = 12)
		public void Actions12() throws IOException, InterruptedException {
		    System.out.println("Testcase 12 :Sửa học hàm học vị với bỏ trống tại Tên HHHV và ấn Hủy");
		    
		    // Khởi tạo trang SuaHocHamHocVi_Page
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu từ file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    
		    // Lấy giá trị từ dòng thứ 4 của cột đầu tiên trong file Excel
		    XSSFRow row = sheet.getRow(3);
		    String NAME = row.getCell(0).getStringCellValue();
		    
		    // Mở menu học hàm, học vị
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào ô tìm kiếm trên giao diện web
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);
		    
		    // Click vào nút sửa đầu tiên trong danh sách kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
		    Thread.sleep(2000);
		    
		    // Xóa dữ liệu trong trường "Tên HHHV"
		    WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		    inpElement.clear();
		    Thread.sleep(4000);
		    
		    // Click vào nút "Hủy"
		    MainPage.ClickCloseButton();
		    System.out.println("=======");
		}
		// Khởi tạo một testcase để kiểm tra việc sửa học hàm, học vị với số âm tại trường "Thứ Tự" và sau đó nhấn nút "Hủy"
		@Test(priority = 13)
		public void Actions13() throws IOException, InterruptedException {
		    System.out.println("Testcase 13 :Sửa học hàm học vị với số âm tại Thứ Tự và ấn Hủy");
		    
		    // Khởi tạo trang SuaHocHamHocVi_Page
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu từ file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    
		    // Lấy giá trị từ dòng đầu tiên của cột đầu tiên trong file Excel
		    XSSFRow row = sheet.getRow(0);
		    String NAME = row.getCell(0).getStringCellValue();
		    
		    // Mở menu học hàm, học vị
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào ô tìm kiếm trên giao diện web
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);
		    
		    // Click vào nút sửa đầu tiên trong danh sách kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
		    Thread.sleep(4000);
		    
		    // Lấy giá trị từ dòng đầu tiên của cột thứ 3 trong file Excel
		    XSSFRow row3 = sheet.getRow(0);
		    String NAME3 = row3.getCell(2).getStringCellValue();
		    
		    // Xóa dữ liệu trong trường "Thứ Tự"
		    WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
		    inpElement3.clear();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào trường "Thứ Tự"
		    inpElement3.sendKeys(NAME3);
		    Thread.sleep(4000);
		    
		    // Click vào nút "Hủy"
		    MainPage.ClickCloseButton();
		    System.out.println("=======");
		}

		// Khởi tạo một testcase để kiểm tra việc sửa học hàm, học vị với số lớn hơn 100 tại trường "Thứ Tự" và sau đó nhấn nút "Hủy"
		@Test(priority = 14)
		public void Actions14() throws IOException, InterruptedException {
		    System.out.println("Testcase 14 :Sửa học hàm học vị với số lớn hơn 100 tại Thứ Tự và ấn Hủy");
		    
		    // Khởi tạo trang SuaHocHamHocVi_Page
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu từ file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    
		    // Lấy giá trị từ dòng đầu tiên của cột đầu tiên trong file Excel
		    XSSFRow row = sheet.getRow(0);
		    String NAME = row.getCell(0).getStringCellValue();
		    
		    // Mở menu học hàm, học vị
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào ô tìm kiếm trên giao diện web
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);
		    
		    // Click vào nút sửa đầu tiên trong danh sách kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
		    Thread.sleep(4000);
		    
		    // Lấy giá trị từ dòng thứ 2 của cột thứ 3 trong file Excel
		    XSSFRow row3 = sheet.getRow(1);
		    String NAME3 = row3.getCell(2).getStringCellValue();
		    
		    // Xóa dữ liệu trong trường "Thứ Tự"
		    WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
		    inpElement3.clear();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào trường "Thứ Tự"
		    inpElement3.sendKeys(NAME3);
		    Thread.sleep(4000);
		    
		    // Click vào nút "Hủy"
		    MainPage.ClickCloseButton();
		    System.out.println("=======");
		}

		// Khởi tạo một testcase để kiểm tra việc sửa học hàm, học vị với kí tự đặc biệt tại trường "Thứ Tự" và sau đó nhấn nút "Hủy"
		@Test(priority = 15)
		public void Actions15() throws IOException, InterruptedException {
		    System.out.println("Testcase 15 :Sửa học hàm học vị với kí tự đặc biệt tại Thứ Tự và ấn Hủy");
		    
		    // Khởi tạo trang SuaHocHamHocVi_Page
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu từ file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    
		    // Lấy giá trị từ dòng thứ 2 của cột đầu tiên trong file Excel
		    XSSFRow row = sheet.getRow(1);
		    String NAME = row.getCell(0).getStringCellValue();
		    
		    // Mở menu học hàm, học vị
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào ô tìm kiếm trên giao diện web
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);
		    
		    // Click vào nút sửa đầu tiên trong danh sách kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();

		    Thread.sleep(4000);
		    
		    // Lấy giá trị từ dòng thứ 3 của cột thứ 3 trong file Excel
		    XSSFRow row3 = sheet.getRow(2);
		    String NAME3 = row3.getCell(2).getStringCellValue();
		    
		    // Xóa dữ liệu trong trường "Thứ Tự"
		    WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
		    inpElement3.clear();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào trường "Thứ Tự"
		    inpElement3.sendKeys(NAME3);
		    Thread.sleep(4000);
		    
		    // Click vào nút "Hủy"
		    MainPage.ClickCloseButton();
		    System.out.println("=======");
		}

		// Khởi tạo một testcase để kiểm tra việc sửa học hàm, học vị với bỏ trống trường "Thứ Tự" và sau đó nhấn nút "Hủy"
		@Test(priority = 16)
		public void Actions16() throws IOException, InterruptedException {
		    System.out.println("Testcase 16 :Sửa học hàm học vị với bỏ trống tại Thứ Tự và ấn Hủy");
		    
		    // Khởi tạo trang SuaHocHamHocVi_Page
		    SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

		    // Đọc dữ liệu từ file Excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    
		    // Lấy giá trị từ dòng đầu tiên của cột đầu tiên trong file Excel
		    XSSFRow row = sheet.getRow(1);
		    String NAME = row.getCell(0).getStringCellValue();
		    
		    // Mở menu học hàm, học vị
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    
		    // Nhập dữ liệu từ file Excel vào ô tìm kiếm trên giao diện web
		    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		    inputElement.sendKeys(NAME);
		    
		    // Click vào nút sửa đầu tiên trong danh sách kết quả tìm kiếm
		    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
		    Thread.sleep(4000);
		    
		    // Xóa dữ liệu trong trường "Thứ Tự"
		    WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
		    inpElement3.clear();
		    Thread.sleep(2000);
		    
		    // Click vào nút "Hủy"
		    MainPage.ClickCloseButton();
		    System.out.println("=======");
		}
		@AfterTest
		public void Close() {
			driver.close();
		}
}
