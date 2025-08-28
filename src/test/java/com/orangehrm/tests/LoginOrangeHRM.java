package com.orangehrm.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.utilities.ExcelUtiles;
import com.orangehrm.utilities.Screenshot;

import SeleniumPack.login_PageFactory;

public class LoginOrangeHRM extends BaseTest {

    static String projectPath = System.getProperty("user.dir");

    @Test(dataProvider = "logindata")
    public void verifylogin(String username, String password) throws IOException {
        test = extent.createTest("Login with the user: " + username);

        // Ensure correct URL is opened
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // PageFactory initialization
        login_PageFactory obj = PageFactory.initElements(driver, login_PageFactory.class);

        obj.enterusername(username);
        obj.enterpassword(password);
        obj.clickonlogin();

        String actualTitle = driver.getTitle();

        if (actualTitle.contains("Orange")) {
            test.pass("Login Successful. Title matched: " + actualTitle);
        } else {
            String screenPath = Screenshot.Capture(driver, "Login_Failed_" + username);
            test.fail("Login Unsuccessful. Title mismatch: " + actualTitle)
                .addScreenCaptureFromPath(screenPath);
        }
    }

    @DataProvider
    public Object[][] logindata() throws IOException {
        String excelPath = projectPath + "\\data.xlsx";
        return ExcelUtiles.getdata(excelPath, "Sheet1");
    }
}
