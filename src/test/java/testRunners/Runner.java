package testRunners;


import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.CucumberReportingConfig;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "classpath:features",
		glue = "stepDefinitions",
		tags = "@login",
		dryRun = false,
		monochrome = true,
		//including full path as required in my OS.
		plugin = {"pretty",
				"html:/Users/owner/git/repository/us.bullish.test/target/site/cucumber-pretty",
			    "json:/Users/owner/git/repository/us.bullish.test/target/cucumber.json"},
		publish = true
		
		
		)

public class Runner {
	
	@AfterClass
	public static void generateReport() {
		CucumberReportingConfig.reportConfig();
		
	}
	

}
