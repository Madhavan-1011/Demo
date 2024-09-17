package resources;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageObjects {
	
	private WebDriver driver;

	public PageObjects(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebDriver openQATools() {
		driver.get("https://demoqa.com/elements");
		return driver;
	}
	
	public void getTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "DEMOQA");
		System.out.println("Title of the page is "+ title);
	}

	public void closeTab() {
		System.out.println("Closing current tab");
		driver.quit();
	}
}
