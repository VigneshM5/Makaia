package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.MyHome_Page;

public class CreateLead extends PreAndPost{
	
	
	@BeforeTest
	public void setValue() {
		testCaseName = "CreateLead";
		testDesc = "Create a new Lead";
		nodeName = "Leads";
		author = "Vignesh";
		category = "Functional";
		excelFileName = "CreateLead";
	}
	

	@Test(dataProvider="TST")
	public void createLead(String cName,String fName,String lName,
			String email,String phone){		
		
		new MyHome_Page(/*driver, test*/)
		.clickLeads()
		.clickCreateLeads()
		.typeCoName(cName)
		.typeFiName(fName)
		.typeLaName(lName)
		.clickCreateLead()
		.geFirsttName(fName);		
	}	
}