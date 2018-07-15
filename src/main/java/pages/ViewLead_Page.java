package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class ViewLead_Page extends PreAndPost {
	
	public ViewLead_Page(/*EventFiringWebDriver driver, ExtentTest test*/) {
		/*this.driver = driver;
		this.test = test;*/
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "viewLead_firstName_sp")
	WebElement eleViewFirstName;
	
	@FindBy(linkText = "Edit")
	WebElement eleLinkEdit;
	
	@FindBy(linkText = "Find Leads")
	WebElement eleLinkFind;
	
	@FindBy(id = "viewLead_companyName_sp")
	WebElement eleViewCoName;
	
	public ViewLead_Page geFirsttName(String fName) {
		verifyPartialText(eleViewFirstName, fName);
		return this;
	}
	
	public EditLead_Page clickEditLeads() {
		click(eleLinkEdit);
		return new EditLead_Page(/*driver, test*/);
	}
	
	public FindLead_Page clickFindLeads() {
		click(eleLinkFind);
		return new FindLead_Page(/*driver, test*/);
	}
	
	public ViewLead_Page geCotName(String cName) {
		verifyPartialText(eleViewCoName, cName);
		return this;
	}
}