package FUNCTION2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogOut {
	static WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\AN515-45\\AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
	}
	@Test
	public void Action() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[2]")).click();
		System.out.println("Đăng xuất thành công");
	}
}
