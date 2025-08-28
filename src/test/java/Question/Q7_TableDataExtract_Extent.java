package Question;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
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

public class Q7_TableDataExtract_Extent {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeClass
	public void setup() {
		// Set up Extent Report
		ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/Q7_TableDataExtractReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void f() {
		test = extent.createTest("Extract Table Data and Jason Email");

		driver.get("https://the-internet.herokuapp.com/tables");
		test.log(Status.INFO, "Opened the table page");

		List<WebElement> firstNames = driver.findElements(By.xpath("//html/body/div[2]/div/div/table[1]/tbody/tr/td[2]"));
		test.log(Status.INFO, "Fetched first names");

		System.out.println("First Names: ");
		for (WebElement name : firstNames) {
			System.out.println(name.getText());
			test.log(Status.INFO, "First Name: " + name.getText());
		}

		WebElement emailOfJason = driver.findElement(By.xpath("//html//body//table[1]//tr[3]//td[3]"));
		String emailOfJasonText = emailOfJason.getText();
		System.out.println("Jason's Email: " + emailOfJasonText);
		test.log(Status.PASS, "Jason's Email fetched: " + emailOfJasonText);
	}

	@AfterMethod
	public void captureResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
			test.addScreenCaptureFromPath(takeScreenshot(result.getName()));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Passed");
			test.addScreenCaptureFromPath(takeScreenshot(result.getName()));
		}
	}

	public String takeScreenshot(String testName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/" + testName + ".png";
		FileUtils.copyFile(src, new File(path));
		return path;
	}

	@AfterClass
	public void close() {
		driver.quit();
		extent.flush();
	}
}
