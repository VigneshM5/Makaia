package test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class MyHome extends WebDriverServiceImpl {

	public MyHome(EventFiringWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Leads")
	WebElement eleLeads;
	
	public MyLeads clickLeads() {
		click(eleLeads);
		return new MyLeads(driver, test);
	}
}
