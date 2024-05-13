package HocHamHocVi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XoaCapBac_Page {
    // Khai báo biến driver để tương tác với trình duyệt
    private WebDriver driver;
    
    // Xác định phần tử của menu chính trên trang web bằng XPath
    private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
    
    // Xác định phần tử của menu HHHV bên trong menu chính bằng XPath
    private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
    
    // Xác định phần tử của mục cấp bậc bên trong menu chính bằng XPath
    private By CapBacClick = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a");
    
    // Constructor nhận một đối tượng WebDriver để khởi tạo lớp XoaCapBac_Page
    public XoaCapBac_Page(WebDriver driver) {
        this.driver = driver;
    }
    
    // Phương thức để chọn menu chính
    public void Menu() {
        driver.findElement(MenuClick).click();
    }
    
    // Phương thức để chọn menu HHHV bên trong menu chính
    public void HHHVMenu() {
        driver.findElement(MenuClickHHHV).click();
    }
    
    // Phương thức để chọn mục cấp bậc trong menu chính
    public void CapBac() {
        driver.findElement(CapBacClick).click();
    }
}