package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Lab11_Locators {
    WebDriver driver;

    public Lab11_Locators(WebDriver driver) {
        this.driver = driver;
    }


    By desktopsTab = By.linkText("Desktops");
    By macOption = By.linkText("Mac (1)");
    By sortDropdown = By.id("input-sort");
    By addToCartBtn = By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]");
    By successMessage = By.xpath("//*[@id=\"product-category\"]/div[1]");
    By searchBox = By.xpath("//*[@id=\"search\"]/input");
    By searchBtn = By.xpath("//*[@id=\"search\"]/span/button");
    By searchCriteria = By.name("search");
    By searchDescriptionCheckbox = By.name("description");
    By searchCriteriaBtn = By.xpath("//*[@id=\"button-search\"]");
    By macHeading = By.linkText("Mac");

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickDesktops() {
        driver.findElement(desktopsTab).click();
    }

    public void clickMac() {
        driver.findElement(macOption).click();
    }

    public String verifyMacHeading() {
        return driver.findElement(macHeading).getText();
    }

    public void selectSortByNameAZ() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Name (A - Z)");
    }

    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public boolean isSuccessMsgDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public void searchProduct(String product) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchBtn).click();
    }

    public void clearSearchCriteria() {
        driver.findElement(searchCriteria).clear();
    }

    public void searchWithDescription(String product) {
        driver.findElement(searchCriteria).clear();
        driver.findElement(searchCriteria).sendKeys(product);
        driver.findElement(searchDescriptionCheckbox).click();
        driver.findElement(searchCriteriaBtn).click();
    }
}

