package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;


public class DuplicateLead extends PreAndPost {
	
	@Test
	public void duplicateLead () {
		
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
		
		WebElement eleEmail = locateElement("xpath", "//span[text()='Email']");
		click(eleEmail);
		
		WebElement eleFiLeadtxt = locateElement("xpath", "//input[@name='emailAddress']");
		type(eleFiLeadtxt, "abc@gmail.com");
		
		WebElement linkLead = locateElement("xpath", "//div[text()='Lead ID']/following::table//a");
		String leadText = getText(linkLead);
		System.out.println("Lead Text is: " +leadText);
		click(linkLead);
		
		verifyPartialTitle("View Lead");
		
		WebElement btnDuplicate = locateElement("xpath", "//a[text()='Duplicate Lead']");
		click(btnDuplicate);
		
		verifyPartialTitle("Duplicate Lead");
		
		WebElement txtCo = locateElement("id", "createLeadForm_companyName");
		clearText(txtCo);
		type(txtCo, "testleaf");
		
		WebElement txtFn = locateElement("id", "createLeadForm_firstName");
		clearText(txtFn);
		type(txtFn, "testleaf");
		
		WebElement txtLn = locateElement("id", "createLeadForm_lastName");
		clearText(txtLn);
		type(txtLn, "testleaf");
		
		WebElement btnSubmit = locateElement("class", "smallSubmit");
		click(btnSubmit);
		
		WebElement txtFiName = locateElement("id", "viewLead_firstName_sp");
		String name = getText(txtFiName);
		verifyPartialText(txtFiName, name);
		
		
	}

}
