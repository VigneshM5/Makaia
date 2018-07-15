package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lib.selenium.WebDriverServiceImpl;

public class LearnHooks extends WebDriverServiceImpl {
	@Before
	public void beforeScenario(Scenario sc) {
		startReport();
		startTestCase(sc.getName(), sc.getId());
		startTestModule("Leads for LeafTaps");
		test.assignAuthor("Vignesh");
		test.assignCategory("Smoke");
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();		
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);	
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//Enter the User Id and Password
	
	}
	
	@After
	public void afterScenario(Scenario sc) {
		closeActiveBrowser();
		endResult();
	}
	
}
