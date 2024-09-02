package todo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RadioButton {
	
	private static WebDriver driver;
	
	public RadioButton(WebDriver web) {
		this.driver = web;
	}
	
	public static void clickRadioButton() throws InterruptedException{
	
	//radio button
			WebElement radio1 = driver.findElement(By.className("radioButton"));
			radio1.click();
			boolean radio1Status = radio1.isSelected();
			Assert.assertEquals(true, radio1Status);
			System.out.println("heeheheeRadio1");
			
			Thread.sleep(2000);

			WebElement radio2 = driver.findElement(By.xpath("//*[@class='left-align']/fieldset/label[2]/input"));
			radio2.click();
			boolean radio2Status = radio2.isSelected();
			Assert.assertEquals(true, radio2Status);
			System.out.println("heeheheeRadio2");
	}
}
