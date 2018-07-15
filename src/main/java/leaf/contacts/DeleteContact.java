package leaf.contacts;



import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class DeleteContact extends WebDriverServiceImpl {

	@Test
	public void deleteContact() throws Exception{	
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");

		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");

		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);

		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);

		WebElement eleContacts = locateElement("link", "Contacts");
		click(eleContacts);

		WebElement eleFindContacts = locateElement("link", "Find Contacts");
		click(eleFindContacts);

		WebElement eleFirstName = locateElement("xpath", "(//input[@name='firstName'])[3]");
		type(eleFirstName, "Gopinath");
		WebElement eleFindContactsBut = locateElement("xpath", "//button[contains(text(),'Find Contacts')]");
		click(eleFindContactsBut);
		WebElement eleFLID = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		String leadID = getText(eleFLID);
		click(eleFLID);

		WebElement eleDeactivate = locateElement("link", "Deactivate Contact");
		click(eleDeactivate);	
		acceptAlert();
		eleFindContacts = locateElement("link", "Find Contacts");
		click(eleFindContacts);	
		WebElement elelead = locateElement("xpath", "//label[contains(text(),'Contact Id:')]/following::input[1]");
		type(elelead, leadID);

		eleFindContactsBut = locateElement("xpath", "//button[contains(text(),'Find Contacts')]");
		click(eleFindContactsBut);
		WebElement elerecords = locateElement("class", "x-paging-info");
		verifyPartialText(elerecords, "No records to display");
		
	}
}
