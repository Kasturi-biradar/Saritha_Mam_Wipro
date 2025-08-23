package SeleniumPack;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Providing_Data_Using_CSVFile_ToDataProvider {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @DataProvider(name = "dp")
    public Object[][] dp() throws IOException, CsvException {
        String csvFile = projectPath + "\\DATACSV.csv"; // Ensure CSV file exists at this path
        CSVReader csvReader = new CSVReader(new FileReader(csvFile));
        List<String[]> csvData = csvReader.readAll();
        csvReader.close();

        // Skip header if present
        int rows = csvData.size();
        Object[][] data = new Object[rows][2];
        for (int i = 0; i < rows; i++) {
            data[i][0] = csvData.get(i)[0];
            data[i][1] = csvData.get(i)[1];
        }
        return data;
    }

    @Test(dataProvider = "dp")
    public void loginTest(String username, String password) throws InterruptedException {
        String title = driver.getTitle();
        System.out.println("The Title is: " + title);
        Thread.sleep(3000);

        // Example with PageFactory (if you have login_PageFactory class)
        // login_PageFactory obj = PageFactory.initElements(driver, login_PageFactory.class);
        // obj.enterusername(username);
        // obj.enterpassword(password);
        // obj.clickonlogin();

        // Or direct locators:
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Just a sample assertion after login
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard") ||
                driver.getPageSource().contains("Invalid credentials"));
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
