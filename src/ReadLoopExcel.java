import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadLoopExcel {
	static WebDriver driver = new FirefoxDriver();
	String baseURL = "http://live.guru99.com/index.php/customer/account/create/";
	@BeforeTest
	public void beforeTest() {
		//maximize browser
		driver.manage().window().maximize();
	}
	@Test
	public void DataDriven1() throws Exception{
		try {
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
			for (int row = 1; row <4 ; row++) {
				for (int col = 1; col < 6; col++) {
					//open browser
					driver.get(baseURL);
					
					//Fill data from excel
					String FirstName=ExcelUtils.getCellData(row, col);
					String LastName=ExcelUtils.getCellData(row, col);
					String Email=ExcelUtils.getCellData(row, col);
					String Pass=ExcelUtils.getCellData(row, col);
					String ConfirmPass = ExcelUtils.getCellData(row, col);
					
					System.out.println(FirstName);
					System.out.println(LastName);
					System.out.println(Email);
					System.out.println(Pass);
					
					BaseCommon.RegisterWith(driver, FirstName, LastName, Email, Pass, ConfirmPass);	
					BaseCommon.Goto_Logout(driver);
					
				}
			}

		} catch (IOException e) {
			System.out.println("Test data file not found");
		} 
	}
}
