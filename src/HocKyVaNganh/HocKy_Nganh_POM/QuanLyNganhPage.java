package HocKy_Nganh_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuanLyNganhPage {
    private WebDriver driver;

    // Constructor
    public QuanLyNganhPage(WebDriver driver) {
        this.driver = driver;
    }

    // Phương thức để truy cập vào tab Học kỳ ngành
    public void accessHocKyNganhTab() {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a/span")).click();
    }

    // Phương thức để truy cập vào tab Quản lý ngành
    public void accessQuanLyNganhTab() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
    }

    // Phương thức để tạo ngành mới với dữ liệu từ file Excel
    public void createNewMajor(String maNganh, String tenNganh, String standfString) {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();

        //Nhập thông tin ngành
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys(maNganh);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(tenNganh);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys(standfString);
    }

    // Phương thức để chọn chương trình đào tạo
    public void selectChuongTrinhDaoTao(int index) {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/select/option[" + index + "]")).click();
    }

    // Phương thức để lưu thông tin ngành
    public void saveMajor() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
    }

    // Phương thức để lấy thông báo sau khi lưu
    public String getSaveMessage() {
        return driver.findElement(By.xpath("/html/body/div[3]/div/div")).getText();
    }
    
    // Phương thức để lấy thông báo sau khi lưu
    public String getSaveMessageDouble() {
        return driver.findElement(By.xpath("/html/body/div[4]/div/div[2]")).getText();
    }
    
    // Phương thức để lấy thông báo lỗi
    public String getErrorMessage() {
        return driver.findElement(By.id("id-error")).getText();
    }

    // Phương thức để đóng cửa sổ thông báo lỗi
    public void closeErrorMessage() {
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
    }
    
    // Phương thức để lấy thông báo lỗi khi không nhập tên ngành
    public String getNameErrorMessage() {
        return driver.findElement(By.id("name-error")).getText();
    }
    
    // Phương thức để lấy thông báo lỗi khi không nhập tên viết tắt của ngành
    public String getAbbreviationErrorMessage() {
        return driver.findElement(By.id("abbreviation-error")).getText();
    }
    
    // Phương thức để lấy thông báo lỗi về chương trình đào tạo
    public String getProgramTypeError() {
        return driver.findElement(By.id("program_type-error")).getText();
    }
    // Phương thức để đóng thông báo
    public void closeAlert() throws InterruptedException {
    	Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
    }

    // Phương thức để đóng popup
    public void closePopup() throws InterruptedException {
    	Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
    }
    
    
    // Phương thức để tìm ngành theo mã ngành
    public String searchMajorByCode(String maNganh) {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(maNganh);
        WebElement tenNganhElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[2]"));
        String tenNganh = tenNganhElement.getText();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
        return tenNganh;
    }
    
    // Phương thức để tìm kiếm ngành theo tên ngành
    public String searchMajorByName(String tenNganh) {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(tenNganh);
        WebElement tenNganhElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[3]"));
        String tenNganhResult = tenNganhElement.getText();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
        return tenNganhResult;
    }
    
    // Phương thức để tìm kiếm ngành theo tên viết tắt
    public String searchMajorByStand(String standString) {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(standString);
        WebElement tenNganhElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[4]"));
        String tenNganh = tenNganhElement.getText();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
        return tenNganh;
    }
    
    // Phương thức để chỉnh sửa thông tin của một ngành
    public String editMajor(String newName, String newStand) throws InterruptedException {
        WebElement editButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]"));
        editButton.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(newName);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys(newStand);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
        Thread.sleep(1000);
        WebElement messElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
        return messElement.getText();
    }
    
    // Phương thức để chỉnh sửa thông tin của một ngành (không sửa tên ngành)
    public String editMajorWithoutName(String newStand) throws InterruptedException {
        WebElement editButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]"));
        editButton.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys(newStand);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
        Thread.sleep(1000);
        WebElement messElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
        return messElement.getText();
    }
    
    
 // Phương thức để chỉnh sửa thông tin của một ngành (không sửa tên viết tắt)
    public String editMajorWithoutStand(String newName) throws InterruptedException {
        WebElement editButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]"));
        editButton.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys(newName);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
        Thread.sleep(1000);
        WebElement messElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
        return messElement.getText();
    }
    
 // Phương thức để chỉnh sửa thông tin của một ngành (xóa tên ngành)
    public String editMajorDeleteName() throws InterruptedException {
        WebElement editButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]"));
        editButton.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
        Thread.sleep(1000);
        WebElement messElement = driver.findElement(By.id("name-error"));
        return messElement.getText();
    }
    
    // Phương thức để chỉnh sửa thông tin của một ngành (xóa tên viết tắt)
    public String editMajorDeleteStand() throws InterruptedException {
        WebElement editButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[1]"));
        editButton.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
        Thread.sleep(2000);
        WebElement messElement = driver.findElement(By.id("abbreviation-error"));
        return messElement.getText();
    }
    
    // Phương thức để hủy việc xóa một ngành
    public String cancelDeleteMajor() throws InterruptedException {
        WebElement removeButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[2]"));
        removeButton.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")).click();
        Thread.sleep(800);
        WebElement messElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr"));
        WebElement ctdtElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[5]"));
        String actualResult = "1 492003 Ngành new Update 2 TEGA1 Update 2 " + ctdtElement.getText();
        return messElement.getText();
    }
    
 // Phương thức để xóa một ngành
    public String deleteMajor() throws InterruptedException {
        WebElement removeButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[2]"));
        removeButton.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
        Thread.sleep(800);
        WebElement messElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
        return messElement.getText();
    }
}

