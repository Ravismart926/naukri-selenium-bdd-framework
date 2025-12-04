package com.naukri.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	private static final String REPORT_PATH="reports/extent-report.html";
	
	public static synchronized ExtentReports getInstance() {
		if(extent==null) {
			ExtentSparkReporter spark=new ExtentSparkReporter(REPORT_PATH);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Regression Suite");
			extent=new ExtentReports();
			extent.attachReporter(spark);
			
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Tester Name", "Ravi");
			
		}
		
		
		return extent;
		
		
	}

}
