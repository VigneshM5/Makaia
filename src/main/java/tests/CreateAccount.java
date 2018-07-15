package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class CreateAccount extends WebDriverServiceImpl{

	@Test
	public void createAccount() throws InterruptedException {
		
		//Login into Leaf Tap Application
		//Enter User ID
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		//Enter Password
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");

		//Click on Submit
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		//Click on CRM/SFA Link
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);

		//Click on Accounts Link
		WebElement eleAc = locateElement("link", "Accounts");
		click(eleAc);

		//Click on Create Accounts Link
		WebElement eleCA = locateElement("link", "Create Account");
		click(eleCA);

		//Enter Accounts Name
		WebElement txtAc = locateElement("id", "accountName");
		String str = "testleafIndigo2356";
		type(txtAc, str);

		//Select Industry Type
		WebElement liIn = locateElement("name", "industryEnumId");
		selectDropDownUsingVisibleText(liIn, "Media");

		//Select Currency		
		WebElement liPC = locateElement("id", "currencyUomId");
		selectDropDownUsingVisibleText(liPC, "INR - Indian Rupee");

		//Select Source
		WebElement liSo = locateElement("id", "dataSourceId");
		selectDropDownUsingVisibleText(liSo, "Other");

		//Select Marketing Campaign
		WebElement liMC = locateElement("id", "marketingCampaignId");
		selectDropDownUsingVisibleText(liMC, "Automobile");

		//Enter Phone #
		WebElement elePn = locateElement("id", "primaryPhoneNumber");
		type(elePn, "1234567890");

		//#Enter City Name
		WebElement eleCi = locateElement("id", "generalCity");
		type(eleCi, "New York");

		//Enter Email Id
		WebElement eleEma = locateElement("id", "primaryEmail");
		type(eleEma, "abc@gmail.com");

		//Enter Country
		WebElement liCo = locateElement("id", "generalCountryGeoId");
		selectDropDownUsingVisibleText(liCo, "United States");

		Thread.sleep(3000);

		//Enter State
		WebElement liSt = locateElement("id", "generalStateProvinceGeoId");
		selectDropDownUsingVisibleText(liSt, "Connecticut");

		//Click Create Account Account Button
		WebElement btnAcn = locateElement("class", "smallSubmit");
		click(btnAcn);
		
		verifyPartialTitle("Create Account");
		
		if (verifyPartialTitle("Create Account") == true) {
			Thread.sleep(3000);
			WebElement eleCADup = locateElement("link", "Create Account Ignoring Duplicates");
			click(eleCADup);
			acceptAlert();
		}

		//Get the Account Name and Split the Account Id separately
		WebElement txAcName = locateElement("xpath", "//span[text()='Account Name']/following::span[1]");
		String txAcNa = getText(txAcName);
		String tcSplitID = txAcNa.split("\\(")[1].split("\\)")[0];
	/*	String id = txAcNa.replaceAll("\\D", "");
		System.out.println(id);		
		System.out.println("txAcNa");*/

		//Click on Find Accounts Page
		WebElement eleFA = locateElement("link", "Find Accounts");
		click(eleFA);

		//Type Account Id
		WebElement txtAccountID = locateElement("name", "id");
		type(txtAccountID,tcSplitID);

		//Type Account Name
		WebElement txtAccountName = locateElement("xpath", "(//input[@name='accountName'])[2]");
		type(txtAccountName,str);
		
		//Click on Accounts Name
		WebElement btnFindAcc = locateElement("xpath", "//button[text()='Find Accounts']");
		click(btnFindAcc);

		//Click on available link 
		WebElement linkLead = locateElement("xpath", "//div[text()='Account ID']/following::table//a");
		click(linkLead);
		
		//Check on the Account Name and Account Id
		WebElement txtAccountID1 = locateElement("xpath", "//span[text()='Account Name']/following::span[1]");
		verifyPartialText(txtAccountID1, tcSplitID);
		
		//Close the Browser
		closeActiveBrowser();
		
	}
}
