package PhanCong;

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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XemPhanCong {
	static WebDriver driver;
	public Random random = new Random();
	@BeforeTest
	public void setup() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\letan\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]/ul/li[2]/a")).click();

		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Phancong.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow row = sheet.getRow(1);
		 String hocky = row.getCell(0).getStringCellValue();
		 String nganhString = row.getCell(1).getStringCellValue();
		 
		 
		 //Setup học kỳ và ngành
		 
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span")).click();
		 Thread.sleep(500);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys(hocky);
		 Thread.sleep(500);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li")).click();
		 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span")).click();
		 Thread.sleep(500);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input")).sendKeys(nganhString);
		 Thread.sleep(500);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
	
		 // Setup Môn và GV
		 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span/span[1]/span")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/div/button[2]")).click();
		 
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span/ul/li/input")).click();
		 Thread.sleep(500);
		 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/div/button[2]")).click();
		 
	
	}
	
//	@Test (priority = 0)
//	public void SoftOneSOneT() throws InterruptedException {
//		Thread.sleep(5000);
//		System.out.println("Test case 1: Lọc 1 môn học 1 giảng viên");
//		//Chọn môn
//		WebElement inputsujectElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span/ul/li/input"));
//		inputsujectElement.click();
//		Thread.sleep(2000);
//		int randomsubject = random.nextInt(1,22);
//		WebElement mondachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/span/ul/li["+randomsubject+"]"));
//		Thread.sleep(2000);
//		String subjectString = mondachonElement.getText();
//		mondachonElement.click();
//		//Chọn giảng viên
//		Thread.sleep(5000);
//		WebElement inputGvElement =  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span/ul/li/input"));
//		inputGvElement.click();
//		int randomTeacher = random.nextInt(1,380);
//		Thread.sleep(5000);
//		WebElement giangviendachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/span/ul/li["+randomTeacher+"]"));
//		String giangvienString = giangviendachonElement.getText();
//		giangviendachonElement.click();
//		
//		try {
//			Thread.sleep(1000);
//			WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//			System.out.println(thongbaoElement.getText());
//			System.out.println("Kết quả mong đợi: Đã chọn 1 môn, Đã chọn 1 GV");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		} catch (Exception e) {
//			System.out.println("Giảng viên đã được phân công");
//			System.out.println("Kết quả mong đợi: Đã chọn 1 môn, Đã chọn 1 GV");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		}	
//	}
	
//	@Test (priority = 1)
//	public void SoftOneSNoT() throws InterruptedException {
//		Thread.sleep(5000);
//		System.out.println("Test case 2: Lọc 1 môn học bỏ tất cả giảng viên");
//		//Chọn môn
//		WebElement inputsujectElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span/ul/li/input"));
//		inputsujectElement.click();
//		Thread.sleep(2000);
//		int randomsubject = random.nextInt(1,22);
//		WebElement mondachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/span/ul/li["+randomsubject+"]"));
//		Thread.sleep(2000);
//		String subjectString = mondachonElement.getText();
//		mondachonElement.click();
//		//Chọn giảng viên
//		Thread.sleep(5000);
//		WebElement inputGvElement =  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span/ul/li/input"));
//		inputGvElement.click();
//
//		Thread.sleep(5000);
//		WebElement giangviendachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/div/button[2]"));
//		String giangvienString = giangviendachonElement.getText();
//		giangviendachonElement.click();
//		
//		try {
//			Thread.sleep(1000);
//			WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//			System.out.println(thongbaoElement.getText());
//			System.out.println("Kết quả mong đợi: Đã chọn 1 môn, Lọc Giảng Viên");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		} catch (Exception e) {
//			System.out.println("Giảng viên đã được phân công");
//			System.out.println("Kết quả mong đợi: Đã chọn 1 môn, Lọc Giảng Viên");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		}		
//	}
	
//	@Test (priority = 2)
//	public void SoftOneSNoT() throws InterruptedException {
//		Thread.sleep(5000);
//		System.out.println("Test case 3: Lọc 1 môn học chọn tất cả giảng viên");
//		//Chọn môn
//		WebElement inputsujectElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span/ul/li/input"));
//		inputsujectElement.click();
//		Thread.sleep(2000);
//		int randomsubject = random.nextInt(1,22);
//		WebElement mondachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/span/ul/li["+randomsubject+"]"));
//		Thread.sleep(2000);
//		String subjectString = mondachonElement.getText();
//		mondachonElement.click();
//		//Chọn giảng viên
//		Thread.sleep(5000);
//		WebElement inputGvElement =  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span/ul/li/input"));
//		inputGvElement.click();
//
//		Thread.sleep(5000);
//		WebElement giangviendachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/div/button[1]"));
//		String giangvienString = giangviendachonElement.getText();
//		giangviendachonElement.click();
//		
//		Thread.sleep(5000);
//		System.out.println("Kết quả mong đợi: Đã chọn 1 môn, Đã chọn xxx giảng viên");
//		System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//			
//	}
	
