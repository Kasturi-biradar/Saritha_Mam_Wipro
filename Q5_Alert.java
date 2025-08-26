package Question;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q5_Alert {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  WebElement alertBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
	  alertBtn.click();
	  Thread.sleep(2000);
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	 String alertSuccess = driver.findElement(By.id("result")).getText();
	 Assert.assertTrue(alertSuccess.contains("You successfully clicked an alert"));
  }
  @BeforeClass
  public void setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
}
