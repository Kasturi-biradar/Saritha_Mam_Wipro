package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC7_Select_Dropdown {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		WebElement Desktop = driver.findElement(By.linkText("Desktops"));
		Desktop.click();
		WebElement Mac = driver.findElement(By.linkText("Mac (1)"));
		Mac.click();
		
		WebElement sort = driver.findElement(By.id("input-sort"));
		Select slct = new Select(sort);
//		slct.selectByIndex(5);
		
		List<WebElement> eleCount = slct.getOptions();
		for(int i=0;i<eleCount.size();i++) {
			System.out.println(eleCount.get(i).getText());
		}
	}

}
