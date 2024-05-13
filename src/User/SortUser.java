package Users;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortUser {
	public WebDriver driver;
	Random random = new Random();
	@BeforeTest
	public void setup() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\letan\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + chromeProfilePath);
        driver = new ChromeDriver(options);
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.id("OpenIdConnect")).click();
        Thread.sleep(2000);
	}
	@Test (priority = 0)
	public void getUser() throws InterruptedException {
		Thread.sleep(2000);
		WebElement tabuser = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[3]/a/span"));
		tabuser.click();
		Thread.sleep(2000);
	}
	@Test (priority = 1)
	public void sortUserbyData() throws InterruptedException {
		System.out.println("Test Case 1: Lọc người dùng theo dữ liệu");
		Thread.sleep(2000);
		//GetInput
		WebElement optionInput = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div/label/div/span[1]/span[1]/span/ul/li[6]/input"));
		optionInput.click();
		//Ẩn dữ liệu
		int optionsDataHide = 1;
		int optionsDataView = 1;
		for(int i = 1; i <= 5; i++) {		
			WebElement optionData = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div/label/div/span[2]/span/span/ul/li["+optionsDataHide+"]"));
			optionData.click();
			Thread.sleep(2000);
			System.out.println("Dữ liệu được ẩn theo: "+optionData.getText());
			optionsDataHide++;
		}
		for(int i = 1; i <= 7; i++) {		
			WebElement optionData = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div/label/div/span[2]/span/span/ul/li["+optionsDataView+"]"));
			optionData.click();
			Thread.sleep(2000);
			System.out.println("Dữ liệu được hiển thị theo: "+optionData.getText());
			optionsDataView++;
		}
	}
	@Test (priority = 2)
	public void sortbyNumber() throws InterruptedException {
		System.out.println("Test Case 2: Lọc người dùng theo số hiển thị");
		Thread.sleep(2000);
		int numbersData = random.nextInt(4)+1;
		WebElement numberData = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/label/select/option["+numbersData+"]"));
		numberData.click();
		System.out.println("Dữ liệu hiển thị: " + numberData.getText());
	}
	@Test (priority = 3)
	public void sortbyTeacherType() throws InterruptedException {
		System.out.println("Test Case 3: Lọc người dùng theo loại GV");
		Thread.sleep(2000);
		int typenumber = random.nextInt(3)+1;
		WebElement typeTeacher = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[1]/div[2]/div[1]/select/option["+typenumber+"]"));
		typeTeacher.click();
		if (typeTeacher.getText().equalsIgnoreCase("Chọn Loại GV Để Lọc")) {
			System.out.println("Dữ liệu lọc theo: Tất cả");
		}
		System.out.println("Dữ liệu lọc theo: " + typeTeacher.getText());
	}
	
	@Test (priority = 4)
	public void sortbyRole() throws InterruptedException {
		System.out.println("Test Case 4: Lọc người dùng theo vai trò");
		Thread.sleep(2000);
		int rolenumber = random.nextInt(5)+1;
		WebElement rolElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[1]/div[2]/div[2]/select/option["+rolenumber+"]"));
		rolElement.click();
		if (rolElement.getText().equalsIgnoreCase("Chọn role để lọc")) {
			System.out.println("Lọc theo vai trò: Tất cả");
		} System.out.println("Lọc theo vai trò: "+rolElement.getText());
	}
	@Test (priority = 5)
	public void searchUser() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test Case 5: Lọc người dùng theo tìm kiếm");
		Thread.sleep(2000);
		WebElement searchbox = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
		searchbox.sendKeys("Lê Tấn Đạt");
		WebElement inforUser = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr"));
		System.out.println(inforUser.getText());
		searchbox.clear();
		Thread.sleep(2000);

	}
	
	@Test (priority = 6)
	public void SearchUserbyData() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 6 tìm kiếm người dùng theo list Data");
		FileInputStream fis = new FileInputStream("E:\\TestData\\UserSearch.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for(int i = 1; i < sheet.getPhysicalNumberOfRows()-1; i++) {
        	Row row = sheet.getRow(i);
        	int lastcell = row.getLastCellNum();
        	int tr = 2;
        	for(int j =0; j < lastcell; j++) {
        		Thread.sleep(2000);
        		String valueString = row.getCell(j).getStringCellValue();
        		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(valueString);
        		WebElement databackElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[1]/td["+tr+"]"));
        		System.out.println("Kết quả mong đợi: "+ valueString);
        		System.out.println("Kết Quả thực tế: " +databackElement.getText());
        		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
        		tr++;
        		Thread.sleep(2000);
        	}
        }
	}
	
	
}
