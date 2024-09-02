
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import todo.AutoSuggestion;
import todo.RadioButton;
import todo.SelectiveDropdown;

public class practice {

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		RadioButton radioButton = new RadioButton(driver);
		radioButton.clickRadioButton();
		
		String pageName = driver.findElement(By.xpath("//h1[contains(text(),'Practice Page')]")).getText();
		System.out.println(pageName);
		
		AutoSuggestion autosugg = new AutoSuggestion(driver);
		autosugg.getAutoSuggest("Ind");
		
		SelectiveDropdown selDropdown = new SelectiveDropdown(driver);
		selDropdown.selDropdown();
		
		
	}
}
