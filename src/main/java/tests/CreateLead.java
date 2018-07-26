package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;



public class CreateLead extends PreAndPost{

	@Test(groups = {"Smoke"}, dataProvider = "SIT")
	public void createLead(String cName, String fName, String lName, String eMail
			, String phone) {

		WebElement eleCL = locateElement("link", "Create Lead");
		click(eleCL);
		WebElement txtCo = locateElement("id", "createLeadForm_companyName");
		type(txtCo, cName);		
		WebElement txtFn = locateElement("id", "createLeadForm_firstName");
		type(txtFn, fName);		
		WebElement txtLn = locateElement("id", "createLeadForm_lastName");
		type(txtLn, lName);		
		WebElement liSo = locateElement("id", "createLeadForm_dataSourceId");
		selectDropDownUsingVisibleText(liSo, "Other");		
		WebElement liMc = locateElement("id", "createLeadForm_marketingCampaignId");
		selectDropDownUsingIndex(liMc, 2);
		type(locateElement("id", "createLeadForm_primaryEmail"),eMail);
		type(locateElement("id", "createLeadForm_primaryPhoneNumber"),"" +phone);
		
		WebElement btnSubmit = locateElement("class", "smallSubmit");
		click(btnSubmit);		

	}
	
	@DataProvider(name = "UAT", indices = {1})
	public String[][] getData() {
		String data[][] = new String[2][5];
		data[0][0] = "TestLeaf";
		data[0][1] = "Vignesh";
		data[0][2] = "Sundaram";
		data[0][3] = "Vignesh@abc.com";
		data[0][4] = "1234567890";
		
		data[1][0] = "Corporate";
		data[1][1] = "Sahana";
		data[1][2] = "Vignesh";
		data[1][3] = "Sahana@abc.com";
		data[1][4] = "1896123456";
		return data;
	}
	
	@DataProvider(name = "SIT")
	public Object[][] getData1() {
		Object data[][] = new Object[1][5];
		data[0][0] = "TestLeaf";
		data[0][1] = "Sangeetha";
		data[0][2] = "Karuna";
		data[0][3] = "Sangeetha@abc.com";
		data[0][4] = 1234567892;		
		return data;
	}

}




