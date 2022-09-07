package stepDefination;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.BaseClass;
import PageObject.LoginPage;
import PageObject.SearchPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Scenario;

public class stepDefinationLoginPage extends BaseClass {

	//declare driver and page class object
	public WebDriver driver;
	public LoginPage loginpage;
	public AddNewCustomerPage customerpage;
	public SearchPage spage;

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		WebDriverManager.chromedriver().setup();

		//Initialize driver and page class object
		driver=new ChromeDriver();

		loginpage=new LoginPage(driver);

		customerpage=new AddNewCustomerPage(driver);
		spage=new SearchPage(driver);

	}

	@When("User open  URL {string}")
	public void user_open_url(String url) {

		driver.get(url);

	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pass) {

		loginpage.enterEmail(email);
		loginpage.enterPassword(pass);

	}

	@When("Click on Login")
	public void click_on_login() {

		loginpage.clickLogin();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		//if(scenario.isFailed()) {
			final byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		//}
		
		
	}
	
	
////////////////////////Login/////////////////////////////////////////////

	@Then("Page title should be {string}")
	public void page_title_should_be(String titleExpected) {

		String TitleActual=driver.getTitle();
		if(TitleActual.equals(titleExpected)) {
			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//Fail
		}

	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() throws Exception {
		Thread.sleep(20000);
		loginpage.clickLogout();
	}

	@Then("Close browser")
	public void close_browser() {
		driver.close();
		driver.quit();

	}

	///////////////////Add new customer/////////////////////////////////////////

	@Then("User can view dashboard")
	public void user_can_view_dashboard() {
		String actualTitle=customerpage.getPageTitle();
		String ExpectedTitle="Dashboard / nopCommerce administration";
		if(actualTitle.equals(ExpectedTitle)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}

	}

	@When("User clicks on Customer Menu")
	public void user_clicks_on_customer_menu() {
		customerpage.clickOnCustomerMenu();
	}

	@When("Clicks on Customer menu item")
	public void clicks_on_customer_menu_item() {
		customerpage.clickOnCustomerSubMenu();

	}

	@When("Click on Add new button")
	public void click_on_add_new_button() throws Exception {
		customerpage.clickOnAddNew();
		Thread.sleep(2000);
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		
		String actualTitle=customerpage.getPageTitle();
		String ExpectedTitle="Add a new customer / nopCommerce administration";
		if(actualTitle.equals(ExpectedTitle)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}

		
	}

	@When("User enter customers info")
	public void user_enter_customers_info() {
		
		customerpage.enterEmail("test4@gmail.com");
		customerpage.enterPassword("1234");
		customerpage.enterFirstname("Neha");
		customerpage.enterLastname("Kakkar");
		customerpage.enterGender("Female");
		customerpage.enterDOB("6/24/2000");
		customerpage.enterCompany("testcompany");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400);");
        customerpage.enterNewsletter("Test store 2");
        customerpage.enterCustomerRoles("Vendors");
		customerpage.enterManagerOfVendor("Vendor 1");
		customerpage.enterAdminComment("test");
		
		

	}

	@When("Click on Save button")
	public void click_on_save_button() {
		customerpage.clickOnSave();

	}

	@Then("User can view confirmation message as {string}")
	public void user_can_view_confirmation_message_as(String expectedConfirmationMessage) {

//to verify we are checking current page body tag we have that message or not
		String bodyTag=driver.findElement(By.tagName("Body")).getText();
		if(bodyTag.contains(expectedConfirmationMessage)) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

////////////////////SearchCustomer//////////////////////////////////////
	@When("Enter Customer email")
	public void enter_customer_email() throws NullPointerException  {
	   spage.enterEmail("sadasd@gmail.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		spage.clickSearch();  
	}

	@Then("User should found email in search table")
	public void user_should_found_email_in_search_table() {
	   // boolean emailFound=spage.searchCustomerByEmail("sadasd@gmail.com");
	    /*if(spage.searchCustomerByEmail("sadasd@gmail.com")==true)
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }*/
		
		String expectedEmail="sadasd@gmail.com";
	    
		Assert.assertTrue(spage.searchCustomerByEmail(expectedEmail));
	}



}
