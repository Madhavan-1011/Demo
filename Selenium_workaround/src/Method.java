import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method addRemove = new Method();
		addRemove.addRemoveTest();
		
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		//Dynamic dropdown
		//Thread.sleep(500);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

	}
	
	public void addRemoveTest() {
		System.out.println("Hello!!!");
	}

}
