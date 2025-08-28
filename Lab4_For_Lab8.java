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

public class Lab4_For_Lab8 {
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
    public void lab4Flow() throws InterruptedException {
       
        String title = driver.getTitle();
        Assert.assertEquals(title, "Your Store");
        Reporter.log("Page title verified: " + title, true);

        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();

        WebElement macHeading = driver.findElement(By.linkText("Mac"));
        Assert.assertEquals(macHeading.getText(), "Mac");
        Reporter.log("Mac heading verified successfully", true);

        WebElement sortDropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A - Z)");

        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Monitors");
        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();

        WebElement criteria = driver.findElement(By.name("search"));
        criteria.clear();
        criteria.sendKeys("Monitors");
        driver.findElement(By.name("description")).click();
        driver.findElement(By.id("button-search")).click();

        Reporter.log("Search with Monitors completed successfully", true);
    }
}
