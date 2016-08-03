import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseCommon {
	WebDriver driver;
	public static By linkRegister = By.xpath("//a[contains(text(),'Register')]"); 
	//Login
	public static By linkAccount = By.xpath(".//a/span[contains(text(),'Account')]");
	public static By linkLogin = By.xpath("//a[contains(text(),'Log In')]"); 

	//Logout
	public static By linkLogout = By.xpath(".//a[contains(text(),'Log Out')]");


	public static By txtFirstName = By.id("firstname");
	public static By txtLastName = By.id("lastname");
	public static By txtEmail = By.id("email_address");
	public static By txtPass = By.id("password");
	public static By txtConfirm = By.id("confirmation");
	public static By btnSubmit = By.xpath(".//button[@title='Register']");

	/*
	 * Register Function with First Name, Last Name, Email, Pass, ConfirmPass
	 */
	public static void RegisterWith(WebDriver driver,String First, String Last,String Email, String Pass, String Confirm) {
		driver.findElement(txtFirstName).sendKeys(First);
		driver.findElement(txtLastName).sendKeys(Last);
		driver.findElement(txtEmail).sendKeys(Email);
		driver.findElement(txtPass).sendKeys(Pass);
		driver.findElement(txtConfirm).sendKeys(Confirm);
		driver.findElement(btnSubmit).click();
	}
	/*
	 * Get random number
	 */
	public static int getRandomNumber(int number){
		int randomNumber=0;
		Random objGenerator = new Random();
		for (int iCount = 0; iCount< number; iCount++){
			randomNumber = objGenerator.nextInt(10000);
		}
		return randomNumber;
	}

	public static void Goto_Logout(WebDriver driver) { 
		driver.findElement(linkAccount).click();
		driver.findElement(linkLogout).click();
	}
}
