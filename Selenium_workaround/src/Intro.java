import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class Intro {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//driver.get("https://www.google.com");
		//System.out.println(driver.getTitle());	
		//driver.findElement(By.id("APjFqb")).sendKeys("youtube"+ Keys.ENTER);
		Intro a = new Intro();		
		a.tabSwitchTest(driver);
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.get("https://www.youtube.com");
		//system.out.println("openedtab is "+driver.getTitle());
		
		//driver.quit();

	}

	public static void addRemoveTest(WebDriver driver) throws InterruptedException 
{
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Add Element')]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Element')]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Element')]"));
		
		int j=driver.findElements(By.className("added-manually")).size();
		Thread.sleep(2000);
		for(int i = 0; i<j; i++)
		{
			driver.findElement(By.className("added-manually")).click();
		}
		//System.out.println("Hello");
		//return "Maddy";

	}
	
	public static void navigateTest(WebDriver driver)
	{
		driver.get("https://google.com");
		driver.navigate().to("https://gmail.com");
		driver.navigate().back();
	}
	
	public static void dropdownTest(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		//checkbox
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		Thread.sleep(500);
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		Assert.assertEquals(driver.findElements(By.cssSelector("div[id='discount-checkbox'] input[type='checkbox']")).size(), 5);
		
		
		//static dropdown
		//System.out.println(dropdown.getFirstSelectedOption().getText());
		Select dropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		dropdown.selectByIndex(3);
		Thread.sleep(500);
		dropdown.selectByVisibleText("AED");
		
		
		//selective dropdown
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(500);
		int i = 1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
		

		//Dynamic dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='PNY']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='COK']")).click();
				
		
		//Calendar
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("ui-state-default.ui-state-highlight.ui-state-active")).click();
		//if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
			//driver.findElement(By.name("ctl00$mainContent$view_date2")).click();
			//Thread.sleep(1000);
			//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
			//Thread.sleep(1000);		

		
		//Radio
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		
		
		//Autosuggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option: options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
			option.click();
			break;
			}
			
		}
		driver.quit();
		System.out.print("Execution Successfull!!");
	
	}
	
	public static void alertTest(WebDriver driver) throws InterruptedException
	{
		String name = "Maddy";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		//System.out.println(driver.switchTo().alert().getText());
		String alertMsg = driver.switchTo().alert().getText();
		Assert.assertTrue(alertMsg.contains("Hello "+name+", share this practice page and share your knowledge"));
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("confirmbtn")).click();
		Assert.assertTrue(driver.switchTo().alert().getText().contains("Hello "+name+", Are you sure you want to confirm?"));
		driver.switchTo().alert().dismiss();
		
		driver.quit();
		System.out.print("Execution Success!!!");
	}	

	public void cartTest(WebDriver driver) throws InterruptedException
	{
		String[] vegList = {"Cucumber","Carrot","Potato","Pista","Walnuts"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		List veg = Arrays.asList(vegList);
		int j = 0;

		for(int i=0; i<products.size(); i++)
		{
			String[] product = products.get(i).getText().split("-");
			String name = product[0].trim();
			
			if(veg.contains(name))
			{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if(j==vegList.length)
				{
					break;
				}
			}	
		}
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		/*
		List<WebElement> cart = driver.findElements(By.xpath("//p[@class='product-name']/button"));
		Assert.assertEquals(vegList, cart);
		for(int k=0; k<cart.size(); k++)
		{
			String[] cartItem = cart.get(k).getText().split("-");
			String checkList = cartItem[0].trim();
			
			if(veg.contains(checkList))
			{
				Assert.assertTrue(true);
			}
		}*/
		//driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("promoCode")));
		//Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("Maddy");
		driver.findElement(By.className("promoBtn")).click();
		//Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
	
		//driver.quit();
	}
	
	public void actionsTest(WebDriver driver)
	{
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("[class='nav-a nav-a-2   nav-progressive-attribute'] span"))).contextClick().build().perform();
		a.moveToElement(driver.findElement(By.cssSelector(".nav-search-field input"))).click().keyDown(Keys.SHIFT).sendKeys("L")
		.keyUp(Keys.SHIFT).sendKeys("aptop", Keys.ENTER).build().perform();
		
		
	}
	
	public void tabSwitchTest(WebDriver driver)
	{
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL).moveToElement(driver.findElement(By.cssSelector(".blinkingText"))).click().build().perform();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentTab = it.next();
		String childTab = it.next();
		driver.switchTo().window(childTab);
		
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentTab);
		driver.findElement(By.id("password")).sendKeys(emailId);
		driver.findElement(By.id("username")).sendKeys(emailId);
		driver.findElement(By.id("password")).sendKeys(emailId);
		driver.findElement(By.id("terms")).isSelected();
		driver.findElement(By.id("signInBtn")).click();
		
	}
}
