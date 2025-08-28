package Question;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1_GoogleLaunch {
	 WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://www.google.com");
	  String title = driver.getTitle();
	  System.out.println("The title is: " + title);
  }
  @BeforeClass
  public void setup() {
	  WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
  @AfterClass
  public void close() {
	  driver.quit();
  }
}




