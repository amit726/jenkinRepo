package ListenersBase;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import orgGeneric.BaseClass;

public class RerunTests extends BaseClass implements IRetryAnalyzer {

		 private int retryCount =1;
		    private int max_retryCount=3;
			public boolean retry(ITestResult result) 
			{   if(result.getStatus()==ITestResult.FAILURE && retryCount < max_retryCount)
			    {
				try
				  {  retryCount++;
				    return true;
			      }catch(Exception e)
				   {logs.info(e.getMessage());
				     
				   }
			   }
		return false;
	}
	
	

}
  
