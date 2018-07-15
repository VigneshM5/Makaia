package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.MyHome_Page;

public class CreateLead_Dup extends PreAndPost{
	
	
	@BeforeTest
	public void setValue() {
		testCaseName = "CreateLead_Duplicate";
		testDesc = "Create a new Lead as a duplicate";
		nodeName = "Leads";
		author = "Vignesh_Sahana";
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