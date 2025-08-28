package SeleniumPack;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12 {
    WebDriver driver;
    Properties prob;

    @BeforeClass
    public void setUp() throws IOException {
        
        prob = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Kavya Para\\git\\github.com\\Kasturi-biradar\\Saritha_Mam_Wipro\\Wipro\\config.property");
        prob.load(fis);

        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        
        driver.get(prob.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void lab12Flow() throws InterruptedException {
        
        String expectedTitle = "Your Store";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Reporter.log("Page title verified: " + actualTitle, true);

        
        driver.findElement(By.linkText(prob.getProperty("desktop_tab"))).click();
        driver.findElement(By.linkText(prob.getProperty("mac_link"))).click();

        
        WebElement macHeading = driver.findElement(By.linkText(prob.getProperty("mac_heading")));
        Assert.assertEquals(macHeading.getText(), "Mac");
        Reporter.log("Mac heading verified successfully", true);

       
        WebElement sortDropdown = driver.findElement(By.id(prob.getProperty("sort_dropdown")));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(prob.getProperty("sort_option"));

 
        driver.findElement(By.xpath(prob.getProperty("search_box"))).sendKeys("Monitors");
        driver.findElement(By.xpath(prob.getProperty("search_button"))).click();

        WebElement criteria = driver.findElement(By.name(prob.getProperty("search_criteria")));
        criteria.clear();
        criteria.sendKeys("Monitors");

        driver.findElement(By.name(prob.getProperty("description_checkbox"))).click();
        driver.findElement(By.id(prob.getProperty("final_search_button"))).click();

        Reporter.log("Search with Monitors completed successfully", true);
    }
}
