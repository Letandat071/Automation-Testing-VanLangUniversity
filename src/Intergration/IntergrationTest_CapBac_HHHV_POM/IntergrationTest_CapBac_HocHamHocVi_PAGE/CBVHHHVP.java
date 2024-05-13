package IntergrationTest_CapBac_HocHamHocVi_PAGE;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CBVHHHVP {
    // Khai báo biến driver để sử dụng WebDriver
    static WebDriver driver;
    
    // Khai báo các định danh (locators) cho các thành phần trên giao diện
    private By clickMenu = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
    private By clickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]");
    private By buttonAdd = By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]");
    private By clickSaveHHHVButton = By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]");
    private By clickCapBac = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a");
    private By capbacAdd = By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button");
    private By closeAddHHHButton = By.xpath("//*[@id=\"btnClose\"]");
    private By clickDelete = By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr/td[5]/a[2]");
    private By clickSecondelete = By.xpath("/html/body/div[3]/div/div[6]/button[1]");
    private By clickCloseDeleteButton = By.xpath("/html/body/div[3]/div/div[6]/button[3]");
    
    // Khởi tạo constructor của class và truyền vào WebDriver
    public CBVHHHVP(WebDriver driver) {
        this.driver = driver;
    }
    
    // Phương thức để di chuyển đến mục Menu
    public void MenuNavigation() {
        driver.findElement(clickMenu).click();
    }
    
    // Phương thức để chọn mục Hội họa, Hội vẽ
    public void HHHVMenu() {
        driver.findElement(clickHHHV).click();
    }
    
    // Phương thức để chọn mục Cấp bậc
    public void CapBac() {
        driver.findElement(clickCapBac).click();
    }
    
    // Phương thức để nhấn nút Thêm mới
    public void AddHHHVButton() {
        driver.findElement(buttonAdd).click();
    }
    
    // Phương thức để nhấn nút Lưu và kiểm tra xem nút có hoạt động hay không
    public void SaveHHHVButton() {
        WebElement clickElement = driver.findElement(clickSaveHHHVButton);
        clickElement.click();
        if (clickElement.isEnabled()) {
            System.out.println("Click lưu và tạo thành công tại mục HHHV");
        } else {
            System.out.println("Click lưu và tạo không thành công tại mục HHHV");
        }
    }
    
    // Phương thức để nhấn nút Thêm mới cấp bậc
    public void AddCapBacButton() {
        driver.findElement(capbacAdd).click();
    }
    
    // Phương thức để nhấn nút Hủy và kiểm tra xem nút có hoạt động hay không
    public void CloseButton() throws InterruptedException, IOException {
        WebElement clickElement = driver.findElement(closeAddHHHButton);
        if (clickElement.isEnabled()) {
            clickElement.click();
            Thread.sleep(2000);
            System.out.println("Click Hủy thành công tại mục tạo HHHV");
        } else {
            System.out.println("Click Hủy không thành công tại mục tạo HHHV");
        }
    }
    
    // Phương thức để nhấn nút Xóa và kiểm tra xem nút có hoạt động hay không
    public void DeleteButton() throws InterruptedException {
        driver.findElement(clickDelete).click();
        Thread.sleep(5000); // Thay đổi thời gian chờ thành 5 giây
        WebElement clickElement = driver.findElement(clickSecondelete);
        if (clickElement.isEnabled()) {
            clickElement.click();
            System.out.println("Click Xóa thành công tại mục HHHV");
        } else {
            System.out.println("Click Xóa không thành công tại mục HHHV");
        }
    }
    
    // Phương thức để nhấn nút Hủy xóa và kiểm tra xem nút có hoạt động hay không
    public void CloseDeleteButton() throws InterruptedException {
        driver.findElement(clickDelete).click();
        Thread.sleep(3000);
        WebElement clickElement = driver.findElement(clickCloseDeleteButton);
        if (clickElement.isEnabled()) {
            clickElement.click();
            Thread.sleep(2000);
            System.out.println("Click Hủy xóa thành công tại mục HHHV");
        } else {
            System.out.println("Click Hủy xóa không thành công tại mục HHHV");
        }
    }

}
