package CapBacGiaoVien;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.poi.hslf.record.Sound;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HocKy_CapBacGiaoVien {
	static WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\Phan_Hoang_Khang\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
	}

	@BeforeTest
	public void Setup2() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a")).click();
		Thread.sleep(2000);
	}

//	@Test(priority = 37)
//	public void Action38() throws InterruptedException {
//	    // In ra thông tin của testcase
//	    System.out.println("Testcase 38: CHỨC NĂNG CHỌN HỌC KỲ BẤT Kì");
//	    // Click vào liên kết để mở chức năng chỉnh sửa
//	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
//	    linkEdit.click();
//	    Thread.sleep(2000);
//	    // Lấy danh sách các phần tử trong dropdown
//	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"term\"]/option"));
//	    int numberOfElements = elements.size();
//	    // Random một số ngẫu nhiên để chọn học kỳ
//	    Random random = new Random();
//	    int rand = random.nextInt(numberOfElements);
//	    // Chọn học kỳ theo index ngẫu nhiên
//	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"term\"]"));
//	    Select select = new Select(dropdown);
//	    select.selectByIndex(rand);
//	    // In ra học kỳ đã chọn
//	    WebElement printElement = driver.findElement(By.xpath("//*[@id=\"select2-term-container\"]"));
//	    String printString = printElement.getText();
//	    System.out.println("Học kỳ được chọn là: " + printString);
//	    Thread.sleep(2000);
//	}

	@Test(priority = 38)
	public void Action39() throws InterruptedException {
	    // In ra thông tin của testcase
	    System.out.println("Testcase 39: CHỨC NĂNG NHẬP HỌC KỲ BẤT Kì");
	    // Click vào liên kết để mở chức năng chỉnh sửa
	    WebElement linkEdit = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a"));
	    linkEdit.click();
	    Thread.sleep(2000);
	    // Click vào dropdown để mở danh sách các học kỳ
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span")).click();
	    // Lấy danh sách các phần tử trong dropdown
	    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"term\"]/option"));
	    int numberOfElements = elements.size();
	    // Random một số ngẫu nhiên để chọn học kỳ
	    Random random = new Random();
	    int rand = random.nextInt(numberOfElements);
	    // Chọn học kỳ theo index ngẫu nhiên
	    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"term\"]"));
	    Select select = new Select(dropdown);
	    select.selectByIndex(rand);
	    // Lấy và in ra học kỳ đã chọn
	    WebElement printElement = driver.findElement(By.xpath("//*[@id=\"select2-term-container\"]"));
	    String printString = printElement.getText();
	    // Nhập học kỳ đã chọn vào ô input và nhấn Enter
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys(printString);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
	    System.out.println("Học kỳ được nhập là: " + printString);
	}

	
}
