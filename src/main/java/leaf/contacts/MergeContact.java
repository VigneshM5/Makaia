package leaf.contacts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;


public class MergeContact extends WebDriverServiceImpl {

	@Test
	public void mergeContact() throws Exception{
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
		WebElement eleMergeContacts = locateElement("link", "Merge Contacts");
		click(eleMergeContacts);
		WebElement eleFromLead = locateElement("xpath", "(//img[@alt='Lookup'])[1]");
		click(eleFromLead);
		switchToWindow(1);
		WebElement eleFindContactsBut = locateElement("xpath", "//button[contains(text(),'Find Contacts')]");
		click(eleFindContactsBut);
		WebElement eleFirstName = locateElement("xpath", "//input[@name='firstName']");
		type(eleFirstName, "Gopinath");
		WebElement eleFLID = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		String leadID = getText(eleFLID);
		click(eleFLID);
		switchToWindow(0);
		eleFromLead = locateElement("xpath", "(//img[@alt='Lookup'])[2]");
		click(eleFromLead);
		switchToWindow(1);
		 eleFirstName = locateElement("xpath", "//input[@name='firstName']");
		type(eleFirstName, "Babu");
		eleFindContactsBut = locateElement("xpath", "//button[contains(text(),'Find Contacts')]");
		click(eleFindContactsBut);
		eleFLID = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		click(eleFLID);
		switchToWindow(0);
		WebElement eleMerge = locateElement("link", "Merge");
		click(eleMerge);
		acceptAlert();
		WebElement eleFindContacts = locateElement("link", "Find Contacts");
		click(eleFindContacts);	
		WebElement elelead = locateElement("xpath", "//label[contains(text(),'Contact Id:')]/following::input[1]");
		type(elelead, leadID);
		eleFindContactsBut = locateElement("xpath", "//button[contains(text(),'Find Contacts')]");
		click(eleFindContactsBut);
		WebElement elerecords = locateElement("class", "x-paging-info");
		verifyPartialText(elerecords, "No records to display");
		
	}

}
