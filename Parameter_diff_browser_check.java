package SeleniumPack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;


import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameter_diff_browser_check {
	@Parameters("browser")
	
@Test
  public void f(String browser) {
	  if(browser.equalsIgnoreCase("chrome"))
	  {
	  WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver();
	  driver.get("https://www.flipkart.com/");
	  }
	  else if( browser.equalsIgnoreCase("firefox")){
		  WebDriverManager.firefoxdriver().setup();
			 WebDriver driver = new FirefoxDriver();
		  driver.get("https://www.flipkart.com/");
	  }
	  else if(browser.equalsIgnoreCase("edge")){
		  WebDriverManager.edgedriver().setup();
			 WebDriver  driver = new EdgeDriver();
		  driver.get("https://www.flipkart.com/");
	  }

  }
}
