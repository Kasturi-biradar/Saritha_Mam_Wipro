package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		String email = "defnfgnhh1h23k" + System.currentTimeMillis() + "@gmail.com";
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Kasturi");
		driver.findElement(By.id("input-lastname")).sendKeys("Biradar");
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys("82178645");
		driver.findElement(By.id("input-password")).sendKeys("Kasturi@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Kasturi@123");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys("Kasturi@123");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		System.out.println("Login successfull");
		Thread.sleep(3000);
		//Lab-6
		WebElement components = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a"));
		components.click();
		WebElement Monitors = driver.findElement(By.linkText("Monitors (2)"));
		Monitors.click();
		
		WebElement showDropdown = driver.findElement(By.id("input-limit"));
		Select selectfromDropdown = new Select(showDropdown);
		selectfromDropdown.selectByIndex(1);
		
		
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]"));
		addToCart.click();
		Thread.sleep(3000);
		WebElement specification = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[2]/a"));
		specification.click();
		if(specification.isDisplayed()) {
			System.out.println("specification verified");
		}
		
		WebElement addtoWishListBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]"));
		addtoWishListBtn.click();
		Thread.sleep(3000);
		WebElement addtoWishtext = driver.findElement(By.cssSelector(".alert-success"));
		System.out.println(addtoWishtext.getText());
		if(addtoWishtext.getText().contains(addtoWishtext.getText())) {
			System.out.println("Wish list text verified");
		}
		Thread.sleep(3000);
		WebElement searchMobile = driver.findElement(By.name("search"));
		searchMobile.sendKeys("Mobile");
		Thread.sleep(3000);
		WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
		searchBtn.click();
		Thread.sleep(3000);
		WebElement descriptionCheckBox = driver.findElement(By.name("description"));
		descriptionCheckBox.click();
		Thread.sleep(3000);
		WebElement searchBtnCheck = driver.findElement(By.id("button-search"));
		searchBtnCheck.click();
		Thread.sleep(3000);
		WebElement HTCLink = driver.findElement(By.linkText("HTC Touch HD"));
		HTCLink.click();
		Thread.sleep(3000);
		WebElement quantity = driver.findElement(By.id("input-quantity"));
		quantity.clear();
		quantity.sendKeys("3");
		Thread.sleep(3000);
		 WebElement addCart = driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
		 addCart.click();
		 
		Thread.sleep(4000);
		
//		WebElement cartVerifyMsg = driver.findElement(By.cssSelector(".alert-success"));
//		Thread.sleep(3000);
//		String cartText = cartVerifyMsg.getText();
//		System.out.println(cartText);
//		Thread.sleep(3000);
//		if(cartText.contains("Success: You have added HTC Touch HD to your shopping cart!")) {
//			System.out.println("Added to cart msg verified");
//		}
//		Thread.sleep(3000);
		WebElement viewCartBtn = driver.findElement(By.xpath("//*[@id=\"cart\"]/button"));
		viewCartBtn.click();
		Thread.sleep(3000);
		WebElement viewCart = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong"));
		viewCart.click();
		Thread.sleep(3000);
		WebElement mobileName = driver.findElement(By.linkText("HTC Touch HD"));
		System.out.println(mobileName.getText());
		if(mobileName.getText().contains("HTC Touch HD")) {
			System.out.println("Mobile name verified");
		}
		Thread.sleep(3000);
		WebElement checkoutBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a"));
		checkoutBtn.click();
		Thread.sleep(3000);
		WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		MyAccount.click();
		Thread.sleep(3000);
		WebElement LogOut = driver.findElement( By.linkText("Logout"));
		LogOut.click();
		Thread.sleep(3000);
	}

}
