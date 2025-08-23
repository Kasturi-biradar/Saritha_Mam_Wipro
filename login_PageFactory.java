

package SeleniumPack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login_PageFactory{
    //WebDriver driver;

	//By uname = By.name("username");
	@FindBy(name="username")
	WebElement uname;
	
	//By pword = By.name("password");
	@FindBy(name="password")
	WebElement pword;
	
	//By loginbutton=By.xpath("//button[@type='submit']");
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	 
	public void enterusername(String username)
	{
		//driver.findElement(uname).sendKeys(username);
		uname.sendKeys(username);

	}
	
	
	public void enterpassword(String password)
	{
//		driver.findElement(pword).sendKeys(password);
		pword.sendKeys(password);

	}
	
	
	public void clickonlogin()
	{
//		driver.findElement(loginbutton).click();
		loginbutton.click();

	}
	
}

