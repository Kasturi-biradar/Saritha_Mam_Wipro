package Question;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q8_MultipleWindowsHandle {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://the-internet.herokuapp.com/windows");
	  String parent = driver.getWindowHandle();
	  WebElement clickBtn = driver.findElement(By.linkText("Click Here"));
	  clickBtn.click();
	  Set<String> windows = driver.getWindowHandles();
	  for(String win : windows ) {
		  if(!win.equals(parent)) {
		  driver.switchTo().window(win);
			  System.out.println(driver.getTitle());
			  driver.close();
		  }
	  }
			  driver.switchTo().window(parent);
			  System.out.println(driver.getTitle());
		  }
	  
  
  @BeforeClass
  public void setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
			 
  }
}
