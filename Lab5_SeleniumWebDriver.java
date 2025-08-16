package SeleniumPack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5_SeleniumWebDriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		String validEmail="santmjjoksh"+ System.currentTimeMillis()+"@gmail.com";
		
		String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);
        if (actualTitle.equals("Your Store")) {
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification failed");
        }
        
        WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
        myAccount.click();
        
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        
        WebElement registerHeading = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        if(registerHeading.isDisplayed()) {
        	System.out.println("Register heading is displayed " + registerHeading.getText());
        		
        	}else {
        		System.out.println("Register heading is not found");
        }
        
        WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        continueBtn.click();
        
        Thread.sleep(3000);
        WebElement warningMsg = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
        String warningMsgText = warningMsg.getText();
        if(warningMsgText.contains("Warning: You must agree to the Privacy Policy!")) {
        	System.out.println("Warning msg verified");
        }else {
        	System.out.println("warning msg not verified");
        }
        
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFM");
        WebElement agreeCheckBox = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        agreeCheckBox.click();
        WebElement firstNameError = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div\r\n"));
        if(firstNameError.isDisplayed()) {
        	System.out.println("First Name Error Displayed: " + firstNameError.getText());
        	firstName.clear();
        	firstName.sendKeys("Kasturi");
        	}
       WebElement ContinueBtn1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div/div/input[2]"));
       ContinueBtn1.click();
       Thread.sleep(3000);
       
       
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFM");
        Thread.sleep(1000);
        WebElement lastNameError = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div\r\n"));
        if(lastNameError.isDisplayed()) {
        	System.out.println("Last Name Error Displayed: " + lastNameError.getText());
        	
        	lastName.clear();
        	
        	lastName.sendKeys("Biradar");
        }
        WebElement ContinueBtn2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]"));
        ContinueBtn2.click();
        Thread.sleep(3000);
      	 
        	 WebElement email = driver.findElement(By.id("input-email"));
        	 email.sendKeys(validEmail);
        	 WebElement ContinueBtn3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]"));
             ContinueBtn3.click();
             Thread.sleep(3000);
             
        	 WebElement telephone = driver.findElement(By.id("input-telephone"));
        	 telephone.sendKeys("12");
        	 WebElement telephoneError = driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div"));
        	 if(telephoneError.isDisplayed()) {
        		 telephone.clear();
        		 telephone.sendKeys("345678910");
        	 }
        	 WebElement ContinueBtn4 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]"));
             ContinueBtn4.click();
             Thread.sleep(3000);
          
        	 WebElement password = driver.findElement(By.id("input-password"));
        	 password.sendKeys("123");
             Thread.sleep(3000);
        	 WebElement passwordError = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div"));
        	 if(passwordError.isDisplayed()) {
        		 password.clear();
        		 password.sendKeys("456789");
        	 }
        	 WebElement ContinueBtn5 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]"));
             ContinueBtn5.click();
             Thread.sleep(3000);
             
        	 WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
        	 passwordConfirm.sendKeys("456789");
        	 Thread.sleep(3000);
             
        	 WebElement ContinueBtn6 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]"));
             ContinueBtn6.click();
             Thread.sleep(3000);
             
             System.out.println("hii");
             Thread.sleep(3000);
        	 WebElement newsletterYES = driver.findElement(By.xpath("//input[@value='1']"));
        	 newsletterYES.click();
        	 Thread.sleep(3000);
        	 
        	 WebElement checkBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[1]"));
        	 checkBox.click();
        	 
        	 WebElement ContinueBtn7 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]"));
             ContinueBtn7.click();
             Thread.sleep(3000);
             
             WebElement ContinueBtn8 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/a"));
             ContinueBtn8.click();
             Thread.sleep(3000);
	}
        
}

