package SOGIOQUYDOI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ThongKeSoGioQuyDoi_HocKy_BangBieu_Page {
	private WebDriver driver;
	private By termDropdown = By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]");
	private By termSearchInput = By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input");
	private By tableTab = By.xpath("//*[@id=\"table-tab\"]");
	private By majorDropdown = By.xpath("//*[@id=\"select2-major-container\"]");
	private By majorSearchInput = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input");

	public ThongKeSoGioQuyDoi_HocKy_BangBieu_Page(WebDriver driver) {
		this.driver = driver;
	}

	// Phương thức điều hướng đến trang
	public void navigateToPage() throws InterruptedException {
		// Click vào menu để mở dropdown
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/a")).click();
		Thread.sleep(2000); // Chờ 2 giây để load
		// Click vào submenu để chọn mục con
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[2]/a")).click();
		Thread.sleep(2000); // Chờ 2 giây để load
	}

	// Phương thức chọn học kỳ
	public void selectTerm(String term) throws InterruptedException {
		driver.findElement(termDropdown).click(); // Click vào dropdown học kỳ
		driver.findElement(termSearchInput).sendKeys(term); // Nhập thông tin học kỳ vào ô tìm kiếm
		driver.findElement(termSearchInput).sendKeys(Keys.ENTER); // Ấn phím ENTER để tìm kiếm

		Thread.sleep(2000); // Chờ 2 giây để load
	}

	// Phương thức chọn ngành học
	public void selectMajor(String major) throws InterruptedException {
		driver.findElement(majorDropdown).click(); // Click vào dropdown ngành học
		driver.findElement(majorSearchInput).sendKeys(major); // Nhập thông tin ngành học vào ô tìm kiếm
		driver.findElement(majorSearchInput).sendKeys(Keys.ENTER); // Ấn phím ENTER để tìm kiếm
		Thread.sleep(2000); // Chờ 2 giây để load
	}

	// Phương thức chuyển sang tab bảng biểu
    public void switchToTableTab() {
        driver.findElement(tableTab).click(); // Click vào tab bảng biểu
    }
}