package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Initialize {
	protected WebDriver driver = new InternetExplorerDriver();
	public Initialize(String URL) throws InterruptedException {
		System.out.println("test");
		//driver.manage().window().setSize(new Dimension(500,500));
		
    driver.get(URL);

    System.out.println(getCallerClassName());
}
	    public static String getCallerClassName() { 
	        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
	        for (int i=1; i<stElements.length; i++) {
	            StackTraceElement ste = stElements[i];
	            if (!ste.getClassName().equals(Initialize.class.getName()) && ste.getClassName().indexOf("java.lang.Thread")!=0) {
	                return ste.getClassName();
	            }
	        }
	        return null;
	     }
	
}
