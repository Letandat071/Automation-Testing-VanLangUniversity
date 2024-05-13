package FUNCTION2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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

public class ThemNguoiDung {
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

		System.out.println("Testcase 1: Thêm người dùng nhưng không điền mã giảng viên");
		
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);

		String fullname = row.getCell(1).getStringCellValue();
		String email = row.getCell(2).getStringCellValue();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys(fullname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
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
		String ketquamongdoi = "Bạn chưa nhập mã giảng viên";

		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + errorElement.getText());


	}

	@Test(priority = 1)
	public void Actions2() throws InterruptedException, IOException {
		System.out.println("Testcase 2: Thêm người dùng nhưng không điền tên giảng viên");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(1);
		
		int id = (int) row.getCell(0).getNumericCellValue(); // Đọc giá trị số nguyên từ cột A
//		String fullname = row.getCell(1).getStringCellValue();
		String email = row.getCell(2).getStringCellValue();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]")).sendKeys(String.valueOf(id)); // Chuyển số nguyên
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000);
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();

		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"full_name-error\"]"));
		String expected = "Bạn chưa nhập tên giảng viên";

		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void Actions3() throws InterruptedException, IOException {
		System.out.println("Testcase 3: Thêm người dùng nhưng email không hợp lệ");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(2);

		int id = (int) row.getCell(0).getNumericCellValue(); // Đọc giá trị số nguyên từ cột A
		String fullname = row.getCell(1).getStringCellValue();

		String email = row.getCell(2).getStringCellValue();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]")).sendKeys(String.valueOf(id)); // Chuyển số nguyên																		// thành chuỗi
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys(fullname);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
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

	@Test(priority = 3)
	public void Actions4() throws InterruptedException, IOException {
		System.out.println("Testcase 4: Thêm người dùng nhưng không điền email;");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(3);
		int id = (int) row.getCell(0).getNumericCellValue(); // Đọc giá trị số nguyên từ cột A
		String fullname = row.getCell(1).getStringCellValue();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]")).sendKeys(String.valueOf(id)); // Chuyển số nguyên
																							// thành chuỗ
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys(fullname);
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
	@Test(priority = 4)
	public void Actions5() throws InterruptedException, IOException {
		System.out.println("Testcase 5: Thêm người dùng nhưng điền ký tự đặc biệt");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(4);

		String id = row.getCell(0).getStringCellValue(); // Đọc giá trị số nguyên từ cột A
		String fullname = row.getCell(1).getStringCellValue();

		String email = row.getCell(2).getStringCellValue();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]")).sendKeys(String.valueOf(id)); // Chuyển số nguyên																		// thành chuỗi
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys(fullname);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
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
	@Test(priority = 5)
	public void Actions6() throws InterruptedException, IOException {
		System.out.println("Testcase 6: Thêm người dùng đúng thông tin");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(8);

		String id = row.getCell(0).getStringCellValue(); // Đọc giá trị số nguyên từ cột A
		String fullname = row.getCell(1).getStringCellValue();

		String email = row.getCell(2).getStringCellValue();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]")).sendKeys(String.valueOf(id)); // Chuyển số nguyên																		// thành chuỗi
		Thread.sleep(4000);
		driver.findElement(By.id("staff_id")).sendKeys(id);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys(fullname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		
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


}
