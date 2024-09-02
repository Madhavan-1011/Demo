package todo;

import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-geolocation");
		options.addArguments("enable-strict-powerful-feature-restrictions");
		options.addArguments("disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		//driver.get("https://www.spicejet.com/");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		/*
		WebElement fromLocation = driver.findElement(By.cssSelector("div[data-testid='to-testID-origin'] div div:nth-of-type(1)"));
		fromLocation.sendKeys(Keys.ENTER, "BL");
		System.out.println("Printing BL");
		
		List<WebElement> listOfLocFrom = driver.findElements(By.cssSelector("div.r-1dqxon3 div div div div"));
		System.out.println("fetched locations");

		for(WebElement loc: listOfLocFrom) {
			if(loc.getText().equals("Bengaluru")) {
				System.out.println(loc.getText());
				loc.click();
				break;
				
			}
		}
		
		System.out.println("BL selected");
		WebElement selectedLoc = driver.findElement(By.cssSelector("div[data-testid='to-testID-origin'] div:nth-child(2) input"));
		System.out.println(selectedLoc.getAttribute("value"));
		Assert.assertEquals(selectedLoc.getAttribute("value"), "Bengaluru (BLR)");
		
		Actions actions = new Actions(driver);
		actions.sendKeys("d").perform();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("div.r-1x0uki6 div:nth-child(2) div.r-1ozqkpa")).click();
		List<WebElement> listOfLocTo = driver.findElements(By.cssSelector("div.r-1dqxon3 div div div div"));
		for(WebElement loc: listOfLocTo) {
			if(loc.getText().equals("Dubai")) {
				System.out.println(loc.getText());
				loc.click();
				break;
			}
		}
		System.out.println("Dubai selected");
		String selectedToLoc = driver.findElement(By.cssSelector("div[data-testid='to-testID-destination'] div div input"))
			.getAttribute("value");
		Assert.assertEquals(selectedToLoc, "Dubai (DXB)");
		
		String bookingMon = "June";
		String bookingDate = "1";
		String currentCal = driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']/div[3]/div[2]/div/div/div/div[1]/div")).getText();
		String currentMon = currentCal.split(" ")[0];
		System.out.println(currentMon);


		if(currentMon.equalsIgnoreCase(bookingMon)) {
			List<WebElement> dates = driver.findElements(By.xpath("//div[@data-testid='undefined-calendar-picker']/div[3]/div[2]/div/div[2]/div/div[3]/div/div/div/div"));
			
			List<WebElement> date = dates.stream().sorted().collect(Collectors.toList());
			Collections.reverse(date);
			for(int i = 0; i < dates.size(); i++) {
				String date = dates.get(i).getText();			
				System.out.println(date);

				if(date.equals(bookingDate)) {
					System.out.println("Inside in loop");
					driver.findElement(By
							.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div["+bookingDate+"]"))
					.click();
				}

		}
			
	}*/
		
		WebElement radiobutton1 = driver.findElement(By.cssSelector("label[for='radio1'] input"));
		radiobutton1.click();
		System.out.println(radiobutton1.isDisplayed());
		System.out.println(radiobutton1.isEnabled());
	}

}
