package cp.testCases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import cp.base.Baseclass;
import cp.pages.BankInfoPage;

public class BankInfoTest extends Baseclass {

	BankInfoPage objbankinfo;
	SoftAssert softAssert = new SoftAssert();
	
	public BankInfoTest(){
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
	public void verifyPlaidBankConnect()
	{
		boolean bankconnection=objbankinfo.bankConnectPlaid();
		softAssert.assertEquals(true, bankconnection);
	}
	@Test(priority=3)
	public void verifyPlaidBankLogin()
	{
		boolean banklogin=objbankinfo.plaidcredentials();
		softAssert.assertEquals(true, banklogin);
		
	}
//	@AfterTest
//	public void teardown()
//	{
//		System.out.println("after Test");
//	}
	
	
}
