package leaf.leads;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class DeleteLead extends PreAndPost {
	
	@BeforeTest
	public void setValue() {
		testCaseName = "DeleteLead";
		testDesc = "Search for a Lead and Delete the Lead";
		nodeName = "Leads";
		author = "Sahana";
		category = "Regression";
		excelFileName = "DeleteLead";
	}	

	@Test(dataProvider="TST")
	public void deleteLead(String fName) throws InterruptedException {
		
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Find Leads"));	
		Thread.sleep(5000);
		type(locateElement("xpath", "(//input[@name='firstName'])[3]"), fName);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		String leadID = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("link", "Delete"));
		click(locateElement("link", "Find Leads"));
		type(locateElement("xpath", "//input[@name='id']"),leadID);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		verifyPartialText(locateElement("class", "x-paging-info"), "No records to display");		
	}
}