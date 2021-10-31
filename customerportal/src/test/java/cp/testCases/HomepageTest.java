package cp.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import cp.base.Baseclass;
import cp.pages.Applynow;
import cp.pages.Homepage;

public class HomepageTest extends Baseclass {
	Homepage objhomepage;
	Applynow objapplynow;
	public HomepageTest()
	{
		super();
	}
	@BeforeSuite
	public void setUp()
	{
		initialisation();
		objhomepage=new Homepage();
		objapplynow=new Applynow();
	}
	
	@Test(priority=1)
	public void verifyPagetitle()
	{
		String flag =objhomepage.getTitle();
		Assert.assertEquals(flag, "11Loans from LendingPoint | Apply Now");
	}
	
	@Test(priority=2)
	public void verifyLogo()
	{
		boolean flag=objhomepage.validateLogo();
		Assert.assertEquals(flag, true);
	}
	@Test(priority=3)
	public void verifyLinks() throws InterruptedException
	{
		objapplynow=objhomepage.validateLinks();
		Assert.assertTrue(true);
	}
	
	

}
