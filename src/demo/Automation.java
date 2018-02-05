package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automation {
	public boolean run(WebDriver driver, char[] operation, String[] control, String[] testdata) {
		StringBuilder log = new StringBuilder();
		try {

			int j = 0;
			int i = 0;
			int k = 0;
			for (i = 0; i < operation.length; i++) {
				log.append("Loop counters value i=" + i + " and j=" + j + " and k=" + k);
				if (operation[i] == 'i') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.id(control[j++])));
					log.append(webElement1a.getAttribute("Type")
							+ " Type identified. SendKeys command will be performed with '" + testdata[k]);
					webElement1a.sendKeys(testdata[k++]);
				} else if (operation[i] == 'b') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.id(control[j++])));
					log.append(
							webElement1a.getAttribute("Type") + " Type identified. Click command will be performed.");
					webElement1a.click();
				} else if (operation[i] == 'a') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(control[j++])));
					log.append(webElement1a.getTagName() + " control identified. Click command will be processed.");
					webElement1a.click();
				} else if (operation[i] == 'r') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.name(control[j++])));
					log.append(
							webElement1a.getAttribute("Type") + " Type identified. Click command will be processed.");
					webElement1a.click();
				} else if (operation[i] == 'd') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.id(control[j++])));
					log.append(
							webElement1a.getTagName() + " control identified. Select command will be performed with '"
									+ testdata[k] + "' test data.");
				} else if (operation[i] == 'v') {
					WebDriverWait waiter = new WebDriverWait(driver, 30);
					WebElement webElement1a = waiter
							.until(ExpectedConditions.visibilityOfElementLocated(By.id(control[j++])));

					log.append(webElement1a.getTagName() + " control identified. Verification will be performed with '"
							+ testdata[k] + "' test data.");
					if (webElement1a.getText().contains(testdata[k])) {
						log.append(webElement1a.getText() + " contains the test data " + testdata[k]);
					} else {
						log.append(webElement1a.getText() + " does not contain the test data " + testdata[k]);
					}
				}
			}
			return true;
		} catch (Exception e) {
			log.append("Unhandled Exception occured ! " + e.toString());
			return false;
		}
	}
}
