package SeleniumPack;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab11_forTestCases_exact_as_lab_used_advance {
    WebDriver driver;
    Lab11_forLocators_exact_as_lab_used_advance page;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");
        page = new Lab11_forLocators_exact_as_lab_used_advance(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void testLabFlow() {
        // Step 1: Verify title
        Assert.assertEquals(page.getTitle(), "Your Store", "Title mismatch!");

        // Step 2: Go to Desktops > Mac
        page.clickDesktops();
        page.clickMac();

        // Step 3: Verify Mac heading
        Assert.assertEquals(page.verifyMacHeading(), "Mac", "Mac heading not verified!");

        // Step 4: Sort by Name(A-Z)
        page.selectSortByNameAZ();

        // Step 5: Add to cart
        page.clickAddToCart();
        Assert.assertTrue(page.isSuccessMsgDisplayed(), "Success message not displayed!");

        // Step 6: Search Mobile
        page.searchProduct("Mobile");
        wait.until(ExpectedConditions.visibilityOf(page.searchCriteria));

        // Step 7: Clear search box
        page.clearSearchCriteria();
        wait.until(ExpectedConditions.visibilityOf(page.searchCriteria));

        // Step 8: Search Monitors with description checked
        page.searchWithDescription("Monitors");
        wait.until(ExpectedConditions.visibilityOf(page.searchCriteria));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
