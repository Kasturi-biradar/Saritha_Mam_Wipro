package SeleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC4_FindElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		System.out.println("Total links in Amazon.in : "+ allLink.size());
		
		for(WebElement link : allLink) {
			System.out.println("The link is: " + link.getAttribute("href"));
			System.out.println("The link text: " +link.getText());
		}
	}

}
