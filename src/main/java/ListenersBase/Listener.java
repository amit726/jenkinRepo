package ListenersBase;

import org.testng.IClassListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IMethodInstance;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;





public class Listener implements ITestListener, ISuiteListener,IInvokedMethodListener,IClassListener {

	public void onAfterClass(ITestClass arg0, IMethodInstance arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onBeforeClass(ITestClass arg0, IMethodInstance arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		ExtentReportUtils.logs.info("test execution failed");
		ExtentReportUtils.extentlogs.log(Status.FAIL,"test execution failed");
		ExtentReportUtils.extent.flush();
	}

	public void onTestSkipped(ITestResult arg0) {
		ExtentReportUtils.logs.info("test execution skipped");
		ExtentReportUtils.extentlogs.log(Status.SKIP,"test execution skipped due to run mode set to no");
		ExtentReportUtils.extent.flush();
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		ExtentReportUtils.logs.info("test execution done");
		ExtentReportUtils.extentlogs.log(Status.PASS,"test executed successfully");
		ExtentReportUtils.extent.flush();
		
	}
	

}
