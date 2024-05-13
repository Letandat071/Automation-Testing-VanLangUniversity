package LichGiangDay;

import java.util.Iterator;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LichGiangDay {
	public WebDriver driver;
	Random random = new Random();
	@BeforeTest
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\Phan_Hoang_Khang\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();

	}
		
//	@Test(priority = 0)
//	public void LichGiangDay1() throws InterruptedException {
//	    System.out.println("Testcase 1: xem một giảng viên");
//	    Thread.sleep(2000);
//	    // Tab Thống kê 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
//	    Thread.sleep(1000);
//	    // Lịch giảng dạy
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[5]/a")).click();
//	    Thread.sleep(2000);
//	    // Học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys("997");
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    // Tuần
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span")).click();
//	    int sotuan = random.nextInt(1, 17);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[" + sotuan + "]")).click();
//	    // Chọn nhiều GV để xem
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//*[@id=\"timetableStatisticsDiv\"]/div[2]/div[1]/div[3]/span/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    WebElement tenGV = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/span/ul/li[2]"));
//	    tenGV.click();
//	    String tenMongdoiString = tenGV.getText();
//	    WebElement tenGV3 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/span/ul/li[3]"));
//	    tenGV3.click();
//	    String tenMongdoiString3 = tenGV3.getText();
//	    Thread.sleep(2000);
//	    WebElement ketquaElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[2]/td[1]"));
//	    String ketquanthucteString = ketquaElement.getText();
//	    Thread.sleep(2000);
//	    WebElement ketquaElement2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[1]"));
//	    String ketquanthucteString2 = ketquaElement2.getText();
//	    System.out.println("Kết quả mong đợi: " + tenMongdoiString + tenMongdoiString3);
//	    System.out.println("Kết quả thực tế: " + ketquanthucteString + ketquanthucteString2);
//	}

	
	
//	@Test(priority = 1)
//	public void LichGiangDay2() throws InterruptedException {
//	    System.out.println("Testcase 2: xem nhiều giảng viên");
//	    Thread.sleep(2000);
//	    // Tab Thống kê 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
//	    Thread.sleep(1000);
//	    // Lịch giảng dạy
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[5]/a")).click();
//	    Thread.sleep(2000);
//	    // Học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys("997");
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();    
//	    // Tuần
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span")).click();
//	    int sotuan = random.nextInt(1, 17);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[" + sotuan + "]")).click();
//	    // Chọn nhiều GV để xem
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//*[@id=\"timetableStatisticsDiv\"]/div[2]/div[1]/div[3]/span/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    WebElement tenGV = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/span/ul/li[2]"));
//	    tenGV.click();
//	    String tenMongdoiString = tenGV.getText();
//	    WebElement tenGV3 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/span/ul/li[3]"));
//	    tenGV3.click();
//	    String tenMongdoiString3 = tenGV3.getText();
//	    Thread.sleep(2000);
//	    WebElement ketquaElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[2]/td[1]"));
//	    String ketquanthucteString = ketquaElement.getText();
//	    Thread.sleep(2000);
//	    WebElement ketquaElement2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[1]"));
//	    String ketquanthucteString2 = ketquaElement2.getText();
//	    System.out.println("Kết quả mong đợi: " + tenMongdoiString + " " + tenMongdoiString3);
//	    System.out.println("Kết quả thực tế: " + ketquanthucteString + " " + ketquanthucteString2);
//	}

//	
//	@Test(priority = 2)
//	public void LichGiangDay3() throws InterruptedException {
//	    System.out.println("Testcase 3: xem tất cả giảng viên");
//	    Thread.sleep(2000);
//	    // Tab Thống kê 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
//	    Thread.sleep(1000);
//	    // Lịch giảng dạy
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[5]/a")).click();
//	    Thread.sleep(2000);
//	    // Học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys("997");
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
//	    // Tuần
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span")).click();
//	    int sotuan = random.nextInt(1, 17);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[" + sotuan + "]")).click();
//	    // Chọn nhiều GV để xem
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//*[@id=\"timetableStatisticsDiv\"]/div[2]/div[1]/div[3]/span/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    WebElement tenGV = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/div/button[1]"));
//	    tenGV.click();
//	    Thread.sleep(8000);
//	    WebElement selectElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/select"));
//	    // Khởi tạo đối tượng Select
//	    Select select = new Select(selectElement);
//	    // Lấy danh sách các option
//	    java.util.List<WebElement> options = select.getOptions();
//	    // Đếm số lượng option
//	    int numberOfOptions = options.size() + 1;
//	    Thread.sleep(8000);
//	    WebElement ketquacuoiElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span/span[1]/span/ul/li[" + numberOfOptions + "]/input"));
//	    String ketquaString = ketquacuoiElement.getAttribute("placeholder");
//	    System.out.println("Kết quả mong đợi: Đã chọn " + (numberOfOptions - 1) + " Giảng viên ");
//	    System.out.println("Kết quả thực tế: " + ketquaString);
//	}

