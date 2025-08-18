package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC5_Keys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php?");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		if(driver.findElement(By.id("email_create")).isDisplayed()){
			System.out.println("email create is displayed");
			driver.findElement(By.id("email_create")).clear();
			driver.findElement(By.id("email_create")).sendKeys("system@gmail.com");
			driver.findElement(By.id("email_create")).sendKeys(Keys.TAB);
			driver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
		}else {
			System.out.println("Email create is not displayed");
		}
				
		
	}

}
