package testRunners;


import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import core.CucumberReportingConfig;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "classpath:features",
		glue = "stepDefinitions",
		tags = "@login",
		dryRun = false,
		monochrome = true,
		
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
