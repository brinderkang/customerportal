package cp.testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import cp.base.Baseclass;
import cp.pages.IncomeInfoPage;

public class IncomeInfoTest extends Baseclass {
	
	IncomeInfoPage objincomeinfo;
	SoftAssert softAssert = new SoftAssert();
	
	public IncomeInfoTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		objincomeinfo = new IncomeInfoPage();
	}
	
	@Test(priority=1)
	public void VerifyIncomeInfoText()
	{
		boolean flag = objincomeinfo.incomeInfotexts();
		softAssert.assertEquals(flag, true);
	}
	@Test(priority=2)
	public void verifyEnterBankDetails()
	{
		boolean flag = objincomeinfo.Incomedetails();
		softAssert.assertEquals(flag, true);
	}
//	@AfterTest
//	public void teardown()
//	{
//		System.out.println("after Test");
//	}

}
