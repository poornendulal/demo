package demo.demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import demo.Automation;

public class AutomationTest {
  @Test
  public void login() {

	  System.out.println("testNG login hello");
    
  }
  @Test
  public void clicklink() {

	  System.out.println("testNG click link hello");
    
  }
  @Test
  public void clicklinkfailed() {
String str[] = {""};
char operation[]= {'k','a'};
Automation a = new Automation();
WebDriver driver = null ;
a.run(driver, operation, str, str);
	  System.out.println("testNG click link hello");
    
  }
}
