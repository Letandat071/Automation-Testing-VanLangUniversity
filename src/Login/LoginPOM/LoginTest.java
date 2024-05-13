package LoginPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.*;

public class LoginTest {
    public WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        Thread.sleep(4000);
		driver.findElement(By.id("details-button")).click();
		Thread.sleep(200);
		driver.findElement(By.id("proceed-link")).click();
		
	    driver.findElement(By.id("OpenIdConnect")).click();
	    Thread.sleep(4000);
    }

//    @Test(priority = 0)
//    public void truemailfailpass() throws InterruptedException, IOException {
//        System.out.println("Test case 1: Đúng email sai password");
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        // Lấy dữ liệu từ file excel
//        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\Logindata.xlsx");
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        XSSFRow row = sheet.getRow(1);
//        String email = row.getCell(0).getStringCellValue();
//        String pass = row.getCell(1).getStringCellValue();
//        String result = row.getCell(2).getStringCellValue();
//        fis.close();
//
//        // Điền dữ liệu lên trang email
//        loginPage.enterEmail(email);
//        loginPage.clickSignIn();
//
//        // Điền dữ liệu lên trang password
//        Thread.sleep(4000);
//        loginPage.enterPassword(pass);
//        Thread.sleep(4000);
//        loginPage.clickSignIn();
//
//        Thread.sleep(4000);
//        String trueresult = loginPage.getErrorMessage();
//        System.out.println("Kết quả mong đợi: " + result);
//        System.out.println("Kết quả thực tế: " + trueresult);
//
//        driver.navigate().refresh();
//        driver.navigate().back();
//    }
    @Test(priority = 1)
    public void emailnohavedomain() throws InterruptedException, IOException {
        System.out.println("Test case 2: Email không có đuôi @");

        LoginPage loginPage = new LoginPage(driver);

        // Lấy dữ liệu từ file excel
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\Logindata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(2);
        String email = row.getCell(0).getStringCellValue();
        String pass = row.getCell(1).getStringCellValue();
        String result = row.getCell(2).getStringCellValue();
        fis.close();

        // Điền dữ liệu lên trang email
        loginPage.enterEmail(email);
        loginPage.clickSignIn();

        Thread.sleep(4000);
        String trueresult = loginPage.getEmailError();
        System.out.println("Kết quả mong đợi: " + result);
        System.out.println("Kết quả thực tế: " + trueresult);

        driver.navigate().refresh();
    }

    @Test(priority = 2)
    public void emailwrongdomain() throws InterruptedException, IOException {
        System.out.println("Test case 3: Email sai đuôi @");

        LoginPage loginPage = new LoginPage(driver);

        // Lấy dữ liệu từ file excel
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\Logindata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(3);
        String email = row.getCell(0).getStringCellValue();
        String pass = row.getCell(1).getStringCellValue();
        String result = row.getCell(2).getStringCellValue();
        fis.close();

        // Điền dữ liệu lên trang email
        loginPage.enterEmail(email);
        loginPage.clickSignIn();

        Thread.sleep(4000);
        String trueresult = loginPage.getEmailError();
        System.out.println("Kết quả mong đợi: " + result);
        System.out.println("Kết quả thực tế: " + trueresult);

        driver.navigate().refresh();
    }
    
    @Test(priority = 3)
    public void truemailblankpass() throws InterruptedException, IOException {
        System.out.println("Test case 4: Email đúng để trống mật khẩu");

        LoginPage loginPage = new LoginPage(driver);

        // Lấy dữ liệu từ file excel
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\Logindata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(4);
        String email = row.getCell(0).getStringCellValue();
        String result = row.getCell(2).getStringCellValue();
        fis.close();

        // Điền dữ liệu lên trang email
        loginPage.enterEmail(email);
        loginPage.clickSignIn();

        // Điền dữ liệu lên trang password (không nhập mật khẩu)
        Thread.sleep(5000);
        loginPage.clickSignIn();

        Thread.sleep(4000);
        String trueresult = loginPage.getPasswordError();
        System.out.println("Kết quả mong đợi: " + result);
        System.out.println("Kết quả thực tế: " + trueresult);

        driver.close();
    }

    @Test(priority = 5)
    public void taikhoanhople() throws InterruptedException, IOException {
        System.out.println("Test case 5: Thông tin đăng nhập hợp lệ");

        LoginPage loginPage = new LoginPage(driver);

        // Lấy dữ liệu từ file excel
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\Logindata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(5);
        String pass = row.getCell(1).getStringCellValue();
        String email = row.getCell(0).getStringCellValue();
        fis.close();

        // Điền dữ liệu lên trang email
        loginPage.enterEmail(email);
        loginPage.clickSignIn();

        // Điền dữ liệu lên trang password
        loginPage.enterPassword(pass);
        loginPage.clickSignIn();

        Thread.sleep(4000);
        String trueresult = loginPage.getLoggedInUserInfo();
        Thread.sleep(4000);
        System.out.println("Kết quả mong đợi: " + email);
        System.out.println("Kết quả thực tế: " + trueresult);
    }
}
