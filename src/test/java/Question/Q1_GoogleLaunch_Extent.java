package Question;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1_GoogleLaunch_Extent {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setup() {
        // Setup Extent Report
        String reportPath = System.getProperty("user.dir") + "/reports/Q1_GoogleLaunchReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void launchGoogle() {
        test = extent.createTest("Google Launch Test");
        try {
            driver.get("https://www.google.com");
            String title = driver.getTitle();
            test.info("Navigated to Google");
            test.pass("Page title is: " + title);

            // Take Screenshot
            String screenshotPath = takeScreenshot("GoogleHome");
            test.addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    public String takeScreenshot(String fileName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String dest = System.getProperty("user.dir") + "/screenshots/" + fileName + "_" + dateName + ".png";
        File finalDest = new File(dest);
        FileUtils.copyFile(src, finalDest);
        return dest;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush(); // Generate the report
    }
}
