package HocKy_Nganh_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.*;

public class QuanLyNganhTest {
    public WebDriver driver;
    public Random random = new Random();
    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        String chromeProfilePath = "C:\\Users\\letan\\AppData\\Local\\Google\\Chrome\\User Data";
        options.addArguments("user-data-dir=" + chromeProfilePath);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.id("OpenIdConnect")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void CreatMajor() throws InterruptedException, IOException {
        System.out.println("Test Case 1: Tạo ngành đúng và đủ dữ liệu!!");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Truy cập tab Học kỳ ngành
        quanLyNganhPage.accessHocKyNganhTab();

        // Truy cập tab Quản lý ngành
        quanLyNganhPage.accessQuanLyNganhTab();

        // Lấy dữ liệu từ file excel
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\marjor.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String maNganh = row.getCell(0).getStringCellValue();
        String tenNganh = row.getCell(1).getStringCellValue();
        String standfString = row.getCell(2).getStringCellValue();
        fis.close();

        // Tạo ngành mới với dữ liệu từ file Excel
        quanLyNganhPage.createNewMajor(maNganh, tenNganh, standfString);

        // Chọn chương trình đào tạo
        int ctdt = random.nextInt(2, 4);
        quanLyNganhPage.selectChuongTrinhDaoTao(ctdt);

        // Lưu thông tin ngành
        quanLyNganhPage.saveMajor();

        // Lấy thông báo sau khi lưu
        String ketquaMongdoi = "Lưu thành công";
        System.out.println("Kết quả mong đợi: " + ketquaMongdoi);
        System.out.println("Kết quả thực tế: " + quanLyNganhPage.getSaveMessage());
    }
    
    @Test(priority = 1)
    public void CreatNocode() throws InterruptedException, IOException {
        System.out.println("Test Case 2: Tạo ngành nhưng không điền mã ngành");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Tạo ngành mới nhưng không điền mã ngành
        quanLyNganhPage.createNewMajor("", "Tên Ngành", "Standard");

        // Chọn chương trình đào tạo
        int ctdt = random.nextInt(2, 4);
        quanLyNganhPage.selectChuongTrinhDaoTao(ctdt);

        // Lưu thông tin ngành
        quanLyNganhPage.saveMajor();

        // Lấy thông báo lỗi
        String ketquaMongdoi = "Bạn chưa nhập mã ngành";
        Thread.sleep(2000);

        System.out.println("Kết quả mong đợi: " + ketquaMongdoi);
        System.out.println("Kết quả thực tế: " + quanLyNganhPage.getErrorMessage());

        // Đóng cửa sổ thông báo lỗi
        quanLyNganhPage.closeErrorMessage();
    }
    
    @Test(priority = 2)
    public void creatNoNam() throws IOException, InterruptedException {
        System.out.println("Test Case 3: Tạo ngành nhưng không điền tên ngành");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Tạo ngành mới nhưng không điền tên ngành
        quanLyNganhPage.createNewMajor("Mã Ngành", "", "Standard");

        // Chọn chương trình đào tạo
        int ctdt = random.nextInt(2, 4);
        quanLyNganhPage.selectChuongTrinhDaoTao(ctdt);

        // Lưu thông tin ngành
        quanLyNganhPage.saveMajor();

        // Lấy thông báo lỗi
        String ketquamongdoi = "Bạn chưa nhập tên ngành";
        Thread.sleep(2000);

        System.out.println("Kết quả mong đợi: " + ketquamongdoi);
        System.out.println("Kết quả thực tế: " + quanLyNganhPage.getNameErrorMessage());

        // Đóng cửa sổ thông báo lỗi
        quanLyNganhPage.closeErrorMessage();
    }
    
