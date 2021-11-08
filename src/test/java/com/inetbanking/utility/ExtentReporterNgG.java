package com.inetbanking.utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNgG {
static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		String Path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter  reporter=new ExtentSparkReporter(Path);
		reporter.config().setReportName("Banking");
		reporter.getConf().setDocumentTitle("BankingTest Result");
		reporter.getConf().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Ashish");
		
		return extent;
		
		
		
	}
}
