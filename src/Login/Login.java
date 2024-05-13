package Users;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.language.Nysiis;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	public WebDriver driver;
	@BeforeTest 
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		Thread.sleep(2000);
		driver.findElement(By.id("details-button")).click();
		Thread.sleep(200);
		driver.findElement(By.id("proceed-link")).click();
		
	    driver.findElement(By.id("OpenIdConnect")).click();
	    Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void truemailfailpass() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test case 1: Đúng email sai password");
		
		//Lấy dữ liệu từ file excel
		FileInputStream fis = new FileInputStream("E:\\TestData\\Logindata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String email = row.getCell(0).getStringCellValue();
        String pass = row.getCell(1).getStringCellValue();
       String result = row.getCell(2).getStringCellValue();
        //Điền dữ liệu lên web ở trang email
        Thread.sleep(2000);
        driver.findElement(By.id("i0116")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).click();
        
        //Điền dữ liệu lên web ở trang password
        driver.findElement(By.id("i0118")).sendKeys(pass);
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(2000);
        String trueresult = driver.findElement(By.id("i0118Error")).getText();
        System.out.println("Kết quả mong đợi: "+ result);
        System.out.println("Kết quả thực tế: "+ trueresult);
        driver.navigate().refresh();
        driver.navigate().back();
	}
	
	
	@Test (priority = 1)
	public void emailnohavedomain() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test case 2: Email không có đuôi @");
		
		//Lấy dữ liệu từ file excel
		FileInputStream fis = new FileInputStream("E:\\TestData\\Logindata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(2);
        String email = row.getCell(0).getStringCellValue();
        String pass = row.getCell(1).getStringCellValue();
       String result = row.getCell(2).getStringCellValue();
        //Điền dữ liệu lên web ở trang email
        Thread.sleep(2000);
        driver.findElement(By.id("i0116")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).click();
        
        Thread.sleep(2000);
        String trueresult = driver.findElement(By.id("usernameError")).getText();
        System.out.println("Kết quả mong đợi: "+ result);
        System.out.println("Kết quả thực tế: "+ trueresult);
        driver.navigate().refresh();
	}
	@Test (priority = 2)
	public void emailwrongdomain() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test case 3: Email sai đuôi @");
		
		//Lấy dữ liệu từ file excel
		FileInputStream fis = new FileInputStream("E:\\TestData\\Logindata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(3);
        String email = row.getCell(0).getStringCellValue();
        String pass = row.getCell(1).getStringCellValue();
       String result = row.getCell(2).getStringCellValue();
        //Điền dữ liệu lên web ở trang email
        Thread.sleep(2000);
        driver.findElement(By.id("i0116")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).click();
        
        Thread.sleep(2000);
        String trueresult = driver.findElement(By.id("usernameError")).getText();
        System.out.println("Kết quả mong đợi: "+ result);
        System.out.println("Kết quả thực tế: "+ trueresult);
        driver.navigate().refresh();
	}
	@Test (priority = 3)
	public void truemailblankpass () throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test case 4: Email đúng để trống mật khẩu");
		
		//Lấy dữ liệu từ file excel
		FileInputStream fis = new FileInputStream("E:\\TestData\\Logindata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(4);
        String email = row.getCell(0).getStringCellValue();
       String result = row.getCell(2).getStringCellValue();
        //Điền dữ liệu lên web ở trang email
        Thread.sleep(2000);
        driver.findElement(By.id("i0116")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).click();
        

        //Điền dữ liệu lên web ở trang password
        Thread.sleep(5000);
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(2000);
        String trueresult = driver.findElement(By.id("i0118Error")).getText();
        System.out.println("Kết quả mong đợi: "+ result);
        System.out.println("Kết quả thực tế: "+ trueresult);
        driver.close();
	}
	
	
	
	@Test (priority = 5)
	public void taikhoanhople () throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test case 5: Thông tin đăng nhập hợp lệ");
		
		//Lấy dữ liệu từ file excel
		FileInputStream fis = new FileInputStream("E:\\TestData\\Logindata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(5);
        String pass = row.getCell(1).getStringCellValue();
        String email = row.getCell(0).getStringCellValue();

       //Điền dữ liệu lên web ở trang email
       Thread.sleep(2000);
       driver.findElement(By.id("i0116")).sendKeys(email);
       Thread.sleep(2000);
       driver.findElement(By.id("idSIButton9")).click();
       
       //Điền dữ liệu lên web ở trang password
       driver.findElement(By.id("i0118")).sendKeys(pass);
       Thread.sleep(2000);
       driver.findElement(By.id("idSIButton9")).click();
       Thread.sleep(2000);
       String trueresult= driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/h3/span")).getText();
       Thread.sleep(2000);
       System.out.println("Kết quả mong đợi: "+ email);
       System.out.println("Kết quả thực tế: "+ trueresult);

	}
}
