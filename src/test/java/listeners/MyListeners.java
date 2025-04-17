package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.CommonUtils;
import Utils.ElementUtilities;

public class MyListeners implements ITestListener {
	ExtentReports reports;
	ExtentTest extentTest ;
	public WebDriver driver;
	@Override
	public void onStart(ITestContext context) {
		 reports = CommonUtils.getExtentReports();
	}
	@Override
	public void onTestStart(ITestResult result) {
		extentTest = reports.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS,result.getName()+"test got passed" );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL,result.getName()+"test got Failed" );
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String screenShotPath = new ElementUtilities(driver).captureScreenshot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(screenShotPath);
		extentTest.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP,result.getName()+"test got skipped" );
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
		File extentFile =new File(System.getProperty("user.dir")+"\\Reports\\ExtentReport.html");
		try {
			Desktop.getDesktop().browse(extentFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
