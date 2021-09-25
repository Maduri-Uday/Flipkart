package resources;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {

static	ExtentSparkReporter reporter;
static	com.aventstack.extentreports.ExtentReports report;
	
	public static com.aventstack.extentreports.ExtentReports reports()
	{
		String reportPath=System.getProperty("user.dir")+"//reports//index.html";
		reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("FlipKart Title Validation");
		reporter.config().setReportName("uday");
		
		report = new com.aventstack.extentreports.ExtentReports();
		report.attachReporter(reporter);
		return report;
	}
}
