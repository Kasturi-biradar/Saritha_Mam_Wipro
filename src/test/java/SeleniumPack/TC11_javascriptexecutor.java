package SeleniumPack;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC11_javascriptexecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('Hello');");   //(for alert)
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");  (scroll By to end)
//		js.executeScript("window.scrollBy(0,2000)");   (scroll By to middle)
		
	}

}
