package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class EditLead extends PreAndPost{
	
	@Test(dependsOnMethods = {"tests.CreateLead.createLead"}, 
			description = "Runs Edit Lead based on the leads created", 
			groups= {"Smoke"})
	public void editLead() {
		
		WebElement eleLead = locateElement("link", "Leads");
		click(eleLead);
		
		WebElement eleFiLead = locateElement("link", "Find Leads");
		click(eleFiLead);
		
		WebElement eleFiLeadtxt = locateElement("xpath", "(//input[@name='firstName'])[3]");
		type(eleFiLeadtxt, "testleaf");
		
		WebElement btnFiLead = locateElement("xpath", "//button[text()='Find Leads']");
		click(btnFiLead);
		
		WebElement linkLead = locateElement("xpath", "//div[text()='Lead ID']/following::table//a");
		click(linkLead);
		
		verifyPartialTitle("View Lead");
		
		WebElement btnEdit = locateElement("xpath", "//div[@class='frameSectionExtra']/a[text()='Edit']");
		click(btnEdit);
		
		WebElement eleComName = locateElement("id", "updateLeadForm_companyName");
		clearText(eleComName);
		String name = "testleaf2";
		type(eleComName, name);
		
		WebElement eleFiName = locateElement("id", "updateLeadForm_firstName");
		clearText(eleFiName);
		type(eleFiName, name);
		
		WebElement eleLaName = locateElement("id", "updateLeadForm_lastName");
		clearText(eleLaName);
		type(eleLaName, name);
		
		WebElement eleUpd = locateElement("xpath", "//input[@class = 'smallSubmit']");
		click(eleUpd);
		
		WebElement txFiName = locateElement("id", "viewLead_firstName_sp");
		verifyExactText(txFiName, name);			
		
	}
	
}
