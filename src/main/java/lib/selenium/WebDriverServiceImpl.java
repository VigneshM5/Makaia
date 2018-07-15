package lib.selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{

	public WebElement locateElement(String locator, String locValue) {

		try {
			switch (locator) {
			case "id": return driver.findElement(By.id(locValue));

			case "class": return driver.findElement(By.className(locValue));

			case "link" : return driver.findElement(By.linkText(locValue));

			case "xpath" : return driver.findElement(By.xpath(locValue));
			
			case "name" : return driver.findElement(By.name(locValue));

			default:
				break;
			}
		} catch (NoSuchElementException e) {
			System.err.println("Element with locator " +locator+ " and locator value of " + locValue + " has not been found");
			throw new RuntimeException("Element Not found error");
		}
		return null;
	}

	public void type(WebElement ele, String data) {
		//ele.clear();
		try {
			ele.sendKeys(data);
			reportSteps("The Data "+data+" is Entered Successfully", "pass");
		} catch (Exception e) {
			e.printStackTrace();
			reportSteps("The Data "+data+" is not Entered Successfully", "fail");
		}	
	}

	public void click(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			reportSteps("The Element " + ele+ " was clicked successfully", "pass");
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +ele+  "has not been found");
			reportSteps("The Element " + ele+ " was not clicked successfully", "fail");
		}		
	}

	public String getText(WebElement ele) {
		
		try {
			String text = ele.getText();
			reportSteps("The Element " + ele+ " has text as " +text, "pass");
			return text;			
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +ele+  "has not been found");
			reportSteps("The Element " + ele+ " did not have any text", "fail");
			throw new RuntimeException("Failed");
		}		
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			Select obj = new Select(ele);
			obj.selectByVisibleText(value);
			reportSteps("The Element " + ele+ " selected the drop down value as " +value, "pass");
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +ele+  "has not been found");
			reportSteps("The Element " + ele+ " did not selected the drop down value as " +value, "fail");
			throw new RuntimeException("Failed");
		}		
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			Select obj = new Select(ele);
			obj.selectByValue(value);
			reportSteps("The Element " + ele+ " selected the drop down value as " +value, "pass");
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +ele+  "has not been found");
			reportSteps("The Element " + ele+ " did not selected the drop down value as " +value, "fail");
			throw new RuntimeException("Failed");
		}	

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {		
		try {
			Select obj = new Select(ele);
			obj.selectByIndex(index);
			reportSteps("The Element " + ele+ " selected the drop down with index " +index, "pass");
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +ele+  "has not been found");
			reportSteps("The Element " + ele+ " did not selected the drop down with index " +index, "fail");
			throw new RuntimeException("Failed");
		}		
	}

	public void clearText(WebElement ele) {
		try {
			ele.clear();
			reportSteps("The Element " + ele+ " was cleared", "pass");
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +ele+  "has not been found");
			reportSteps("The Element " + ele+ " couldn't be found", "pass");
			throw new RuntimeException("Failed");
		}
	}

	public boolean verifyExactTitle(String expectedTitle) {
		try {
			String str = driver.getTitle();
			if (str == expectedTitle) {
				System.out.println("Expected Title is correct");
				reportSteps("The Title " + expectedTitle+ " was found to be exact", "pass");
			}else {
				System.out.println("Expected Title is not correct");
				reportSteps("The Title " + expectedTitle+ " was found to be not exact", "fail");
			}
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +expectedTitle+  "has not been found");
			reportSteps("No such Element was found", "fail");
			throw new RuntimeException("Failed");
		}

		return false;
	}

	public boolean verifyPartialTitle(String expectedTitle) {

		try {
			String str = driver.getTitle();
			if (str.contains(expectedTitle)) {
				System.out.println("Expected Title is correct");
				reportSteps("The Title " + expectedTitle+ " was found to be matching", "pass");
				return true;
			}else {
				System.out.println("Expected Title is not correct");
				reportSteps("The Title " + expectedTitle+ " was found to be not matching", "fail");
			}
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +expectedTitle+  "has not been found");
			reportSteps("No such Element was found", "fail");
			throw new RuntimeException("Failed");
		}
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if (ele.getText() == expectedText) {
				System.out.println("Expected Text is correct " +ele.getText()+ " : " +expectedText);
				reportSteps("The Text " + expectedText+ " was found to be matching", "pass");
			}else {
				System.out.println("Expected Text is not correct "+ele.getText()+ " : " +expectedText);
				reportSteps("The Text " + expectedText+ " was found to be not matching", "fail");
			}
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +expectedText+  "has not been found");
			reportSteps("No such Element was found", "fail");
			throw new RuntimeException("Failed");
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			String str = ele.getText();
			if (str.contains(expectedText)) {
				System.out.println("Expected Text " +expectedText+ " is correct");
				reportSteps("The Text " + expectedText+ " was found to be matching", "pass");
			}else {
				System.out.println("Expected Text " +expectedText+ " is not correct");
				reportSteps("The Text " + expectedText+ " was found to be not matching", "fail");
			}
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +expectedText+  "has not been found");
			reportSteps("No such Element was found", "fail");
			throw new RuntimeException("Failed");
		}
		

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if (ele.getAttribute(attribute) == value) {
				System.out.println("Expected Attribute is correct " +ele.getAttribute(attribute) + " : " +value);
				reportSteps("The Attribute " + attribute+ " was found to be matching", "pass");
			}else {
				System.out.println("Expected Attribute is not correct "+ele.getAttribute(attribute) + " : " +value);
				reportSteps("The Attribute " + attribute+ " was found to be not matching", "fail");
			}
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +ele.getAttribute(attribute)+  "has not been found");
			reportSteps("No such Element was found", "fail");
			throw new RuntimeException("Failed");
		}
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		
		try {
			String str = ele.getAttribute(attribute);				
			if (str.contains(value)) {
				System.out.println("Expected Attribute is correct " +ele.getAttribute(attribute) + " : " +value);
				reportSteps("The Attribute " + attribute+ " was found to be matching", "pass");
			}else {
				System.out.println("Expected Attribute is not correct " +ele.getAttribute(attribute) + " : " +value);
				reportSteps("The Attribute " + attribute+ " was found to be not matching", "fail");
			}
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element with name " +ele.getAttribute(attribute)+  "has not been found");
			reportSteps("No such Element was found", "fail");
			throw new RuntimeException("Failed");
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			boolean selected = ele.isSelected();
			if (selected == true) {
				System.out.println("Element " +ele+ " is selected");
				reportSteps("The Element " + ele+ " was selected succesfully", "pass");
			}else {
				System.out.println("Element " +ele+ " is not selected");
				reportSteps("The Element " + ele+ " was not selected succesfully", "fail");
			}
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element " +ele+ " is not been selected");
			reportSteps("No such Element was found", "fail");
		}

	}

	public void verifyDisplayed(WebElement ele) {
		try {
			boolean displayed = ele.isDisplayed();
			if (displayed == true) {
				System.out.println("Element " +ele+ " is selected");
				reportSteps("The Element " + ele+ " was displayed succesfully", "pass");
			}else {
				System.out.println("Element " +ele+ " is not selected");
				reportSteps("The Element " + ele+ " was not displayed succesfully", "fail");
			}
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element " +ele+ " is not been selected");
			reportSteps("No such Element was found", "fail");
		}


	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			/*for (String eachHandle: allWindows) {
				System.out.println(eachHandle);
			}*/
			List<String> listofWindows = new ArrayList<String>();
			listofWindows.addAll(allWindows);
			driver.switchTo().window(listofWindows.get(index));
			reportSteps("The Window with index " +index+ " was switched succesfully", "pass");
		} catch (NoSuchWindowException e) {
			System.err.println("Window has not been found");
			reportSteps("No such Element was found", "fail");
			throw new RuntimeException("Failed");
		}
		
	}

	public void switchToFrame(WebElement ele) {		
		driver.switchTo().frame(ele);
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText() {
		try {
			String text = driver.switchTo().alert().getText();
			reportSteps("The Text " + text + " was got succesfully", "pass");
			return text;
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element has not been found");
			reportSteps("No such Element was found", "fail");
			throw new RuntimeException("Failed");
		}
	}

	public void closeActiveBrowser() {

		try {
			driver.close();
		} catch (UnreachableBrowserException e) {
			System.err.println("Element has not been found");
			reportSteps("No Browser was found", "fail");
			throw new RuntimeException("Failed");
		}


	}

	public void closeAllBrowsers() {		
		try {
			driver.quit();
		} catch (UnreachableBrowserException e) {
			System.err.println("Element has not been found");
			reportSteps("No Browsers was found", "fail");
			throw new RuntimeException("Failed");
		}
	}
	
	public void actionClass (WebElement ele, String action) {
		Actions builder = new Actions(driver);
		switch (action) {
		case "move" : builder.moveToElement(ele).perform();
		case "click": builder.click(ele).perform();
		case "click_hold": builder.clickAndHold(ele).perform();	
		default: break;
		}
	}
	
	public void waittill(WebElement ele) {		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getTitle2() {
		return driver.getTitle();
	}
	

}
