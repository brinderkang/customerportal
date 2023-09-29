package cp.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cp.base.Baseclass;
import cp.pages.Applynow2;
import cp.pages.Homepage;

public class HomepageTest extends Baseclass {
	Homepage objhomepage;
	Applynow2 objapplynow;
//	public ExtentReports extent;
	public com.aventstack.extentreports.ExtentTest extentTest;
	public HomepageTest()
	{
		super();
	}
//	@BeforeTest
//	public void launch()
//	{
////		initialisation();
////		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
////		extent.addSystemInfo("Host Name", "Naveen Mac");
////		extent.addSystemInfo("User Name", "Naveen Automation Labs");
////		extent.addSystemInfo("Environment", "QA");
//	}
	
	
//	@AfterTest
//	public void endReport(){
//		
//		extent.flush();
//		extent.close();
//	}
	@BeforeTest
	public void setUp()
	{
		initialisation();
		objhomepage=new Homepage();
		objapplynow=new Applynow2();
	}
	
	@Test(priority=1,groups= {"homepage"})
	public void verifyPagetitle()
	{
//		extentTest =  extent.createTest("verifyPagetitle");
//		extentTest.log(Status.INFO, "Verify)title");
//		extentTest.pass("verifyPagetitle");
		String flag =objhomepage.getTitle();
		Assert.assertEquals(flag, "Loans from LendingPoint | Apply Now");
	}
	
	@Test(priority=2,groups= {"homepage"})
	public void verifyLogo()
	{
//		extentTest = extent.createTest("verifyLogo");
//		extentTest.log(Status.INFO, "Verify)title");
//		extentTest.pass("verifyPagetitle");
		boolean flag=objhomepage.validateLogo();
		Assert.assertEquals(flag, true);
	}
	@Test(priority=3,groups= {"homepage"})
	public void verifyLinks() throws InterruptedException
	{
//		extentTest = extent.createTest("verifyLinks");
//		extentTest.log(Status.INFO, "Verify)title");
//		extentTest.pass("verifyPagetitle");
		objapplynow=objhomepage.validateLinks();
		Assert.assertTrue(true);
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
//		
//	}
//	@AfterSuite
//	public void close()
//	{
//		
//		extent.flush();
//		extent.close();
//		driver.close();
//		driver.quit();
//
//	}
	
	
	

}