//	
//	@Test(priority = 3)
//	public void LichGiangDay4() throws InterruptedException {
//	    System.out.println("Testcase 4: Lọc giảng viên CH");
//	    Thread.sleep(2000);
//	    //Tab Thống kê 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
//	    Thread.sleep(1000);
//	    //Lich giang day
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[5]/a")).click();
//	    Thread.sleep(2000);
//	    //Học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys("997");
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();		
//	    // Tuần
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span")).click();
//	    int sotuan = random.nextInt(1,17);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li["+sotuan+"]")).click();		
//	    //Chọn nhiều GV để xem
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//*[@id=\"timetableStatisticsDiv\"]/div[2]/div[1]/div[3]/span/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    WebElement tenGV =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/div/button[1]"));
//	    tenGV.click();
//	    //Chọn lọc theo GV
//	    Thread.sleep(4000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    //Get loại
//	    WebElement loaiGV = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/span/ul/li[1]"));
//	    loaiGV.click();
//	    String ketquaString = loaiGV.getText();
//	    //Check
//	    Thread.sleep(4000);
//	    WebElement checkElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[1]"));		
//	    if (checkElement.getAttribute("data-type").equals("CH")) {
//	        System.out.println("Kết quả mong đợi: " + ketquaString);
//	        System.out.println("Kết quả thực tế: Cơ hữu");
//	    }
//	    else {
//	        System.out.println("Chuyển thất bại!!");
//	    }
//	}

//	
//	@Test(priority = 4)
//	public void LichGiangDay5() throws InterruptedException {
//	    System.out.println("Testcase 5: lọc giảng viên thỉnh giảng");
//	    Thread.sleep(2000);
//	    //Tab Thống kê 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
//	    Thread.sleep(1000);
//	    //Lich giang day
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[5]/a")).click();
//	    Thread.sleep(2000);
//	    //Học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys("997");
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();		
//	    // Tuần
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span")).click();
//	    int sotuan = random.nextInt(1,17);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li["+sotuan+"]")).click();		
//	    //Chọn nhiều GV để xem
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//*[@id=\"timetableStatisticsDiv\"]/div[2]/div[1]/div[3]/span/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    WebElement tenGV =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/div/button[1]"));
//	    tenGV.click();
//	    //Chọn lọc theo GV
//	    Thread.sleep(4000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    //Get loại
//	    WebElement loaiGV = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/span/ul/li[3]")); // Chọn Thỉnh giảng (TG)
//	    loaiGV.click();
//	    String ketquaString = loaiGV.getText();
//	    //Check
//	    Thread.sleep(4000);
//	    WebElement checkElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[1]"));		
//	    if (checkElement.getAttribute("data-type").equals("TG")) {
//	        System.out.println("Kết quả mong đợi: " + ketquaString);
//	        System.out.println("Kết quả thực tế: Thỉnh Giảng");
//	    }
//	    else {
//	        System.out.println("Chuyển thất bại!!");
//	    }
//	}

//	
//	@Test(priority = 5)
//	public void LichGiangDay6() throws InterruptedException {
//	    System.out.println("Testcase 6: hide ca giảng");
//	    Thread.sleep(2000);
//	    //Tab Thống kê 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
//	    Thread.sleep(1000);
//	    //Lich giang day
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[5]/a")).click();
//	    Thread.sleep(2000);
//	    //Học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys("997");
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();		
//	    // Tuần
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span")).click();
//	    int sotuan = random.nextInt(1,17);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li["+sotuan+"]")).click();		
//	    //Chọn nhiều GV để xem
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//*[@id=\"timetableStatisticsDiv\"]/div[2]/div[1]/div[3]/span/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    WebElement tenGV =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/div/button[1]"));
//	    tenGV.click();
//	    //Chọn lọc theo ca giảng
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span")).click();
//	    for(int i = 1; i <=5; i++) {
//	        Thread.sleep(2000);
//	        WebElement cagiangElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/span/ul/li["+i+"]"));
//	        System.out.println("Đã ẩn: " + cagiangElement.getText());
//	        cagiangElement.click();
//	    }
//	}

