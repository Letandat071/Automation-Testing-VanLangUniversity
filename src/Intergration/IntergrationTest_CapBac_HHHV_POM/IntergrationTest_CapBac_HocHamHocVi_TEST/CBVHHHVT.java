package IntergrationTest_CapBac_HocHamHocVi_TEST;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import IntergrationTest_CapBac_HocHamHocVi_PAGE.CBVHHHVP;
import PageSetup.Setup;

public class CBVHHHVT {
	static WebDriver driver;
	private String savedID;

	private By IDHHHV = By.xpath("//*[@id=\"id\"]");
	private By NAMEHHHV = By.xpath("//*[@id=\"name\"]");

	@BeforeSuite
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}

	@BeforeTest
	public void Setup2() throws InterruptedException {
		CBVHHHVP MainPage = new CBVHHHVP(driver);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void Action() throws InterruptedException, IOException {
		// Khởi tạo đối tượng CBVHHHVP để thao tác trên trang web
		CBVHHHVP MainPage = new CBVHHHVP(driver);
		// In ra console để thông báo bắt đầu thực hiện testcase
		System.out.println("Testcase 1:Tạo học hàm học vị và kiểm tra Học hàm học vị mới có tồn tại bên mục Cấp Bậc");
		// Di chuyển đến menu Hội họa, Hội vẽ
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		// Nhấn nút Thêm mới trên giao diện
		MainPage.AddHHHVButton();
		Thread.sleep(2000);
		// Mở file Excel chứa dữ liệu để lấy dữ liệu học hàm học vị mới
		FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		// Lấy dữ liệu từ file Excel
		XSSFRow row = sheet.getRow(14);
		String id = row.getCell(0).getStringCellValue();
		String name = row.getCell(1).getStringCellValue();
		// Nhập dữ liệu vào các trường ID và Name trên giao diện
		driver.findElement(IDHHHV).sendKeys(id);
		driver.findElement(NAMEHHHV).sendKeys(name);
		savedID = name;
		Thread.sleep(2000);
		// Nhấn nút Lưu để lưu học hàm học vị mới
		MainPage.SaveHHHVButton();
		System.out.println("=======");
		System.out.println("Chuyển sang mục Cấp Bậc");
		// Di chuyển đến mục Cấp Bậc trên giao diện
		MainPage.CapBac();
		Thread.sleep(2000);
		// Nhấn nút Thêm mới cấp bậc
		MainPage.AddCapBacButton();
		Thread.sleep(2000);
		// Kiểm tra xem dữ liệu học hàm học vị mới đã tồn tại trong textbox tạo cấp bậc hay không
		String pageSource = driver.getPageSource();
		if (pageSource.contains(savedID)) {
		    System.out.println("Dữ liệu " + savedID + " đã tạo tại HHHV tồn tại ở mục textbox tạo Cấp Bậc ");
		} else {
		    System.out.println("Dữ liệu " + savedID + " đã tạo tại HHHV không tồn tại ở mục textbox tạo Cấp Bậc ");
		}
		System.out.println("============");

	}

	@Test(priority = 2)
	public void Action2() throws InterruptedException, IOException {
		// Khởi tạo đối tượng CBVHHHVP để thao tác trên trang web
		CBVHHHVP MainPage = new CBVHHHVP(driver);
		// In ra console để thông báo bắt đầu thực hiện testcase
		System.out.println("Testcase 2:Tạo học hàm học vị và ấn Hủy và kiểm tra Học hàm học vị mới có tồn tại bên mục Cấp Bậc");
		// Di chuyển đến menu Hội họa, Hội vẽ
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		// Nhấn nút Thêm mới trên giao diện
		MainPage.AddHHHVButton();
		Thread.sleep(2000);
		// Mở file Excel chứa dữ liệu để lấy dữ liệu học hàm học vị mới
		FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		// Lấy dữ liệu từ file Excel
		XSSFRow row = sheet.getRow(15);
		String id = row.getCell(0).getStringCellValue();
		String name = row.getCell(1).getStringCellValue();
		// Nhập dữ liệu vào các trường ID và Name trên giao diện
		driver.findElement(IDHHHV).sendKeys(id);
		driver.findElement(NAMEHHHV).sendKeys(name);
		savedID = name;
		Thread.sleep(2000);
		// Nhấn nút Hủy để hủy thao tác tạo mới học hàm học vị
		MainPage.CloseButton();
		System.out.println("=======");
		System.out.println("Chuyển sang mục Cấp Bậc");
		// Di chuyển đến mục Cấp Bậc trên giao diện
		MainPage.CapBac();
		Thread.sleep(2000);
		// Nhấn nút Thêm mới cấp bậc
		MainPage.AddCapBacButton();
		Thread.sleep(2000);
		// Kiểm tra xem dữ liệu học hàm học vị mới đã tồn tại trong textbox tạo cấp bậc hay không
		String pageSource = driver.getPageSource();
		if (pageSource.contains(savedID)) {
		    System.out.println("Dữ liệu " + savedID + " đã Hủy tạo tại HHHV tồn tại ở textbox tạo Cấp Bậc ");
		} else {
		    System.out.println("Dữ liệu " + savedID + " đã Hủy tạo tại HHHV không tồn tại ở textbox tạo Cấp Bậc ");
		}
		System.out.println("============");

	}

	@Test(priority = 3)
	public void Action3() throws InterruptedException, IOException {
		CBVHHHVP MainPage = new CBVHHHVP(driver);
		System.out.println("Testcase 3:Chỉnh sửa học hàm học vị và kiểm tra Học hàm học vị được chỉnh sửa bên mục Cấp Bậc");
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"))
				.sendKeys("TestingKhangIntergrations");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr/td[5]/a[1]")).click();
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		// Lấy dữ liệu học kỳ từ ô đầu tiên của dòng đầu tiên
		XSSFRow row = sheet.getRow(16);
		String name = row.getCell(1).getStringCellValue();
		driver.findElement(NAMEHHHV).clear();
		driver.findElement(NAMEHHHV).sendKeys(name);
		savedID = name;
		Thread.sleep(2000);
		MainPage.SaveHHHVButton();
		System.out.println("=======");
		System.out.println("Chuyển sang mục Cấp Bậc");
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.AddCapBacButton();
		Thread.sleep(2000);
		String pageSource = driver.getPageSource();
		if (pageSource.contains(savedID)) {
			System.out.println("Dữ liệu " + savedID + " đã chỉnh sửa tại HHHV tồn tại ở mục Cấp Bậc ");
		} else {
			System.out.println("Dữ liệu " + savedID + " đã chỉnh sửa tại HHHV không tồn tại ở mục ");
		}
		System.out.println("============");
	}

	@Test(priority = 4)
	public void Action4() throws InterruptedException, IOException {
	    // Khởi tạo đối tượng CBVHHHVP để thực hiện các thao tác trên trang web
	    CBVHHHVP MainPage = new CBVHHHVP(driver);
	    // In ra console để thông báo bắt đầu thực hiện testcase
	    System.out.println("Testcase 4:Chỉnh sửa học hàm học vị và ấn Hủy và kiểm tra Học hàm học vị được chỉnh sửa bên mục Cấp Bậc");
	    // Di chuyển đến menu Hội họa, Hội vẽ
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Tìm và nhập từ khóa để tìm kiếm học hàm học vị cần chỉnh sửa
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"))
	            .sendKeys("TestingKhangIntergrations");
	    Thread.sleep(2000);
	    // Nhấn vào nút chỉnh sửa của học hàm học vị tìm được
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr/td[5]/a[1]")).click();
	    Thread.sleep(2000);
	    // Mở file Excel chứa dữ liệu để lấy dữ liệu học hàm học vị mới
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(16);
	    String name = row.getCell(2).getStringCellValue();
	    // Xóa dữ liệu hiện có trong trường Name và nhập dữ liệu mới
	    driver.findElement(NAMEHHHV).clear();
	    driver.findElement(NAMEHHHV).sendKeys(name);
	    savedID = name;
	    Thread.sleep(2000);
	    // Nhấn nút Hủy để hủy bỏ các thay đổi
	    MainPage.CloseButton();
	    System.out.println("=======");
	    System.out.println("Chuyển sang mục Cấp Bậc");
	    // Di chuyển đến mục Cấp Bậc trên giao diện
	    MainPage.CapBac();
	    Thread.sleep(2000);
	    // Tìm kiếm các cấp bậc với tên đã chỉnh sửa
	    MainPage.AddCapBacButton();
	    Thread.sleep(2000);
	    // Kiểm tra xem dữ liệu học hàm học vị mới đã được chỉnh sửa và tồn tại trong textbox tạo cấp bậc hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains(savedID)) {
	        System.out.println("Dữ liệu " + savedID + " đã Hủy chỉnh sửa tại HHHV tồn tại ở mục Cấp Bậc");
	    } else {
	        System.out.println("Dữ liệu " + savedID + " đã Hủy chỉnh sửa tại HHHV không tồn tại ở mục Cấp Bậc ");
	    }
	    System.out.println("============");
	}


	@Test(priority = 5)
	public void Action5() throws InterruptedException, IOException {
	    // Khởi tạo đối tượng CBVHHHVP để thực hiện các thao tác trên trang web
	    CBVHHHVP MainPage = new CBVHHHVP(driver);
	    // In ra console để thông báo bắt đầu thực hiện testcase
	    System.out.println("Testcase 5:Hủy xóa học hàm học vị và kiểm tra Học hàm học vị còn tồn tại bên mục Cấp Bậc");
	    // Di chuyển đến menu Hội họa, Hội vẽ
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Tìm và nhập từ khóa để tìm kiếm học hàm học vị cần hủy xóa
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"))
	            .sendKeys("TestingKhangIntergrations");
	    Thread.sleep(2000);
	    // Nhấn nút Hủy xóa của học hàm học vị cần hủy xóa
	    MainPage.CloseDeleteButton();
	    // Mở file Excel chứa dữ liệu để lấy dữ liệu học hàm học vị
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(14);
	    String name = row.getCell(1).getStringCellValue();
	    savedID = name;
	    Thread.sleep(2000);
	    System.out.println("=======");
	    System.out.println("Chuyển sang mục Cấp Bậc");
	    // Di chuyển đến mục Cấp Bậc trên giao diện
	    MainPage.CapBac();
	    Thread.sleep(3000);
	    MainPage.AddCapBacButton();
	    Thread.sleep(2000);
	    // Kiểm tra xem dữ liệu học hàm học vị đã được hủy xóa và còn tồn tại trong textbox tạo cấp bậc hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains(savedID)) {
	        System.out.println("Dữ liệu " + savedID + " đã Hủy xóa tại HHHV tồn tại ở mục Cấp Bậc ");
	    } else {
	        System.out.println("Dữ liệu " + savedID + " đã Hủy xóa tại HHHV không tồn tại ở mục Cấp Bậc ");
	    }
	    System.out.println("============");
	}

	@Test(priority = 6)
	public void Action6() throws InterruptedException, IOException {
	    // Khởi tạo đối tượng CBVHHHVP để thực hiện các thao tác trên trang web
	    CBVHHHVP MainPage = new CBVHHHVP(driver);
	    // In ra console để thông báo bắt đầu thực hiện testcase
	    System.out.println("Testcase 6:Xóa học hàm học vị đã có dữ liệu và kiểm tra Học hàm học vị tồn tại bên mục Cấp Bậc");
	    // Di chuyển đến menu Hội họa, Hội vẽ
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Tìm và nhập từ khóa để tìm kiếm học hàm học vị cần xóa
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"))
	            .sendKeys("TestingKhangIntergrations");
	    Thread.sleep(2000);
	    // Nhấn nút xóa của học hàm học vị cần xóa
	    MainPage.DeleteButton();
	    // Mở file Excel chứa dữ liệu để lấy dữ liệu học hàm học vị
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(14);
	    String name = row.getCell(1).getStringCellValue();
	    savedID = name;
	    Thread.sleep(2000);
	    System.out.println("=======");
	    System.out.println("Chuyển sang mục Cấp Bậc");
	    // Di chuyển đến mục Cấp Bậc trên giao diện
	    MainPage.CapBac();
	    Thread.sleep(3000);
	    MainPage.AddCapBacButton();
	    Thread.sleep(2000);
	    // Kiểm tra xem dữ liệu học hàm học vị đã được xóa và không còn tồn tại trong textbox tạo cấp bậc hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains(savedID)) {
	        System.out.println("Dữ liệu " + savedID + " đã Xóa trùng bị dữ liệu tại HHHV tồn tại ở mục Cấp Bậc ");
	    } else {
	        System.out.println("Dữ liệu " + savedID + " đã Xóa trùng bị dữ liệu tại HHHV không tồn tại ở mục Cấp Bậc ");
	    }
	    System.out.println("============");
	}

	@Test(priority = 7)
	public void Action7() throws InterruptedException, IOException {
	    // Khởi tạo đối tượng CBVHHHVP để thực hiện các thao tác trên trang web
	    CBVHHHVP MainPage = new CBVHHHVP(driver);
	    // In ra console để thông báo bắt đầu thực hiện testcase
	    System.out.println("Testcase 7:Tạo mới dữ liệu và xóa HHHV và kiểm tra bên mục Cấp Bậc");
	    // Di chuyển đến menu Hội họa, Hội vẽ
	    MainPage.HHHVMenu();
	    Thread.sleep(2000);
	    // Nhấn vào nút Thêm mới trong mục HHHV
	    MainPage.AddHHHVButton();
	    Thread.sleep(2000);
	    // Mở file Excel chứa dữ liệu để lấy dữ liệu học hàm học vị mới
	    FileInputStream fis = new FileInputStream("K:\\Automation\\HocHamHocVi.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    // Lấy dữ liệu từ file Excel
	    XSSFRow row = sheet.getRow(17);
	    String id = row.getCell(0).getStringCellValue();
	    String name = row.getCell(1).getStringCellValue();
	    // Nhập dữ liệu vào các trường ID và Name
	    driver.findElement(IDHHHV).sendKeys(id);
	    driver.findElement(NAMEHHHV).sendKeys(name);
	    savedID = name;
	    Thread.sleep(2000);
	    // Nhấn nút Lưu để lưu dữ liệu mới
	    MainPage.SaveHHHVButton();
	    Thread.sleep(2000);
	    // Tìm và nhập từ khóa để tìm kiếm học hàm học vị vừa tạo
	    driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input")).sendKeys(name);
	    Thread.sleep(2000);
	    // Nhấn nút Xóa để xóa học hàm học vị vừa tạo
	    MainPage.DeleteButton();
	    Thread.sleep(2000);
	    System.out.println("=======");
	    System.out.println("Chuyển sang mục Cấp Bậc");
	    // Di chuyển đến mục Cấp Bậc trên giao diện
	    MainPage.CapBac();
	    Thread.sleep(2000);
	    MainPage.AddCapBacButton();
	    Thread.sleep(2000);
	    // Kiểm tra xem dữ liệu học hàm học vị đã được xóa và không còn tồn tại trong textbox tạo cấp bậc hay không
	    String pageSource = driver.getPageSource();
	    if (pageSource.contains(savedID)) {
	        System.out.println("Dữ liệu " + savedID + " đã Xóa tại HHHV tồn tại ở mục textbox thêm tạo Cấp Bậc ");
	    } else {
	        System.out.println("Dữ liệu " + savedID + " đã Xóa tại HHHV không tồn tại ở mục textbox tạo Cấp Bậc ");
	    }
	}

	}

