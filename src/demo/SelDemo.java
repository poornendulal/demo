package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SelDemo {
	public static WebDriver driver;
	public static void main (String arge[]) throws InterruptedException, MalformedURLException
	{
		
		String URL = "http://www.google.com";
 		String Node = "http://9.193.102.106:4444/wd/hub";
 		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
 
 		driver = new RemoteWebDriver(new URL(Node), cap);
 
 		driver.navigate().to(URL);
 		Thread.sleep(5000);
 		driver.quit();
 		System.out.println("Hellow");
	}
}
