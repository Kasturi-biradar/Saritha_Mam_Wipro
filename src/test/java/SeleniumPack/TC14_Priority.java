package SeleniumPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC14_Priority {
  
  @Test(priority=3)
  public void test1() {
      System.out.println("This is test1");
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.get("https://www.amazon.in/");
  }
  
  @Test(priority=1)
  public void test2() {
      System.out.println("This is test2");
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.get("http://yahoo.com/");
  }
  
  @Test(priority=2)
  public void test3() {
      System.out.println("This is test3");
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.get("https://www.myntra.com/");
  }
}
