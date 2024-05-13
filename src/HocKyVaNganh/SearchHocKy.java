package HocKy_Nganh;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.command.PullImageCmd;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;


public class SearchHocKy {
	
	public WebDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\letan\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir="+chromeProfilePath);
        driver = new ChromeDriver(options);
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.id("OpenIdConnect")).click();
        Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void getNganh() throws InterruptedException {
		WebElement tabHKN = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a/span"));
		tabHKN.click();
		Thread.sleep(2000);
	}
	
	@Test (priority = 1)
	public void normalcharcter() throws InterruptedException {
		String listtext = "ABCDEFGHIKLMNOPQRSTVXYZ";
		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();

		
		for(int i = 0; i<=22; i++) {
			Thread.sleep(800);
			WebElement searchbox = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
			String charString = String.valueOf(listtext.charAt(i));
			searchbox.sendKeys(charString);
			Thread.sleep(1000);
			WebElement dataTable = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[1]"));
			System.out.println(dataTable.getText());
			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
				pasStringBuilder.append(charString);
			} else {
				faildBuilder.append(charString);
			}
			driver.navigate().refresh();
		}
		
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key word không hợp lệ "+faildString);
		System.out.println("Key Word hợp lệ " + pasString);	
	}
	@Test (priority = 2)
	public void specialCharacter() throws InterruptedException {
		String listtext = "~`!@#$%^&*()-_=+\\|]}[{':;.>,</?";
		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();
		
		for(int i = 0; i<=30; i++) {
			Thread.sleep(1000);
			WebElement searchbox = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
			String charString = String.valueOf(listtext.charAt(i));
			searchbox.sendKeys(charString);
			Thread.sleep(1000);
			WebElement dataTable = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[1]"));
			System.out.println(dataTable.getText());
			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
				pasStringBuilder.append(charString);
			} else {
				faildBuilder.append(charString);
			}
			driver.navigate().refresh();
		}
		
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key kí tự không hợp lệ "+faildString);
		System.out.println("Key kí tự hợp lệ " + pasString);
			
	}
	@Test (priority = 3)
	public void numberCharacter() throws InterruptedException {
		String listtext = "0123456789";
		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();
		
		for(int i = 0; i<=9; i++) {
			Thread.sleep(1000);
			WebElement searchbox = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
			String charString = String.valueOf(listtext.charAt(i));
			searchbox.sendKeys(charString);
			Thread.sleep(1000);
			WebElement dataTable = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[1]"));
			System.out.println(dataTable.getText());
			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
				 faildBuilder.append(charString);
			} else {
				pasStringBuilder.append(charString);
			}
			driver.navigate().refresh();
		}
		
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key number không hợp lệ "+faildString);
		System.out.println("Key number hợp lệ " + pasString);
		driver.close();	
	}
	
	@Test (priority = 4)
	public void number4character() throws InterruptedException {
		String listtext = "0123456789";
		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();
		
		for(int i = 0; i<=9; i++) {
			for(int k =0; k<=9; k++) {
				for (int j =0; j <=9 ; j++) {
					for(int l =0; l<=9 ; l++) {
						Thread.sleep(1000);
						WebElement searchbox = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
						String charString = String.valueOf(listtext.charAt(i)) +String.valueOf(listtext.charAt(k)) + String.valueOf(listtext.charAt(j))+ String.valueOf(listtext.charAt(l));
						searchbox.sendKeys(charString);
						Thread.sleep(1000);
						WebElement dataTable = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[1]"));
						System.out.println(dataTable.getText());
						if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
							 faildBuilder.append(charString);
						} else {
							pasStringBuilder.append(charString);
						}
						driver.navigate().refresh();
					}
				}
				
			}
			
		}
		
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key number không hợp lệ "+ faildString);
		System.out.println("Key number hợp lệ " + pasString);
		driver.close();	
	}
	

	
}
