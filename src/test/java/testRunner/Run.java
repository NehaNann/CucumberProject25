package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class) //remove while creatoing junit tp tesrtng
@CucumberOptions(
	features = ".//FeatureFile/LoginFeature.feature",
	glue = "stepDefination",
	dryRun = false,
	monochrome = true,
	//plugin = {"pretty","html:target/CucumberReports/reports2.html"}	
	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	,tags="@Sanity"
	
		
		)


public class Run extends AbstractTestNGCucumberTests {
	
/**This is empty class**/

}
