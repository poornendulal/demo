package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SeleniumSample {
	public static void main(String[] args) throws InterruptedException {
        char operation[]= {'i','i','b','v','a','r','d','v'};
        String control[]= {"userName", "password","submit","divverify","Flights","tripType","dropdownid","verify"};
      	String testdata[] = {"username","password","div","option1","Verification"};      	
        new SeleniumSample().generalize(operation, control,testdata);
	}
	
	public void generalize(char operation[], String control[], String testdata[])
	{
		System.setProperty("webdriver.firefox.marionette","");
		WebDriver driver = new FirefoxDriver();
        String baseUrl = "c:\\index.html";
        driver.get(baseUrl);
		int j=0, i, k=0;
		for( i=0;i<operation.length;i++)
		{
			System.out.println("Loop counters value i=" + i +" and j="+ j +" and k="+k);
			if (operation[i]=='i')
			{
				 WebDriverWait waiter = new WebDriverWait(driver, 30);
			     WebElement webElement1a = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id(control[j++])));
			     System.out.println(webElement1a.getAttribute("Type").toString()+" Type identified. SendKeys command will be performed with '"+testdata[k]+"' test data.");
			     webElement1a.sendKeys(testdata[k++]);
			}else if (operation[i]=='b')
			{
				WebDriverWait waiter = new WebDriverWait(driver, 30);
			    WebElement webElement1a = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id(control[j++])));
			    System.out.println(webElement1a.getAttribute("Type").toString()+" Type identified. Click command will be performed.");
			    webElement1a.click();
			}else if (operation[i]=='a')
			{
				WebDriverWait waiter = new WebDriverWait(driver, 30);
			    WebElement webElement1a = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(control[j++])));
			    System.out.println(webElement1a.getTagName().toString()+" control identified. Click command will be processed.");
			    webElement1a.click();
			}else if (operation[i]=='r')
			{
				WebDriverWait waiter = new WebDriverWait(driver, 30);
			    WebElement webElement1a = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.name(control[j++])));
			    System.out.println(webElement1a.getAttribute("Type").toString()+" Type identified. Click command will be processed.");
			    webElement1a.click();
			}else if (operation[i]=='d')//drop down to be implemented
			{
				j++;k++;
				/*WebDriverWait waiter = new WebDriverWait(driver, 30);
			    WebElement webElement1a = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.name(control[j++])));
			    System.out.println(webElement1a.getAttribute("Type").toString()+" Type identified. Click command will be processed.");
			    webElement1a.click();*/
			}else if (operation[i]=='v')
			{
				WebDriverWait waiter = new WebDriverWait(driver, 30);
			    WebElement webElement1a = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id(control[j++])));
			    System.out.println(webElement1a.getTagName().toString()+" control identified. Verification will be performed with '" +testdata[k]+ "' test data.");
			    if(webElement1a.getText().contains(testdata[k])==true)
			    {
			    	System.out.println(webElement1a.getText() +" contains the test data " + testdata[k]);
			    }else
			    {
			    	System.out.println(webElement1a.getText() +" does not contain the test data " + testdata[k]);
			    }
			}
		}
		driver.quit();
	}

}
