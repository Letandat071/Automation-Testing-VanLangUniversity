package Intergration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CapBac_CapBacGV {
	static WebDriver driver;
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
 
	}
//	@Test (priority = 0)
//	public void themcbwr() throws InterruptedException {
//		System.out.println("Tạo Cấp bậc và kiểm tra tại CBGV Cancel");
//		Thread.sleep(2000);
//		//chọn tab thống kê
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//		//Chọn tab HHHV
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[1]/a")).click();
//		//Chọn tab Cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
//		//Nút thêm cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
//		//Chọn Ngành 
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div/span/span[1]/span/span[1]")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]/option[83]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div/span/span[1]/span/span[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys("ZliveTest");
//		
//		Thread.sleep(2000);
//		//Xác nhận 
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[1]")).click();
//		
//		
//		//Chọn vào tab cấp bậc GV
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		//Chọn nút chỉnh sửa
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[5]/a")).click();
//		//Click Tab 
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[1]/span[1]/span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[1]/input")).sendKeys("ZliveTest");
//		Thread.sleep(2000);
//		WebElement ketquathuctElement = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li"));
//		
//		String thongbaoString = ketquathuctElement.getText();
//		System.out.println("Kết quả mong đợi: Không tìm thấy kết quả");
//		System.out.println("Kết quả thực tế: " + thongbaoString);
//		driver.navigate().refresh();
//	}
	
//	@Test (priority = 0)
//	public void themcbok() throws InterruptedException {
//		System.out.println("Tạo Cấp bậc và kiểm tra tại CBGV OK");
//		Thread.sleep(2000);
//		//chọn tab thống kê
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//		//Chọn tab HHHV
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[1]/a")).click();
//		//Chọn tab Cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
//		//Nút thêm cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
//		//Chọn Ngành 
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div/span/span[1]/span/span[1]")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]/option[83]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div/span/span[1]/span/span[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys("ZliveTest");
//		
//		Thread.sleep(2000);
//		//Xác nhận 
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//		
//		
//		//Chọn vào tab cấp bậc GV
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		//Chọn nút chỉnh sửa
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[5]/a")).click();
//		//Click Tab 
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[1]/span[1]/span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[1]/input")).sendKeys("ZliveTest");
//		Thread.sleep(2000);
//		WebElement ketquathuctElement = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li"));
//		
//		String thongbaoString = ketquathuctElement.getText();
//		System.out.println("Kết quả mong đợi: ZliveTest");
//		System.out.println("Kết quả thực tế: " + thongbaoString);
//		
//		driver.navigate().refresh();
//	}
//	
//	@Test (priority = 2)
//	public void themcbok() throws InterruptedException {
//		System.out.println("Sửa Cấp bậc và kiểm tra tại CBGV Cancel");
//		Thread.sleep(2000);
//		//chọn tab thống kê
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//		//Chọn tab HHHV
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[1]/a")).click();
//		//Chọn tab Cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
//		//Nút tìm cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("ZliveTest");
//		//Chọn Icont Chỉnh sửa
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[2]/td[2]/a[1]")).click();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div/span/span[1]/span/span[1]")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]/option[2]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div/span/span[1]/span/span[1]")).click();
//
//		
//		Thread.sleep(2000);
//		//Xác nhận 
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[1]")).click();
//		
//		
//		//Chọn vào tab cấp bậc GV
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		//Chọn nút chỉnh sửa
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[5]/a")).click();
//		//Click Tab 
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[1]/span[1]/span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[1]/input")).sendKeys("ZliveTest");
//		Thread.sleep(2000);
//		WebElement ketquathuctElement = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li"));
//		
//		String thongbaoString = ketquathuctElement.getText();
//		System.out.println("Kết quả mong đợi: ZliveTest");
//		System.out.println("Kết quả thực tế: " + thongbaoString);
//		
//		driver.navigate().refresh();
//	}
	
	
//	@Test (priority = 3)
//	public void themcbok() throws InterruptedException {
//		System.out.println("Sửa Cấp bậc và kiểm tra tại CBGV OK");
//		Thread.sleep(2000);
//		//chọn tab thống kê
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//		//Chọn tab HHHV
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[1]/a")).click();
//		//Chọn tab Cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
//		//Nút tìm cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("ZliveTest");
//		//Chọn Icont Chỉnh sửa
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[2]/td[2]/a[1]")).click();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div/span/span[1]/span/span[1]")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//*[@id=\"academic_degree_id\"]/option[2]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/div/span/span[1]/span/span[1]")).click();
//
//		
//		Thread.sleep(2000);
//		//Xác nhận 
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/button[2]")).click();
//		
//		
//		//Chọn vào tab cấp bậc GV
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		//Chọn nút chỉnh sửa
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[5]/a")).click();
//		//Click Tab 
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[1]/span[1]/span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[1]/input")).sendKeys("ZliveTest");
//		Thread.sleep(2000);
//		WebElement ketquathuctElement = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li"));
//		
//		String thongbaoString = ketquathuctElement.getText();
//		System.out.println("Kết quả mong đợi: ZliveTest");
//		System.out.println("Kết quả thực tế: " + thongbaoString);
//		
//		driver.navigate().refresh();
//	}
	
	
//	@Test (priority = 4)
//	public void themcbok() throws InterruptedException {
//		System.out.println("Xóa Cấp bậc và kiểm tra tại CBGV Cancel");
//		Thread.sleep(2000);
//		//chọn tab thống kê
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//		//Chọn tab HHHV
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[1]/a")).click();
//		//Chọn tab Cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
//		//Nút tìm cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("ZliveTest");
//		//Chọn Icont Xóa
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[2]/td[2]/a[2]")).click();
//		
//		//Xác nhận
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")).click();
//
//		
//		
//		//Chọn vào tab cấp bậc GV
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		//Chọn nút chỉnh sửa
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[5]/a")).click();
//		//Click Tab 
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[1]/span[1]/span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[1]/input")).sendKeys("ZliveTest");
//		Thread.sleep(2000);
//		WebElement ketquathuctElement = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li"));
//		
//		String thongbaoString = ketquathuctElement.getText();
//		System.out.println("Kết quả mong đợi: ZliveTest");
//		System.out.println("Kết quả thực tế: " + thongbaoString);
//		
//		driver.navigate().refresh();
//	}
//	
//	@Test (priority = 4)
//	public void themcbok() throws InterruptedException {
//		System.out.println("Xóa Cấp bậc và kiểm tra tại CBGV Oke");
//		Thread.sleep(2000);
//		//chọn tab thống kê
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//		//Chọn tab HHHV
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[1]/a")).click();
//		//Chọn tab Cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
//		//Nút tìm cấp bậc
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("ZliveTest");
//		//Chọn Icont Xóa
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[2]/td[2]/a[2]")).click();
//		
//		//Xác nhận
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
//
//		
//		Thread.sleep(2000);
//		//Chọn vào tab cấp bậc GV
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		//Chọn nút chỉnh sửa
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[5]/a")).click();
//		//Click Tab 
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[1]/span[1]/span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[1]/input")).sendKeys("ZliveTest");
//		Thread.sleep(2000);
//		WebElement ketquathuctElement = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li"));
//		
//		String thongbaoString = ketquathuctElement.getText();
//		System.out.println("Kết quả mong đợi: Không tìm thấy kết quả");
//		System.out.println("Kết quả thực tế: " + thongbaoString);
//		
//		driver.navigate().refresh();
//	}
}
