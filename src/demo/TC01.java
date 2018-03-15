package demo;

public class TC01 {
	public static void main(String[] args) {
		System.out.println("hellow ");
		
		System.setProperty("webdriver.ie.driver", "C:\\iedriver\\IEDriverServer.exe");
		char[] operation = { 'i', 'b', 'v'};
		String[] control = { "lst-ib", "btnK", "resultStats" };
		String[] testdata = { "this is automation test engineering demo", "seconds"};
		Initialize init = new Initialize("https://www.google.co.uk");
		
		Automation automate = new Automation();
		automate.run(init.driver, operation, control, testdata);
		init.driver.quit();
	}
}
