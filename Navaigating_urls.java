package SeleniumPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Navaigating_urls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/");
		
		driver.navigate().to("https:www.yahoo.com/");
		System.out.println("URL is: "+driver.getCurrentUrl());
		
		driver.navigate().back();
		System.out.println("URL is: " + driver.getCurrentUrl());
		
		driver.navigate().forward();
		
		
		
		driver.navigate().refresh();
		System.out.println("Url is: " + driver.getCurrentUrl());
		System.out.println("Page Siurce is: " + driver.getPageSource());
	}

}