//	@Test (priority = 3)
//	public void SoftOneSOneT() throws InterruptedException {
//		Thread.sleep(5000);
//		System.out.println("Test case 4: Lọc tất cả môn học 1 giảng viên");
//		//Chọn môn
//		WebElement inputsujectElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span/ul/li/input"));
//		inputsujectElement.click();
//		Thread.sleep(2000);
//
//		WebElement mondachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/div/button[1]"));
//		Thread.sleep(5000);
//		String subjectString = mondachonElement.getText();
//		mondachonElement.click();
//		//Chọn giảng viên
//		Thread.sleep(5000);
//		WebElement inputGvElement =  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span/ul/li/input"));
//		inputGvElement.click();
//		int randomTeacher = random.nextInt(1,380);
//		Thread.sleep(5000);
//		WebElement giangviendachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/span/ul/li["+randomTeacher+"]"));
//		String giangvienString = giangviendachonElement.getText();
//		giangviendachonElement.click();
//		
//		try {
//			Thread.sleep(1000);
//			WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//			System.out.println(thongbaoElement.getText());
//			System.out.println("Kết quả mong đợi: Đã chọn tất cả môn, Đã chọn 1 GV");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		} catch (Exception e) {
//			System.out.println("Giảng viên đã được phân công");
//			System.out.println("Kết quả mong đợi: Đã chọn tất cả môn, Đã chọn 1 GV");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		}	
//	}
	
