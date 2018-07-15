package leaf.contacts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;


public class EditContact extends PreAndPost {

	@Test(invocationCount =  2)
	public void editContact() throws Exception{	
		WebElement eleContacts = locateElement("link", "Contacts");
		click(eleContacts);

		WebElement eleFindContacts = locateElement("link", "Find Contacts");
		click(eleFindContacts);

		WebElement eleFirstName = locateElement("xpath", "(//input[@name='firstName'])[3]");
		type(eleFirstName, "Gopinath");
		WebElement eleFindContactsBut = locateElement("xpath", "//button[contains(text(),'Find Contacts')]");
		click(eleFindContactsBut);
		WebElement eleFLID = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		//String leadID = getText(eleFLID);
		click(eleFLID);

		WebElement eleDeactivate = locateElement("link", "Edit");
		click(eleDeactivate);	
		eleFirstName = locateElement("id", "updateContactForm_firstName");
		type(eleFirstName, "Gopinath");

		WebElement eleCLB = locateElement("class", "smallSubmit");
		click(eleCLB);
	}
}
