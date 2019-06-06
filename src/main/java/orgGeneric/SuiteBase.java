package orgGeneric;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Framework03.Utiltest;
import ListenersBase.ExtentReportUtils;



public class SuiteBase extends BaseClass {
	private int count=0;
	private int max_count=3;
	
/*	@BeforeSuite
public void testname(ITestResult r) throws FileNotFoundException {
		
		testcaseName = r.getMethod().getMethodName();
		System.out.println(testcaseName);
	}
	@BeforeTest
	public String[][] reports (Method m, ITestResult r) throws FileNotFoundException {
		
		String[][] two = null;
		
		try {
			logs = Logger.getLogger(this.getClass().getSimpleName());
			logs.info("**********before test execution started**********");
			logs.info("log4j is working fine");
			
			ExtentReportUtils ru = new ExtentReportUtils();
			ru.createextentreport(testcaseName,r.getMethod().getMethodName());
			logs.info("extent report is working fine");
			logs.info("********before test execution finished*********");
		}
		*/
	@BeforeClass
	public void setup() throws Exception {
		logs.info("**************starting before class***********");
		
		initialiseBrwPrg();
		//here we are initializing the property files and excel files
		launchBrowser();
		//here we are launch the browser
		enterURL();
		//it will enter the Url
		logs.info("****** Before class executed********");
		}
	@BeforeMethod
	public void checkTestskip() throws Exception
	{
		logs.info("*********Running before Method********");
		System.out.println("utilsTest.isTestCaseRunnable(excel,testCaseName)");
		if(!Utiltest.isTestCaseRunnable(excel,testcaseName))
		{
			closeBrowser(driver);
			throw new SkipException("Skipped due to testcase run mode set to no");
		}
	}
    

}
