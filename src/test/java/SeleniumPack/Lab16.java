package SeleniumPack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Lab16 {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?");
    }

    @Test(dataProvider = "UserDetails")
    public void registerAccount(String firstname, String lastname, String email,
                                String telephone, String password) {
        // Verify title
        Assert.assertEquals(driver.getTitle(), "Your Store");

        // Navigate to Register Page
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // Verify "Register Account"
        WebElement header = driver.findElement(By.xpath("//h1[text()='Register Account']"));
        Assert.assertTrue(header.isDisplayed(), "Register page header not found");

        // Fill registration form
        driver.findElement(By.id("input-firstname")).sendKeys(firstname);
        driver.findElement(By.id("input-lastname")).sendKeys(lastname);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(password);

        // Select Privacy Policy and Continue
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Verify success message
        WebElement success = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        Assert.assertTrue(success.isDisplayed(), "Success message not displayed");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @DataProvider(name = "UserDetails")
    public Object[][] getUserData()
            throws ParserConfigurationException, SAXException, IOException {
        // Ensure correct XML file name matches your uploaded file
        File file = new File(projectPath + "C:\\Users\\Kavya Para\\git\\github.com\\Kasturi-biradar\\Saritha_Mam_Wipro\\Wipro\\Lab16XML.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("user");
        Object[][] data = new Object[nList.getLength()][5];

        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                data[i][0] = element.getElementsByTagName("firstname").item(0).getTextContent();
                data[i][1] = element.getElementsByTagName("lastname").item(0).getTextContent();
                data[i][2] = element.getElementsByTagName("email").item(0).getTextContent();
                data[i][3] = element.getElementsByTagName("telephone").item(0).getTextContent();
                data[i][4] = element.getElementsByTagName("password").item(0).getTextContent();
            }
        }
        return data;
    }
}
