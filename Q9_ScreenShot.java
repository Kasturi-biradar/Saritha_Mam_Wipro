package Question;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q9_ScreenShot {
	WebDriver driver;
	 String projectpath=System.getProperty("user.dir")  ;
  @Test
  
  public void f() throws IOException {
	  driver.get("https://www.wikipedia.org/");
	  File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  File dest = new File(projectpath + "\\Q9_Screenshot.png" );
	  FileUtils.copyFile(src,dest);
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
