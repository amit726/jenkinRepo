package ListenersBase;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import orgGeneric.BaseClass;

public class ExtentReportUtils extends BaseClass {
	public void createextentreport(String testcasename,String methodName)
	   {
		   logs.info("initialising extent report");
		   String path="D:\\Nov_java program\\AmitMaven\\ExtentReport"+testcasename+".html";
		   reporter=new ExtentHtmlReporter(path);
		   extent.attachReporter(reporter);
		   extentlogs=extent.createTest(methodName);
	   }
	   
	   public void initLOg4j()
	   {
		   Logger.getLogger(this.getClass().getSimpleName());
	
	   }
}
