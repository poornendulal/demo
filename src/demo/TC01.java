package demo;

public class TC01 {
	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "C:\\driver\\IEDriverServer.exe");
		char[] operation = { 'i', 'i', 'b', 'd', 'v', 'a', 'r', 'v' };
		String[] control = { "userName", "password", "submit", "dropdownid", "divverify", "Flights", "tripType",
				"verify" };
		String[] testdata = { "username", "password", "Option1", "div", "Verification" };
		Initialize init = new Initialize("http://www.yahoo.com");
		System.out.println(init.driver);
		System.out.println("did i wait ?");
		Automation automate = new Automation();
		automate.run(init.driver, operation, control, testdata);
		init.driver.quit();
	}
}
