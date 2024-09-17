import resources.DriverObjects;
import resources.PageObjects;
import resources.TextBoxTab;
import resources.Utilities;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pageValidation.CheckBoxValidation;
import pageValidation.RadioButtonValidation;
import pageValidation.TextTabValidation;

public class ElementTab {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		DriverObjects driverObjects = new DriverObjects();
		WebDriver driver = driverObjects.initializeWebDriver();
		//to get page title
		PageObjects page = new PageObjects(driver);
		page.openQATools();
		page.getTitle();

		//to validate text box
		//TextTabValidation textTabValidation = new TextTabValidation(driver);
		//textTabValidation.validateTextTab();
		
		//to validate check box
		//CheckBoxValidation checkBoxValidation =new CheckBoxValidation(driver);
		//checkBoxValidation.validateCheckTab();
		
		//to validate radioButton
		RadioButtonValidation radioButtonValidation= new RadioButtonValidation(driver);
		radioButtonValidation.clickYes();
		radioButtonValidation.clickImpressive();
		
		Thread.sleep(2000);
		//page.closeTab();
	}

}
