package miniProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {
	public static WebDriver driver;
	int name;
	public static void launchBrowser() {
		driver=new ChromeDriver();
		
		//driver.manage().window().maximize();

	}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	

	
}
