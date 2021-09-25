package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listerners extends Base implements ITestListener {
	
	com.aventstack.extentreports.ExtentReports report  = ExtentReports.reports();
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
	test=report.createTest(result.getMethod().getMethodName());	

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test is passed");

	}

	public void onTestFailure(ITestResult result) {
		
		WebDriver driver = null;
		test.fail(result.getThrowable());
		String methodName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			screenshot(methodName, driver);
			test.addScreenCaptureFromPath(screenshot(methodName, driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		
		report.flush();
	}

}