    @Test(priority = 3)
    public void creatNoStanNam() throws IOException, InterruptedException {
        System.out.println("Test Case 4: Tạo ngành nhưng không điền tên viết tắt");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Tạo ngành mới nhưng không điền tên viết tắt
        quanLyNganhPage.createNewMajor("Mã Ngành", "Tên Ngành", "");

        // Chọn chương trình đào tạo
        int ctdt = random.nextInt(2, 4);
        quanLyNganhPage.selectChuongTrinhDaoTao(ctdt);

        // Lưu thông tin ngành
        quanLyNganhPage.saveMajor();

        // Lấy thông báo lỗi
        String ketquamongdoi = "Bạn chưa nhập tên viết tắt của ngành";
        Thread.sleep(2000);

        System.out.println("Kết quả mong đợi: " + ketquamongdoi);
        System.out.println("Kết quả thực tế: " + quanLyNganhPage.getAbbreviationErrorMessage());

        // Đóng cửa sổ thông báo lỗi
        quanLyNganhPage.closeErrorMessage();
    }
    
    
    @Test(priority = 4)
    public void CreatonlyCode() throws IOException, InterruptedException {
        System.out.println("Test Case 5: Tạo ngành chỉ điền mã");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Tạo ngành mới chỉ điền mã
        quanLyNganhPage.createNewMajor("Mã Ngành", "", "");

        // Chọn chương trình đào tạo
        int ctdt = random.nextInt(2, 4);
        quanLyNganhPage.selectChuongTrinhDaoTao(ctdt);

        // Lưu thông tin ngành
        quanLyNganhPage.saveMajor();

        // Lấy thông báo lỗi
        String ketquamongdoi = "Bạn chưa nhập tên ngành, Bạn chưa nhập tên viết tắt của ngành";
        Thread.sleep(2000);

        System.out.println("Kết quả mong đợi: " + ketquamongdoi);
        System.out.println("Kết quả thực tế: " + quanLyNganhPage.getNameErrorMessage() + ", " + quanLyNganhPage.getAbbreviationErrorMessage());

        // Đóng cửa sổ thông báo lỗi
        quanLyNganhPage.closeErrorMessage();
    }
    
    @Test(priority = 5)
    public void Creatonlyname() throws IOException, InterruptedException {
        System.out.println("Test Case 6: Tạo ngành chỉ điền tên ngành");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Tạo ngành mới chỉ điền tên ngành
        quanLyNganhPage.createNewMajor("", "Tên Ngành", "");

        // Chọn chương trình đào tạo
        int ctdt = random.nextInt(2, 4);
        quanLyNganhPage.selectChuongTrinhDaoTao(ctdt);

        // Lưu thông tin ngành
        quanLyNganhPage.saveMajor();

        // Lấy thông báo lỗi
        String ketquamongdoi = "Bạn chưa nhập mã ngành, Bạn chưa nhập tên viết tắt của ngành";
        Thread.sleep(2000);

        System.out.println("Kết quả mong đợi: " + ketquamongdoi);
        System.out.println("Kết quả thực tế: " + quanLyNganhPage.getErrorMessage() + ", " + quanLyNganhPage.getAbbreviationErrorMessage());

        // Đóng cửa sổ thông báo lỗi
        quanLyNganhPage.closeErrorMessage();
    }
    
    @Test(priority = 6)
    public void Creatonlystand() throws IOException, InterruptedException {
        System.out.println("Test Case 7: Tạo ngành chỉ điền tên viết tắt");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Tạo ngành mới chỉ điền tên viết tắt
        quanLyNganhPage.createNewMajor("", "", "Tên Viết Tắt");

        // Chọn chương trình đào tạo
        int ctdt = random.nextInt(2, 4);
        quanLyNganhPage.selectChuongTrinhDaoTao(ctdt);

        // Lưu thông tin ngành
        quanLyNganhPage.saveMajor();

        // Lấy thông báo lỗi
        String ketquamongdoi = "Bạn chưa nhập mã ngành, Bạn chưa nhập tên ngành";
        Thread.sleep(2000);

        System.out.println("Kết quả mong đợi: " + ketquamongdoi);
        System.out.println("Kết quả thực tế: " + quanLyNganhPage.getErrorMessage() + ", " + quanLyNganhPage.getNameErrorMessage());

        // Đóng cửa sổ thông báo lỗi
        quanLyNganhPage.closeErrorMessage();
    }
    
    @Test(priority = 7)
    public void Creatonlyct() throws IOException, InterruptedException {
        System.out.println("Test Case 8: Tạo ngành chỉ điền CTDT");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Tạo ngành mới chỉ chọn chương trình đào tạo
        quanLyNganhPage.createNewMajor("", "", "");

        // Chọn chương trình đào tạo
        int ctdt = random.nextInt(2, 4);
        quanLyNganhPage.selectChuongTrinhDaoTao(ctdt);

        // Lưu thông tin ngành
        quanLyNganhPage.saveMajor();

        // Lấy thông báo lỗi
        String ketquamongdoi = "Bạn chưa nhập mã ngành, Bạn chưa nhập tên ngành, Bạn chưa nhập tên viết tắt của ngành";
        Thread.sleep(2000);

        System.out.println("Kết quả mong đợi: " + ketquamongdoi);
        System.out.println("Kết quả thực tế: " + quanLyNganhPage.getErrorMessage() + ", " + quanLyNganhPage.getNameErrorMessage() + ", " + quanLyNganhPage.getAbbreviationErrorMessage());

        // Đóng cửa sổ thông báo lỗi
        quanLyNganhPage.closeErrorMessage();
    }
    
