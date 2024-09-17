package pageValidation;

import org.openqa.selenium.WebDriver;

import resources.CheckBoxTab;
import resources.Utilities;

public class CheckBoxValidation {
	
	private WebDriver driver;

	public CheckBoxValidation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateCheckTab() throws InterruptedException {
		Utilities utilities = new Utilities();
		utilities.gotoTab("Elements", "Check Box");	
		
		CheckBoxTab checkBoxTab = new CheckBoxTab(driver);
		checkBoxTab.clickHome();
		checkBoxTab.verifyAllResult();
		checkBoxTab.verifyResult();
	}
}
