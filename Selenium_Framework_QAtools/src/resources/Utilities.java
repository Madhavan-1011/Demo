package resources;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities extends DriverObjects{

	public void gotoTab(String tab, String menu) throws InterruptedException {
		List<WebElement> tabNames = driver.findElements(By.xpath("//div[@class='element-group']//div[@class='header-text']"));
		for(int i = 0; i < tabNames.size(); i++) {  
			String tabName = tabNames.get(i).getText();
		    //System.out.println(tabNames.get(i).getText());
		    if(tabName.equalsIgnoreCase(tab)) {
		    	List<WebElement> tabList = driver.findElements(By.xpath("//div[@class='element-group']//div[@class='element-list collapse show']/ul/li/span"));
		    	for(int j = 0; j < tabList.size(); j++) {  
					String list = tabList.get(j).getText();
					//System.out.println("listname "+list);
					if(tabList.get(j).getText().equals(menu)) {
						System.out.println("Page has been selected");
						Thread.sleep(2000);
						boolean present = true;
						do{
						try {
							waitForClickableElement(tabList.get(j));
							tabList.get(j).click();
							present = true;
							Thread.sleep(2000);
							String pageTitle = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']//h1")).getText();
						    System.out.println("Page title :" +pageTitle);
						} catch (ElementClickInterceptedException e) {
							present = false;
							JavascriptExecutor js = (JavascriptExecutor)driver;
							js.executeScript("window.scrollBy(0,250)", "");
							Thread.sleep(4000);
							waitForClickableElement(tabList.get(j));
							tabList.get(j).click();
							String pageTitle = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']//h1")).getText();
						    System.out.println("Page title :" +pageTitle);
						}
						}while(present = false);
					}
		    	}
		    }
		}
	}
}
