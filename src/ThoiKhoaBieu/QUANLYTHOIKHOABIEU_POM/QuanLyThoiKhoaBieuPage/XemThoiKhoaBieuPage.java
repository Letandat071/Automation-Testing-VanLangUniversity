package QuanLyThoiKhoaBieuPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XemThoiKhoaBieuPage {
    private WebDriver driver;

    // Xpaths của các dropdown và bảng thời khóa biểu
    private By hocKyDropdown = By.xpath("//*[@id=\"select2-term-container\"]");
    private By tenGiangVienDropdown = By.xpath("//*[@id=\"select2-lecturer-container\"]");
    private By weekDropdown = By.xpath("//*[@id=\"week\"]/option");
    private By timetableTable = By.xpath("//*[@id=\"personalTimetableDiv\"]/div[3]/table/tbody");

    // Constructor nhận WebDriver và khởi tạo
    public XemThoiKhoaBieuPage(WebDriver driver) {
        this.driver = driver;
    }

    // Phương thức click vào dropdown Học kỳ
    public void clickHocKyDropdown() {
        driver.findElement(hocKyDropdown).click();
    }

    // Phương thức nhập Học kỳ vào dropdown
    public void inputHocKy(String hocKy) {
        // Tìm ô input và nhập giá trị Học kỳ, sau đó nhấn Enter
        WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input"));
        input.sendKeys(hocKy);
        input.sendKeys(Keys.ENTER);
    }

    // Phương thức click vào dropdown Tên giảng viên
    public void clickTenGiangVienDropdown() {
        driver.findElement(tenGiangVienDropdown).click();
    }

    // Phương thức nhập Tên giảng viên vào dropdown
    public void inputTenGiangVien(String tenGiangVien) {
        // Tìm ô input và nhập giá trị Tên giảng viên, sau đó nhấn Enter
        WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
        input.sendKeys(tenGiangVien);
        input.sendKeys(Keys.ENTER);
    }

    // Phương thức trả về số lượng tuần trong dropdown Tuần
    public int getNumberOfWeeks() {
        return driver.findElements(weekDropdown).size();
    }

    // Phương thức trả về dữ liệu thời khóa biểu
    public String getTimetableData() {
        WebElement timetableElement = driver.findElement(timetableTable);
        return timetableElement.getText();
    }

    // Phương thức chọn một tuần trong dropdown Tuần
    public void selectWeek(int weekIndex) {
        // Xây dựng xpath của tuần cần chọn và thực hiện click
        String xpathButton = "//*[@id=\"week\"]/option[" + weekIndex + "]";
        WebElement itemElement = driver.findElement(By.xpath(xpathButton));
        itemElement.click();
    }
}
