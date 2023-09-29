package cp.testCases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import cp.base.Baseclass;
import cp.pages.BankInfoPage;

public class BankInfoSkipPlaidTest extends Baseclass {

	BankInfoPage objbankinfo;
	SoftAssert softAssert = new SoftAssert();
	
	public BankInfoSkipPlaidTest(){
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		objbankinfo = new BankInfoPage();
		
	}
	
	@Test(priority=1)
	public void verifybankInfoElements()
	{
		boolean bankpage_ele=objbankinfo.bankInfoElements();
		softAssert.assertEquals(true, bankpage_ele);
	}
	@Test(priority=2)
	public void verifySkipPlaid()
	{
		boolean skipThisStep=objbankinfo.skipplaid();
		Assert.assertEquals(skipThisStep,true);
	}
//	@AfterTest
//	public void teardown()
//	{
//		System.out.println("after Test");
//	}
//	
	
	
}
