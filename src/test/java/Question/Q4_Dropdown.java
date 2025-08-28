package Question;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q4_Dropdown {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://www.selenium.dev/selenium/web/web-form.html");
	  WebElement dropdown = driver.findElement(By.name("my-select"));
	  Select select = new Select(dropdown);
	  select.selectByVisibleText("Two");
	  Assert.assertEquals(select.getFirstSelectedOption().getText(),"Two");
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
