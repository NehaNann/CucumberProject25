package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
//Initialise driver
	
	WebDriver ldriver;

//Constructor
	
 public LoginPage(WebDriver rdriver)
 {
	 ldriver=rdriver;
	 PageFactory.initElements(rdriver, this);
 }
 
 //Page Elements
 
 @FindBy(id="Email")
 WebElement email;
 
 @FindBy(id="Password")
 WebElement password;
 
 @FindBy(xpath="//*[text()='Log in']")
 WebElement LogIn;
 
 @FindBy(xpath = "//a[text()='Logout']")
 WebElement LogOut;
 
 //Actions
 public void enterEmail(String emailid)
 {
	 email.clear();
	 email.sendKeys(emailid);
 }
 
 public void enterPassword(String Pass)
 {
	 password.clear();
	 password.sendKeys(Pass);
 }
 
 public void clickLogin()
 {
	 LogIn.click();
 }
 
 public void clickLogout()
 {
	 LogOut.click();
 }
 
}
