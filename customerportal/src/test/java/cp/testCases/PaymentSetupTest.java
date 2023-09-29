package cp.testCases;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cp.base.Baseclass;
import cp.pages.PaymentSetupPage;



public class PaymentSetupTest extends Baseclass {
	
	PaymentSetupPage objpaymentsetup;
	public PaymentSetupTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		objpaymentsetup=new PaymentSetupPage();
	}
	@Test(priority=1)
	public void verifyRepaymentInfoText()
	{
		boolean flag=objpaymentsetup.paymentSetupTexts();
		Assert.assertEquals(true, flag);
	}
	@Test(priority=2)
	public void verifyRepaymentDetails() throws InterruptedException
	{
		boolean flag=objpaymentsetup.repaymentInfo();
		Assert.assertEquals(true, flag);
	}
//	@AfterTest
//	public void teardown()
//	{
//		System.out.println("after Test");
//	}

}
