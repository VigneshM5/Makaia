package lib.selenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import data.read.ReadExcel;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PreAndPost extends WebDriverServiceImpl{

	public String testCaseName, testDesc, nodeName, author, category, excelFileName;

	@BeforeMethod
	@Parameters({"url", "username", "password"})
	public void beforeMethod(String url, String uName, String pwd) {
		startTestModule(nodeName/*, author, category*/);
		test.assignAuthor(author);
		test.assignCategory(category);
		//System.out.println("beforeMethod");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();		
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);	
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//Enter the User Id and Password
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, uName);		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, pwd);		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
	}

	@AfterMethod(groups= {"Sanity","Smoke"})
	public void afterMethod() {
		closeActiveBrowser();
		System.out.println("afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		startTestCase(testCaseName, testDesc);
		
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");

	}

	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}

	@AfterSuite
	public void afterSuite() {
		endResult();

	}

	@DataProvider(name="TST",indices= {1})
	public String[][] getData() throws IOException {
		ReadExcel readExcel = new ReadExcel();
		String[][] value = readExcel.readExcel(excelFileName);
		return value;
	}

}