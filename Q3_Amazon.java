//package Question;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Q3_Amazon {
//	WebDriver driver;
//  @Test
//  public void f() throws InterruptedException {
//	  Thread.sleep(3000);
//	  driver.get("https://www.amazon.in/");
//	  Thread.sleep(3000);
//	  WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
//	  search.sendKeys("laptop",Keys.ENTER);
//	  Thread.sleep(3000);
//	  List<WebElement> products = driver.findElements(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"));
//	  System.out.println("First 5 products name");
//	  for(int i=0;i<5 && i<products.size();i++) {
//		
//		  System.out.println((i+1)+ ": " + products.get(i).getText());
//  }
//  }
//  @BeforeClass
//  public void setup() {
//	  WebDriverManager.chromedriver().setup();
//	  driver = new ChromeDriver();
//	  driver.manage().window().maximize();
//	  
//		  
//	  
//  }
//  @AfterClass
//  public void close() {
//	  driver.quit();
//  }
//}
package Question;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Q3_Amazon {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchLaptop() throws InterruptedException {
        driver.get("https://www.amazon.in/");
        Thread.sleep(4000);
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("laptop", Keys.ENTER);

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id=\"CardInstancej7A5IlyLkvlby8rdPyGx9A\"]/div/div/div[1]/div/div[1]/div/div[2]/div/a/span/span[2]")
            
        ));

        List<WebElement> products = driver.findElements(By.xpath("//*[@id=\"CardInstancej7A5IlyLkvlby8rdPyGx9A\"]/div/div/div[1]/div/div[1]/div/div[2]/div/a/span/span[2]"));
        System.out.println("First 5 product names:");
        for (int i = 0; i < 5 && i < products.size(); i++) {
            System.out.println((i + 1) + ": " + products.get(i).getText());
        }
    }
@AfterClass
public void close() {
	driver.quit();
}
   
}
