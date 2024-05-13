package HocHamHocVi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TimKiemCapBac_Page {
    // Khai báo biến driver để tương tác với trình duyệt
    private WebDriver driver;
    // Xpath của menu chính
    private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
    // Xpath của menu HHHV
    private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
    // Xpath của mục cấp bậc
    private By CapBacClick = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a");
    // Xpath của dropdown để chọn số lượng dữ liệu hiển thị
    private By ChooseData = By.xpath("//*[@id=\"tblAcademicDegreeRank_length\"]/label/select");

    // Constructor nhận vào một WebDriver để khởi tạo trang
    public TimKiemCapBac_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Phương thức để click vào menu chính
    public void Menu() {
        driver.findElement(MenuClick).click();
    }

    // Phương thức để click vào menu HHHV
    public void HHHVMenu() {
        driver.findElement(MenuClickHHHV).click();
    }

    // Phương thức để click vào mục cấp bậc
    public void CapBac() {
        driver.findElement(CapBacClick).click();
    }

    // Phương thức để chọn số lượng dữ liệu hiển thị
    public void Data(String DATA) {
        // Tìm dropdown chứa số liệu hiển thị
        WebElement dropdown = driver.findElement(ChooseData);
        // Khởi tạo một đối tượng Select từ dropdown
        Select select = new Select(dropdown);
        // Chọn giá trị trong dropdown bằng cách truyền vào giá trị DATA
        select.selectByValue(DATA);
    }
}