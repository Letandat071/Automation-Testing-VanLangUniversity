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

import HocHamHocVi.TimKiemCapBac_Page;
import PageSetup.Setup;

public class TimKiemCapBac_Test {
	   static WebDriver driver;
		@BeforeSuite
		public void Main() throws IOException, InterruptedException {
			Setup setup = new Setup();
			driver = setup.setup();
			Thread.sleep(3000);
		}
		@BeforeTest
		public void Setup2() throws InterruptedException {
			TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
			MainPage.Menu();
			Thread.sleep(2000);
		}
		@Test
		public void Action1() throws InterruptedException, IOException {
		    // Khởi tạo một đối tượng TimKiemCapBac_Page
		    TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    // Dừng 2 giây để chờ load
		    Thread.sleep(2000);
		    // Click vào mục cấp bậc
		    MainPage.CapBac();
		    // Dừng 2 giây để chờ load
		    Thread.sleep(2000);
		    // Chọn hiển thị 25 dữ liệu
		    MainPage.Data("25");
		    // Dừng 2 giây để chờ load
		    Thread.sleep(2000);

		    // Mở file Excel chứa dữ liệu tìm kiếm
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // StringBuilder để lưu các từ khóa tìm kiếm thành công và thất bại
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong Excel để thực hiện tìm kiếm
		    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		        XSSFRow row = sheet.getRow(i);
		        // Lấy từ khóa tìm kiếm từ cột đầu tiên của dòng
		        String id = row.getCell(0).getStringCellValue();

		        // Dừng 0.5 giây
		        Thread.sleep(500);
		        // Tìm ô input để nhập từ khóa tìm kiếm và nhập từ khóa
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        // Dừng 1 giây để đợi kết quả tìm kiếm
		        Thread.sleep(1000);
		        // Tìm dữ liệu trong bảng để kiểm tra kết quả tìm kiếm
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		        System.out.println(dataTable.getText());
		        // Kiểm tra xem có kết quả tìm kiếm hay không
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa nội dung trong ô input để chuẩn bị cho tìm kiếm tiếp theo
		        searchbox.clear();
		    }
		    // In kết quả tìm kiếm
		    System.out.println("Testcase 1:Tìm kiếm với Hiển thị 25 dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}

		@Test
		public void Action2() throws InterruptedException, IOException {
		    // Khởi tạo một đối tượng TimKiemCapBac_Page
		    TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    // Dừng 2 giây để chờ load
		    Thread.sleep(2000);
		    // Click vào mục cấp bậc
		    MainPage.CapBac();
		    // Dừng 2 giây để chờ load
		    Thread.sleep(2000);
		    // Chọn hiển thị 50 dữ liệu
		    MainPage.Data("50");
		    // Dừng 2 giây để chờ load
		    Thread.sleep(2000);

		    // Mở file Excel chứa dữ liệu tìm kiếm
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // StringBuilder để lưu các từ khóa tìm kiếm thành công và thất bại
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong Excel để thực hiện tìm kiếm
		    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		        XSSFRow row = sheet.getRow(i);
		        // Lấy từ khóa tìm kiếm từ cột đầu tiên của dòng
		        String id = row.getCell(0).getStringCellValue();

		        // Dừng 0.5 giây
		        Thread.sleep(500);
		        // Tìm ô input để nhập từ khóa tìm kiếm và nhập từ khóa
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        // Dừng 1 giây để đợi kết quả tìm kiếm
		        Thread.sleep(1000);
		        // Tìm dữ liệu trong bảng để kiểm tra kết quả tìm kiếm
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		        System.out.println(dataTable.getText());
		        // Kiểm tra xem có kết quả tìm kiếm hay không
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa nội dung trong ô input để chuẩn bị cho tìm kiếm tiếp theo
		        searchbox.clear();
		    }
		    // In kết quả tìm kiếm
		    System.out.println("Testcase 2:Tìm kiếm với Hiển thị 50 dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}
		@Test
		public void Action3() throws InterruptedException, IOException {
		    // Khởi tạo một đối tượng TimKiemCapBac_Page
		    TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
		    // Click vào menu HHHV
		    MainPage.HHHVMenu();
		    // Dừng 2 giây để chờ load
		    Thread.sleep(2000);
		    // Click vào mục cấp bậc
		    MainPage.CapBac();
		    // Dừng 2 giây để chờ load
		    Thread.sleep(2000);
		    // Chọn hiển thị tất cả dữ liệu
		    MainPage.Data("-1");
		    // Dừng 2 giây để chờ load
		    Thread.sleep(2000);

		    // Mở file Excel chứa dữ liệu tìm kiếm
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // StringBuilder để lưu các từ khóa tìm kiếm thành công và thất bại
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong Excel để thực hiện tìm kiếm
		    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		        XSSFRow row = sheet.getRow(i);
		        // Lấy từ khóa tìm kiếm từ cột đầu tiên của dòng
		        String id = row.getCell(0).getStringCellValue();

		        // Dừng 0.5 giây
		        Thread.sleep(500);
		        // Tìm ô input để nhập từ khóa tìm kiếm và nhập từ khóa
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        // Dừng 1 giây để đợi kết quả tìm kiếm
		        Thread.sleep(1000);
		        // Tìm dữ liệu trong bảng để kiểm tra kết quả tìm kiếm
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		        System.out.println(dataTable.getText());
		        // Kiểm tra xem có kết quả tìm kiếm hay không
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa nội dung trong ô input để chuẩn bị cho tìm kiếm tiếp theo
		        searchbox.clear();
		    }
		    // In kết quả tìm kiếm
		    System.out.println("Testcase 3:Tìm kiếm với Hiển thị tất cả dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}




		@Test
		public void Action4() throws InterruptedException, IOException {
		    // Khởi tạo trang chứa các phương thức thực hiện tìm kiếm
		    TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
		    // Mở menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Chọn chức năng cấp bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Chọn hiển thị 25 dữ liệu
		    MainPage.Data("25");
		    Thread.sleep(2000);

		    // Đọc dữ liệu từ file excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Khởi tạo StringBuilder để lưu kết quả tìm kiếm
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong file excel để tìm kiếm
		    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		        XSSFRow row = sheet.getRow(i);
		        String id = row.getCell(1).getStringCellValue();

		        // Chờ 0.5 giây
		        Thread.sleep(500);
		        // Tìm ô tìm kiếm và nhập từ khóa tìm kiếm
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        Thread.sleep(1000);
		        // Kiểm tra kết quả tìm kiếm
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		        System.out.println(dataTable.getText());
		        // Kiểm tra kết quả và lưu vào StringBuilder tương ứng
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa từ khóa tìm kiếm
		        searchbox.clear();
		    }
		    // In kết quả tìm kiếm
		    System.out.println("Testcase 4:Tìm kiếm với kí tự đặc biệt và Hiển thị 25 dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}

		@Test
		public void Action5() throws InterruptedException, IOException {
		    // Khởi tạo trang chứa các phương thức thực hiện tìm kiếm
		    TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
		    // Mở menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Chọn chức năng cấp bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Chọn hiển thị 50 dữ liệu
		    MainPage.Data("50");
		    Thread.sleep(2000);

		    // Đọc dữ liệu từ file excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Khởi tạo StringBuilder để lưu kết quả tìm kiếm
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong file excel để tìm kiếm
		    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		        XSSFRow row = sheet.getRow(i);
		        String id = row.getCell(1).getStringCellValue();

		        // Chờ 0.5 giây
		        Thread.sleep(500);
		        // Tìm ô tìm kiếm và nhập từ khóa tìm kiếm
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        Thread.sleep(1000);
		        // Kiểm tra kết quả tìm kiếm
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		        System.out.println(dataTable.getText());
		        // Kiểm tra kết quả và lưu vào StringBuilder tương ứng
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa từ khóa tìm kiếm
		        searchbox.clear();
		    }
		    // In kết quả tìm kiếm
		    System.out.println("Testcase 5:Tìm kiếm với kí tự đặc biệt và Hiển thị 50 dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}

		@Test
		public void Action6() throws InterruptedException, IOException {
		    // Khởi tạo trang chứa các phương thức thực hiện tìm kiếm
		    TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
		    // Mở menu HHHV
		    MainPage.HHHVMenu();
		    Thread.sleep(2000);
		    // Chọn chức năng cấp bậc
		    MainPage.CapBac();
		    Thread.sleep(2000);
		    // Chọn hiển thị tất cả dữ liệu
		    MainPage.Data("-1");
		    Thread.sleep(2000);
		    // Đọc dữ liệu từ file excel
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Khởi tạo StringBuilder để lưu kết quả tìm kiếm
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong file excel để tìm kiếm
		    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		        XSSFRow row = sheet.getRow(i);
		        String id = row.getCell(1).getStringCellValue();

		        // Chờ 0.5 giây
		        Thread.sleep(500);
		        // Tìm ô tìm kiếm và nhập từ khóa tìm kiếm
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        Thread.sleep(1000);
		        // Kiểm tra kết quả tìm kiếm
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		        System.out.println(dataTable.getText());
		        // Kiểm tra kết quả và lưu vào StringBuilder tương ứng
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa từ khóa tìm kiếm
		        searchbox.clear();
		    }
		    // In kết quả tìm kiếm
		    System.out.println("Testcase 6:Tìm kiếm với kí tự đặc biệt và Hiển thị tất cả dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}

		@AfterTest
		public void Close() {
			driver.close();
		}
}
