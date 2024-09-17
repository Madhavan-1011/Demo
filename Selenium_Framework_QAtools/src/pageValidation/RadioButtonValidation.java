package pageValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import resources.DriverObjects;
import resources.Utilities;

public class RadioButtonValidation {
	
	private WebDriver driver;

	public RadioButtonValidation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickYes() throws InterruptedException {
		Utilities utilities = new Utilities();
		utilities.gotoTab("Elements", "Radio Button");	
		WebElement yes = driver.findElement(By.xpath("//label[contains(text(),'Yes') and @checked]"));
		//yes.click();
		Assert.assertTrue(yes.isEnabled());
		System.out.println("yes is Enabled");
	}
	
	public void clickImpressive() throws InterruptedException {
		Utilities utilities = new Utilities();
		utilities.gotoTab("Elements", "Radio Button");	
		WebElement Impressive = driver.findElement(By.xpath("//label[contains(text(),'Impressive')]"));
		Impressive.click();
		Assert.assertTrue(Impressive.isEnabled());
		System.out.println("Impressive is Enabled");
	}

}
