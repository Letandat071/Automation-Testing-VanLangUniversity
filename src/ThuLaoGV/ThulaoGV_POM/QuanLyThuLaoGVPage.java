package ThulaoGV_POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuanLyThuLaoGVPage {
	 private WebDriver driver;

	    // Constructor
	    public QuanLyThuLaoGVPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Phương thức để thực hiện các hành động để mở trang QuanLyThuLaoGV
	    public void openQuanLyThuLaoGVPage() throws InterruptedException {
	        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
	        driver.findElement(By.id("OpenIdConnect")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
	        Thread.sleep(500);
	        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[5]/a")).click();
	    }
	    
	    // Phương thức chọn học kỳ
	    public void selectTerm(String term) throws AWTException {
	        try {
	            WebElement termContainer = driver.findElement(By.id("select2-term-container"));
	            termContainer.click();
	            WebElement termInput = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input"));
	            termInput.sendKeys(term);
	            Robot robot = new Robot();
	            robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);
	            Thread.sleep(1000);
	        } catch (InterruptedException  e) {
	           
	        }
	    }

	    public boolean isNoDataAvailable() {
	        try {
	            WebElement blankTerm = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/h4"));
	            String notice = "Chưa có dữ liệu hệ số cho năm học này";
	            return blankTerm.getText().contains(notice);
	        } catch (Exception e) {
	            WebElement termInfo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/label"));
	            String thongbaoString = "Hiển thị";
	            return termInfo.getText().contains(thongbaoString);
	        }
	    }
	    
	    public void clickTermContainer() {
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span")).click();
	    }

	    public void enterTerm(String term) {
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys(term);
	    }

	    public void selectTermFromList() {
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[2]/ul/li")).click();
	    }

	    public WebElement getDataElement() {
	        return driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div"));
	    }

	    
	    public void clearSearchField() {
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).clear();
	    }

	    public void searchByMagv(String magv) {
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(magv);
	    }

	    public void searchByTengv(String tengv) {
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(tengv);
	    }

	    public WebElement getMagvResultElement() {
	        return driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr/td[2]"));
	    }

	    public WebElement getTengvResultElement() {
	        return driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr/td[3]"));
	    }

	    
	    public void clickPrintButton() {
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
	    }

	    public void clickPrintConfirmationButton() {
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]")).click();
	    }

	    public void refreshPage() {
	        driver.navigate().refresh();
	    }
	    
	    public void selectCopyToClipboardOption() {
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/label/select")).click();
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/label/select/option[4]")).click();
	    }

	    public void clickExportButton() {
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
	    }

	    public void clickCopyToClipboardButton() {
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]")).click();
	    }

	    public String getAlertMessage() {
	        WebElement alertElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
	        return alertElement.getText();
	    }

	    public String getClipboardData() throws UnsupportedFlavorException, IOException {
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        return (String) clipboard.getData(DataFlavor.stringFlavor);
	    }
}
