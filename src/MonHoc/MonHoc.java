package MonHoc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MonHoc {
	public WebDriver driver;
	Random random = new Random();
	@BeforeTest
	public void setup() throws InterruptedException {
		String profileString = "C:\\Users\\Phan_Hoang_Khang\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + profileString);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[3]/a")).click();
	}
	
//	@Test (priority = 0)
//	public void MonHoc1() throws InterruptedException, IOException {
//	    // Đợi 2 giây
//	    Thread.sleep(1500);
//	    // In ra thông báo cho test case
//	    System.out.println("Test case 1: Xem môn học theo - Học kỳ - Đơn ");	    
//	    // Mở file Excel chứa dữ liệu môn học
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\MonHoc.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(1);
//	    // Lấy thông tin về học kỳ và ngành từ file Excel
//	    String hockyString = row.getCell(0).getStringCellValue();
//	    String nganhString = row.getCell(1).getStringCellValue();	    
//	    // Tạo độ trễ trước khi thao tác với trình duyệt
//	    Thread.sleep(2000);
//	    // Click vào ô chọn học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
//	    // Tạo độ trễ trước khi gửi dữ liệu học kỳ
//	    Thread.sleep(2000);
//	    // Nhập thông tin học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
//	    // Tạo độ trễ trước khi chọn học kỳ từ dropdown
//	    Thread.sleep(2000);
//	    // Chọn học kỳ từ dropdown
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();
//	    // Tạo độ trễ trước khi thao tác với trình duyệt
//	    Thread.sleep(2000);
//	    // Click vào ô chọn ngành
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span")).click();
//	    // Tạo độ trễ trước khi gửi dữ liệu ngành
//	    Thread.sleep(2000);
//	    // Nhập thông tin ngành
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    // Tạo độ trễ trước khi chọn ngành từ dropdown
//	    Thread.sleep(2000);
//	    // Chọn ngành từ dropdown
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();      
//	    System.out.println("Kết quả nhập vào học kỳ: " + hockyString);
//	    System.out.println("Kết quả nhập vào ngành: " + nganhString);
//	    try {
//	        // Đợi 2 giây
//	        Thread.sleep(2000);
//	        // Tìm và lấy thông báo
//	        WebElement thongbao = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]/div/label"));
//	        // Kiểm tra nếu thông báo chứa chuỗi "Hiển thị"
//	        if (thongbao.getText().contains("Hiển thị")) {
//	            // In ra thông báo thành công
//	            System.out.println("Xem Thành Công!");
//	        } else {
//	            // In ra thông báo thất bại
//	            System.out.println("Xem thất bại");
//	        }
//	    } catch (Exception e) {
//	        // Nếu có lỗi, in ra thông báo thất bại
//	        System.out.println("Xem thất bại");
//	    }
//	}

	
//	@Test(priority = 1)
//	public void Monhoc2() throws InterruptedException, IOException {
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // In ra thông điệp chỉ định mục đích của test case
//	    System.out.println("Test case 2: Xem môn học theo - Học kỳ - Đơn - Số Liệu");
//	    // Đọc dữ liệu từ tập tin Excel
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\MonHoc.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(1);
//	    // Lấy thông tin học kỳ và ngành từ Excel
//	    String hockyString = row.getCell(0).getStringCellValue();
//	    String nganhString = row.getCell(1).getStringCellValue();
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // Thực hiện hành động UI để chọn học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    // Thực hiện hành động UI để chọn ngành
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    // Chọn một lựa chọn ngẫu nhiên từ dropdown
//	    WebElement optionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]/div/label/select"));
//	    optionElement.click();
//	    Thread.sleep(2000);
//	    int option = random.nextInt(1,4);
//	    WebElement optnumberElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[1]/div/label/select/option["+option+"]"));
//	    optnumberElement.click();
//	    Thread.sleep(2000);
//	    optionElement.click();
//	    Thread.sleep(2000);
//	    // In ra kết quả nhập học kỳ và ngành
//	    System.out.println("Kết quả nhập vào học kỳ: " + hockyString);
//	    System.out.println("Kết quả nhập vào ngành: " + nganhString);
//	    System.out.println("Đã hiển thị thành công: " + optnumberElement.getText() +" Dữ liệu!!");
//	}
//	
//	@Test(priority = 2)
//	public void MonHoc3() throws InterruptedException, IOException {
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // In ra thông điệp chỉ định mục đích của test case
//	    System.out.println("Test case 3: Xem môn học theo - Học kỳ - Đơn -> Tìm kiếm -> Mã môn học");
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\MonHoc.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(1);
//	    String hockyString = row.getCell(0).getStringCellValue();
//	    String nganhString = row.getCell(1).getStringCellValue();
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // Thực hiện hành động UI để chọn học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    // Thực hiện hành động UI để chọn ngành
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    XSSFSheet sheet2 = workbook.getSheetAt(1);
//	    System.out.println("Kết quả nhập vào học kỳ: " + hockyString);
//	    System.out.println("Kết quả nhập vào ngành: " + nganhString);
//	    for(int i = 1; i < sheet2.getPhysicalNumberOfRows(); i++ ) {
//	        XSSFRow row2 = sheet2.getRow(i);
//	        String mamonhocString = row2.getCell(0).getStringCellValue();
//	        String tenMonhocString = row2.getCell(1).getStringCellValue();
//	        String ngonNguString = row2.getCell(2).getStringCellValue();
//	        Thread.sleep(2000);
//	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).clear();
//	        Thread.sleep(2000);
//	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).sendKeys(mamonhocString);
//	        Thread.sleep(2000);
//	        WebElement mamonhoctt = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2]"));
//	        System.out.println("Kết quả mong đợi: " + mamonhocString);
//	        System.out.println("Kết quả thực tế: " + mamonhoctt.getText());
//	    }
//	}
//	
//	@Test(priority = 3)
//	public void MonHoc4() throws InterruptedException, IOException {
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // In ra thông điệp chỉ định mục đích của test case
//	    System.out.println("Test case 4: Xem môn học theo - Học kỳ - Đơn -> Tìm kiếm -> Tên môn học");
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\MonHoc.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(1);
//	    String hockyString = row.getCell(0).getStringCellValue();
//	    String nganhString = row.getCell(1).getStringCellValue();
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // Thực hiện hành động UI để chọn học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    // Thực hiện hành động UI để chọn ngành
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    XSSFSheet sheet2 = workbook.getSheetAt(1);
//	    System.out.println("Kết quả nhập vào học kỳ: " + hockyString);
//	    System.out.println("Kết quả nhập vào ngành: " + nganhString);
//	    for(int i = 1; i < sheet2.getPhysicalNumberOfRows(); i++ ) {
//	        XSSFRow row2 = sheet2.getRow(i);
//	        String tenMonhocString = row2.getCell(1).getStringCellValue();
//	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).clear();
//	        Thread.sleep(2000);
//	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).sendKeys(tenMonhocString);
//	        Thread.sleep(2000);
//	        WebElement nganhhoctt = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]"));
//	        System.out.println("Kết quả mong đợi: " + tenMonhocString);
//	        System.out.println("Kết quả thực tế: " + nganhhoctt.getText());
//	    }
//	}
//	
//	@Test(priority = 4)
//	public void MonHoc5() throws InterruptedException, IOException {
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // In ra thông điệp chỉ định mục đích của test case
//	    System.out.println("Test case 5: Xem môn học theo - Học kỳ - Đơn -> Tìm kiếm -> Ngôn ngữ môn học");
//	    FileInputStream fis = new FileInputStream("D:\\TestLibery\\MonHoc.xlsx");
//	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    XSSFRow row = sheet.getRow(1);
//	    String hockyString = row.getCell(0).getStringCellValue();
//	    String nganhString = row.getCell(1).getStringCellValue();
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // Thực hiện hành động UI để chọn học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hockyString);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    // Thực hiện hành động UI để chọn ngành
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
//	    Thread.sleep(2000);
//	    XSSFSheet sheet2 = workbook.getSheetAt(1);
//	    System.out.println("Kết quả nhập vào học kỳ: " + hockyString);
//	    System.out.println("Kết quả nhập vào ngành: " + nganhString);
//	    for(int i = 1; i < sheet2.getPhysicalNumberOfRows(); i++ ) {
//	        XSSFRow row2 = sheet2.getRow(i);
//	        String ngonNguString = row2.getCell(2).getStringCellValue();
//	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).clear();
//	        Thread.sleep(2000);
//	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).sendKeys(ngonNguString);
//	        Thread.sleep(2000);
//	        WebElement nntt = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[5]"));
//	        System.out.println("Kết quả mong đợi: " + ngonNguString);
//	        System.out.println("Kết quả thực tế: " + nntt.getText());
//	    }
//	}
//	
//	@Test(priority = 5)
//	public void MonHoc6() throws InterruptedException {
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // In ra thông điệp chỉ định mục đích của test case
//	    System.out.println("Test case 6: Sắp xếp theo Mã môn học Tăng dần");
//	    Thread.sleep(2000);
//	    // Tìm và chọn phần tử thể hiện mã môn học
//	    WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[2]"));
//	    Thread.sleep(2000);
//	    // Click vào phần tử để sắp xếp tăng dần
//	    mamonhocElement.click();
//	    // Lấy thuộc tính aria-label để kiểm tra thứ tự sắp xếp
//	    String trangtahString = mamonhocElement.getAttribute("aria-label");
//	    String dowString = "Sắp xếp thứ tự giảm dần";
//	    String upString = "Sắp xếp thứ tự tăng dần";
//	    if (trangtahString.contains(upString)) {
//	        System.out.println("Sắp xếp mã môn học tăng dần! Thành công!!");
//	    } else  {
//	        System.out.println("Sắp xếp mã môn học tăng dần! Thất bại!!");
//	    }
//	}
//	
//	@Test(priority = 6)
//	public void MonHoc7() throws InterruptedException {
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // In ra thông điệp chỉ định mục đích của test case
//	    System.out.println("Test case 7: Sắp xếp theo Mã môn học Giảm dần");
//	    Thread.sleep(2000);
//	    // Tìm và chọn phần tử thể hiện mã môn học
//	    WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[2]"));
//	    Thread.sleep(2000);
//	    // Click vào phần tử để sắp xếp giảm dần
//	    mamonhocElement.click();
//	    // Lấy thuộc tính aria-label để kiểm tra thứ tự sắp xếp
//	    String trangtahString = mamonhocElement.getAttribute("aria-label");
//	    String dowString = "Sắp xếp thứ tự giảm dần";
//	    if (trangtahString.contains(dowString)) {
//	        System.out.println("Sắp xếp mã môn học Giảm dần! Thành công!!");
//	    } else  {
//	        System.out.println("Sắp xếp mã môn học Giảm dần! Thất bại!!");
//	    }
//	}
//	
//	@Test(priority = 7)
//	public void MonHoc8() throws InterruptedException {
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // In ra thông điệp chỉ định mục đích của test case
//	    System.out.println("Test case 8: Sắp xếp theo Tên môn học Giảm dần");
//	    Thread.sleep(2000);
//	    // Tìm và chọn phần tử thể hiện tên môn học
//	    WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[3]"));
//	    Thread.sleep(2000);
//	    // Click vào phần tử để sắp xếp giảm dần
//	    mamonhocElement.click();
//	    // Lấy thuộc tính aria-label để kiểm tra thứ tự sắp xếp
//	    String trangtahString = mamonhocElement.getAttribute("aria-label");
//	    String dowString = "Sắp xếp thứ tự giảm dần";
//	    String upString = "Sắp xếp thứ tự tăng dần";
//	    if (trangtahString.contains(dowString)) {
//	        System.out.println("Sắp xếp tên môn học giảm dần! Thành công!!");
//	    } else  {
//	        System.out.println("Sắp xếp tên môn học giảm dần! Thất bại!!");
//	    }
//	}
//	
//	@Test(priority = 8)
//	public void MonHoc9() throws InterruptedException {
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // In ra thông điệp chỉ định mục đích của test case
//	    System.out.println("Test case 9: Sắp xếp theo Tên môn học Tăng dần");
//	    Thread.sleep(2000);
//	    // Tìm và chọn phần tử thể hiện tên môn học
//	    WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[3]"));
//	    Thread.sleep(2000);
//	    // Click vào phần tử để sắp xếp tăng dần
//	    mamonhocElement.click();
//	    // Lấy thuộc tính aria-label để kiểm tra thứ tự sắp xếp
//	    String trangtahString = mamonhocElement.getAttribute("aria-label");
//	    String dowString = "Sắp xếp thứ tự tăng dần";
//	    if (trangtahString.contains(dowString)) {
//	        System.out.println("Sắp xếp tên môn học tăng dần! Thành công!!");
//	    } else  {
//	        System.out.println("Sắp xếp tên môn học tăng dần! Thất bại!!");
//	    }
//	}
//	
//	@Test(priority = 9)
//	public void MonHoc10() throws InterruptedException {
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // In ra thông điệp chỉ định mục đích của test case
//	    System.out.println("Test case 10: Sắp xếp theo ngôn ngữ môn học Giảm dần");
//	    Thread.sleep(2000);
//	    // Tìm và chọn phần tử thể hiện ngôn ngữ môn học
//	    WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[5]"));
//	    Thread.sleep(2000);
//	    // Click vào phần tử để sắp xếp giảm dần
//	    mamonhocElement.click();
//	    // Lấy thuộc tính aria-label để kiểm tra thứ tự sắp xếp
//	    String trangtahString = mamonhocElement.getAttribute("aria-label");
//	    String dowString = "Sắp xếp thứ tự giảm dần";
//	    String upString = "Sắp xếp thứ tự tăng dần";
//	    if (trangtahString.contains(dowString)) {
//	        System.out.println("Sắp xếp ngôn ngữ môn học giảm dần! Thành công!!");
//	    } else  {
//	        System.out.println("Sắp xếp ngôn ngữ môn học giảm dần! Thất bại!!");
//	    }
//	}
//	
//	@Test(priority = 10)
//	public void MonHoc11() throws InterruptedException {
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // In ra thông điệp chỉ định mục đích của test case
//	    System.out.println("Test case 11: Sắp xếp theo ngôn ngữ môn học Tăng dần");
//	    Thread.sleep(2000);
//	    // Tìm và chọn phần tử thể hiện ngôn ngữ môn học
//	    WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[5]"));
//	    Thread.sleep(2000);
//	    // Click vào phần tử để sắp xếp tăng dần
//	    mamonhocElement.click();
//	    // Lấy thuộc tính aria-label để kiểm tra thứ tự sắp xếp
//	    String trangtahString = mamonhocElement.getAttribute("aria-label");
//	    String dowString = "Sắp xếp thứ tự tăng dần";
//	    if (trangtahString.contains(dowString)) {
//	        System.out.println("Sắp xếp ngôn ngữ môn học tăng dần! Thành công!!");
//	    } else  {
//	        System.out.println("Sắp xếp ngôn ngữ môn học tăng dần! Thất bại!!");
//	    }
//	}
//	
//	@Test(priority = 11)
//	public void MonHoc12() throws InterruptedException {
//	    // Dừng chương trình trong 2 giây
//	    Thread.sleep(2000);
//	    // In ra thông điệp chỉ định mục đích của test case
//	    System.out.println("Test case 12: Sắp xếp theo STC môn học Giảm dần");
//	    Thread.sleep(2000);
//	    // Tìm và chọn phần tử thể hiện STC môn học
//	    WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[4]"));
//	    Thread.sleep(2000);
//	    // Click vào phần tử để sắp xếp giảm dần
//	    mamonhocElement.click();
//	    // Lấy thuộc tính aria-label để kiểm tra thứ tự sắp xếp
//	    String trangtahString = mamonhocElement.getAttribute("aria-label");
//	    String dowString = "Sắp xếp thứ tự giảm dần";
//	    if (trangtahString.contains(dowString)) {
//	        System.out.println("Sắp xếp STC môn học giảm dần! Thành công!!");
//	    } else  {
//	        System.out.println("Sắp xếp STC môn học giảm dần! Thất bại!!");
//	    }
//	}
//	
	@Test(priority = 12)
	public void MonHoc13() throws InterruptedException {
	    // Dừng chương trình trong 2 giây
	    Thread.sleep(2000);
	    // In ra thông điệp chỉ định mục đích của test case
	    System.out.println("Test case 13: Sắp xếp theo STC môn học Tăng dần");
	    Thread.sleep(2000);
	    // Tìm và chọn phần tử thể hiện STC môn học
	    WebElement mamonhocElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/thead/tr/th[4]"));
	    Thread.sleep(2000);
	    // Click vào phần tử để sắp xếp tăng dần
	    mamonhocElement.click();
	    // Lấy thuộc tính aria-label để kiểm tra thứ tự sắp xếp
	    String trangtahString = mamonhocElement.getAttribute("aria-label");
	    String dowString = "Sắp xếp thứ tự tăng dần";
	    if (trangtahString.contains(dowString)) {
	        System.out.println("Sắp xếp STC môn học tăng dần! Thành công!!");
	    } else  {
	        System.out.println("Sắp xếp STC môn học tăng dần! Thất bại!!");
	    }
	}
	
}
