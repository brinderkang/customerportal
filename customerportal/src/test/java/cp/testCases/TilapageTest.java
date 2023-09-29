package cp.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cp.base.Baseclass;
import cp.pages.PaymentSetupPage;
import cp.pages.Tilapage;

public class TilapageTest extends Baseclass {
	
	Tilapage objtilapage;
	
	public TilapageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		objtilapage=new Tilapage();
	}
	@Test(priority=1)
	public void verifyconsent1()
	{
		boolean flag=objtilapage.verifyConsentChkbox1();
		Assert.assertEquals(flag, true);
	}
	@Test(priority=2)
	public void verifyconsent2()
	{
		boolean flag=objtilapage.verifyConsentChkbox2();
		Assert.assertEquals(flag, true);
	}
	@Test(priority=3)
	public void verifySignContract()
	{
		boolean flag=objtilapage.verifySignContractBtn();
		Assert.assertEquals(flag, true);
	}
//	@AfterTest
//	public void teardown()
//	{
//		System.out.println("after Test");
//	}

}
