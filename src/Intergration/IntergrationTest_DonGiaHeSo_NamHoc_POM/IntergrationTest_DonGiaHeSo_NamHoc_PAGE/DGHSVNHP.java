package IntergrationTest_DonGiaHeSo_NamHoc_PAGE;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DGHSVNHP {
    static WebDriver driver; // Khai báo biến driver là static để có thể truy cập từ các phương thức static khác
    // Khai báo các locator của các element trên trang
    private By clickHKN = By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a");
    private By AddHKButton = By.xpath("//*[@id=\"tblTerm_wrapper\"]/div[1]/div[2]/div/div[2]/button");
    private By luuButton = By.xpath("//*[@id=\"term-form\"]/div[7]/button[2]");
    private By clickMenu = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
    private By clickDGVHS = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[2]/a");
    private By closebutton = By.xpath("//*[@id=\"btnClose\"]");
    private By clickDelete = By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[2]");
    private By closeDelete = By.xpath("/html/body/div[3]/div/div[6]/button[3]");
    private By secondDelete = By.xpath("/html/body/div[3]/div/div[6]/button[1]");
    
    // Khai báo constructor để khởi tạo đối tượng với WebDriver
    public DGHSVNHP(WebDriver driver) {
        this.driver = driver;
    }
    
    // Phương thức để chuyển đến mục Học kỳ
    public void MenuHK() {
        driver.findElement(clickHKN).click();
    }
    
    // Phương thức để nhấn nút thêm mới học kỳ
    public void AddNewTermButton() {
        driver.findElement(AddHKButton).click();
    }

    // Phương thức để lưu thông tin học kỳ và kiểm tra việc lưu thành công
    public void SaveHKButton() throws InterruptedException, IOException{
        WebElement clickElement = driver.findElement(luuButton);
        clickElement.click();
        if (clickElement.isEnabled()) {
            System.out.println("Click lưu và tạo thành công tại mục Học Kỳ");
        } else {
            System.out.println("Click lưu và tạo không thành công tại mục Học Kỳ");
        }
    }
    
    // Phương thức để hủy việc thêm mới học kỳ và kiểm tra việc hủy thành công
    public void CloseHKButton() throws InterruptedException, IOException{
        WebElement clickElement = driver.findElement(closebutton);
        if (clickElement.isEnabled()) {
            clickElement.click();
            System.out.println("Click Hủy thành công tại mục Học Kỳ");
        } else {
            System.out.println("Click Hủy không thành công tại mục Học Kỳ");
        }
    }
    
    // Phương thức để hủy việc xóa học kỳ và kiểm tra việc hủy thành công
    public void CloseHKDelete() throws InterruptedException, IOException{
        driver.findElement(clickDelete).click();
        Thread.sleep(3000);
        WebElement clickElement = driver.findElement(closeDelete);
        if (clickElement.isEnabled()) {
            clickElement.click();
            Thread.sleep(2000);
            System.out.println("Click Hủy xóa thành công");
        } else {
            System.out.println("Click Hủy xóa không thành công ");
        }
    }
    
    // Phương thức để xóa học kỳ và kiểm tra việc xóa thành công
    public void DeleteHK() throws InterruptedException {
        driver.findElement(clickDelete).click();
        Thread.sleep(5000); // Thay đổi thời gian chờ thành 5 giây
        WebElement clickElement = driver.findElement(secondDelete);
        if (clickElement.isEnabled()) {
            clickElement.click();
            System.out.println("Click Xóa thành công tại mục Cấp Bậc");
        } else {
            System.out.println("Click Xóa không thành công tại mục Cấp Bậc");
        }
    }
    
    // Phương thức để chuyển đến mục Menu
    public void MenuNavigation() {
        driver.findElement(clickMenu).click();
    }
    
    // Phương thức để chuyển đến mục Danh sách giáo viên, hướng dẫn sinh viên
    public void DGVHS() throws InterruptedException, IOException {
        driver.findElement(clickDGVHS).click();
        Thread.sleep(2000);
    }


}
