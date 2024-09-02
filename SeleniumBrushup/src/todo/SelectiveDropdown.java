package todo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectiveDropdown {
	
	private WebDriver driver;
	
	public SelectiveDropdown(WebDriver webdriver) {
		this.driver = webdriver;
	}
	
	public void selDropdown() {
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Option3");
		System.out.println(dropdown.getText());
	}

}
