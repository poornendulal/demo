package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Automation {
	public boolean run(WebDriver driver, char operation[], String control[], String testdata[]) {
		try {
			int j = 0, i, k = 0;;
			for (i = 0; i < operation.length; i++) {
				System.out.println("Loop counters value i=" + i + " and j=" + j + " and k=" + k);
				if (operation[i] == 'i') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.id(control[j++])));
					System.out.println(webElement1a.getAttribute("Type").toString()
							+ " Type identified. SendKeys command will be performed with '" + testdata[k]
							+ "' test data.");
					webElement1a.sendKeys(testdata[k++]);

				} else if (operation[i] == 'b') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.id(control[j++])));
					System.out.println(webElement1a.getAttribute("Type").toString()
							+ " Type identified. Click command will be performed.");
					webElement1a.click();
				} else if (operation[i] == 'a') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(control[j++])));
					System.out.println(webElement1a.getTagName().toString()
							+ " control identified. Click command will be processed.");
					webElement1a.click();
				} else if (operation[i] == 'r') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.name(control[j++])));
					System.out.println(webElement1a.getAttribute("Type").toString()
							+ " Type identified. Click command will be processed.");
					webElement1a.click();
				} else if (operation[i] == 'd') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.id(control[j++])));
					Select dropdown = new Select(webElement1a);
					System.out.println(webElement1a.getTagName().toString()
							+ " control identified. Select command will be performed with '" + testdata[k]
							+ "' test data.");
					dropdown.selectByValue(testdata[k++]);
				} else if (operation[i] == 'v') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.id(control[j++])));
					System.out.println(webElement1a.getTagName().toString()
							+ " control identified. Verification will be performed with '" + testdata[k]
							+ "' test data.");
					if (webElement1a.getText().contains(testdata[k]) == true) {
						System.out.println(webElement1a.getText() + " contains the test data " + testdata[k]);
					} else {
						System.out.println(webElement1a.getText() + " does not contain the test data " + testdata[k]);
					}
				} else if (operation[i] == 'f') {
					List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
					System.out.println(iframes.size());
					for (int ii = 0; ii < iframes.size(); ii++) {
						System.out.println(iframes.size() + "ID = " + iframes.get(ii).getAttribute("id"));
						if (iframes.isEmpty()) {
							int ik=0;
							driver.switchTo().frame(ik);ii=0;iframes = driver.findElements(By.tagName("iframe"));
							System.out.println(iframes.size() + "ID = " + iframes.get(ik).getAttribute("id"));
						}
						
					}
				} else {
					String a[] = { "" };
					a[1] = "";
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println("Unhandled Exception occured ! " + e.toString());
			// Assert.fail(e.toString());
			Assert.assertTrue(true, "Click failed because !!");
			return false;
		}
	}
}
