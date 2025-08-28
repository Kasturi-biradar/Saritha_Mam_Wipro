package Question;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q7_TableDataExtract {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://the-internet.herokuapp.com/tables");
	  List<WebElement> firstNames = driver.findElements(By.xpath("//html/body/div[2]/div/div /table[1]/tbody/tr/td[2]"));
	  System.out.println("First Names: ");
	  for(int i=0;i<firstNames.size();i++) {
		  firstNames.get(i).getText();
		  System.out.println(  firstNames.get(i).getText());
	  }
	  WebElement emailOfJason  = driver.findElement(By.xpath("//html//body//table[1]//tr[3]//td[3]"));
	  String emailOfJasonText = emailOfJason.getText();
	  System.out.println(emailOfJasonText);
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
