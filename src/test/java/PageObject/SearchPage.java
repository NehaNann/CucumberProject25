package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver ldriver;

	public SearchPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Elements on Page

	@FindBy(id="SearchEmail")
	WebElement Email;

	@FindBy(id="search-customers")
	WebElement SearchButton;

	@FindBy(id="customers-grid_wrapper")
	WebElement SearchTable;
	
	@FindBy(xpath="(//table[@role='grid'])[2]//tr")
	List<WebElement> RowCount;

	@FindBy(xpath="(//table[@role='grid'])[2]//tr[1]/td")
	List<WebElement> CoulmnCount;
	
	//Methods
	
	public void enterEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void clickSearch() {
		SearchButton.click();
	}

	public boolean searchCustomerByEmail(String expectedEmail) {
		
		boolean found=false;
	//Total no of rows
		int ttlRows=RowCount.size();
		
	//Total no of columns
		int ttlCoulmn=CoulmnCount.size();
	
	//Iterate through loop and iterate through 2nd coulmn for 1st row
	for(int i=1;i<ttlRows;i++) {
		//2nd coulmn-email iterate
		WebElement actualEmail=ldriver.findElement(By.xpath("(//table[@role='grid'])[2]//tr["+i+"]/td[2]"));
		if(actualEmail.equals(expectedEmail)) {
			found=true;
		}
			
	}
	return found;
		
		
	}




}
