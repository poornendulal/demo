package demo;

public class TC2 {
	public static void main(String[] args) {
		 System.setProperty("webdriver.firefox.marionette", "");

		char operation[] = { 'i', 'i', 'b', 'd', 'v', 'a', 'r', 'v' };
		String control[] = { "userName", "password", "submit", "dropdownid", "divverify", "Flights", "tripType",
				"verify" };
		String testdata[] = { "username", "password", "Option1", "div", "Verification" };

		Initialize init = new Initialize("file://c:/index.html");
		Automation automate = new Automation();
		automate.run(init.driver, operation, control, testdata);
		init.driver.quit();
	}
}
