package leaf.contacts;

import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class CreateContact extends PreAndPost {
	@Test(invocationCount = 3, groups = {"smoke", "Babu"})
	public void createContact() throws Exception{						
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Contacts"));
		click(locateElement("link", "Create Contact"));		
		type(locateElement("id", "firstNameField"), "Gopinath");		
		type(locateElement("id", "lastNameField"), "Jayakumar");		
		click(locateElement("class", "smallSubmit"));
	}

}