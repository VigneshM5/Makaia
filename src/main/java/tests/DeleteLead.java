package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;


public class DeleteLead extends PreAndPost{
	
	@Test(dependsOnMethods = {"tests.CreateLead.createLead"}, alwaysRun = true, groups = {"Sanity"})
	public void deleteLead() {
		
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
		
		WebElement eleFiLead = locateElement("link", "Find Leads");
		click(eleFiLead);
		
		WebElement elePhone = locateElement("xpath", "//span[text()='Phone']");
		click(elePhone);
		
		WebElement eleFiLeadtxt = locateElement("xpath", "//input[@name='phoneNumber']");
		type(eleFiLeadtxt, "1234567890");
		
		WebElement btnFiLead = locateElement("xpath", "//button[text()='Find Leads']");
		click(btnFiLead);
		
		WebElement linkLead = locateElement("xpath", "//div[text()='Lead ID']/following::table//a");
		String leadText = getText(linkLead);
		System.out.println("Lead Text is: " +leadText);
		click(linkLead);
		
		verifyPartialTitle("View Lead");
		
		
		WebElement btnDelete = locateElement("class", "subMenuButtonDangerous");
		click(btnDelete);
		
		WebElement eleFiLead1 = locateElement("link", "Find Leads");
		click(eleFiLead1);
		
		WebElement eleFiLeadId = locateElement("xpath", "//input[@name='id']");
		type(eleFiLeadId, leadText);
		
		WebElement btnFiLead1 = locateElement("xpath", "//button[text()='Find Leads']");
		click(btnFiLead1);
		
		WebElement errText = locateElement("class", "x-paging-info");
		String errTxt = getText(errText);
		System.out.println("Error Text is " +errTxt);	
		
	}
	
}
