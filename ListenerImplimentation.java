package commonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener {

	ExtentReports report ;
	JavaUtil ju =new JavaUtil() ;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		//String methodName = result.getMethod().getMethodName() ;
		Reporter.log("Test Execution is Started",true) ;
		
		ExtentSparkReporter reporter =new ExtentSparkReporter("./extentreport/"+ju.getRandomNumbers()+".html") ;
		reporter.config().setDocumentTitle("vtigercrm1") ;
		reporter.config().setTheme(Theme.DARK) ;
		reporter.config().setReportName("demo") ;
		
		//ExtentReports r1 = new ExtentReports() ;
		report=new ExtentReports() ;
		report.attachReporter(reporter) ;
		report.setSystemInfo("OS", "window") ;
		report.setSystemInfo("Browser", "Chrome") ;
		report.setSystemInfo("Browser version", "122") ;
		report.setSystemInfo("Author", "Varsha") ;
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		String methodName = result.getMethod().getMethodName() ;
		//Reporter.log(methodName+"Test Execution is Passed",true) ;
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		String msg = result.getThrowable().toString() ;
		String methodName = result.getMethod().getMethodName() ;
		Reporter.log(methodName+"Test Execution is Failed"+" "+msg,true) ;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		String methodName = result.getMethod().getMethodName() ;
		Reporter.log(methodName+"Test Execution is Skipped",true) ;
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		//String methodName = result.getMethod().getMethodName() ;
		Reporter.log("To Start Execution",true) ;
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		//String methodName = result.getMethod().getMethodName() ;
		Reporter.log("To Finish Execution",true) ;
		report.flush();
	}
	

	
}
