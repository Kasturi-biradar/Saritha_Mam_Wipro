package SeleniumPack;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Lab3_For_TestNG {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.linkText("Desktops")).click();
	  driver.findElement(By.linkText("Mac (1)")).click();
	  WebElement sortDropdown = driver.findElement(By.id("input-sort"));
	  Select select = new Select(sortDropdown);
	  select.selectByVisibleText("Name (A - Z)");
	  driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
	  WebElement successMsg = driver.findElement(By.xpath("//*[@id=\"product-category\"]/div[1]"));
	  if(successMsg.isDisplayed()) {
		  System.out.println("Success message is displayed");
		  Thread.sleep(2000);
	  }
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before each Test Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After each Test Method");
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://tutorialsninja.com/demo/index.php");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class: Quit WebDriver");
      driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test: TestNG BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test: TestNG AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite: TestNG BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite: TestNG AfterSuite");
  }

}
