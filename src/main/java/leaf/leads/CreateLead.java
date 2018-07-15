package leaf.leads;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.read.ReadExcel;
import lib.selenium.PreAndPost;

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
		click(locateElement("link", "Leads"));		
		click(locateElement("link", "Create Lead"));		
		type(locateElement("id", "createLeadForm_companyName"), cName);		
		type(locateElement("id", "createLeadForm_firstName"), fName);		
		type(locateElement("id", "createLeadForm_lastName"), lName);
		type(locateElement("id", "createLeadForm_primaryEmail"), email);
		type(locateElement("id", "createLeadForm_primaryPhoneNumber"), phone);
		click(locateElement("class", "smallSubmit"));				
	}
	
	
}