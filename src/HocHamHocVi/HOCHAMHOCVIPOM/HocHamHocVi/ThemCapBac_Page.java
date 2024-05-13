package HocHamHocVi;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ThemCapBac_Page {
    private WebDriver driver;
    private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
    private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
    private By CapBacClick = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a");
    private By CancelButton = By.xpath("//*[@id=\"btnClose\"]");
    private By SaveButton = By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]");
    
    // Constructor của class, nhận WebDriver làm tham số để thao tác trên trình duyệt.
    public  ThemCapBac_Page(WebDriver driver) {
        this.driver = driver;
    }
    
    // Phương thức để mở menu chính trên trang web.
    public void Menu() {
        driver.findElement(MenuClick).click();
    }
    
    // Phương thức để mở menu Học hàm học vị trên trang web.
    public void HHHVMenu() {
        driver.findElement(MenuClickHHHV).click();
    }
    
    // Phương thức để chọn mục "Cấp bậc" từ menu con của menu Học hàm học vị.
    public void CapBac() {
        driver.findElement(CapBacClick).click();
    }
    
    // Phương thức để click vào nút Hủy và kiểm tra xem nút đó có được kích hoạt hay không.
    public void ClickCloseButton() throws InterruptedException, IOException {
        WebElement clickElement = driver.findElement(CancelButton);
        if (clickElement.isEnabled()) {
            clickElement.click();
            Thread.sleep(2000);
            System.out.println("Click Hủy thành công");
        } else {
            System.out.println("Click Hủy không thành công ");
        }
    }
    
    // Phương thức để click vào nút Lưu và kiểm tra xem nút đó có được kích hoạt hay không.
    public void ClickSaveButton() {
        WebElement clickElement = driver.findElement(SaveButton);
        clickElement.click();
        if (clickElement.isEnabled()) {
            System.out.println("Click lưu thành công ");
        } else {
            System.out.println("Click lưu không thành công");
        }
    }
}
