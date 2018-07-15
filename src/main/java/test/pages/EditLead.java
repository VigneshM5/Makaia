package test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class EditLead extends PreAndPost{

	public EditLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(id="updateLeadForm_firstName")
	WebElement eleFirstName;
	
	@FindBy(className="smallSubmit")
	WebElement eleUpdate;
	
	public EditLead typeFirstName(String fName) {
		clearText(eleFirstName);
		type(eleFirstName, fName);
		return this;
	}

	public ViewLead clickUpdateButton() {
		click(eleUpdate);
		return new ViewLead(driver, test);
	}				
}