package cp.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cp.base.Baseclass;
import cp.pages.Applynow;
import junit.framework.Assert;

public class ApplynowTest extends Baseclass{
	
	Applynow objapplynow;
	
	public ApplynowTest()
	{
		super();	
		
	}
	
	@BeforeTest
	public void setUp()
	{
		objapplynow=new Applynow();
	}
	
	@Test
	public void verfiylogo()
	{
		boolean flag = objapplynow.validateLogo();
		Assert.assertEquals(flag, true);
	}
	@Test
	public void verifyBasicinfo() throws IOException
	{
		boolean flag=objapplynow.Basic_info();
		Assert.assertEquals(flag, true);
	}

}
