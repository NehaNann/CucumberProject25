package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	WebDriver ldriver;

	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	//Find web elements on the web page


	@FindBy(xpath="(//*[@class='nav-link' and @href='#'])[6]")
	WebElement CustomerMenu;


	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement CustomerSubMenu;

	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement addNewButton;

	@FindBy(id="Email")
	WebElement txtEmail;

	@FindBy(id="Password")
	WebElement txtPassword;

	@FindBy(id="FirstName")
	WebElement txtFirstname;

	@FindBy(id="LastName")
	WebElement txtLastname;

	@FindBy(id="Gender_Male")
	WebElement genderMale;


	@FindBy(id="Gender_Female")
	WebElement genderFemale;

	@FindBy(id="DateOfBirth")
	WebElement txtDOB;

	@FindBy(id="Company")
	WebElement txtCompanyName;

	@FindBy(id="IsTaxExempt")
	WebElement checkIsTaxExempt;

	@FindBy(xpath="(//*[@class='form-group row'])[9]//div[@role='listbox']")
	public
	WebElement dropdownNewsletter;

	@FindBy(xpath="(//*[@class='form-group row'])[10]//div[@role='listbox']")
	WebElement dropdownCustomerRoles;

	@FindBy(id="VendorId")
	WebElement dropdownVender;

	@FindBy(id="AdminComment")
	WebElement adminComment;


	@FindBy(name="save")
	WebElement btnSave;

	//Actions Methods for web elements

	public String getPageTitle()
	{
		return ldriver.getTitle();
	}

	public void clickOnCustomerMenu()
	{
		CustomerMenu.click();
	}

	public void clickOnCustomerSubMenu() {

		CustomerSubMenu.click();
	}

	public void clickOnAddNew() {

		addNewButton.click();
	}

	public void enterEmail(String emailAdd) {

		txtEmail.sendKeys(emailAdd);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}


	public void enterLastname(String lastname) {
		txtLastname.sendKeys(lastname);
	}
	public void enterFirstname(String firstname) {
		txtFirstname.sendKeys(firstname);
	}

	public void enterDOB(String dob) {
		txtDOB.sendKeys(dob);
	}

	public void enterCompany(String company) {
		txtCompanyName.sendKeys(company);
	}
	public void enterGender(String gender) {

		if(gender.equals("Male")) {
			genderMale.click();	
		}
		else if(gender.equals("Female")) {
			genderFemale.click();
		}else
		{
			genderMale.click();
		}

	}

	public void enterNewsletter(String value) {
		dropdownNewsletter.sendKeys(value);
	}
	public void enterCustomerRoles(String value) {
		Select s=new Select(dropdownCustomerRoles);
		s.selectByVisibleText(value);	
	}
	public void enterManagerOfVendor(String value) {
		Select s=new Select(dropdownCustomerRoles);
		s.selectByVisibleText(value);	
	}

	public void enterAdminComment(String comment) {
		adminComment.sendKeys(comment);
	}

	public void clickOnSave() {
		btnSave.click();
	}




}
