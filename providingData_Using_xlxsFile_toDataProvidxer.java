package SeleniumPack;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class providingData_Using_xlxsFile_toDataProvidxer {
    WebDriver driver;

    @Test(dataProvider = "dp")
    public void f(String username, String password) throws InterruptedException {
        String title = driver.getTitle();
        System.out.println("The Title is: " + title);
        Thread.sleep(2000);

        WebElement name = driver.findElement(By.name("username"));
        name.clear();
        name.sendKeys(username);

        WebElement pass = driver.findElement(By.name("password"));
        pass.clear();
        pass.sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
        driver.manage().deleteAllCookies();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
    }
    @DataProvider
    public Object[][] dp() throws IOException {
        String projectpath = System.getProperty("user.dir");
        File file1 = new File(projectpath + "\\data.xlsx");
        FileInputStream fs = new FileInputStream(file1);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        int rowcount = worksheet.getPhysicalNumberOfRows();
        System.out.println("rows: " + rowcount);

        Object[][] data = new Object[rowcount][2];   

        for (int i = 0; i < rowcount; i++) {         
            data[i][0] = worksheet.getRow(i).getCell(0).getStringCellValue();
            data[i][1] = worksheet.getRow(i).getCell(1).getStringCellValue();
        }

        workbook.close();
        fs.close();

        return data;
    }


    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
        driver.quit();
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
