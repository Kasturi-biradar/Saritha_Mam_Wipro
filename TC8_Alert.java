package SeleniumPack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC8_Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://letcode.in/alert");
		driver.findElement(By.id("accept")).click();
		Alert simAlert = driver.switchTo().alert();
		System.out.println("The Messgae is " + simAlert.getText());
		simAlert.accept();
		
		driver.findElement(By.id("confirm")).click();
		Alert confirmAlert = driver.switchTo().alert();
		System.out.println("The Messgae is " + confirmAlert.getText());
		confirmAlert.dismiss();
		
		driver.findElement(By.id("prompt")).click();
		Alert promptAlert = driver.switchTo().alert();
		System.out.println("The Messgae is " + promptAlert.getText());
		promptAlert.sendKeys("Hii");
		promptAlert.accept();
	}

}