    @Test(priority = 8)
    public void Creatnotthing() throws IOException, InterruptedException {
        System.out.println("Test Case 9: Tạo ngành không điền gì");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Truy cập tab Quản lý ngành
        quanLyNganhPage.accessHocKyNganhTab();
        quanLyNganhPage.accessQuanLyNganhTab();

        // Tạo ngành mới không điền thông tin gì
        quanLyNganhPage.createNewMajor("", "", "");

        // Lưu thông tin ngành
        quanLyNganhPage.saveMajor();

        // Lấy thông báo lỗi
        String errorMessage = quanLyNganhPage.getErrorMessage();
        String nameErrorMessage = quanLyNganhPage.getNameErrorMessage();
        String abbreviationErrorMessage = quanLyNganhPage.getAbbreviationErrorMessage();
        String programTypeError = quanLyNganhPage.getProgramTypeError();

        // So sánh kết quả mong đợi với kết quả thực tế
        String expectedResult = "Bạn chưa nhập mã ngành, Bạn chưa nhập tên ngành, Bạn chưa nhập tên viết tắt của ngành, Bạn chưa chọn CTĐT";
        System.out.println("Kết quả mong đợi: " + expectedResult);
        System.out.println("Kết quả thực tế: " + errorMessage + ", " + nameErrorMessage + ", " + abbreviationErrorMessage + ", " + programTypeError);

        // Đóng cửa sổ thông báo lỗi
        quanLyNganhPage.closeErrorMessage();
    }
    
    @Test(priority = 9)
    public void CreatMajorDouble() throws InterruptedException, IOException {
        System.out.println("Test Case 10: Tạo ngành đúng và đủ dữ liệu đã tồn tại!!");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Truy cập tab Học kỳ ngành
        quanLyNganhPage.accessHocKyNganhTab();

        // Truy cập tab Quản lý ngành
        quanLyNganhPage.accessQuanLyNganhTab();

        // Tạo ngành mới với dữ liệu từ file Excel
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\marjor.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String maNganh = row.getCell(0).getStringCellValue();
        String tenNganh = row.getCell(1).getStringCellValue();
        String standfString = row.getCell(2).getStringCellValue();
        quanLyNganhPage.createNewMajor(maNganh, tenNganh, standfString);

        // Chọn chương trình đào tạo
        int ctdt = random.nextInt(2,4);
        quanLyNganhPage.selectChuongTrinhDaoTao(ctdt);

        // Lưu thông tin ngành
        quanLyNganhPage.saveMajor();

        // Lấy thông báo sau khi lưu
        String ketquaMongdoi = "Mã ngành này đã tồn tại!";
        String messElement = quanLyNganhPage.getSaveMessageDouble();
        System.out.println("Kết quả mong đợi: " + ketquaMongdoi);
        System.out.println("Kết quả thực tế: " + messElement);

        // Đóng thông báo và popup
        Thread.sleep(2000);
        quanLyNganhPage.closeAlert();

    }
    
    @Test(priority = 10)
    public void searchMajorCode() throws InterruptedException, IOException {
        System.out.println("Test Case 11: Tìm ngành theo mã ngành");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Tìm ngành theo mã ngành
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\marjor.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String maNganh = row.getCell(0).getStringCellValue();
        String tenNganh = quanLyNganhPage.searchMajorByCode(maNganh);

        // So sánh kết quả
        String ketquamongdoi = "492003";
        System.out.println("Kết quả mong đợi: " + ketquamongdoi);
        System.out.println("Kết quả thực tế: " + tenNganh);
    }
    
    @Test(priority = 11)
    public void searchMajorName() throws InterruptedException, IOException {
        System.out.println("Test Case 12: Tìm ngành theo tên ngành");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Tìm ngành theo tên ngành
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\marjor.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String tenNganh = row.getCell(1).getStringCellValue();
        String tenNganhResult = quanLyNganhPage.searchMajorByName(tenNganh);

        // In kết quả mong đợi và kết quả thực tế
        System.out.println("Kết quả mong đợi: " + tenNganh);
        System.out.println("Kết quả thực tế: " + tenNganhResult);
    }
    
    @Test(priority = 12)
    public void searchMajorStand() throws InterruptedException, IOException {
        System.out.println("Test Case 13: Tìm ngành theo tên viết tắt");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Tìm ngành theo tên viết tắt
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\marjor.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String standString = row.getCell(2).getStringCellValue();
        String tenNganhResult = quanLyNganhPage.searchMajorByStand(standString);

        // In kết quả mong đợi và kết quả thực tế
        System.out.println("Kết quả mong đợi: " + standString);
        System.out.println("Kết quả thực tế: " + tenNganhResult);
    }
    
