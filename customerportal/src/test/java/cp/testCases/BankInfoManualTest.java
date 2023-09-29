package cp.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import cp.base.Baseclass;
import cp.pages.BankInfoManualPage;

public class BankInfoManualTest extends Baseclass {

	BankInfoManualPage objbankinfo;
	SoftAssert softAssert = new SoftAssert();
	
	public BankInfoManualTest(){
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		objbankinfo = new BankInfoManualPage();	
	}
	
	@Test(priority=1)
	public void verifybankInfoText()
	{
		boolean bankpage_ele=objbankinfo.bankInfotexts();
		softAssert.assertEquals(true, bankpage_ele);
	}
	
	@Test(priority=2)
	public void verifyEnterBankDetails()
	{
		boolean bankconnection=objbankinfo.bankdetails();
		softAssert.assertEquals(true, bankconnection);
	}
//	@AfterTest
//	public void teardown()
//	{
//		System.out.println("after Test");
//	}
//	
}
