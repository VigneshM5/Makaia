package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class MergeLeads extends PreAndPost{
	
	@Test(groups= {"Sanity"})
	public void mergeLeads() {
		
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		WebElement eleLead = locateElement("link", "Leads");
		click(eleLead);
		
		WebElement eleML = locateElement("link", "Merge Leads");
		click(eleML);
		
		WebElement imgFr = locateElement("xpath", "(//span[text()='From Lead']/following::img)[1]");
		click(imgFr);
		
		
		
		WebElement imgTo = locateElement("xpath", "(//span[text()='From Lead']/following::img)[2]");
		click(imgTo);
	}
	
	

}
