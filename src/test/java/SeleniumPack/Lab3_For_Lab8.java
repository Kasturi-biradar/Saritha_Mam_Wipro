package SeleniumPack;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Lab3_For_Lab8 {
    WebDriver driver;

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

    @Test
    public void lab3Flow() throws InterruptedException {
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();

        WebElement sortDropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A - Z)");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
        WebElement successMsg = driver.findElement(By.xpath("//*[@id=\"product-category\"]/div[1]"));

        Assert.assertTrue(successMsg.isDisplayed(), "Success message not displayed!");
        Reporter.log("Lab3 Test Passed: Add to cart success message displayed", true);
    }
}