//	
//	@Test(priority = 6)
//	public void LichGiangDay7() throws InterruptedException {
//	    System.out.println("Testcase 7: hide ca giảng");
//	    Thread.sleep(2000);
//	    //Tab Thống kê 
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
//	    Thread.sleep(1000);
//	    //Lich giang day
//	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[5]/a")).click();
//	    Thread.sleep(2000);
//	    //Học kỳ
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys("997");
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();		
//	    // Tuần
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span")).click();
//	    int sotuan = random.nextInt(1,17);
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li["+sotuan+"]")).click();		
//	    //Chọn nhiều GV để xem
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//*[@id=\"timetableStatisticsDiv\"]/div[2]/div[1]/div[3]/span/span[1]/span")).click();
//	    Thread.sleep(2000);
//	    WebElement tenGV =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/div/button[1]"));
//	    tenGV.click();
//	    //Chọn lọc theo ca giảng
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span")).click();
//	    for(int i = 1; i <=5; i++) {
//	        Thread.sleep(2000);
//	        WebElement cagiangElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/span/ul/li["+i+"]"));
//	        cagiangElement.click();
//	    }		
//	    for(int i = 1; i <=5; i++) {
//	        Thread.sleep(2000);
//	        WebElement cagiangElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/span/ul/li["+i+"]"));
//	        System.out.println("Đã hiện: " + cagiangElement.getText());
//	        cagiangElement.click();
//	    }
//	}

//	
//	@Test (priority = 7)
//	public void LichGiangDay8() throws InterruptedException {
//		System.out.println("Testcase 8: hide thứ ca giảng");
//		Thread.sleep(2000);
//		//Tab Thống kê 
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
//		Thread.sleep(1000);
//		//Lich giang day
//		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[5]/a")).click();
//		Thread.sleep(2000);
//		//Học kỳ
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys("997");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();	
//		// Tuần
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span")).click();
//		int sotuan = random.nextInt(1,17);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li["+sotuan+"]")).click();		
//		//Chọn nhiều GV để xem
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"timetableStatisticsDiv\"]/div[2]/div[1]/div[3]/span/span[1]/span")).click();
//		Thread.sleep(2000);
//		WebElement tenGV =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/div/button[1]"));
//		tenGV.click();
//		//Chọn lọc theo ca giảng
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[6]/span[1]/span[1]/span")).click();
//		for(int i = 1; i <=8; i++) {
//			Thread.sleep(2000);
//			WebElement cagiangElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[6]/span[1]/span[1]/span/ul/li["+i+"]"));
//			System.out.println("Đã Ẩn: " + cagiangElement.getText());
//			cagiangElement.click();
//		}
//		
//	}
	@Test (priority = 8)
	public void LichGiangDay9() throws InterruptedException {
		System.out.println("Testcase 9: hide thứ ca giảng");
		Thread.sleep(2000);
		//Tab Thống kê 
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
		Thread.sleep(1000);
		//Lich giang day
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[5]/a")).click();
		Thread.sleep(2000);
		//Học kỳ
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input")).sendKeys("997");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();	
		// Tuần
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span/span[1]/span")).click();
		int sotuan = random.nextInt(1,17);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li["+sotuan+"]")).click();	
		//Chọn nhiều GV để xem
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"timetableStatisticsDiv\"]/div[2]/div[1]/div[3]/span/span[1]/span")).click();
		Thread.sleep(2000);
		WebElement tenGV =driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/div/button[1]"));
		tenGV.click();
		//Chọn lọc theo ca giảng
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[6]/span[1]/span[1]/span")).click();
		for(int i = 1; i <=8; i++) {
			Thread.sleep(2000);
			WebElement cagiangElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[6]/span[1]/span[1]/span/ul/li["+i+"]"));
			cagiangElement.click();
		}
		for(int i = 1; i <=8; i++) {
			Thread.sleep(2000);
			WebElement cagiangElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[6]/span[2]/span/span/ul/li["+i+"]"));
			System.out.println("Đã hiện: " + cagiangElement.getText());
			cagiangElement.click();
		}
	}
}
