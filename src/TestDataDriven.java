import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestDataDriven {
	static WebDriver driver = new FirefoxDriver();
	String baseURL = "http://live.guru99.com/index.php/customer/account/create/";
	@BeforeTest
	public void beforeTest() {
		//open browser
		driver.get(baseURL);

		//maximize browser
		driver.manage().window().maximize();
	}
	@Test
	public void DataDriven1() throws Exception{
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		String FirstName=ExcelUtils.getCellData(1, 1);
		String LastName=ExcelUtils.getCellData(1, 2);
		String Email=ExcelUtils.getCellData(1, 3);
		String Pass=ExcelUtils.getCellData(1, 4);
		String ConfirmPass = ExcelUtils.getCellData(1, 5);
		BaseCommon.RegisterWith(driver, FirstName, LastName, Email, Pass, ConfirmPass);	
	}

}
