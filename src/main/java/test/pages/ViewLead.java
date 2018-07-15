package test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class ViewLead extends PreAndPost {

	public static String leadIDRead;
	
	public ViewLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="viewLead_firstName_sp")
	WebElement eleFirstName;
	
	@FindBy(id="viewLead_companyName_sp")
	WebElement eleCompName;
	
	@FindBy(linkText="Edit")
	WebElement eleEditButton;
	
	@FindBy(linkText="Find Leads")
	WebElement eleFind;

	@FindBy(linkText="Duplicate Lead")
	WebElement eleDuplicate;
	
	@FindBy(linkText="Delete")
	WebElement eleDelete;
	
	public FindLeads clickFindLeads() {
		click(eleFind);
		return new FindLeads(driver, test);
	}
	
	public void verifyFirstName(String fName) {
		verifyExactAttribute(eleFirstName, "value", fName);
	}
	
	public void verifyCompName(String cName) {
		verifyPartialAttribute(eleCompName, "value", cName);
	}
	
	public EditLead clickEditLead() {
		click(eleEditButton);
		return new EditLead(driver, test);
	}
	
	public DuplicateLead clickDuplicate() {
		click(eleDuplicate);
		return new DuplicateLead(driver, test);
	}
	
	public ViewLead clickDelete() {
		click(eleDelete);
		return this;
	}
	
	public ViewLead getLeadID() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(locateElement("xpath", "//span[@id='viewLead_companyName_sp']")));
		leadIDRead = getText(locateElement("xpath", "//span[@id='viewLead_companyName_sp']"))
				.substring(getText(locateElement("xpath", "//span[@id='viewLead_companyName_sp']")).lastIndexOf('(')+1, 
						getText(locateElement("xpath", "//span[@id='viewLead_companyName_sp']")).lastIndexOf(')'));
		return this;
	}
}
