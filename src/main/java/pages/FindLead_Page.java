package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class FindLead_Page extends PreAndPost{

	public String leadId;
	
	public FindLead_Page(/*EventFiringWebDriver driver, ExtentTest test*/) {
		/*this.driver = driver;
		this.test = test;*/
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@name='firstName'])[3]")
	WebElement eleFirstName;

	@FindBy(xpath = "//button[text()='Find Leads']")
	WebElement eleBtnFindLead;

	@FindBy(xpath = "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
	WebElement clickFirstName;

	@FindBy(id = "updateLeadForm_companyName")
	WebElement eleCoName;
	
	@FindBy(xpath = "//input[@name='id']")
	WebElement eleLeadId;


	public FindLead_Page typeFirstName(String fName) {
		type(eleFirstName, fName);
		return this;
	}

	public FindLead_Page clickFindLead() {
		click(eleBtnFindLead);
		return this;
	}

	public FindLead_Page getTextLeadId() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(clickFirstName));
		leadId = getText(clickFirstName);
		return this;
	}

	public pages.ViewLead_Page clickTextLeadId() {
		//String leadId = getText(clickFirstName);
		click(clickFirstName);
		//return leadId;
		return new ViewLead_Page(/*driver, test*/);
	}



	public FindLead_Page clearTextCoName() {
		clearText(eleCoName);
		return this;
	}
	
	public FindLead_Page typeLeadId() {
		//new ViewLead_Page(driver, test)
		type(eleLeadId, leadId);
		return this;
	}

}