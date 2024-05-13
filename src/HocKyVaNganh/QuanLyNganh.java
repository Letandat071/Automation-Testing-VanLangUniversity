package HocKy_Nganh;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.hslf.record.Sound;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.tsp.TSPUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuanLyNganh {
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
	public void CreatMajor() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 1: Tạo ngành đúng và đủ dữ liệu!!");
		WebElement tabHKN = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a/span"));
		tabHKN.click();
		Thread.sleep(2000);
		WebElement majorTab = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a"));
		majorTab.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Marjor.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String maNganh = row.getCell(0).getStringCellValue();
        String tenNganh = row.getCell(1).getStringCellValue();
        String standfString = row.getCell(2).getStringCellValue();
        
		//Nhập thông tin ngành
        
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys(maNganh);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(tenNganh);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys(standfString);
		int ctdt = random.nextInt(2,4);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option["+ctdt+"]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		//Lấy thông báo
		Thread.sleep(800);
		WebElement messElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		String ketquaMongdoi = "Lưu thành công";
		System.out.println("Kết quả mong đợi: "+ketquaMongdoi);
		System.out.println("Kết quả thực tế: "+ messElement.getText());
		
	}
	
	
	
	@Test (priority = 1)
	public void CreatNocode() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Tesace 2: Tạo ngành nhưng không điền mã ngành");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Marjor.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(2);

        String tenNganh = row.getCell(1).getStringCellValue();
        String standfString = row.getCell(2).getStringCellValue();
        
		//Nhập thông tin ngành
        
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(tenNganh);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys(standfString);
		int ctdt = random.nextInt(2,4);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option["+ctdt+"]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(1000);
		WebElement errorElement = driver.findElement(By.id("id-error"));
		
		String ketquamongdoi = "Bạn chưa nhập mã ngành";
		Thread.sleep(2000);
		
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + errorElement.getText());
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
	}
	
	@Test (priority = 2)
	public void creatNoNam() throws IOException, InterruptedException {
		Thread.sleep(2000);
		System.out.println("Tesace 3: Tạo ngành nhưng không điền tên ngành");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Marjor.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(3);
        String maNganh = row.getCell(0).getStringCellValue();
        String standfString = row.getCell(2).getStringCellValue();
        
		//Nhập thông tin ngành
        
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys(maNganh);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys(standfString);
		int ctdt = random.nextInt(2,4);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option["+ctdt+"]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(1000);
		WebElement errorElement = driver.findElement(By.id("name-error"));
		
		String ketquamongdoi = "Bạn chưa nhập tên ngành";
		Thread.sleep(2000);
		
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + errorElement.getText());
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
	}
	
	@Test (priority = 3)
	public void creatNoStanNam() throws IOException, InterruptedException {
		Thread.sleep(2000);
		System.out.println("Tesace 4: Tạo ngành nhưng không điền tên viết tắt");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Marjor.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(4);
        String maNganh = row.getCell(0).getStringCellValue();
        String tenNganh = row.getCell(1).getStringCellValue();
 
        
		//Nhập thông tin ngành
        
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys(maNganh);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(tenNganh);
	
		int ctdt = random.nextInt(2,4);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option["+ctdt+"]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(1000);
		WebElement errorElement = driver.findElement(By.id("abbreviation-error"));
		
		String ketquamongdoi = "Bạn chưa nhập tên viết tắt của ngành";
		Thread.sleep(2000);
		
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + errorElement.getText());
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
	}
	
	@Test (priority = 4)
	public void CreatonlyCode() throws IOException, InterruptedException {
		Thread.sleep(2000);
		System.out.println("Tesace 5: Tạo ngành chỉ điền mã");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Marjor.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(5);
        String maNganh = row.getCell(0).getStringCellValue();
        
		//Nhập thông tin ngành
        
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys(maNganh);
	
		int ctdt = random.nextInt(2,4);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option["+ctdt+"]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(1000);
		WebElement errorElement = driver.findElement(By.id("abbreviation-error"));
		WebElement errorElement2 = driver.findElement(By.id("name-error"));
		String ketquamongdoi = "Bạn chưa nhập tên ngành, Bạn chưa nhập tên viết tắt của ngành";
		Thread.sleep(2000);
		
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + errorElement2.getText() +", "+ errorElement.getText());
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
	}
	
	@Test (priority = 5)
	public void Creatonlyname() throws IOException, InterruptedException {
		Thread.sleep(2000);
		System.out.println("Tesace 6: Tạo ngành chỉ điền tên ngành");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Marjor.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(6);
 String tenNganh = row.getCell(1).getStringCellValue();
        
		//Nhập thông tin ngành
        
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(tenNganh);
	
		int ctdt = random.nextInt(2,4);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option["+ctdt+"]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(1000);
		WebElement errorElement = driver.findElement(By.id("abbreviation-error"));
		WebElement errorElement2 = driver.findElement(By.id("id-error"));
		String ketquamongdoi = "Bạn chưa nhập mã ngành, Bạn chưa nhập tên viết tắt của ngành";
		Thread.sleep(2000);
		
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + errorElement2.getText() +", "+ errorElement.getText());
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
       
	}
	
	@Test (priority = 6)
	public void Creatonlystand() throws IOException, InterruptedException {
		Thread.sleep(2000);
		System.out.println("Tesace 7: Tạo ngành chỉ điền tên viết tắt");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Marjor.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(7);
       
        String standfString = row.getCell(2).getStringCellValue();
        
		//Nhập thông tin ngành
        
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys(standfString);
		int ctdt = random.nextInt(2,4);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option["+ctdt+"]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(1000);
		WebElement errorElement = driver.findElement(By.id("name-error"));
		WebElement errorElement2 = driver.findElement(By.id("id-error"));
		String ketquamongdoi = "Bạn chưa nhập mã ngành, Bạn chưa nhập tên ngành";
		Thread.sleep(2000);
		
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + errorElement2.getText() +", "+ errorElement.getText());
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
       
	}
	
	@Test (priority = 7)
	public void Creatonlyct() throws IOException, InterruptedException {
		Thread.sleep(2000);
		System.out.println("Tesace 8: Tạo ngành chỉ điền CTDT");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
		        
		//Nhập thông tin ngành
        
		Thread.sleep(5000);
		
		int ctdt = random.nextInt(2,4);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option["+ctdt+"]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(1000);
		WebElement errorElement = driver.findElement(By.id("name-error"));
		WebElement errorElement2 = driver.findElement(By.id("id-error"));
		WebElement errorElement3 = driver.findElement(By.id("abbreviation-error"));
		String ketquamongdoi = "Bạn chưa nhập mã ngành, Bạn chưa nhập tên ngành, Bạn chưa nhập tên viết tắt của ngành";
		Thread.sleep(2000);
		
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + errorElement2.getText() +", "+ errorElement.getText()+", "+ errorElement3.getText());
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
       
	}
	
	@Test (priority = 8)
	public void Creatnotthing() throws IOException, InterruptedException {
		Thread.sleep(2000);
		System.out.println("Tesace 9: Tạo ngành không điền gì");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();        
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(1000);
		WebElement errorElement = driver.findElement(By.id("name-error"));
		WebElement errorElement2 = driver.findElement(By.id("id-error"));
		WebElement errorElement3 = driver.findElement(By.id("abbreviation-error"));
		WebElement errorElement4 = driver.findElement(By.id("program_type-error"));
		String ketquamongdoi = "Bạn chưa nhập mã ngành, Bạn chưa nhập tên ngành, Bạn chưa nhập tên viết tắt của ngành, Bạn chưa chọn CTĐT";
		Thread.sleep(2000);
		
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + errorElement2.getText() +", "+ errorElement.getText()+", "+ errorElement3.getText()+", "+errorElement4.getText());
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
       
	}
	@Test (priority = 9)
	public void CreatMajorDouble() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 10: Tạo ngành đúng và đủ dữ liệu đã tồn tại!!");
		WebElement tabHKN = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a/span"));
		tabHKN.click();
		Thread.sleep(2000);
		WebElement majorTab = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a"));
		majorTab.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Marjor.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String maNganh = row.getCell(0).getStringCellValue();
        String tenNganh = row.getCell(1).getStringCellValue();
        String standfString = row.getCell(2).getStringCellValue();
        
		//Nhập thông tin ngành
        
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys(maNganh);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(tenNganh);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys(standfString);
		int ctdt = random.nextInt(2,4);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option["+ctdt+"]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		//Lấy thông báo
		Thread.sleep(2000);
		WebElement messElement = driver.findElement(By.id("swal2-html-container"));
		String ketquaMongdoi = "Mã ngành này đã tồn tại!";
		System.out.println("Kết quả mong đợi: "+ketquaMongdoi);
		System.out.println("Kết quả thực tế: "+ messElement.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
	}
	
	
	@Test (priority = 10)
	public void searchMajorCode() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 11: Tìm ngành theo mã ngành");
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Marjor.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String maNganh = row.getCell(0).getStringCellValue();

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(maNganh);
		
		WebElement tenNganhElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[2]"));
		String ketquamongdoi = "492003";
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: "+ tenNganhElement.getText());
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
		
	} 
	@Test (priority = 11)
	public void searchMajorName() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 12: Tìm ngành theo tên ngành");
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Marjor.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String tenNganh = row.getCell(1).getStringCellValue();

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(tenNganh);
		
		WebElement tenNganhElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[3]"));
		String ketquamongdoi = "Ngành 231378928372983";
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: "+ tenNganhElement.getText());
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
		
	}
	
	@Test (priority = 12)
	public void searchMajorStand() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Test Case 13: Tìm ngành theo tên viết tắt");
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\Marjor.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String standString = row.getCell(2).getStringCellValue();

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(standString);
		
		WebElement tenNganhElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[4]"));
		String ketquamongdoi = "TEGA1";
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: "+ tenNganhElement.getText());
		
	}
	
	@Test (priority = 13)
	public void editmajor() throws InterruptedException, IOException {
		System.out.println("Test Case 14: Sửa ngành đúng và đủ thông tin");
		Thread.sleep(2000);
		WebElement editbutton=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editbutton);
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\marjorupdate.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String name = row.getCell(0).getStringCellValue();
        String standString = row.getCell(1).getStringCellValue();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(name);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).clear();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys(standString);
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(500);
		WebElement messElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		String ketquamongdoi = "Cập nhật thành công";
		System.out.println("Kết quả mong đợi: "+ketquamongdoi);
		System.out.println("Kết quả thực tế: " + messElement.getText());
		
		
	}
	
	@Test (priority = 14)
	public void editmajornoNamer() throws InterruptedException, IOException {
		System.out.println("Test Case 15: Sửa tên viết tắt ngành không sửa tên ngành");
		Thread.sleep(2000);
		WebElement editbutton=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editbutton);
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\marjorupdate.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(2);
        String standString = row.getCell(1).getStringCellValue();
        
		Thread.sleep(5000);

		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).clear();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys(standString);
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(500);
		WebElement messElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		String ketquamongdoi = "Cập nhật thành công";
		System.out.println("Kết quả mong đợi: "+ketquamongdoi);
		System.out.println("Kết quả thực tế: " + messElement.getText());
		
		
	}
	
	@Test (priority = 15)
	public void editmajornoStand() throws InterruptedException, IOException {
		System.out.println("Test Case 16: Sửa tên ngành không sửa tên viết tắt");
		Thread.sleep(2000);
		WebElement editbutton=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editbutton);
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\marjorupdate.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(3);
        String name = row.getCell(0).getStringCellValue();
        
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(name);
		
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(500);
		WebElement messElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		String ketquamongdoi = "Cập nhật thành công";
		System.out.println("Kết quả mong đợi: "+ketquamongdoi);
		System.out.println("Kết quả thực tế: " + messElement.getText());
		
		
	}
	
	@Test (priority = 16)
	public void editmajordlname() throws InterruptedException, IOException {
		System.out.println("Test Case 17: Xóa Tên ngành giữ lại tên viết tắt");
		Thread.sleep(2000);
		WebElement editbutton=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editbutton);
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\marjorupdate.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String name = row.getCell(0).getStringCellValue();
        String standString = row.getCell(1).getStringCellValue();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();

		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(500);
		WebElement messElement = driver.findElement(By.id("name-error"));
		String ketquamongdoi = "Bạn chưa nhập tên ngành";
		System.out.println("Kết quả mong đợi: "+ketquamongdoi);
		System.out.println("Kết quả thực tế: " + messElement.getText());
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
		
		
	}
	
	@Test (priority = 17)
	public void editmajordlstand() throws InterruptedException, IOException {
		System.out.println("Test Case 18: Xóa Tên viết tắt giữ lại tên ngành");
		Thread.sleep(2000);
		WebElement editbutton=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editbutton);
		
		FileInputStream fis = new FileInputStream("E:\\TestData\\marjorupdate.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String name = row.getCell(0).getStringCellValue();
        String standString = row.getCell(1).getStringCellValue();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).clear();

		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
		
		Thread.sleep(500);
		WebElement messElement = driver.findElement(By.id("abbreviation-error"));
		String ketquamongdoi = "Bạn chưa nhập tên viết tắt của ngành";
		System.out.println("Kết quả mong đợi: "+ketquamongdoi);
		System.out.println("Kết quả thực tế: " + messElement.getText());
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
		
		
	}
	
	
	@Test (priority = 18)
	public void CanldeleteMajor() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test Case 19: Người dùng chọn xóa nhưng hủy");
		WebElement removebutton=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", removebutton);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")).click();
		
		Thread.sleep(800);
		WebElement messElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr"));
		WebElement ctdtElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[5]"));
		String ketquamongdoi = "1 492003 Ngành new Update 2 TEGA1 Update 2 " + ctdtElement.getText();
		System.out.println("Kết quả mong đợi: " + ketquamongdoi );
		System.out.println("Kết quả thực tế: " + messElement.getText());
	
	}
	
	@Test (priority = 19)
	public void deleteMajor() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test Case 20: Người dùng chọn xóa và xác nhận");
		WebElement removebutton=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", removebutton);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		
		Thread.sleep(800);
		WebElement messElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		String ketquamongdoi = "Xoá thành công!";
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tết: "+ messElement.getText());
		
		driver.close();
	}
	
	
}
