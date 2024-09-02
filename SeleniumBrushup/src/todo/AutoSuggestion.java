package todo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoSuggestion {
	
	public static WebDriver driver;

	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));

	public AutoSuggestion(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public static void getAutoSuggest(String suggKey) throws InterruptedException {
		WebElement suggBox = driver.findElement(By.cssSelector("input.ui-autocomplete-input"));
		suggBox.sendKeys(suggKey, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.ENTER);
		System.out.println(suggBox.getText());
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("li[id='ui-id-9']"))));
		//driver.findElement(By.xpath("//*[@id='ui-id-9']")).click();
		//Assert.assertEquals(driver.findElement(By.id("autocomplete")).getText(), "India");
		System.out.println(driver.findElement(By.xpath("//*[contains(text(),'Suggession Class Example')]")).getText());
	}
	
}
