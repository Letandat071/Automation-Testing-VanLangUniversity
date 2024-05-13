package HocHamHocVi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TimKiemHocHamHocVi_Page {
    private WebDriver driver;
    private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
    private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
    private By ChooseData = By.xpath("//*[@id=\"tblAcademicDegree_length\"]/label/select");

    // Constructor nhận WebDriver làm tham số để tạo đối tượng trang web
    public TimKiemHocHamHocVi_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Phương thức Menu() để mở menu chính
    public void Menu() {
        driver.findElement(MenuClick).click();
    }

    // Phương thức HHHVMenu() để chọn mục "Học hàm học vị" trong menu chính
    public void HHHVMenu() {
        driver.findElement(MenuClickHHHV).click();
    }

    // Phương thức Data(String DATA) để chọn số lượng dữ liệu hiển thị
    public void Data(String DATA) {
        WebElement dropdown = driver.findElement(ChooseData);
        Select select = new Select(dropdown);
        select.selectByValue(DATA);
    }
}
