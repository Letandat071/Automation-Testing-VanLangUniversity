package HocHamHocVi;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuaDoiCapBac_Page {
	 private WebDriver driver;
	 private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
	 private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
	 private By CapBacClick = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a");
	 private By findingName = By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input");
	 private By changingButton = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[2]/td[2]/a[1]");
	 private By CancelButton = By.xpath("//*[@id=\"btnClose\"]");
	 private By SaveButton = By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]");
	 // Khai báo các biến WebDriver và By để tìm kiếm và tương tác với các phần tử trên trang

	 public SuaDoiCapBac_Page(WebDriver driver) {
		 this.driver = driver;
	 }
	 // Constructor nhận đối tượng WebDriver và khởi tạo driver cho class

	 public void Menu() {
		 driver.findElement(MenuClick).click();
	 }
	 // Phương thức Menu() thực hiện nhấn vào menu chính

	 public void HHHVMenu() {
		 driver.findElement(MenuClickHHHV).click();
	 }
	 // Phương thức HHHVMenu() thực hiện nhấn vào submenu liên quan đến HHHV

	 public void CapBac() {
		 driver.findElement(CapBacClick).click();
	 }
	 // Phương thức CapBac() thực hiện nhấn vào mục menu cấp bậc học vị

	 public void InputName(String NAME) {
		 driver.findElement(findingName).sendKeys(NAME);
	 }
	 // Phương thức InputName(String NAME) nhập văn bản vào trường tìm kiếm

	 public void ClickButton() {
		 driver.findElement(changingButton).click();
	 }
	 // Phương thức ClickButton() thực hiện nhấn vào một nút, có thể là nút để chỉnh sửa một học vị/cấp bậc cụ thể

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
	 // Phương thức ClickCloseButton() thực hiện nhấn vào nút hủy và xác nhận liệu việc nhấn có thành công không

	 public void ClickSaveButton() {
			WebElement clickElement =driver.findElement(SaveButton);
			clickElement.click();
			if (clickElement.isEnabled()) {
			    System.out.println("Click lưu thành công ");
			} else {
			    System.out.println("Click lưu không thành công");
			}
		}
	 // Phương thức ClickSaveButton() thực hiện nhấn vào nút lưu và xác nhận liệu việc nhấn có thành công không
}
