package selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class practice {

	@Test
	public void testcase1() {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		List<WebElement> list = dropdown.getOptions();
		
		ArrayList actuallist = new ArrayList();
		for(WebElement ele : list)
		{
			String data = ele.getText();
			actuallist.add(data);
			//System.out.println(data);
		}
		System.out.println(actuallist);
		
		List templist =new ArrayList();
		templist.addAll(actuallist);
		Collections.sort(templist);
		System.out.println(templist);
		Assert.assertTrue(templist.equals(actuallist));
		
	}

}
