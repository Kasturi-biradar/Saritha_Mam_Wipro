

package SeleniumPack;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Lab15 {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @DataProvider(name = "userData")
    public Object[][] userData() throws IOException, CsvException {
        String csvFile = projectPath + "\\Lab15CSV.csv"; // Ensure the CSV file path is correct
        CSVReader csvReader = new CSVReader(new FileReader(csvFile));
        List<String[]> csvData = csvReader.readAll();
        csvReader.close();

        // Skip header row
        int rows = csvData.size() - 1;
        Object[][] data = new Object[rows][5];
        for (int i = 1; i <= rows; i++) {
            data[i - 1][0] = csvData.get(i)[0]; // First Name
            data[i - 1][1] = csvData.get(i)[1]; // Last Name
            data[i - 1][2] = csvData.get(i)[2]; // Email
            data[i - 1][3] = csvData.get(i)[3]; // Telephone
            data[i - 1][4] = csvData.get(i)[4]; // Password
        }
        return data;
    }

    @Test(dataProvider = "userData")
    public void registerUser(String firstName, String lastName, String email, String telephone, String password) throws InterruptedException {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Your Store", "Title mismatch!");

        // Click on My Account -> Register
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // Verify Register Account page
        Assert.assertTrue(driver.getPageSource().contains("Register Account"), "Register Account page not found!");

        // Fill details from CSV
        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(password);

        // Agree to privacy policy
        driver.findElement(By.name("agree")).click();

        // Click Continue
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Verify success message
        Assert.assertTrue(driver.getPageSource().contains("Your Account Has Been Created"), "Account creation message not found!");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}
