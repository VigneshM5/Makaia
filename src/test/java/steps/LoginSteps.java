package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.selenium.WebDriverServiceImpl;

public class LoginSteps extends WebDriverServiceImpl{
	
	
	/*public LoginSteps(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}*/
//ChromeDriver driver;

/*@Given("open the browser")
public void openBrowser() {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver = new ChromeDriver();	
}
@And("launch the URL")
public void launchURL() {
	driver.get("http://leaftaps.com/opentaps/control/login");	
}

@And("set the timeouts")
public void setTimeouts() {
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
}

@And("maximize the browser")
public void maxBrowser() {
	driver.manage().window().maximize();	
}*/

@Given("enter the username as (.*)")
public void enterUserName(String username) {
	driver.findElement(By.id("username")).sendKeys(username);	
}

@And("enter the password as (.*)")
public void enterPassword(String password) {
	driver.findElement(By.id("password")).sendKeys(password);	
}

@When("click the login button")
public void clickLogin() {
	driver.findElement(By.className("decorativeSubmit")).click();
}

@When("click the crmsfa link")
public void clickcrmsfa() {
	driver.findElement(By.linkText("CRM/SFA")).click();
}

@Then("login is successful")
public void loginSuccess() {
	System.out.println("Login Successful");
}

/*@Given("click leads")
public void clickLeads() {
	driver.findElementByLinkText("Leads").click();	
}

@And("click create lead link")
public void clickCreateLeads() {
	driver.findElementByLinkText("Create Lead").click();	
}

@And("enter the company name as (.*)")
public void enterCompanyName(String cName) {
	driver.findElementById("createLeadForm_companyName").sendKeys(cName);	
}

@And("enter the First name as (.*)")
public void enterFirstName(String fName) {
	driver.findElementById("createLeadForm_firstName").sendKeys(fName);	
}

@And("enter the Last name as (.*)")
public void enterLastName(String lName) {
	driver.findElementById("createLeadForm_lastName").sendKeys(lName);	
}

@And("enter the phone numbers as (.*)")
public void enterPhoNum(String phoNum) {
	driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys(phoNum);	
}

@And("enter the datasource as (.*)")
public void enterDataSource(String dataSource) {
	WebElement dataSo = driver.findElementById("createLeadForm_dataSourceId");
	Select obj = new Select(dataSo);
	obj.selectByVisibleText(dataSource);	
}

@When("click the create lead button")
public void clickCreateLead() {
	driver.findElementByClassName("smallSubmit").click();
}

@Then("Create Lead is successful")
public void createLeadSuccess() {
	System.out.println("Create Lead with Mandatory Fields is Successful");
}

@And("close the browser")
public void closeBrowser() {
	driver.close();
}*/



}
