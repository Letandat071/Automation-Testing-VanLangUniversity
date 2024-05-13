package FUNCTION2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChinhSuaNguoiDung {
	static WebDriver driver;

	@BeforeTest
	public void setup() {
		String chromeProfilePath = "C:\\Users\\AN515-45\\AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
	}

	@Test(priority = 0)
	public void Actions() throws InterruptedException, IOException {
		Thread.sleep(5000);
		System.out.println("Testcase 1: Chỉnh sửa người dùng nhưng không điền tên giảng viên");

		FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);


		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr/td[7]/a[1]")).click();
		Thread.sleep(3000); // Dừng chương trình trong 3 giây.
		// Xoá dữ liệu cũ trong ô nhập tên.
		driver.findElement(By.id("full_name")).clear();

		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000);
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();

		Thread.sleep(2000);
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"full_name-error\"]"));
		String ketquamongdoi = "Bạn chưa nhập tên giảng viên";

		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + errorElement.getText());

	}

	@Test(priority = 1)
	public void Actions2() throws InterruptedException, IOException {
		System.out.println("Tesace 2: Chỉnh sửa người dùng nhưng không điền mã giảng viên");
		Thread.sleep(5000);
		FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(0);


		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr/td[7]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("staff_id")).clear();
		Thread.sleep(2000);

		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000);
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();

		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"staff_id-error\"]"));
		String expected = "Bạn chưa nhập mã giảng viên";

		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void Actions3() throws InterruptedException, IOException {
		System.out.println("Testcase 3: Cập nhật người dùng nhưng không điền email");

		FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(2);

		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr[1]/td[7]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).clear();
		
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000);
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();

		Thread.sleep(2000);
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"email-error\"]"));
		String expected = "Bạn chưa nhập email";

		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());
	}

	@Test(priority = 3)
	public void Actions4() throws InterruptedException, IOException {
		System.out.println("Testcase 4: Cập nhật người dùng nhưng điền ký tự đặc biệt vào mã giảng viên");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(4);

		String id = row.getCell(0).getStringCellValue(); // Đọc giá trị số nguyên từ cột A


		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr[1]/td[7]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("staff_id")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]")).sendKeys(String.valueOf(id)); // Chuyển số nguyên																		// thành chuỗi
		Thread.sleep(4000);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000);
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();

		Thread.sleep(2000);
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"staff_id-error\"]"));
		String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";

		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());
	}
	@Test(priority = 4)
	public void Actions5() throws InterruptedException, IOException {
		System.out.println("Testcase 5: Cập nhật người dùng nhưng điền email không hợp lệ");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(5);
		String email = row.getCell(2).getStringCellValue();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr[1]/td[7]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys(email);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000);
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();

		Thread.sleep(2000);
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"email-error\"]"));
		String expected = "Vui lòng nhập email Văn Lang hợp lệ!";

		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());

	}
	@Test(priority = 5)
	public void Actions6() throws InterruptedException, IOException {
		Thread.sleep(5000);
		System.out.println("Testcase 6: Chỉnh sửa người dùng nhưng điền tên với kí tự đặc biệt");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(6);

		String fullname = row.getCell(1).getStringCellValue();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr/td[7]/a[1]")).click();
		Thread.sleep(3000); // Dừng chương trình trong 3 giây.
		driver.findElement(By.id("full_name")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("full_name")).sendKeys(fullname);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000);
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();

		Thread.sleep(1000);
		WebElement updateElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		String ketquathucte= updateElement.getText();
		String ketquamongdoi = "Cập nhật thành công!";

		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + ketquathucte);

	}
	@Test(priority = 6)
	public void Actions7() throws InterruptedException, IOException {
		Thread.sleep(5000);
		System.out.println("Testcase 7: Chỉnh sửa người dùng đúng thông tin");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(7);

		String idString = row.getCell(0).getStringCellValue();
		String fullnameString = row.getCell(1).getStringCellValue();
		String gmailString = row.getCell(2).getStringCellValue();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr/td[7]/a[1]")).click();
		Thread.sleep(3000); // Dừng chương trình trong 3 giây.
		driver.findElement(By.id("staff_id")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("staff_id")).sendKeys(idString);
		Thread.sleep(3000); // Dừng chương trình trong 3 giây.
		driver.findElement(By.id("full_name")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("full_name")).sendKeys(fullnameString);
		Thread.sleep(3000); // Dừng chương trình trong 3 giây.
		driver.findElement(By.id("email")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(gmailString);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000);
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();

		Thread.sleep(1000);
		WebElement updateElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		String ketquathucte= updateElement.getText();
		String ketquamongdoi = "Cập nhật thành công!";

		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + ketquathucte);

	}


}
