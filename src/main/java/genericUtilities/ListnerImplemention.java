package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implemention to Itestlistener Interface of TestNG
 */

public class ListnerImplemention implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		
		// capture Method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("# " + methodName + " Test Script execution Started #");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		// capture Method name
				String methodName = result.getMethod().getMethodName();
				System.out.println("# " + methodName + " Test Script PASS #");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		// capture Method name
				String methodName = result.getMethod().getMethodName();
				System.out.println("# " + methodName + " Test Script FAIL #");
	
	// Capture Exception
				System.out.println(result.getThrowable());
				
				// Capture screen shot 
				JavaUtilities j = new JavaUtilities();
				SeleniumUtility s = new SeleniumUtility();
				
					String screenshotName = methodName+"_"+j.getSystemDate();
					
					try {
						s.captureScreenShot(BaseClass.sdriver, screenshotName);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					}
	
	
	
	
	

	@Override
	public void onTestSkipped(ITestResult result) {
		
		// capture Method name
				String methodName = result.getMethod().getMethodName();
				System.out.println("# " + methodName + " Test Script SKIP #");

				// capture Exception
				System.out.println(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		// Basic Configuration of Extent Reports
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReporter\\Report-"+new JavaUtilities().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Automation Execution Report");
		
		// Report Generation
		ExtentReports report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Reporter Name", "Bhagya");
	 
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("# Suite  execution start #");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("# suite  execution finish#");
	}

}