//	@Test (priority = 4)
//	public void SoftOneSOneT() throws InterruptedException {
//		Thread.sleep(5000);
//		System.out.println("Test case 5: Lọc tất cả môn học bỏ tất cả giảng viên");
//		//Chọn môn
//		WebElement inputsujectElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span/ul/li/input"));
//		inputsujectElement.click();
//		Thread.sleep(2000);
//
//		WebElement mondachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/div/button[1]"));
//		Thread.sleep(5000);
//		String subjectString = mondachonElement.getText();
//		mondachonElement.click();
//		//Chọn giảng viên
//		Thread.sleep(5000);
//		WebElement inputGvElement =  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span/ul/li/input"));
//		inputGvElement.click();
//		Thread.sleep(5000);
//		WebElement giangviendachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/div/button[2]"));
//		String giangvienString = giangviendachonElement.getText();
//		giangviendachonElement.click();
//		
//		try {
//			Thread.sleep(1000);
//			WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//			System.out.println(thongbaoElement.getText());
//			System.out.println("Kết quả mong đợi: Đã chọn tất cả môn, Lọc Giảng Viên");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		} catch (Exception e) {
//			System.out.println("Giảng viên đã được phân công");
//			System.out.println("Kết quả mong đợi: Đã chọn tất cả môn, Lọc Giảng Viên");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		}	
//	}
	
	
//	@Test (priority = 5)
//	public void SoftOneSOneT() throws InterruptedException {
//		Thread.sleep(5000);
//		System.out.println("Test case 6: Lọc tất cả môn học chọn tất cả giảng viên");
//		//Chọn môn
//		WebElement inputsujectElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span/ul/li/input"));
//		inputsujectElement.click();
//		Thread.sleep(2000);
//
//		WebElement mondachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/div/button[1]"));
//		Thread.sleep(5000);
//		String subjectString = mondachonElement.getText();
//		mondachonElement.click();
//		//Chọn giảng viên
//		Thread.sleep(5000);
//		WebElement inputGvElement =  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span/ul/li/input"));
//		inputGvElement.click();
//		Thread.sleep(5000);
//		WebElement giangviendachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/div/button[1]"));
//		String giangvienString = giangviendachonElement.getText();
//		giangviendachonElement.click();
//		
//		try {
//			Thread.sleep(1000);
//			WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//			System.out.println(thongbaoElement.getText());
//			System.out.println("Kết quả mong đợi: Đã chọn tất cả môn, họn tất cả GV");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		} catch (Exception e) {
//			System.out.println("Giảng viên đã được phân công");
//			System.out.println("Kết quả mong đợi: Đã chọn tất cả môn, Chọn tất cả GV");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		}	
//	}
	
	
//	@Test (priority = 6)
//	public void SoftOneSOneT() throws InterruptedException {
//		Thread.sleep(5000);
//		System.out.println("Test case 7: bỏ tất cả môn học 1 giảng viên");
//		//Chọn môn
//		WebElement inputsujectElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span/ul/li/input"));
//		inputsujectElement.click();
//		Thread.sleep(2000);
//
//		WebElement mondachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/div/button[2]"));
//		Thread.sleep(5000);
//		String subjectString = mondachonElement.getText();
//		mondachonElement.click();
//		//Chọn giảng viên
//		Thread.sleep(5000);
//		WebElement inputGvElement =  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span/ul/li/input"));
//		inputGvElement.click();
//		int randomTeacher = random.nextInt(1,380);
//		Thread.sleep(5000);
//		WebElement giangviendachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/span/ul/li["+randomTeacher+"]"));
//		String giangvienString = giangviendachonElement.getText();
//		giangviendachonElement.click();
//		
//		try {
//			Thread.sleep(1000);
//			WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//			System.out.println(thongbaoElement.getText());
//			System.out.println("Kết quả mong đợi: Lọc môn học, Đã chọn 1 GV");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		} catch (Exception e) {
//			System.out.println("Giảng viên đã được phân công");
//			System.out.println("Kết quả mong đợi: Lọc môn học, Đã chọn 1 GV");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		}	
//	}
	
	
//	@Test (priority = 7)
//	public void SoftOneSOneT() throws InterruptedException {
//		Thread.sleep(5000);
//		System.out.println("Test case 8: bỏ tất cả môn học bỏ tất cả giảng viên");
//		//Chọn môn
//		WebElement inputsujectElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span/ul/li/input"));
//		inputsujectElement.click();
//		Thread.sleep(2000);
//
//		WebElement mondachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/div/button[2]"));
//		Thread.sleep(5000);
//		String subjectString = mondachonElement.getText();
//		mondachonElement.click();
//		//Chọn giảng viên
//		Thread.sleep(5000);
//		WebElement inputGvElement =  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span/ul/li/input"));
//		inputGvElement.click();
//		Thread.sleep(5000);
//		WebElement giangviendachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/div/button[2]"));
//		String giangvienString = giangviendachonElement.getText();
//		giangviendachonElement.click();
//		
//		try {
//			Thread.sleep(1000);
//			WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//			System.out.println(thongbaoElement.getText());
//			System.out.println("Kết quả mong đợi: Lọc môn học, Lọc Giảng Viên");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		} catch (Exception e) {
//			System.out.println("Giảng viên đã được phân công");
//			System.out.println("Kết quả mong đợi: lọc môn học, Lọc Giảng Viên");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		}	
//	}
	
	
//	@Test (priority = 8)
//	public void SoftOneSOneT() throws InterruptedException {
//		Thread.sleep(5000);
//		System.out.println("Test case 9: bỏ tất cả môn học chọn tất cả giảng viên");
//		//Chọn môn
//		WebElement inputsujectElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span/ul/li/input"));
//		inputsujectElement.click();
//		Thread.sleep(2000);
//
//		WebElement mondachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/div/button[2]"));
//		Thread.sleep(5000);
//		String subjectString = mondachonElement.getText();
//		mondachonElement.click();
//		//Chọn giảng viên
//		Thread.sleep(5000);
//		WebElement inputGvElement =  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span/ul/li/input"));
//		inputGvElement.click();
//		Thread.sleep(5000);
//		WebElement giangviendachonElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/div/button[1]"));
//		String giangvienString = giangviendachonElement.getText();
//		giangviendachonElement.click();
//		
//		try {
//			Thread.sleep(1000);
//			WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//			System.out.println(thongbaoElement.getText());
//			System.out.println("Kết quả mong đợi: Bỏ chọn tất cả, vhọn tất cả GV");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		} catch (Exception e) {
//			System.out.println("Giảng viên đã được phân công");
//			System.out.println("Kết quả mong đợi: Bỏ chọn tất cả, Chọn tất cả GV");
//			System.out.println("Kết quả thực tế: " + inputsujectElement.getAttribute("placeholder") +", "+ inputGvElement.getAttribute("placeholder") +" : " +subjectString +", " + giangvienString );
//		}	
//	}
	
}
