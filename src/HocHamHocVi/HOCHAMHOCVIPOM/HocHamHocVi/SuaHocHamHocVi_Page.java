package HocHamHocVi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuaHocHamHocVi_Page {
    // Khai báo biến WebDriver để tương tác với trình duyệt
    private WebDriver driver;
    
    // Xpath của các phần tử trên giao diện người dùng
    private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
    private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
    private By SaveButton = By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]");
    private By CloseButton = By.xpath("//*[@id=\"btnClose\"]");

    // Constructor nhận đối tượng WebDriver và gán cho biến driver
    public SuaHocHamHocVi_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Phương thức Menu để nhấn vào menu
    public void Menu() {
        driver.findElement(MenuClick).click();
    }

    // Phương thức HHHVMenu để nhấn vào mục Học hàm, học vị
    public void HHHVMenu() {
        driver.findElement(MenuClickHHHV).click();
    }

    // Phương thức ClickSaveButton để nhấn vào nút Lưu và in ra thông báo tương ứng
    public void ClickSaveButton() {
        try {
            // Tìm phần tử Lưu và nhấn vào
            WebElement clickElement = driver.findElement(SaveButton);
            clickElement.click();
            System.out.println("Click lưu thành công ");
        } catch (Exception e) {
            // Nếu không tìm thấy phần tử hoặc không thể nhấn được, in ra thông báo lỗi
            System.out.println("Click lưu không thành công");
        }
    }

    // Phương thức ClickCloseButton để nhấn vào nút Hủy và in ra thông báo tương ứng
    public void ClickCloseButton() throws InterruptedException {
        // Tìm phần tử Hủy và kiểm tra nếu có thể nhấn được thì nhấn và in ra thông báo thành công
        WebElement clickElement = driver.findElement(CloseButton);
        if (clickElement.isEnabled()) {
            clickElement.click();
            Thread.sleep(2000);
            System.out.println("Click Hủy thành công");
        } else {
            // Nếu không thể nhấn được, in ra thông báo lỗi
            System.out.println("Click Hủy không thành công");
        }
        // In ra dấu phân cách cuối cùng để phân biệt giữa các thông báo
        System.out.println("=======");
    }
}
