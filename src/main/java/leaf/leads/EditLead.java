package leaf.leads;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.read.ReadExcel;
import lib.selenium.PreAndPost;

public class EditLead extends PreAndPost {

	
	
	@BeforeTest
	public void setValue() {
		testCaseName = "EditLead";
		testDesc = "Search for a Lead and edit details";
		nodeName = "Leads";
		author = "Sangeetha";
		category = "Regression";
		excelFileName = "EditLead";
	}
	
	@Test(dataProvider="TST")
	public void editLead(String fName,String cName) throws InterruptedException {
		
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Find Leads"));				
		type(locateElement("xpath", "(//input[@name='firstName'])[3]"), fName);
		click(locateElement("xpath", "//button[text()='Find Leads']"));		
		String leadID = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("link", "Edit"));
		clearText(locateElement("id", "updateLeadForm_companyName"));
		type(locateElement("id", "updateLeadForm_companyName"), cName);
		click(locateElement("class", "smallSubmit"));
		click(locateElement("link", "Find Leads"));
		type(locateElement("xpath", "//input[@name='id']"), leadID);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(2000);
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		verifyPartialText(locateElement("id", "viewLead_companyName_sp"), cName);		
	}	
}
