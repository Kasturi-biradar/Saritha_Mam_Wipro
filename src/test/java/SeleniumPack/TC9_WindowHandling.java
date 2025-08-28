package SeleniumPack;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

;

public class TC9_WindowHandling {
	public static void main (String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/window");
		
		driver.findElement(By.id("home")).click();
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentWindow);
		System.out.println("url is: " + driver.getCurrentUrl());
		
		driver.findElement(By.id("multi")).click();
		Set<String> multiWindows = driver.getWindowHandles();
		for(String eachWindow : multiWindows) {
			driver.switchTo().window(eachWindow);
			System.out.println("url is: " + driver.getCurrentUrl());
		}
		
		driver.close();
		driver.quit();
	}
}
