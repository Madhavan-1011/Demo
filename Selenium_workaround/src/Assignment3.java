import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Maddy");
		driver.findElement(By.name("email")).sendKeys("Maddy@123");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("maddy");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		Select dropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		dropdown.selectByIndex(0);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("10/11/1997");
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
		WebElement alrtMsg = driver.findElement(By.cssSelector(".alert-success"));
		String submitMsg = alrtMsg.getText().toString().replace("×", "").trim();
		//Assert.assertEquals(submitMsg.contains("Success! The Form has been submitted successful"),true, "Error Occured");
		Assert.assertEquals(submitMsg, "Success! The Form has been submitted successfully!.");
		System.out.println(submitMsg);
		driver.quit();
		System.out.print("Execution Successful!!");

	}

}
