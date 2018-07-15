package lib.selenium;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GenerateReports {

	public static void main(String[] args) throws IOException {
		
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.htm");
		html.setAppendExisting(true);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);

		ExtentTest test = extent.createTest("TC001_CreateLead","Create a new Lead");
		test.assignCategory("Smoke");
		test.assignAuthor("Vignesh");
		
		test.pass("Details were passed Successfully");
		test.fail("Details were not passed correctly");
		test.pass("Details were passed Successfully", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
		extent.flush();
	}
}