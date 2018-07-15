package test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.WebDriverServiceImpl;

public class MyLeads extends WebDriverServiceImpl {

	public MyLeads(EventFiringWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Create Lead")
	WebElement eleCreate;

	@FindBy(linkText="Find Leads")
	WebElement eleFind;

	@FindBy(linkText="Merge Leads")
	WebElement eleMerge;

	public CreateLead clickCreateLead() {
		click(eleCreate);
		return new CreateLead(driver, test);
	}

	public FindLeads clickFindLeads() {
		click(eleFind);
		return new FindLeads(driver, test);
	}
	
	public MergeLeads clickMergeLeads() {
		click(eleMerge);
		return new MergeLeads(driver, test);
	}
}