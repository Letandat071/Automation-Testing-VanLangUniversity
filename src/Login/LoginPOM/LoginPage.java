package LoginPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Phương thức để nhập email
    public void enterEmail(String email) {
        driver.findElement(By.id("i0116")).sendKeys(email);
    }

    // Phương thức để nhập mật khẩu
    public void enterPassword(String password) {
        driver.findElement(By.id("i0118")).sendKeys(password);
    }

    // Phương thức để nhấn nút đăng nhập
    public void clickSignIn() {
        driver.findElement(By.id("idSIButton9")).click();
    }

    // Phương thức để lấy thông báo lỗi
    public String getErrorMessage() throws InterruptedException {
    	Thread.sleep(4000);
        return driver.findElement(By.id("i0118Error")).getText();
    }
    
    public String getEmailError() {
        return driver.findElement(By.id("usernameError")).getText();
    }
    // Phương thức để lấy thông báo lỗi khi không nhập mật khẩu
    public String getPasswordError() {
        return driver.findElement(By.id("i0118Error")).getText();
    }

    // Phương thức để lấy thông tin sau khi đăng nhập thành công
    public String getLoggedInUserInfo() {
        return driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/h3/span")).getText();
    }
}
