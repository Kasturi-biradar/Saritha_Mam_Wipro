package Question;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils; // Add commons-io dependency
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

public class Q4_Dropdown_Extent {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setup() {
        // Setup Extent Report
        String reportPath = System.getProperty("user.dir") + "/reports/DropdownTestReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void f() {
        test = extent.createTest("Dropdown Test");

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement dropdown = driver.findElement(By.name("my-select"));

        Select select = new Select(dropdown);
        select.selectByVisibleText("Two");

        String selectedOption = select.getFirstSelectedOption().getText();
        test.log(Status.INFO, "Selected option: " + selectedOption);

        Assert.assertEquals(selectedOption, "Two");
        test.log(Status.PASS, "Dropdown selection is correct");
    }

    @AfterMethod
    public void afterTest(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = takeScreenshot(result.getName());
            test.log(Status.FAIL, "Test Failed");
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed");
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
        extent.flush();
    }
}
