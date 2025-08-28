package Question;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q2_Login {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://the-internet.herokuapp.com/login");
	  WebElement userName = driver.findElement(By.name("username"));
	  userName.sendKeys("tomsmith");
	  WebElement password = driver.findElement(By.name("password"));
	  password.sendKeys("SuperSecretPassword!");
	  WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
	  loginBtn.click();
	  WebElement loginMsg = driver.findElement(By.id("flash"));
	   String loginMsgText = loginMsg.getText();
	   System.out.println(loginMsgText);
	    Assert.assertTrue(loginMsgText.contains("You logged into a secure area!"));
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
