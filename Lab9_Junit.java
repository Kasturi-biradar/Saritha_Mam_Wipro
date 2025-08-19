package SeleniumPack;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class Lab9_Junit{

    void performTest(String browser) throws InterruptedException {
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/index.php");

        if (!driver.getTitle().equals("Your Store")) {
            System.out.println(browser + " : Title mismatch!");
        }

        
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac")).click();

        // Verify Mac heading
        String heading = driver.findElement(By.tagName("h2")).getText();
        if (!heading.equals("Mac")) {
            System.out.println(browser + " : Heading mismatch!");
        }

   
        Select sort = new Select(driver.findElement(By.id("input-sort")));
        sort.selectByVisibleText("Name (A - Z)");

        driver.findElement(By.xpath("//button[@data-original-title='Add to Cart']")).click();

        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Monitors");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(2000);

        searchBox.clear();
        driver.findElement(By.name("description")).click();
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(2000);

        driver.quit();
    }

    @Test
    public void testOnChrome() throws InterruptedException {
        performTest("chrome");
    }

    @Test
    public void testOnIE() throws InterruptedException {
        performTest("ie");
    }
}
