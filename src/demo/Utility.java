package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.marionette","");
		WebDriver driver = new FirefoxDriver();
		driver.get("c:\\index.html");
		List<WebElement> we = driver.findElements(By.tagName("input"));
for(int i =0;i<we.size();i++)
{
	System.out.println(we.get(i).getText());
}
	}

}
