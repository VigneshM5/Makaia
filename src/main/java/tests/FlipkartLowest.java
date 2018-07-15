package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class FlipkartLowest extends WebDriverServiceImpl{
	
	@Test
	public void flipkartLowest() throws InterruptedException{
		
		//Click on Escape
		driver.getKeyboard().sendKeys(Keys.ESCAPE);
		
		//Hover over TV & Appliances
		WebElement tv_app = locateElement("xpath", "//span[text()='TVs & Appliances']");
		actionClass(tv_app, "move");
		WebElement tv_sam = locateElement("xpath", "(//span[text()='Samsung'])[2]");
		click(tv_sam);
		
		WebElement pr_Min = locateElement("xpath", "(//span[text()='Price']/following::select)[1]");
		selectDropDownUsingValue(pr_Min, "25000");
		
		WebElement pr_Max = locateElement("xpath", "(//span[text()='Price']/following::select)[2]");
		selectDropDownUsingValue(pr_Max, "60000");
		
		WebElement scr_size = locateElement("xpath", "//div[text()='Screen Size']");
		click(scr_size);
		
		WebElement scr_size_tv = locateElement("xpath", "//div[text()='48 - 55']");
		click(scr_size_tv);

		WebElement tv_cost = locateElement("xpath", "(//img)[5]/preceding::div[3]");
		String tv_cost_val = getText(tv_cost);
				
		Thread.sleep(2000);
		
		WebElement tv_link = locateElement("xpath", "(//img)[5]/preceding::div[9]");
		click(tv_link);
		
		switchToWindow(1);
		
		WebElement tv_cost_1 = locateElement("xpath", "(//img)[4]/following::div[4]");
		//String tv_cost_val_1 = getText(tv_cost_1);
		
		verifyPartialText(tv_cost_1, tv_cost_val);
		
		closeActiveBrowser();
		switchToWindow(0);
		
		click(locateElement("xpath", "(//span[text()='Add to Compare'])[1]"));
		click(locateElement("xpath", "(//span[text()='Add to Compare'])[2]"));
		
		click(locateElement("xpath", "//span[text()='COMPARE']"));
		
		verifyPartialText(locateElement("xpath", "//span[text()='Compare']"), "Compare");
		
		String Cmpr1 = getText(locateElement("xpath", "(//div[@class='_1vC4OE'])[1]"));		
		String Cmpr2 = getText(locateElement("xpath", "(//div[@class='_1vC4OE'])[2]"));
		
		String pr1 = Cmpr1.replaceAll("\\D", "");
		int pr1_val = Integer.parseInt(pr1);
		
		String pr2 = Cmpr2.replaceAll("\\D", "");
		int pr2_val = Integer.parseInt(pr2);
		
		if (pr1_val > pr2_val) {
			System.out.println(getText(locateElement("xpath", "(//a[@class='_3YNWH1'])[2]"))+ " is the lowest price");
		}else {
			System.out.println(getText(locateElement("xpath", "(//a[@class='_3YNWH1'])[1]"))+ " is the lowest price");
		}
		
	}

}
