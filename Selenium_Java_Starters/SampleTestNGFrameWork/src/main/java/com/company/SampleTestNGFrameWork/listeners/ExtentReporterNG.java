package com.company.SampleTestNGFrameWork.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	/**
	 * This method is used to configure HTML and generate a consolidate report
	 * It uses ExtentSparkReporter class for configuring HTML details
	 * It uses ExtentReports class to generate consolidated report using the reporter created by ExtendSparkReporter
	 * @return
	 */
	public static ExtentReports getExtentReporter() {
		// Set the html report to save
		String htmlPath = System.getProperty("user.dir")+"\\reports\\index.html";
		
		// HTML CONFIGURATION
		ExtentSparkReporter reporter = new ExtentSparkReporter(htmlPath);
		reporter.config().setDocumentTitle("TEST EXECUTION RESULTS");
		reporter.config().setReportName("TEST RESULTS");
		reporter.config().setEncoding("utf-8");
		reporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
		
		// TO CREATE CONSOLIDATE REPORTS USING REPORTER
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Executed By", "User");
		return extent;
		
	}
}
