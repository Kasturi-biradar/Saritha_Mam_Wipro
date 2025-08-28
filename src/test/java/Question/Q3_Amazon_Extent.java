package Question;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils; // commons-io dependency required
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class Q3_Amazon_Extent {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setup() {
        // Extent report setup
        String reportPath = System.getProperty("user.dir") + "/reports/AmazonSearchReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void f() throws InterruptedException {
        test = extent.createTest("Amazon Search Test");
        driver.get("https://www.amazon.in/");
        Thread.sleep(3000);

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("laptop", Keys.ENTER);
        Thread.sleep(3000);

        List<WebElement> products = driver.findElements(By.cssSelector("h2.a-size-medium"));
        System.out.println("First 5 products name:");
        test.log(Status.INFO, "Printing first 5 product names from Amazon search.");

        for (int i = 0; i < 5 && i < products.size(); i++) {
            String productName = products.get(i).getText();
            System.out.println((i + 1) + ": " + productName);
            test.log(Status.INFO, (i + 1) + ": " + productName);
        }
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
