package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practiceTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		System.out.println("Number of rows: "+rowCount);
		
		int colCount = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th")).size();
		System.out.println("Number of Columns: "+colCount);
		
		driver.quit();
	}

}
