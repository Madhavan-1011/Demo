package resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckBoxTab {
	
	@FindBy(xpath = "//span[@class='rct-checkbox']")
	WebElement home;
	
	@FindBy(xpath = "//span[@class='rct-text'][1]/button")
	WebElement mainToggle;
	
	@FindBy(xpath = "//div[@id='result']/span[@class='text-success']")
	List<WebElement> successElement;

	private WebDriver driver;
	
	public CheckBoxTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
		
	public void clickHome() throws InterruptedException {
		boolean status =  home.isSelected();
		if(status == false) {
			home.click();
			status =  home.isEnabled();
		}
		Assert.assertTrue(status);
	}
	
	public void verifyAllResult() {
		List<String> expectedResult = Arrays.asList("home","desktop","notes","commands","documents","workspace","react","angular","veu","office","public","private","classified","general","downloads","wordFile","excelFile");
		//List<WebElement> result = driver.findElements(By.xpath("//div[@id='result']/span[@class='text-success']"));
		compareResult(expectedResult);
	}
	
	public void verifyResult() {
		boolean status =  home.isEnabled();
		if(status == true)
			home.click();
		mainToggle.click();
		driver.findElement(By.xpath("//*[text()='Downloads']/parent::label/span[1]")).click();	
		List<String> expectedResult = Arrays.asList("downloads","wordFile","excelFile");
		compareResult(expectedResult);
	}
	
	public void compareResult(List<String> expectedResult) {
		List<WebElement> result = successElement;
		List<String> actualResult = new ArrayList<String>();
		for(WebElement i:result) {
			actualResult.add(i.getText());
			//System.out.println(i.getText());
		}
		
		Assert.assertTrue(actualResult.containsAll(expectedResult));
		System.out.println("actualResult is matching with expectedResult");
	}
}
