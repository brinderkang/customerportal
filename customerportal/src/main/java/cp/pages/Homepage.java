package cp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cp.base.Baseclass;
import cp.extentreport.ExtentTestNGReportBuilder;
import cp.utilities.Util;

public class Homepage extends Baseclass {
	
//	Page Factory
	@FindBy(xpath="//img[contains(@src,'lp-stacked-logo.svg')]")
	WebElement logo;
	@FindBy(xpath="(//a[contains(@href,'/continue')])[3]")
	WebElement loginlink;
	@FindBy(xpath="(//a[text()='Apply'])[2]")
	WebElement applybutton;
	
	
	public Homepage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo() 
	{
		return logo.isDisplayed();
	}
	public Applynow2 validateLinks() throws InterruptedException
	{
		Util.waituntilElementPresent(applybutton);
		child.log(Status.PASS, "details1");
		child.info("Apply button present");
		loginlink.isDisplayed();
		child.log(Status.PASS, "loginlinkdisplay");
		child.info("login link dispslay");
		loginlink.isEnabled();
		applybutton.isDisplayed();
		applybutton.isEnabled();
		applybutton.click();
		Thread.sleep(8000);
		return new Applynow2();
		
	}

}
