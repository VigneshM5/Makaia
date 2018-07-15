package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class EditLead_Page extends PreAndPost{

	public EditLead_Page(/*EventFiringWebDriver driver, ExtentTest test*/) {
		/*this.driver = driver;
		this.test = test;*/
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "smallSubmit")
	WebElement eleBtnEditLead;

	@FindBy(id = "updateLeadForm_companyName")
	WebElement eleCoName;


	public EditLead_Page clearTextCoName() {
		clearText(eleCoName);
		return this;
	}
	
	public EditLead_Page enterTextCoName(String cName) {
		type(eleCoName, cName);
		return this;
	}
	
	public ViewLead_Page submitEditBtn(){
		click(eleBtnEditLead);
		return new ViewLead_Page(/*driver, test*/);
	}




}
