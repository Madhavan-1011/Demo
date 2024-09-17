package pageValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import resources.TextBoxTab;
import resources.Utilities;

public class TextTabValidation {
	
	public WebDriver driver;
	
	public TextTabValidation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validateTextTab() throws InterruptedException {

		Utilities utilities = new Utilities();
		utilities.gotoTab("Elements", "Text Box");
		
		String name = "Maddy";
		String email = "maddy@gmail.com";
		String curaddress = "dummy current address";
		String peraddress ="dummy permanent address";
		
		TextBoxTab textBoxTab = new TextBoxTab(driver);
		textBoxTab.setUserName(name);
		textBoxTab.setUserEmail(email);
		textBoxTab.setcurAddress(curaddress);
		textBoxTab.setperAddress(peraddress);
		textBoxTab.submit();

		validateResult(name, email, curaddress, peraddress);
	}
	
	public void validateResult(String userName, String userEmail, String curAddress, String PerAddress) {
		String[] resultName = driver.findElement(By.id("name")).getText().split(":");
		Assert.assertEquals(resultName[1], userName);
		System.out.println("Name validation done");
		
		String[] resultMail = driver.findElement(By.id("email")).getText().split(":");
		Assert.assertEquals(resultMail[1], userEmail);
		System.out.println("email validation done");
		
		String[] resultCurAdd = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText().split(":");
		Assert.assertEquals(resultCurAdd[1], curAddress);
		System.out.println("currentAddress validation done");
		
		String[] resultPerAdd = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText().split(":");
		Assert.assertEquals(resultPerAdd[1], PerAddress);
		System.out.println("permanentAddress validation done");
	}

}
