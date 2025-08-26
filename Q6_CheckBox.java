package Question;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q6_CheckBox {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.get("https://the-internet.herokuapp.com/checkboxes");
	  List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes input[type='checkbox']"));
	  for(WebElement checkbox : checkboxes) {
		  if(!checkbox.isSelected()) {
			  Thread.sleep(1000);
			  checkbox.click();
		  }
	  

	  }
  
  for(WebElement checkbox : checkboxes) {
  Assert.assertTrue(checkbox.isSelected());
  }
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
