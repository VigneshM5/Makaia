package test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CreateLead extends PreAndPost{

	public CreateLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompName;

	@FindBy(id="createLeadForm_firstName")
	WebElement eleFirstName;

	@FindBy(id="createLeadForm_lastName")
	WebElement eleLastName;

	@FindBy(className="smallSubmit")
	WebElement eleCreate;

	public CreateLead typeCompName(String cName) {
		type(eleCompName, cName);
		return this;
	}

	public CreateLead typeFirstName(String fName) {
		type(eleFirstName, fName);
		return this;
	}

	public CreateLead typeLastName(String lName) {
		type(eleLastName, lName);
		return this;
	}

	public ViewLead clickCreate() {
		click(eleCreate);
		return new ViewLead(driver, test);
	}				
}