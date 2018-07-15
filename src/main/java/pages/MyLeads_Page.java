package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import lib.selenium.PreAndPost;

public class MyLeads_Page extends PreAndPost{
	
	public MyLeads_Page(/*EventFiringWebDriver driver, ExtentTest test*/) {
		/*this.driver = driver;
		this.test = test;*/
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Create Lead")
	WebElement eleCreLead;
	
	@FindBy(xpath = "//button[text()='Find Leads']")
	WebElement eleFindLead;
	
	@And("click create lead link")
	public CreateLead_Page clickCreateLeads() {
		click(eleCreLead);
		return new CreateLead_Page(/*driver, test*/);
	}
	
	public FindLead_Page clickFindLeads() {
		click(eleFindLead);
		return new FindLead_Page(/*driver, test*/);
	}

}
