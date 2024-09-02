import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".large-12.columns a")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentTab = it.next();
		String childTab = it.next();
		driver.switchTo().window(childTab);
		System.out.print(driver.findElement(By.cssSelector(".example")).getText());
		driver.switchTo().window(parentTab);
		System.out.print("\n");
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());

	}

}
