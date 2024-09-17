package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TextBoxTab {
	
	@FindBy(id = "userName")
	public WebElement name;
	
	@FindBy(id = "userEmail")
	public WebElement email;
	
	@FindBy(id = "currentAddress")
	public WebElement currentAddress;

	@FindBy(id = "permanentAddress")
	public WebElement permanentAddress;
	
	@FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
	public WebElement submit;

	public WebDriver driver;
	
	public TextBoxTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String userName) {
		name.sendKeys(userName);
	}
	
	public void setUserEmail(String userEmail) {
		email.sendKeys(userEmail);
	}
	
	public void setcurAddress(String curAddress) {
		currentAddress.sendKeys(curAddress);
	}
	
	public void setperAddress(String perAddress) {
		permanentAddress.sendKeys(perAddress);
	}
	
	public void submit() {
		DriverObjects d = new DriverObjects();
		d.waitForClickableElement(submit);
		submit.click();
	}
}
