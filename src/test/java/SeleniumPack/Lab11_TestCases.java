package SeleniumPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab11_TestCases {
    WebDriver driver;
    Lab11_Locators page;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");
        page = new Lab11_Locators(driver);
    }

    @Test
    public void testLabFlow() throws InterruptedException {
      
        Assert.assertEquals(page.getTitle(), "Your Store", "Title mismatch!");

        page.clickDesktops();
        page.clickMac();

        Assert.assertEquals(page.verifyMacHeading(), "Mac", "Mac heading not verified!");

        page.selectSortByNameAZ();

        page.clickAddToCart();
        Assert.assertTrue(page.isSuccessMsgDisplayed(), "Success message not displayed!");

        page.searchProduct("Mobile");
        Thread.sleep(2000);

        page.clearSearchCriteria();
        Thread.sleep(1000);

        page.searchWithDescription("Monitors");
        Thread.sleep(2000);
    }

    public void tearDown() {
        driver.quit();
    }
}
