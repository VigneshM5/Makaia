package test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class FindLeads extends PreAndPost {
	
	public FindLeads(EventFiringWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({
		@FindBy(xpath = "(//input[@name='firstName'])[3]"),
		@FindBy(xpath = "(//input[@name='firstName'])") })
	WebElement eleFirstName;
	
	@FindBy(xpath = "//input[@name='id']")
	WebElement eleLeadIDBox;
	
	@FindBy(xpath = "//button[text()='Find Leads']")
	WebElement eleFindButton;
	
	@FindBy(xpath = "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement eleLeadID;
	
	public FindLeads typeFirstName(String fName) {
		type(eleFirstName, fName);
		return this;
	}
	
	public FindLeads typeLeadID() {
		new ViewLead(driver, test);
		type(eleLeadIDBox, ViewLead.leadIDRead);
		return this;
	}
	
	public FindLeads typeIDaftMerge() {
		new MergeLeads(driver, test);
		type(eleLeadIDBox, MergeLeads.leadID1);
		return this;
	}
	
	public FindLeads verifyAfterMerge() {
		click(eleFindButton);
		verifyPartialText(locateElement("class", "x-paging-info"), "No records to display");
		return this;
	}
	
	public FindLeads clickFindButton() {
		click(eleFindButton);
		return this;
	}
	
	public ViewLead clickLeadID() {
		click(eleLeadID);
		return new ViewLead(driver, test);
	}
	
	public MergeLeads selectLead() {
		click(eleLeadID);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		switchToWindow(0);
		return new MergeLeads(driver, test);
	}
}