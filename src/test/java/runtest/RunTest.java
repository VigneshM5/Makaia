package runtest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features = "src/test/java/feature/", glue = {"steps", "pages"}, monochrome = true/*, tags = "@smoke"*/)
@RunWith(Cucumber.class)

public class RunTest {

}