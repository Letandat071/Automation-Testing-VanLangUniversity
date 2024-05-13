package Intergration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThuLao_NguoiDung_ThinhGiang {
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
//	public void themuserthinhgiangcancel() throws InterruptedException {
//		System.out.println("Tạo người dùng chọn hủy và kiểm tra tại Thù lao GV:");
//		//Tab user
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
//		//add user
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
//		//Mã GV
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys("21102003");
//		//Tên  GV
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys("Hoàng Khánh");
//		//Email
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys("hoangkhanh@vanlanguni.vn");
//		//LoạiGV
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option[3]")).click();
//		//Role
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/select/option[3]")).click();
//		Thread.sleep(1000);
//		//Xác nhận 
//		driver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();
//		
//		
//		//Tab thù lao
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//		//Thù lao GV
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
//		
//		//Setup kỳ
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[1]/span[1]/span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys("997");
//		//Chọn kỳ 997
//		Thread.sleep(500);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[2]/ul/li")).click();
//		
//		
//		//Check Infor người dùng
//		Thread.sleep(6000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("21102003");
//		Thread.sleep(2000);
//		WebElement inforElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]"));
//		
//		String infString = inforElement.getText();
//		
//		System.out.println("Kết quả mong đợi: Không tìm thấy kết quả");
//		System.out.println("Kết quả thực tế: " + infString);
//		
//		
//	}
	
	
//	@Test (priority = 1)
//	public void themuserthinhgiangok() throws InterruptedException {
//		System.out.println("Tạo người dùng chọn lưu và kiểm tra tại Thù lao GV:");
//		//Tab user
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
//		//add user
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
//		//Mã GV
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys("21102003");
//		//Tên  GV
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys("Hoàng Khánh");
//		//Email
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys("hoangkhanh@vanlanguni.vn");
//		//LoạiGV
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option[3]")).click();
//		//Role
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/select/option[3]")).click();
//		Thread.sleep(1000);
//		//Xác nhận 
//		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();
//		
//		
//		//Tab thù lao
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//		//Thù lao GV
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
//		
//		//Setup kỳ
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[1]/span[1]/span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys("997");
//		//Chọn kỳ 997
//		Thread.sleep(500);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[2]/ul/li")).click();
//		
//		
//		//Check Infor người dùng
//		Thread.sleep(6000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("21102003");
//		Thread.sleep(2000);
//		WebElement inforElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]"));
//		
//		String infString = inforElement.getText();
//		
//		System.out.println("Kết quả mong đợi: 1 21102003 Hoàng Khánh.....");
//		System.out.println("Kết quả thực tế: " + infString);
//		
//		
//	}
	
	
//	@Test (priority = 2)
//	public void fixserthinhgiangcancel() throws InterruptedException {
//		System.out.println("Sửa người dùng chọn huỷ và kiểm tra tại Thù lao GV:");
//		//Tab user
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
//		//search user
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("21102003");
//		//Click Icont Sửa 
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr[1]/td[7]/a[1]")).click();
//		//Tên  GV
//		Thread.sleep(1000);
//		driver.findElement(By.id("full_name")).sendKeys("Hoàng Khánh Ver2");
//		//Email
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys("hoangkhanhver2@vanlanguni.vn");
//		//LoạiGV
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option[3]")).click();
//		//Role
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/select/option[2]")).click();
//		Thread.sleep(1000);
//		//Xác nhận 
//		driver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();
//		
//		
//		//Tab thù lao
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//		//Thù lao GV
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
//		
//		//Setup kỳ
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[1]/span[1]/span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys("997");
//		//Chọn kỳ 997
//		Thread.sleep(500);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[2]/ul/li")).click();
//		
//		
//		//Check Infor người dùng
//		Thread.sleep(6000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("21102003");
//		Thread.sleep(2000);
//		WebElement inforElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]"));
//		
//		String infString = inforElement.getText();
//		
//		System.out.println("Kết quả mong đợi: 1 21102003 Hoàng Khánh.....");
//		System.out.println("Kết quả thực tế: " + infString);
//		driver.close();
//		
//	}
	
//	@Test (priority = 3)
//	public void fixserthinhgiangok() throws InterruptedException {
//		System.out.println("Sửa người dùng chọn lưu và kiểm tra tại Thù lao GV:");
//		//Tab user
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
//		//search user
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("21102003");
//		//Click Icont Sửa 
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr[1]/td[7]/a[1]")).click();
//		//Tên  GV
//		Thread.sleep(1000);
//		driver.findElement(By.id("full_name")).clear();
//		driver.findElement(By.id("full_name")).sendKeys("Hoàng Khánh Ver2");
//		//LoạiGV
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option[3]")).click();
//		//Role
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/select/option[2]")).click();
//		Thread.sleep(1000);
//		//Xác nhận 
//		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();
//		
//		
//		//Tab thù lao
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//		//Thù lao GV
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
//		
//		//Setup kỳ
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[1]/span[1]/span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys("997");
//		//Chọn kỳ 997
//		Thread.sleep(500);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[2]/ul/li")).click();
//		
//		
//		//Check Infor người dùng
//		Thread.sleep(6000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("21102003");
//		Thread.sleep(2000);
//		WebElement inforElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]"));
//		
//		String infString = inforElement.getText();
//		
//		System.out.println("Kết quả mong đợi: 1 21102003 Hoàng Khánh ver2.....");
//		System.out.println("Kết quả thực tế: " + infString);
//		driver.close();
//		
//	}
	
	
//	@Test (priority = 4)
//	public void deleteuserthinhgiangcancel() throws InterruptedException {
//		System.out.println("Xóa người dùng chọn hủy và kiểm tra tại Thù lao GV:");
//		//Tab user
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
//		//search user
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("21102003");
//		//Click Icont Sửa 
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[1]/td[7]/a[2]")).click();
//		Thread.sleep(1000);
//		//Xác nhận 
//		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")).click();
//		
//		
//		//Tab thù lao
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
//		//Thù lao GV
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
//		
//		//Setup kỳ
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[1]/span[1]/span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys("997");
//		//Chọn kỳ 997
//		Thread.sleep(500);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[2]/ul/li")).click();
//		
//		
//		//Check Infor người dùng
//		Thread.sleep(6000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("21102003");
//		Thread.sleep(2000);
//		WebElement inforElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]"));
//		
//		String infString = inforElement.getText();
//		
//		System.out.println("Kết quả mong đợi: 1 21102003 Hoàng Khánh ver2.....");
//		System.out.println("Kết quả thực tế: " + infString);
//		driver.close();
//		
//	}
	
	@Test (priority = 5)
	public void deleteuserthinhgiangok() throws InterruptedException {
		System.out.println("Xóa người dùng chọn xóa và kiểm tra tại Thù lao GV:");
		//Tab user
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		//search user
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("21102003");
		//Click Icont Sửa 
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[1]/td[7]/a[2]")).click();
		Thread.sleep(1000);
		//Xác nhận 
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		
		
		//Tab thù lao
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
		//Thù lao GV
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
		
		//Setup kỳ
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[1]/span[1]/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys("997");
		//Chọn kỳ 997
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[2]/ul/li")).click();
		
		
		//Check Infor người dùng
		Thread.sleep(6000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys("21102003");
		Thread.sleep(2000);
		WebElement inforElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]"));
		
		String infString = inforElement.getText();
		
		System.out.println("Kết quả mong đợi: Không tìm thấy kết quả");
		System.out.println("Kết quả thực tế: " + infString);
		driver.close();
		
	}
}
