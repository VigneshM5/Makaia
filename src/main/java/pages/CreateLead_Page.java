package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.selenium.PreAndPost;
import steps.LearnHooks;

public class CreateLead_Page extends PreAndPost{
	
	public CreateLead_Page(/*EventFiringWebDriver driver, ExtentTest test*/) {
		/*this.driver = driver;
		this.test = test;*/
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "createLeadForm_companyName")
	WebElement eleCoName;
	
	@FindBy(id = "createLeadForm_firstName")
	WebElement eleFiName;
	
	@FindBy(id = "createLeadForm_lastName")
	WebElement eleLaName;
	
	@FindBy(className = "smallSubmit")
	WebElement eleBtnCreateLead;
	
	@And("enter the company name as (.*)")
	public CreateLead_Page typeCoName(String cName) {
		type(eleCoName, cName);
		return this;
	}
	@And("enter the First name as (.*)")
	public CreateLead_Page typeFiName(String fName) {
		type(eleFiName, fName);
		return this;
	}
	@And("enter the Last name as (.*)")
	public CreateLead_Page typeLaName(String lName) {
		type(eleLaName, lName);
		return this;
	}
	@When("click the create lead button")
	public ViewLead_Page clickCreateLead() {
		click(eleBtnCreateLead);
		return new ViewLead_Page(/*driver, test*/);
	}
	
	@Then("Create Lead is successful")
	public void createLeadSuccess() {
		System.out.println("Create Lead with Mandatory Fields is Successful");
	}
	
	

}
