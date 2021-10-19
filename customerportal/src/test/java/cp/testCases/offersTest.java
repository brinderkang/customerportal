package cp.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cp.base.Baseclass;
import cp.pages.Applynow;
import cp.pages.Homepage;

public class offersTest extends Baseclass {
	
	Homepage objhmpage;
	Applynow objanpage;
	public offersTest()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialisation();
		objhmpage= new Homepage();
		objanpage =new Applynow();
		
	}
	@Test
	public void verifyPagetitle()
	{
		String flag = objhmpage.getTitle();
		Assert.assertEquals(flag, "Loans from LendingPoint | Apply Now", "TC Fail");
	}

}
