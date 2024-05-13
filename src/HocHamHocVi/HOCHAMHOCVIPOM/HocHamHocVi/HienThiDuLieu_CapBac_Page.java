package HocHamHocVi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HienThiDuLieu_CapBac_Page {
    private WebDriver driver;
    private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
    private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
    private By CapBacClick = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a");
    private By DropdownChoose = By.xpath("//*[@id=\"tblAcademicDegreeRank_length\"]/label/select");
    private By ChooseBody = By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody");

    // Constructor nhận một tham số driver để thiết lập trình điều khiển trình duyệt
    public HienThiDuLieu_CapBac_Page(WebDriver driver) {
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

    // Phương thức để chọn số lượng dữ liệu hiển thị trên trang
    public void SelectData(String NUM) throws InterruptedException {
        WebElement dropdown = driver.findElement(DropdownChoose);
        Select select = new Select(dropdown);
        select.selectByValue(NUM);
        Thread.sleep(2000);
    }

    // Phương thức để in ra dữ liệu hiển thị trên trang
    public void PrintData() {
        WebElement prinElement = driver.findElement(ChooseBody);
        String dataString = prinElement.getText();
        System.out.println(dataString);
    }
}
