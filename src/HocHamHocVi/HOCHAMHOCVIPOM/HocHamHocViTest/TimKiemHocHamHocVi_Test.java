package HocHamHocViTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HocHamHocVi.SuaHocHamHocVi_Page;
import HocHamHocVi.TimKiemHocHamHocVi_Page;
import PageSetup.Setup;

public class TimKiemHocHamHocVi_Test {
	 static WebDriver driver;

		@BeforeSuite
		public void Main() throws IOException, InterruptedException {
			Setup setup = new Setup();
			driver = setup.setup();
			Thread.sleep(3000);
		}
		@BeforeTest
		public void Setup2() throws InterruptedException {
			TimKiemHocHamHocVi_Page MainPage = new TimKiemHocHamHocVi_Page(driver);
			MainPage.Menu();
			Thread.sleep(2000);
		}
		@Test
		public void SearchHocHamHocVi() throws InterruptedException, IOException {
		    // Khởi tạo một đối tượng TimKiemHocHamHocVi_Page để thao tác trên trang web.
		    TimKiemHocHamHocVi_Page MainPage = new TimKiemHocHamHocVi_Page(driver);
		    // Mở menu Học hàm học vị.
		    MainPage.HHHVMenu();
		    // Đợi 2 giây cho trang web load dữ liệu.
		    Thread.sleep(2000);
		    // Chọn hiển thị 10 dữ liệu.
		    MainPage.Data("10");
		    // Đợi 2 giây cho trang web load dữ liệu mới.
		    Thread.sleep(2000);

		    // Đọc dữ liệu từ file Excel.
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Khởi tạo StringBuilder để lưu các từ khóa tìm kiếm thành công và thất bại.
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong file Excel để tìm kiếm.
		    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		        XSSFRow row = sheet.getRow(i);
		        String id = row.getCell(0).getStringCellValue();

		        // Tìm ô tìm kiếm trên trang web và nhập từ khóa cần tìm.
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        // Đợi 1 giây để kết quả tìm kiếm xuất hiện.
		        Thread.sleep(1000);
		        // Tìm phần tử chứa kết quả tìm kiếm trên trang web.
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		        // Kiểm tra kết quả tìm kiếm và lưu vào StringBuilder tương ứng.
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa từ khóa trong ô tìm kiếm để chuẩn bị tìm kiếm từ khóa tiếp theo.
		        searchbox.clear();
		    }
		    // In ra màn hình kết quả của Testcase 1.
		    System.out.println("Testcase 1:Tìm kiếm với Hiển thị 10 dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}

		@Test
		public void SearchHocHamHocVi2() throws InterruptedException, IOException {
		    // Khởi tạo một đối tượng TimKiemHocHamHocVi_Page để thao tác trên trang web.
		    TimKiemHocHamHocVi_Page MainPage = new TimKiemHocHamHocVi_Page(driver);
		    // Mở menu Học hàm học vị.
		    MainPage.HHHVMenu();
		    // Đợi 2 giây cho trang web load dữ liệu.
		    Thread.sleep(2000);
		    // Chọn hiển thị 25 dữ liệu.
		    MainPage.Data("25");
		    // Đợi 2 giây cho trang web load dữ liệu mới.
		    Thread.sleep(2000);

		    // Đọc dữ liệu từ file Excel.
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Khởi tạo StringBuilder để lưu các từ khóa tìm kiếm thành công và thất bại.
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong file Excel để tìm kiếm.
		    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		        XSSFRow row = sheet.getRow(i);
		        String id = row.getCell(0).getStringCellValue();

		        // Tìm ô tìm kiếm trên trang web và nhập từ khóa cần tìm.
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        // Đợi 1 giây để kết quả tìm kiếm xuất hiện.
		        Thread.sleep(1000);
		        // Tìm phần tử chứa kết quả tìm kiếm trên trang web.
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		        // Kiểm tra kết quả tìm kiếm và lưu vào StringBuilder tương ứng.
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa từ khóa trong ô tìm kiếm để chuẩn bị tìm kiếm từ khóa tiếp theo.
		        searchbox.clear();
		    }
		    // In ra màn hình kết quả của Testcase 2.
		    System.out.println("Testcase 2:Tìm kiếm với Hiển thị 25 dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}
		@Test
		public void SearchHocHamHocVi3() throws InterruptedException, IOException {
		    // Khởi tạo một đối tượng TimKiemHocHamHocVi_Page để thao tác trên trang web.
		    TimKiemHocHamHocVi_Page MainPage = new TimKiemHocHamHocVi_Page(driver);
		    // Mở menu Học hàm học vị.
		    MainPage.HHHVMenu();
		    // Đợi 2 giây cho trang web load dữ liệu.
		    Thread.sleep(2000);
		    // Chọn hiển thị 50 dữ liệu.
		    MainPage.Data("50");
		    // Đợi 2 giây cho trang web load dữ liệu mới.
		    Thread.sleep(2000);

		    // Đọc dữ liệu từ file Excel.
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Khởi tạo StringBuilder để lưu các từ khóa tìm kiếm thành công và thất bại.
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong file Excel để tìm kiếm.
		    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		        XSSFRow row = sheet.getRow(i);
		        String id = row.getCell(0).getStringCellValue();

		        // Tìm ô tìm kiếm trên trang web và nhập từ khóa cần tìm.
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        // Đợi 1 giây để kết quả tìm kiếm xuất hiện.
		        Thread.sleep(1000);
		        // Tìm phần tử chứa kết quả tìm kiếm trên trang web.
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		        // Kiểm tra kết quả tìm kiếm và lưu vào StringBuilder tương ứng.
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa từ khóa trong ô tìm kiếm để chuẩn bị tìm kiếm từ khóa tiếp theo.
		        searchbox.clear();
		    }
		    // In ra màn hình kết quả của Testcase 3.
		    System.out.println("Testcase 3:Tìm kiếm với Hiển thị 50 dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}

		@Test
		public void SearchHocHamHocVi4() throws InterruptedException, IOException {
		    // Khởi tạo một đối tượng TimKiemHocHamHocVi_Page để thao tác trên trang web.
		    TimKiemHocHamHocVi_Page MainPage = new TimKiemHocHamHocVi_Page(driver);
		    // Mở menu Học hàm học vị.
		    MainPage.HHHVMenu();
		    // Đợi 2 giây cho trang web load dữ liệu.
		    Thread.sleep(2000);
		    // Chọn hiển thị tất cả dữ liệu.
		    MainPage.Data("-1");
		    // Đợi 2 giây cho trang web load dữ liệu mới.
		    Thread.sleep(2000);

		    // Đọc dữ liệu từ file Excel.
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Khởi tạo StringBuilder để lưu các từ khóa tìm kiếm thành công và thất bại.
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong file Excel để tìm kiếm.
		    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		        XSSFRow row = sheet.getRow(i);
		        String id = row.getCell(0).getStringCellValue();

		        // Tìm ô tìm kiếm trên trang web và nhập từ khóa cần tìm.
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        // Đợi 1 giây để kết quả tìm kiếm xuất hiện.
		        Thread.sleep(1000);
		        // Tìm phần tử chứa kết quả tìm kiếm trên trang web.
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		        // Kiểm tra kết quả tìm kiếm và lưu vào StringBuilder tương ứng.
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa từ khóa trong ô tìm kiếm để chuẩn bị tìm kiếm từ khóa tiếp theo.
		        searchbox.clear();
		    }
		    // In ra màn hình kết quả của Testcase 4.
		    System.out.println("Testcase 4:Tìm kiếm với Hiển thị tất cả dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}

		@Test
		public void SearchHocHamHocVi5() throws InterruptedException, IOException {
		    // Khởi tạo một đối tượng TimKiemHocHamHocVi_Page để thao tác trên trang web.
		    TimKiemHocHamHocVi_Page MainPage = new TimKiemHocHamHocVi_Page(driver);
		    // Mở menu Học hàm học vị.
		    MainPage.HHHVMenu();
		    // Đợi 2 giây cho trang web load dữ liệu.
		    Thread.sleep(2000);
		    // Chọn hiển thị 10 dữ liệu.
		    MainPage.Data("10");
		    // Đợi 2 giây cho trang web load dữ liệu mới.
		    Thread.sleep(2000);

		    // Đọc dữ liệu từ file Excel.
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Khởi tạo StringBuilder để lưu các từ khóa tìm kiếm thành công và thất bại.
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong file Excel để tìm kiếm.
		    for (int i = 0; i < 21; i++) {
		        XSSFRow row = sheet.getRow(i);
		        // Lấy từ khóa từ cột thứ 2 trong file Excel.
		        String id = row.getCell(1).getStringCellValue();

		        // Tìm ô tìm kiếm trên trang web và nhập từ khóa cần tìm.
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        // Đợi 1 giây để kết quả tìm kiếm xuất hiện.
		        Thread.sleep(1000);
		        // Tìm phần tử chứa kết quả tìm kiếm trên trang web.
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		        // Kiểm tra kết quả tìm kiếm và lưu vào StringBuilder tương ứng.
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa từ khóa trong ô tìm kiếm để chuẩn bị tìm kiếm từ khóa tiếp theo.
		        searchbox.clear();
		    }
		    // In ra màn hình kết quả của Testcase 6.
		    System.out.println("Testcase 5:Tìm kiếm với kí tự đặc biệt và Hiển thị 10 dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}
		@Test
		public void SearchHocHamHocVi6() throws InterruptedException, IOException {
		    // Khởi tạo một đối tượng TimKiemHocHamHocVi_Page để thao tác trên trang web.
		    TimKiemHocHamHocVi_Page MainPage = new TimKiemHocHamHocVi_Page(driver);
		    // Mở menu Học hàm học vị.
		    MainPage.HHHVMenu();
		    // Đợi 2 giây cho trang web load dữ liệu.
		    Thread.sleep(2000);
		    // Chọn hiển thị 25 dữ liệu.
		    MainPage.Data("25");
		    // Đợi 2 giây cho trang web load dữ liệu mới.
		    Thread.sleep(2000);

		    // Đọc dữ liệu từ file Excel.
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Khởi tạo StringBuilder để lưu các từ khóa tìm kiếm thành công và thất bại.
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong file Excel để tìm kiếm.
		    for (int i = 0; i < 21; i++) {
		        XSSFRow row = sheet.getRow(i);
		        // Lấy từ khóa từ cột thứ 2 trong file Excel.
		        String id = row.getCell(1).getStringCellValue();

		        // Tìm ô tìm kiếm trên trang web và nhập từ khóa cần tìm.
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        // Đợi 1 giây để kết quả tìm kiếm xuất hiện.
		        Thread.sleep(1000);
		        // Tìm phần tử chứa kết quả tìm kiếm trên trang web.
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		        // Kiểm tra kết quả tìm kiếm và lưu vào StringBuilder tương ứng.
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa từ khóa trong ô tìm kiếm để chuẩn bị tìm kiếm từ khóa tiếp theo.
		        searchbox.clear();
		    }
		    // In ra màn hình kết quả của Testcase 6.
		    System.out.println("Testcase 6:Tìm kiếm với kí tự đặc biệt và Hiển thị 25 dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}
		@Test
		public void SearchHocHamHocVi7() throws InterruptedException, IOException {
		    // Khởi tạo một đối tượng TimKiemHocHamHocVi_Page để thao tác trên trang web.
		    TimKiemHocHamHocVi_Page MainPage = new TimKiemHocHamHocVi_Page(driver);
		    // Mở menu Học hàm học vị.
		    MainPage.HHHVMenu();
		    // Đợi 2 giây cho trang web load dữ liệu.
		    Thread.sleep(2000);
		    // Chọn hiển thị 50 dữ liệu.
		    MainPage.Data("50");
		    // Đợi 2 giây cho trang web load dữ liệu mới.
		    Thread.sleep(2000);

		    // Đọc dữ liệu từ file Excel.
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Khởi tạo StringBuilder để lưu các từ khóa tìm kiếm thành công và thất bại.
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong file Excel để tìm kiếm.
		    for (int i = 0; i < 21; i++) {
		        XSSFRow row = sheet.getRow(i);
		        // Lấy từ khóa từ cột thứ 2 trong file Excel.
		        String id = row.getCell(1).getStringCellValue();

		        // Tìm ô tìm kiếm trên trang web và nhập từ khóa cần tìm.
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        // Đợi 1 giây để kết quả tìm kiếm xuất hiện.
		        Thread.sleep(1000);
		        // Tìm phần tử chứa kết quả tìm kiếm trên trang web.
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		        // Kiểm tra kết quả tìm kiếm và lưu vào StringBuilder tương ứng.
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa từ khóa trong ô tìm kiếm để chuẩn bị tìm kiếm từ khóa tiếp theo.
		        searchbox.clear();
		    }
		    // In ra màn hình kết quả của Testcase 7.
		    System.out.println("Testcase 7:Tìm kiếm với kí tự đặc biệt và Hiển thị 50 dữ liệu");
		    String pasString = pasStringBuilder.toString();
		    String faildString = faildBuilder.toString();
		    System.out.println("Key word không có kết quả " + faildString);
		    System.out.println("Key Word có kết quả " + pasString);
		    System.out.println("=================");
		}
		@Test
		public void SearchHocHamHocVi8() throws InterruptedException, IOException {
		    // Khởi tạo một đối tượng TimKiemHocHamHocVi_Page để thao tác trên trang web.
		    TimKiemHocHamHocVi_Page MainPage = new TimKiemHocHamHocVi_Page(driver);
		    // Mở menu Học hàm học vị.
		    MainPage.HHHVMenu();
		    // Đợi 2 giây cho trang web load dữ liệu.
		    Thread.sleep(2000);
		    // Chọn hiển thị tất cả dữ liệu.
		    MainPage.Data("-1");
		    // Đợi 2 giây cho trang web load dữ liệu mới.
		    Thread.sleep(2000);

		    // Đọc dữ liệu từ file Excel.
		    FileInputStream fis = new FileInputStream("K:\\Automation\\SearchHocHamHocVi.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);

		    // Khởi tạo StringBuilder để lưu các từ khóa tìm kiếm thành công và thất bại.
		    StringBuilder pasStringBuilder = new StringBuilder();
		    StringBuilder faildBuilder = new StringBuilder();

		    // Duyệt qua từng dòng trong file Excel để tìm kiếm.
		    for (int i = 0; i < 21; i++) {
		        XSSFRow row = sheet.getRow(i);
		        // Lấy từ khóa từ cột thứ 2 trong file Excel.
		        String id = row.getCell(1).getStringCellValue();

		        // Tìm ô tìm kiếm trên trang web và nhập từ khóa cần tìm.
		        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		        searchbox.sendKeys(id);
		        // Đợi 1 giây để kết quả tìm kiếm xuất hiện.
		        Thread.sleep(1000);
		        // Tìm phần tử chứa kết quả tìm kiếm trên trang web.
		        WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		        // Kiểm tra kết quả tìm kiếm và lưu vào StringBuilder tương ứng.
		        if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
		            faildBuilder.append(id);
		        } else {
		            pasStringBuilder.append(id);
		        }
		        // Xóa từ khóa trong ô tìm kiếm để chuẩn bị tìm kiếm từ khóa tiếp theo.
		        searchbox.clear();
		    }
		    // In ra màn hình kết quả của Testcase 8.
		    System.out.println("Testcase 8:Tìm kiếm với kí tự đặc biệt và Hiển thị tất cả dữ liệu");
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
