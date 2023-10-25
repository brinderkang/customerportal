package cp.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cp.base.Baseclass;
import cp.pages.Applynow2;




public class ApplynowTest extends Baseclass{
	
	Applynow2 objapplynow;
	public ExtentReports extent;
	public ExtentTest extentTest;
	public ApplynowTest()
	{
		super();	
		
	}
//	@BeforeTest
//	public void setExtent(){
//		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
//		extent.addSystemInfo("Host Name", "BSingh PC");
//		extent.addSystemInfo("User Name", "Bsingh");
//		extent.addSystemInfo("Environment", "QA");
//		
//	}
//	
//	@AfterTest
//	public void endReport(){
////		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
//		extent.flush();
//		extent.close();
//	}
	@BeforeMethod
	public void setUp()
	{
		objapplynow=new Applynow2();
	}
	
	@Test(priority=1,groups= {"apply"})
	public void verfiylogo()
	{
//		extentTest = extent.startTest("verfiylogo");
		boolean flag = objapplynow.validateLogo();
		Assert.assertEquals(flag, true);
	}
	@Test(priority=2,groups= {"apply"})
	public void verifyBasicinfo() throws IOException
	{
//		extentTest = extent.startTest("verifyBasicinfo");
		boolean flag=objapplynow.Basic_info();
		Assert.assertEquals(flag, true);
	}
	@Test(priority=3,groups= {"apply"})
	public void verifySubmitLoanApplication() 
	{	 
//		extentTest = extent.startTest("verifySubmitLoanApplication");
		boolean offerpage=objapplynow.checkmyoptions();
		Assert.assertEquals(true, offerpage);
	}
//	@AfterMethod
//	public void tearDown(ITestResult result) throws IOException{
//		
//		if(result.getStatus()==ITestResult.FAILURE){
//			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
//			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
//			
////			String screenshotPath = FreeCRMTest.getScreenshot(driver, result.getName());
////			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
//			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
//		}
//		else if(result.getStatus()==ITestResult.SKIP){
//			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
//		}
//		else if(result.getStatus()==ITestResult.SUCCESS){
//			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
//
//		}
//		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
//	}
	
}
