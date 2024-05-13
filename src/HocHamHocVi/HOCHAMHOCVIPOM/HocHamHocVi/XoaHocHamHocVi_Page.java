package HocHamHocVi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XoaHocHamHocVi_Page {
    private WebDriver driver; // WebDriver instance để tương tác với trình duyệt
    private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a"); // Định vị cho mục chính trong menu
    private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a"); // Định vị cho mục con liên quan đến học hàm, học vị

    // Constructor để khởi tạo trang với WebDriver instance được truyền vào
    public XoaHocHamHocVi_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Phương thức để nhấp vào mục chính trong menu
    public void Menu() {
        driver.findElement(MenuClick).click();
    }

    // Phương thức để nhấp vào mục con liên quan đến học hàm, học vị
    public void HHHVMenu() {
        driver.findElement(MenuClickHHHV).click();
    }
}
