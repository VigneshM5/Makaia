package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.MyHome_Page;
import pages.ViewLead_Page;

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

		new MyHome_Page(/*driver, test*/)
		.clickLeads()
		.clickFindLeads()
		.typeFirstName(fName)
		.clickFindLead()
		.getTextLeadId()
		.clickTextLeadId()
		.clickEditLeads()
		.clearTextCoName()
		.enterTextCoName(cName)
		.submitEditBtn()
		.clickFindLeads()
		.typeLeadId()
		.clickTextLeadId()
		.geCotName(cName);
	}	
}
