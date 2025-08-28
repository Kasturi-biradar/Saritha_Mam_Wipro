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

public class Lab4_For_TestNG {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String title = driver.getTitle();
	  if(title.equals("Your Store")) {
		  System.out.println("Title Verified");
	  }
	  
	  driver.findElement(By.linkText("Desktops")).click();
	  driver.findElement(By.linkText("Mac (1)")).click();
	 WebElement macHeading =  driver.findElement(By.linkText("Mac"));
	 System.out.println(macHeading.getText());
	 if(macHeading.getText().equals("Mac")) {
		 System.out.println("Mac Heading Verified");
	 }else { System.out.println("Mac Heading not Verified");}
	  
	  WebElement sortDropdown = driver.findElement(By.id("input-sort"));
	  Select select = new Select(sortDropdown);
	  select.selectByVisibleText("Name (A - Z)");
	  WebElement successMsg = driver.findElement(By.xpath("//*[@id=\"product-category\"]/div[1]"));
	  successMsg.getText();
	  driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Mobile");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.name("search")).clear();
	  Thread.sleep(3000);
	  driver.findElement(By.name("description")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
	  driver.findElement(By.name("search")).clear();
	  driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Moniters");
	  Thread.sleep(3000);
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
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
	  driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
