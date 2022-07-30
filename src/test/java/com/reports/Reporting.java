package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
/**
 * 
 * @author Vikki
 * @CreationDate 26/06/2022
 * @Description To create a method for generating jvm report
 *
 */
public class Reporting {
	/**
	 * 
	 * @param jsonFile
	 * @CreationDate 26/06/2022
	 * @Decsription To generate JVM Report
	 */
	public static void generateJVMReport(String jsonFile) {
		File file = new File(System.getProperty("user.dir")+"\\target");

		Configuration configuration = new Configuration(file, "OMRBranchAPIAutomation");
		configuration.addClassifications("OS", "Windows 11");
		configuration.addClassifications("Browser", "Chrome");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);

		builder.generateReports();
	}

}