    @Test(priority = 13)
    public void editmajor() throws InterruptedException, IOException {
        System.out.println("Test Case 14: Sửa ngành đúng và đủ thông tin");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Sửa ngành với thông tin mới
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\marjorupdate.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String newName = row.getCell(0).getStringCellValue();
        String newStand = row.getCell(1).getStringCellValue();
        String actualMessage = quanLyNganhPage.editMajor(newName, newStand);

        // In kết quả mong đợi và kết quả thực tế
        String expectedMessage = "Cập nhật thành công";
        System.out.println("Kết quả mong đợi: " + expectedMessage);
        System.out.println("Kết quả thực tế: " + actualMessage);
    }
    
    @Test(priority = 14)
    public void editmajornoNamer() throws InterruptedException, IOException {
        System.out.println("Test Case 15: Sửa tên viết tắt ngành không sửa tên ngành");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Sửa tên viết tắt ngành mà không sửa tên ngành
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\marjorupdate.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(2);
        String newStand = row.getCell(1).getStringCellValue();
        String actualMessage = quanLyNganhPage.editMajorWithoutName(newStand);

        // In kết quả mong đợi và kết quả thực tế
        String expectedMessage = "Cập nhật thành công";
        System.out.println("Kết quả mong đợi: " + expectedMessage);
        System.out.println("Kết quả thực tế: " + actualMessage);
    }
    
    @Test(priority = 15)
    public void editmajornoStand() throws InterruptedException, IOException {
        System.out.println("Test Case 16: Sửa tên ngành không sửa tên viết tắt");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Sửa tên ngành mà không sửa tên viết tắt
        FileInputStream fis = new FileInputStream("D:\\TEST\\TestData\\marjorupdate.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(3);
        String newName = row.getCell(0).getStringCellValue();
        String actualMessage = quanLyNganhPage.editMajorWithoutStand(newName);

        // In kết quả mong đợi và kết quả thực tế
        String expectedMessage = "Cập nhật thành công";
        System.out.println("Kết quả mong đợi: " + expectedMessage);
        System.out.println("Kết quả thực tế: " + actualMessage);
    }
    
    @Test(priority = 16)
    public void editmajordlname() throws InterruptedException, IOException {
        System.out.println("Test Case 17: Xóa Tên ngành giữ lại tên viết tắt");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Xóa tên ngành giữ lại tên viết tắt
        String actualMessage = quanLyNganhPage.editMajorDeleteName();

        // In kết quả mong đợi và kết quả thực tế
        String expectedMessage = "Bạn chưa nhập tên ngành";
        System.out.println("Kết quả mong đợi: " + expectedMessage);
        System.out.println("Kết quả thực tế: " + actualMessage);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
    }
    
    @Test(priority = 17)
    public void editmajordlstand() throws InterruptedException, IOException {
        System.out.println("Test Case 18: Xóa Tên viết tắt giữ lại tên ngành");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Xóa tên viết tắt giữ lại tên ngành
        String actualMessage = quanLyNganhPage.editMajorDeleteStand();

        // In kết quả mong đợi và kết quả thực tế
        String expectedMessage = "Bạn chưa nhập tên viết tắt của ngành";
        System.out.println("Kết quả mong đợi: " + expectedMessage);
        System.out.println("Kết quả thực tế: " + actualMessage);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
        
    }

    @Test(priority = 18)
    public void CanldeleteMajor() throws InterruptedException {
        System.out.println("Test Case 19: Người dùng chọn xóa nhưng hủy");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Hủy việc xóa một ngành
        String actualResult = quanLyNganhPage.cancelDeleteMajor();

        // In kết quả mong đợi và kết quả thực tế
        WebElement ctdtElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[5]"));
        String expectedResult = "1 492003 Ngành new Update 2 TEGA1 Update 2 " + ctdtElement.getText();
        System.out.println("Kết quả mong đợi: " + expectedResult);
        System.out.println("Kết quả thực tế: " + actualResult);
    }
    
    @Test(priority = 19)
    public void deleteMajor() throws InterruptedException {
        System.out.println("Test Case 20: Người dùng chọn xóa và xác nhận");

        QuanLyNganhPage quanLyNganhPage = new QuanLyNganhPage(driver);

        // Xóa một ngành
        String actualResult = quanLyNganhPage.deleteMajor();

        // In kết quả mong đợi và kết quả thực tế
        String expectedResult = "Xoá thành công!";
        System.out.println("Kết quả mong đợi: " + expectedResult);
        System.out.println("Kết quả thực tế: " + actualResult);
    }
}

