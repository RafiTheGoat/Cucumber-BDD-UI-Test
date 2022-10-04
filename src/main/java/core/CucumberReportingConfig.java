package core;

import java.io.*;
import java.util.*;


import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

public class CucumberReportingConfig {
	

	public static void reportConfig() {
		
		File reportOutputDirectory = new File("target");
			
			List<String> jsonFiles = new ArrayList<>();
			jsonFiles.add("/Users/owner/git/repository/us.tigers.capstone/target/cucumber.json");
			
			String buildNumber = "1";
			String projectName = "Capstone";
		
			
			Configuration configuration = new Configuration(reportOutputDirectory, projectName);
			configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
			configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
			configuration.setBuildNumber(buildNumber);
			configuration.addClassifications("Platform", "Mac");
			configuration.addClassifications("Browser", "chrome");
			configuration.addClassifications("Branch", "release/1.0");
			
			ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
			@SuppressWarnings("unused")
			Reportable result = reportBuilder.generateReports();
			
			
			
			
	}
}
