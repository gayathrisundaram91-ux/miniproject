package miniProject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Demoblaze extends BrowserLaunch {

	public static void login() throws InterruptedException {
		WebElement login = driver.findElement(By.id("login2"));
		login.click();
		Thread.sleep(-3000);
		WebElement	userName = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		userName.sendKeys("gayathri91");
		
		WebElement password = driver.findElement(By.xpath("(//input[@class='form-control'])[6]"));
		password.sendKeys("gayathri91");
		
		WebElement login_btn = driver.findElement(By.xpath("//button[text()='Log in']"));
		login_btn.click();
		
	}
	
	public static void screenShot(String fileName) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc = new File("C:\\Users\\Gayathri Vignesh\\eclipse-workspace\\miniProject\\Screenshot" +fileName+ ".png");
		
		try {
			FileHandler.copy(src, desc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void add_Product_ToCart() throws InterruptedException {
		
		WebElement laptop = driver.findElement(By.xpath("(//a[@class='list-group-item'])[3]"));
		laptop.click();
		
		WebElement sony = driver.findElement(By.xpath("//a[text()='Sony vaio i5']"));
		String sony_text = sony.getText();
		sony.click();
		
		Thread.sleep(3000);
		
		WebElement add_to_cart = driver.findElement(By.xpath("//a[text()='Add to cart']"));
		add_to_cart.click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement cart_btn = driver.findElement(By.id("cartur"));
		cart_btn.click();
		
		Thread.sleep(3000);
		screenShot("cartpage");
		WebElement product_title_text = driver.findElement(By.xpath("//td[text()='Sony vaio i5']"));
		if(sony_text.equals(product_title_text.getText())) {
			System.out.println("It is true");
		}
		
		WebElement place_Order = driver.findElement(By.xpath("//button[text()='Place Order']"));
		//Thread.sleep(3000);

		String placeorder_btn_text = place_Order.getText();
		place_Order.click();
		
		Thread.sleep(3000);

		WebElement expected_prod_text = driver.findElement(By.xpath("//h5[text()='Place order']"));
		String Product_titile_text = expected_prod_text.getText();
		
		if (placeorder_btn_text.equalsIgnoreCase(expected_prod_text.getText())) {
		    System.out.println("Both text is matching");
		}

		//if(placeorder_btn_text.equals(Product_titile_text)) {
//		if(placeorder_btn_text.equals(expected_prod_text.getText())) {
//			
//			System.out.println("Both text is matching");
//		}
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("K.Gayathri");
		
		WebElement country = driver.findElement(By.id("country"));
		country.sendKeys("India");
		
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Chennai");
		
		WebElement card = driver.findElement(By.id("card"));
		card.sendKeys("2457 59867 5784");
		
		WebElement month = driver.findElement(By.id("month"));
		month.sendKeys("December");
		
		WebElement year = driver.findElement(By.id("year"));
		year.sendKeys("2029");
		
		Thread.sleep(3000);
		WebElement purchase_btn = driver.findElement(By.xpath("//button[text()='Purchase']"));
		purchase_btn.click();
		
		WebElement thank_you = driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']"));
		System.out.println(thank_you.getText());
		
		WebElement prod_pur_detail = driver.findElement(By.xpath("//p[@class='lead text-muted ']"));
		System.out.println(prod_pur_detail.getText());
		
		Thread.sleep(3000);
		
		screenShot("purchase_detail");
		
		WebElement ok_btn = driver.findElement(By.xpath("//button[text()='OK']"));
		ok_btn.click();
		
		Thread.sleep(6000);
		
		WebElement logout = driver.findElement(By.id("logout2"));
		logout.click();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		launchBrowser();
		launchUrl("https://www.demoblaze.com/index.html");
		login();
		Thread.sleep(3000);
		screenShot("DemoBlaze_Login");
		add_Product_ToCart();
		
		
	}
}
