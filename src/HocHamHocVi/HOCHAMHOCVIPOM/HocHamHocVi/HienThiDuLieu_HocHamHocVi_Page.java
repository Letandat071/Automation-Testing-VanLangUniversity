package HocHamHocVi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HienThiDuLieu_HocHamHocVi_Page {
	 private WebDriver driver; // WebDriver được sử dụng để tương tác với trình duyệt
	 private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a"); // Định danh cho nút Menu
	 private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a"); // Định danh cho mục Học hàm, học vị trong Menu
	 private By DropdownChoose =By.xpath("//*[@id=\"tblAcademicDegree_length\"]/label/select"); // Định danh cho dropdown chọn số lượng dữ liệu trên trang
	 private By ChooseBody = By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"); // Định danh cho phần thân của bảng dữ liệu
	 
	 // Constructor nhận tham số là WebDriver
	 public HienThiDuLieu_HocHamHocVi_Page(WebDriver driver) {
		 this.driver = driver; // Gán WebDriver từ tham số cho biến thành viên driver
	 }
	 
	 // Phương thức Menu() để nhấn vào nút Menu
	 public void Menu() {
		 driver.findElement(MenuClick).click(); // Tìm và nhấn vào nút Menu
	 }
	 
	 // Phương thức HHHVMenu() để nhấn vào mục Học hàm, học vị trong Menu
	 public void HHHVMenu() {
		 driver.findElement(MenuClickHHHV).click(); // Tìm và nhấn vào mục Học hàm, học vị trong Menu
	 }
	 
	 // Phương thức SelectData(String NUM) để chọn số lượng dữ liệu trên trang
	 public void SelectData(String NUM) throws InterruptedException {
			WebElement dropdown = driver.findElement(DropdownChoose); // Tìm dropdown chọn số lượng dữ liệu
			Select select = new Select(dropdown); // Tạo một đối tượng Select từ dropdown
			select.selectByValue(NUM); // Chọn số lượng dữ liệu theo giá trị NUM
			Thread.sleep(2000); // Tạm dừng 2 giây để chờ dữ liệu được tải lại
	 }
	 
	 // Phương thức PrintData() để in dữ liệu hiển thị trên trang
	 public void PrintData() {
		WebElement prinElement=driver.findElement(ChooseBody); // Tìm phần thân của bảng dữ liệu
		String dataString=prinElement.getText(); // Lấy văn bản trong phần thân của bảng
		System.out.println(dataString); // In dữ liệu ra màn hình
	 }
}
