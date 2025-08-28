package Question;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q9_ScreenShot_Extent {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	ExtentReports extent;
	ExtentTest test;

	@BeforeClass
	public void setup() {
		// Setup Extent Report
		ExtentSparkReporter spark = new ExtentSparkReporter(projectPath + "\\ExtentReport_Q9.html");
		spark.config().setDocumentTitle("Wikipedia Screenshot Test");
		spark.config().setReportName("Screenshot Report");
		spark.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(spark);

		// Setup WebDriver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void takeScreenshotTest() throws IOException {
		test = extent.createTest("Wikipedia Screenshot Test");
		try {
			driver.get("https://www.wikipedia.org/");
			test.info("Navigated to Wikipedia");

			// Capture screenshot
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destPath = projectPath + "\\Q9_Screenshot.png";
			File dest = new File(destPath);
			FileUtils.copyFile(src, dest);

			test.pass("Screenshot taken successfully")
				.addScreenCaptureFromPath(destPath);

		} catch (Exception e) {
			test.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@AfterClass
	public void close() {
		driver.quit();
		extent.flush(); // Generates the report
	}
}
