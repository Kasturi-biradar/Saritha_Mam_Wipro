package Question;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils; // Add commons-io dependency
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q8_MultipleWindowsHandle_Extent {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setup() {
        // Setup Extent Report
        String reportPath = System.getProperty("user.dir") + "/reports/MultipleWindowsReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void handleMultipleWindows() {
        test = extent.createTest("Multiple Windows Handle Test");

        driver.get("https://the-internet.herokuapp.com/windows");
        test.log(Status.INFO, "Navigated to the page.");

        String parent = driver.getWindowHandle();
        WebElement clickBtn = driver.findElement(By.linkText("Click Here"));
        clickBtn.click();
        test.log(Status.INFO, "Clicked on 'Click Here' to open a new window.");

        Set<String> windows = driver.getWindowHandles();
        for (String win : windows) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);
                String childTitle = driver.getTitle();
                test.log(Status.INFO, "Child window title: " + childTitle);
                driver.close();
                test.log(Status.INFO, "Closed the child window.");
            }
        }

        driver.switchTo().window(parent);
        String parentTitle = driver.getTitle();
        test.log(Status.INFO, "Back to parent window, title: " + parentTitle);
        test.log(Status.PASS, "Multiple windows handled successfully.");
    }

    @AfterMethod
    public void afterTest(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = takeScreenshot(result.getName());
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed.");
        }
    }

    public String takeScreenshot(String testName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timeStamp + ".png";
        File dest = new File(path);
        FileUtils.copyFile(src, dest);
        return path;
    }

    @AfterClass
    public void close() {
        driver.quit();
        extent.flush(); // Generates the report
    }
}
