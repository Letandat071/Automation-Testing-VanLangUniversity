package ThulaoGV_POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuanLyThuLaoGVTest {
	static WebDriver driver;
    QuanLyThuLaoGVPage quanLyThuLaoGVPage;

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        String chromeProfilePath = "C:\\Users\\letan\\AppData\\Local\\Google\\Chrome\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + chromeProfilePath);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        quanLyThuLaoGVPage = new QuanLyThuLaoGVPage(driver);
        quanLyThuLaoGVPage.openQuanLyThuLaoGVPage();
    }
    @Test(priority = 0)
    public void xemThulaoTheoHocKy() throws InterruptedException, IOException, AWTException {
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\ThuLaoGV.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            String hocKy = row.getCell(0).getStringCellValue();
            Thread.sleep(2000);
            quanLyThuLaoGVPage.selectTerm(hocKy);
            Thread.sleep(2000);

            if (quanLyThuLaoGVPage.isNoDataAvailable()) {
                System.out.println("Học kỳ " + hocKy + " không có dữ liệu để xem");
            } else {
                System.out.println("Đã xem Thù lao giảng viên tại học kỳ: " + hocKy);
            }
            
            driver.navigate().refresh();
        }
    }
    
    @Test(priority = 1)
    public void hienthidulieu() throws InterruptedException {
        QuanLyThuLaoGVPage page = new QuanLyThuLaoGVPage(driver);
        Thread.sleep(2000);
        page.clickTermContainer();
        Thread.sleep(1000);
        page.enterTerm("789");
        Thread.sleep(1000);
        page.selectTermFromList();
        System.out.println("Test Case 2: Hiển thị thù lao theo số dữ liệu");
        Random random = new Random();
        int solieu = random.nextInt(4) + 1;
        Thread.sleep(2000);
        WebElement sodulieu = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/label/select/option[" + solieu + "] "));
        Thread.sleep(1000);
        sodulieu.click();

        Thread.sleep(7000);
        WebElement check = page.getDataElement();
        if (check.getText().contains(sodulieu.getText())) {
            System.out.println("Kết quả mong đợi: " + " Hiển thị 1 tới " + sodulieu.getText() + " của \"***\" dữ liệu");
            System.out.println("Kết quả Thực Tết: " + check.getText());
        }
        Thread.sleep(1000);
        page.refreshPage();
    }
    
    @Test(priority = 2)
    public void timkemGV() throws InterruptedException, IOException {
        QuanLyThuLaoGVPage page = new QuanLyThuLaoGVPage(driver);
        Thread.sleep(2000);
        page.clickTermContainer();
        Thread.sleep(1000);
        page.enterTerm("789");
        Thread.sleep(1000);
        page.selectTermFromList();
        System.out.println("Test Case 3: Tìm kiếm giảng viên theo file dữ liệu");

        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\ThuLaoGV.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(1);
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            String magv = row.getCell(0).getStringCellValue();
            String tengvString = row.getCell(1).getStringCellValue();
            Thread.sleep(2000);
            page.clearSearchField();
            page.searchByMagv(magv);
            Thread.sleep(1000);
            WebElement ketquama = page.getMagvResultElement();
            System.out.println("Kết quả mong đợi: " + magv);
            System.out.println("Kết quả thực tế: " + ketquama.getText());

            Thread.sleep(2000);
            page.clearSearchField();
            page.searchByTengv(tengvString);
            Thread.sleep(1000);
            WebElement ketquaten = page.getTengvResultElement();
            System.out.println("Kết quả mong đợi: " + tengvString);
            System.out.println("Kết quả thực tế: " + ketquaten.getText());
        }
    }
    
    @Test(priority = 3)
    public void exportdataprint() throws InterruptedException, AWTException, IOException {
        QuanLyThuLaoGVPage page = new QuanLyThuLaoGVPage(driver);
        Thread.sleep(2000);
        page.clickTermContainer();
        Thread.sleep(1000);
        page.enterTerm("789");
        Thread.sleep(1000);
        page.selectTermFromList();
        System.out.println("Test Case 4: In dữ liệu bằng print");
        Thread.sleep(1000);
        page.clickPrintButton();
        Thread.sleep(1000);
        page.clickPrintConfirmationButton();
        Thread.sleep(2000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
            System.out.println("File đã được print: " + duLieu);
        } catch (UnsupportedFlavorException  e) {
            System.out.println("Print file thất bại");
        }
        page.refreshPage();
    }
    
    @Test(priority = 4)
    public void saochepdulieuvaoclipboard() throws InterruptedException, UnsupportedFlavorException, IOException {
        QuanLyThuLaoGVPage page = new QuanLyThuLaoGVPage(driver);
        Thread.sleep(2000);
        page.clickTermContainer();
        Thread.sleep(1000);
        page.enterTerm("789");
        Thread.sleep(1000);
        page.selectTermFromList();
        Thread.sleep(2000);
        System.out.println("Test Case 5: Chức năng sao chép dữ liệu vào clipboard");

        page.selectCopyToClipboardOption();
        page.clickExportButton();
        Thread.sleep(1000);
        page.clickCopyToClipboardButton();
        Thread.sleep(300);
        String actualMessage = page.getAlertMessage();

        System.out.println("Kết quả mong đợi: Sao chép vào clipboard");
        System.out.println("Kết quả thực tế: " + actualMessage);

        System.out.println("Dữ liệu mong đợi \n" + page.getClipboardData());

        page.refreshPage();
    }
}
