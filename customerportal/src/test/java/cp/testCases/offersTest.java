package cp.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cp.base.Baseclass;
import cp.pages.Applynow;
import cp.pages.Homepage;
import cp.pages.Offerspage;

public class offersTest extends Baseclass {
	
	Homepage objhmpage;
	Applynow objanpage;
	Offerspage objofferpage;
	SoftAssert softAssert = new SoftAssert();
	public ExtentReports extent;
	public ExtentTest extentTest;
	public offersTest()
	{
		super();
	}
//	@BeforeTest
//	public void setExtent(){
//		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
//		extent.addSystemInfo("Host Name", "Naveen Mac");
//		extent.addSystemInfo("User Name", "Naveen Automation Labs");
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
	public void setup()
	{
		//initialisation();
		objhmpage= new Homepage();
		objanpage =new Applynow();
		objofferpage = new Offerspage();	
	}
	@Test(priority=1)
	public void verifyotpbox()
		{
//		extentTest = extent.startTest("verifyotpbox");
			boolean flag = objofferpage.otpbox();
			softAssert.assertEquals(flag, true);
		}
	@Test(priority=2)
	public void verifyRightPanel() throws Throwable
	{
//		extentTest = extent.startTest("verifyRightPanel");
		boolean flag = objofferpage.getRightPanelvalues();
		softAssert.assertEquals(flag, true);
	}
	@Test(priority =3)
	public void verifySlidermovement()
	{
//		extentTest = extent.startTest("verifySlidermovement");
		boolean flag = objofferpage.offerslider();
		softAssert.assertEquals(flag, true);
	}
	@Test(priority = 4)
	public void verifyOffercontainer()
	{
//		extentTest = extent.startTest("verifyOffercontainer");
		boolean flag = objofferpage.offercontainer();
		softAssert.assertEquals(flag, true);
	}
	@Test(priority=5)
	public void verifySelectOffer()
	{
//		extentTest = extent.startTest("verifySelectOffer");
		boolean flag = objofferpage.selectOffer();
		Assert.assertEquals(flag, true);
	}

}
