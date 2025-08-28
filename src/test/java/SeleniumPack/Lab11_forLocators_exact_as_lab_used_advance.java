package SeleniumPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Lab11_forLocators_exact_as_lab_used_advance {
    WebDriver driver;

    // Locators with PageFactory
    @FindBy(linkText = "Desktops")
    WebElement desktopsTab;

    @FindBy(linkText = "Mac (1)")
    WebElement macOption;

    @FindBy(id = "input-sort")
    WebElement sortDropdown;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")
    WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"product-category\"]/div[1]")
    WebElement successMessage;

    @FindBy(xpath = "//*[@id=\"search\"]/input")
    WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"search\"]/span/button")
    WebElement searchBtn;

    @FindBy(name = "search")
    WebElement searchCriteria;

    @FindBy(name = "description")
    WebElement searchDescriptionCheckbox;

    @FindBy(xpath = "//*[@id=\"button-search\"]")
    WebElement searchCriteriaBtn;

    @FindBy(linkText = "Mac")
    WebElement macHeading;

    // ✅ Constructor must match the class name
    public Lab11_forLocators_exact_as_lab_used_advance(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public String getTitle() {
        return driver.getTitle();
    }

    public void clickDesktops() {
        desktopsTab.click();
    }

    public void clickMac() {
        macOption.click();
    }

    public String verifyMacHeading() {
        return macHeading.getText();
    }

    public void selectSortByNameAZ() {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A - Z)");
    }

    public void clickAddToCart() {
        addToCartBtn.click();
    }

    public boolean isSuccessMsgDisplayed() {
        return successMessage.isDisplayed();
    }

    public void searchProduct(String product) {
        searchBox.clear();
        searchBox.sendKeys(product);
        searchBtn.click();
    }

    public void clearSearchCriteria() {
        searchCriteria.clear();
    }

    public void searchWithDescription(String product) {
        searchCriteria.clear();
        searchCriteria.sendKeys(product);
        searchDescriptionCheckbox.click();
        searchCriteriaBtn.click();
    }
}
